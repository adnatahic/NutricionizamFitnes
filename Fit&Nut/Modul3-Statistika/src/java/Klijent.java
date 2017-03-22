import java.util.Date;

public class Klijent extends Osoba {
    public int idKlijent;
    private int visina;
    private Parametri parametri;
    private boolean spol;
    private int godinaRodjenja;
    private int skalaAktivnosti;
    private String bolesti;
    private String zeljeniRezultati;
    private Date datumPocetka;
    private Trener trener;
    
    public int getVisina(){
        return this.visina;
    }
    public Parametri getParametri(){
        return this.parametri;
    }
    public boolean getSpol(){
        return this.spol;
    }
    public int getGodinaRodjenja(){
        return this.godinaRodjenja;
    }
    public int getSkalaAktivnosti(){
        return this.skalaAktivnosti;
    }
    public String getBolesti(){
        return this.bolesti;
    }
    public String getZeljeniRezultati(){
        return this.zeljeniRezultati;
    }
    public Date getDatumPocetka(){
        return this.datumPocetka;
    }
    public Trener getTrener(){
        return this.trener;
    }
    
    public void setVisina(int visina) {
       this.visina = visina;
    }
    public void setParametri(Parametri parametri) {
       this.parametri = parametri;
    }
    public void setSpol(boolean spol) {
       this.spol = spol;
    }
    public void setGodinaRodjenja(int godinaRodjenja) {
       this.godinaRodjenja = godinaRodjenja;
    }
    public void setSkalaAktivnosti(int skalaAktivnosti) {
       this.skalaAktivnosti = skalaAktivnosti;
    }
    public void setBolesti(String bolesti) {
       this.bolesti = bolesti;
    }
    public void setZeljeniRezultati(String zeljeniRezultati) {
       this.zeljeniRezultati = zeljeniRezultati;
    }
    public void setDatumPocetka(Date datumPocetka) {
       this.datumPocetka = datumPocetka;
    }
    public void setTrener(Trener trener) {
       this.trener = trener;
    }
}
