package com.felipepsaugusto.gestaocustos.useCases;

import com.felipepsaugusto.gestaocustos.entity.Despesa;
import com.felipepsaugusto.gestaocustos.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BuscarDespesaUseCase {

    @Autowired
    private DespesaRepository despesaRepository;

    public List<Despesa> execute(String email, LocalDate date){
        if(date != null){
            return despesaRepository.findByEmailAndData(email, date);
        }else{
            return despesaRepository.findByEmail(email);
        }
    }
}
