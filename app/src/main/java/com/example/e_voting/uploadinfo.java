package com.example.e_voting;

public class uploadinfo {

    public String aadharNumData;
    public String locationData;
    public String ageData;
    public String phoneNumData;
    public String userIdData;
    public String passwordData;
    public String verified;
    public String imageURL1;
    public String imageURL2;

    public uploadinfo(){

    }

    public uploadinfo(String aadharNumData, String locationData, String ageData, String phoneNumData, String userIdData, String passwordData, String verified, String imageURL1, String imageURL2) {
        this.aadharNumData = aadharNumData;
        this.locationData = locationData;
        this.ageData = ageData;
        this.phoneNumData = phoneNumData;
        this.userIdData = userIdData;
        this.passwordData = passwordData;
        this.verified = verified;
        this.imageURL1= imageURL1;
        this.imageURL2= imageURL2;
    }

    public String getAadharNumData() {
        return aadharNumData;
    }

    public String getLocationData() {
        return locationData;
    }

    public String getAgeData() {
        return ageData;
    }

    public String getPhoneNumData() {
        return phoneNumData;
    }

    public String getUserIdData() {
        return userIdData;
    }

    public String getPasswordData() {
        return passwordData;
    }

    public String getVerified() {
        return verified;
    }

    public String getImageURL1() {
        return imageURL1;
    }

    public String getImageURL2() {
        return imageURL2;
    }
}
