package com.felipepsaugusto.gestaocustos.repository;

import com.felipepsaugusto.gestaocustos.entity.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, UUID> {
}
