package com.boot.cifras.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.boot.cifras.Model.Cifras;
import com.boot.cifras.Service.CifrasService;

@Controller
// @RequestMapping("/cesar")
public class CesarController {

  @Autowired
  private CifrasService cifrasservice;

  @GetMapping("/cesarHome")
  public String home() {
    return "cesar/index";
  }

  @PostMapping("/saveCesar")
  public String add(Cifras c) {

    String palavra = c.getTextoSimples().toUpperCase();
    int deslocamento = 3;
    String palavraCifrada = "";

    for (int i = 0; i < palavra.length(); i++) {
      char caractere = palavra.charAt(i);
      if (caractere != ' ') {

        if (caractere >= 'a' && caractere <= 'z') {
          caractere = (char) ((caractere - 'a' + deslocamento) % 26 + 'a');
        } else if (caractere >= 'A' && caractere <= 'Z') {
          caractere = (char) ((caractere - 'A' + deslocamento) % 26 + 'A');
        }
        palavraCifrada += caractere;
      }
    }

    c.setCesar(palavraCifrada);

    cifrasservice.save(c);

    return "redirect:/resultadoCesar/" + c.getId();

  }

  @GetMapping("/resultadoCesar/{id}")
  public ModelAndView dados(@PathVariable("id") int id, Model model) {
    Cifras c = cifrasservice.getCifraById(id);
    model.addAttribute("cifra", c);

    ModelAndView m = new ModelAndView();

    m.setViewName("/cesar/resultado");

    return m;

  }

}
