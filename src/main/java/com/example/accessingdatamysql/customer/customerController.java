package com.example.accessingdatamysql.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Controller
public class customerController {

    private final customerRepository customerRepository;

    @Autowired
    public customerController(customerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("addcustomer")
    public String inputcustomer(Model model) {
        model.addAttribute("mycustomer", new customer());
        return "greetingcustomer";
    }

    @PostMapping("addcustomer")
    public String greetingSubmit(@ModelAttribute customer mycustomer, Model model) {
        model.addAttribute("mycustomer", mycustomer);
        customer customer = new customer();
        customer.setCust_ID(mycustomer.getCust_ID());
        customer.setCust_Address(mycustomer.getCust_Address());
        customer.setCust_Name(mycustomer.getCust_Name());
        customer.setCust_Phone(mycustomer.getCust_Phone());
        customerRepository.save(customer);
        return "resultcustomer";
    }

    @GetMapping(path = "/allcustomers")
    public @ResponseBody
    Iterable<customer> getAllcustomer() {
        return customerRepository.findAll();
    }

    @GetMapping(path = "/customers")
    public String getcustomer(Model model) {
        final Iterable<customer> all = customerRepository.findAll();
        List<customer> list = new ArrayList<>();
        all.forEach(customer -> list.add(customer));
        model.addAttribute("customers", list);
        return "showcust";
    }

    @GetMapping("/findcustomer")
    public String findcustomer(Model model) {
        model.addAttribute("mycustomer", new customer());
        return "findcustomer";
    }

    @PostMapping("/findcustomer")
    public String findCustomerbyId(@ModelAttribute customer mycustomer, Model model) {
        final Optional<customer> id = customerRepository.findById(mycustomer.getCust_ID());
        if (id.isPresent()) {
            model.addAttribute("customer", id.get());
            return "singlecust";
        }
        return "Empty";
    }

    @GetMapping("/delcustomer")
    public String delcustomer(Model model) {
        model.addAttribute("mycustomer", new customer());
        return "delcustomer";
    }

    @PostMapping("/delcustomer")
    public String deleteCustomer(@ModelAttribute customer mycustomer, Model model) {
        model.addAttribute("mycustomer", mycustomer);
        customerRepository.deleteById(mycustomer.getCust_ID());
        return "resultdelcustomer";
    }

    @GetMapping("/error")
    public String errorPage(Model model) {
        return "error";
    }
    
}
