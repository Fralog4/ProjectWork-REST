package com.example.ProjectWorkRest.loader;

import com.example.ProjectWorkRest.model.Company;
import com.example.ProjectWorkRest.model.Employee;
import com.example.ProjectWorkRest.service.CompanyService;
import com.example.ProjectWorkRest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeCompanyLoader implements CommandLineRunner {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CompanyService companyService;

    public void run(String ... args)throws Exception {

        List<Employee> employeeListFincons = new ArrayList<>();
        Company fincons = new Company("1", employeeListFincons, "Bari", "Fincons");
        List<Employee> employeeListAmazon = new ArrayList<>();
        Company amazon = new Company("3", employeeListAmazon, "London", "Amazon");
        List<Employee> employeeListMicrosoft = new ArrayList<>();
        Company microsoft = new Company("2", employeeListMicrosoft, "New York", "Microsoft");

        employeeListFincons = List.of(
                new Employee("1", "Francesco", "Lo Gullo", fincons),
                new Employee("2", "Nicola", "De Girolamo", fincons),
                new Employee("3", "Salvatore", "Macaluso", fincons),
                new Employee("4", "Riccardo", "Patronaggio", fincons),
                new Employee("5", "Cristian", "Scaramella", fincons)
        );
        employeeListAmazon = List.of(
                new Employee("1", "Frank", "Lo Gullo", amazon),
                new Employee("2", "Nick", "DiGregorio", amazon),
                new Employee("3", "Santino", "Macaluso", amazon),
                new Employee("4", "Rick", "Zappalà", amazon),
                new Employee("5", "Robert", "Scaramella", amazon)
        );
        employeeListMicrosoft = List.of(
                new Employee("1", "Luke", "Sky", microsoft),
                new Employee("2", "Frank", "DiGregorio", microsoft),
                new Employee("3", "Matthew", "Macaluso", microsoft),
                new Employee("4", "Rick", "Zappalà", microsoft),
                new Employee("5", "Robert", "Scaramella", microsoft)
        );
        employeeService.save(employeeListFincons);
        employeeService.save(employeeListAmazon);
        employeeService.save(employeeListMicrosoft);
        companyService.save(fincons);
        companyService.save(microsoft);
        companyService.save(amazon);
    }
}
