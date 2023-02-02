package peaksoft.repository;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import peaksoft.config.Config;
import peaksoft.entity.Category;
import peaksoft.entity.Company;
import peaksoft.entity.Product;

import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    private EntityManagerFactory entityManagerFactory;

    public ProductRepositoryImpl() {
        this.entityManagerFactory = Config.getEntityManagerFactory();
    }

    @Override
    public String save(Long categoryId,Long companyId, Product product) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Company company = entityManager.find(Company.class, companyId);
        Category category=entityManager.find(Category.class,categoryId);
        product.setCategory(category);
        product.setCompany(company);
        entityManager.persist(product);
        entityManager.getTransaction().commit();
        entityManager.close();
        return product+"Successfully saved";
    }

    @Override
    public List<Product> findAllProductsByCompanyId(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Product> resultList = entityManager.createQuery("select p from Product  p inner  join Company  c on p.id=c.id where c.id=?1", Product.class).setParameter(1, id).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return resultList;
    }

    @Override
    public void delete(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Product product = entityManager.find(Product.class, id);
        entityManager.remove(product);
        entityManager.getTransaction().commit();
        entityManager.close();


    }
}