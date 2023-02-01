package com.whycoding.model;

public class DNDRace {
    private String index;
    private String name;
    private String url;

    public String getIndex() {
        return index;
    }
    public void setIndex(String index) {
        this.index = index;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString(){
        return "\n-----------------------" +
                "\n DND Race Details" +
                "\n-----------------------" +
                "\n Index: " + index +
                "\n Name: " + name +
                "\n URL: " + url;
    }
}
