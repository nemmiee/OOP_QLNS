package quanlynhansu;

public class NHANVIENCHINH extends NHANVIEN {

    private String email;
    private String maPhong;
    
    public NHANVIENCHINH() {
        super();
        email = "";
        maPhong = "";
    }

    public NHANVIENCHINH(String maNhanVien, String hoTen, NGAY ngaySinh, String gioiTinh, 
            String soDienThoai, DIACHI diaChi, String chucVu, HOPDONG hopDong, String email, String maPhong) {
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
    
    public void nhap(String maNV) {
        super.nhap(maNV);
        System.out.print("Nhap email: ");
        this.email = check.kiemTraEmail();
    }

    @Override
    public void xuat() {
        System.out.println("Ma nhan vien: " + this.maNhanVien);
        System.out.println("Ho ten: " + this.hoTen);
        System.out.println("Ngay sinh: " + ngaySinh);
        System.out.println("Gioi tinh: " + this.gioiTinh);
        System.out.println("So dien thoai: " + this.soDienThoai);
        System.out.println("Dia chi: " + diaChi.toString());
        System.out.println("Chuc vu: " + this.chucVu);
        hopDong.xuat();
    }
}

//package quanlynhansu;
//
//public class NHANVIENCHINH extends NHANVIEN {
//
//    private String maPhong;
//    private String email;
//    
//    public NHANVIENCHINH() {
//        super();
//        maPhong = "";
//        email = "";
//    }
//
//    public NHANVIENCHINH(String maNhanVien, String hoTen, NGAY ngaySinh, String gioiTinh, 
//            String soDienThoai, DIACHI diaChi, String chucVu, HOPDONG hopDong, String maPhong, String email) {
//        super(maNhanVien, hoTen, ngaySinh, gioiTinh, soDienThoai, diaChi, chucVu, hopDong);
//        this.maPhong = maPhong;
//        this.email = email;
//    }
//
//    public String getMaPhong() {
//        return maPhong;
//    }
//
//    public void setMaPhong(String maPhong) {
//        this.maPhong = maPhong;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//    
//    @Override
//    public void nhap(String maNV) {
//        super.nhap(maNV);
//        System.out.print("Nhap ma phong ban: ");
//        this.maPhong = check.kiemTraMaPhongBan();
//        System.out.print("Nhap email: ");
//        this.email = check.kiemTraEmail();
//    }
//
//    @Override
//    public void xuat() {
//        System.out.println("Ma nhan vien: " + this.maNhanVien);
//        System.out.println("Ho ten: " + this.hoTen);
//        System.out.println("Ngay sinh: " + ngaySinh);
//        System.out.println("Gioi tinh: " + this.gioiTinh);
//        System.out.println("So dien thoai: " + this.soDienThoai);
//        System.out.println("Dia chi: " + diaChi.toString());
//        System.out.println("Chuc vu: " + this.chucVu);
//        hopDong.xuat();
//    }
//}

