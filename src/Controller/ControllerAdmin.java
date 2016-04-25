/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;
import view.menuAdmin;

/**
 *
 * @author node06
 */
public class ControllerAdmin extends MouseAdapter implements ActionListener {
    
    Aplikasi model;
    menuAdmin view;

    public ControllerAdmin() {
        this.model = new Aplikasi();
        this.view = new menuAdmin();
        view.setVisible(true);
        view.addListener(this);
        view.addAdapter(this);
        view.setDataStasiun(model.getStasiuns());
        view.setDataRute(model.getRutes());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
          Object src = e.getSource();
          //untuk CRUD Stasiun
          if (src.equals(view.getBtnAdd())){
              Stasiun s = new Stasiun(view.getStasiun().getText(), view.getKota().getText());
              try {
                  model.writeStasiuns(s);
              } catch (IOException ex) {
                  Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
              }
              view.setDataStasiun(model.getStasiuns());
          }
          if (src.equals(view.getBtnUpdate())){
              Stasiun s;
              s = new Stasiun(view.getStasiun().getText(), view.getKota().getText());
              try {
                  model.updateStasiun(view.getListStasiun().getSelectedIndex(), s);
              } catch (IOException ex) {
                  Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
              }
              view.setDataStasiun(model.getStasiuns());
          }
          if (src.equals(view.getBtnDelete())){
              try {
                  model.deleteStasiun(view.getListStasiun().getSelectedIndex());
              } catch (IOException ex) {
                  Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
              }
              view.setDataStasiun(model.getStasiuns());
          }
          //untuk CRUD rute
         if (src.equals(view.getBtnAdd1())){
             Stasiun a = model.getStasiuns().get(view.getListStasiunAwal().getSelectedIndex());
             Stasiun b = model.getStasiuns().get(view.getTujuan().getSelectedIndex());
             Rute r = new Rute(a,b,(Date)view.getBerangkat().getValue(),(Date)view.getTiba().getValue(),Double.parseDouble(view.getHarga().getText()));
              try {
                  model.writeRutes(r);
              } catch (IOException ex) {
                  Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
              }
              view.setDataRute(model.getRutes());
         }
         if (src.equals(view.getBtnUpdate1())){
            int dipilih = view.getListRute().getSelectedIndex();
            Stasiun a = model.getStasiuns().get(view.getListStasiunAwal().getSelectedIndex());
            Stasiun b = model.getStasiuns().get(view.getTujuan().getSelectedIndex());
            Rute r = new Rute(a,b,(Date)view.getBerangkat().getValue(),(Date)view.getTiba().getValue(),Double.parseDouble(view.getHarga().getText()));
              try {
                  model.updateRute(dipilih, r);
              } catch (IOException ex) {
                  Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
              }
            view.setDataRute(model.getRutes());
         }
         if (src.equals(view.getBtnDelete1())){
            int dipilih = view.getListRute().getSelectedIndex();
              try {
                  model.deleteRute(dipilih);
              } catch (IOException ex) {
                  Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
              }
              view.setDataRute(model.getRutes());
         }
    }
    
    public void mousePressed(MouseEvent e){
        Object src = e.getSource();
        if (src.equals(view.getListStasiun())){
            Stasiun s = model.getStasiuns().get(view.getListStasiun().getSelectedIndex());
            view.getStasiun().setText(s.getNamaStasiun());
            view.getKota().setText(s.getKota());
        }
        if (src.equals(view.getListRute())){
            int dipilih = view.getListRute().getSelectedIndex();
            Rute r = model.getRutes().get(dipilih);
            view.getListStasiunAwal().setSelectedItem(r.getAwal().toString());
            view.getTujuan().setSelectedItem(r.getTujuan().toString());
            view.getBerangkat().setValue((Date)r.getBerangkat());
            view.getTiba().setValue((Date)r.getTiba());
            view.getHarga().setText(""+r.getHarga());
        }
    }
    
}
