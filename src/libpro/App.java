/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libpro;

import classes.AddBook;
import classes.GiveBook;
import classes.AddReader;
import classes.BackBook;
import factory.Factory;
import interfaces.Persistent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import interfaces.ModifyEntity;

/**
 *
 * @author jvm
 */
public class App {
    
    private final Persistent p = Factory.getPersistent();
    private final ModifyEntity me = Factory.getEditable();
    
    public void run(){
        String repeat = "r";
        System.out.println("Здравствуйте!");
        System.out.println("---------------------");
        do{ 
              System.out.println("Выберите действие:");
              System.out.println("0 - Выйти из программы");
              System.out.println("1 - Добавить читателя");
              System.out.println("2 - Добавить книгу");
              System.out.println("3 - Выдать книгу читателю");
              System.out.println("4 - Вернуть книгу в библиотеку");
              BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
              System.out.println("Введите число: ");
              String flag="";
                try {
                    flag = br.readLine();
                } catch (IOException ex) {
                    Logger.getLogger(LibPro.class.getName()).log(Level.SEVERE, null, ex);

                }

              switch (flag) {
                case "0":
                    repeat = "no";
                    break;
                case "1":
                    AddReader ar = new AddReader(me,p);
                    ar.addAndSaveReader();
                    break;
                case "2":
                    AddBook ab = new AddBook(me,p);
                    ab.addAndSaveBook();
                    break;
                case "3":
                    GiveBook ah = new GiveBook(p);
                    ah.addAndSaveHistories();
                    break; 
                case "4":
                    BackBook bb = new BackBook(p);
                    bb.backBookAndSaveHistory();
                    break;
                default:
                    System.out.println("-----------------------------");
                    System.out.println("Выберите корректную команду!");
                    System.out.println();
                    repeat = "r";
              }
            
        }while("r".equals(repeat));
        System.out.println("------ До свидания! :) -------");
    }
}
