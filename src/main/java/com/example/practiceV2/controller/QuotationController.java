package com.example.practiceV2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.practiceV2.domain.Quotation;
import com.example.practiceV2.service.QuotationService;

//@Controller
@RestController
@RequestMapping("/quotations")
public class QuotationController {
    @Autowired
    private QuotationService quotationService;

    //一覧を取得
    @GetMapping
    public List<Quotation> index() {
        List<Quotation> quotations = quotationService.findAll();
        //    model.addAttribute("quotations", quotations);
        //    return "quotations/index";
        return quotations;
    }

    /*新規画面に遷移
    @GetMapping("new")
    public String newQuotation(Model model) {
        return "quotations/new";
    }*/

    //編集画面に遷移
    /*
    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) { // ⑤
        Quotation quotation = quotationService.findOne(id);
        model.addAttribute("quotation", quotation);
        return "quotations/edit";

    }*/

    //特定のidを返却
    @GetMapping("{id}")
    public Quotation show(@PathVariable Long id) {
        Quotation quotation = quotationService.findOne(id);
    //     model.addAttribute("quotation", quotation);
    //    return "quotations/show";
          return quotation;
    }

    //randomなレコードを表示
    @GetMapping("random")
    public Quotation random() {
        int r = new java.util.Random().nextInt(quotationService.findAll().size());
        r += 1;
        Quotation quotation = quotationService.findOne((long) r);
        //model.addAttribute("quotation", quotation);
        return quotation;
    }

    //新規作成
    @PostMapping(path = "/create",produces = MediaType.APPLICATION_JSON_VALUE)
    public Quotation create(@RequestBody Quotation quotation) {
        quotationService.save(quotation);
        //System.out.println(quotation);
        return quotation;
    }

    //編集したデータの保存
    @PutMapping(path = "{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Quotation update(@PathVariable Long id, @RequestBody Quotation quotation) {
        quotation.setId(id);
        quotationService.save(quotation);
        return quotation;
    }

    //特定のidを削除
    @DeleteMapping("{id}")
    public Quotation destroy(@PathVariable Long id) {
        Quotation quotation = quotationService.findOne(id);
        quotationService.delete(id);
        return quotation;
    }
}
