package de.hska.iwi.vslab.Api_Category.ConsumingREST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;


public class ConsumeCoreCategory {

    private String urlCoreCategory = "http://localhost:8082/category";
    
    RestTemplate restTemplate = new RestTemplate();

    public Category[] getCategories() {
        Category [] categories = restTemplate.getForObject(urlCoreCategory, Category[].class);
        return categories;
    }

    public Category getCategory(int id) {
        Category category = restTemplate.getForObject(urlCoreCategory + "/" + id, Category.class);
        return category;
    }

    public void addCategory(Category category) {
        restTemplate.postForLocation(urlCoreCategory, category);
    }

    public void updateCategory(Category category) {
        restTemplate.put(urlCoreCategory, category);
    }

}