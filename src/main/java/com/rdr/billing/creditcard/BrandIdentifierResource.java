package com.rdr.billing.creditcard;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.rdr.billing.creditcard.brand.BrandCreditCard;
import com.rdr.billing.creditcard.entityrest.Brand;
import com.rdr.billing.creditcard.entityrest.CreditCard;

@Path("/creditcard/brand")
public class BrandIdentifierResource {

  @Inject
  private BrandCreditCard brandCreditCard;

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Brand identifierBrand(CreditCard creditCard) {
    Brand brand = brandCreditCard.detect(creditCard.getNumberCreditCard());
    return brand;
  }
}
