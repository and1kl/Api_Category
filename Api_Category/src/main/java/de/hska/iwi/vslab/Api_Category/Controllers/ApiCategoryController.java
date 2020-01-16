package de.hska.iwi.vslab.Api_Category.Controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import de.hska.iwi.vslab.Api_Category.ConsumingREST.Category;
import de.hska.iwi.vslab.Api_Category.Services.ApiCategoryService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableCircuitBreaker
public class ApiCategoryController {

    @Autowired
    private ApiCategoryService apiCategoryService;

    private static final Logger log = LoggerFactory.getLogger(ApiCategoryController.class);

    @PostMapping(path = "/category", consumes = "application/json")
    //@HystrixCommand(fallbackMethod = "fallbackAddCategory")
    public void addCategory(@RequestBody(required = true) Category request) {
        log.info("addCategory(name) was called");
        apiCategoryService.postCategory(request.getName());
    }

    public void fallbackAddCategory(Category category, Throwable throwable) {
        System.out.printf("DefaultFallback, exception=%s%n", throwable);
    }

    /**
     * Delete a category and all products that were in that category.
     */
    @DeleteMapping("/category/{id}")
    //@HystrixCommand(fallbackMethod = "defaultFallbackWithId")
    public void deleteCategory(@PathVariable int id) {
        log.info("deleteCategory(id) was called");
        apiCategoryService.deleteCategory(id);
    }

    @GetMapping("/category")
    @HystrixCommand(fallbackMethod = "fallbackGetCategories")
    public Category[] getCategories() {
        log.info("getCategoires() was called");
        return apiCategoryService.getCategories();
    }

    public Category[] fallbackGetCategories() {
        Category category1 = new Category(1, "fallbackCategory1");
        Category category2 = new Category(2, "fallbackCategory2");
        Category[] categoryA = new Category[2];
        categoryA[0] = category1;
        categoryA[1] = category2;
        return categoryA;
    }

    @GetMapping("/category/{id}")
    //@HystrixCommand(fallbackMethod = "fallbackGetCategory")
    public Category getCategory(@PathVariable int id) {
        log.info("getCategory(id) was called");
        return apiCategoryService.getCategory(id);
    }

    public Category fallbackGetCategory() {
        Category category = new Category(1, "fallbackCategory1");
        return category;
    }

    @PutMapping(path = "/category/{id}", consumes = "application/json")
    //@HystrixCommand(fallbackMethod = "defaultFallbackWithId")
    public void updateCategory(@PathVariable int id, @RequestBody(required = true) Category request) {
        log.info("updateCategory(int id, String name) was called");
        apiCategoryService.updateCategory(request.getId(), request.getName());
    }

    public void defaultFallback(Throwable throwable) {
        System.out.printf("DefaultFallback, exception=%s%n", throwable);
    }

    public void defaultFallbackWithId(int id, Throwable throwable) {
        System.out.printf("DefaultFallbackWithId, id=%s, exception=%s%n", id, throwable);
    }

}
