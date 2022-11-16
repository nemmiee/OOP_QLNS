package quanlynhansu;

public class KHENTHUONG {

    private NGAY ngayKhenThuong;
    private int mucKhenThuong;
    
    CHECK check = new CHECK();

    public KHENTHUONG(NGAY ngayKhenThuong, int mucKhenThuong) {
        this.ngayKhenThuong = ngayKhenThuong;
        this.mucKhenThuong = mucKhenThuong;
    }

    public KHENTHUONG() {
        ngayKhenThuong = new NGAY();
    }

    public void nhapKhenThuong() {
        System.out.println("Ngay khen thuong: ");
        ngayKhenThuong.nhapNgay();
        System.out.print("Muc khen thuong -> ");
        this.mucKhenThuong = (int) check.kiemTraSoNguyenDuong();
    }

    public void xuatKhenThuong() {
        System.out.println("Ngay khen thuong: " + ngayKhenThuong);
        System.out.println("Muc khen thuong: " + this.mucKhenThuong);
    }

    @Override
    public String toString() {
        return "KHENTHUONG [ngayKhenThuong=" + ngayKhenThuong + ", mucKhenThuong=" + mucKhenThuong + "]";
    }

//	public static void main(String[] args) {
//		KHENTHUONG a= new KHENTHUONG();
//		a.nhapKhenThuong();
//		System.out.println(a);
//	}
}
