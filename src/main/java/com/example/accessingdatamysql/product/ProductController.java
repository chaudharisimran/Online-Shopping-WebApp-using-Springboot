package com.example.accessingdatamysql.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class ProductController {

    private final productRepository productRepository;

    @Autowired
    public ProductController(productRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/addproduct")
    public String inputproduct(Model model) {
        model.addAttribute("myproduct", new product());
        return "greetingproduct";
    }

    @PostMapping("/addproduct")
    public String greetingSubmit(@ModelAttribute product myproduct, Model model) {
        model.addAttribute("myproduct", myproduct);
        product product = new product();
        product.setProd_ID(myproduct.getProd_ID());
        product.setColour(myproduct.getColour());
        product.setCompany(myproduct.getCompany());
        product.setPrice(myproduct.getPrice());
        product.setProd_Name(myproduct.getProd_Name());
        product.setSize(myproduct.getSize());
        productRepository.save(product);
        return "resultproduct";
    }

    @GetMapping(path = "/allproducts")
    public @ResponseBody
    Iterable<product> getAllProduct() {
        return productRepository.findAll();
    }

    @GetMapping("/products")
    public String getproduct(Model model) {
        final ArrayList<product> products = new ArrayList<>();
        productRepository.findAll().forEach(product -> products.add(product));
        model.addAttribute("products", products);
        return "showproduct";
    }

    @GetMapping("/")
    public String products(Model model) {
        final ArrayList<product> products = new ArrayList<>();
        productRepository.findAll().forEach(product -> products.add(product));
        model.addAttribute("products", products);
        return "productview";
    }


    @GetMapping("/findproduct")
    public String findproduct(Model model) {
        model.addAttribute("myproduct", new product());
        return "findproduct";
    }

    @PostMapping("/findproduct")
    public @ResponseBody
    product findproductbyId(@ModelAttribute product myproduct, Model model) {
        return productRepository.findById(myproduct.getProd_ID()).get();
    }

    @GetMapping("/delproduct")
    public String delproduct(Model model) {
        model.addAttribute("myproduct", new product());
        return "delproduct";
    }

    @PostMapping("/delproduct")
    public String deleteproduct(@ModelAttribute product myproduct, Model model) {
        model.addAttribute("myproduct", myproduct);
        productRepository.deleteById(myproduct.getProd_ID());
        return "resultdelproduct";
    }
}
