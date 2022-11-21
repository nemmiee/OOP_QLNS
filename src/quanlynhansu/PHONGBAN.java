package quanlynhansu;

import java.io.Serializable;

public class PHONGBAN implements Serializable, NhapXuat {
    private static final long serialVersionUID = 1L;
    
    private String maTruongPhong;
    private String maPhong;
    private String tenPhong;
    
    CHECK check = new CHECK();
    
    public PHONGBAN() {
        maTruongPhong = "";
        maPhong = "";
        tenPhong = "";
    }
    
    public PHONGBAN(String maTruongPhong, String maPhong, String tenPhong) {
        this.maTruongPhong = maTruongPhong;
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
    }

    public String getMaTruongPhong() {
        return maTruongPhong;
    }

    public void setMaTruongPhong(String maTruongPhong) {
        this.maTruongPhong = maTruongPhong;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    @Override
    public void nhap() {
        System.out.print("Ma truong phong: ");
        this.maTruongPhong = Main.scan.nextLine();
        System.out.print("Ma phong ban: ");
        this.maPhong = Main.scan.nextLine();
        System.out.print("Ten phong ban: ");
        this.tenPhong = Main.scan.nextLine();
    }
    
    public void nhap(String maPhong, String maTruongPhong) {
        this.maPhong = maPhong;
        this.maTruongPhong = maTruongPhong;
        System.out.print("Ten phong ban: ");
        this.tenPhong = check.kiemTraChuoiKyTu();
    }

    @Override
    public void xuat() {
        System.out.println("Ma truong phong: " + this.maTruongPhong);
        System.out.println("Ma phong ban: " + this.maPhong);
        System.out.println("Ten phong ban: " + this.tenPhong);
    }

}
