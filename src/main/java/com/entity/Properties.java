package com.entity;

import lombok.Data;

import java.util.List;

@Data
public class Properties {

    private String year;
    private String programType;
    private String currency;
    private String programAvailabilityId;
    private Rating rating;
    private List<String> categories;
    private List<String> genre;
    private LocalizedTexts programDescription;
    private String duration;
    private List<Images> images;


}
