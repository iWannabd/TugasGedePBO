/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasgedepbo;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;

/**
 *
 * @author azaqo
 */
public class Console {
    private Aplikasi model;
    private Scanner sc;
    private String pil;

    public Console() {
        model = new Aplikasi();
        sc = new Scanner(System.in);
        pil="";
    }
    
    public void mainMenu(){
        System.out.println("Halo, apakah anda admin atau pengguna? ");
        pil = sc.nextLine();
        switch (pil){
                case "admin":
                    break;
                case "pengguna":
                    pengguna();
                    break;
                default:
                    mainMenu();
                    break;
        }
        
    }
    
    public void pengguna(){
        System.out.println("berikut adalah daftar rute dan kereta yang tersedia");
        int i=0;
        for (Kereta k : model.getKeretas()) {
            System.out.println(i+". "+k.toString());
            i++;
        }
        System.out.println("Silahkan pilih kereta");
        int d = sc.nextInt();
        System.out.println("Silahkan masukan data lengkap anda mulai dari nama: ");
        String a = sc.nextLine();
        System.out.println("Lalu nomor identitas anda: ");
        Long b = sc.nextLong();
        System.out.println("Lalu kontak yang dapat dihubungi: ");
        String c = sc.nextLine();
        
        Kereta k = model.getKeretas().get(d);
        
        Tiket t = new Tiket(a,b,c,new Date(),k.getRoute().getHarga());
        k.addPenumpang(t);
        try {
            model.updateKereta(d, k);
        } catch (IOException ex) {
            Logger.getLogger(Console.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            
    
}
