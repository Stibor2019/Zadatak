import javax.persistence.*;

@Entity
@Table(name = "zaposleni_tabela")

public class Zaposleni {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "zaposleni_id")
    public int zaposleni_id;


    @Column(name = "zaposleni_ime")
    public String zaposleni_ime;
    @Column(name = "zaposleni_godine")
    public int  zaposleni_godine;
    @Column(name = "zaposleni_adresa")
    public String zaposleni_adresa;
    @Column(name = "zaposleni_plata")
   public int zaposleni_plata;



    public Zaposleni() {
    }

    public Zaposleni(int zaposleni_id, String zaposleni_ime, int  zaposleni_godine, String zaposleni_adresa, int zaposleni_plata) {
        this.zaposleni_id =zaposleni_id;
        this.zaposleni_ime = zaposleni_ime;
        this.zaposleni_godine =zaposleni_godine;
        this.zaposleni_adresa = zaposleni_adresa;
        this.zaposleni_plata = zaposleni_plata;
    }
    public Zaposleni(int zaposleni_id){
        this.zaposleni_id = zaposleni_id;
    }

   public Zaposleni(String zaposleni_ime,  int zaposleni_godine,String  zaposleni_adresa, int zaposleni_plata) {
        this.zaposleni_ime = zaposleni_ime;
        this.zaposleni_godine =zaposleni_godine;
        this.zaposleni_adresa = zaposleni_adresa;
        this.zaposleni_plata = zaposleni_plata;
    }

    public int getZaposleni_id() { return zaposleni_id; }
    public void setZaposleni_id(int zaposleni_id) { this.zaposleni_id = zaposleni_id; }
    public String getZaposleni_ime() { return zaposleni_ime; }
    public void setZaposleni_ime(String zaposleni_ime) { this.zaposleni_ime= zaposleni_ime; }
    public int getZaposleni_godine() { return zaposleni_godine; }
    public void setZaposleni_godine(int zaposleni_godine) { this.zaposleni_godine = zaposleni_godine; }
    public String getZaposleni_adresa() { return zaposleni_adresa; }
    public void setZaposleni_adresa(String zaposleni_adresa) { this.zaposleni_adresa = zaposleni_adresa; }
    public int getZaposleni_plata() { return zaposleni_plata; }
    public void setZaposleni_plata(int zaposleni_plata) { this.zaposleni_plata = zaposleni_plata; }



    @Override
    public String toString(){
        return zaposleni_id + "\t" + zaposleni_ime + "\t" +zaposleni_godine + "\t" + zaposleni_adresa + "\t" + zaposleni_plata;
    }
}

