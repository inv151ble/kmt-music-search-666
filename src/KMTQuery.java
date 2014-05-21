import de.umass.lastfm.Artist;

public class KMTQuery {
   public static String uArtName,uTag,uPop;
   public static KMTArtist testA;
    public KMTQuery(){
        uArtName = (WindowFrame.userArtistName).getText();
       // uPop = (WindowFrame.userPopularity).getSelectedItem();
        uTag = (WindowFrame.userTag).getText();
        Artist testA1 = Artist.search(uArtName,Main1.key).iterator().next();
        testA = new KMTArtist(testA1);
        SearchHist b = new SearchHist();

    KMTResult userResult = new KMTResult();
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
