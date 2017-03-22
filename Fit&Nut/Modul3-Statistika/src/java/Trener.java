public class Trener extends Osoba {
    public int idTrener;
    private String iskustvo;
    private String edukacija;
    private int brojKlijenata;
    private boolean spol;
    private int godinaRodjenja;
    
    public String getIskustvo(){
        return this.iskustvo;
    }
    public String getEdukacija(){
        return this.edukacija;
    }
    public int getBrojKlijenata(){
        return this.brojKlijenata;
    }
    public boolean getSpol(){
        return this.spol;
    }
    public int getGodinaRodjenja(){
        return this.godinaRodjenja;
    }
    
}
