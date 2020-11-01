package ba.unsa.etf.rpr;
//korpa.dodajArtikl(a)
//korpa.getArtikli()
//korpa.izbaciArtiklSaKodom(kod)
//korpa.dajUkupnuCijenuArtikala()

public class Korpa {
    private Artikl[] korpa = new Artikl[50];
    private int uneseno;

    public Artikl[] getArtikli() {
        return korpa;
    }

    public boolean dodajArtikl(Artikl artikl) {
        if(uneseno < 50) {
            korpa[uneseno] = new Artikl(artikl.getNaziv(), artikl.getCijena(), artikl.getKod());
            uneseno++;
            return true;
        }
        return false;
    }

    public int dajUkupnuCijenuArtikala() {
        int suma = 0;
        for(int i = 0; i < uneseno; i++)
            suma = suma + korpa[i].getCijena();
        return  suma;
    }

    public Artikl izbaciArtiklSaKodom(String kod) {
        for(int i = 0; i < uneseno; i++) {
            if(korpa[i].getKod().equals(kod)) {
                //isti je
                //posto vraca Artikl napravi ga i vrati ga
                Artikl novi = new Artikl(korpa[i].getNaziv(),korpa[i].getCijena(), korpa[i].getKod());
                //treba sve pomjeriti za jedno ulijevo
                int j;
                for(j = i; j < uneseno; j++)
                    korpa[j] = korpa[j + 1];
                korpa[j] = null;
                uneseno--;
                return  novi;
            }
        }
        return  null;
    }
}
