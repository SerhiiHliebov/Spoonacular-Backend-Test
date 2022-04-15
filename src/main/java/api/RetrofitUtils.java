package api;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@UtilityClass
@Slf4j
public class RetrofitUtils {

    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    public Retrofit getRetrofit() {

        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(logging);
        return new Retrofit.Builder()
                .baseUrl("https://minimarket1.herokuapp.com/market/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }
}
