public class Trening {
    public int idTrening;
    private Klijent klijent;
    private double trajanje;
    private int ucestalost;
    private String opis;
    
    public Klijent getKlijent(){
        return this.klijent;
    }
    public double getTrajanje(){
        return this.trajanje;
    }
    public int getUcestalost(){
        return this.ucestalost;
    }
    public String getOpis(){
        return this.opis;
    }
    
    public void setKlijent(Klijent klijent) {
       this.klijent = klijent;
    }
    public void setTrajanje(double trajanje) {
       this.trajanje = trajanje;
    }
    public void setUcestalost(int ucestalost) {
       this.ucestalost = ucestalost;
    }
    public void setOpis(String opis) {
       this.opis = opis;
    }
}
