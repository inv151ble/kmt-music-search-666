import java.io.*;
import java.util.Properties;

public class KMTUser {

    private static int searchDeph;
    private static int historySize;
    private static boolean searchRigor;
    private static int midSearchDeph;
    private static int midHistorySize;
    private static boolean midSearchRigor;
    public static int pk;

    public static int getMidSearchDeph() {
        return midSearchDeph;
    }

    public static void setMidSearchDeph(int midSearchDeph) {
        KMTUser.midSearchDeph = midSearchDeph;
    }

    public static int getMidHistorySize() {
        return midHistorySize;
    }

    public static void setMidHistorySize(int midHistorySize) {
        KMTUser.midHistorySize = midHistorySize;
    }

    public static boolean isMidSearchRigor() {
        return midSearchRigor;
    }

    public static void setMidSearchRigor(boolean midSearchRigor) {
        KMTUser.midSearchRigor = midSearchRigor;
    }

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
            prop.setProperty("searchDeph", Integer.toString(midSearchDeph));
            prop.setProperty("historySize", Integer.toString(midHistorySize));
            prop.setProperty("searchRigor", Boolean.toString(midSearchRigor));

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