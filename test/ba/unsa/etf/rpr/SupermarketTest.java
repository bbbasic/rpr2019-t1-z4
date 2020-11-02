package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SupermarketTest {

    //u metodi dodajArtikl u Supermarketu
    @Test
    void dodajArtikl() {
        Supermarket supermarket = new Supermarket();
        Artikl artikl = new Artikl("Telefon", 1000, "0");
        supermarket.dodajArtikl(artikl);
    }

    @Test
    void izbaciArtiklSaKodomKojegIma() {
        Supermarket supermarket = new Supermarket();
        Artikl novi = new Artikl("Olovka", 500, "0");
        supermarket.dodajArtikl(novi);
        //vraca artikl koji je nasao, poredi samo kodove
        //vraca pronadjeni
        Artikl provjera = supermarket.izbaciArtiklSaKodom(novi.getKod());
        //trebao bi vratiti ne null ref nego da je pronajden
        assertNotNull(provjera);

    }
    @Test
    void izbaciArtiklSaKodomKojegNema() {
        Supermarket supermarket = new Supermarket();
        Artikl provjera = supermarket.izbaciArtiklSaKodom("1234");
        //ako nije pronadjen onda je null vracen
        assertNull(provjera);
    }
}