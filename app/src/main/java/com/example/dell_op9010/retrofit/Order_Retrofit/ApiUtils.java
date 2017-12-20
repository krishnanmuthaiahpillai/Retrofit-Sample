package com.example.dell_op9010.retrofit.Order_Retrofit;

import com.example.dell_op9010.retrofit.Product_Retrofit.ProductRetriever;
import com.example.dell_op9010.retrofit.Product_Retrofit.ProductRetrofit;
import com.example.dell_op9010.retrofit.Single_Order.SingleOrderRetriever;
import com.example.dell_op9010.retrofit.product_categories_Retrofit.Product_Categories_Retriever;

/**
 * Created by Dell-OP9010 on 12/12/2017.
 */

public class ApiUtils {

    public static final String BASE_URL = "https://www.harvestfromhome.in/storefront/wc-api/v2/";

    public static OrderRetriever getOrderDetails(String order) {
        return RetrofitClient.getClient(BASE_URL+order).create(OrderRetriever.class);
    }

    public static SingleOrderRetriever getSingleOrderDetails(String orderno) {
        return RetrofitClient.getClient(BASE_URL+orderno).create(SingleOrderRetriever.class);
    }


    public static ProductRetriever getProductDetails() {
        return RetrofitClient.getClient(BASE_URL).create(ProductRetriever.class);
    }

    public static Product_Categories_Retriever getProductCategory() {
        return RetrofitClient.getClient(BASE_URL).create(Product_Categories_Retriever.class);
    }
}


