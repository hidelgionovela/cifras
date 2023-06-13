package com.boot.cifras.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.boot.cifras.Model.Playfair;
import com.boot.cifras.Service.PlayfairService;

@Controller
public class PlayfairController {

         @Autowired
         private PlayfairService cifrasservice;

         @GetMapping("/playfairHome")
         public String home() {
                  return "playfair/index";
         }

         @PostMapping("/savePlayfair")
         public String add(Playfair p) {

                  String textoClaro = p.getTextoSimples();
                  String chave = p.getChave();
                  boolean changeJtoI = true;

                  PlayfairCipher pf = new PlayfairCipher();

                  pf.createTable(chave, changeJtoI);
                  String enc = pf.encode(pf.prepareText(textoClaro, changeJtoI));
                  p.setTextoCifrado(enc);
                  String dec = pf.decode(enc);
                  p.setTextoDecifrado(dec);

                  cifrasservice.save(p);

                  return "redirect:/resultadoPlayfair/" + p.getId();

         }

         @GetMapping("/resultadoPlayfair/{id}")
         public ModelAndView dados(@PathVariable("id") int id, Model model) {
                  Playfair c = cifrasservice.getCifraById(id);
                  model.addAttribute("cifra", c);

                  ModelAndView m = new ModelAndView();

                  m.setViewName("/playfair/resultado");

                  return m;

         }
}
