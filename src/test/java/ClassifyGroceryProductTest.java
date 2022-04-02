import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.core.Is.is;

public class ClassifyGroceryProductTest extends Base{



    @Test
    void test1() {

        RestAssured.given()
                .queryParam("post body")
                .body("{ \"title\": \"Nuts\", \"upc\": \"\", \"plu_code\": \"\" }")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .body("usdaCode", is(12135))
                .when()
                .post("food/products/classify")
                .body()
                .asPrettyString();

    }

    @Test
    void test2() {

        RestAssured.given()
                .queryParam("post body")
                .body("{ \"title\": \"cocoa butter\", \"upc\": \"\", \"plu_code\": \"\" }")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .body("usdaCode", is(1001))
                .when()
                .post("food/products/classify")
                .body()
                .asPrettyString();

    }

    @Test
    void test3() {

        RestAssured.given()
                .queryParam("post body")
                .body("{ \"title\": \"pineapples\", \"upc\": \"\", \"plu_code\": \"\" }")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .body("breadcrumbs[0]", is("tropical fruit"))
                .when()
                .post("food/products/classify")
                .body()
                .asPrettyString();

    }

    @Test
    void test4() {

        RestAssured.given()
                .queryParam("post body")
                .body("{ \"title\": \"chili sauce\", \"upc\": \"\", \"plu_code\": \"\" }")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .body("category", Matchers.notNullValue())
                .when()
                .post("food/products/classify")
                .body()
                .asPrettyString();

    }

    @Test
    void test5() {

        RestAssured.given()
                .queryParam("post body")
                .body("{ \"title\": \"olive oil\", \"upc\": \"\", \"plu_code\": \"\" }")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .body("category", Matchers.notNullValue())
                .body("breadcrumbs[0]", is("cooking oil"))
                .when()
                .post("food/products/classify")
                .body()
                .asPrettyString();

    }
}
