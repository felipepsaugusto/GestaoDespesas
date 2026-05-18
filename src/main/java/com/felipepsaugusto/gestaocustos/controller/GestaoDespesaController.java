package com.felipepsaugusto.gestaocustos.controller;

import com.felipepsaugusto.gestaocustos.entity.Despesa;
import com.felipepsaugusto.gestaocustos.useCases.CadastroDespesaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gestao")
public class GestaoDespesaController {

    @Autowired
    private CadastroDespesaUseCase cadastroDespesaUseCase;

    @PostMapping("/create")
    public Despesa create(@RequestBody Despesa despesa) {
        return cadastroDespesaUseCase.execute(despesa);
    }
}
