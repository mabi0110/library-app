package com.example.library.web.admin;

import com.example.library.domain.category.CategoryService;
import com.example.library.domain.category.dto.CategoryDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CategoryManagementController {

    private final CategoryService categoryService;

    public CategoryManagementController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/admin/add-category")
    public String addCategoryForm(Model model) {
        CategoryDto category = new CategoryDto();
        model.addAttribute("category", category);
        return "admin/category-form";
    }

    @PostMapping("/admin/add-category")
    public String addCategory(CategoryDto category, RedirectAttributes redirectAttributes) {
        categoryService.addCategory(category);
        redirectAttributes.addFlashAttribute(AdminController.NOTIFICATION_ATTRIBUTE, "Category %s was saved".formatted(category.getName()));
        return "redirect:/admin";
    }
}
