/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasgedepbo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Aplikasi;
import model.Gerbong;
import model.Kereta;
import model.Rute;
import model.Stasiun;
import model.Tiket;

/**
 *
 * @author node06
 */
public class TugasGedePBO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException, IOException {

//          Application.main_menu();
//        ArrayList<Rute> coba = new ArrayList<>();
//        coba.add(new Rute(new Stasiun("Bandung","KiaraCondong"),new Stasiun("Yogyakarta","Tugu"),new Date(),new Date()));
//        Gson gson = new GsonBuilder().create();
//        Writer writer;
//        writer = new OutputStreamWriter(new FileOutputStream("route.json") , "UTF-8");
//        gson.toJson(coba,writer);
//        writer.close();
//        ArrayList<Stasiun> ah = new ArrayList<>();
//        Application.tempStation.add(new Stasiun("Bandung","KiaraCondong"));
//        Application.tempStation.add(new Stasiun("Yogyakarta","Tugu"));
//        Application.tempStation.add(new Stasiun("Malang","Malang Kota Lama"));
//        for (Stasiun arg : Application.tempStation) {
//            System.out.println(arg.getNamaStasiun());
//        }
//        try {
//            Application.write_Station();
//        } catch (UnsupportedEncodingException ex) {
//            Logger.getLogger(TugasGedePBO.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(TugasGedePBO.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(TugasGedePBO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
            
//        Scanner sc = new Scanner(System.in);
//        Double a = sc.nextDouble();
//        try(Writer writer = new OutputStreamWriter(new FileOutputStream("route.json") , "UTF-8")){
//            Gson gson = new GsonBuilder().create();
//            
//            ArrayList<Rute> routes = new ArrayList<>();
//            
//            Rute route = new Rute();
//            route.setAwal(new Stasiun("Bandung","Bandung"));
//            routes.add(route);
//            gson.toJson(routes,writer);
//        } catch (IOException ex) {
//            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
//        }

//        try{
//            Reader reader;
//            reader = new InputStreamReader(new FileInputStream("route.json"));
//            Gson gson = new GsonBuilder().create();
//            Type listType = new TypeToken<ArrayList<Rute>>(){
//            }.getType();
//            ArrayList<Rute> p = gson.fromJson(reader,listType);
//            p.stream().forEach((rute) -> {
//                System.out.println(rute.getAwal().getNamaStasiun());
//            });
//        } catch (IOException ex) {
//            Logger.getLogger(TugasGedePBO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        Aplikasi app = new Aplikasi();
//        app.loadKeretas();
//        List<Kereta> a = app.getKeretas();
//        for (Kereta kereta : a) {
//            System.out.println(kereta.getNama());
//        }
//        System.out.println("");
//            Kereta k = new Kereta("Malabar",2);
//            k.addGerbong(new Gerbong());
//            Tiket t = new Tiket("asd",123,"0132",new Date(),1);
//            for (int i = 0; i < 25; i++) {
//                k.addPenumpang(t);
//            }
//            
//            Gson g = new GsonBuilder().setPrettyPrinting().create();
//            System.out.println(g.toJson(k));
          
//Aplikasi app = new Aplikasi();
//new Controller.ControllerMenuPemesanan(app);
    Console c = new Console();
    c.mainMenu();


    
            
    }
    
}
