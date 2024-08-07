package com.infuse.rikteste.repository;

import com.infuse.rikteste.model.Pedido;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    boolean existsByNumeroControle(String numeroControle);

    List<Pedido> findByNumeroControle(String numeroControle);

    List<Pedido> findByDataCadastro(LocalDate dataCadastro);

    List<Pedido> findByNumeroControleAndDataCadastro(String numeroControle, LocalDate dataCadastro);

}
