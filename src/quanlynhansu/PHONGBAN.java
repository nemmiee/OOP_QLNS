package quanlynhansu;

public class PHONGBAN {

    private String maTruongPhong;
    private String maPhongBan;
    private String tenPhongBan;
    private int soLuongNhanVien;
    
    public PHONGBAN() {
        maTruongPhong = "";
        maPhongBan = "";
        tenPhongBan = "";
        soLuongNhanVien = 0;
    }

    public String getMaTruongPhong() {
        return maTruongPhong;
    }

    public void setMaTruongPhong(String maTruongPhong) {
        this.maTruongPhong = maTruongPhong;
    }

    public String getMaPhongBan() {
        return maPhongBan;
    }

    public void setMaPhongBan(String maPhongBan) {
        this.maPhongBan = maPhongBan;
    }

    public int getSoLuongNhanVien() {
        return soLuongNhanVien;
    }
    
    public String getTenPhongBan() {
        return tenPhongBan;
    }

    public void setTenPhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }

    public PHONGBAN(String maTruongPhong, String maPhongBan, String tenPhongBan, int soLuongNhanVien) {
        this.maTruongPhong = maTruongPhong;
        this.maPhongBan = maPhongBan;
        this.tenPhongBan = tenPhongBan;
        this.soLuongNhanVien = soLuongNhanVien;
    }

    public void nhapPhongBan() {
        System.out.print("Ma truong phong -> ");
        this.maTruongPhong = Main.scan.nextLine();
        System.out.print("Ma phong ban -> ");
        this.maPhongBan = Main.scan.nextLine();
        System.out.print("So luong nhan vien -> ");
        this.soLuongNhanVien = Integer.parseInt(Main.scan.nextLine());
        System.out.print("Ten Phong Ban -> ");
        this.tenPhongBan = Main.scan.nextLine();
    }

    public void xuatPhongBan() {
        System.out.println("Ma truong phong: " + this.maTruongPhong);
        System.out.println("Ma phong ban: " + this.maPhongBan);
        System.out.println("So luong nhan vien: " + this.soLuongNhanVien);
        System.out.println("Ten phong ban: " + this.tenPhongBan);
    }

}
