/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import factory.FilesPersistentImpl;
import entity.Book;
import entity.History;
import entity.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author jvm
 */
public class Search {
    /**
     * Returns a list of books read by the reader
     * @param reader 
     * @return list of books
     */
    public List<Book> booksReadByReader(Reader reader){
        List<Book> books = new ArrayList<>();
        List<History> histories = new ArrayList<>();
        FilesPersistentImpl kle = new FilesPersistentImpl();
        histories = kle.loadHistories();
        for (int i = 0; i < histories.size(); i++) {
            History history = histories.get(i);
            if(history.getReader().equals(reader) && history.getDateEnd()==null){
                books.add(history.getBook());
            }
        }
        return books;
    }
    
}
