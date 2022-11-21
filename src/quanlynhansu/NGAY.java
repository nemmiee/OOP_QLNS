package quanlynhansu;

import java.io.Serializable;

public class NGAY implements Serializable {
    private static final long serialVersionUID = 1L;

    private int ngay;
    private int thang;
    private int nam;

    CHECK check = new CHECK();

    public NGAY() {
    }

    public NGAY(int ngay, int thang, int nam) {
        this.ngay = ngay;
        this.thang = thang;
        this.nam = nam;
    }

    public int getNgay() {
        return ngay;
    }

    public void setNgay(int ngay) {
        this.ngay = ngay;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }
    
    public boolean compareDate(NGAY date) {
        if (this.ngay == date.getNgay() && this.thang == date.getThang() && this.nam == date.getNam()) {
            return true;
        }
        else {
            return false;
        }
    }

    public void nhapNgay() {
        while (true) {
            try {
                System.out.print("\tNgay -> ");
                int day = Integer.parseInt(Main.scan.nextLine());
                System.out.print("\tThang -> ");
                int month = Integer.parseInt(Main.scan.nextLine());
                System.out.print("\tNam -> ");
                int year = Integer.parseInt(Main.scan.nextLine());
                while (!check.kiemTraNgayThangNam(day, month, year)) {
                    System.out.println("Khong hop le! Vui long nhap lai:\n");
                    System.out.print("\tNgay -> ");
                    day = Integer.parseInt(Main.scan.nextLine());
                    System.out.print("\tThang -> ");
                    month = Integer.parseInt(Main.scan.nextLine());
                    System.out.print("\tNam -> ");
                    year = Integer.parseInt(Main.scan.nextLine());
                }
                ngay = day;
                thang = month;
                nam = year;
                break;
            } catch (NumberFormatException e) {
                System.out.println("Sai dinh dang! Moi nhap lai:");
            }
        }
    }

    @Override
    public String toString() {
        return this.ngay + "/" + this.thang + "/" + this.nam;
    }
}
