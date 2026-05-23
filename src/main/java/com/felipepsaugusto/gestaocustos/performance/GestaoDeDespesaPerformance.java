package com.felipepsaugusto.gestaocustos.performance;

import com.felipepsaugusto.gestaocustos.entity.Despesa;
import com.felipepsaugusto.gestaocustos.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@EnableCaching
@RestController
@RequestMapping("/gestao/performance")
public class GestaoDeDespesaPerformance {

    @Autowired
    private DespesaRepository despesaRepository;

    @GetMapping("/listar-sempaginacao")
    public ResponseEntity<List<Despesa>> listarSemPaginacao() {
        long inicio = System.currentTimeMillis();
        var lista = despesaRepository.findAll();
        long fim = System.currentTimeMillis();
        System.out.println("Tempo levado em ms: " + (fim - inicio));
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/com-paginacao/{email}")
    public ResponseEntity<Page<Despesa>> listarComPaginacao(@PathVariable String email, Pageable pageable) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        var lista = despesaRepository.findByEmail(email, pageable);
        stopWatch.stop();
        System.out.println("Tempo levado em ms: " + stopWatch.getTotalTimeMillis());
        return ResponseEntity.ok(lista);
    }

    @Cacheable(value = "gastosPorEmailCache", key = "#email + '-' + #pageable.pageNumber + '-' + #pageable.pageSize + '-'")
    @GetMapping("/cache/{email}")
    public ResponseEntity<Page<Despesa>> cacheComPaginacao(@PathVariable String email, Pageable pageable) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        var lista = despesaRepository.findByEmail(email, pageable);
        stopWatch.stop();
        System.out.println("Tempo levado em ms: " + stopWatch.getTotalTimeMillis());
        return ResponseEntity.ok(lista);
    }
}
