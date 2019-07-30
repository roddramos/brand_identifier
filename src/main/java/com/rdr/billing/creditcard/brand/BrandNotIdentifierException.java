package com.rdr.billing.creditcard.brand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrandNotIdentifierException extends RuntimeException {
  private static final long serialVersionUID = -8907688009088912856L;

  private static final Logger LOGGER = LoggerFactory.getLogger(BrandNotIdentifierException.class);

  private String message;

  public BrandNotIdentifierException(String message) {
    LOGGER.error(message);
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

}
