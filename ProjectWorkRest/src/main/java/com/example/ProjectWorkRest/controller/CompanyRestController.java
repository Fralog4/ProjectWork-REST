package com.example.ProjectWorkRest.controller;


import com.example.ProjectWorkRest.exception.NotFoundException;
import com.example.ProjectWorkRest.loader.EmployeeCompanyLoader;
import com.example.ProjectWorkRest.model.Company;
import com.example.ProjectWorkRest.repository.CompanyRepository;
import com.example.ProjectWorkRest.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyRestController{

    @Autowired
    private CompanyService companyService;
    @GetMapping("{companyId}")
    public Company getCompanyById(@PathVariable String companyId) throws NotFoundException {
        return companyService.getCompanyById(companyId);
    }
    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() throws NotFoundException {
        return companyService.getAllCompanies();
    }
    @DeleteMapping("{companyId}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable String companyId) {
        return companyService.deleteCompanyById(companyId);
    }
    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        return companyService.createCompany(company);
    }
    @PutMapping("{companyId}")
    public ResponseEntity<String> updateCompany(@PathVariable String companyId, @RequestBody Company company) {
        return companyService.updateCompany(company,companyId);
    }
}
