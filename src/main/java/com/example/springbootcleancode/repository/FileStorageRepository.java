package com.example.springbootcleancode.repository;

import com.example.springbootcleancode.domain.FileStorage;
import com.example.springbootcleancode.domain.FileStorageStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.List;

@Repository
public interface FileStorageRepository extends JpaRepository<FileStorage, Long> {

    FileStorage findByHashId(String hashId);

    List<FileStorage> findAllByFileStorageStatus(FileStorageStatus status);
}
