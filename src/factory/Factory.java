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
        if("databases".equals(conf.getString("save"))){
            return new ORMPersistentImpl();
        }if("files".equals(conf.getString("save"))){
            return new FilesPersistentImpl();
        }else{
             return new FilesPersistentImpl();
        }
        
    }
    
    public static ModifyEntity getEditable(){
        return new ConcoleModifyEntityImpl();
    }
}
