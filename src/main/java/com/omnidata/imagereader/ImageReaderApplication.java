package com.omnidata.imagereader;

import net.sourceforge.tess4j.Tesseract;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ImageReaderApplication {

    @Bean
    Tesseract tesseract(){
        return new Tesseract();
    }

    public static void main(String[] args) {
        SpringApplication.run(ImageReaderApplication.class, args);
    }

}
