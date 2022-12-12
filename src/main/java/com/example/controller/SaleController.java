package com.example.controller;

import com.example.Configuration.aeroMapperConfig;
import com.example.entity.Daily_Sales;
import com.example.entity.Product_Details;
import com.example.service.SaleServiceImpl;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;

import java.util.*;
import java.util.stream.Collectors;


@Controller("/sale")
public class SaleController {
    @Inject
    aeroMapperConfig mapper;
    @Inject
    SaleServiceImpl saleService;

    @Post("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public String addSale(@Body Daily_Sales daily_sales) {
        return saleService.addSale(daily_sales);
    }

    @Get("/get")
    public List<Daily_Sales> getAllSale() {
        return saleService.getAllSale();
    }

    @Get("/daycount/{saleDate}")
    public int getcnt(@PathVariable String saleDate) {
        List<Daily_Sales> ds = mapper.getMapper().scan(Daily_Sales.class);
        return ds.stream().filter(x -> x.getSaleDate().equalsIgnoreCase(saleDate)).collect(Collectors.toList()).size();

    }

    @Get("/daymax/{saleDate}")
    public double getmaxamt(@PathVariable String saleDate) {
        double max = 0;
        List<Daily_Sales> ds = mapper.getMapper().scan(Daily_Sales.class);
        List<Daily_Sales> daily_sales = ds.stream().filter(x -> x.getSaleDate().equals(saleDate)).collect(Collectors.toList());

        for (Daily_Sales d : daily_sales) {
            if (d.getTotalAmount() > max) {

                max = d.getTotalAmount();
            }
        }

        return max;
    }

    @Get("/dailysale/{saleDate}")
    public List<Daily_Sales> todaysalelist(@PathVariable String saleDate) {
        List<Daily_Sales> daily_sales = mapper.getMapper().scan(Daily_Sales.class).stream().filter(x -> x.getSaleDate().equals(saleDate)).collect(Collectors.toList());
        return daily_sales;
    }

    @Get("/dayavg/{saleDate}")
    public double getavg(@PathVariable String saleDate) {
        double add = 0;
        List<Daily_Sales> ds = mapper.getMapper().scan(Daily_Sales.class);
        List<Daily_Sales> daily_sales = ds.stream().filter(x -> x.getSaleDate().equals(saleDate)).
                collect(Collectors.toList());
        for (Daily_Sales d : daily_sales) {
            add = add + d.getTotalAmount();
        }
        return (add / daily_sales.size());
    }

    @Get("/pname/{saleDate}")
    public List<List<Product_Details>> productname(@PathVariable String saleDate) {
        List<Daily_Sales> daily_sales = mapper.getMapper().scan(Daily_Sales.class).stream()
                .filter(x -> x.getSaleDate().equals(saleDate)).collect(Collectors.toList());

        List<List<Product_Details>> s = new ArrayList<>();
        daily_sales.stream().forEach(i -> s.add(i.getProducts()));
        return s;
    }
}

