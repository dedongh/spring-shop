package com.engineerskasa.demo.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ekits")
public class EmployeeController {
    @Autowired
    EmployeeDAO employeeDAO;

    @PostMapping("/employees")
    public void createEmployee(@Valid @RequestBody Employee employee) {
         employeeDAO.save(employee);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeDAO.findAll();
    }

    @GetMapping("/employees/{employee_id}")
    public ResponseEntity<Employee> getEmployeeByID(@PathVariable Integer employee_id) {

        Employee employee = employeeDAO.findOneEmployee(employee_id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(employee);
    }

    @PutMapping("/employees/{employee_id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "employee_id") Integer employee_id,
                                                   @Valid @RequestBody Employee employee) {
        Employee emp = employeeDAO.findOneEmployee(employee_id);
        if (emp == null) {
            return ResponseEntity.notFound().build();
        }

        emp.setEmployee_name(employee.getEmployee_name());
        emp.setEmployee_designation(employee.getEmployee_designation());
        emp.setEmployee_expertise(employee.getEmployee_expertise());

        employeeDAO.save(emp);

        return ResponseEntity.ok().body(emp);

    }

    @DeleteMapping("/employees/{employee_id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Integer employee_id) {
        Employee emp = employeeDAO.findOneEmployee(employee_id);
        if (emp == null) {
            return ResponseEntity.notFound().build();
        }
        employeeDAO.delete(employee_id);
        return ResponseEntity.ok().build();
    }
}
