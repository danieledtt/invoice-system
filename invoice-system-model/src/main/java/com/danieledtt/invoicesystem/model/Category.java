package com.danieledtt.invoicesystem.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by DuttoDa on 24/04/2018.
 */
public class Category {

    private long idCategory;
    private String name;
    private BigDecimal taxRate;

    public long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(long idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;

        Category category = (Category) o;

        if (idCategory != category.idCategory) return false;
        if (name != null ? !name.equals(category.name) : category.name != null) return false;
        return !(taxRate != null ? !taxRate.equals(category.taxRate) : category.taxRate != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (idCategory ^ (idCategory >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (taxRate != null ? taxRate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Category{" +
                "idCategory=" + idCategory +
                ", name='" + name + '\'' +
                ", taxRate=" + taxRate +
                '}';
    }
}
