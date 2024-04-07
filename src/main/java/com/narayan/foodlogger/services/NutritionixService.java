package com.narayan.foodlogger.services;

import com.narayan.foodlogger.model.NutritionixBaseProduct;
import com.narayan.foodlogger.model.NutritionixDetailedProduct;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface NutritionixService {
    List<NutritionixBaseProduct> searchQuery(String query) throws UnsupportedEncodingException;
    NutritionixDetailedProduct getDetailedProduct(String query) throws UnsupportedEncodingException;
}
