package com.rdr.billing.creditcard.brand;

import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import com.rdr.billing.creditcard.entityrest.Brand;

@ApplicationScoped
public class BrandCreditCard {

  @Inject
  private GeneratedRolesBrand generatedRolesBrand;

  public Brand detect(String cardNumber) {
    Optional<Brand> brand = generatedRolesBrand.getRolesForBrands().stream()
        .filter(brandProvider -> brandProvider.getProvider().matcher(cardNumber).matches())
        .map(brandProvider -> brandProvider.getBrand()).findFirst();
    brand.orElseThrow(() -> new BrandNotIdentifierException("Bandeira não identificada"));

    return brand.get();

  }

}
