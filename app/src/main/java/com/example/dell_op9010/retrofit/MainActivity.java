package com.example.dell_op9010.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.dell_op9010.retrofit.Order_Retrofit.ApiUtils;
import com.example.dell_op9010.retrofit.Order_Retrofit.Order;
import com.example.dell_op9010.retrofit.Order_Retrofit.OrderRetriever;
import com.example.dell_op9010.retrofit.Order_Retrofit.OrderRetrofit;
import com.example.dell_op9010.retrofit.Product_Retrofit.Product;
import com.example.dell_op9010.retrofit.Product_Retrofit.ProductRetriever;
import com.example.dell_op9010.retrofit.Product_Retrofit.ProductRetrofit;
import com.example.dell_op9010.retrofit.Single_Order.SingleOrderRetriever;
import com.example.dell_op9010.retrofit.Single_Order.Single_Order;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private OrderRetriever orderRetriever;
    private SingleOrderRetriever singleOrderRetriever;
    private ProductRetriever productRetriever;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // orderRetriever = ApiUtils.getOrderDetails("orders/");
        singleOrderRetriever=ApiUtils.getSingleOrderDetails("orders/386/");
      //  productRetriever=ApiUtils.getProductDetails();
     //   loadOrder();
     //   loadProduct();
        loadSingleOrder();
    }

    private void loadSingleOrder() {
        new Thread(new Runnable() {
            @Override
            public void run() {
        singleOrderRetriever.getOrder().enqueue(new Callback<Single_Order>() {
            @Override
            public void onResponse(Call<Single_Order> call, Response<Single_Order> response) {

                if(response.isSuccessful()) {
                    //mAdapter.updateAnswers(response.body().getItems());
                    Order order=response.body().getOrder();

                    if(order!=null){
                         Log.d("Single Order", "===>"+order.getId());
                        Log.e("Single Order", "===>"+order.getId());
                        Log.w("Single Order", "===>"+order.getId());
                        Log.i("Single Order", "===>"+order.getId());

                    }

                }else {
                    int statusCode  = response.code();
                    Log.e("Single Order", "statusCode"+statusCode);
                    Log.e("Single Order", "statusCode"+statusCode);
                    Log.e("Single Order", "statusCode"+statusCode);
                    Log.e("Single Order", "statusCode"+statusCode);
                    Log.e("Single Order", "statusCode"+statusCode);
                    Log.e("Single Order", "statusCode"+statusCode);


                }
            }

            @Override
            public void onFailure(Call<Single_Order> call, Throwable t) {
                // showErrorMessage();
                Log.d("Single Order", "===onFailure>");
                Log.e("Single Order", "===onFailure>");
                Log.w("Single Order", "===onFailure>");
                Log.i("Single Order", "===onFailure>");
            }
        });
            }
        }).start();

    }

    private void loadProduct() {

                productRetriever.getProduct().enqueue(new Callback<ProductRetrofit>() {
                    @Override
                    public void onResponse(Call<ProductRetrofit> call, Response<ProductRetrofit> response) {

                        if(response.isSuccessful()) {
                            //mAdapter.updateAnswers(response.body().getItems());
                            List<Product>productList=response.body().getProducts();

                            if(productList!=null&&!productList.isEmpty()){
                                for(int i=0;i<productList.size();i++){
                                    Log.d("productList", "===>"+productList.get(i).getTitle());
                                }
                            }

                        }else {
                            int statusCode  = response.code();
                            Log.e("productList", "statusCode"+statusCode);

                        }
                    }

                    @Override
                    public void onFailure(Call<ProductRetrofit> call, Throwable t) {
                        // showErrorMessage();
                    }
                });


    }

    public void loadOrder() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                orderRetriever.getOrder().enqueue(new Callback<OrderRetrofit>() {
                    @Override
                    public void onResponse(Call<OrderRetrofit> call, Response<OrderRetrofit> response) {

                        if(response.isSuccessful()) {
                            //mAdapter.updateAnswers(response.body().getItems());
                            List<Order>orderList=response.body().getOrders();

                            if(orderList!=null&&!orderList.isEmpty()){
                                for(int i=0;i<orderList.size();i++){
                                    Log.d("orderList", "===>"+orderList.get(i).getOrderNumber());
                                }
                            }

                        }else {
                            int statusCode  = response.code();
                            Log.e("statusCode", "statusCode"+statusCode);

                        }
                    }

                    @Override
                    public void onFailure(Call<OrderRetrofit> call, Throwable t) {
                        // showErrorMessage();
                    }
                });
            }
        }).start();

    }
}
