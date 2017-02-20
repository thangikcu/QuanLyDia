
import util.Util;
import manager.DiaManager;
import manager.HoaDonManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thanggun99
 */
public class Main {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DiaManager diaManager = diaManager = new DiaManager();
        HoaDonManager hoaDonManager = hoaDonManager = new HoaDonManager();
        int menu;
        do{
            menu = Util.menu("============== Trang chủ ==============\n\n\n"
                + "1. Quản lý đĩa\n"
                + "2. Quản lý hóa đơn\n"
                + "3. Thoát\n");

            switch(menu){
                case 1:
                    diaManager.loadMenu();
                    break;
                case 2:
                    hoaDonManager.loadMenu();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }while(menu != 3);
    }
    
}
