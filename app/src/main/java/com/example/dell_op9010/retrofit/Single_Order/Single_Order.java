package com.example.dell_op9010.retrofit.Single_Order;

/**
 * Created by Dell-OP9010 on 12/16/2017.
 */


import com.example.dell_op9010.retrofit.Order_Retrofit.Order;
import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class Single_Order {

    @SerializedName("order")
    @Expose
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

}