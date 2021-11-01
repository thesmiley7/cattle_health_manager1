package com.example.cattlehealthmanager.ui;

import android.os.Bundle;

public class AnimalList {

    public int tagNo;
    private String category;
    private double weight;
    public boolean gender;
    private String methodObtained;
    private String date;
    private int fatherTag;
    private int motherTag;

    //constructors


    public AnimalList(int tagNo, String category, double weight, boolean gender, String methodObtained, String date, int fatherTag, int motherTag) {
        this.tagNo = tagNo;
        this.category = category;
        this.weight = weight;
        this.gender = gender;
        this.methodObtained = methodObtained;
        this.date = date;
        this.fatherTag = fatherTag;
        this.motherTag = motherTag;
    }

    public AnimalList() {
    }

    //toString method

    @Override
    public String toString() {
        return "AnimalList{" +
                "tagNo=" + tagNo +
                ", category='" + category + '\'' +
                ", weight=" + weight +
                ", gender=" + gender +
                ", methodObtained='" + methodObtained + '\'' +
                ", date='" + date + '\'' +
                ", fatherTag=" + fatherTag +
                ", motherTag=" + motherTag +
                '}';
    }


    //getters and setters

    public int getTagNo() {
        return tagNo;
    }

    public void setTagNo(int tagNo) {
        this.tagNo = tagNo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getMethodObtained() {
        return methodObtained;
    }

    public void setMethodObtained(String methodObtained) {
        this.methodObtained = methodObtained;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getFatherTag() {
        return fatherTag;
    }

    public void setFatherTag(int fatherTag) {
        this.fatherTag = fatherTag;
    }

    public int getMotherTag() {
        return motherTag;
    }

    public void setMotherTag(int motherTag) {
        this.motherTag = motherTag;
    }

    protected void onCreate(Bundle savedInstanceState) {
    }
}
