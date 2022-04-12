package MarketTests;

import api.MiniMarketService;
import api.RetrofitUtils;
import market.ProductDto;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.*;
import retrofit2.Response;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;

public class PutProductTest {

    static MiniMarketService miniMarketService;
    ProductDto updateProduct;

    @BeforeAll
    static void setUp() {
        miniMarketService = RetrofitUtils.getRetrofit().create(MiniMarketService.class);
    }

    @BeforeEach
    void setUpPutProduct() {
        updateProduct = ProductDto.builder()
                .id((long) 3)
                .title("Bread")
                .price(35)
                .categoryTitle("Food")
                .build();
    }

    @Test
    @DisplayName("Update Product")
    void PutProduct() throws IOException {
        Response<ProductDto> responsePostProduct = miniMarketService.updateProduct(updateProduct).execute();
        assertThat(responsePostProduct.isSuccessful(), CoreMatchers.is(true));
    }

    @AfterEach
    void tearDown() throws IOException {
        ProductDto returnProduct = ProductDto.builder()
                .id((long) 3)
                .title("Bread")
                .price(25)
                .categoryTitle("Food")
                .build();
        Response<ProductDto> responseUpdateProduct = miniMarketService.updateProduct(returnProduct).execute();
        assertThat(responseUpdateProduct.isSuccessful(),CoreMatchers.is(true));
    }
}
