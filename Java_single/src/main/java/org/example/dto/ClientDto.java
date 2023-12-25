package org.example.dto;

public class ClientDto {

    private long id;

    private String name;

    private String family_name;

    public ClientDto(long id, String name, String family_name) {
        this.id = id;
        this.name = name;
        this.family_name = family_name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    @Override
    public String toString() {
        return "ClientDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", family_name='" + family_name + '\'' +
                '}';
    }

}
