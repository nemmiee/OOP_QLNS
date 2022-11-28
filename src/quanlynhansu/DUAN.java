package quanlynhansu;

public class DUAN {

    private String tenDuAn;
    private String maDuAn;
    private String maTruongDuAn;
    private long kinhPhi;
    private String kieuDuAn;
    private NGAY ngayBatDauDuAn;
    private NGAY ngayKetThucDuAn;
    private NHANVIEN[] nvDuAnList;
    
    CHECK check = new CHECK();


    public void nhap() {
        System.out.print("Ten du an -> ");
        this.tenDuAn = check.kiemTraChuoiKyTu();
        System.out.print("Ma du an -> ");
        this.maDuAn = Main.inHoaTatCaKyTu(check.kiemTraChuoiKyTu());
        
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

    public void xuat() {
    }
}
