package peaksoft.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import peaksoft.config.Config;
import peaksoft.entity.Category;
import peaksoft.entity.Product;

import java.util.List;

public class CategoryRepositoryImpl implements CategoryRepository {
    private final EntityManagerFactory entityManagerFactory;

    public CategoryRepositoryImpl() {
        this.entityManagerFactory = Config.getEntityManagerFactory();
    }

    @Override
    public String save(Category category) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(category);
        entityManager.getTransaction().commit();
        entityManager.close();
        return category+"Successfully save";
    }

    @Override
    public List<Product> getAllProductGroupByCategoryName(String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Product> resultList = entityManager.createQuery("select p from  Product p join Category  c on p.id=c.id where c.categoryName=:name", Product.class)
                .setParameter("name",name)
                .getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return resultList;
    }
}
