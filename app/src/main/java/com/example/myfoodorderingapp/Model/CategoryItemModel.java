package com.example.myfoodorderingapp.Model;

import java.io.Serializable;

public class CategoryItemModel implements Serializable {
    private String id;
    private String title;
    private int image;
    private double rating;
    private double distance;
    private String category;
    private String estimateTime;
    private String price;


    public CategoryItemModel(String id, String title, int image, double rating, double distance, String category, String estimateTime, String price) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.rating = rating;
        this.distance = distance;
        this.category = category;
        this.estimateTime = estimateTime;
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEstimateTime() {
        return estimateTime;
    }

    public void setEstimateTime(String estimateTime) {
        this.estimateTime = estimateTime;
    }
}
