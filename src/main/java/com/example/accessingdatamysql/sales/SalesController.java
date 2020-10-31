package com.example.accessingdatamysql.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SalesController {
    private final SalesRepository salesRepository;

    @Autowired
    public SalesController(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    @GetMapping("/addsales")
    public String inputSales(Model model) {
        model.addAttribute("mySales", new Sales());
        return "addSales";
    }

    @PostMapping("/addsales")
    public String greetingSubmit(@ModelAttribute Sales mySales, Model model) {
        model.addAttribute("mySales", mySales);
        Sales Sales = new Sales();
        Sales.setSales_ID(mySales.getSales_ID());
        Sales.setCust_ID(mySales.getCust_ID());
        Sales.setProd_ID(mySales.getProd_ID());
        salesRepository.save(Sales);
        return "resultSales";
    }

    @GetMapping(path = "/allsales")
    public @ResponseBody
    Iterable<Sales> getAllSales() {
        return salesRepository.findAll();
    }

    @GetMapping(path = "/sales")
    public String getcustomer(Model model) {
        List<Sales> list = new ArrayList<>();
        salesRepository.findAll().forEach(list::add);
        model.addAttribute("sales", list);
        return "showsales";
    }

    @GetMapping("/findsales")
    public String findsales(Model model) {
        model.addAttribute("mysales", new Sales());
        return "findsales";
    }

    @PostMapping("/findsales")
    public @ResponseBody
    Sales findsalesbyId(@ModelAttribute Sales mysales, Model model) {
        return salesRepository.findById(mysales.getSales_ID()).get();
    }

    @GetMapping("/delsales")
    public String delsales(Model model) {
        model.addAttribute("mysales", new Sales());
        return "delsales";
    }

    @PostMapping("/delsales")
    public String deletesales(@ModelAttribute Sales mysales, Model model) {
        model.addAttribute("mysales", mysales);
        salesRepository.deleteById(mysales.getSales_ID());
        return "resultdelsales";
    }
    

}

