package com.omnidata.imagereader.Services;

import com.lowagie.text.pdf.PdfDocument;
import com.omnidata.imagereader.Model.BankAccount;
import net.sourceforge.tess4j.Tesseract;
import org.apache.commons.io.FilenameUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;


@Service
public class FileService implements FileServiceI {

  private final Tesseract tesseract;

  @Value("${tesseract.path}")
  private  String tesseractPath;

    public FileService(Tesseract tesseract) {
        this.tesseract = tesseract;
    }

    @Override
    @Async
    public CompletableFuture<String> readText(MultipartFile mFile, String lang, int x, int y, int width, int height) {

        String content="";
        try {
           File file = multipartFileToFile(mFile);

            tesseract.setLanguage(lang);
            tesseract.setDatapath(tesseractPath);

            try {
                // limit the set of characters that tesseract is looking for (e.g. search only for letters a-z)
                tesseract.setTessVariable("tessedit_char_whitelist", "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ");

               Rectangle rectangle =  new Rectangle(x, y, width, height);

                content = tesseract.doOCR(file,rectangle);
                System.out.println("content  "+ content);

                              removeFile(file);
                return CompletableFuture.completedFuture(content);
                 }
         catch (Exception | Error e) {
             throw new RuntimeException("could not read the file with these parameters");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        throw new RuntimeException("Error while converting the file");
        }
    }
    private void removeFile(File file) {
        //delete the temporary file
        File f = new File(file.toURI());
        f.delete();
    }

    private File multipartFileToFile(MultipartFile multipartFile) throws IOException {
        String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
        File file =  File.createTempFile(Objects.requireNonNull(multipartFile.getOriginalFilename()), "."+extension);
        multipartFile.transferTo(file);
        return file;
    }

}
