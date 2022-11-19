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
                    System.out.println("\n#--------------------------------#");
                    System.out.println("| Ban da thoat khoi chuong trinh |");
                    System.out.println("#--------------------------------#");
                    exit = true;
                    break;
                }
                case 1: {
                    nvManager.add();
                    break;
                }
                case 2: {
                    nvManager.edit();
                    break;
                }
                case 3: {
                    nvManager.delete();
                    break;
                }
                case 4: {
                    nvManager.printListALL();
                    break;
                }
                case 5: {
                    nvManager.printPersonalInfo();
                }
                break;
                case 6: {
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
                                System.out.println("-> Nhap 1 de them 1 than nhan.");
                                System.out.println("-> Nhap 2 de them nhieu than nhan");
                                System.out.print("Moi nhap lua chon: ");
                                int input2 = kiemTraChoice();
                                switch (input2) {
                                    case 1:
                                        tnManager.add(nvManager.getNhanVienList());
                                        break;
                                    case 2:
                                        System.out.print("Nhap so luong than nhan: ");
                                        int amount = (int) CHECK.kiemTraSoNguyenDuong();
                                        tnManager.add(nvManager.getNhanVienList(), amount);
                                        break;
                                    default:
                                        System.out.println("Ban da nhap sai lua chon.");
                                        break;
                                }
                                break;
                            }
                            case 2: {
                                tnManager.edit();
                                break;
                            }
                            case 3: {
                                tnManager.delete(nvManager.getNhanVienList());
                                break;
                            }
                            case 4: {
                                tnManager.printThanNhanList();
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
                    tnManager.printThanNhanList();
                    break;
                }
                case 8: {
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
                                ccManager.delete();
                                break;
                            }
                            case 4: {
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

    public static void menu() {
        System.out.println();
        System.out.println("##==================== MENU CHINH ====================##");
        System.out.println("||  Nhap 1 de them nhan vien.                         ||");
        System.out.println("||  Nhap 2 de sua thong tin nhan vien.                ||");
        System.out.println("||  Nhap 3 de xoa nhan vien.                          ||");
        System.out.println("||  Nhap 4 de xem thong tin toan bo nhan vien.        ||");
        System.out.println("||  Nhap 5 de xem thong tin cua mot nhan vien.        ||");
        System.out.println("||  Nhap 6 de quan ly than nhan.                      ||");
        System.out.println("||  Nhap 7 de xem toan bo than nhan.                  ||");
        System.out.println("||  Nhap 8 de quan ly cham cong                       ||");
        System.out.println("||  Nhap 0 de thoat.                                  ||");
        System.out.println("##====================================================##");
    }

    public static void editNhanVienMenu() {
        System.out.println();
        System.out.println("#---------- MENU SUA NHAN VIEN -----------#");
        System.out.println("|   Nhap 1 de sua ho va ten nhan vien.    |");
        System.out.println("|   Nhap 2 de sua ngay sinh.              |");
        System.out.println("|   Nhap 3 de sua gioi tinh.              |");
        System.out.println("|   Nhap 4 de sua so dien thoai.          |");
        System.out.println("|   Nhap 5 de sua dia chi.                |");
        System.out.println("|   Nhap 6 de sua chuc vu.                |");
        System.out.println("|   Nhap 0 de thoat                       |");
        System.out.println("#-----------------------------------------#");
    }

    public static void thanNhanMenu() {
        System.out.println();
        System.out.println("+-------------------- MENU THAN NHAN ---------------------+");
        System.out.println("|   Nhap 1 de them than nhan.                             |");
        System.out.println("|   Nhap 2 de chinh sua thong tin than nhan.              |");
        System.out.println("|   Nhap 3 de xoa 1 than nhan.                            |");
        System.out.println("|   Nhap 4 de in danh sach than nhan.                     |");
        System.out.println("|   Nhap 0 de thoat khoi chuc nang quan ly than nhan.     |");
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
        System.out.println("#------------ MENU CHAM CONG -------------#");
        System.out.println("|   Nhap 1 de them bang cham cong.        |");
        System.out.println("|   Nhap 2 de xoa cham cong.              |");
        System.out.println("|   Nhap 3 de chinh sua bang cham cong.   |");
        System.out.println("|   Nhap 4 de in bang cham cong.          |");
        System.out.println("|   Nhap 0 de thoat.                      |");
        System.out.println("#-----------------------------------------#");
    }

}
