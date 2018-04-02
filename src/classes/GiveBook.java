
package classes;

import entity.Book;
import entity.History;
import entity.Reader;
import interfaces.Persistent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import libpro.LibPro;

/**
 *
 * @author jvm
 */
public class GiveBook {
            
    private Persistent p;

    public GiveBook(Persistent p) {
        this.p = p;
    }
    
    public void addAndSaveHistories(){
        System.out.println("-------- Выдача книги читателю ----------");
        List<Reader> readers = new ArrayList<>();
        List<Book> books = new ArrayList<>();
        try {
            readers = p.loadReaders();
            books = p.loadBooks();
        } catch (Exception e) {
            Logger.getLogger(GiveBook.class.getName()).log(Level.SEVERE, "Нет файла "+LibPro.RADERS_SAVE+" или "+LibPro.BOOKS_SAVE, e);

        }

        System.out.println("Список читателей:");
        Search search = new Search();
        for (int i = 0; i < readers.size(); i++) {
            Reader reader = readers.get(i);
            System.out.println(i+1+". "+reader.getName()+". "+reader.getSurname());
            List<Book> readerBooks = search.booksReadByReader(reader);
            System.out.println("\tЧитает:");
            for (int j = 0; j < readerBooks.size(); j++) {
                Book book = readerBooks.get(j);
                System.out.println("\t"+book.getCapture());
            }
        }

        System.out.println("Список книг:");
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            System.out.println(i+1+". "+book.getCapture()+". "+book.getAuthor());
        }

        System.out.print("Выберите номер читателя ");
        System.out.println("и номер книги для него.");
        System.out.println("-------\"0\" выход в главное меню-------");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numReader="";
        String numBook="";
        try {
            System.out.println("Читатель № "); numReader = br.readLine();
            if(numReader.equals("0")) return;
            System.out.println("Книга № ");  numBook = br.readLine();
            if(numBook.equals("0")) return;
        } catch (IOException ex) {
            Logger.getLogger(GiveBook.class.getName()).log(Level.SEVERE, "Ошибка создания потока", ex);
        }
        History newHistory = new History();
        // добавляем выбранную книгу, читателя и дату в новую историю
        newHistory.setBook(books.get(new Integer(numBook)-1));
        newHistory.setReader(readers.get(new Integer(numReader)-1));
        newHistory.setDateBegin(new GregorianCalendar().getTime());
        //Читаем истории из файла, 
        List<History> histories = histories = p.loadHistories();
        //добавляем новую историю и  
        histories.add(newHistory);
        //сохраняем обновленные истории в файл
        p.saveHistories(histories);
        System.out.println("Читатель "+newHistory.getReader().getSurname()+" получил книгу \""+newHistory.getBook().getCapture()+"\".");
        System.out.println("+++++++++++++++++++++++++");
    }
    
}
