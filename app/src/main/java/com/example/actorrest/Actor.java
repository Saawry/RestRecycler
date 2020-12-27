package com.example.actorrest;

import androidx.annotation.NonNull;

public class Actor {
    private String id;
    private String name;
    private String image;
    private String age;

    public Actor(String id, String name, String image, String age) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.age = age;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
