package david.gero.adattar;

/**
 * Created by Dávid on 2015.12.16..
 */
public class Adatkiir {

    private String _Nev, _Email, _Telefonszam, _Lakcim;

    public Adatkiir (String Nev, String Email, String Telefonszam, String Lakcim){

        _Nev = Nev;
        _Email = Email;
        _Telefonszam = Telefonszam;
        _Lakcim = Lakcim;

    }

    public String get_Nev(){
        return _Nev;
    }

    public  String get_Email(){
        return _Email;
    }

    public String get_Telefonszam(){
        return _Telefonszam;
    }

    public String get_Lakcim(){
        return  _Lakcim;
    }
}
