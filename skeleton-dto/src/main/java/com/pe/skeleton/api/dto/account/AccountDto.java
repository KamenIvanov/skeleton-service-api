package com.pe.skeleton.api.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pe.skeleton.api.dto.AbstractNamedEntityDto;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

/**
 * @author kamen on 3.06.22 г.
 */
@Schema(description = "Holds full data about an account.")
public class AccountDto extends AbstractNamedEntityDto {

    @Schema(description = "The email used for the registration.")
    @JsonProperty(value = "email")
    private String email;

    @Schema(description = "The user's gender.")
    @JsonProperty(value = "gender")
    private GenderDto gender;

    @Schema(description = "Indicates the account status.")
    @JsonProperty(value = "status")
    private AccountStatusDto status;

    public AccountDto() {
        // POJO
    }

    public AccountDto(UUID id, String name) {
        super(id, name);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GenderDto getGender() {
        return gender;
    }

    public void setGender(GenderDto gender) {
        this.gender = gender;
    }

    public AccountStatusDto getStatus() {
        return status;
    }

    public void setStatus(AccountStatusDto status) {
        this.status = status;
    }
}
