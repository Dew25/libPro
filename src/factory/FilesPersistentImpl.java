/*
 Реализация инерфейса (Persistent) сохранения списков сущностей в файлах
 */
package factory;

import entity.Book;
import entity.History;
import entity.Reader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import interfaces.Persistent;
import libpro.LibPro;

/**
 *
 * @author jvm
 */
public class FilesPersistentImpl implements Persistent {

    public FilesPersistentImpl() {
        
    }
    
    @Override
    public void saveReaders(List<Reader> readers) {
        try {
            FileOutputStream fos = new FileOutputStream(LibPro.RADERS_SAVE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(readers);
            oos.flush();
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(FilesPersistentImpl.class.getName()).log(Level.SEVERE, "Ошибка записи файла", ex);
        }
    }

    @Override
    public void saveBooks(List<Book> books) {
        try {
            FileOutputStream fos = new FileOutputStream(LibPro.BOOKS_SAVE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(books);
            oos.flush();
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(FilesPersistentImpl.class.getName()).log(Level.SEVERE, "Ошибка записи файла", ex);
        }
    }

    @Override
    public void saveHistories(List<History> histories) {
        try {
            FileOutputStream fos = new FileOutputStream(LibPro.HISTORIES_SAVE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(histories);
            oos.flush();
            oos.close();
            
        } catch (IOException ex) {
            Logger.getLogger(FilesPersistentImpl.class.getName()).log(Level.SEVERE, "Ошибка записи файла", ex);
        }
    }

    @Override
    public List<Reader> loadReaders() {
        FileInputStream fis = null;
        List<Reader> readers = new ArrayList<>();
        try {
            fis = new FileInputStream(LibPro.RADERS_SAVE);
            ObjectInputStream oin = new ObjectInputStream(fis);
            readers = (List<Reader>) oin.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FilesPersistentImpl.class.getName()).log(Level.SEVERE, "Не существует файл", ex);
        } catch (IOException ex) {
            Logger.getLogger(FilesPersistentImpl.class.getName()).log(Level.SEVERE, "Ошибка чтения файла", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FilesPersistentImpl.class.getName()).log(Level.SEVERE, "Нет такого класса", ex);
        } finally {
            try {
                if(fis != null)fis.close();
            } catch (IOException ex) {
                Logger.getLogger(FilesPersistentImpl.class.getName()).log(Level.SEVERE, "Ошибка закрытия потока", ex);
            }
        }
        return readers;
    }

    @Override
    public List<Book> loadBooks() {
        FileInputStream fis = null;
        List<Book> books = new ArrayList<>();
        try {
            fis = new FileInputStream(LibPro.BOOKS_SAVE);
            ObjectInputStream oin = new ObjectInputStream(fis);
            books = (List<Book>) oin.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FilesPersistentImpl.class.getName()).log(Level.SEVERE, "Не существует файл", ex);
        } catch (IOException ex) {
            Logger.getLogger(FilesPersistentImpl.class.getName()).log(Level.SEVERE, "Ошибка чтения файла", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FilesPersistentImpl.class.getName()).log(Level.SEVERE, "Нет такого класса", ex);
        } finally {
            try {
                if(fis != null)fis.close();
            } catch (IOException ex) {
                Logger.getLogger(FilesPersistentImpl.class.getName()).log(Level.SEVERE, "Ошибка закрытия потока", ex);
            }
            
        }
        return books;
    }

    @Override
    public List<History> loadHistories() {
        FileInputStream fis = null;
        List<History> histories = new ArrayList<>();
        try {
            fis = new FileInputStream(LibPro.HISTORIES_SAVE);
            ObjectInputStream oin = new ObjectInputStream(fis);
            histories = (List<History>) oin.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FilesPersistentImpl.class.getName()).log(Level.SEVERE, "Не существует файл", ex);
            
        } catch (IOException ex) {
            Logger.getLogger(FilesPersistentImpl.class.getName()).log(Level.SEVERE, "Ошибка чтения файла", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FilesPersistentImpl.class.getName()).log(Level.SEVERE, "Нет такого класса", ex);
        } finally {
            try {
                if(fis!=null) fis.close();
            } catch (IOException ex) {
                Logger.getLogger(FilesPersistentImpl.class.getName()).log(Level.SEVERE, "Ошибка закрытия потока", ex);
            }
        }if(histories == null) histories = new ArrayList<>();
        return histories;
    }

}
