package quanlynhansu;

import java.io.Serializable;

public class DUAN implements Serializable {

    private static final long serialVersionUID = 1L;

    private String maDuAn;
    private String tenDuAn;
    private String maPhongBanPhuTrach;
    private long kinhPhi;
    private NGAY ngayBatDauDuAn;
    private NGAY ngayKetThucDuAn;
    private NHANVIEN[] nvDuAnList;

    CHECK check = new CHECK();

    public DUAN() {
        this.maDuAn = "";
        this.tenDuAn = "";
        this.maPhongBanPhuTrach = "None";
        this.kinhPhi = 0;
        this.nvDuAnList = null;
    }

    public String getMaDuAn() {
        return maDuAn;
    }

    public void setMaDuAn(String maDuAn) {
        this.maDuAn = maDuAn;
    }

    public String getTenDuAn() {
        return tenDuAn;
    }

    public void setTenDuAn(String tenDuAn) {
        this.tenDuAn = tenDuAn;
    }

    public String getMaPhongBanPhuTrach() {
        return maPhongBanPhuTrach;
    }

    public void setMaPhongBanPhuTrach(String maPhongBanPhuTrach) {
        this.maPhongBanPhuTrach = maPhongBanPhuTrach;
    }

    public long getKinhPhi() {
        return kinhPhi;
    }

    public void setKinhPhi(long kinhPhi) {
        this.kinhPhi = kinhPhi;
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

    public NHANVIEN[] getNvDuAnList() {
        return nvDuAnList;
    }

    public void setNvDuAnList(NHANVIEN[] nvDuAnList) {
        this.nvDuAnList = nhanvienManager.sortByMaNV(nvDuAnList);
    }

    public void addOneNvToDuAnList(NHANVIEN nv) {
        this.nvDuAnList = nhanvienManager.add(nvDuAnList, nv);
        this.nvDuAnList = nhanvienManager.sortByMaNV(nvDuAnList);
    }

    public void nhap(String maDuan) {
        this.maDuAn = maDuan;
        System.out.print("Moi nhap ten du an: ");
        this.tenDuAn = Main.scan.nextLine();
        this.tenDuAn = Main.inHoaChuCaiDauTienCuaChuoi(this.tenDuAn);
        System.out.print("Moi nhap kinh phi cua du an: ");
        this.kinhPhi = CHECK.kiemTraSoNguyenDuong();
        System.out.println("Moi nhap ngay bat dau du an: ");
        NGAY start = new NGAY();
        start.nhap();
        System.out.println("Moi nhap ngay ket thuc du an: ");
        NGAY end = new NGAY();
        end.nhap();
        while (!check.kiemTraStartEndDay(start, end)) {
            System.out.println("Ngay ket thuc phai sau ngay bat dau! Moi nhap lai:");
            System.out.println("Nhap lai ngay bat dau du an: ");
            start.nhap();
            System.out.println("Nhap lai ngay ket thuc du an: ");
            end.nhap();
        }
        this.ngayBatDauDuAn = start;
        this.ngayKetThucDuAn = end;
    }
}
