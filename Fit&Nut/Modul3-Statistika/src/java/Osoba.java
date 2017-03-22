public class Osoba {
    public int idOsoba;
    private String username;
    private String password;
    private String ime;
    private String prezime;
    private String mail;
    
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public String getIme(){
        return this.ime;
    }
    public String getPrezime(){
        return this.prezime;
    }
    public String getMail(){
        return this.mail;
    }
    
    public void setUsername(String username) {
       this.username = username;
    }
    public void setPassword(String password) {
       this.password = password;
    }
    public void setIme(String ime) {
       this.ime = ime;
    }
    public void setMail(String mail) {
       this.mail = mail;
    }
}
