package com.rdr.billing.creditcard.brand;

import javax.ws.rs.WebApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrandNotIdentifierException extends WebApplicationException {
  private static final long serialVersionUID = -8907688009088912856L;

  private static final Logger LOGGER = LoggerFactory.getLogger(BrandNotIdentifierException.class);

  public BrandNotIdentifierException(String message) {
    super(message, 400);
    LOGGER.error(message);
  }
}
