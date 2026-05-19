package com.felipepsaugusto.gestaocustos.controller;

import com.felipepsaugusto.gestaocustos.custommessage.ErrorMessage;
import com.felipepsaugusto.gestaocustos.entity.Despesa;
import com.felipepsaugusto.gestaocustos.useCases.BuscarDespesaUseCase;
import com.felipepsaugusto.gestaocustos.useCases.CadastroDespesaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/gestao")
public class GestaoDespesaController {

    @Autowired
    private CadastroDespesaUseCase cadastroDespesaUseCase;
    @Autowired
    private BuscarDespesaUseCase buscarDespesaUseCase;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Despesa despesa) {
       try{
           var result = cadastroDespesaUseCase.execute(despesa);
           return ResponseEntity.ok(result);
       }catch (IllegalArgumentException e){
           var errorMessage = new ErrorMessage(e.getMessage(), "INVALID_PARAMS");
           return ResponseEntity.status(400).body(errorMessage);
       }
    }

    @GetMapping("/findByEmailAndDate/{email}")
    public List<Despesa> findByEmailAndDate(@PathVariable String email, @RequestParam(required = false) LocalDate data){
        return buscarDespesaUseCase.execute(email, data);
    }
}
