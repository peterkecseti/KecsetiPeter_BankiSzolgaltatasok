package com.petrik.bankiszolgaltatasok;

public class MegtakaritasiSzamla extends Szamla {
    public MegtakaritasiSzamla(Tulajdonos tulajdonos) {
        super(tulajdonos);
    }

    @Override
    public boolean kivesz(int osszeg) {
        if (!(getAktualisEgyenleg() - osszeg < 0)){
            return true;
        }else return false;

    }

    private static double kamat = 1.1;

    public double getKamat() {
        return kamat;
    }

    public void setKamat(double kamat) {
        this.kamat = kamat;
    }

    void kamatJovairas(){
        //tul degeneralt vagyok ahhoz hogy felfogjam
        befizet((int)kamat*this.getAktualisEgyenleg());
    }

}
