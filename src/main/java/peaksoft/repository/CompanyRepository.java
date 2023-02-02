package peaksoft.repository;

import peaksoft.entity.Company;

public interface CompanyRepository {
  String save(Company company);
  void deleteById(Long id);
  Company update (Long id, Company newCompany);
}
