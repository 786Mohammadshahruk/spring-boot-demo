package com.springboot.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonProperty("first_name")
    @NotEmpty(message = "first_name should not be null or Empty")
    @Size(max = 10, min = 4, message = "first_name size should be min 4 and max 10.")
    @Column(name = "first_name")
    private String firstName;


    @JsonProperty("last_name")
    @Column(name = "last_name")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$", message = "Last Name only contains letters, Numbers and Space")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @JsonProperty("mobile_number")
    @Column(name = "mobile_number")
    private String mobileNumber;

    @JsonProperty("contact_number")
    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "price")
    @Digits(integer = 3, fraction = 2, message = "price should be maximum 3 digit and fraction should be 2 digit")
    private BigDecimal price;

}
