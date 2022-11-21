package quanlynhansu;

public class THUCTAPSINH extends NHANVIEN {
    
    private String email;

    public THUCTAPSINH() {
        super();
        email = "";
    }

    public THUCTAPSINH(String maNhanVien, String hoTen, NGAY ngaySinh, String gioiTinh, String soDienThoai, DIACHI diaChi, String chucVu, HOPDONG hopDong, String email) {
        super(maNhanVien, hoTen, ngaySinh, gioiTinh, soDienThoai, diaChi, chucVu, hopDong);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public void nhap(String maNV) {
        super.nhap(maNV);
        System.out.print("Moi nhap email: ");
        this.email = check.kiemTraEmail();
    }

    @Override
    public void xuat() {
        System.out.printf("|%-10s|%-20s|%-15s|%-10s|%-15s|%-50s|%-15s|\n", this.maNhanVien, this.hoTen, this.ngaySinh, this.gioiTinh, this.soDienThoai, this.diaChi, this.chucVu);

    }
}
