package quanlynhansu;

import java.io.Serializable;

public class CHAMCONG implements Serializable, NhapXuat {

    private static final long serialVersionUID = 1L;

    private String maNV;
    private int thang;
    private int nam;
    private int duNgayCong;
    private int nuaNgayCong;
    private int khongCong;

    CHECK check = new CHECK();

    public CHAMCONG() {
        maNV = "";
        thang = 0;
        nam = 0;
        duNgayCong = 0;
        nuaNgayCong = 0;
        khongCong = 0;
    }

    public CHAMCONG(String maNV, int thang, int nam, int duNgayCong, int nuaNgayCong, int khongCong) {
        this.maNV = maNV;
        this.thang = thang;
        this.nam = nam;
        this.duNgayCong = duNgayCong;
        this.nuaNgayCong = nuaNgayCong;
        this.khongCong = khongCong;
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

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaNV() {
        return maNV;
    }

    public int getDuNgayCong() {
        return duNgayCong;
    }

    public void setDuNgayCong(int duNgayCong) {
        this.duNgayCong = duNgayCong;
    }

    public int getNuaNgayCong() {
        return nuaNgayCong;
    }

    public void setNuaNgayCong(int nuaNgayCong) {
        this.nuaNgayCong = nuaNgayCong;
    }

    public int getKhongCong() {
        return khongCong;
    }

    public void setKhongCong(int khongCong) {
        this.khongCong = khongCong;
    }

    public float tongNgayCong() {
        return (float) (duNgayCong * 1 + nuaNgayCong * 0.5 + khongCong * 0);
    }

    @Override
    public void nhap() {
        System.out.print("Nhap ma nhan vien: ");
        this.maNV = check.kiemTraMaNhanVien();
        while (true) {
            System.out.print("Nhap thang: ");
            this.thang = (int) CHECK.kiemTraSoNguyenDuong();
            System.out.print("Nhap nam: ");
            this.nam = (int) CHECK.kiemTraSoNguyenDuong();
            if (thang > 0 && thang < 13) {
                break;
            }
            else {
                System.out.println("Thang khong hop le.");
            }
        }
        int dungGio, diTre, nghi, tong;
        while (true) {
            System.out.print("So ngay di dung gio: ");
            dungGio = (int) CHECK.kiemTraSoNguyenDuong();
            System.out.print("So ngay di tre: ");
            diTre = (int) CHECK.kiemTraSoNguyenDuong();
            System.out.print("So ngay nghi: ");
            nghi = (int) CHECK.kiemTraSoNguyenDuong();
            tong = dungGio + diTre + nghi;
            if (tong == check.lastDayOfMonth(thang, nam)) {
                break;
            } else {
                System.out.println("Tong so ngay vua nhap " + tong + " khong khop voi so ngay cua " + thang + "/" + nam + " la " + check.lastDayOfMonth(thang, nam) + " ngay");
            }
        }
    }

    public void nhap(String maNV, int thang, int nam) {
        int dungGio, diTre, nghi, tong;
        while (true) {
            System.out.print("So ngay di dung gio: ");
            dungGio = (int) CHECK.kiemTraSoNguyenDuong();
            System.out.print("So ngay di tre: ");
            diTre = (int) CHECK.kiemTraSoNguyenDuong();
            System.out.print("So ngay nghi: ");
            nghi = (int) CHECK.kiemTraSoNguyenDuong();
            tong = dungGio + diTre + nghi;
            if (tong == check.lastDayOfMonth(thang, nam)) {
                break;
            } else {
                System.out.println("Tong so ngay vua nhap \"" + tong + "\" khong khop voi so ngay cua " + thang + "/" + nam + " la " + check.lastDayOfMonth(thang, nam) + " ngay.");
            }
        }
        this.maNV = maNV;
        this.thang = thang;
        this.nam = nam;
        this.duNgayCong = dungGio;
        this.nuaNgayCong = diTre;
        this.khongCong = nghi;
    }
    
    @Override
    public void xuat() {
        System.out.println(thang + "/" + nam);
        System.out.println("Ma nhan vien: " + maNV);
        System.out.println("So ngay du cong: " + duNgayCong);
        System.out.println("So ngay di tre: " + nuaNgayCong);
        System.out.println("So ngay nghi: " + khongCong);
    }

    @Override
    public String toString() {
        return "Ma nhan vien: " + maNV + " - So ngay di dung gio: " + duNgayCong + " - So ngay di tre: " + nuaNgayCong
                + " - So ngay nghi: " + khongCong + " - Tong ngay cong: " + tongNgayCong();
    }

}
