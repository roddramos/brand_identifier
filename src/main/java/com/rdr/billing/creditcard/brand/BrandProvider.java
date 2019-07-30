package com.rdr.billing.creditcard.brand;

import java.util.regex.Pattern;
import com.rdr.billing.creditcard.entityrest.Brand;

public class BrandProvider {
  private Brand brand;
  private Pattern provider;

  public BrandProvider(Brand brand, Pattern pattern) {
    super();
    this.brand = brand;
    this.provider = pattern;
  }

  public Brand getBrand() {
    return brand;
  }

  public Pattern getProvider() {
    return provider;
  }


}
