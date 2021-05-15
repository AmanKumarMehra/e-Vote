package com.example.e_voting;

public class CampaignModel {
    String campaign;

    public String getCampaign() {
        return campaign;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    String sender;

    public CampaignModel(String campaign, String sender) {
        this.campaign = campaign;
        this.sender = sender;
    }

    public CampaignModel() {
    }
}
