package com.boot.cifras.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "critografia")
public class Cifras extends AbstractEntity<Long> {

         
         @Column(name = "textoSimples", nullable = true, length = 500)
         private String textoSimples;
         @Column(name = "cesar", nullable = true, length = 500)
         private String cesar;
         @Column(name = "hill", nullable = true, length = 500)
         private String hill;
         @Column(name = "vigenere", nullable = true, length = 500)
         private String vigenere;

         

         public String getCesar() {
                  return cesar;
         }
         public void setCesar(String cesar) {
                  this.cesar = cesar;
         }
         public String getHill() {
                  return hill;
         }
         public void setHill(String hill) {
                  this.hill = hill;
         }
         public String getVigenere() {
                  return vigenere;
         }
         public void setVigenere(String vigenere) {
                  this.vigenere = vigenere;
         }
         public String getTextoSimples() {
                  return textoSimples;
         }
         public void setTextoSimples(String textoSimples) {
                  this.textoSimples = textoSimples;
         }
         
         
         

}
