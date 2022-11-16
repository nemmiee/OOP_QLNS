package quanlynhansu;

public class DUAN {

    private String tenDuAn;
    private String maDuAn;
    private long kinhPhiThucHien;
    private String maPhongBanThucHienDuAn;
    private NGAY ngayBatDauDuAn;
    private NGAY ngayKetThucDuAn;
    
    CHECK check = new CHECK();

    public DUAN(String tenDuAn, String maDuAn, long kinhPhiThucHien, String maPhongBanThucHienDuAn, NGAY ngayBatDauDuAn, NGAY ngayKetThucDuAn) {
        this.tenDuAn = tenDuAn;
        this.maDuAn = maDuAn;
        this.kinhPhiThucHien = kinhPhiThucHien;
        this.maPhongBanThucHienDuAn = maPhongBanThucHienDuAn;
        this.ngayBatDauDuAn = ngayBatDauDuAn;
        this.ngayKetThucDuAn = ngayKetThucDuAn;
    }

    public DUAN() {
        ngayBatDauDuAn = new NGAY();
        ngayKetThucDuAn = new NGAY();
    }

    public String getTenDuAn() {
        return tenDuAn;
    }

    public void setTenDuAn(String tenDuAn) {
        this.tenDuAn = tenDuAn;
    }

    public String getMaDuAn() {
        return maDuAn;
    }

    public void setMaDuAn(String maDuAn) {
        this.maDuAn = maDuAn;
    }

    public long getKinhPhiThucHien() {
        return kinhPhiThucHien;
    }

    public void setKinhPhiThucHien(long kinhPhiThucHien) {
        this.kinhPhiThucHien = kinhPhiThucHien;
    }

    public String getPhongBanThucHienDuAn() {
        return maPhongBanThucHienDuAn;
    }

    public void setPhongBanThucHienDuAn(String phongBanThucHienDuAn) {
        this.maPhongBanThucHienDuAn = phongBanThucHienDuAn;
    }

    public NGAY getNgayBatDauDuAn() {
        return ngayBatDauDuAn;
    }

    public void setNgayBatDauDuAn(NGAY ngayBatDauDuAn) {
        this.ngayBatDauDuAn = ngayBatDauDuAn;
    }

    public NGAY getNgayKetThucDuAn() {
        return ngayKetThucDuAn;
    }

    public void setNgayKetThucDuAn(NGAY ngayKetThucDuAn) {
        this.ngayKetThucDuAn = ngayKetThucDuAn;
    }

    public void nhapDuAn() {
        System.out.print("Ten du an -> ");
        this.tenDuAn = check.kiemTraChuoiKyTu();
        System.out.print("Ma du an -> ");
        this.maDuAn = Main.inHoaTatCaKyTu(check.kiemTraChuoiKyTu());
        System.out.print("Kinh phi thuc hien du an (Don vi: Dong) -> ");
        this.kinhPhiThucHien = check.kiemTraSoNguyenDuong();
        System.out.print("Ma phong ban thuc hien du an -> ");
        this.maPhongBanThucHienDuAn = check.kiemTraMaPhongBan();
        System.out.println("Ngay bat dau du an: ");
        NGAY start = new NGAY();
        start.nhapNgay();
        System.out.println("Ngay ket thuc du an: ");
        NGAY end = new NGAY();
        end.nhapNgay();
        while (!check.kiemTraStartEndDay(start, end)) {
            System.out.println("Khong hop le! Moi nhap lai:");
            System.out.println("Ngay bat dau du an: ");
            start.nhapNgay();
            System.out.println("Ngay ket thuc du an: ");
            end.nhapNgay();
        }
        this.ngayBatDauDuAn = start;
        this.ngayKetThucDuAn = end;
    }

    public void xuatDuAn() {
        System.out.println("Ten du an: " + this.tenDuAn);
        System.out.println("Ma du an: " + this.maDuAn);
        System.out.println("Kinh phi thuc hien du an: " + this.kinhPhiThucHien + " trieu dong");
        System.out.println("Ma phong ban thuc hien du an: " + this.maPhongBanThucHienDuAn);
        System.out.println("Ngay bat dau du an: " + this.ngayBatDauDuAn);
        System.out.println("Ngay ket thuc du an: " + this.ngayKetThucDuAn);
    }
}
