package com.example.e_voting;

public class model {

    String aadharNumData;
    String ageData;
    String imageURL2;
    String locationData;
    String passwordData;
    String phoneNumData;
    String userIdData;

    // Empty Constructor
    public model() {

    }

    // parametrized Constructor
    public model(String aadharNumData, String ageData, String imageURL2, String locationData, String passwordData, String phoneNumData, String userIdData) {
        this.aadharNumData = aadharNumData;
        this.ageData = ageData;
        this.imageURL2 = imageURL2;
        this.locationData = locationData;
        this.passwordData = passwordData;
        this.phoneNumData = phoneNumData;
        this.userIdData = userIdData;
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

    public String getPasswordData() {
        return passwordData;
    }

    public void setPasswordData(String passwordData) {
        this.passwordData = passwordData;
    }

    public String getPhoneNumData() {
        return phoneNumData;
    }

    public void setPhoneNumData(String phoneNumData) {
        this.phoneNumData = phoneNumData;
    }

    public String getUserIdData() {
        return userIdData;
    }

    public void setUserIdData(String userIdData) {
        this.userIdData = userIdData;
    }
}
