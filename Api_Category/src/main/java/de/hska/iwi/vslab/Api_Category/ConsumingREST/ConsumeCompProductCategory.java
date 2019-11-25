package de.hska.iwi.vslab.Api_Category.ConsumingREST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;


public class ConsumeCompProductCategory {

    //private String urlCoreProduct = "http://localhost:8081//comp_product_category/category";

    private static final Logger log = LoggerFactory.getLogger(ConsumeCompProductCategory.class);
    RestTemplate restTemplate = new RestTemplate();

    public void deleteCategory(int id) {
        try {
            UrlBuilder urlBuilder = new UrlBuilder();
            log.info("URL:" + urlBuilder.getCompositeServiceUrl_withId(id));
            restTemplate.delete(urlBuilder.getCompositeServiceUrl_withId(id));
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

}