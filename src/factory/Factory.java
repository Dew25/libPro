/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import interfaces.Persistent;
import interfaces.ModifyEntity;
import java.util.ResourceBundle;

/**
 *
 * @author jvm
 */
public class Factory {
    private final static ResourceBundle conf = ResourceBundle.getBundle("resourses.config");
    public static Persistent getPersistent(){
        String key = conf.getString("save");
        Persistent p = null;
        switch (key) {
            case "databases":
                p = new ORMPersistentImpl();
                break;
            case "files":
                p = new FilesPersistentImpl();
                break;
            default:
                p = new ORMPersistentImpl();
        }
        return p;
    }
        
    public static ModifyEntity getEditable(){
        return new ConcoleModifyEntityImpl();
    }
}
