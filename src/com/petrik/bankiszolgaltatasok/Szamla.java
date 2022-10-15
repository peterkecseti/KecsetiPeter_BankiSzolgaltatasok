package com.petrik.bankiszolgaltatasok;

public abstract class Szamla extends BankiSzolgaltatas {

    public Szamla(Tulajdonos tulajdonos) {
        super(tulajdonos);
    }

    private int aktualisEgyenleg;

    public int getAktualisEgyenleg() {
        return aktualisEgyenleg;
    }

    public void befizet(int osszeg){
        aktualisEgyenleg += osszeg;
    }

    public abstract boolean kivesz(int osszeg);
}
