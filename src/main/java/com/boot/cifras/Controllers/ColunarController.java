package com.boot.cifras.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.boot.cifras.Model.Colunar;
import com.boot.cifras.Service.ColunarService;

@Controller
public class ColunarController {


         @Autowired
         private ColunarService cifrasservice;

         @GetMapping("/colunarHome")
         public String home() {
                  return "colunar/index";
         }

         @PostMapping("/saveColunar")
         public String add(Colunar p) {

                  String textoClaro = p.getTextoSimples();
                  String chave = p.getChave();

                  TransposicaoColunar teste = new TransposicaoColunar(chave);
        
                  String textoSimples = teste.removerEspacos(textoClaro);
                  System.out.println(textoSimples);
          //        Todo: A chave nao pode ter letras repetidas.       
                  
                  // String result = teste.cifrar(textoSimples, chave);
                  String result = teste.cifrar(textoSimples, chave);
                  p.setTextoCifrado(result);
                  p.setTextoDecifrado(textoSimples);
                  cifrasservice.save(p);
                  return "redirect:/resultadoColunar/"+p.getId();

         }

         @GetMapping("/resultadoColunar/{id}")
         public ModelAndView dados(@PathVariable("id") int id, Model model) {
                  Colunar c = cifrasservice.getCifraById(id);
                  model.addAttribute("cifra", c);

                  ModelAndView m = new ModelAndView();

                  m.setViewName("/colunar/resultado");

                  return m;

         }
}
