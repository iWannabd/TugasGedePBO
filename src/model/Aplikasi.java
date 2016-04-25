/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author azaqo
 */
//berguna untuk crud apapun
public class Aplikasi {
    List<Kereta> keretas; 
    List<Stasiun> stasiuns;
    List<Tiket> tikets;
    List<Rute> rutes;
    final static String keretajsonfile = "keretas.json";
    final static String stasiunjsonfile = "stasiuns.json";
    final static String tiketjsonfile = "tikets.json";
    final static String rutejsonfile = "rutes.json";

    public static String getKeretajsonfile() {
        return keretajsonfile;
    }

    public static String getStasiunjsonfile() {
        return stasiunjsonfile;
    }

    public static String getTiketjsonfile() {
        return tiketjsonfile;
    }

    public static String getRutejsonfile() {
        return rutejsonfile;
    }

    public void setKeretas(List<Kereta> keretas) {
        this.keretas = keretas;
    }

    public void setStasiuns(List<Stasiun> stasiuns) {
        this.stasiuns = stasiuns;
    }

    public void setTikets(List<Tiket> tikets) {
        this.tikets = tikets;
    }

    public void setRutes(List<Rute> rutes) {
        this.rutes = rutes;
    }

    public Aplikasi() {
        this.keretas = Collections.synchronizedList(new ArrayList<Kereta>());
        this.stasiuns = Collections.synchronizedList(new ArrayList<Stasiun>());
        this.tikets = Collections.synchronizedList(new ArrayList<Tiket>());
        this.rutes = Collections.synchronizedList(new ArrayList<Rute>());
        try {
            loadKeretas();
            loadStasiuns();
            loadRutes();
        } catch (IOException ex) {
            Logger.getLogger(Aplikasi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadKeretas() throws IOException{
        //load daftar kereta dari file
        Gson gson = new Gson();
        Type listOfKereta = new TypeToken<List<Kereta>>(){}.getType();
        Reader is = new InputStreamReader(new FileInputStream(keretajsonfile));
        keretas = Collections.synchronizedList(
                (List<Kereta>) gson.fromJson(is,listOfKereta)
        );
        is.close();
    }
    
    public void loadStasiuns() throws IOException{
        //load daftar stasiun dari file
        Gson gson = new Gson();
        Type listOfStasiun = new TypeToken<List<Stasiun>>(){}.getType();
        Reader is = new InputStreamReader(new FileInputStream(stasiunjsonfile));
        stasiuns = Collections.synchronizedList(
                (List<Stasiun>) gson.fromJson(is,listOfStasiun)
        );
        is.close();
        
    }
    
    public void loadTikets() throws IOException{
        //load daftar tiket dari file
        Gson gson = new Gson();
        Type listOfTiket = new TypeToken<List<Tiket>>(){}.getType();
        Reader is = new InputStreamReader(new FileInputStream(tiketjsonfile));
        tikets = Collections.synchronizedList(
                (List<Tiket>) gson.fromJson(is,listOfTiket)
        );
        is.close();
        
    }
    
    public void loadRutes() throws IOException{
        //load daftar tiket dari file
        Gson gson = new Gson();
        Type listOfRute = new TypeToken<List<Rute>>(){}.getType();
        Reader is = new InputStreamReader(new FileInputStream(rutejsonfile));
        rutes = Collections.synchronizedList(
                (List<Rute>) gson.fromJson(is,listOfRute)
        );
        is.close();
        
    }

    public List<Kereta> getKeretas() {
        return keretas;
    }

    public List<Stasiun> getStasiuns() {
        return stasiuns;
    }
    
    public List<Tiket> getTikets() {
        return tikets;
    }
    
    public List<Rute> getRutes() {
        return rutes;
    }
    
    public void komit() throws IOException{
        Gson gson = new Gson();
        Writer os = new OutputStreamWriter(new FileOutputStream(keretajsonfile));
        gson.toJson(keretas,os);
        os.close();
    }
    
    public void writeKeretas(Kereta k) throws IOException{
        //tulis keretas ke file
        Gson gson = new Gson();
        Writer os = new OutputStreamWriter(new FileOutputStream(keretajsonfile));
        keretas.add(k);
        
        gson.toJson(keretas,os);
        os.close();
    }
    
    public void writeStasiuns(Stasiun s) throws IOException{
        Gson gson = new Gson();
        Writer os = new OutputStreamWriter(new FileOutputStream(stasiunjsonfile));
        stasiuns.add(s);
        
        gson.toJson(stasiuns,os);
        os.close();
    }
    
    public void updateStasiun(int pos,Stasiun s) throws IOException{
        Gson gson = new Gson();
        Writer os = new OutputStreamWriter(new FileOutputStream(stasiunjsonfile));
        stasiuns.set(pos, s);
        
        gson.toJson(stasiuns,os);
        os.close();
        
    }
    
    public void deleteStasiun(int pos) throws IOException{
        Gson gson = new Gson();
        Writer os = new OutputStreamWriter(new FileOutputStream(stasiunjsonfile));
        stasiuns.remove(pos);
        
        gson.toJson(stasiuns,os);
        os.close();
    }
    
    public void writeTikets(Tiket t) throws IOException{
        Gson gson = new Gson();
        Writer os = new OutputStreamWriter(new FileOutputStream(tiketjsonfile));
        tikets.add(t);
        
        gson.toJson(tikets,os);
        os.close();
    }
    
    public void writeRutes(Rute r) throws IOException{
        Gson gson = new Gson();
        Writer os = new OutputStreamWriter(new FileOutputStream(rutejsonfile));
        rutes.add(r);
        
        gson.toJson(rutes,os);
        os.close();
    }
    
    public void updateRute(int pos,Rute r) throws IOException{
        Gson gson = new Gson();
        Writer os = new OutputStreamWriter(new FileOutputStream(rutejsonfile));
        rutes.set(pos, r);
        
        gson.toJson(rutes,os);
        os.close();
    }
    
    public void deleteRute(int pos) throws IOException{
        Gson gson = new Gson();
        Writer os = new OutputStreamWriter(new FileOutputStream(rutejsonfile));
        rutes.remove(pos);
        
        gson.toJson(rutes,os);
        os.close();
    }
    
    public void updateKereta(int pos, Kereta k) throws IOException{
        Gson gson = new Gson();
        Writer os = new OutputStreamWriter(new FileOutputStream(keretajsonfile));
        keretas.set(pos, k);
        
        gson.toJson(keretas,os);
        os.close();
    }
    
    public void deleteKereta(int pos) throws IOException{
        Gson gson = new Gson();
        Writer os = new OutputStreamWriter(new FileOutputStream(keretajsonfile));
        keretas.remove(pos);
        
        gson.toJson(keretas,os);
        os.close();
    }
}
