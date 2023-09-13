package com.springboot.demo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {
    private long id;
    @NotEmpty(message = "address should not be null or Empty")
    @Size(max = 10, min = 4, message = "address size should be min 4 and max 10.")
    private String address;
    @JsonProperty("contact_number")
    private String contactNumber;
}
