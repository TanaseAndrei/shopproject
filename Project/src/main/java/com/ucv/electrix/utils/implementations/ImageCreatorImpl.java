package com.ucv.electrix.utils.implementations;

import com.ucv.electrix.utils.interfaces.ImageCreator;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImageCreatorImpl implements ImageCreator {
    @Override
    public String createPicture(MultipartFile multipartFile) throws IOException {
        String folder = "src/main/resources/static/images/uploaded/products/";
        try {
            byte[] pictureBytes = multipartFile.getBytes();
            Path path = Paths.get(folder + multipartFile.getOriginalFilename());
            Files.write(path, pictureBytes);
        } catch (IOException ioException){
            throw ioException;
        }
        return multipartFile.getOriginalFilename();
    }
}
