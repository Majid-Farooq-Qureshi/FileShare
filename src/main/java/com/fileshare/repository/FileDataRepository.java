package com.fileshare.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fileshare.Entity.FileMeta;

@Repository
public interface FileDataRepository extends MongoRepository<FileMeta,String> {
        Optional<FileMeta> findByFilename(String filename);
    // Custom query methods can be defined here if needed
    // For example, findByFileName(String fileName);
    // This will allow you to retrieve FileData objects based on the file name.
    
}
