package com.example.entity;

import com.aerospike.mapper.annotations.AerospikeBin;
import com.aerospike.mapper.annotations.AerospikeEmbed;
import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;

import java.util.List;

@AerospikeRecord(namespace = "test", set = "sale")
public class Daily_Sales {
    @AerospikeKey
    private int saleId;

    @AerospikeEmbed
    private List<Product_Details> products;
    private String saleDate;

    private double totalAmount;

    public Daily_Sales() {
    }

    public Daily_Sales(int saleId, List<Product_Details> products, String saleDate, double totalAmount) {
        this.saleId = saleId;
        this.products = products;
        this.saleDate = saleDate;
        this.totalAmount = totalAmount;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public List<Product_Details> getProducts() {
        return products;
    }

    public void setProducts(List<Product_Details> products) {
        this.products = products;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Daily_Sales{" +
                "saleId=" + saleId +
                ", products=" + products +
                ", saleDate='" + saleDate + '\'' +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
