package com.whycoding.services;

import com.whycoding.model.DNDClass;
import com.whycoding.model.DNDClassList;
import org.springframework.web.client.RestTemplate;

public class DNDClassService {

    private static final String API_BASE_URL = "https://www.dnd5eapi.co/api/";
    private final RestTemplate restTemplate = new RestTemplate();

    public DNDClassList getListOfClasses(){
        return restTemplate.getForObject(API_BASE_URL + "classes/", DNDClassList.class);
    }


    public DNDClass getClassByIndex(String index){
        return restTemplate.getForObject(API_BASE_URL + "classes/" + index, DNDClass.class);
    }
}
