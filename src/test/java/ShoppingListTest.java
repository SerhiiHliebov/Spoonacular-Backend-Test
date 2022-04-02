import Spoonacular.PostShoppingListModel.Item;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ShoppingListTest extends Base{

    @Test
    void testPostShoppingList() {

        Item actually = RestAssured.given()
                .queryParam("username", "test4")
                .queryParam("hash", "896c2bf52059f3b6bcc9c937bb47e7f1c4fa30f2")
                .body("{\n" +
                        "\t\"item\": \"1 package flour powder\",\n" +
                        "\t\"aisle\": \"flour\",\n" +
                        "\t\"parse\": true\n" +
                        "}")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .when()
                .post("mealplanner/test4/shopping-list/items")
                .body()
                .as(Item.class);

        System.out.println(actually);

        Assertions.assertEquals(actually.getName(), "flour powder");
        Assertions.assertNotNull(actually.getId());
    }

    @Test
    void testGetPostShoppingList() {

        Item actually = RestAssured.given()
                .queryParam("username", "test4")
                .queryParam("hash", "896c2bf52059f3b6bcc9c937bb47e7f1c4fa30f2")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .when()
                .get("mealplanner/test4/shopping-list")
                .body()
                .as(Item.class);

        System.out.println(actually);

            Assertions.assertNotNull(actually.getStartDate());
            Assertions.assertNull(actually.getPantryItem());

        }

}

