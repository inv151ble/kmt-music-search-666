import de.umass.lastfm.*;
import java.text.DateFormat;
import java.util.Collection;

public class Main1 {
    public static Collection<String> artists1;
    public static String key;

    public static void main(String[] args) {
        key = "014e37a523f39ad113d20ef8ee47bf78"; // Last.fm API key
        Caller.getInstance().setUserAgent("tst");
       // String user = "inv151ble";
       KMTUser kmtUser = new KMTUser();
       WindowFrame userInterface = new WindowFrame();
     /*  // Chart<Artist> chart = Artist.getSimilar(KMTQuery.uArtName,1,key);
        DateFormat format = DateFormat.getDateInstance();
      //  String from = format.format(chart.getFrom());
     //   String to = format.format(chart.getTo());
       // System.out.printf("Charts for %s for the week from %s to %s:%n", user, from, to);
        Collection<Artist> artists = Artist.getSimilar(KMTQuery.uArtName, 1, key);
        for (Artist artist : artists) {
             artists1.add(artist.getName());
        }*/
    }

}
