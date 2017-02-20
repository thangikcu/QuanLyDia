/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Thanggun99
 */
public class Dia {
    private int tongSo;
    private String tenDia, theLoai, maDia;

    public Dia() {
    }

    
    public Dia(String maDia, int tongSo, String tenDia, String theLoai) {
        this.maDia = maDia;
        this.tongSo = tongSo;
        this.tenDia = tenDia;
        this.theLoai = theLoai;
    }

    public String getMaDia() {
        return maDia;
    }

    public void setMaDia(String maDia) {
        this.maDia = maDia;
    }

    public int getTongSo() {
        return tongSo;
    }

    public void setTongSo(int tongSo) {
        this.tongSo = tongSo;
    }

    public String getTenDia() {
        return tenDia;
    }

    public void setTenDia(String tenDia) {
        this.tenDia = tenDia;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }
    
    @Override
    public String toString(){
       return "\t Mã đĩa: " + maDia + "\t Tên đĩa: " + tenDia + "\t Thể loại: " + theLoai + "\t Số lượng: "+ tongSo;
    }
    
    
}
