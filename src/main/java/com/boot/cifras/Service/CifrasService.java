package com.boot.cifras.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.cifras.Model.Cifras;
import com.boot.cifras.Repository.CifrasRepository;

@Service
public class CifrasService {

         @Autowired
         private CifrasRepository cifrasRepository;

         public void save(Cifras c) {
                  cifrasRepository.save(c);
         }

         public List<Cifras> getAllCifras() {
                  return cifrasRepository.findAll();
         }

         public Cifras getCifraById(Integer id) {
                  return cifrasRepository.findById(id).get();
         }

         // public void deleteById(int id) {
         // cifrasRepository.deleteById(id);

         // }

}
