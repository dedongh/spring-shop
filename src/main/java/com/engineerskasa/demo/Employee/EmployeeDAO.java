package com.engineerskasa.demo.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeDAO {
    @Autowired
    EmployeeRepo employeeRepo;

    // save employee
    public void save(Employee employee) {
         employeeRepo.save(employee);
    }

    // get all employees
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    // get single employee
    public Employee findOneEmployee(Integer employee_id) {
        return employeeRepo.findById(employee_id).get();
        //return employeeRepo.findOne(employee_id);
    }

    // delete an employee
    public void delete(Integer employee) {
        employeeRepo.deleteById(employee);
    }

}
