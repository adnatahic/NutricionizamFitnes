import java.util.Date;

public class Komentari {
    public int idKomentar;
    private Klijent klijent;
    private Trener trener;
    private Date datum;
    private String komentar;
    
    public Klijent getKlijent(){
        return this.klijent;
    }
    public Trener getTrener(){
        return this.trener;
    }
    public Date getDatum(){
        return this.datum;
    }
    public String getKomentar(){
        return this.komentar;
    }
    
    public void setKlijent(Klijent klijent) {
       this.klijent = klijent;
    }
    public void setTrener(Trener trener) {
       this.trener = trener;
    }
    public void setDatum(Date datum) {
       this.datum = datum;
    }
    public void setKomentar(String komentar) {
       this.komentar = komentar;
    }
}
