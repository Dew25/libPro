/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.panels;

import javax.swing.JPanel;

/**
 *
 * @author jvm
 */
public class TabTwo extends JPanel implements Runnable {

    public TabTwo() {
        Thread t = new Thread(this);
        t.start();
    }

    public void run() {
        
    }
}

