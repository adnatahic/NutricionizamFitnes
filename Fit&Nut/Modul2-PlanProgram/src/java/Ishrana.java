public class Ishrana {
    public int idIshrana;
    private Klijent klijent;
    private String dorucak;
    private String uzina1;
    private String rucak;
    private String uzina2;
    private String vecera;
    
    public Klijent getKlijent(){
        return this.klijent;
    }
    public String getDorucak(){
        return this.dorucak;
    }
    public String getUzina1(){
        return this.uzina1;
    }
    public String getRucak(){
        return this.rucak;
    }
    public String getUzina2(){
        return this.uzina2;
    }
    public String getVecera(){
        return this.vecera;
    }
    
    public void setKlijent(Klijent klijent) {
       this.klijent = klijent;
    }
    public void setDorucak(String dorucak) {
       this.dorucak = dorucak;
    }
    public void setUzina1(String uzina1) {
       this.uzina1 = uzina1;
    }
    public void setRucak(String rucak) {
       this.dorucak = rucak;
    }
    public void setUzina2(String uzina2) {
       this.uzina2 = uzina2;
    }
    public void setVecera(String vecera) {
       this.vecera = vecera;
    }
}
