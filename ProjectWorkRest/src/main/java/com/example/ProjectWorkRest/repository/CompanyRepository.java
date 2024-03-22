package com.example.ProjectWorkRest.repository;

import com.example.ProjectWorkRest.exception.NotFoundException;
import com.example.ProjectWorkRest.model.Company;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CompanyRepository {
    private List<Company> companies = new ArrayList<>();

    public Company getCompanyById(String companyId) throws NotFoundException {
        for (Company company : companies) {
            if (company.getCompanyId().equals(companyId)) {
                return company;
            }
        }
        throw new NotFoundException(String.format("No company found with ID: %s", companyId));
    }

    public ResponseEntity<List<Company>> getAllCompanies() throws NotFoundException {
        if (companies.isEmpty()) {
            throw new NotFoundException(String.format("No companies has been found"));
        }
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    public ResponseEntity<String> deleteCompanyById(String companyId) {
        if (companies.removeIf(x -> x.getCompanyId().equals(companyId))) {
            return new ResponseEntity<>("Company with ID " + companyId + " has been deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Company with ID " + companyId + " not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Company> createCompany(Company company) {
        try {
            Company companyCreated = new Company();
            companyCreated.setAddress(company.getAddress());
            companyCreated.setName(company.getName());
            companyCreated.setCompanyId(company.getCompanyId());
            companyCreated.setEmployeeCompanyList(company.getEmployeeCompanyList());
            companies.add(companyCreated);
            return new ResponseEntity<>(companyCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> updateCompany(Company company, String companyId) {
        Company companyToUpdate = null;
        for (Company companyCheck : companies) {
            if (companyCheck.getCompanyId().equals(companyId)) {
                companyToUpdate = companyCheck;
                break;
            }
        }
        if (companyToUpdate != null) {
            companyToUpdate.setCompanyId(company.getCompanyId());
            companyToUpdate.setAddress(company.getAddress());
            companyToUpdate.setEmployeeCompanyList(company.getEmployeeCompanyList());
            companyToUpdate.setName(company.getName());

            companies.remove(companyToUpdate);
            companies.add(company);
            return new ResponseEntity<>("Employee with ID " + companyId + " updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Employee with ID " + companyId + " not found", HttpStatus.NOT_FOUND);
        }
    }
    public Company save(Company company) {
        companies.add(company);
        return company;
    }
}
