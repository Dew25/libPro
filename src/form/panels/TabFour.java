/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.panels;

import entity.Reader;
import factory.Factory;
import factory.ORMPersistentImpl;
import interfaces.Persistent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author jvm
 */
public class TabFour extends JPanel implements Runnable {

    public TabFour() {
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        JLabel label = new JLabel("Заполните все текстовые поля");
        JTextField nameReader = new JTextField(20);
        JTextField surnameReader = new JTextField(20);
        JTextField codeReader = new JTextField(20);
        JButton addReader = new JButton("Добавить читателя");
        add(nameReader);
        add(surnameReader);
        add(codeReader);
        add(addReader);
        addReader.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    if("".equals(nameReader.getText()) || "".equals(surnameReader.getText())
                            || "".equals(codeReader.getText())){
                        add(label);
                    }else{
                        Persistent persist = Factory.getPersistent();
                        Reader newReader = new Reader();
                        newReader.setName(nameReader.getText());
                        newReader.setSurname(surnameReader.getText());
                        newReader.setCode(codeReader.getText());
                        List<Reader> readers = new ArrayList<>();
                        readers.add(newReader);
                        persist.saveReaders(readers);
                    }
                }
                
            });
        
        
        
    };
        
 
}

