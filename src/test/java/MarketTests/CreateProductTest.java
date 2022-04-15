package MarketTests;

import MyBatis.db.dao.CategoriesMapper;
import MyBatis.db.dao.ProductsMapper;
import MyBatis.db.model.Products;
import api.MiniMarketService;
import api.MyBatisDbService;
import api.RetrofitUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import market.ProductDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class CreateProductTest {

    static MiniMarketService miniMarketService;
    static ProductsMapper productsMapper;
    static CategoriesMapper categoriesMapper;
    ProductDto product;
    Long id;

    @BeforeAll
    static void beforeAll() {

        miniMarketService = RetrofitUtils.getRetrofit().create(MiniMarketService.class);
        categoriesMapper = MyBatisDbService.getCategoriesMapper();
        productsMapper = MyBatisDbService.getProductsMapper();
    }
    @BeforeEach
    void setUpPostProduct() {
        product = ProductDto.builder()
                .title("Apple Juice")
                .categoryTitle("Food")
                .price(20)
                .build();

    }


    @SneakyThrows
    @Test
    void createNewProduct() {

            Response<ProductDto> response = miniMarketService.createProduct(product).execute();
        id = response.body().getId();
        assertThat(response.isSuccessful()).isTrue();
        assertThat(productsMapper.selectByPrimaryKey(Long.valueOf(id)).getTitle()).isEqualTo(product.getTitle());

    }

    @SneakyThrows
    @Test
    void createNewProductPrice() {
        int price = 77777;
        product.setPrice(price);

        Response<ProductDto> response =
                miniMarketService.createProduct(product)
                        .execute();
        id = response.body().getId();
        assertThat(response.isSuccessful()).isTrue();
        ProductsMapper productsMapper = MyBatisDbService.getProductsMapper();
        Products productDb = productsMapper.selectByPrimaryKey(Long.valueOf(id));
        assertThat(productDb.getPrice().equals(price));

    }

    @SneakyThrows
    @Test
    void createNewProductTitleString() {
        String title = "milk";
        product.setTitle(title);

        Response<ProductDto> response =
                miniMarketService.createProduct(product)
                        .execute();
        id = response.body().getId();
        assertThat(response.isSuccessful()).isTrue();
        ProductsMapper productsMapper = MyBatisDbService.getProductsMapper();
        Products productDb = productsMapper.selectByPrimaryKey(Long.valueOf(id));
        assertThat(productDb.getTitle().equals(title));

    }

    @AfterEach
    void tearDown () {
        MyBatisDbService.getCategoriesMapper().deleteByPrimaryKey(id);
    }
}
