package com.ucv.electrix.utils.interfaces;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageCreator {
    String createPicture(MultipartFile multipartFile) throws IOException;
}
