/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import util.Util;
import interfaces.HanhDong;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import model.Dia;

/**
 *
 * @author Thanggun99
 */
public class DiaManager implements HanhDong{
    public static ArrayList<Dia> dias;
    private final Scanner scanner;

    public DiaManager() {
        loadDias();
        scanner = new Scanner(System.in);

    }
    
    @Override
    public void loadMenu(){
        int menu;

        do{
            menu = Util.menu("============== Quản lý đĩa ==============\n\n\n"
                + "1. Thêm đĩa\n"
                + "2. Danh sách đĩa\n"
                + "3. Tìm kiếm theo tên đĩa\n"
                + "4. Sắp xếp theo tên\n"
                + "5. Quay lại\n");
            
            switch(menu){
                case 1:
                    input();
                    break;
                case 2:
                    display();
                    scanner.nextLine();
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
    public void input() {
        String kq;
        Dia dia;
        do{
            dia = new Dia();
            System.out.println("Nhập mã đĩa");
            dia.setMaDia(scanner.nextLine());
            
            System.out.println("Nhập tên đĩa");
            dia.setTenDia(scanner.nextLine());
            
            System.out.println("Nhập thể loại");
            dia.setTheLoai(scanner.nextLine());
            
            dia.setTongSo(nhapSoLuong());
            
            dias.add(dia);
            
            System.out.println("Bạn có muốn nhập tiếp không (c/k) ?");
            kq = new Scanner(System.in).nextLine();
            
        }while(kq.equalsIgnoreCase("c"));
    }

    @Override
    public void display() {
        dias.forEach((d) -> {
            System.out.println(d.toString());
        });
    }
    
    @Override
    public void sapXep(){
        ArrayList<Dia> list = new ArrayList<>();
        list.addAll(dias);
        Collections.sort(list, new Comparator<Dia>() {
            @Override
            public int compare(Dia d1, Dia d2) {
                return d1.getTenDia().compareToIgnoreCase(d2.getTenDia());
            }
        });
        for(Dia d : list){
            System.out.println(d.toString());
        }
    }
    
    @Override
    public void timKiem(){
        System.out.println("Nhập từ cần tìm");
        String str = scanner.nextLine();
        for(Dia d : dias){
            if(d.getTenDia().contains(str)){
                System.out.println(d.toString());
            }
        }
    }
    
    public int nhapSoLuong(){
        System.out.println("Nhập tổng số");
        try{
            return new Scanner(System.in).nextInt();
        }catch(Exception e){
            return nhapSoLuong();
        }
    }
    
    private void loadDias(){
        dias = new ArrayList<>();
        
        dias.add(new Dia("D_05", 5, "Nhạc hot Việt 2016", "Ca nhạc"));
        dias.add(new Dia("D_09", 20, "5 anh em siêu nhân", "Hoạt Hình"));
        dias.add(new Dia("D_07", 7, "Xiếc", "Khoa học viễn tưởng"));
        dias.add(new Dia("D_06", 9, "Nhà tắm có nhiều cửa sổ", "Hành động"));
        dias.add(new Dia("D_13", 12, "Ở nhà một mình", "Tài liệu"));
    }

}
