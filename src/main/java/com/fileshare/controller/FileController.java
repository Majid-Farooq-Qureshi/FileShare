package com.fileshare.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import com.fileshare.service.FileService;

@Controller
public class FileController {

    @Autowired
    private FileService service;
    
     public String uploadFile(MultipartFile file ) throws IOException {
        return service.uploadFile(file);
    }

    public byte[] downloadFile(String filename) throws IOException {
        return service.downloadFile(filename);
    }
}
