package com.example.BYSell.controller;

import com.example.BYSell.models.Product;
import com.example.BYSell.services.ProductServices;
import com.sun.tools.jconsole.JConsoleContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductServices productServices;



    @GetMapping({"/",""})
    public String products(@RequestParam(name="title", required = false) String title, Model model) {
        model.addAttribute("products",productServices.list(title));
        return "products";
    }
    @GetMapping("/product/{id}")
    public String productInfo(Model model, @PathVariable Long id) {

        Product product = productServices.getProductById(id);
        System.out.println("========>"+product);
        model.addAttribute("product",product);
        model.addAttribute("images", product.getImages());
        return "productInfo";
    }
    @PostMapping("/product/create")
    public String createProduct(@RequestParam("file1")MultipartFile file1,
                                @RequestParam("file2")MultipartFile file2,
                                @RequestParam("file3")MultipartFile file3,
                                Product product) throws IOException {
        productServices.saveProduct(product,file1,file2,file3);
        return "redirect:/";
    }
    @PostMapping("/product/delete/{id}")
    public String  deleteProduct (@PathVariable long id) {
        productServices.deleteProduct(id);
        return "redirect:/";
    }
}
