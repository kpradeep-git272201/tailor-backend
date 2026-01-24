package com.tailorapp.storage.service;

import com.tailorapp.common.enums.UploadModule;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

    String uploadImage(
            MultipartFile file,
            UploadModule module,
            Long referenceId
    );
}

