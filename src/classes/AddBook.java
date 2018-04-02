/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entity.Book;
import interfaces.Persistent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import interfaces.ModifyEntity;

/**
 *
 * @author jvm
 */
public class AddBook {
    private ModifyEntity me;
    private Persistent p;

    public AddBook(ModifyEntity me,Persistent p) {
        this.me = me;
        this.p = p;
    }
    public void addAndSaveBook(){
        Book book= new Book();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Book> books = p.loadBooks(); 
        book= me.addBook();
        books.add(book);
        p.saveBooks(books);
        System.out.println("В библиотеку добавлена книга "+book.toString());
    }
    
}
