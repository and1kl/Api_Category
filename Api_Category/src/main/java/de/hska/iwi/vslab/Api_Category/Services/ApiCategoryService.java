package de.hska.iwi.vslab.Api_Category.Services;

import org.springframework.stereotype.Service;

import de.hska.iwi.vslab.Api_Category.ConsumingREST.Category;
import de.hska.iwi.vslab.Api_Category.ConsumingREST.ConsumeCompProductCategory;
import de.hska.iwi.vslab.Api_Category.ConsumingREST.ConsumeCoreCategory;

/**
 * The implementation of the service.
 */
@Service
public class ApiCategoryService {

    ConsumeCompProductCategory compProductCategory = new ConsumeCompProductCategory();

    public void deleteCategory(int id) {
        compProductCategory.deleteCategory(id);
    }

    ConsumeCoreCategory coreCategory = new ConsumeCoreCategory();

    public Category getCategory(int id) {
        return coreCategory.getCategory(id);
    }

    public Category[] getCategories() {
        return coreCategory.getCategories();
    }

    public void postCategory(String name) {
        coreCategory.addCategory(new Category(-1, name));
    }

    public void updateCategory(int id, String name) {
        Category cat = new Category(id, name);
        coreCategory.updateCategory(cat);
    }

}
