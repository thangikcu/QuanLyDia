/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Thanggun99
 */
public abstract class HoaDon {
    protected String khachHang, nhanVien;
    protected ArrayList<Dia> danhSachDia;

    public HoaDon() {
    }
    
    public HoaDon(String khachHang, String nhanVien, ArrayList<Dia> danhSachDia) {
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.danhSachDia = danhSachDia;
    }

    public String getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(String khachHang) {
        this.khachHang = khachHang;
    }

    public String getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(String nhanVien) {
        this.nhanVien = nhanVien;
    }

    public ArrayList<Dia> getDanhSachDia() {
        return danhSachDia;
    }

    public void setDanhSachDia(ArrayList<Dia> danhSachDia) {
        this.danhSachDia = danhSachDia;
    }
    

    
    
}
