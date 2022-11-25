package quanlynhansu;

public class NHANVIENPHU extends NHANVIEN {

    private final String email = "None";
    private final String maPhong = "None";
    
    public NHANVIENPHU() {
        super();
    }

    public NHANVIENPHU(String maNhanVien, String hoTen, NGAY ngaySinh, String gioiTinh, 
            String soDienThoai, DIACHI diaChi, String chucVu, HOPDONG hopDong) {
        super(maNhanVien, hoTen, ngaySinh, gioiTinh, soDienThoai, diaChi, chucVu, hopDong);
    }

    public String getEmail() {
        return email;
    }   

    public String getMaPhong() {
        return maPhong;
    }
    
    @Override
    public void xuat() {
        System.out.printf("|%-10s|%-20s|%-15s|%-10s|%-15s|%-50s|%-15s|\n", this.maNhanVien, 
                this.hoTen, this.ngaySinh, this.gioiTinh, this.soDienThoai, this.diaChi, this.chucVu);
    }

}
