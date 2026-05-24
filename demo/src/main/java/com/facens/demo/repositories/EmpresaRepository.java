package com.facens.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.facens.demo.models.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, String> {

}
