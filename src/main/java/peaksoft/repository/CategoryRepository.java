package peaksoft.repository;

import peaksoft.entity.Category;
import peaksoft.entity.Product;

import java.util.List;

public interface CategoryRepository {

    String save(Category category);
    List<Product> getAllProductGroupByCategoryName(String name);


}
