package com.felipepsaugusto.gestaocustos.performance;

import com.felipepsaugusto.gestaocustos.entity.Despesa;
import com.felipepsaugusto.gestaocustos.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

//component retirado
public class GestaoDeDespesaSeeder implements CommandLineRunner {

    @Autowired
    private DespesaRepository despesaRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Geraçao de seeds iniciada");
        for(int c = 0; c < 15000; c++){
            Despesa despesa = new Despesa();
            despesa.setEmail("performance@gmail");
            despesa.setCategoria("Teste");
            despesa.setData(LocalDate.now().minusDays((c % 30)));
            despesa.setValor(BigDecimal.valueOf(10 + (c % 50)));
            despesa.setDescricao("Gasto n°: " + c);
            despesaRepository.save(despesa);
        }
        System.out.println("Geração de seeds feita");
    }
}
