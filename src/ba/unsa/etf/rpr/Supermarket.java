package ba.unsa.etf.rpr;

    public class Supermarket {
    private Artikl[] supermarket = new Artikl[100];
    private int uneseno;

    public Artikl[] getArtikli() {
        return supermarket;
    }

    //supermarket.dodajArtikl(new Artikl("Biciklo", 1000, "1"));
    public void dodajArtikl(Artikl artikl) {
        supermarket[uneseno] = new Artikl(artikl.getNaziv(), artikl.getCijena(), artikl.getKod());
        uneseno++;
    }
    //Artikl a = supermarket.izbaciArtiklSaKodom(kod);
    public Artikl izbaciArtiklSaKodom(String kod) {
        for(int i = 0; i < uneseno; i++) {
            if(supermarket[i].getKod().equals(kod)) {
                //isti je
                //posto vraca Artikl napravi ga i vrati ga
                Artikl novi = new Artikl(supermarket[i].getNaziv(),supermarket[i].getCijena(), supermarket[i].getKod());
                //treba sve pomjeriti za jedno ulijevo
                int j;
                for(j = i; j < uneseno; j++) {
                    supermarket[j] = supermarket[j + 1];
                }
                supermarket[j] = null;
                uneseno--;
                return  novi;
            }
        }
        return  null;
    }


}
