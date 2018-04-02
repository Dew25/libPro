/*
Класс позволяет изменить запись истории и 
т.о. вернуть книгу в библиотеку
Реализован консольный интерфейс выбора возвращаемой книги
*/
package classes;

import entity.History;
import interfaces.Persistent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jvm
 */
public class BackBook {
                
    private Persistent kle;

    public BackBook(Persistent p) {
        this.kle = p;
    }
    
    public void backBookAndSaveHistory(){
        System.out.println();
        System.out.println("---------- Возвращение книг ----------");
        System.out.println();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Читаем историю из файла, добавляем новую историю и сохраняем в файл
        List<History> histories = new ArrayList<>();
        History backBookHistory = null;
        String numHistory="";
        try{
            histories = kle.loadHistories();
            System.out.println("Список историй: ");
            System.out.println("0. Выход в главное меню");
            for (int i = 0; i < histories.size(); i++) {
                History history = histories.get(i);
                if(history.getDateEnd() == null)
                System.out.println(i+1+". "+history.toString());
            }
            System.out.println("Выберите номер истории с нужной книгой и читателем");
            System.out.println("История №: ");
            numHistory = br.readLine();
            if(numHistory.equals("0")) return;
            //копируем указанную историю из списка историй
            backBookHistory = histories.get(new Integer(numHistory)-1);
            //Удаляем выбранную историю из списка историй
            histories.remove(backBookHistory);
            //Модифицируем выбранную копию истории
            backBookHistory.setDateEnd(new GregorianCalendar().getTime());
            //Добавляем обновленную историю в список
            histories.add(backBookHistory);
        }catch(NullPointerException e){
            Logger.getLogger(BackBook.class.getName()).log(Level.SEVERE, "Обращение к несуществующему объекту", e);
        } catch (IOException ex) {
            Logger.getLogger(BackBook.class.getName()).log(Level.SEVERE, "Ошибка ввода/вывода", ex);
        }
        //Сохраняем обновленную историю в файл
        kle.saveHistories(histories);
        System.out.println("Читатель "+backBookHistory.getReader().getSurname()+ " вернул книгу \""+backBookHistory.getBook().getCapture()+"\"");
        System.out.println("-------------------------");
    }
    
}
