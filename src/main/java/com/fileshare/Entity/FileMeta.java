package com.fileshare.Entity;


import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("File_Data")
public class FileMeta {

    @Id
    private String id; // MongoDB uses String for IDs by default

    private String filename;
    private String filetype;
    private String filepath;
    private long size;
    private LocalDateTime uploadedAt;
}
