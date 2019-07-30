package com.rdr.billing.creditcard.brand;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import javax.enterprise.context.ApplicationScoped;
import com.rdr.billing.creditcard.entityrest.Brand;

@ApplicationScoped
public class BrandCreditCard {

  private List<BrandProvider> rolesForBrands;

  public BrandCreditCard() {
    this.rolesForBrands = new ArrayList<>();
    rolesForBrands.add(
        new BrandProvider(new Brand("visa"), Pattern.compile("^4[0-9]{12}(?:[0-9]{3}){0,2}$")));
    rolesForBrands.add(new BrandProvider(new Brand("mastercard"),
        Pattern.compile("^(?:5[1-5]|2(?!2([01]|20)|7(2[1-9]|3))[2-7])\\d{14}$")));
    rolesForBrands.add(new BrandProvider(new Brand("elo"), Pattern.compile(
        "^(4011(78|79)|43(1274|8935)|45(1416|7393|763(1|2))|50(4175|6699|67[0-7][0-9]|9000)|50(9[0-9][0-9][0-9])|627780|63(6297|6368)|650(03([^4])|04([0-9])|05(0|1)|05([7-9])|06([0-9])|07([0-9])|08([0-9])|4([0-3][0-9]|8[5-9]|9[0-9])|5([0-9][0-9]|3[0-8])|9([0-6][0-9]|7[0-8])|7([0-2][0-9])|541|700|720|727|901)|65165([2-9])|6516([6-7][0-9])|65500([0-9])|6550([0-5][0-9])|655021|65505([6-7])|6516([8-9][0-9])|65170([0-4]))")));
    rolesForBrands.add(new BrandProvider(new Brand("amex"), Pattern.compile("^3[47][0-9]{13}$")));
    rolesForBrands.add(new BrandProvider(new Brand("discover"),
        Pattern.compile("^6(?:011|[45][0-9]{2})[0-9]{12}$")));
    rolesForBrands.add(
        new BrandProvider(new Brand("jcb"), Pattern.compile("^(?:2131|1800|35\\d{3})\\d{11}$")));
    rolesForBrands
        .add(new BrandProvider(new Brand("chinaunionpay"), Pattern.compile("^62[0-9]{14,17}$")));

  }


  public Brand detect(String cardNumber) {

    Optional<Brand> brand = rolesForBrands.stream()
        .filter(brandProvider -> brandProvider.getProvider().matcher(cardNumber).matches())
        .map(brandProvider -> brandProvider.getBrand()).findFirst();
    brand.orElseThrow(() -> new BrandNotIdentifierException("Bandeira não identificada"));

    return brand.get();

  }

}
