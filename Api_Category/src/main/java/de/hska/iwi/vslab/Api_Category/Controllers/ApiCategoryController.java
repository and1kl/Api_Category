package de.hska.iwi.vslab.Api_Category.Controllers;

import de.hska.iwi.vslab.Api_Category.ConsumingREST.Category;
import de.hska.iwi.vslab.Api_Category.Services.ApiCategoryService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiCategoryController {

    @Autowired
    private ApiCategoryService apiCategoryService;

    private static final Logger log = LoggerFactory.getLogger(ApiCategoryController.class);

    @PostMapping(path = "/category", consumes = "application/json")
    public void addCategory(@RequestBody(required = true) Category request) {
        log.info("addCategory(name) was called");
        apiCategoryService.postCategory(request.getName());
    }

    /**
     * Delete a category and all products that were in that category.
     */
    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable int id) {
        log.info("deleteCategory(id) was called");
        apiCategoryService.deleteCategory(id);
    }

    @GetMapping("/category")
    public Category[] getCategories() {
        log.info("getCategoires() was called");
        return apiCategoryService.getCategories();
    }

    @GetMapping("/category/{id}")
    public Category getCategory(@PathVariable int id) {
        log.info("getCategory(id) was called");
        return apiCategoryService.getCategory(id);
    }

    @PutMapping(path = "/category/{id}", consumes = "application/json")
    public void updateCategory(@PathVariable int id, @RequestBody(required = true) Category request) {
        log.info("updateCategory(int id, String name) was called");
        apiCategoryService.updateCategory(request.getId(), request.getName());
    }

}
