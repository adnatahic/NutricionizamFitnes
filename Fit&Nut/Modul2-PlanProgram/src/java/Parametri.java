import java.util.Date;

public class Parametri {
    public int idParametri;
    private Date datum;
    private double tezina;
    
    public Date getDatum(){
        return this.datum;
    }
    public double getTezina(){
        return this.tezina;
    }
    
    public void setDatum(Date datum) {
       this.datum = datum;
    }
    public void setTezina(double tezina) {
       this.tezina = tezina;
    }
}
