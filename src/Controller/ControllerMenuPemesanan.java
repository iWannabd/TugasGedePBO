/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;
import view.menuPemesanan;

/**
 *
 * @author azaqo
 */
public class ControllerMenuPemesanan extends MouseAdapter implements ActionListener{
    Aplikasi model;
    menuPemesanan view;

    public ControllerMenuPemesanan(Aplikasi model) {
        this.model = model;
        this.view = new menuPemesanan();
        view.setVisible(true);
        view.addListener(this);
        view.addAdapter(this);
        view.setData(model.getKeretas());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnPesan())){
            List<Kereta> ks = model.getKeretas();
            int dipilih = view.getjList1().getSelectedIndex();
            Kereta k = ks.get(dipilih);
            
            Tiket t = new Tiket(view.getNama(),Integer.parseInt(view.getIdPenum()),view.getKontak(),new Date(),0);
            
            k.addPenumpang(t);
            ks.set(dipilih, k);
            model.setKeretas(ks);
            try {
                model.komit();
            } catch (IOException ex) {
                Logger.getLogger(ControllerMenuPemesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (source.equals(view.getBtnAdmin())){
            new ControllerAdmin();
        }
    }
    
}
