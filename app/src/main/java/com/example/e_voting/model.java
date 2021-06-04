package com.example.e_voting;

public class model {

    String aadharNumData;
    String ageData;
    String imageURL2;
    String locationData;
    String phoneNumData;
    String verified;


    // Empty Constructor
    public model() {

    }

    // parametrized Constructor
    public model(String aadharNumData, String ageData, String imageURL2, String locationData,  String phoneNumData, String verified) {
        this.aadharNumData = aadharNumData;
        this.ageData = ageData;
        this.imageURL2 = imageURL2;
        this.locationData = locationData;
        this.phoneNumData = phoneNumData;
        this.verified = verified;
    }


    // Getter Setters
    public String getAadharNumData() {
        return aadharNumData;
    }

    public void setAadharNumData(String aadharNumData) {
        this.aadharNumData = aadharNumData;
    }

    public String getAgeData() {
        return ageData;
    }

    public void setAgeData(String ageData) {
        this.ageData = ageData;
    }

    public String getImageURL2() {
        return imageURL2;
    }

    public void setImageURL2(String imageURL2) {
        this.imageURL2 = imageURL2;
    }

    public String getLocationData() {
        return locationData;
    }

    public void setLocationData(String locationData) {
        this.locationData = locationData;
    }



    public String getPhoneNumData() {
        return phoneNumData;
    }

    public void setPhoneNumData(String phoneNumData) {
        this.phoneNumData = phoneNumData;
    }

    public String getVerified() {
        return verified;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }
}
