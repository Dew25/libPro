/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import entity.Book;
import entity.History;
import entity.Reader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import interfaces.ModifyEntity;

/**
 *
 * @author jvm
 */
public class ConcoleModifyEntityImpl implements ModifyEntity{
    
    public  BufferedReader br;

    public ConcoleModifyEntityImpl() {
        try {
           br = new BufferedReader(new InputStreamReader(System.in,"UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ConcoleModifyEntityImpl.class.getName()).log(Level.SEVERE, "Не поддерживается кодировка", ex);
        }
         
    }
    
    
    @Override
    public Reader addReader() {
       Reader reader = new Reader();
        try {
            System.out.println("Данные пользователя.");
            System.out.print("Имя: ");
            reader.setName(br.readLine());
            System.out.print("фамилия: ");
            reader.setSurname(br.readLine());
            System.out.print("Личный код: ");
            reader.setCode(br.readLine());
        } catch (IOException ex) {
            Logger.getLogger(ConcoleModifyEntityImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reader;
        
    }

    @Override
    public Book addBook() {
        Book book=new Book();
        try {
            System.out.println("Данные книги.");
            System.out.print("Название книги: ");
            book.setCapture(br.readLine());
            System.out.print("Автор: ");
            book.setAuthor(br.readLine());
            System.out.print("ISBN код: ");
            book.setIsbn(br.readLine());
        } catch (IOException ex) {
            Logger.getLogger(ConcoleModifyEntityImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return book;
    }

    @Override
    public History takeBook(Reader reader, Book book) {
       History history = new History();
       history.setBook(book);
       history.setReader(reader);
       Calendar c = new GregorianCalendar();
       history.setDateBegin(c.getTime());
       return history;
    }
    
    @Override
    public History backBook(History history){
       Calendar c = new GregorianCalendar();
       history.setDateEnd(c.getTime());
       return history;
    }
}
