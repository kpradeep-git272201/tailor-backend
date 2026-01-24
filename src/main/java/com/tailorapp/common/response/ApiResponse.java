package com.tailorapp.common.response;

import java.time.LocalDateTime;
import java.util.Map;

public class ApiResponse<T> {

    private boolean success;
    private String message;
    private T data;
    private ApiError error;
    private Meta meta;

    private ApiResponse(boolean success, String message, T data, ApiError error, Integer count) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.error = error;
        this.meta = new Meta(count);
    }

    /* ========= SUCCESS ========= */

    public static <T> ApiResponse<T> success(String message, T data, Integer count) {
        return new ApiResponse<>(true, message, data, null, count);
    }

    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(true, message, data, null, null);
    }

    public static <T> ApiResponse<T> success(String message) {
        return new ApiResponse<>(true, message, null, null, null);
    }

    /* ========= ERROR ========= */

    public static <T> ApiResponse<T> error(String message, String code) {
        return new ApiResponse<>(false, message, null, new ApiError(code, message), null);
    }

    /* ========= GETTERS ========= */

    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
    public T getData() { return data; }
    public ApiError getError() { return error; }
    public Meta getMeta() { return meta; }

    /* ========= INNER ========= */

    public static class ApiError {
        private String code;
        private String message;
        private String detail;

        public ApiError(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public ApiError(String code, String message, String detail) {
            this.code = code;
            this.message = message;
            this.detail = detail;
        }

        public String getCode() { return code; }
        public String getMessage() { return message; }
        public String getDetail() { return detail; }
    }

    public static class Meta {
        private LocalDateTime timestamp = LocalDateTime.now();
        private Integer count;

        public Meta(Integer count) {
            this.count = count;
        }

        public LocalDateTime getTimestamp() { return timestamp; }
        public Integer getCount() { return count; }
    }
}
