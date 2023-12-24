package org.example.dto;


public class CreateCompanyDto {


    private String name;

    public CreateCompanyDto(long id, String name) {

        this.name = name;
    }

    public CreateCompanyDto() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
