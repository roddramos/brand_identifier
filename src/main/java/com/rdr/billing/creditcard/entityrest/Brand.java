package com.rdr.billing.creditcard.entityrest;

public class Brand {
  private String bandeira;

  public Brand(String bandeira) {
    this.bandeira = bandeira;
  }

  public String getBandeira() {
    return bandeira;
  }

  public void setBandeira(String bandeira) {
    this.bandeira = bandeira;
  }

}
