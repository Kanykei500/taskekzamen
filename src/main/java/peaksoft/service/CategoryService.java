package peaksoft.service;

import peaksoft.entity.Category;
import peaksoft.entity.Product;

import java.util.List;

public interface CategoryService {
    String save(Category category);
    List<Product> getAllProductGroupByCategoryName(String name);
}

