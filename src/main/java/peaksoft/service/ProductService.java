package peaksoft.service;

import peaksoft.entity.Product;

import java.util.List;

public interface ProductService {
    String save(Long categoryId,Long companyId, Product product);
    List<Product> findAllProductsByCompanyId(Long id);
    void delete (Long id);
}
