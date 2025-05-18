package com.fileshare.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.io.File;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;

import com.fileshare.Entity.FileMeta;
import com.fileshare.repository.FileDataRepository;

@Service
public class FileService {
    
    @Autowired
    private FileDataRepository repository;
    private final String FOLDER_PATH = "C:\\Users\\Majid\\Desktop\\MyFiles\\";

    public String uploadFile(MultipartFile file ) throws IOException {
        String filePath = FOLDER_PATH + file.getOriginalFilename();

        FileMeta fileMeta = repository.insert(FileMeta.builder()
            .filename(file.getOriginalFilename())
            .filetype(file.getContentType())
            .filepath(filePath)
            .size(file.getSize())
            .uploadedAt(LocalDateTime.now())
            .build());
        
            file.transferTo(new File(filePath));
            // If you want to use Path, use Path.of(filePath)
            // file.transferTo(Path.of(filePath));

        if (fileMeta != null) {
            return "File uploaded successfully: " + filePath;
        } else {
            return "File upload failed";
        }
    }

public byte[] downloadFile(String filename) throws IOException {
    FileMeta fileData = repository.findByFilename(filename).orElse(null);
    String filePath = fileData.getFilepath();
    byte [] image = Files.readAllBytes(new File(filePath).toPath());
    return image; 
}

}
