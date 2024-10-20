package org.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        //making a API call via OKhttp

//        String url = "https://fakestoreapi.com/products/1";
//
//        OkHttpClient client = new OkHttpClient();
//
//        Request request = new Request.Builder().url(url).build();
//
//        try(Response response = client.newCall(request).execute()){
//            if(!response.isSuccessful()){
//                System.out.println("Something went wrong while downloading data");
//            }
//            System.out.println(response.body().string());
//
//        }catch(Exception e){
//            e.printStackTrace();
//        }

        Retrofit retrofit = new Retrofit.Builder().
                baseUrl("https://fakestoreapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        ProductService productService = retrofit.create(ProductService.class);

        Product p = productService.getProductById("1").execute().body();
        System.out.println("Downloaded Product Object is "+ p.toString());
    }
}