package com.ecommerce.api.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utils {
    public static byte[] convertImgToByteArray(String imgPath) throws IOException{
        Path path = Paths.get(imgPath);
        return Files.readAllBytes(path);
    }
}
