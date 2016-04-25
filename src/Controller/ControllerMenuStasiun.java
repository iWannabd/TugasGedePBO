/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import model.Aplikasi;
import view.menuStasiun;

/**
 *
 * @author azaqo
 */
public class ControllerMenuStasiun extends MouseAdapter implements ActionListener {

    Aplikasi model;
    menuStasiun view;

    public ControllerMenuStasiun(Aplikasi model) {
        this.model = model;
        this.view = new menuStasiun();
        view.setVisible(true);
        view.mouseAdapter(this);
        view.addListener(this);
        view.setDataLsit(model.getStasiuns());
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object s = e.getSource();
    }
    
}
