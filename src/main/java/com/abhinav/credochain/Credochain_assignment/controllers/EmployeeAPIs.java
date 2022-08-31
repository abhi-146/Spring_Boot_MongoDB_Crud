package com.abhinav.credochain.Credochain_assignment.controllers;

import com.abhinav.credochain.Credochain_assignment.models.EmployeeDetailRequest;
import com.abhinav.credochain.Credochain_assignment.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class EmployeeAPIs {
    @Autowired
    EmployeeRepository employeeRepository;


    // API: Create or Save employee details
    @PostMapping("/employees")
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeDetailRequest employeeDetailRequest) {
        try {
            EmployeeDetailRequest _employee = employeeRepository.save(new EmployeeDetailRequest(
                    employeeDetailRequest.getEmployeeId(),
                    employeeDetailRequest.getMobileNumber(),
                    employeeDetailRequest.getEmployeeName(),
                    employeeDetailRequest.getEmailId(),
                    employeeDetailRequest.getAddress()));

            // Return: Success
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // API 2: Read or Retrieve employee details
    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDetailRequest> getEmployeeById(@PathVariable("id") String id) {
        Optional<EmployeeDetailRequest> _employee = employeeRepository.findById(id);
        if (_employee.isPresent()) {

            // If the required employee is present, return its details.
            return new ResponseEntity<>(_employee.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // API 3: Update employee details
    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeDetailRequest> updateEmployee(@PathVariable("id") String id, @RequestBody EmployeeDetailRequest employeeDetailRequest) {
        Optional<EmployeeDetailRequest> _employee = employeeRepository.findById(id);
        if (_employee.isPresent()) {

            // Get the employee.
            EmployeeDetailRequest update_employee = _employee.get();

            // Update the employee details
            update_employee.setEmployeeId(employeeDetailRequest.getEmployeeId());
            update_employee.setMobileNumber(employeeDetailRequest.getMobileNumber());
            update_employee.setEmployeeName(employeeDetailRequest.getEmployeeName());
            update_employee.setEmailId(employeeDetailRequest.getEmailId());
            update_employee.setAddress(employeeDetailRequest.getAddress());

            // Reflect the updated details in the database
            employeeRepository.save(update_employee);

            // Return the updated details of employee.
            return new ResponseEntity<>(update_employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // API 4: Delete employee details
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<EmployeeDetailRequest> deleteEmployee(@PathVariable("id") String id) {
        try {

            // Delete the employee from the database
            employeeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
