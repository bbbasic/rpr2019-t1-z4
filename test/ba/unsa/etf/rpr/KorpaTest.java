package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KorpaTest {

    //korpa je puna
    @Test
    void ProvjeraDaLiImaProstoraUkorpi() {
        Korpa korpa = new Korpa();
        for(int i = 0; i < 50; i++) {
            //kopirano  String str3 = String.valueOf(c);
            Artikl novi = new Artikl("pobno_ime", 1000, String.valueOf(i));
            korpa.dodajArtikl(novi);
        }
        Artikl drugi = new Artikl("olovka", 200, "52");
        boolean da_li_je_korpa_puna = korpa.dodajArtikl(drugi);
        assertFalse(da_li_je_korpa_puna);
    }

    //korpa nije puna
    @Test
    void ProvjeraDaLiImaProstoraUkorpiKorpaNijePUna() {
        Korpa korpa = new Korpa();
        Artikl drugi = new Artikl("olovka", 200, "0");
        boolean da_li_je_korpa_puna = korpa.dodajArtikl(drugi);
        assertTrue(da_li_je_korpa_puna);
    }

    @Test
    void izbaciArtiklSaKodomKojegIma() {
        Korpa korpa = new Korpa();
        Artikl novi = new Artikl("Olovka", 100, "0");
        korpa.dodajArtikl(novi);
        //vraca artikl koji je nasao, poredi samo kodove
        //vraca pronadjeni
        Artikl provjera = korpa.izbaciArtiklSaKodom(novi.getKod());
        //trebao bi vratiti ne null ref nego da je pronajden
        assertNotNull(provjera);

    }
    @Test
    void izbaciArtiklSaKodomKojegNema() {
        Korpa korpa = new Korpa();
        Artikl provjera = korpa.izbaciArtiklSaKodom("1234");
        //ako nije pronadjen onda je null vracen
        assertNull(provjera);
    }
    @Test
    void dajUkupniCijenu() {
        Korpa korpa = new Korpa();
        Artikl prvi_novi = new Artikl("Olovka", 100, "0");
        Artikl drugi_novi = new Artikl("Sveska", 200,"1");
        Artikl treci_novi = new Artikl("Papir", 100,"2");
        korpa.dodajArtikl(prvi_novi);
        korpa.dodajArtikl(drugi_novi);
        korpa.dodajArtikl(treci_novi);
        //cijena je 400
        //provjeriti da li korpa.DajUkupnuVijenuArtikala vraca dobru cijenu
        assertEquals(400, korpa.dajUkupnuCijenuArtikala());
    }

}