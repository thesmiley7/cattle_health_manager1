package com.example.cattlehealthmanager.animal;

public class Animal {
    private String tag_no;
    private String category;
    private double weight;
    private boolean gender;
    private String method_obtained;
    private String DOB;
    private String father_tag;
    private String mother_tag;

    public Animal(String tag_no, String category, double weight, boolean gender, String method_obtained, String DOB, String father_tag, String mother_tag) {
        this.tag_no = tag_no;
        this.category = category;
        this.weight = weight;
        this.gender = gender;
        this.method_obtained = method_obtained;
        this.DOB = DOB;
        this.father_tag = father_tag;
        this.mother_tag = mother_tag;
    }

    public String getTag_no() {
        return tag_no;
    }

    public void setTag_no(String tag_no) {
        this.tag_no = tag_no;
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

    public String getMethod_obtained() {
        return method_obtained;
    }

    public void setMethod_obtained(String method_obtained) {
        this.method_obtained = method_obtained;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getFather_tag() {
        return father_tag;
    }

    public void setFather_tag(String father_tag) {
        this.father_tag = father_tag;
    }

    public String getMother_tag() {
        return mother_tag;
    }

    public void setMother_tag(String mother_tag) {
        this.mother_tag = mother_tag;
    }
}
