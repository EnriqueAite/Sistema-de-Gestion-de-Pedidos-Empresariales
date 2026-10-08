package com.sigep.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sigep.model.Empresa;

@Repository
public interface IEmpresaRepository extends JpaRepository<Empresa, Integer> {
}