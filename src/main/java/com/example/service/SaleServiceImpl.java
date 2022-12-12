package com.example.service;

import com.example.entity.Daily_Sales;
import com.example.entity.Product_Details;
import com.example.repository.SaleRepoImpl;
import jakarta.inject.Inject;

import java.util.List;

public class SaleServiceImpl {
    @Inject
    SaleRepoImpl saleRepo;

    public String addSale(Daily_Sales daily_sales) {
        return saleRepo.addSale(daily_sales);
    }

    public List<Daily_Sales> getAllSale() {
        return saleRepo.getAllSale();
    }

    public String addProduct(Product_Details product_details) {
        return saleRepo.addProduct(product_details);
    }

    public Product_Details getbyid(int id) {
        return saleRepo.getbyid(id);
    }
}
