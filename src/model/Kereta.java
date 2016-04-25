/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author iwannadb
 */
public class Kereta {
    private List<Gerbong> gerbongs;
    private String nama;
    private int maxGerbong;
    private Rute rute;
    
    public Kereta(String nama,int maxGer){
        this.nama = nama;
        maxGerbong = maxGer;
        gerbongs = Collections.synchronizedList(new ArrayList<Gerbong>());
    }

    public Kereta(String nama, int maxGerbong, Rute rute) {
        this.nama = nama;
        this.maxGerbong = maxGerbong;
        this.rute = rute;
        gerbongs = Collections.synchronizedList(new ArrayList<Gerbong>());
    }
    
    public boolean addGerbong(Gerbong g){
        if (gerbongs.size()<getMaxGerbong()) {
            gerbongs.add(g);
            return true;
        }
        else
            return false;
    }
    
    public boolean addPenumpang(Tiket t){
        Gerbong g;
        if (gerbongs.isEmpty()){ //belum ada gerbong
            g = new Gerbong();
            g.addPenumpang(t);
            gerbongs.add(g);
        } else { //udah ada gerbong
            int ahir = gerbongs.size()-1;
            g = gerbongs.get(ahir); // ambil gerbong terahir
            if (g.addPenumpang(t)) { //klo bisa ditambahkan
                gerbongs.set(ahir, g); //update gerbong terahir
                return true;
            } else { // klo penuh
                g = new Gerbong(); //bikin gerbong baru
                g.addPenumpang(t); //tambahin penumpang
                if (gerbongs.add(g)){ //klo bisa ditambahin gerbongnya
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
    
    private List<Gerbong> getGerbongs(){
        return gerbongs;
    }
    public void setRoute(Rute ru){
        this.rute = ru;
    }
    public Rute getRoute(){
        return rute;
    }

    /**
     * @return the 
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the maxGerbong
     */
    public int getMaxGerbong() {
        return maxGerbong;
    }

    /**
     * @param maxGerbong the maxGerbong to set
     */
    public void setMaxGerbong(int maxGerbong) {
        this.maxGerbong = maxGerbong;
    }

    @Override
    public String toString() {
        
        return nama;
    }
    public String[] daftarPenumpang(){
        
        List<String> ret = Collections.synchronizedList(new ArrayList<String>());
    
        for (Gerbong gerbong : gerbongs) {
            for (Tiket tiket : gerbong.getTickets()) {
                if (tiket != null)
                    ret.add(tiket.toString());
            }
            
        }
        return ret.toArray(new String[0]);
    }
    
    
}
