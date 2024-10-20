package org.example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProductService {

    @GET("products/{id}")
    Call<Product> getProductById(@Path("id") String id);
}
