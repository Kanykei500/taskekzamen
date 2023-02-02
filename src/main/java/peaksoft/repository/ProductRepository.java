package peaksoft.repository;

import peaksoft.entity.Product;

import java.util.List;

public interface ProductRepository {
    String save(Long companyId,Long categoryId, Product product);
    List<Product> findAllProductsByCompanyId(Long id);
    void delete (Long id);
}
