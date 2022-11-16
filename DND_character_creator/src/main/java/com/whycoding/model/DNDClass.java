package com.whycoding.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DNDClass {

    private String index;
    private String name;
    private String url;
    @JsonProperty("hit_die")
    private int hitDie;

    public String getIndex() {return index;}
    public void setIndex(String index) {this.index = index;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getUrl() {return url;}
    public void setUrl(String url) {this.url = url;}
    public int getHitDice() {return hitDie;}
    public void setHitDice(int hitDice) {this.hitDie = hitDice;}

    @Override
    public String toString(){
        return "\n-----------------------" +
                "\n DND Class Details" +
                "\n-----------------------" +
                "\n Index: " + index +
                "\n Name: " + name +
                "\n Hit Die: " + hitDie +
                "\n URL: " + url;

    }


//last brace of the class
}

