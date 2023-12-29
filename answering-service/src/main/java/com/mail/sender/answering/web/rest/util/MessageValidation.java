package com.mail.sender.answering.web.rest.util;

import org.apache.commons.lang3.StringUtils;

public class MessageValidation {

  public static boolean checkUniqMessage(String uniqMessage) {
    return !StringUtils.isEmpty(uniqMessage);
  }
}