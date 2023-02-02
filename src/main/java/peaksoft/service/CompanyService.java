package peaksoft.service;

import peaksoft.entity.Company;

public interface CompanyService {
    String save(Company company);
    String deleteById(Long id);
    Company update (Long id,Company newCompany);
}
