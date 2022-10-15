package com.petrik.bankiszolgaltatasok;

public class HitelSzamla extends Szamla{

    private int hitelKeret;

    public int getHitelKeret() {
        return hitelKeret;
    }

    public HitelSzamla(Tulajdonos tulajdonos) {
        super(tulajdonos);
    }


    @Override
    public boolean kivesz(int osszeg) {
        if (osszeg <= this.hitelKeret + getAktualisEgyenleg()){
            hitelKeret -= osszeg;
            return true;
        }
        else{
            return false;
        }

    }
}
