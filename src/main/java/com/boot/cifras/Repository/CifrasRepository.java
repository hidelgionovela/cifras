package com.boot.cifras.Repository;

import org.springframework.stereotype.Repository;

import com.boot.cifras.Model.Cifras;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CifrasRepository extends JpaRepository<Cifras, Integer> {

}
