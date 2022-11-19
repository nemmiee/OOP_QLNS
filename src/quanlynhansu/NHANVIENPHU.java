package quanlynhansu;

public class NHANVIENPHU extends NHANVIEN {

    private LUONG luong;
    private static int soLuongNhanVienPhu = 0;

    public NHANVIENPHU() {
        super();
        luong = new LUONG();
    }

    public NHANVIENPHU(String maNhanVien, String hoTen, NGAY ngaySinh, String gioiTinh, String soDienThoai, DIACHI diaChi, String chucVu, HOPDONG hopDong, LUONG luong) {
        super(maNhanVien, hoTen, ngaySinh, gioiTinh, soDienThoai, diaChi, chucVu, hopDong);
        this.luong = luong;
    }

    public LUONG getLuong() {
        return luong;
    }

    public void setLuong(LUONG luong) {
        this.luong = luong;
    }
    
    public static int getSoLuongNhanVienPhu() {
        return soLuongNhanVienPhu;
    }

    @Override
    public void nhap() {
        super.nhap();
        System.out.println("Luong:");
        this.luong.nhapLuong();
    }

    public void bangNhanVienPhu() {
        System.out.println("+----------+--------------------+---------------+----------+---------------+--------------------------------------------------+---------------+---------------+");
        System.out.printf("|%-10s|%-20s|%-15s|%-10s|%-15s|%-50s|%-15s|%-15s|\n", "Ma", "Ho Ten", "Ngay Sinh", "Gioi tinh", "So dien Thoai", "Dia chi", "Chuc vu", "Luong");
        System.out.println("+----------+--------------------+---------------+----------+---------------+--------------------------------------------------+---------------+---------------+");
    }

    @Override
    public void xuat() {
        System.out.printf("|%-10s|%-20s|%-15s|%-10s|%-15s|%-50s|%-15s|%-15s|\n", this.maNhanVien, this.hoTen, this.ngaySinh, this.gioiTinh, this.soDienThoai, this.diaChi, this.chucVu, luong.getLuong());

    }

    public void ketThucBangNhanVienPhu() {
        System.out.println("+----------+--------------------+---------------+----------+---------------+--------------------------------------------------+---------------+---------------+");
    }

}
