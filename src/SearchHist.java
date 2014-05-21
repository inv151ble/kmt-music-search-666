/**
 * Created by Платон on 20.05.2014.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SearchHist {
    public SearchHist() {
            try {
                WindowFrame.userHistory.removeAllItems();
                Class.forName("org.h2.Driver").newInstance();
                Connection conn = DriverManager.getConnection("jdbc:h2:C:\\db\\DB",
                        "sa", "");
                Statement st = null;
                st = conn.createStatement();
                st.execute("INSERT INTO HISTRY(name) VALUES(" + "\'"+ KMTQuery.uArtName +"\'"+ ")");
                ResultSet result;
                result = st.executeQuery("SELECT * FROM HISTRY");
                while (result.next()) {
                    WindowFrame.userHistory.addItem(result.getString("NAME"));
                    }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    public static void clearHist(){
        try {
            Class.forName("org.h2.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:h2:C:\\db\\DB",
                    "sa", "");
            Statement st = null;
            st = conn.createStatement();
            st.execute("DELETE FROM HISTRY");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
