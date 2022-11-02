package com.example.superheroes;

import android.os.Parcel;
import android.os.Parcelable;

public class Character implements Parcelable {
    String name;
    String gender;
    String height;
    String race;
    String weight;
    String hometown;
    String publisher;
    String image_url;
    String intelligence;
    String speed;
    String power;

    public Character(String name, String gender, String height, String race, String weight, String hometown, String publisher, String image_url, String intelligence, String speed, String power) {
        this.name = name;
        this.gender = gender;
        this.height = height;
        this.race = race;
        this.weight = weight;
        this.hometown = hometown;
        this.publisher = publisher;
        this.image_url = image_url;
        this.intelligence = intelligence;
        this.speed = speed;
        this.power = power;
    }

    protected Character(Parcel in) {
        name = in.readString();
        gender = in.readString();
        height = in.readString();
        race = in.readString();
        weight = in.readString();
        hometown = in.readString();
        publisher = in.readString();
        image_url = in.readString();
        intelligence = in.readString();
        speed = in.readString();
        power = in.readString();
    }

    public static final Creator<Character> CREATOR = new Creator<Character>() {
        @Override
        public Character createFromParcel(Parcel in) {
            return new Character(in);
        }

        @Override
        public Character[] newArray(int size) {
            return new Character[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(String intelligence) {
        this.intelligence = intelligence;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(gender);
        parcel.writeString(height);
        parcel.writeString(race);
        parcel.writeString(weight);
        parcel.writeString(hometown);
        parcel.writeString(publisher);
        parcel.writeString(image_url);
        parcel.writeString(intelligence);
        parcel.writeString(speed);
        parcel.writeString(power);
    }
}