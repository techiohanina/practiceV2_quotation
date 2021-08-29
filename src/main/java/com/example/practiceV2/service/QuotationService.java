package com.example.practiceV2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practiceV2.domain.Quotation;
import com.example.practiceV2.repository.QuotationRepository;

@Service
public class QuotationService {
    @Autowired
    private QuotationRepository puotationRepository;

    public List<Quotation> findAll() {
        return puotationRepository.findAll();
    }

    public Quotation findOne(Long id) {
        // メソッド名がfindOneからfindByIdに変わった
        // Optionalを返すようになったので取得できなかった場合の処理`.orElse(null)`を追加
        return puotationRepository.findById(id).orElse(null);
    }

    public Quotation save(Quotation puotation) {
        return puotationRepository.save(puotation);
    }

    public void delete(Long id) {
        // メソッド名がdeleteからdeleteByIdに変わった       
        puotationRepository.deleteById(id);
    }
}