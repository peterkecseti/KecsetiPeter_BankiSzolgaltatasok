package com.petrik.bankiszolgaltatasok;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    static List<Szamla> szamlaLista = new ArrayList<>();

    public Bank(){

    }



    public Szamla szamlaNyitas(Tulajdonos tulajdonos, int hitelkeret){
        if (hitelkeret >0){
            szamlaLista.add(new HitelSzamla(tulajdonos, hitelkeret));
            return new HitelSzamla(tulajdonos, hitelkeret);
        } else if(hitelkeret == 0){
            szamlaLista.add(new MegtakaritasiSzamla(tulajdonos));
            return new MegtakaritasiSzamla(tulajdonos);
        }else{
            throw new IllegalArgumentException("A hitelkeret nem lehet kisebb mint 0");
        }
    }
    public int getOsszegyenleg(Tulajdonos tulajdonos){
        int osszeegyenleg = 0;
        for (Szamla szamla : szamlaLista) {
            if (szamla.getTulajdonos() == tulajdonos) {
                osszeegyenleg += szamla.getAktualisEgyenleg();
            }
        }
        return osszeegyenleg;
    }

    public int getLegnagyobbEgyenleguSzamla(Tulajdonos tulajdonos){
        int max = 0;
        for (Szamla szamla : szamlaLista) {
            if (szamla.getTulajdonos() == tulajdonos && szamla.getAktualisEgyenleg() > max) {
                max = szamla.getAktualisEgyenleg();
            }
        }
        return max;
    }

    public long getOsszhitelkeret(){
        int osszeg = 0;
        for (Szamla szamla : szamlaLista){
            if (szamla instanceof HitelSzamla){
                osszeg+=((HitelSzamla) szamla).getHitelKeret();
            }
        }
        return osszeg;
    }

}
