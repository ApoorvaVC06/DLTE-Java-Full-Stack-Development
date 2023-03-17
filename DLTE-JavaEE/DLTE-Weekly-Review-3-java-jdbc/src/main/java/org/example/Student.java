package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    private int reg_no;
    private  String name;
    private int age;
    private  String email;
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class Address{
    private  String door,street,city;
    private int pincode;
}
