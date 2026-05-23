package com.felipepsaugusto.gestaocustos.repository;

import com.felipepsaugusto.gestaocustos.entity.Despesa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, UUID> {
    List<Despesa> findByEmail(String email);
    List<Despesa> findByEmailAndData(String email, LocalDate data);
    Page<Despesa> findByEmail(String email, Pageable pageable);
}
