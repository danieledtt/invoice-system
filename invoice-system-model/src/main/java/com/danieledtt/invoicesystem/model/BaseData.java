package com.danieledtt.invoicesystem.model;

import java.util.List;

/**
 * Created by DuttoDa on 25/04/2018.
 */
public class BaseData {

    private List<Category> categoryList;
    private List<Product> productList;

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
