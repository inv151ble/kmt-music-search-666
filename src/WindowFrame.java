import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class WindowFrame extends JFrame
{
    static JTextField userArtistName;
    static JLabel[] userOut = new JLabel[KMTUser.getSearchDeph()];
    static JTextField userTag;
    static JButton searchButton;
    static JButton histButton;
    static JButton optionButton;
    static JComboBox userPopularity;
    static JComboBox userHistory;
    public static ArrayList histList = new ArrayList();
    eHendler hendler = new eHendler();
    public WindowFrame()
    {
        getContentPane().setLayout(null);
        setupGUI();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            Class.forName("org.h2.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:h2:C:\\db\\DB",
                    "sa", "");
            Statement st = null;
            st = conn.createStatement();
            ResultSet result;
            result = st.executeQuery("SELECT * FROM HISTRY");
            while (result.next()) {
                WindowFrame.userHistory.addItem(result.getString("NAME"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void setupGUI()
    {
        userArtistName = new JTextField();
        userArtistName.setLocation(20,20);
        userArtistName.setSize(103,30);
        userArtistName.setText("Artist name");
        userArtistName.setColumns(10);
        getContentPane().add(userArtistName);

        userTag = new JTextField();
        userTag.setLocation(160,20);
        userTag.setSize(99,30);
        userTag.setText("Tag");
        userTag.setColumns(10);
        getContentPane().add(userTag);

        searchButton = new JButton();
        searchButton.setLocation(160,80);
        searchButton.setSize(220,60);
        searchButton.setText("Search!");
        getContentPane().add(searchButton);

        optionButton = new JButton();
        optionButton.setLocation(500,420);
        optionButton.setSize(80,20);
        optionButton.setText("Option");
        getContentPane().add(optionButton);

        histButton = new JButton();
        histButton.setLocation(540,20);
        histButton.setSize(35,30);
        histButton.setText(">");
        getContentPane().add(histButton);

        userPopularity = new JComboBox();
        userPopularity.setLocation(280,20);
        userPopularity.setSize(106,30);
        getContentPane().add(userPopularity);

        userHistory = new JComboBox();
        userHistory.setLocation(416,20);
        userHistory.setSize(106,30);
        getContentPane().add(userHistory);

        setTitle("KMT Music search");
        setSize(600,480);
        setVisible(true);
        setResizable(false);

        for(int i = 0;i<KMTUser.getSearchDeph(); i++){
        userOut[i] = new JLabel();
        userOut[i].setLocation(160, 200 + (i * 20));
        userOut[i].setSize(220, 20);
        userOut[i].setText("");
        //userOut[i].setColumns(10);
        getContentPane().add(userOut[i]);
        }

//        ResultTableModel rtm = new ResultTableModel();
//        resultTable = new JTable(rtm);
//        resTabPane = new JScrollPane(resultTable);
//        resTabPane.setPreferredSize(new Dimension(100,100));
//        resTabPane.setLocation(100,100);
//        getContentPane().add(resTabPane);

        searchButton.addActionListener(hendler);
        optionButton.addActionListener(hendler);
        histButton.addActionListener(hendler);

    }

    public class eHendler implements ActionListener{


        public void actionPerformed(ActionEvent e) {

            if(e.getSource()==searchButton){
                KMTQuery UserQuery = new KMTQuery();
            }

            if(e.getSource()==optionButton){
                AdminFrame adminInterface = new AdminFrame();
            }

            if(e.getSource()==histButton){
                userArtistName.setText(userHistory.getSelectedItem().toString());
                KMTQuery UserQuery = new KMTQuery();
            }


        }
    }


    //    public static void main( String args[] )
//    {
//        new WindowFrame();
//    }
}
