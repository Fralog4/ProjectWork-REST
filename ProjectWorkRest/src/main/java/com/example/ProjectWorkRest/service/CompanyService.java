package com.example.ProjectWorkRest.service;

import com.example.ProjectWorkRest.exception.NotFoundException;
import com.example.ProjectWorkRest.model.Company;
import com.example.ProjectWorkRest.model.Employee;
import com.example.ProjectWorkRest.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    public Company getCompanyById(String companyId) throws NotFoundException {
        return companyRepository.getCompanyById(companyId);
    }

    public ResponseEntity<List<Company>> getAllCompanies() throws NotFoundException {
        return companyRepository.getAllCompanies();
    }
    public ResponseEntity<String> deleteCompanyById(String companyId) {
        return companyRepository.deleteCompanyById(companyId);
    }
    public ResponseEntity<Company> createCompany(Company company) {
        return companyRepository.createCompany(company);
    }
    public ResponseEntity<String> updateCompany(Company company,String companyId) {
        return companyRepository.updateCompany(company,companyId);
    }
    public Company save(Company company) {
        return companyRepository.save(company);
    }
    }
