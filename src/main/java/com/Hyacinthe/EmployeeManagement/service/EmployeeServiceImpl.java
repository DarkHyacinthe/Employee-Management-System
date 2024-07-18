package com.Hyacinthe.EmployeeManagement.service;

import com.Hyacinthe.EmployeeManagement.model.Employee;
import com.Hyacinthe.EmployeeManagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.ldap.PagedResultsControl;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    @Override
    public Employee getEmployeeById(Long id){
        return employeeRepository.findById(id).orElse(null);
    }
    @Override
    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    @Override
    public Employee updateEmployee(Long id, Employee employee){
        Employee existingEmployee = employeeRepository.findById(id).orElse(null);
        if (existingEmployee != null){
            existingEmployee.setFirstName(employee.getFirstName());
            existingEmployee.setLastName(employee.getLastName());
            existingEmployee.setEmail(employee.getEmail());
            return employeeRepository.save(existingEmployee);
        }
        return null;
    }
    @Override
    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }

}
