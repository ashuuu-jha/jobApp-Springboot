package com.example.firstjobapp.company;

import com.example.firstjobapp.job.Job;
import com.example.firstjobapp.job.JobRepository;
import com.example.firstjobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public interface CompanyService {
     List<Company> getAllCompanies();
     boolean updateCompany(Company company , Long id);
     boolean deleteCompanyById(Long id);
     void createCompany(Company company);
     Company getCompanyById(Long id);
}
