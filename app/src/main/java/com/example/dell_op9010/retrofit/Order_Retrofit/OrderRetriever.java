package com.example.dell_op9010.retrofit.Order_Retrofit;

/**
 * Created by Dell-OP9010 on 12/12/2017.
 */

import retrofit2.Call;
import retrofit2.http.GET;

public interface OrderRetriever {
    String consumer_key=" ck_1c71b904cce930eab87c896459f484339186e778";
    String consumer_secret="cs_186ffd471ced4c2e29b5861a92dbeef91cf824e2";

    @GET("?consumer_key="+consumer_key+"&consumer_secret="+consumer_secret+"")
    Call<OrderRetrofit> getOrder();

}