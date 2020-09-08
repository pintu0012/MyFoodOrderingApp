package com.example.myfoodorderingapp.Model;

public class HomeRecyclerModel {
    private String id;
    private String title;
    private int image;
    private String options;

    public HomeRecyclerModel(String id, String title, int image, String options) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.options = options;
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

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }
}
