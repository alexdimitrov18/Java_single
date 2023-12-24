package org.example.dto;

import org.example.entities.UnitType;

public class VehicleDTO {

    private String type;

    private UnitType unit;

    private String plate;

    private double capacity ;


    public VehicleDTO() {
    }

    public VehicleDTO(String type, UnitType unit, String plate, double capacity) {
        this.type = type;
        this.unit = unit;
        this.plate = plate;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "VehicleDTO{" +
                "type='" + type + '\'' +
                ", unit=" + unit +
                ", plate='" + plate + '\'' +
                ", capacity=" + capacity +
                '}';
    }

}
