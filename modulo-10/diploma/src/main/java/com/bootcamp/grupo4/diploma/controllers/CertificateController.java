package com.bootcamp.grupo4.diploma.controllers;

import com.bootcamp.grupo4.diploma.dtos.CertificateDTO;
import com.bootcamp.grupo4.diploma.dtos.StudentDTO;
import com.bootcamp.grupo4.diploma.services.CertificateService;
import com.bootcamp.grupo4.diploma.services.CertificateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/analyzeNotes")
public class CertificateController {

    private final CertificateService certificateService;

    @Autowired
    public CertificateController(CertificateService certificateService) {
        this.certificateService = certificateService;
    }

    @PostMapping
    public ResponseEntity<CertificateDTO> createCertificate(@Valid @RequestBody StudentDTO studentDTO) {
        CertificateDTO certificateDTO = certificateService.analyzeNotes(studentDTO);

        return new ResponseEntity<>(certificateDTO, HttpStatus.CREATED);
    }
}
