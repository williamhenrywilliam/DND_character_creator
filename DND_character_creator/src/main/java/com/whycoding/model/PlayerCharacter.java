package com.whycoding.model;

public class PlayerCharacter {

    private DNDClass dndClass;
    private DNDRace dndRace;
    private String characterName;

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
}
