package com.sepidejd.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(
        name = "Account",
        description = "Schema to hold Account information"
)
public class AccountsDto {

    @Schema(
            description = "Account number of Sepide Bank account"
    )
    private Long accountNumber;

    @Schema(
            description = "Account type of Seppide Bank account",
            example = "Saving"
    )

    private String accountType;

    @Schema(
            description = "Sepide Bank branch address"
    )
    private String branchAddress;
}
