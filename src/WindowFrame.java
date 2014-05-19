import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WindowFrame extends JFrame
{
    static JTextField userArtistName;
    static JTextField[] userOut = new JTextField[5];
    static JTextField userTag;
    static JButton searchButton;
    static JButton optionButton;
    static Choice userPopularity;
    static Choice userHistory;
    eHendler hendler = new eHendler();

    public WindowFrame()
    {
        getContentPane().setLayout(null);
        setupGUI();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    void setupGUI()
    {
        userArtistName = new JTextField();
        userArtistName.setLocation(20,20);
        userArtistName.setSize(103,25);
        userArtistName.setText("Artist name");
        userArtistName.setColumns(10);
        getContentPane().add(userArtistName);

        userTag = new JTextField();
        userTag.setLocation(160,20);
        userTag.setSize(99,25);
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

        userPopularity = new Choice();
        userPopularity.setLocation(280,20);
        userPopularity.setSize(106,28);
        getContentPane().add(userPopularity);

        userHistory = new Choice();
        userHistory.setLocation(416,20);
        userHistory.setSize(106,30);
        getContentPane().add(userHistory);

        setTitle("KMT Music search");
        setSize(600,480);
        setVisible(true);
        setResizable(false);

        for(int i = 0;i<5; i++){
        userOut[i] = new JTextField();
        userOut[i].setLocation(160, 200 + (i * 20));
        userOut[i].setSize(220, 20);
        userOut[i].setText("Out");
        userOut[i].setColumns(10);
        getContentPane().add(userOut[i]);
        }




        searchButton.addActionListener(hendler);
        optionButton.addActionListener(hendler);
    }

    public class eHendler implements ActionListener{


        public void actionPerformed(ActionEvent e) {

            if(e.getSource()==searchButton){
                KMTQuery UserQuery = new KMTQuery();

            }

            if(e.getSource()==optionButton){
                AdminFrame adminInterface = new AdminFrame();

            }

        }
    }


    //    public static void main( String args[] )
//    {
//        new WindowFrame();
//    }
}
