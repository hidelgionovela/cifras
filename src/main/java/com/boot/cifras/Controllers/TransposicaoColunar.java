package com.boot.cifras.Controllers;

public class TransposicaoColunar {
         public static char chave[];
         public static int chavePos[];

         /**
          * Construtor da classe TransposicaoColunar.
          * Inicializa os atributos chave e chavePos com base na chave escolhida.
          *
          * @param chaveEscolhida A chave escolhida para a cifra.
          */
         public TransposicaoColunar(String chaveEscolhida) {
                  chavePos = new int[chaveEscolhida.length()];
                  chave = chaveEscolhida.toCharArray();
         }

         /**
          * Construtor adicional da classe TransposicaoColunar.
          * Inicializa os atributos chave e chavePos com base na chave escolhida,
          * substituindo a chave escolhida pelo valor de ggg (ignorando o valor
          * fornecido).
          *
          * @param ggg            Ignorado (não utilizado).
          * @param chaveEscolhida A chave escolhida para a cifra.
          */
         public TransposicaoColunar(String ggg, String chaveEscolhida) {
                  chaveEscolhida = ggg; // Ignora o valor de ggg.
                  chavePos = new int[chaveEscolhida.length()];
                  chave = chaveEscolhida.toCharArray();
         }

         /**
          * Remove os espaços em branco de uma frase.
          *
          * @param frase A frase contendo espaços em branco.
          * @return A frase sem espaços em branco.
          */
         public String removerEspacos(String frase) {
                  return frase.replaceAll("\\s+", "");
         }

         /**
          * Ordena a chave escolhida em ordem alfabética.
          * Atualiza o array chavePos de acordo com a ordem alfabética da chave.
          *
          * @param chaveEscolhida A chave escolhida para a cifra.
          */
         public static void ordenaChave(String chaveEscolhida) {
                  int min, i, j;
                  char chaveOriginal[] = chaveEscolhida.toCharArray();
                  char temp;

                  // Passo 1: Ordena a chave escolhida em ordem alfabética
                  for (i = 0; i < chaveEscolhida.length(); i++) {
                           min = i;
                           for (j = i; j < chaveEscolhida.length(); j++) {
                                    if (chave[min] > chave[j]) {
                                             min = j;
                                    }
                           }

                           if (min != i) {
                                    temp = chave[i];
                                    chave[i] = chave[min];
                                    chave[min] = temp;
                           }
                  }

                  // Passo 2: Preenchendo a posição do array
                  // de acordo com a ordem alfabética
                  // usando loops for aninhados
                  for (i = 0; i < chaveEscolhida.length(); i++) {
                           for (j = 0; j < chaveEscolhida.length(); j++) {
                                    if (chaveOriginal[i] == chave[j]) {
                                             chavePos[i] = j;
                                    }
                           }
                  }
         }

         /**
          * Cifra um texto claro utilizando a chave escolhida.
          *
          * @param textoClaro     O texto claro a ser cifrado.
          * @param chaveEscolhida A chave escolhida para a cifra.
          * @return O texto cifrado.
          */
         public  String cifrar(String textoClaro, String chaveEscolhida) {
                  // int min, i, j;
                  int  i, j;
                  // char chaveOriginal[] = chaveEscolhida.toCharArray();
                  // char temp;
                  ordenaChave(chaveEscolhida);

                  int linha = textoClaro.length() / chaveEscolhida.length();
                  int extrabit = textoClaro.length() % chaveEscolhida.length();
                  int linhaExtra = (extrabit == 0) ? 0 : 1;
                  // int rowtemp = -1;
                  int coltemp = -1;
                  int totallen = (linha + linhaExtra) * chaveEscolhida.length();
                  char pmat[][] = new char[(linha + linhaExtra)][(chaveEscolhida.length())];
                  char encry[] = new char[totallen];

                  // int tempcnt = -1;
                  linha = 0;

                  // Passo 1: Preenche a matriz pmat com o texto claro
                  // de acordo com a chave escolhida e a quantidade de linhas
                  for (i = 0; i < totallen; i++) {
                           coltemp++;
                           if (i < textoClaro.length()) {
                                    if (coltemp == (chaveEscolhida.length())) {
                                             linha++;
                                             coltemp = 0;
                                    }
                                    pmat[linha][coltemp] = textoClaro.charAt(i);
                           } else {
                                    pmat[linha][coltemp] = '-';
                           }
                  }

                  int len = -1, k;

                  // Passo 2: Preenche o array encry com o texto cifrado
                  // de acordo com a ordem alfabética da chave escolhida
                  for (i = 0; i < chaveEscolhida.length(); i++) {
                           for (k = 0; k < chaveEscolhida.length(); k++) {
                                    if (i == chavePos[k]) {
                                             break;
                                    }
                           }
                           for (j = 0; j <= linha; j++) {
                                    len++;
                                    encry[len] = pmat[j][k];
                           }
                  }

                  String p1 = new String(encry);
                  return (new String(p1));
         }
}
