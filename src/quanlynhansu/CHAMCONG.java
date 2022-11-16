package quanlynhansu;

public class CHAMCONG {

    private NGAY ngayChamCong;
    private String maNhanVien;
    private int soLanDiTre;
    private int soNgayNghi;
    private int soGioTangCa;
    private KHENTHUONG khenThuong;
    
    CHECK check = new CHECK();

    public CHAMCONG() {
        ngayChamCong = new NGAY();
        khenThuong = new KHENTHUONG();
    }

    public CHAMCONG(NGAY ngayChamCong, String maNhanVien, int soLanDiTre, int soNgayNghi, int soGioTangCa, KHENTHUONG khenThuong) {
        this.ngayChamCong = ngayChamCong;
        this.maNhanVien = maNhanVien;
        this.soLanDiTre = soLanDiTre;
        this.soNgayNghi = soNgayNghi;
        this.soGioTangCa = soGioTangCa;
        this.khenThuong = khenThuong;
    }

    public NGAY getNgayChamCong() {
        return ngayChamCong;
    }

    public void setNgayChamCong(NGAY ngayChamCong) {
        this.ngayChamCong = ngayChamCong;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public int getSoLanDiTre() {
        return soLanDiTre;
    }

    public void setSoLanDiTre(int soLanDiTre) {
        this.soLanDiTre = soLanDiTre;
    }

    public int getSoNgayNghi() {
        return soNgayNghi;
    }

    public void setSoNgayNghi(int soNgayNghi) {
        this.soNgayNghi = soNgayNghi;
    }

    public int getSoGioTangCa() {
        return soGioTangCa;
    }

    public void setSoGioTangCa(int soGioTangCa) {
        this.soGioTangCa = soGioTangCa;
    }

    public KHENTHUONG getKhenThuong() {
        return khenThuong;
    }

    public void setKhenThuong(KHENTHUONG khenThuong) {
        this.khenThuong = khenThuong;
    }

    public void nhapChamCong() {
        System.out.print("Ngay cham cong->");
        this.ngayChamCong.nhapNgay();
        System.out.print("Ma nhan vien ->");
        this.maNhanVien = check.kiemTraMaNhanVien();
        System.out.print("So lan di tre -> ");
        this.soLanDiTre = (int) check.kiemTraSoNguyenDuong();
        System.out.print("So ngay nghi -> ");
        this.soNgayNghi = (int) check.kiemTraSoNguyenDuong();
        System.out.print("So gio tang ca -> ");
        this.soGioTangCa = (int) check.kiemTraSoNguyenDuong();
        System.out.println("Khen thuong: ");
        this.khenThuong.nhapKhenThuong();
    }

    public void xuatChamCong() {
        System.out.println("Ngay cham cong: " + this.ngayChamCong);
        System.out.println("Ma nhan vien: " + this.maNhanVien);
        System.out.println("So lan di tre: " + this.soLanDiTre);
        System.out.println("So ngay nghi: " + this.soNgayNghi);
        System.out.println("So gio tang ca: " + this.soGioTangCa);
        khenThuong.xuatKhenThuong();
    }

    @Override
    public String toString() {
        return "CHAMCONG [ngayChamCong=" + ngayChamCong + ", maNhanVien=" + maNhanVien + ", soLanDiTre=" + soLanDiTre
                + ", soNgayNghi=" + soNgayNghi + ", soGioTangCa=" + soGioTangCa + ", khenThuong=" + khenThuong + "]";
    }

}
