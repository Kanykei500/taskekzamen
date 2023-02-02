package peaksoft.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import peaksoft.config.Config;
import peaksoft.entity.Category;
import peaksoft.entity.Company;

public class CompanyRepositoryImpl implements CompanyRepository{
    private EntityManagerFactory entityManagerFactory;

    public  CompanyRepositoryImpl() {
        this.entityManagerFactory = Config.getEntityManagerFactory();
    }

    @Override
    public String save(Company company) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(company);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully saved";
    }

    @Override
    public void deleteById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Company company = entityManager.find(Company.class, id);
        entityManager.remove(company);
        entityManager.getTransaction().commit();
        entityManager.close();


    }

    @Override
    public Company update(Long id, Company newCompany) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Company reference = entityManager.getReference(Company.class, id);
        reference.setCompanyName(newCompany.getCompanyName());
        entityManager.getTransaction().commit();
        entityManager.close();

        return newCompany;
    }
}