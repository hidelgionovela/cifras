package com.boot.cifras.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "colunar")
public class Colunar extends AbstractEntity<Long> {

         @Column(name = "textoSimples", nullable = true, length = 500)
         private String textoSimples;
         @Column(name = "chave", nullable = true, length = 500)
         private String chave;
         @Column(name = "textoCifrado", nullable = true, length = 500)
         private String textoCifrado;
         @Column(name = "textoDecifrado", nullable = true, length = 500)
         private String textoDecifrado;

         public String getTextoSimples() {
                  return textoSimples;
         }

         public void setTextoSimples(String textoSimples) {
                  this.textoSimples = textoSimples;
         }

         public String getChave() {
                  return chave;
         }

         public void setChave(String chave) {
                  this.chave = chave;
         }

         public String getTextoCifrado() {
                  return textoCifrado;
         }

         public void setTextoCifrado(String textoCifrado) {
                  this.textoCifrado = textoCifrado;
         }

         public String getTextoDecifrado() {
                  return textoDecifrado;
         }

         public void setTextoDecifrado(String textoDecifrado) {
                  this.textoDecifrado = textoDecifrado;
         }

}
