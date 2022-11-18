package quanlynhansu;

import java.io.Serializable;

public class DIACHI implements Serializable {
    private static final long serialVersionUID = 1L;

    private String tenQuan;
    private String tenThanhPho;

    CHECK check = new CHECK();

    public DIACHI() {
    }

    public DIACHI(String tenQuan, String tenThanhPho) {
        this.tenQuan = tenQuan;
        this.tenThanhPho = tenThanhPho;
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
        System.out.print("\tTen quan / huyen / thi xa -> ");
        String quan = Main.scan.nextLine();
        System.out.print("\tTen tinh / thanh pho -> ");
        String thanhPho = Main.scan.nextLine();
        while (!check.kiemTraDiaChi(quan, thanhPho)) {
            System.out.println("Khong hop le! Moi nhap lai:");
            System.out.print("\tTen quan / huyen / thi xa -> ");
            quan = Main.scan.nextLine();
            System.out.print("\tTen tinh / thanh pho -> ");
            thanhPho = Main.scan.nextLine();
        }
        this.tenQuan = Main.inHoaChuCaiDauMoiTu(quan);
        this.tenThanhPho = Main.inHoaChuCaiDauMoiTu(thanhPho);
    }

    @Override
    public String toString() {
        return this.tenQuan + ", " + this.tenThanhPho;
    }
}
