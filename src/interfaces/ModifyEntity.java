/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entity.Book;
import entity.History;
import entity.Reader;

/**
 *
 * @author jvm
 */
public interface ModifyEntity {
    public Reader addReader();
    public Book addBook();
    public History takeBook(Reader reader, Book book);
    public History backBook(History history);
    
}
