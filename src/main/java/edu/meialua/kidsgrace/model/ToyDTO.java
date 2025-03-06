package edu.meialua.kidsgrace.model;

public class ToyDTO {
    private Long id;
    private String name;
    private String category;
    private String description;
    private String brand;
    private Byte[] image;
    private float value;

    public ToyDTO() {
    }

    public ToyDTO(Long id, String name, String category, String description, String brand, Byte[] image, float value) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.brand = brand;
        this.image = image;
        this.value = value;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
