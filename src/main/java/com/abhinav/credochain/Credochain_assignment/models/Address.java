package com.abhinav.credochain.Credochain_assignment.models;

import lombok.AllArgsConstructor;
import lombok.Data;

// @Data will automatically create getters and setters
@Data
// @AllArgsConstructor will automatically generate the constructor for this class.
@AllArgsConstructor
public class Address {
    String line1;
    String line2;
    String landmark;
    String city;
    String state;
    String pincode;
}
