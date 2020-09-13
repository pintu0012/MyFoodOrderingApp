package com.example.myfoodorderingapp.Model;

public class RestaurantSliderModel {
    private String id;
    private int image;
    private String imageLink;

    public RestaurantSliderModel(String id, int image, String imageLink) {
        this.id = id;
        this.image = image;
        this.imageLink = imageLink;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
