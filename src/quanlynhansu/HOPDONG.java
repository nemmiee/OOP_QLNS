package quanlynhansu;

import java.io.Serializable;

public class HOPDONG implements Serializable, NhapXuat {
    private static final long serialVersionUID = 1L;

    private NGAY ngayBatDauHopDong;
    private NGAY ngayKetThucHopDong;

    CHECK check = new CHECK();

    public HOPDONG() {
        ngayBatDauHopDong = new NGAY();
        ngayKetThucHopDong = new NGAY();
    }

    public HOPDONG(NGAY ngayBatDauHopDong, NGAY ngayKetThucHopDong) {
        this.ngayBatDauHopDong = ngayBatDauHopDong;
        this.ngayKetThucHopDong = ngayKetThucHopDong;
    }

    public NGAY getNgayBatDauHopDong() {
        return ngayBatDauHopDong;
    }

    public void setNgayBatDauHopDong(NGAY ngayBatDauHopDong) {
        this.ngayBatDauHopDong = ngayBatDauHopDong;
    }

    public NGAY getNgayKetThucHopDong() {
        return ngayKetThucHopDong;
    }

    public void setNgayKetThucHopDong(NGAY ngayKetThucHopDong) {
        this.ngayKetThucHopDong = ngayKetThucHopDong;
    }

    @Override
    public void nhap() {
        System.out.println("Ngay bat dau hop dong: ");
        NGAY start = new NGAY();
        start.nhap();
        System.out.println("Ngay ket thuc hop dong: ");
        NGAY end = new NGAY();
        end.nhap();
        while (!check.kiemTraStartEndDay(start, end)) {
            System.out.println("Ngay ket thuc phai sau ngay bat dau! Moi nhap lai:");
            System.out.println("Ngay bat dau hop dong: ");
            start.nhap();
            System.out.println("Ngay ket thuc hop dong: ");
            end.nhap();
        }
        ngayBatDauHopDong = start;
        ngayKetThucHopDong = end;
    }

    @Override
    public void xuat() {
        System.out.println("Ngay bat dau hop dong: " + ngayBatDauHopDong);
        System.out.println("Ngay ket thuc hop dong: " + ngayKetThucHopDong);
    }

    @Override
    public String toString() {
        return "ngayBatDauHopDong=" + ngayBatDauHopDong + ", ngayKetThucHopDong=" + ngayKetThucHopDong;
    }
}
