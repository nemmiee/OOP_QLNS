package quanlynhansu;

public class HOPDONG {

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

    public void nhapHopDong() {
        System.out.println("Ngay bat dau hop dong: ");
        NGAY start = new NGAY();
        start.nhapNgay();
        System.out.println("Ngay ket thuc hop dong: ");
        NGAY end = new NGAY();
        end.nhapNgay();
        while (!check.kiemTraStartEndDay(start, end)) {
            System.out.println("Khong hop le! Moi nhap lai:");
            System.out.println("Ngay bat dau hop dong: ");
            start.nhapNgay();
            System.out.println("Ngay ket thuc hop dong: ");
            end.nhapNgay();
        }
        ngayBatDauHopDong = start;
        ngayKetThucHopDong = end;
    }

    public void xuatHopDong() {
        System.out.println("Ngay bat dau hop dong: " + ngayBatDauHopDong);
        System.out.println("Ngay ket thuc hop dong: " + ngayKetThucHopDong);
    }

    @Override
    public String toString() {
        return "HOPDONG [ngayBatDauHopDong=" + ngayBatDauHopDong + ", ngayKetThucHopDong=" + ngayKetThucHopDong + "]";
    }
//	public static void main(String[] args) {
//		HOPDONG a= new HOPDONG();
//		a.nhapHopDong();
//		a.xuatHopDong();
//	}
}
