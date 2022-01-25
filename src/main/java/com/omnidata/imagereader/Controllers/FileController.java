package com.omnidata.imagereader.Controllers;

import com.omnidata.imagereader.Model.BankAccount;
import com.omnidata.imagereader.Services.FileService;
import com.omnidata.imagereader.Services.FileServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/files")
public class FileController {

private final FileServiceI fileService;
    @Autowired
    public FileController(FileServiceI fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/read")
    public CompletableFuture<String> readFileText(@RequestParam MultipartFile file,
                                                       @RequestParam(defaultValue = "eng") String lang,
                                                       @RequestParam(defaultValue = "0") int x,
                                                       @RequestParam(defaultValue = "0") int y,
                                                       @RequestParam(defaultValue = "0") int width,
                                                       @RequestParam(defaultValue = "0") int height) {

     return fileService.readText(file,lang,x,y,width,height);

    }
}
