package quanlynhansu;

public class DIACHI {

    private String soNha;
    private String tenDuong;
    private String tenPhuong;
    private String tenQuan;
    private String tenThanhPho;

    CHECK check = new CHECK();

    public DIACHI() {
    }

    public DIACHI(String soNha, String tenDuong, String tenPhuong, String tenQuan, String tenThanhPho) {
        this.soNha = soNha;
        this.tenDuong = tenDuong;
        this.tenPhuong = tenPhuong;
        this.tenQuan = tenQuan;
        this.tenThanhPho = tenThanhPho;
    }

    public String getSoNha() {
        return soNha;
    }

    public void setSoNha(String soNha) {
        this.soNha = soNha;
    }

    public String getTenDuong() {
        return tenDuong;
    }

    public void setTenDuong(String tenDuong) {
        this.tenDuong = tenDuong;
    }

    public String getTenPhuong() {
        return tenPhuong;
    }

    public void setTenPhuong(String tenPhuong) {
        this.tenPhuong = tenPhuong;
    }

    public String getTenQuan() {
        return tenQuan;
    }

    public void setTenQuan(String tenQuan) {
        this.tenQuan = tenQuan;
    }

    public String getTenThanhPho() {
        return tenThanhPho;
    }

    public void setTenThanhPho(String tenThanhPho) {
        this.tenThanhPho = tenThanhPho;
    }

    public void nhapDiaChi() {
        System.out.print("\tSo nha -> ");
        String sonha = Main.scan.nextLine();
        System.out.print("\tTen duong -> ");
        String duong = Main.scan.nextLine();
        System.out.print("\tTen phuong -> ");
        String phuong = Main.scan.nextLine();
        System.out.print("\tTen quan / huyen / thi xa -> ");
        String quan = Main.scan.nextLine();
        System.out.print("\tTen tinh / thanh pho -> ");
        String thanhPho = Main.scan.nextLine();
        while (!check.kiemTraDiaChi(sonha, duong, phuong, quan, thanhPho)) {
            System.out.println("Khong hop le! Moi nhap lai:");
            System.out.print("\tSo nha -> ");
            sonha = Main.scan.nextLine();
            System.out.print("\tTen duong -> ");
            duong = Main.scan.nextLine();
            System.out.print("\tTen phuong -> ");
            phuong = Main.scan.nextLine();
            System.out.print("\tTen quan / huyen / thi xa -> ");
            quan = Main.scan.nextLine();
            System.out.print("\tTen tinh / thanh pho -> ");
            thanhPho = Main.scan.nextLine();
        }
        this.soNha = Main.inHoaChuCaiDauMoiTu(sonha);
        this.tenDuong = Main.inHoaChuCaiDauMoiTu(duong);
        this.tenPhuong = Main.inHoaChuCaiDauMoiTu(phuong);
        this.tenQuan = Main.inHoaChuCaiDauMoiTu(quan);
        this.tenThanhPho = Main.inHoaChuCaiDauMoiTu(thanhPho);
    }

    @Override
    public String toString() {
        return this.soNha + ", " + this.tenDuong + ", " + this.tenPhuong + ", " + this.tenQuan + ", " + this.tenThanhPho;
    }

//	public static void main(String[] args) {
//		DIACHI a= new DIACHI();
//		a.nhapDiaChi();
//		System.out.println(a);
//	}
}
