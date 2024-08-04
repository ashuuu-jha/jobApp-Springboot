package com.example.firstjobapp.company.impl;

import com.example.firstjobapp.company.Company;
import com.example.firstjobapp.company.CompanyRepository;
import com.example.firstjobapp.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company , Long Id) {
       Optional<Company> companyOptional = companyRepository.findById(Id);
        if (companyOptional.isPresent()) {
            Company existingCompany = companyOptional.get();

//            existingCompany.setName(company.getName());
//            existingCompany.setDescription(company.getDescription());
//            existingCompany.setJobs(company.getJobs());
            companyRepository.save(existingCompany);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        if(companyRepository.existsById(id)){
            companyRepository.deleteById(id);
            return true;
        }

        return false;
    }

    @Override
    public void createCompany(Company company) {

    }
    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

}
