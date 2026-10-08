package com.sigep.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sigep.model.Pedido;

@Repository
public interface IPedidoRepository extends JpaRepository<Pedido, Integer> {
}