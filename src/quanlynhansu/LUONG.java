package quanlynhansu;

import java.io.Serializable;

public class LUONG implements Serializable, NhapXuat {

    private String maNV;
    private int thang;
    private int nam;
    private long luongCoBan;
    private float heSoLuong;
    private long luong;

    CHECK check = new CHECK();

    public LUONG() {
        maNV = "";
        thang = 0;
        nam = 0;
        luongCoBan = 0;
        heSoLuong = 0;
        luong = 0;
    }

    public LUONG(String maNV, int thang, int nam, long luongCoBan, float heSoLuong) {
        this.thang = thang;
        this.nam = nam;
        this.luongCoBan = luongCoBan;
        this.heSoLuong = heSoLuong;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
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

    public long getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(long luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public float getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(float heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public long getLuong() {
        return luong;
    }

    @Override
    public void nhap() {
        System.out.println("Moi nhap thang: ");
        this.thang = (int) CHECK.kiemTraSoNguyenDuong();
        System.out.print("Moi nhap nam: ");
        this.nam = (int) CHECK.kiemTraSoNguyenDuong();
        System.out.print("Luong co ban (Don vi: Dong): ");
        this.luongCoBan = CHECK.kiemTraSoNguyenDuong();
        float heSo;
        while (true) {
            System.out.print("Moi nhap he so luong: ");
            heSo = check.kiemTraFloat();
            if (heSo >= 0) {
                break;
            }
            else {
                System.out.println("He so luong phai la so duong.");
            }
        }
        this.heSoLuong = heSo;
    }
    
    public void nhap(String maNV, int thang, int nam, float soNgayCong) {
        System.out.print("Luong co ban (Don vi: Dong): ");
        this.luongCoBan = CHECK.kiemTraSoNguyenDuong();
        float heSo;
        while (true) {
            System.out.print("He so luong: ");
            heSo = check.kiemTraFloat();
            if (heSo >= 0) {
                break;
            }
            else {
                System.out.println("He so luong phai la so duong.");
            }
        }
        this.thang = thang;
        this.nam = nam;
        this.heSoLuong = heSo;
        this.maNV = maNV;
        this.luong = (long) ((luongCoBan * heSoLuong) / 26 * soNgayCong);
    }

    @Override
    public void xuat() {
        System.out.println("Luong co ban : " + this.luongCoBan + " trieu dong");
        System.out.println("He so luong: " + this.heSoLuong);
        System.out.println("Luong: " + this.luong + " trieu dong");
    }

    @Override
    public String toString() {
        return "LUONG [luongCoBan=" + luongCoBan + ", heSoLuong=" + heSoLuong + ", luong=" + luong + "]";
    }
}
