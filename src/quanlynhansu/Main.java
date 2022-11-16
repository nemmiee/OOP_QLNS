/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quanlynhansu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        mainMenuChoice();
    }

    public static Scanner scan = new Scanner(System.in);

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

    public static void mainMenuChoice() {
        nhanvienManager nvManager = new nhanvienManager();
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
                }
                break;

                case 1: {
                    nvManager.add();
                }
                break;

                case 2: {
                    nvManager.edit();
                }
                break;

                case 3: {
                    nvManager.delete();
                }
                break;

                case 4: {
                    nvManager.printListALL();
                }
                break;
                
                case 5: {
                    nvManager.printPersonalInfo();
                } break;

                default: {
                    System.out.println("Nhap sai lua chon!");
                }
            }
            if (exit) {
                break;
            }
            menu();
        }
    }

    public static void menu() {
        System.out.println("#----------------------------------------------#");
        System.out.println("Nhap 1 de them nhan vien.");
        System.out.println("Nhap 2 de sua thong tin nhan vien.");
        System.out.println("Nhap 3 de xoa nhan vien.");
        System.out.println("Nhap 4 de xem thong tin toan bo nhan vien");
        System.out.println("Nhap 5 de xem thong tin cua mot nhan vien");
        System.out.println("Nhap 0 de thoat.");
        System.out.println("#----------------------------------------------#");
    }

    public static void editNhanVienMenu() {
        System.out.println("+----------------------------------------------+");
        System.out.println("  Nhap 1 de sua ho va ten nhan vien.");
        System.out.println("  Nhap 2 de sua ngay sinh.");
        System.out.println("  Nhap 3 de sua gioi tinh.");
        System.out.println("  Nhap 4 de sua so dien thoai.");
        System.out.println("  Nhap 5 de sua dia chi.");
        System.out.println("  Nhap 6 de sua chuc vu.");
        System.out.println("  Nhap 7 de sua than nhan.");
        System.out.println("  Nhap 0 de thoat");
        System.out.println("+----------------------------------------------+");
    }
}
