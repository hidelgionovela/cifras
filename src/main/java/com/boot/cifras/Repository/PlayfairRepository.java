package com.boot.cifras.Repository;

import org.springframework.stereotype.Repository;

import com.boot.cifras.Model.Playfair;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PlayfairRepository extends JpaRepository<Playfair, Integer> {

}
