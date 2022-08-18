package com.bomsbro.common.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.security.Key;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Slf4j
@Component
public class TokenProvider {



    private static final String AUTHORITIES_KEY = "auth";
    private static final String BEARER_TYPE = "bearer";
    private static final String DEFAULT_ROLE_PREFIX = "ROLE_";
    private static final String TOKEN_ACCOUNT_ID = "accountId";
    private static final String TOKEN_USER_MAP = "userMap";
    private static final String HEADER_USER_ID = "WAPL-User-Id";
    private static final String HEADER_ACCOUNT_ID = "WAPL-Account-Id";

    private final Key key;

    public TokenProvider(@Value("${jwt.secret}") String secretKey) throws CertificateException {
        System.out.println("secretKey = " + secretKey);
        System.out.println("System.getenv(\"SECRET_KEY\") = " + System.getenv("SECRET_KEY"));
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        CertificateFactory cf = CertificateFactory.getInstance("X509");
        X509Certificate certificate = (X509Certificate) cf.generateCertificate(new ByteArrayInputStream(keyBytes));
        this.key = certificate.getPublicKey();
    }

    public Authentication getAuthentication(String accessToken, HttpServletRequest request) {
        // 토큰 복호화
        Claims claims = parseClaims(accessToken);

        // 호출 캐릭터 uuid
        String uuid = request.getHeader(HEADER_USER_ID);

        // get WAPL data from JWT
        Long accountId = claims.get(TOKEN_ACCOUNT_ID, Long.class);
        Map<String, Object> userMap = claims.get(TOKEN_USER_MAP, Map.class);

        CustomPrincipal principal = new CustomPrincipal();
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        // 호출 캐릭터 정보가 유효하다면 custom principal 및 authorities 세팅
        if(StringUtils.hasText(uuid) && userMap != null && userMap.get(uuid) != null){

            ObjectMapper mapper = new ObjectMapper();
            MapperObject user = mapper.convertValue(userMap.get(uuid), MapperObject.class);

            principal.setAccountId(accountId);
            principal.setUserId(uuid);
            principal.setGroupId(user.getGroupId());

            authorities.add(new SimpleGrantedAuthority(DEFAULT_ROLE_PREFIX + user.getRole()));
        }
        // 유효하지 않다면 계정 정보만 세팅
        else {
            principal.setAccountId(accountId);
        }
        // 인증된 Authentication 객체 생성하여 리턴
        return new UsernamePasswordAuthenticationToken(principal, null, authorities);
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            log.info("잘못된 JWT 서명입니다.");
        } catch (ExpiredJwtException e) {
            log.info("만료된 JWT 토큰입니다.");
        } catch (UnsupportedJwtException e) {
            log.info("지원되지 않는 JWT 토큰입니다.");
        } catch (IllegalArgumentException e) {
            log.info("JWT 토큰이 잘못되었습니다.");
        }
        return false;
    }

    private Claims parseClaims(String accessToken) {
        try {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(accessToken).getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }

    @Getter
    static class MapperObject implements Serializable {
        private Long groupId;
        private String role;

    }
}
