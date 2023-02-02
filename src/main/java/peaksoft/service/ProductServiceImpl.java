package peaksoft.service;

import peaksoft.entity.Product;
import peaksoft.repository.ProductRepository;
import peaksoft.repository.ProductRepositoryImpl;

import java.util.List;

public class ProductServiceImpl implements ProductService{
    ProductRepository productRepository=new ProductRepositoryImpl();


    @Override
    public String save(Long categoryId, Long companyId, Product product) {
        productRepository.save(categoryId,companyId,product);
        return "Successfully saved";
    }

    @Override
    public List<Product> findAllProductsByCompanyId(Long id) {
        return productRepository.findAllProductsByCompanyId(id);
    }

    @Override
    public void delete(Long id) {
        productRepository.delete(id);

    }
}
