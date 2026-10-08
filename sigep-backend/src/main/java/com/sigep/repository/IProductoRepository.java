package com.sigep.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sigep.model.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer> {
}