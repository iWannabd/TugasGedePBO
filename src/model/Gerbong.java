/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Muhammad 'Aizul F
 */
public class Gerbong {
    private int maxPenumpang;
    private int i = 0;

    
    private Tiket[] tickets;
    public Tiket[] getTickets() {
        return tickets;
    }

    public Gerbong() {
        this.maxPenumpang = 20;
        this.tickets = new Tiket[maxPenumpang];
    }

    public Gerbong(int maxpen) {
        this.maxPenumpang = maxpen;
        this.tickets = new Tiket[maxPenumpang];
    }
    
    
    public boolean addPenumpang(Tiket t){
        if (i < maxPenumpang){
            tickets[i] = t;
            i ++;
            return true;
        } else {
            return false;
        }
    }

    public int getMaxPenumpang() {
        return maxPenumpang;
    }

    public void setMaxPenumpang(int maxPenumpang) {
        this.maxPenumpang = maxPenumpang;
    }
}
