package quanlynhansu;

public class LUONG {

    private long luongCoBan;
    private float heSoLuong;
    private long luong;
    
    CHECK check = new CHECK();

    public LUONG() {
    }

    public LUONG(long luongCoBan, float heSoLuong, long luong) {
        this.luongCoBan = luongCoBan;
        this.heSoLuong = heSoLuong;
        this.luong = luong;
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(long luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(float heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(long luong) {
        this.luong = luong;
    }

    public void nhapLuong() {
        System.out.print("Luong co ban (Don vi: Dong) -> ");
        this.luongCoBan = check.kiemTraSoNguyenDuong();
        System.out.print("He so luong -> ");
        this.heSoLuong = check.kiemTraFloat();
        this.luong = (long) (luongCoBan * heSoLuong);
    }

    public void xuatLuong() {
        System.out.println("Luong co ban : " + this.luongCoBan + " trieu dong");
        System.out.println("He so luong: " + this.heSoLuong);
        System.out.println("Luong: " + this.luong + " trieu dong");
    }

    @Override
    public String toString() {
        return "LUONG [luongCoBan=" + luongCoBan + ", heSoLuong=" + heSoLuong + ", luong=" + luong + "]";
    }
//	public static void main(String[] args) {
//		LUONG a= new LUONG();
//		a.nhapLuong();
//		a.xuatLuong();
//	}
}
