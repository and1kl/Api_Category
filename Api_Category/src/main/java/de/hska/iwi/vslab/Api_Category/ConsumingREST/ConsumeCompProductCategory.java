package de.hska.iwi.vslab.Api_Category.ConsumingREST;

import org.springframework.web.client.RestTemplate;


public class ConsumeCompProductCategory {

    private String urlCoreProduct = "http://localhost:8081//comp_product_category/category";
    
    RestTemplate restTemplate = new RestTemplate();

    public void deleteCategory(int id) {
        restTemplate.delete(urlCoreProduct + "/" + id);
    }

}