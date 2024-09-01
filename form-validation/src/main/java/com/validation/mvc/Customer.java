package com.validation.mvc;

import com.validation.mvc.validation.NBACode;
import jakarta.validation.constraints.*;

public class Customer {

    private String firstName;

    @Min(value = 0, message = "must be greater than or equal to 0")
    @Max(value=10, message="can't be greater than 10")
    @NotNull(message = "is required")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 characters")
    private String postalCode;

    @NotNull(message = "is required")
    @Size(min=1, message = "is required")
    private String lastName = "";

    @NBACode(value = "NBA2K", message = "must start with NBA2K")
    private String nbaCode;

    public String getNbaCode() {
        return nbaCode;
    }

    public void setNbaCode(String nbaCode) {
        this.nbaCode = nbaCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getFreePasses() {
        return freePasses;
    }


    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
