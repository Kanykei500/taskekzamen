package peaksoft.service;

import peaksoft.entity.Category;
import peaksoft.entity.Product;
import peaksoft.repository.CategoryRepository;
import peaksoft.repository.CategoryRepositoryImpl;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    CategoryRepository categoryRepository=new CategoryRepositoryImpl();


    @Override
    public String save(Category category) {
        categoryRepository.save(category);
        return "Successfully saved";
    }

    @Override
    public List<Product> getAllProductGroupByCategoryName(String name) {


        return categoryRepository.getAllProductGroupByCategoryName( name);
    }
}
