import de.umass.lastfm.Artist;
import de.umass.lastfm.Caller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

/**
 * Created by Платон on 19.05.2014.
 */
public class KMTApplet extends JApplet {

    public static Collection<String> artists1;
    public static String key;

    public void init() {
        key = "014e37a523f39ad113d20ef8ee47bf78"; // Last.fm API key
        Caller.getInstance().setUserAgent("tst");
        getContentPane().setLayout(null);
        setupGUI();
    }

    static JTextField userArtistName;
    static JTextField[] userOut = new JTextField[5];
    static JTextField userTag;
    static JButton searchButton;
    static Choice userPopularity;
    static Choice userHistory;
    eHendler hendler = new eHendler();


    void setupGUI()
    {
        userArtistName = new JTextField();
        userArtistName.setLocation(160,20);
        userArtistName.setSize(220,30);
        userArtistName.setText("Artist name");
        userArtistName.setColumns(10);
        getContentPane().add(userArtistName);



        searchButton = new JButton();
        searchButton.setLocation(160,80);
        searchButton.setSize(220,60);
        searchButton.setText("Search!");
        getContentPane().add(searchButton);

        setSize(600,480);
        setVisible(true);

        for(int i = 0;i<5; i++){
            userOut[i] = new JTextField();
            userOut[i].setLocation(160, 200 + (i * 20));
            userOut[i].setSize(220, 20);
            userOut[i].setText("-");
            userOut[i].setColumns(10);
            getContentPane().add(userOut[i]);
        }

        searchButton.addActionListener(hendler);

    }

    public class KMTArtist extends Artist{
        //public static String Name;
        public  String[] artists1 = new String[5];
        public  Collection<KMTArtist> similar;
        public  Collection<Artist> similar1;

        public KMTArtist(Artist a) {
            super(a.getName(), a.getUrl());
            int i=0;
            similar1=Artist.getSimilar(this.getName(), 5, Main1.key);
            for (Artist artist : similar1) {
                artists1[i]=artist.getName();
                i++;
            }
        }

        public Collection<KMTArtist> getKMTSimilar() {

            for (Artist artist : similar1) {
                similar.add(new KMTArtist(artist));


            };
            return similar;
        }

    }


    public class KMTQuery {
        public  String uArtName,uTag,uPop;
        public  KMTArtist testA;
        public KMTQuery(){
            uArtName = (KMTApplet.userArtistName).getText();
            uPop = (KMTApplet.userPopularity).getSelectedItem();
            uTag = (KMTApplet.userTag).getText();
            Artist testA1 = Artist.search(uArtName,KMTApplet.key).iterator().next();
            testA = new KMTArtist(testA1);
            for(int i = 0;i<5; i++)
            {
                KMTApplet.userOut[i].setText(testA.artists1[i]);
            }
        }

        public String getuArtName() {
            return uArtName;
        }

        public String getuTag() {
            return uTag;
        }

        public String getuPop() {
            return uPop;
        }
    }


    public class eHendler implements ActionListener{


        public void actionPerformed(ActionEvent e) {

            if(e.getSource()==searchButton){
                KMTQuery UserQuery = new KMTQuery();

            }
        }
    }
}
