package com.crudexample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudexample.models.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>{



}
