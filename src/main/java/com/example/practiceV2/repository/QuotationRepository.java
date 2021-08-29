package com.example.practiceV2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.practiceV2.domain.Quotation;

@Repository
public interface QuotationRepository extends JpaRepository<Quotation, Long> {

}