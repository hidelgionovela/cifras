package com.boot.cifras.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.cifras.Model.Colunar;
import com.boot.cifras.Repository.ColunarRepository;

@Service
public class ColunarService {

         @Autowired
         private ColunarRepository cifrasRepository;

         public void save(Colunar c) {
                  cifrasRepository.save(c);
         }

         public Colunar getCifraById(Integer id) {
                  return cifrasRepository.findById(id).get();
         }

         

}
