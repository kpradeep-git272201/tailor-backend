package com.tailorapp.common.util;

import java.util.UUID;

public class FileNameUtil {
    public static String generateFileName(String original) {
        String ext = original.substring(original.lastIndexOf("."));
        return UUID.randomUUID() + ext;
    }
}
