package shulz.lab4.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shulz.lab4.entities.Product;
import shulz.lab4.services.ProductService;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public String getProductById(Model uiModel, @PathVariable int id) {
        Product product = productService.getProductById(id);
        uiModel.addAttribute("product", product);
        return "product";
    }

    @GetMapping()
    public String getProductList(Model uiModel) {
        List<Product> productList = productService.getProductList();
        uiModel.addAttribute("productList", productList);
        return "productList";
    }

    @GetMapping("/new")
    public String addProduct(Model uiModel) {
        uiModel.addAttribute("product", new Product());
        return "product-form";
    }

    @PostMapping("/new")
    public String processForm(Model uiModel, @ModelAttribute("product") Product product) {
        productService.addProduct(product);
        return "redirect:/product";
    }
}

