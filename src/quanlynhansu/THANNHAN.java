package quanlynhansu;

import java.io.Serializable;

public class THANNHAN implements Serializable, NhapXuat {

    private static final long serialVersionUID = 1L;

    private String maNV;
    private String hoTenThanNhan;
    private String gioiTinh;
    private NGAY ngaySinhThanNhan;
    private String quanHeThanNhan;

    CHECK check = new CHECK();

    public THANNHAN() {
        ngaySinhThanNhan = new NGAY();
    }

    public THANNHAN(String maNV, String hoTenThanNhan, String gioiTinh, NGAY ngaySinhThanNhan, String quanHeThanNhan) {
        this.maNV = maNV;
        this.hoTenThanNhan = hoTenThanNhan;
        this.gioiTinh = gioiTinh;
        this.ngaySinhThanNhan = ngaySinhThanNhan;
        this.quanHeThanNhan = quanHeThanNhan;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTenThanNhan() {
        return hoTenThanNhan;
    }

    public void setHoTenThanNhan(String hoTenThanNhan) {
        this.hoTenThanNhan = hoTenThanNhan;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public NGAY getNgaySinhThanNhan() {
        return ngaySinhThanNhan;
    }

    public void setNgaySinhThanNhan(NGAY ngaySinhThanNhan) {
        this.ngaySinhThanNhan = ngaySinhThanNhan;
    }

    public String getQuanHeThanNhan() {
        return quanHeThanNhan;
    }

    public void setQuanHeThanNhan(String quanHeThanNhan) {
        this.quanHeThanNhan = quanHeThanNhan;
    }

    public boolean compareThanNhan(THANNHAN tn) {
        if (this.maNV == tn.getMaNV() && this.hoTenThanNhan.equals(tn.getHoTenThanNhan()) && this.gioiTinh.equals(tn.getGioiTinh())
                && this.ngaySinhThanNhan.compareDate(tn.getNgaySinhThanNhan()) && this.quanHeThanNhan.equals(tn.getQuanHeThanNhan())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void nhap() {
        System.out.print("Nhap ma nhan vien: ");
        this.maNV = check.kiemTraMaNhanVien();
        System.out.print("Ho ten than nhan -> ");
        this.hoTenThanNhan = check.kiemTraHoTen();
        System.out.print("Gioi tinh than nhan -> ");
        this.gioiTinh = check.kiemTraGioiTinh();
        System.out.println("Ngay sinh than nhan: ");
        this.ngaySinhThanNhan.nhapNgay();
        System.out.print("Quan he than nhan -> ");
        this.quanHeThanNhan = check.kiemTraChuoiKyTu();
    }

    public void nhap(String maNV) {
        this.maNV = maNV;
        System.out.print("Ho ten than nhan -> ");
        this.hoTenThanNhan = check.kiemTraHoTen();
        System.out.print("Gioi tinh than nhan -> ");
        this.gioiTinh = check.kiemTraGioiTinh();
        System.out.println("Ngay sinh than nhan: ");
        this.ngaySinhThanNhan.nhapNgay();
        System.out.print("Quan he than nhan -> ");
        this.quanHeThanNhan = check.kiemTraChuoiKyTu();
    }

    @Override
    public void xuat() {
        System.out.println("Ho ten than nhan: " + this.hoTenThanNhan);
        System.out.println("Gioi tinh than nhan: " + this.gioiTinh);
        System.out.println("Ngay sinh than nhan: " + this.ngaySinhThanNhan);
        System.out.println("Quan he than nhan: " + this.quanHeThanNhan);
    }

    @Override
    public String toString() {
        return maNV + ", hoTenThanNhan: " + hoTenThanNhan + ", gioiTinh: " + gioiTinh + ", ngaySinhThanNhan: " + ngaySinhThanNhan + ", quanHeThanNhan: " + quanHeThanNhan;
    }
}
