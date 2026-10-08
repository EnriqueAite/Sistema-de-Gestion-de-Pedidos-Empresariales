package com.sigep.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sigep.model.MovimientoStock;

@Repository
public interface IMovimientoStockRepository extends JpaRepository<MovimientoStock, Integer> {
}