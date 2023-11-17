package com.luv2code;

import com.luv2code.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {
    @CourseCode
    private String courseCode;
    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
    private String postalCode;
    @NotNull(message = "is required")
    @Min(value = 0, message = "must be greater than 0 or equal to 0")
    @Max(value = 10, message = "must be least than 10 or equal to 10")
    private Integer freePasses;
    private String firstName;

    // validation rules
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName = "";

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
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

    public void setFreePasses(int freePasses) {
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
