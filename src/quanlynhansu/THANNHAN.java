package quanlynhansu;

public class THANNHAN {

    private String hoTenThanNhan;
    private String gioiTinh;
    private NGAY ngaySinhThanNhan;
    private String quanHeThanNhan;
    
    CHECK check = new CHECK();

    public THANNHAN(String hoTenThanNhan, String gioiTinh, NGAY ngaySinhThanNhan, String quanHeThanNhan) {
        this.hoTenThanNhan = hoTenThanNhan;
        this.gioiTinh = gioiTinh;
        this.ngaySinhThanNhan = ngaySinhThanNhan;
        this.quanHeThanNhan = quanHeThanNhan;
    }

    public THANNHAN() {
        ngaySinhThanNhan = new NGAY();
    }

    public String getHoTenThanNhan() {
        return hoTenThanNhan;
    }

    public void setHoTenThanNhan(String hoTenThanNhan) {
        this.hoTenThanNhan = hoTenThanNhan;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public NGAY getNgaySinhThanNhan() {
        return ngaySinhThanNhan;
    }

    public void setNgaySinhThanNhan(NGAY ngaySinhThanNhan) {
        this.ngaySinhThanNhan = ngaySinhThanNhan;
    }

    public String getQuanHeThanNhan() {
        return quanHeThanNhan;
    }

    public void setQuanHeThanNhan(String quanHeThanNhan) {
        this.quanHeThanNhan = quanHeThanNhan;
    }

    public void nhapNhanThan() {
        System.out.print("Ho ten than nhan -> ");
        this.hoTenThanNhan = check.kiemTraHoTen();
        System.out.print("Gioi tinh than nhan -> ");
        this.gioiTinh = check.kiemTraGioiTinh();
        System.out.println("Ngay sinh than nhan: ");
        this.ngaySinhThanNhan.nhapNgay();
        System.out.print("Quan he than nhan -> ");
        this.quanHeThanNhan = check.kiemTraChuoiKyTu();
    }

    public void xuatNhanThan() {
        System.out.println("Ho ten than nhan: " + this.hoTenThanNhan);
        System.out.println("Gioi tinh than nhan: " + this.gioiTinh);
        System.out.println("Ngay sinh than nhan: " + this.ngaySinhThanNhan);
        System.out.println("Quan he than nhan: " + this.quanHeThanNhan);
    }

    @Override
    public String toString() {
        return "THANNHAN [hoTenThanNhan=" + hoTenThanNhan + ", gioiTinh=" + gioiTinh + ", ngaySinhThanNhan=" + ngaySinhThanNhan + ", quanHeThanNhan=" + quanHeThanNhan + "]";
    }
}
