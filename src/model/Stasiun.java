/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Muhammad 'Aizul F
 */
public class Stasiun {
    private String namaStasiun;
    private String kota;
    
    public Stasiun(String namaStasiun,String kota){
        this.namaStasiun = namaStasiun;
        this.kota = kota;
    }

    public void setNamaStasiun(String namaStasiun) {
        this.namaStasiun = namaStasiun;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getNamaStasiun() {
        return namaStasiun;
    }

    public String getKota() {
        return kota;
    }

    @Override
    public String toString() {
        return  namaStasiun + " (" + kota + ")";
    }
    
    
}
