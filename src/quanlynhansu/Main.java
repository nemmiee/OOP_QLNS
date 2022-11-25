/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quanlynhansu;

import java.util.Scanner;

public class Main {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        mainMenuChoice();
    }

    public static String inHoaChuCaiDauMoiTu(String s) {
        char[] charArray = s.toCharArray();
        boolean foundSpace = true;
        for (int i = 0; i < charArray.length; i++) {
            // Nếu phần tử trong mảng là một chữ cái
            if (Character.isLetter(charArray[i])) {
                // Chuyển tất cả các chữ cái thành chữ in thường, khi hợp lệ thì mới in hoa
                charArray[i] = Character.toLowerCase(charArray[i]);
                // Kiểm tra khoảng trắng có trước chữ cái
                if (foundSpace) {
                    // Đổi chữ cái thành chữ in hoa
                    charArray[i] = Character.toUpperCase(charArray[i]);
                    foundSpace = false;
                }
            } else {
                foundSpace = true;
            }
        }
        // Chuyển đổi mảng char thành string
        s = String.valueOf(charArray);
        return s.trim();
    }

    public static String inHoaChuCaiDauTienCuaChuoi(String s) {
        s = s.trim();
        String firstLetter = s.substring(0, 1);
        firstLetter = firstLetter.toUpperCase();
        String remainingLetter = s.substring(1, s.length());
        char[] charArray = remainingLetter.toCharArray();
        for (int i = 0; i < remainingLetter.length(); ++i) {
            if (Character.isLetter(charArray[i])) {
                charArray[i] = Character.toLowerCase(charArray[i]);
            }
        }
        remainingLetter = String.valueOf(charArray);
        s = firstLetter + remainingLetter;
        return s;
    }

    public static String inHoaTatCaKyTu(String s) {
        s = s.trim();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length(); ++i) {
            if (Character.isLetter(charArray[i])) {
                charArray[i] = Character.toUpperCase(charArray[i]);
            }
        }
        s = String.valueOf(charArray);
        return s;
    }

    public static int kiemTraChoice() {
        int input;
        while (true) {
            try {
                input = Integer.parseInt(scan.nextLine());
                if (input >= 0) {
                    return input;
                } else {
                    System.out.print("Nhap sai lua chon.\nMoi nhap lua chon: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Nhap sai lua chon.\nMoi nhap lua chon: ");
            }
        }
    }

    public static void mainMenuChoice() {
        nhanvienManager nvManager = new nhanvienManager();
        thannhanManager tnManager = new thannhanManager();
        chamcongManager ccManager = new chamcongManager();
        luongManager luongManager = new luongManager();
        phongbanManager pbManager = new phongbanManager();
        menu();
        int choice = 0;
        boolean exit = false;
        while (true) {
            while (true) {
                System.out.print("Moi lua chon: ");
                try {
                    choice = Integer.parseInt(scan.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Nhap sai lua chon!");
                }
            }
            switch (choice) {
                case 0: {
                    System.out.println("\n          #================================#");
                    System.out.println("          | Ban da thoat khoi chuong trinh |");
                    System.out.println("          #================================#\n");
                    exit = true;
                    break;
                } 
                case 1: {
                    nvManager.add(pbManager.getPbList());
                    break;
                }
                case 2: {
                    nvManager.edit(pbManager.getPbList());
                    break;
                }
                case 3: {
                    nvManager.delete();
                    break;
                }
                case 4: {
                    nvManager.printListALL(pbManager.getPbList());
                    break;
                }
                case 5: {
                    nvManager.printPersonalInfo(pbManager.getPbList());
                    break;
                }
                case 6: {
                    // Than nhan
                    boolean flag = false;
                    while (flag == false) {
                        thanNhanMenu();
                        System.out.print("Moi lua chon: ");
                        int input1 = kiemTraChoice();
                        switch (input1) {
                            case 0:
                                System.out.println("Ban da thoat khoi chuc nang quan ly than nhan.\n");
                                flag = true;
                                break;
                            case 1: {
                                tnManager.add(nvManager.getNhanVienList());
                                break;
                            }
                            case 2: {
                                tnManager.edit(nvManager.getNhanVienList());
                                break;
                            }
                            case 3: {
                                tnManager.delete(nvManager.getNhanVienList());
                                break;
                            }
                            case 4: {
                                tnManager.printThanNhanList(nvManager.getNhanVienList());
                                break;
                            }
                            case 5: {
                                tnManager.printPersonalThanNhan(nvManager.getNhanVienList());
                                break;
                            }
                            default: {
                                System.out.println("Nhap sai lua chon.");
                                break;
                            }
                        }
                    }
                    break;
                }
                case 7: {
                    // Cham cong
                    int input;
                    boolean flag = false;
                    while (flag == false) {
                        chamCongMenu();
                        System.out.print("Moi lua chon: ");
                        input = kiemTraChoice();
                        switch (input) {
                            case 0: {
                                System.out.println("Ban da thoat khoi quan ly cham cong.");
                                flag = true;
                                break;
                            }
                            case 1: {
                                ccManager.add(nvManager.getNhanVienList());
                                break;
                            }
                            case 2: {
                                ccManager.delete(nvManager.getNhanVienList());
                                break;
                            }
                            case 3: {
                                System.out.print("Nhap nam: ");
                                int nam = (int) CHECK.kiemTraSoNguyenDuong();
                                System.out.print("Nhap thang: ");
                                int thang = (int) CHECK.kiemTraSoNguyenDuong();
                                if (thang > 0 && thang < 13) {
                                    ccManager.printList(nvManager.getNhanVienList(), thang, nam);
                                } else {
                                    System.out.println("Thang khong ton tai.");
                                }
                                break;
                            }
                            case 4: {
                                ccManager.printPersonal(nvManager.getNhanVienList());
                                break;
                            }
                            default: {
                                System.out.println("Nhap sai lua chon.");
                                break;
                            }
                        }
                    }
                    break;
                }
                case 8: {
                    // Tinh luong
                    int input;
                    boolean flag = false;
                    while (flag == false) {
                        tinhLuongMenu();
                        System.out.print("Moi lua chon: ");
                        input = kiemTraChoice();
                        switch (input) {
                            case 0: {
                                System.out.println("Ban da thoat khoi quan ly luong.");
                                flag = true;
                                break;
                            }
                            case 1: {
                                luongManager.add(nvManager.getNhanVienList(), ccManager.getCcList());
                                break;
                            }
                            case 2: {
                                luongManager.delete(nvManager.getNhanVienList());
                                break;
                            }
                            case 3: {
                                System.out.print("Nhap nam: ");
                                int nam = (int) CHECK.kiemTraSoNguyenDuong();
                                System.out.print("Nhap thang: ");
                                int thang = (int) CHECK.kiemTraSoNguyenDuong();
                                if (thang > 0 && thang < 13) {
                                    luongManager.printList(nvManager.getNhanVienList(), ccManager.getCcList(), thang, nam);
                                } else {
                                    System.out.println("Thang khong ton tai.");
                                }
                                break;
                            }
                            case 4: {
                                luongManager.printPersonal(nvManager.getNhanVienList(), ccManager.getCcList());
                                break;
                            }
                            default: {
                                System.out.println("Nhap sai lua chon.");
                                break;
                            }
                        }
                    }
                    break;
                }
                case 9: {
                    // Phong ban
                    int input;
                    boolean flag = false;
                    while (flag == false) {
                        phongBanMenu();
                        System.out.print("Moi lua chon: ");
                        input = kiemTraChoice();
                        switch (input) {
                            case 0: {
                                System.out.println("Ban da thoat khoi quan ly phong ban.");
                                flag = true;
                                break;
                            }
                            case 1: {
                                pbManager.add(nvManager.getNhanVienList());
                                break;
                            }
                            case 2: {
                                pbManager.addTruongPhong(nvManager.getNhanVienList());
                                break;
                            }
                            case 3: {
                                pbManager.delete();
                                break;
                            }
                            case 4: {
                                nvManager.deleteNVFromPhongBan(pbManager.getPbList());
                                break;
                            }
                            case 5: {
                                pbManager.editTenPhongBan();
                                break;
                            }
                            case 6: {
                                pbManager.editTruongPhong();
                                break;
                            }
                            case 7: {
                                pbManager.printSinglePhongBanInfo();
                                break;
                            }
                            case 8: {
                                pbManager.printList(); 
                                break;
                            }
                            case 9: {
                                pbManager.printNVPhongBanList(nvManager.getNhanVienList());
                                break;
                            }
                            case 10: {
                                nvManager.printNVKhongCoPhongBan();
                                break;
                            }
                            case 11: {                                
                                pbManager.printTruongPhongInfo(nvManager.getNhanVienList());
                                break;
                            }
                            default: {
                                System.out.println("Nhap sai lua chon.");
                                break;
                            }
                        }
                    }
                    break;
                }
                case 11: {
                    int input;
                    boolean flag = false;
                    while (!flag) {
                        searchMenu();
                        System.out.print("Moi lua chon: ");
                        input = kiemTraChoice();
                        switch (input) {
                            case 0: {
                                System.out.println("Ban da thoat.");
                                flag = true;
                                break;
                            }
                            case 1: {
                                nvManager.printPersonalInfo(pbManager.getPbList());
                                break;
                            }
                            case 2: {
                                nvManager.printNVByName(pbManager.getPbList());
                                break;
                            }
                            case 3: {
                                nvManager.printNVByGender(pbManager.getPbList());
                                break;
                            }
                            case 4: {
                                System.out.println("So luong nhan vien cua cong ty la: " + nvManager.getNhanVienList().length);
                                break;
                            }
                            case 5: {
                                System.out.println("So luong nhan vien chinh cua cong ty la: " + nvManager.getSoLuongNVChinh());
                                break;
                            }
                            case 6: {
                                System.out.println("So luong nhan vien phu cua cong ty la: " + nvManager.getSoLuongNVPhu());
                                break;
                            }
                            case 7: {
                                System.out.println("So luong thuc tap sinh cua cong ty la: " + nvManager.getSoLuongThucTapSinh());
                                break;
                            }
                            case 8: {
                                nvManager.printNVChinhList(pbManager.getPbList());
                                break;
                            }
                            case 9: {
                                nvManager.printNVPhuList(pbManager.getPbList());
                                break;
                            }
                            case 10: {
                                nvManager.printThucTapSinhList(pbManager.getPbList());
                                break;
                            }
                            default: {
                                System.out.println("Nhap sai lua chon.");
                                break;
                            }
                        }
                    }
                    break;
                }
                default: {
                    System.out.println("Nhap sai lua chon!");
                    break;
                }
            }
            if (exit) {
                break;
            }
            menu();
        }
    }

    public static void loaiNhanVien() {
        System.out.println();
        System.out.println("#-------------------------------------#");
        System.out.println("|   Nhap 1 de them nhan vien chinh.   |");
        System.out.println("|   Nhap 2 de them nhan vien phu.     |");
        System.out.println("|   Nhap 3 de them thuc tap sinh.     |");
        System.out.println("#-------------------------------------#");
    }

    public static void menu() {
        System.out.println();
        System.out.println("##==================== MENU CHINH ====================##");
        System.out.println("||  Nhap 1 de them nhan vien.                         ||");
        System.out.println("||  Nhap 2 de sua thong tin nhan vien.                ||");
        System.out.println("||  Nhap 3 de xoa nhan vien.                          ||");
        System.out.println("||  Nhap 4 de xem thong tin toan bo nhan vien.        ||");
        System.out.println("||  Nhap 5 de xem thong tin cua mot nhan vien.        ||");
        System.out.println("||  Nhap 6 de quan ly than nhan.                      ||");
        System.out.println("||  Nhap 7 de quan ly cham cong.                      ||");
        System.out.println("||  Nhap 8 de quan ly tinh luong.                     ||");
        System.out.println("||  Nhap 9 de quan ly phong ban.                      ||");
        System.out.println("||  Nhap 11 de xem nhung chuc nang khac.              ||");
        System.out.println("||  Nhap 0 de thoat.                                  ||");
        System.out.println("##====================================================##");
    }

    public static void editNhanVienMenu() {
        System.out.println();
        System.out.println("#------- MENU CHINH SUA NHAN VIEN --------#");
        System.out.println("|   Nhap 1 de sua ho va ten nhan vien.    |");
        System.out.println("|   Nhap 2 de sua gioi tinh.              |");
        System.out.println("|   Nhap 3 de sua ngay sinh.              |");
        System.out.println("|   Nhap 4 de sua so dien thoai.          |");
        System.out.println("|   Nhap 5 de sua dia chi.                |");
        System.out.println("|   Nhap 6 de sua chuc vu.                |");
        System.out.println("|   Nhap 7 de sua email.                  |");
        System.out.println("|   Nhap 8 de sua phong ban.              |");
        System.out.println("|   Nhap 0 de thoat.                      |");
        System.out.println("#-----------------------------------------#");
    }

    public static void thanNhanMenu() {
        System.out.println();
        System.out.println("+-------------------- MENU THAN NHAN ---------------------+");
        System.out.println("|   Nhap 1 de them than nhan.                             |");
        System.out.println("|   Nhap 2 de chinh sua thong tin than nhan.              |");
        System.out.println("|   Nhap 3 de xoa 1 than nhan.                            |");
        System.out.println("|   Nhap 4 de in danh sach than nhan.                     |");
        System.out.println("|   Nhap 5 de in than nhan cua 1 nhan vien.               |");
        System.out.println("|   Nhap 0 de thoat.                                      |");
        System.out.println("+---------------------------------------------------------+");
    }

    public static void editThanNhanMenu() {
        System.out.println();
        System.out.println("+------------ MENU CHINH SUA THAN NHAN ------------+");
        System.out.println("|   Nhap 1 de chinh sua ho ten than nhan.          |");
        System.out.println("|   Nhap 2 de doi gioi tinh than nhan.             |");
        System.out.println("|   Nhap 3 de chinh sua ngay sinh than nhan.       |");
        System.out.println("|   Nhap 4 de chinh sua quan he than nhan.         |");
        System.out.println("|   Nhap 0 de thoat.                               |");
        System.out.println("+--------------------------------------------------+");
    }

    public static void chamCongMenu() {
        System.out.println();
        System.out.println("#-------------- MENU CHAM CONG ---------------#");
        System.out.println("|   Nhap 1 de them bang cham cong.            |");
        System.out.println("|   Nhap 2 de xoa cham cong.                  |");
        System.out.println("|   Nhap 3 de in bang cham cong.              |");
        System.out.println("|   Nhap 4 de in bang cham cong cua ca nhan.  |");
        System.out.println("|   Nhap 0 de thoat.                          |");
        System.out.println("#---------------------------------------------#");
    }

    public static void tinhLuongMenu() {
        System.out.println();
        System.out.println("#-------------- MENU TINH LUONG ----------------#");
        System.out.println("|   Nhap 1 de them bang luong.                  |");
        System.out.println("|   Nhap 2 de xoa tinh luong.                   |");
        System.out.println("|   Nhap 3 de in bang tinh luong.               |");
        System.out.println("|   Nhap 4 de in bang tinh luong cua ca nhan.   |");
        System.out.println("|   Nhap 0 de thoat.                            |");
        System.out.println("#-----------------------------------------------#");
    }

    public static void phongBanMenu() {
        System.out.println();
        System.out.println("#-------------------- MENU PHONG BAN -----------------------#");
        System.out.println("|   Nhap 1 de them phong ban.                               |");
        System.out.println("|   Nhap 2 de them truong phong.                            |");
        System.out.println("|   Nhap 3 de xoa phong ban.                                |");
        System.out.println("|   Nhap 4 de xoa nhan vien khoi phong ban.                 |");
        System.out.println("|   Nhap 5 de thay doi ten phong ban.                       |");
        System.out.println("|   Nhap 6 de thay doi truong phong.                        |");
        System.out.println("|   Nhap 7 de tim kiem phong ban.                           |");
        System.out.println("|   Nhap 8 de in danh sach phong ban.                       |");
        System.out.println("|   Nhap 9 de in danh sach nhan vien trong phong ban.       |");
        System.out.println("|   Nhap 10 de in danh sach nhan vien khong co phong ban.   |");
        System.out.println("|   Nhap 11 de in thong tin cac truong phong.               |");
        System.out.println("|   Nhap 0 de thoat.                                        |");
        System.out.println("#-----------------------------------------------------------#");
    }

    public static void searchMenu() {
        System.out.println();
        System.out.println("#-------------- MENU CAC CHUC NANG KHAC ----------------#");
        System.out.println("|   Nhap 1 de tim nhan vien theo ma nhan vien.          |");
        System.out.println("|   Nhap 2 de tim nhan vien theo ten.                   |");
        System.out.println("|   Nhap 3 de tim nhan vien theo gioi tinh.             |");
        System.out.println("|   Nhap 4 de xem so luong nhan vien cua cong ty.       |");
        System.out.println("|   Nhap 5 de xem so luong nhan vien chinh.             |");
        System.out.println("|   Nhap 6 de xem so luong nhan vien phu.               |");
        System.out.println("|   Nhap 7 de xem so luong thuc tap sinh.               |");
        System.out.println("|   Nhap 8 de xem danh sach nhan vien chinh.            |");
        System.out.println("|   Nhap 9 de xem danh sach nhan vien phu.              |");
        System.out.println("|   Nhap 10 de xem danh sach thuc tap sinh.             |");
        System.out.println("|   Nhap 0 de thoat.                                    |");
        System.out.println("#-------------------------------------------------------#");
    }
}
