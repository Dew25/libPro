/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entity.Reader;
import interfaces.Persistent;
import java.util.List;
import interfaces.ModifyEntity;

/**
 *
 * @author jvm
 */
public class AddReader {
    private ModifyEntity me;
    private Persistent p;

    public AddReader(ModifyEntity me, Persistent p) {
        this.me = me;
        this.p = p;
    }
    
    public void addAndSaveReader(){
        List<Reader> readers = p.loadReaders(); 
        Reader reader = me.addReader();
        readers.add(reader);
        p.saveReaders(readers);
        System.out.println("В библиотеку записался новый пользователь "+reader.toString());
        System.out.println("+++++++++++++++++++++++++");
    }
    
}
