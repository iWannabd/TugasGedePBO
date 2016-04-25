/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import model.*;
import view.*;

/**
 *
 * @author azaqo
 */
public class ControllerMenuAdmin implements ActionListener{
    Aplikasi model;
    menuAdmin view;

    public ControllerMenuAdmin(Aplikasi model) {
        this.model = model;
        this.view = new menuAdmin();
        this.view.setVisible(true);
        this.view.addListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
    }
}
