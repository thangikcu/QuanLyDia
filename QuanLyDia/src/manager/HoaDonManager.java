/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import interfaces.HanhDong;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import model.Dia;
import model.HoaDon;
import model.HoaDonBan;
import model.HoaDonThue;
import util.Util;

/**
 *
 * @author Thanggun99
 */
public class HoaDonManager implements HanhDong{
    public static final int HOA_DON_BAN = 1;
    public static final int HOA_DON = 3;
    public static final int HOA_DON_THUE = 2;
    
    private ArrayList<HoaDon> hoaDons;
    private ArrayList<HoaDonBan> hoaDonBans;
    private ArrayList<HoaDonThue> hoaDonThues;
    private final Scanner scanner;

    public HoaDonManager() {
        loadHoaDon();
        scanner = new Scanner(System.in);
    }

    @Override
    public void input() {
        String kq;

        do{
            int menu = Util.menu("Bạn muốn nhập loại nào? \n"
                    + "1. Hóa đơn bán \n"
                    + "2. Hóa đơn thuê \n"
                    + "3. Quay lại\n");

            switch(menu){
                case 1:
                    nhapHoaDon(1);
                    break;
                case 2:
                    nhapHoaDon(2);
                    break;
                case 3:
                    return;
                default:
                    break;
            }
            System.out.println("Bạn có muốn nhập tiếp ko (c/k ) ?");
            kq = new Scanner(System.in).nextLine();
        }while(kq.equalsIgnoreCase("c"));
    }
    
    public void nhapHoaDon(int loaiHD){
        ArrayList<Dia> dias = new ArrayList<>();
        HoaDon hoaDon; 
        String sl;
        
        if(loaiHD == HOA_DON_BAN){
            hoaDon = new HoaDonBan();
            
            System.out.println("Nhập mã bán");
            ((HoaDonBan)hoaDon).setMaBan(scanner.nextLine());

            System.out.println("Nhập ngày bán");
            ((HoaDonBan)hoaDon).setNgayBan(scanner.nextLine());
        }else{
            hoaDon = new HoaDonThue(); 
            
            System.out.println("Nhập mã thuê");
            ((HoaDonThue)hoaDon).setMaThue(scanner.nextLine());

            System.out.println("Nhập ngày thuê");
            ((HoaDonThue)hoaDon).setNgayThue(scanner.nextLine()); 
        }
        
        System.out.println("Nhập tên khách hàng");
        hoaDon.setKhachHang(scanner.nextLine());

        System.out.println("Nhập nhân viên");
        hoaDon.setNhanVien(scanner.nextLine());

        System.out.println("Nhập danh sách đĩa");

        for(int i = 0; i < DiaManager.dias.size(); i++){
            Dia d = DiaManager.dias.get(i);
            System.out.println((i + 1) + ". " + d.toString());
        }

        do{
            dias.add(DiaManager.dias.get(chonDia()-1));
            System.out.println("Chọn tiếp(c/k) ?");
            sl = new Scanner(System.in).nextLine();
        }while(sl.equalsIgnoreCase("c"));

        hoaDon.setDanhSachDia(dias);

        hoaDons.add(hoaDon);
    }
    
    public int chonDia(){
        System.out.println("Chọn đĩa");
        try{
            int s = new Scanner(System.in).nextInt();
            if(s <= DiaManager.dias.size()) return s;
            return chonDia();
        }catch(Exception e){
            return chonDia();
        }
    }

    @Override
    public void display() {
        int menu;
        do{
            menu = Util.menu("============== Danh sách hóa đơn ==============\n\n\n"
                + "1. Danh sách hóa đơn\n"
                + "2. Danh sách hóa đơn bán\n"
                + "3. Danh sách hóa đơn thuê\n"
                + "4. Quay lại\n");

            switch(menu){
                case 1:
                    xuatHoaDon(HOA_DON);
                    break;
                case 2:
                    xuatHoaDon(HOA_DON_BAN);
                    break;
                case 3:
                    xuatHoaDon(HOA_DON_THUE);
                    break;
                case 4:
                    return;
                default:
                    break;
            }
        }while(menu != 4);
    }

    @Override
    public void loadMenu() {
        int menu;

        do{
            menu = Util.menu("============== Quản lý hóa đơn ==============\n\n\n"
                + "1. Nhập hóa đơn\n"
                + "2. Danh sách hóa đơn\n"
                + "3. Tìm kiếm theo tên khách hàng\n"
                + "4. Sắp xếp theo tên khách hàng\n"
                + "5. Quay lại\n");
            
            switch(menu){
                case 1:
                    input();
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    timKiem();
                    scanner.nextLine();
                    break;
                case 4:
                    sapXep();
                    scanner.nextLine();
                    break;
                case 5:
                    return;
                default:
                    break;
            }
        }while(menu != 5);
    }

    @Override
    public void timKiem() {
        System.out.println("Nhập từ cần tìm");
        String str = scanner.nextLine();
        for(HoaDon hd : hoaDons){
            if(hd.getKhachHang().contains(str)){
                System.out.println(hd.toString());
            }
        }
    }

    @Override
    public void sapXep() {
        ArrayList<HoaDon> list = new ArrayList<>();
        list.addAll(hoaDons);
        Collections.sort(list, new Comparator<HoaDon>() {
            @Override
            public int compare(HoaDon d1, HoaDon d2) {
                return d1.getKhachHang().compareToIgnoreCase(d2.getKhachHang());
            }
        });
        for(HoaDon hd : list){
            System.out.println(hd.toString());
        }
    }

    private void loadHoaDon() {
        hoaDons = new ArrayList<>();
        
        ArrayList<Dia> dias = new ArrayList<>();
        dias.add(DiaManager.dias.get(3));
        dias.add(DiaManager.dias.get(2));
        hoaDons.add(new HoaDonBan("HD_01", "06/05/1996", "Trần Văn Thắng", "Hòa", dias));
        hoaDons.add(new HoaDonThue("HD_02", "24/06/1996", "Phạm Trung Hòa", "Nhân viên 1", dias));
        hoaDons.add(new HoaDonBan("HD_03", "28/09/1996", "Bùi Như Lạc", "Nhân viên 2", dias));
    }

    private int chonHoaDonBan() {
        System.out.println("Chọn hóa đơn");
        try{
            int s = new Scanner(System.in).nextInt();
            if(s <= hoaDonBans.size()) return s;
            else return chonHoaDonBan();
        }catch(Exception e){
            return chonHoaDonBan();
        }
    }
    
    private int chonHoaDonThue(){
        System.out.println("Chọn hóa đơn");
        try {
            int s = new Scanner(System.in).nextInt();
            if(s <= hoaDonThues.size()) return s;
            return chonHoaDonThue();
        } catch (Exception e) {
            return chonHoaDonThue();
        }
    }
    private int chonHoaDon(){
        System.out.println("Chọn hóa đơn");
        try {
            int s = new Scanner(System.in).nextInt();
            if(s <= hoaDons.size()) return s;
            return chonHoaDon();
        } catch (Exception e) {
            return chonHoaDon();
        }
    }    

    private void xuatHoaDon(int loaiHD) {
        int menu2, index = 1;
        String hds = "";

        if(loaiHD == HOA_DON){
            for(HoaDon hd : hoaDons){
                hds += index + ". " + hd.toString()+"\n";
                index ++;
            }            

        }else if(loaiHD == HOA_DON_BAN){
            hoaDonBans = new ArrayList<>();
            for(int i = 0; i < hoaDons.size(); i++){
                HoaDon hd = hoaDons.get(i);
                if(hd instanceof HoaDonBan){
                    hds += index + ". " + hd.toString()+"\n";
                    index ++;
                    hoaDonBans.add((HoaDonBan) hd);
                }
            }
        }else{
            hoaDonThues = new ArrayList<>();
            for(int i = 0; i < hoaDons.size(); i++){
                HoaDon hd = hoaDons.get(i);
                if(hd instanceof HoaDonThue){
                    hds += index + ". " + hd.toString()+"\n";
                    index ++;
                    hoaDonThues.add((HoaDonThue) hd);
                }
            }            
        }

        do{
            menu2 = Util.menu("============== Danh sách ==============\n\n\n"
                + hds
                + "\n1. Xem chi tiết\n"
                + "2. Quay lại\n");

            switch(menu2){
                case  1:
                    if(loaiHD == HOA_DON){
                        for(Dia d : hoaDons.get(chonHoaDon()-1).getDanhSachDia()){
                         System.out.println(d.toString());
                        }                        
                    }else if(loaiHD == HOA_DON_BAN){
                        for(Dia d : hoaDonBans.get(chonHoaDonBan()-1).getDanhSachDia()){
                         System.out.println(d.toString());
                        }                        
                    }else{
                        for(Dia d : hoaDonThues.get(chonHoaDonThue()-1).getDanhSachDia()){
                         System.out.println(d.toString());
                        }                        
                    }
 
                    scanner.nextLine();
                    break;
                case 2:
                    return;
                default:
                    break;
            }

        }while(menu2 != 2);
    }
    
}
