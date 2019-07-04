package com.example.aplikacjazarzdzaniadlugiem;

import java.util.ArrayList;
import java.util.List;

public class ZalogowanyUzytkownik {


    private static ZalogowanyUzytkownik instance;


    private Uzytkownicy zalogowany;

    private List<Uzytkownicy> listaDodanychUzytkownikow;

    private ZalogowanyUzytkownik(Uzytkownicy u)
    {
       listaDodanychUzytkownikow = new ArrayList<>();
       zalogowany=u;

    }
    public static void inicjalizacja(Uzytkownicy u)
    {

           instance=new ZalogowanyUzytkownik(u);

    }
    public static ZalogowanyUzytkownik getInstance()
    {
        if(instance==null)
            return null;
            else
            return instance;
    }

    public void setZalogowany(Uzytkownicy u) {
        instance.zalogowany=u;
    }

    /**
     * Zwraca zalogowanego użytkownika
     * @return
     */
    public Uzytkownicy getZalogowanyUzytkownik()
    {
        return zalogowany;
    }
    public List<Uzytkownicy> getListaDodanychUzytkownikow() {
        return instance.listaDodanychUzytkownikow;
    }

    public void dodajElementDoListy(Uzytkownicy u)
    {
        instance.listaDodanychUzytkownikow.add(u);
    }
    public void usunElementDoListy(Uzytkownicy u)
    {
        instance.listaDodanychUzytkownikow.remove(u);
    }
    public void zerujElemntyListy(){instance.listaDodanychUzytkownikow.clear();}

}
