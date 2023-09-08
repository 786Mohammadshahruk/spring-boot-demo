package com.springboot.demo.model.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserResponseModel {
    private MetaData metaData;
    private ResourceData resourceData;
}
