package com.example.dell_op9010.retrofit.product_categories_Retrofit;

/**
 * Created by Dell-OP9010 on 12/20/2017.
 */
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Product_Categories_Retrofit {
    @SerializedName("product_categories")
    @Expose
    private List<ProductCategory> productCategories = null;

    public List<ProductCategory> getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(List<ProductCategory> productCategories) {
        this.productCategories = productCategories;
    }

}
