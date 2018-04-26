package com.danieledtt.invoicesystem.model;

import java.math.BigDecimal;

/**
 * Created by DuttoDa on 24/04/2018.
 */
public class Product {

    private long idProduct;
    private String name;
    private BigDecimal netPrice;
    private boolean imported;
    private Category category;

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(BigDecimal netPrice) {
        this.netPrice = netPrice;
    }

    public boolean getImported() {
        return imported;
    }

    public void setImported(boolean imported) {
        this.imported = imported;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (idProduct != product.idProduct) return false;
        if (imported != product.imported) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (netPrice != null ? !netPrice.equals(product.netPrice) : product.netPrice != null) return false;
        return !(category != null ? !category.equals(product.category) : product.category != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (idProduct ^ (idProduct >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (netPrice != null ? netPrice.hashCode() : 0);
        result = 31 * result + (imported ? 1 : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", name='" + name + '\'' +
                ", netPrice=" + netPrice +
                ", imported=" + imported +
                ", category=" + category +
                '}';
    }
}
