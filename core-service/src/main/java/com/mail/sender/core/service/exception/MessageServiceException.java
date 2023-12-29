package com.mail.sender.core.service.exception;

public class MessageServiceException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private int status;

  private CommonErrorDetail commonErrorDetail;

  public MessageServiceException(String message) {
    super(message);
  }

  public MessageServiceException(CommonErrorDetail commonErrorDetail) {
    this.commonErrorDetail = commonErrorDetail;
  }

  public MessageServiceException(String message, Throwable cause) {
    super(message, cause);
  }

  public MessageServiceException(String message, int status) {
    super(message);
    this.status = status;
  }

  public MessageServiceException(String s, Throwable cause, int status) {
    super(s, cause);
    this.status = status;
  }

  public MessageServiceException(CommonErrorDetail commonErrorDetail, Object... arguments) {
    super(commonErrorDetail.getDetail());
    this.commonErrorDetail = commonErrorDetail;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public CommonErrorDetail getCommonErrorDetail() {
    return commonErrorDetail;
  }

  public void setCommonErrorDetail(CommonErrorDetail commonErrorDetail) {
    this.commonErrorDetail = commonErrorDetail;
  }
}
