package com.abhinav.credochain.Credochain_assignment.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// @Data will automatically create getters and setters
@Data
// @AllArgsConstructor will automatically generate the constructor for this class.
@AllArgsConstructor
// Override collection name by employeeDetails using @Document annotation.
@Document(collation = "employeeDetails")
public class EmployeeDetailRequest {

    // Unique id to fetch employee details from database
    @Id
    String employeeId;
    String mobileNumber;
    String employeeName;
    String emailId;
    Address address;

//    public EmployeeDetailRequest(String employeeId, String mobileNumber, String employeeName, String emailId, Address address) {
//        this.employeeId = employeeId;
//        this.mobileNumber = mobileNumber;
//        this.employeeName = employeeName;
//        this.emailId = emailId;
//        this.address = address;
//    }
}
