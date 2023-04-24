// package com.boot.cifras.Controllers;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Latitude 5500
 */

// Java code to implement Vigenere Cipher
 
// class Viginere
// {
 
// This function generates the key in
// a cyclic manner until it's length isi'nt
// equal to the length of original text
// String generateKey(String str, String key)
// {
//     int x = str.length();
 
//     for (int i = 0; ; i++)
//     {
//         if (x == i)
//             i = 0;
//         if (key.length() == str.length())
//             break;
//         key+=(key.charAt(i));
//     }
//     return key;
// }
 
// This function returns the encrypted text
// generated with the help of the key
// String cipherText(String str, String key)
// {
//     String cipher_text="";
 
//     for (int i = 0; i < str.length(); i++)
//     {
//         // converting in range 0-25
//         int x = (str.charAt(i) + key.charAt(i)) %26;
 
//         // convert into alphabets(ASCII)
//         x += 'A';
 
//         cipher_text+=(char)(x);
//     }
//     return cipher_text;
// }
 

// static String originalText(String cipher_text, String key)
// {
//     String orig_text="";
 
//     for (int i = 0 ; i < cipher_text.length() &&
//                             i < key.length(); i++)
//     {
//         // converting in range 0-25
//         int x = (cipher_text.charAt(i) -
//                     key.charAt(i) + 26) %26;
 
//         // convert into alphabets(ASCII)
//         x += 'A';
//         orig_text+=(char)(x);
//     }
//     return orig_text;
// }
 
// This function will convert the lower case character to Upper case
// String LowerToUpper(String s)
// {
//     StringBuffer str =new StringBuffer(s);
//     for(int i = 0; i < s.length(); i++)
//     {
//         if(Character.isLowerCase(s.charAt(i)))
//         {
//             str.setCharAt(i, Character.toUpperCase(s.charAt(i)));
//         }
//     }
//     s = str.toString();
//     return s;
// }
 
// Driver code
// public static void main(String[] args)
// {
//     System.out.println("Cifra de Viginere");
//     String Str = "Hidelgio";
//     String Keyword = Str;
       
//       String str = LowerToUpper(Str);
//       String keyword = LowerToUpper(Keyword);
 
//     String key = generateKey(str, keyword);
//     String cipher_text = cipherText(str, key);
    
//     System.out.println("Texto Simples : "
//         + originalText(cipher_text, key));
 
//     System.out.println("Texto cifrado : "
//         + cipher_text + "\n");
 
    
//     }
// }
