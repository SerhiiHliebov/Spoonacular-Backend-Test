import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.core.Is.is;

public class ComplexSearchTest extends Base{



    @Test
    void test1() {

        RestAssured.given()
                .queryParam("includeIngredients", "chiken")
                .queryParam("minProtein", "15")
                .queryParam("maxProtein", "25")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .body("results[1].nutrition.nutrients[0].unit", is("g"))
                .when()
                .get("recipes/complexSearch")
                .body()
                .asPrettyString();

    }

    @Test
    void test2() {

        RestAssured.given()
                .queryParam("includeIngredients", "cheese")
                .queryParam("maxVitaminA", "50")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .body("results[0].nutrition.nutrients[0].name", is("Vitamin A"))
                .when()
                .get("recipes/complexSearch")
                .body()
                .asPrettyString();

    }

    @Test
    void test3() {

        RestAssured.given()
                .queryParam("cuisine", "French")
                .queryParam("addRecipeInformation", "true")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .body("results[0].vegetarian", is(true))
                .when()
                .get("recipes/complexSearch")
                .body()
                .asPrettyString();

    }

    @Test
    void test4() {

        RestAssured.given()
                .queryParam("query", "pizza")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .body("number", is(10))
                .body("totalResults", is(37))
                .when()
                .get("recipes/complexSearch")
                .body()
                .asPrettyString();

    }

    @Test
    void test5() {

        RestAssured.given()
                .queryParam("cuisine", "italian")
                .queryParam("titleMatch", "Broccolini Quinoa Pilaf")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .body("results[0].title", is("Broccolini Quinoa Pilaf"))
                .when()
                .get("recipes/complexSearch")
                .body()
                .asPrettyString();

    }
}
