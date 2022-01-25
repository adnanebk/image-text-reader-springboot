package com.omnidata.imagereader.Services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.CompletableFuture;

public interface FileServiceI {

    CompletableFuture<String> readText(MultipartFile mFile, String lang, int x, int y, int width, int height);
}
