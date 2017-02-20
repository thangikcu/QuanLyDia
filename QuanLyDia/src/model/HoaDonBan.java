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
public class HoaDonBan extends HoaDon{
    private String maBan, ngayBan;

    public HoaDonBan(String maBan, String ngayBan, String khachHang, String nhanVien, ArrayList<Dia> danhSachDia) {
        super(khachHang, nhanVien, danhSachDia);
        this.maBan = maBan;
        this.ngayBan = ngayBan;
    }

    public HoaDonBan() {
    }


    public String getMaBan() {
        return maBan;
    }

    public void setMaBan(String maBan) {
        this.maBan = maBan;
    }

    public String getNgayBan() {
        return ngayBan;
    }

    public void setNgayBan(String ngayBan) {
        this.ngayBan = ngayBan;
    }
    
    @Override
    public String toString(){
        return "\t Mã bán: " + maBan + "\t Khách hàng: " + khachHang + "\t Ngày bán: " + ngayBan + "\t Nhân viên: " + nhanVien + "\t Số lượng: " + danhSachDia.size();
    }
    
}
