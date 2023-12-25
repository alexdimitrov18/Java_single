package org.example.dto;

import org.example.entities.UnitType;

public class CreateVehicleDTO {

    private String type;

    private UnitType unit;

    private String plate;

    private double capacity;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UnitType getUnit() {
        return unit;
    }

    public void setUnit(UnitType unit) {
        this.unit = unit;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }
}
