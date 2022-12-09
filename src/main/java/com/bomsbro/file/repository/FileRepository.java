package com.bomsbro.file.repository;


import com.bomsbro.file.model.entity.File;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
    Page<File> findAll(Pageable pageable);

    Page<File> findFilesByFileCategoryId(Long fileCategoryId, Pageable pageable);

    Optional<File> findById(long fileId);

    File save(File file);

    void delete(File file);
}
