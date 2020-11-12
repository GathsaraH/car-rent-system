package dto;

import javafx.collections.ObservableList;

public class VehicleDTO {
    private String id;
    private String name;
    private String status;
    private String model;
    private String type;
    private String color;

    public VehicleDTO() {
    }

    public VehicleDTO(String id, String name, String status, String model, String type, String color) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.model = model;
        this.type = type;
        this.color = color;
    }

    public VehicleDTO(String status) {
        this.status=status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    @Override
    public String toString() {
        return "VehicleDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
