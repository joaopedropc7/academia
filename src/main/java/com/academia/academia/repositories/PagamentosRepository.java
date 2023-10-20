package com.academia.academia.repositories;

import com.academia.academia.models.ClientModel;
import com.academia.academia.models.PagamentosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PagamentosRepository extends JpaRepository<PagamentosModel, Integer> {

    @Query("SELECT p FROM PagamentosModel p " +
            "WHERE p.client = :cliente " +
            "AND p.dataPagamento = (SELECT MAX(pp.dataPagamento) FROM PagamentosModel pp WHERE pp.client = :cliente)")
    PagamentosModel findLastPaymentByClient(@Param("cliente") ClientModel cliente);

}
