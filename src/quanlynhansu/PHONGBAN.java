package quanlynhansu;

public class PHONGBAN {
	private String maTruongPhong;
	private String maPhongBan;
	private String tenPhongBan;
	private int soLuongNhanVien;
	private int soDuAnThucHien;
	public String getMaTruongPhong() {
		return maTruongPhong;
	}
	public void setMaTruongPhong(String maTruongPhong) {
		this.maTruongPhong = maTruongPhong;
	}
	public String getMaPhongBan() {
		return maPhongBan;
	}
	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
	}
	public int getSoLuongNhanVien() {
		return soLuongNhanVien;
	}
	public void setSoLuongNhanVien(int soLuongNhanVien) {
		this.soLuongNhanVien = soLuongNhanVien;
	}
	public String getTenPhongBan() {
		return tenPhongBan;
	}
	public void setTenPhongBan(String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
	}
	public int getSoDuAnThucHien() {
		return soDuAnThucHien;
	}
	public void setSoDuAnThucHien(int soDuAnThucHien) {
		this.soDuAnThucHien = soDuAnThucHien;
	}
	public PHONGBAN(String maTruongPhong, String maPhongBan, String tenPhongBan, int soLuongNhanVien, int soDuAnThucHien) {
		this.maTruongPhong = maTruongPhong;
		this.maPhongBan = maPhongBan;
		this.tenPhongBan = tenPhongBan;
		this.soLuongNhanVien = soLuongNhanVien;
		this.soDuAnThucHien = soDuAnThucHien;
	}
	public PHONGBAN() {
	}
	public void nhapPhongBan() {
		System.out.print("Ma truong phong -> ");
		this.maTruongPhong = Main.scan.nextLine();
		System.out.print("Ma phong ban -> ");
		this.maPhongBan = Main.scan.nextLine();
		System.out.print("So luong nhan vien -> ");
		this.soLuongNhanVien=Integer.parseInt(Main.scan.nextLine());
		System.out.print("Ten Phong Ban -> ");
		this.tenPhongBan = Main.scan.nextLine();
		System.out.print("So du an thuc hien -> ");
		this.soDuAnThucHien=Integer.parseInt(Main.scan.nextLine());
	}
	public void xuatPhongBan() {
		System.out.println("Ma truong phong: "+this.maTruongPhong);
		System.out.println("Ma phong ban: "+this.maPhongBan);
		System.out.println("So luong nhan vien: "+this.soLuongNhanVien);
		System.out.println("Ten phong ban: "+this.tenPhongBan);
		System.out.println("So du an da thuc hien: "+this.soDuAnThucHien);
	}
//	public static void main(String[] args) {
//		PHONGBAN a= new PHONGBAN();
//		a.nhapPhongBan();
//		a.xuatPhongBan();
//	}
	
}
