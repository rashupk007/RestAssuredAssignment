package com.entity;

import lombok.Data;

import java.util.List;

@Data
public class Promotion {

    private String promotionId;
    private int orderId;
    private List<String> promoArea;
    private String promoType;
    private boolean showPrice;
    private boolean showText;
    private LocalizedTexts localizedTexts;
    private List<Properties> properties;

}
