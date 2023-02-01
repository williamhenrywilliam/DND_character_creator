package com.whycoding.model;

public class PlayerCharacter {

    private DNDClass dndClass;
    private DNDRace dndRace;
    private String characterName;
    private int strengthScore;
    private int dexterityScore;
    private int constitutionScore;
    private int intelligenceScore;
    private int wisdomScore;
    private int charismaScore;

    public String getCharacterName(){
        return characterName;
    }
    public void setCharacterName(String name){
        this.characterName = name;
    }
    public DNDClass getDndClass() {return dndClass;}
    public void setDndClass(DNDClass dndClass) {this.dndClass = dndClass;}
    public DNDRace getDndRace() {
        return dndRace;
    }
    public void setDndRace(DNDRace dndRace) {
        this.dndRace = dndRace;
    }
    public int getStrengthScore() {
        return strengthScore;
    }
    public void setStrengthScore(int strengthScore) {
        this.strengthScore = strengthScore;
    }
    public int getDexterityScore() {
        return dexterityScore;
    }
    public void setDexterityScore(int dexterityScore) {
        this.dexterityScore = dexterityScore;
    }
    public int getConstitutionScore() {
        return constitutionScore;
    }
    public void setConstitutionScore(int constitutionScore) {
        this.constitutionScore = constitutionScore;
    }
    public int getIntelligenceScore() {
        return intelligenceScore;
    }
    public void setIntelligenceScore(int intelligenceScore) {
        this.intelligenceScore = intelligenceScore;
    }
    public int getWisdomScore() {
        return wisdomScore;
    }
    public void setWisdomScore(int wisdomScore) {
        this.wisdomScore = wisdomScore;
    }
    public int getCharismaScore() {
        return charismaScore;
    }
    public void setCharismaScore(int charismaScore) {
        this.charismaScore = charismaScore;
    }
}
