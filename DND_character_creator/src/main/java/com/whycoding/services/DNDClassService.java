package com.whycoding.services;

import com.whycoding.model.DNDClass;
import com.whycoding.model.DNDResource;
import org.springframework.web.client.RestTemplate;

public class DNDClassService {

    private static final String API_BASE_URL = "https://www.dnd5eapi.co/api/";
    private final RestTemplate restTemplate = new RestTemplate();

    public DNDResource getClassesResource(){
        return restTemplate.getForObject(API_BASE_URL + "classes/", DNDResource.class);
    }

    public DNDClass getClassByIndex(String index){
        return restTemplate.getForObject(API_BASE_URL + "classes/" + index, DNDClass.class);
    }

    public DNDResource getRacesResource(){
        return restTemplate.getForObject(API_BASE_URL + "races/", DNDResource.class);
    }

    //TODO add getRacebyindex call



    //last brace of class
}
