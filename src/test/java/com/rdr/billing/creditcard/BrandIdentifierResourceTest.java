package com.rdr.billing.creditcard;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import javax.ws.rs.core.MediaType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rdr.billing.creditcard.entityrest.Brand;
import com.rdr.billing.creditcard.entityrest.CreditCard;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class BrandIdentifierResourceTest {

  @Test
  public void testBrandIdentifierEndpoint() throws JsonProcessingException {
    CreditCard creditCard = new CreditCard();
    creditCard.setNumberCreditCard("4916937852507746");
    Brand brandConf = new Brand("visa");
    ObjectMapper mapper = new ObjectMapper();
    String writeValueAsString = mapper.writeValueAsString(brandConf);
    given().contentType(MediaType.APPLICATION_JSON).body(creditCard).post("/creditcard/brand")
        .then().statusCode(HttpStatus.SC_OK).body(equalTo(writeValueAsString));

  }

}
