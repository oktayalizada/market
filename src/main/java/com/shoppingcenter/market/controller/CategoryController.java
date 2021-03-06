package com.shoppingcenter.market.controller;


import com.shoppingcenter.market.dto.CategoryDto;
import com.shoppingcenter.market.service.CategoryService;
import com.shoppingcenter.market.utils.CategoryConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/shop")
public class CategoryController {
    private CategoryService categoryService;
    private CategoryConversion categoryConversion;
    @Autowired
    public CategoryController(CategoryService categoryService, CategoryConversion categoryConversion) {
        this.categoryService=categoryService;
        this.categoryConversion=categoryConversion;
    }

    @PostMapping("/categories")
    public ResponseEntity<CategoryDto> createNewCategory(@RequestBody CategoryDto categoryDto){

       return new ResponseEntity<>(
               categoryConversion.
                       toCategoryDto(categoryService.saveCategory(categoryConversion.toCategory(categoryDto))), HttpStatus.CREATED);
    }

    @GetMapping("/categories/{categoryId}")
    public ResponseEntity<CategoryDto> getCategory(){
        return null;
    }


    @DeleteMapping("/categories/{categoryId}")
    public ResponseEntity<CategoryDto> deleteCategory(){
        return null;

    }

    @PutMapping("/categories/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(){
        return null;

    }

    /*@PatchMapping("/categories/{categoryId}")
    public ResponseEntity<CategoryDto> patchCategory(){
        return null;
    }
*/
}
