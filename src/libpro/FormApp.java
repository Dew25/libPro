/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libpro;

import form.panels.TabFour;
import form.panels.TabOne;
import form.panels.TabThree;
import form.panels.TabTwo;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author jvm
 */
public class FormApp  {
    public void run(){
        JFrame f = new JFrame("LibPro");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800,500);
        f.getContentPane().setLayout(new BorderLayout());
        JTabbedPane p = new JTabbedPane();
        f.add(p);
        f.getContentPane().add(p);
        p.addTab("Выдать книгу", new TabOne());
        p.addTab("Вернуть книгу", new TabTwo());
        p.addTab("Новая книга", new TabThree());
        p.addTab("Новый читатель", new TabFour());
        
        SwingUtilities.invokeLater(
            new Runnable() {
                @Override
                public void run() {
                 
                f.setVisible(true);                
            }
          }
        );

    }
}
