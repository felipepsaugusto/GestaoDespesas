package com.felipepsaugusto.gestaocustos.useCases;

import com.felipepsaugusto.gestaocustos.entity.Despesa;
import com.felipepsaugusto.gestaocustos.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroDespesaUseCase {

    @Autowired
    private DespesaRepository despesaRepository;

    public void execute(Despesa despesa){
        System.out.println("Antes de salvar");
        System.out.println(despesa);
        System.out.println("Depois");
        despesa = despesaRepository.save(despesa);
        System.out.println(despesa);
    }
}
