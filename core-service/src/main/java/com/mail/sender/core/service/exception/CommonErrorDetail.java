package com.mail.sender.core.service.exception;


import java.io.Serializable;

public class CommonErrorDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    private int status;

    private String title;

    private String detail;

    private CommonErrorDetail cause;

    private long timestamp;

    private String exception;

    private String method;

    private String requestedPath;

    public int getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public String getDetail() {
        return detail;
    }

    public CommonErrorDetail getCause() {
        return cause;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getException() {
        return exception;
    }

    public String getMethod() {
        return method;
    }

    public String getRequestedPath() {
        return requestedPath;
    }

    public static Builder newBuilder() {
        return new CommonErrorDetail().new Builder();
    }


    public class Builder {
        private Builder() {
            // private constructor
        }

        public Builder setStatus(int status) {
            CommonErrorDetail.this.status = status;
            return this;
        }

        public Builder setTitle(String title) {
            CommonErrorDetail.this.title = title;
            return this;
        }

        public Builder setDetail(String detail) {
            CommonErrorDetail.this.detail = detail;
            return this;
        }

        public Builder setCause(CommonErrorDetail cause) {
            CommonErrorDetail.this.cause = cause;
            return this;
        }

        public Builder setTimestamp(long timestamp) {
            CommonErrorDetail.this.timestamp = timestamp;
            return this;
        }

        public Builder setException(String exception) {
            CommonErrorDetail.this.exception = exception;
            return this;
        }

        public Builder setMethod(String method) {
            CommonErrorDetail.this.method = method;
            return this;
        }

        public Builder setRequestedPath(String requestedPath) {
            CommonErrorDetail.this.requestedPath = requestedPath;
            return this;
        }

        public CommonErrorDetail build() {
            return CommonErrorDetail.this;
        }
    }
}