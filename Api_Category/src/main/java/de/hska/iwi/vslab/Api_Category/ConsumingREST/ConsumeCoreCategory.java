package de.hska.iwi.vslab.Api_Category.ConsumingREST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;


public class ConsumeCoreCategory {

    //private String urlCoreCategory = "http://localhost:8082/category";

    private static final Logger log = LoggerFactory.getLogger(ConsumeCoreCategory.class);
    RestTemplate restTemplate = new RestTemplate();

    public Category[] getCategories() {
        try {
            UrlBuilder urlBuilder = new UrlBuilder();
            log.info("URL:" + urlBuilder.getCategoryUrl());
            Category [] categories = restTemplate.getForObject(urlBuilder.getCategoryUrl(), Category[].class);
            return categories;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

    public Category getCategory(int id) {
        try {
            UrlBuilder urlBuilder = new UrlBuilder();
            log.info("URL:" + urlBuilder.getCategoryUrl_withId(id));
            Category category = restTemplate.getForObject(urlBuilder.getCategoryUrl_withId(id), Category.class);
            return category;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

    public void addCategory(Category category) {
        try {
            UrlBuilder urlBuilder = new UrlBuilder();
            log.info("URL:" + urlBuilder.getCategoryUrl());
            restTemplate.postForLocation(urlBuilder.getCategoryUrl(), category);
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

    public void updateCategory(Category category) {
        try {
            UrlBuilder urlBuilder = new UrlBuilder();
            log.info("URL:" + urlBuilder.getCategoryUrl());
            restTemplate.put(urlBuilder.getCategoryUrl(), category);
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

}