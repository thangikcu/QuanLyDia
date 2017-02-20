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
public class HoaDonThue extends HoaDon{
    private String maThue, ngayThue;

    public HoaDonThue(String maThue, String ngayThue, String khachHang, String nhanVien, ArrayList<Dia> danhSachDia) {
        super(khachHang, nhanVien, danhSachDia);
        this.maThue = maThue;
        this.ngayThue = ngayThue;
    }

    public HoaDonThue() {
    }

    public String getMaThue() {
        return maThue;
    }

    public void setMaThue(String maThue) {
        this.maThue = maThue;
    }

    public String getNgayThue() {
        return ngayThue;
    }

    public void setNgayThue(String ngayThue) {
        this.ngayThue = ngayThue;
    }
    
    @Override
    public String toString(){
        return "\t Mã thuê: " + maThue + "\t Khách hàng: " + khachHang + "\t Ngày thuê: " + ngayThue + "\t Nhân viên: " + nhanVien + "\t Số lượng: " + danhSachDia.size();
    } 
    
    
}
