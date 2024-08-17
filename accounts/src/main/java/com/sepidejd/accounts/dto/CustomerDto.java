package com.sepidejd.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.Data;

@Data
@Schema(
        name = "Customer",
        description = "Schema to hold Customer and Account information"
)
public class CustomerDto {

    @Schema(
            description = "Name of customer",
            example = "Sepide Jamshididana"
    )
    private String name;

    @Schema(
            description = "Email of customer",
            example = "SepideJamshididana@mail.com"
    )
    private String email;

    @Schema(
            description = "Mobile number of customer",
            example = "123456789"
    )
    private String mobileNumber;

    @Schema(
            description = "Account details of the customer"
    )
    private AccountsDto accountsDto;
}
