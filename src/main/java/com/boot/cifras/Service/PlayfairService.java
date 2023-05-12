package com.boot.cifras.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.cifras.Model.Playfair;
import com.boot.cifras.Repository.PlayfairRepository;

@Service
public class PlayfairService {

         @Autowired
         private PlayfairRepository cifrasRepository;

         public void save(Playfair c) {
                  cifrasRepository.save(c);
         }

         public Playfair getCifraById(Integer id) {
                  return cifrasRepository.findById(id).get();
         }

         

}
