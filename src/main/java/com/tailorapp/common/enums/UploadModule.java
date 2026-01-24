package com.tailorapp.common.enums;

public enum UploadModule {

    ARTICLE("catalog/articles"),
    FABRIC("catalog/fabrics"),
    BANNER("catalog/banners"),
    TAILOR("catalog/tailors");

    private final String folder;

    UploadModule(String folder) {
        this.folder = folder;
    }

    public String getFolder() {
        return folder;
    }
}

