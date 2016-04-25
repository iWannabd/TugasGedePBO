/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author node06
 */
public class Rute {
    private Stasiun awal;
    private Stasiun tujuan;
    private Date berangkat;
    private Date tiba;
    private double harga;

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public Rute(Stasiun awal, Stasiun tujuan, Date berangkat, Date tiba) {
        this.awal = awal;
        this.tujuan = tujuan;
        this.berangkat = berangkat;
        this.tiba = tiba;
    }

    public Rute(Stasiun awal, Stasiun tujuan, Date berangkat, Date tiba, double harga) {
        this.awal = awal;
        this.tujuan = tujuan;
        this.berangkat = berangkat;
        this.tiba = tiba;
        this.harga = harga;
    }

    @Override
    public String toString() {
        return awal.toString() + " - " +tujuan.toString();
    }
    
    
    
    /**
     * @return the awal
     */
    public Stasiun getAwal() {
        return awal;
    }

    /**
     * @param awal the awal to set
     */
    public void setAwal(Stasiun awal) {
        this.awal = awal;
    }

    /**
     * @return the tujuan
     */
    public Stasiun getTujuan() {
        return tujuan;
    }

    /**
     * @param tujuan the tujuan to set
     */
    public void setTujuan(Stasiun tujuan) {
        this.tujuan = tujuan;
    }

    /**
     * @return the berangkat
     */
    public Date getBerangkat() {
        return berangkat;
    }

    /**
     * @param berangkat the berangkat to set
     */
    public void setBerangkat(Date berangkat) {
        this.berangkat = berangkat;
    }

    /**
     * @return the tiba
     */
    public Date getTiba() {
        return tiba;
    }

    /**
     * @param tiba the tiba to set
     */
    public void setTiba(Date tiba) {
        this.tiba = tiba;
    }

    /**
     * @return the tickets
     */
}
