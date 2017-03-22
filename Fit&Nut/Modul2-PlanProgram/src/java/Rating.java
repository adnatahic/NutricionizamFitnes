public class Rating {
    public int idRating;
    private Trener trener;
    private Klijent klijent;
    private int ocjena;
    
    public Klijent getKlijent(){
        return this.klijent;
    }
    public Trener getTrener(){
        return this.trener;
    }
    public int getOcjena(){
        return this.ocjena;
    }
    
    public void setKlijent(Klijent klijent) {
       this.klijent = klijent;
    }
    public void setTrener(Trener trener) {
       this.trener = trener;
    }
    public void setOcjena(int ocjena) {
       this.ocjena = ocjena;
    }
    
}
