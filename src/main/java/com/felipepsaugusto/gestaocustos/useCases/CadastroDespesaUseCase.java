package com.felipepsaugusto.gestaocustos.useCases;

import com.felipepsaugusto.gestaocustos.entity.Despesa;
import com.felipepsaugusto.gestaocustos.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroDespesaUseCase {

    @Autowired
    private DespesaRepository despesaRepository;

    public Despesa execute(Despesa despesa) {
        if (despesa.getCategoria() == null || despesa.getData() == null
                || despesa.getDescricao() == null || despesa.getEmail() == null) {
            throw new IllegalArgumentException("Preencha todos os campos");
        } else {
            despesa = despesaRepository.save(despesa);
            return despesa;
        }
    }
}