package peaksoft.service;

import peaksoft.entity.Company;
import peaksoft.repository.CompanyRepository;
import peaksoft.repository.CompanyRepositoryImpl;

public class CompanyServiceImpl implements CompanyService{
    CompanyRepository companyRepository=new CompanyRepositoryImpl();

    @Override
    public String save(Company company) {
        companyRepository.save(company);
        return "Successfully saved";
    }

    @Override
    public String deleteById(Long id) {
        companyRepository.deleteById(id);

        return "Successfully deleted";
    }

    @Override
    public Company update(Long id, Company newCompany) {

        return companyRepository.update(id, newCompany);
    }
}
