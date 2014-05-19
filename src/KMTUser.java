import java.io.*;
import java.util.Properties;

public class KMTUser {

    private static int searchDeph;
    private static int historySize;
    private static boolean searchRigor;
    private static String fileName = "src/res/settings.properties";


public KMTUser() {
    Properties prop = new Properties();
    InputStream input = null;
    try {
        input = new FileInputStream(fileName);
        prop.load(input);
        // Вывод считанных параметров
        searchDeph =  Integer.parseInt(prop.getProperty("searchDeph"));
        historySize = Integer.parseInt(prop.getProperty("historySize"));
        searchRigor = Boolean.parseBoolean(prop.getProperty("searchRigor"));

    } catch (IOException ex) {
        ex.printStackTrace();
    } finally {
        if (input != null) {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
    public static void saveSettings(){

        Properties prop = new Properties();
        OutputStream output = null;
        try {
            output = new FileOutputStream(fileName);
            // Устанавливаем  [поле]        [значение]
            prop.setProperty("searchDeph", Integer.toString(searchDeph));
            prop.setProperty("historySize", Integer.toString(historySize));
            prop.setProperty("searchRigor", Boolean.toString(searchRigor));

            prop.store(output, null);
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }


    public static int getHistorySize() {
        return historySize;
    }

    public static void setHistorySize(int historySize) {
        KMTUser.historySize = historySize;
    }

    public static int getSearchDeph() {
        return searchDeph;
    }

    public static void setSearchDeph(int searchDeph) {
        KMTUser.searchDeph = searchDeph;
    }

    public static boolean isSearchRigor() {
        return searchRigor;
    }

    public static void setSearchRigor(boolean searchRigor) {
        KMTUser.searchRigor = searchRigor;
    }
}