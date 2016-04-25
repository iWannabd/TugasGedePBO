/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Muhammad Thomy
 */
public class Tiket {
    private String namaPenumpang;
    private long idPenumpang;
    private String kontak;
    private Date tanggalPesan;
    private double harga;

    public Tiket(String namaPenumpang, long idPenumpang, String kontak, Date tanggalPesan, double harga) {
        this.namaPenumpang = namaPenumpang;
        this.idPenumpang = idPenumpang;
        this.kontak = kontak;
        this.tanggalPesan = tanggalPesan;
        this.harga = harga;
    }
    
    public void setNamaPenumpang (String namaPenumpang) {
        this.namaPenumpang = namaPenumpang;
    }
    
    public void setIdPenumpang (long idPenumpang) {
        this.idPenumpang = idPenumpang;
    }
    
    public void setKontak (String kontak) {
        this.kontak = kontak;
    }
    
    public void setTanggalPesan (Date tanggalPesan) {
        this.tanggalPesan = tanggalPesan;
    }
    
    public void setHarga (int harga) {
        this.harga = harga;
    }
    
    public String getNamaPenumpang () {
        return namaPenumpang;
    }
    
    public long getIdPenumpang () {
        return idPenumpang;
    }
    
    public String getKontak () {
        return kontak;
    }
    
    public Date getTanggalPesan () {
        return tanggalPesan;
    }
    
    public double getHarga () {
        return harga;
    }

    @Override
    public String toString() {
        return namaPenumpang +" ("+idPenumpang+")";
    }
    
}