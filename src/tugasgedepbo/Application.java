///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package tugasgedepbo;
//
//import model.Gerbong;
//import model.Rute;
//import model.Stasiun;
//import model.Tiket;
//import model.Kereta;
//import java.util.*;
//import java.io.*;
//import com.google.gson.*;
//import com.google.gson.reflect.TypeToken;
//import java.lang.reflect.Type;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import model.*;
//
//
///**
// *
// * @author node06
// */
//public class Application {
//    public static int a;
//    public static String b;
//    public static double c;
//    public static Scanner sc = new Scanner(System.in);
//    private static final String fortang = "yyyy-MM-dd HH:mm";
//    public static SimpleDateFormat sdf = new SimpleDateFormat(fortang);
//    
//    public static ArrayList<Tiket> tempTickets = new ArrayList<>();
//    public static ArrayList<Stasiun> tempStation = new ArrayList<>();
//    public static ArrayList<Kereta> tempKereta = new ArrayList<>();
//    public static ArrayList<Gerbong> tempGerbong = new ArrayList<>();
//    public static Gson gson = new GsonBuilder().create();
//    //file manager
//    public static void load_ticekt() throws FileNotFoundException{
//        Reader reader;
//        reader = new InputStreamReader(new FileInputStream("ticket.json"));
//        Type listType = new TypeToken<ArrayList<Tiket>>(){
//        }.getType();
//        tempTickets = gson.fromJson(reader,listType);
//    }
//    
//    public static void load_Station() throws FileNotFoundException{
//        Reader reader;
//        reader = new InputStreamReader(new FileInputStream("station.json"));
//        Type listType = new TypeToken<ArrayList<Stasiun>>(){
//        }.getType();
//        tempStation = gson.fromJson(reader,listType);
//    }
//    public static void load_Train() throws FileNotFoundException{
//        Reader reader;
//        reader = new InputStreamReader(new FileInputStream("train.json"));
//        Type listType = new TypeToken<ArrayList<Kereta>>(){
//        }.getType();
//        tempKereta = gson.fromJson(reader,listType);
//    }
//    
//    public static void load_Gerbong() throws FileNotFoundException{
//        Reader reader;
//        reader = new InputStreamReader(new FileInputStream("gerbong.json"));
//        Type listType = new TypeToken<ArrayList<Gerbong>>(){
//        }.getType();
//        tempGerbong = gson.fromJson(reader,listType);
//    }
//    
//    public static void write_ticket() throws UnsupportedEncodingException, FileNotFoundException{
//        Writer writer;
//        writer = new OutputStreamWriter(new FileOutputStream("ticket.json") , "UTF-8");
//        gson.toJson(tempTickets,writer);
//    }
//    
//    public static void write_Station() throws UnsupportedEncodingException, FileNotFoundException, IOException{
//        Writer writer;
//        writer = new OutputStreamWriter(new FileOutputStream("station.json") , "UTF-8");
//        gson.toJson(tempStation,writer);
//        writer.close();
//    }
//    public static void write_Train() throws UnsupportedEncodingException, FileNotFoundException{
//        Writer writer;
//        writer = new OutputStreamWriter(new FileOutputStream("train.json") , "UTF-8");
//        gson.toJson(tempKereta,writer);
//    }
//    public static void write_Gerbong() throws UnsupportedEncodingException, FileNotFoundException{
//        Writer writer;
//        writer = new OutputStreamWriter(new FileOutputStream("gerbong.json") , "UTF-8");
//        gson.toJson(tempKereta,writer);
//    }
//    //end of file manager
//    
//    public static void main_menu(){
//        System.out.println("Welcome to Train System Information Service \n "
//                + "1. Buy Ticket \n"
//                + "2. Admin Menu \n");
//        a = sc.nextInt();
//        switch (a){
//            case 1:
////                not yet
//            case 2:
//                admin_menu();
//        }
//    }
//    
//    public static void admin_menu(){
//        
//        System.out.println("Hello Mr. Admin \n"
//                + "1. Manage Station \n"
//                + "2. Manage Route \n");
//        a = sc.nextInt();
//        switch (a){
//            case 2:
//                try {
//                    manage_route();
//                } catch (FileNotFoundException ex) {
//                    Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                break;
//            default:
//                admin_menu();
//        }
//        main_menu();
//        
//    }
//    
//    public static void manage_route() throws FileNotFoundException{
//        Reader reader;
//        reader = new InputStreamReader(new FileInputStream("route.json"));
//        
//        Type listType = new TypeToken<ArrayList<Rute>>(){
//        }.getType();
//        ArrayList<Rute> routes = gson.fromJson(reader,listType);
//        
//        System.out.println("ukuran"+routes.size());
//        if(!routes.isEmpty()){
//            routes.stream().forEach((rute) -> {
//                System.out.println(rute.getAwal().getNamaStasiun());
//            });
//        } else {
//            System.out.println("No Data \n");
//        }
//        
//        System.out.println("1. add route");
//        System.out.println("2. edit or delete route?");
//        a = sc.nextInt();
//
//        switch(a){
//            case 1:
//                load_Station();
//                Rute baru = new Rute();
//                for (Stasiun stat : tempStation) {
//                    System.out.println(stat.getKota() + "in" + stat.getNamaStasiun());
//                }
//                System.out.println("select initial station");
//                a = sc.nextInt();
//                baru.setAwal(tempStation.get(a));
//                
//                System.out.println("select destination station");
//                baru.setTujuan(tempStation.get(sc.nextInt()));
//                
//                System.out.println("enter departure date time"+fortang);
//                try {
//                    baru.setBerangkat(sdf.parse(sc.nextLine()));
//                } catch (ParseException ex) {
//                    Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                
//                System.out.println("enter arial date time");
//                try {
//                    baru.setTiba(sdf.parse(sc.next()));
//                } catch (ParseException ex) {
//                    Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                
//                routes.add(baru);
//            case 2:
//                routes = udel_route(routes);
//        }
//        
//        try(Writer writer = new OutputStreamWriter(new FileOutputStream("route.json") , "UTF-8")){
//            gson.toJson(routes,writer);
//        } catch (IOException ex) {
//            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        admin_menu();
//        
//    }
//
//    private static ArrayList<Rute> udel_route(ArrayList<Rute> routes) {
//        System.out.println("which route?");
//        a = sc.nextInt();
//        Rute temp = routes.get(a);
//        int x = a;
//        ArrayList<Rute> sementara = routes;
//        System.out.println(temp.getAwal().getKota()+"("+temp.getAwal().getNamaStasiun()+")");
//        System.out.println(temp.getTujuan()+"("+temp.getTujuan().getNamaStasiun()+")");
//        System.out.println(temp.getBerangkat());
//        System.out.println(temp.getTiba());
//        System.out.println("\n what change? \n"
//                + "1. initial station \n"
//                + "2. destination \n"
//                + "3. departure time \n"
//                + "4. arrival time \n"
//                + "5. or delete it \n"
//                );
//        a = sc.nextInt();
//        switch(a){
//            case 1:
////                            muat data stasiun
//                System.out.println("not yet available");
//            case 2:
////                            muat data stasiun
//                System.out.println("not yet available");
//            case 3:
//                System.out.println(fortang);
//                b = sc.nextLine();
//                try {
//                    temp.setBerangkat(sdf.parse(b));
//                } catch (ParseException ex) {
//                    Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                break;
//            case 4:
//                System.out.println(fortang);
//                b = sc.nextLine();
//                try {
//                    temp.setTiba(sdf.parse(b));
//                } catch (ParseException ex) {
//                    Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                break;
//            case 5:
//                sementara.remove(x);
//                return sementara;
//        }
//        sementara.set(x, temp);
//        return sementara;
//    }  
//
//    private static ArrayList<Tiket> manage_ticket(ArrayList<Tiket> tickets) {
//        ArrayList<Tiket> sementara = tickets;
//        Tiket temp;
//        System.out.println("which ticket do you want to delete?");
//        sementara.stream().forEach((tiket) -> {
//            System.out.println(tiket.getNamaPenumpang()+"("+tiket.getIdPenumpang()+")");
//        });
//        a = sc.nextInt();
//        sementara.remove(a);
//        return sementara;   
//    }
//
//    private static void manage_Station() {
//        
//    }
//}
