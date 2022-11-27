package com.whycoding.model;

public class PlayerCharacter {

    private DNDClass dndClass;
    private String characterName;

    public String getCharacterName(){
        return characterName;
    }
    public void setCharacterName(String name){
        this.characterName = name;
    }
    public DNDClass getDndClass() {return dndClass;}
    public void setDndClass(DNDClass dndClass) {this.dndClass = dndClass;}



}
