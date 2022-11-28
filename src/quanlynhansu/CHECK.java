/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlynhansu;

import java.io.Serializable;

public class CHECK implements Serializable {

    private static final long serialVersionUID = 1L;

    public String kiemTraMaNhanVien() {
        String input;
        while (true) {
            input = Main.scan.nextLine();
            input = input.trim();
            if (input.matches("[TPC][0-9]{4}")) {
                return input;
            } else {
                System.out.println("Ma nhan vien khong phu hop. Vui long nhap lai theo dinh dang {(C0001) | (P0001) | (T0001)}");
            }
            System.out.print("Moi nhap lai: ");
        }
    }
    
    public String kiemTraMaNVChinh() {
        String input;
        while (true) {
            input = Main.scan.nextLine();
            input = input.trim();
            if (input.matches("C[0-9]{4}")) {
                return input;
            } else {
                System.out.println("Ma nhan vien khong phu hop. Ma nhan vien chinh phai co ky tu \"C\" dau tien va 4 so theo sau. VD: C0001");
            }
            System.out.print("Moi nhap lai: ");
        }
    }
    
    public String kiemTraMaNVPhu() {
        String input;
        while (true) {
            input = Main.scan.nextLine();
            input = input.trim();
            if (input.matches("P[0-9]{4}")) {
                return input;
            } else {
                System.out.println("Ma nhan vien khong phu hop. Ma nhan vien phu phai co ky tu \"P\" dau tien va 4 so theo sau. VD: P0001");
            }
            System.out.print("Moi nhap lai: ");
        }
    }
    
    public String kiemTraMaThucTapSinh() {
        String input;
        while (true) {
            input = Main.scan.nextLine();
            input = input.trim();
            if (input.matches("T[0-9]{4}")) {
                return input;
            } else {
                System.out.println("Ma nhan vien khong phu hop. Ma thuc tap sinh phai co ky tu \"T\" dau tien va 4 so theo sau. VD: T0001");
            }
            System.out.print("Moi nhap lai: ");
        }
    }

    public String kiemTraHoTen() {
        String input;
        while (true) {
            input = Main.scan.nextLine();
            input = input.trim();
            if (input.matches("[a-zA-Z\\s]+")) {
                return Main.inHoaChuCaiDauMoiTu(input);
            } else {
                System.out.print("Khong hop le! Moi nhap lai: ");
            }
        }
    }

    public boolean kiemTraNgayThangNam(int day, int month, int year) {
        if (day < 1 || day > 31 || month < 1 || month > 12) {
            return false;
        }
        if (year % 4 == 0) {
            switch (month) {
                case 2: {
                    if (day > 29) {
                        return false;
                    }
                }
                ;
                break;
                case 1, 3, 5, 7, 8, 10, 12: {
                    if (day > 31) {
                        return false;
                    }
                }
                ;
                break;
                case 4, 6, 9, 11: {
                    if (day > 30) {
                        return false;
                    }
                }
                ;
                break;
            }
        } else {
            switch (month) {
                case 2: {
                    if (day > 28) {
                        return false;
                    }
                }
                ;
                break;
                case 1, 3, 5, 7, 8, 10, 12: {
                    if (day > 31) {
                        return false;
                    }
                }
                ;
                break;
                case 4, 6, 9, 11: {
                    if (day > 30) {
                        return false;
                    }
                }
                ;
                break;
            }
        }
        return true;
    }

    public int lastDayOfMonth(int month, int year) {
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12: {
                return 31;
            }
            case 4, 6, 9, 11:
                return 30;
            case 2: {
                if (year % 4 == 0) {
                    return 29;
                } else {
                    return 28;
                }
            }
            default:
                return -1;
        }
    }

    public String kiemTraSoDienThoai() {
        String input;
        while (true) {
            input = Main.scan.nextLine();
            input = input.trim();
            if (input.matches("0" + "[1-9]{2}" + "[0-9]{7}")) {
                return input;
            } else {
                System.out.println("Khong hop le! Moi nhap lai theo dinh dang 10 so \"0395382257\" ");
            }
            System.out.print("Moi nhap lai: ");
        }
    }

    public String kiemTraGioiTinh() {
        String input;
        while (true) {
            input = Main.scan.nextLine();
            input = input.trim();
            if (input.matches("Nam|nam|Nu|nu")) {
                return Main.inHoaChuCaiDauTienCuaChuoi(input);
            } else {
                System.out.print("Khong hop le! Moi nhap lai theo dinh dang (nam / nu): ");
            }
        }
    }

    public boolean kiemTraDiaChi(String quan, String thanhPho) {
        return quan.matches("[a-zA-Z0-9\\s/]+") && thanhPho.matches("[a-zA-Z\\s]+");
    }

    public boolean kiemTraStartEndDay(NGAY start, NGAY end) {
        if (start.getNam() == end.getNam()) {
            if (start.getThang() == end.getThang()) {
                return start.getNgay() < end.getNgay();
            }
            return start.getThang() <= end.getThang();
        } else {
            return start.getNam() <= end.getNam();
        }
    }

    /**
     * @return Kiểm tra chuỗi nhập vào có phải là chuỗi ký tự không và trả về
     * chuỗi viết hoa chữ cái đầu
     */
    public String kiemTraChuoiKyTu() {
        String input;
        while (true) {
            input = Main.scan.nextLine();
            input = input.trim();
            if (input.matches("[a-zA-Z\\s]+")) {
                return Main.inHoaChuCaiDauTienCuaChuoi(input);
            } else {
                System.out.print("Khong hop le! Moi nhap lai: ");
            }
        }
    }

    public Float kiemTraFloat() {
        Float input;
        while (true) {
            try {
                input = Float.parseFloat(Main.scan.nextLine());
                return input;
            } catch (Exception e) {
                System.out.print("So khong hop le! Moi nhap lai: ");
            }
        }
    }

    public String kiemTraEmail() {
        String input;
        while (true) {
            input = Main.scan.nextLine();
            input = input.trim();
            if (input.matches("^(.+)@(\\S+)$")) {
                return input;
            } else {
                System.out.println("Email khong hop le! Moi nhap theo dinh dang: user@gmail.com");
            }
            System.out.print("Email: ");
        }
    }

    public String kiemTraMaPhongBan() {
        String input;
        while (true) {
            input = Main.scan.nextLine();
            input = input.trim();
            if (input.matches("[A-Z]{2}")) {
                return input;
            } else {
                System.out.println("Ma phong khong hop le! Ma phong ban phai la 2 chu cai viet hoa (VD: IT)");
            }
            System.out.print("Moi nhap ma phong ban: ");
        }
    }

    /**
     * @return Kiểm tra số nguyên dương
     */
    public static long kiemTraSoNguyenDuong() {
        long input;
        while (true) {
            try {
                input = Long.parseLong(Main.scan.nextLine());
                if (input < 0) {
                    System.out.print("So khong duoc nho hon 0!\nMoi nhap lai: ");
                } else {
                    return input;
                }
            } catch (Exception e) {
                System.out.print("So nhap vao khong phai la so nguyen.\nMoi nhap lai: ");
            }
        }
    }

    public static String yesNoChoice() {
        String input;
        while (true) {
            input = Main.scan.nextLine();
            input = input.trim();
            if (input.matches("[Y|N]{1}")) {
                return input;
            } else {
                System.out.println("Sai lua chon.");
            }
            System.out.print("Moi nhap lua chon (Y | N ): ");
        }
    }
    
    public int compareDate(int month1, int year1, int month2, int year2) {
        // return 1 la month1/year1 after month2/year2
        // return 0 la month1/year1 = month2/year2
        // return -1 la month1/year1 before month2/year2
        if (year1 == year2) {
            if (month1 > month2) {
                return 1;
            }
            else if (month1 < month2) {
                return -1;
            }
            else {
                return 0;
            }
        }
        else if (year1 > year2) {
            return 1;
        }
        else {
            return -1;
        }
    }
    
    public String changeMoney(Long moneyIn) {
        char[] moneyArr = moneyIn.toString().toCharArray();
        int count = 0;
        String temp = "";
        // Them dau phay vao chuoi so
        for (int i = moneyArr.length - 1; i >= 0; i--) {
            ++count;
            if (count % 3 == 0 && i > 0) {
                temp += moneyArr[i];
                temp += ",";
                continue;
            }
            temp += moneyArr[i];
        }
        // Dao nguoc chuoi
        String moneyOut = "";
        count = 0;
        moneyArr = temp.toCharArray();
        for (int i = moneyArr.length - 1; i >= 0; --i) {
            moneyOut += moneyArr[i];
            count++;
        }
        return moneyOut;
    }
}
