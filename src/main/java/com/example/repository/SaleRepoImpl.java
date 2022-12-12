package com.example.repository;

import com.example.Configuration.aeroMapperConfig;
import com.example.entity.Daily_Sales;
import com.example.entity.Product_Details;
import jakarta.inject.Inject;

import java.util.List;

public class SaleRepoImpl {

    @Inject
    aeroMapperConfig mapper;

    public String addSale(Daily_Sales daily_sales) {
        mapper.getMapper().save(daily_sales);
        return "Sale Detail saved successfully..!=" + daily_sales.getSaleId();

    }

    public List<Daily_Sales> getAllSale() {
        return mapper.getMapper().scan(Daily_Sales.class);
    }

    public String addProduct(Product_Details product_details) {
        mapper.getMapper().save(product_details);
        return "Product saved successfully..!=" + product_details.getProductId();

    }

    public Product_Details getbyid(int id) {
        return mapper.getMapper().read(Product_Details.class, id);
    }

}
