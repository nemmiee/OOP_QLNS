package quanlynhansu;

public class NHANVIENCHINH extends NHANVIEN {

    private LUONG luong;
    private String email;
    private String maPhongBan;
    private int soDuAnDaThucHien;
    private String maDuAnDangLam;
    private static int soLuongNhanVienChinh = 0;

    public NHANVIENCHINH() {
        super();
        luong = new LUONG();
        ++soLuongNhanVienChinh;
    }

    public NHANVIENCHINH(String maNhanVien, String hoTen, NGAY ngaySinh, String gioiTinh, String soDienThoai, DIACHI diaChi, String chucVu, HOPDONG hopDong, LUONG luong, String email, String maPhongBan, int soDuAnDaThucHien, String maDuAnDangLam) {
        super(maNhanVien, hoTen, ngaySinh, gioiTinh, soDienThoai, diaChi, chucVu, hopDong);
        this.luong = luong;
        this.email = email;
        this.maPhongBan = maPhongBan;
        this.soDuAnDaThucHien = soDuAnDaThucHien;
        this.maDuAnDangLam = maDuAnDangLam;
    }

    public LUONG getLuong() {
        return luong;
    }

    public void setLuong(LUONG luong) {
        this.luong = luong;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMaPhongBan() {
        return maPhongBan;
    }

    public void setMaPhongBan(String maPhongBan) {
        this.maPhongBan = maPhongBan;
    }

    public long getSoDuAnDaThucHien() {
        return soDuAnDaThucHien;
    }

    public void setSoDuAnDaThucHien(int soDuAnDaThucHien) {
        this.soDuAnDaThucHien = soDuAnDaThucHien;
    }

    public String getMaDuAnDangLam() {
        return maDuAnDangLam;
    }

    public void setMaDuAnDangLam(String maDuAnDangLam) {
        this.maDuAnDangLam = maDuAnDangLam;
    }
    
    public static int getSoLuongNhanVienChinh() {
        return soLuongNhanVienChinh;
    }

    @Override
    public void nhapNhanVien() {
        super.nhapNhanVien();
        System.out.println("Luong:");
        luong.nhapLuong();
        System.out.print("Email -> ");
        this.email = check.kiemTraEmail();
        System.out.print("Ma phong ban (IT | KT | NS | DH) -> ");
        this.maPhongBan = check.kiemTraMaPhongBan();
        System.out.print("So du an da thuc hien -> ");
        this.soDuAnDaThucHien = (int) CHECK.kiemTraSoNguyenDuong();
        System.out.print("Ma du an dang lam -> ");
        this.maDuAnDangLam = Main.inHoaTatCaKyTu(Main.scan.nextLine());
    }

    public void bangNhanVienChinh() {
        System.out.println("+----------+--------------------+---------------+----------+---------------+-----------------------------------+--------------------------------------------------+---------------+---------------+--------------------+--------------------+");
        System.out.printf("|%-10s|%-20s|%-15s|%-10s|%-15s|%-35s|%-50s|%-15s|%-15s|%-20s|%-20s|\n", "Ma", "Ho Ten", "Ngay Sinh", "Gioi tinh", "So dien Thoai", "Email", "Dia chi", "Chuc vu", "Luong Chinh", "Du an da thuc hien", "Du an dang lam");
        System.out.println("+----------+--------------------+---------------+----------+---------------+-----------------------------------+--------------------------------------------------+---------------+---------------+--------------------+--------------------+");
    }

    public void xuatNhanVienChinh() {
        System.out.printf("|%-10s|%-20s|%-15s|%-10s|%-15s|%-35s|%-50s|%-15s|%-15s|%-20s|%-20s|\n", this.maNhanVien, this.hoTen, this.ngaySinh, this.gioiTinh, this.soDienThoai, this.email, this.diaChi, this.chucVu, luong.getLuong(), this.soDuAnDaThucHien, this.maDuAnDangLam);
    }

    public void ketThucBangNhanVienChinh() {
        System.out.println("+----------+--------------------+---------------+----------+---------------+-----------------------------------+--------------------------------------------------+---------------+---------------+--------------------+--------------------+");
    }

}
