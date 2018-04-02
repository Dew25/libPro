/*
Пример создания математической модели реального предприятия "Библиотека". 
 */
package libpro;

import java.util.ResourceBundle;

/**
 *
 * @author jvm
 */
public class LibPro {
    
    public static final String RADERS_SAVE = "readers.save";
    public static final String BOOKS_SAVE = "books.save";
    public static final String HISTORIES_SAVE = "histories.save";
    private final static ResourceBundle conf = ResourceBundle.getBundle("resourses.config");
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Получаем значение view из текстоврого файла по пути 
        // src/resourses/config.properties
        String view = conf.getString("view");
        // запускаем приложение в зависимости от установленной сонфигурации
        switch (view) {
            case "form":
                FormApp formApp = new FormApp();
                formApp.run();
                break;
            case "console":
                App app = new App();
                app.run();
                break;
            default:
                new App().run();
        }
        
        
       
    }    
}
