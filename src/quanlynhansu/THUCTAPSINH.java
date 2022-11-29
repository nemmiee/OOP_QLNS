package quanlynhansu;

public class THUCTAPSINH extends NHANVIEN {
    
    private String email;
    private String maPhong;

    public THUCTAPSINH() {
        super();
        email = "";
        maPhong = "";
    }

    public THUCTAPSINH(String maNhanVien, String hoTen, NGAY ngaySinh, String gioiTinh, String soDienThoai, 
            DIACHI diaChi, String chucVu, HOPDONG hopDong, String email, String maPhong) {
        super(maNhanVien, hoTen, ngaySinh, gioiTinh, soDienThoai, diaChi, chucVu, hopDong);
        this.email = email;
        this.maPhong = maPhong;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }
    
    @Override
    public void nhap(String maNV) {
        this.maNhanVien = maNV;
        System.out.print("Ho ten nhan vien: ");
        this.hoTen = check.kiemTraHoTen();
        System.out.println("Ngay sinh: ");
        this.ngaySinh.nhap();
        System.out.print("Gioi tinh (Nam / Nu): ");
        this.gioiTinh = check.kiemTraGioiTinh();
        System.out.print("So dien thoai: ");
        this.soDienThoai = check.kiemTraSoDienThoai();
        System.out.println("Dia chi: ");
        this.diaChi.nhapDiaChi();
        this.chucVu = "Thuc tap";
        System.out.println("Hop dong: ");
        this.hopDong.nhap();
        System.out.print("Moi nhap email: ");
        this.email = check.kiemTraEmail();
    }

    @Override
    public void xuat() {
        System.out.printf("|%-10s|%-20s|%-15s|%-10s|%-15s|%-50s|%-15s|\n", this.maNhanVien, this.hoTen, this.ngaySinh, this.gioiTinh, this.soDienThoai, this.diaChi, this.chucVu);

    }
}
