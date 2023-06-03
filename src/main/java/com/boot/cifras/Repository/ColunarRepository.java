package com.boot.cifras.Repository;

import org.springframework.stereotype.Repository;

import com.boot.cifras.Model.Colunar;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ColunarRepository extends JpaRepository<Colunar, Integer> {

}
