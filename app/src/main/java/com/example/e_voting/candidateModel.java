package com.example.e_voting;

public class candidateModel {
      String name;
      String imgCandidate;
      String partyName;
      String partySymbol;

    public candidateModel() {
    }

    public candidateModel(String name, String imgCandidate, String partyName, String partySymbol) {
        this.name = name;
        this.imgCandidate = imgCandidate;
        this.partyName = partyName;
        this.partySymbol = partySymbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgCandidate() {
        return imgCandidate;
    }

    public void setImgCandidate(String imgCandidate) {
        this.imgCandidate = imgCandidate;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getPartySymbol() {
        return partySymbol;
    }

    public void setPartySymbol(String partySymbol) {
        this.partySymbol = partySymbol;
    }
}
