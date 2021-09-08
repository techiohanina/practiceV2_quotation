package com.example.practiceV2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.practiceV2.domain.Quotation;
import com.example.practiceV2.service.QuotationService;

@Controller
//@RestController
@RequestMapping("/quotations") // ①
public class QuotationController {
    @Autowired
    private QuotationService quotationService;

    @GetMapping
    public String index(Model model) { // ②
        List<Quotation> quotations = quotationService.findAll();
        model.addAttribute("quotations", quotations); // ③
        return "quotations/index"; // ④
    }

    @GetMapping("new")
    public String newQuotation(Model model) {
        return "quotations/new";
    }


    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) { // ⑤
        Quotation quotation = quotationService.findOne(id);
        model.addAttribute("quotation", quotation);
        return "quotations/edit";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        Quotation quotation = quotationService.findOne(id);
        model.addAttribute("quotation", quotation);
        return "quotations/show";
    }

    /*randomなレコードを表示
    @GetMapping("random")
    public String random(Model model) {
        Quotation quotation = quotationService.findOne(id);
        model.addAttribute("quotation", quotation);
        return "quotations/show";
*/

    @PostMapping
    public String create(@ModelAttribute Quotation quotation) { // ⑥
        quotationService.save(quotation);
        return "redirect:/quotations"; // ⑦
    }

    @PutMapping("{id}")
    public String update(@PathVariable Long id, @ModelAttribute Quotation quotation) {
        quotation.setId(id);
        quotationService.save(quotation);
        return "redirect:/quotations";
    }

    @DeleteMapping("{id}")
    public String destroy(@PathVariable Long id) {
        quotationService.delete(id);
        return "redirect:/quotations";
    }
}