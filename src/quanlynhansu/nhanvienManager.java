/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlynhansu;

import java.util.ArrayList;

public class nhanvienManager {

    private NHANVIEN[] nvList;
    private FileNhanVien fnv;

    CHECK check = new CHECK();

    public nhanvienManager() {
        fnv = new FileNhanVien();
        nvList = fnv.read();
    }

    public nhanvienManager(nhanvienManager copy) {
        this.nvList = copy.nvList;
    }

    public void setNhanVienList(NHANVIEN[] nvList) {
        this.nvList = nvList;
    }

    public NHANVIEN[] getNhanVienList() {
        return nvList;
    }

    public NHANVIEN[] add(NHANVIEN[] list, NHANVIEN nv) {
        if (isEmpty(list)) {
            NHANVIEN[] newList = new NHANVIEN[1];
            newList[0] = nv;
            return newList;
        } else {
            NHANVIEN[] newList = new NHANVIEN[list.length + 1];
            for (int i = 0; i < list.length; ++i) {
                newList[i] = list[i];
            }
            newList[list.length] = nv;
            return newList;
        }
    }

    public NHANVIEN[] remove(NHANVIEN[] list, int index) {
        if (index >= 0 && index < list.length) {
            for (int i = index; i < list.length - 1; ++i) {
                list[i] = list[i + 1];
            }
            NHANVIEN[] newList = new NHANVIEN[list.length - 1];
            for (int i = 0; i < newList.length; ++i) {
                newList[i] = list[i];
            }
            return newList;
        } else {
            return list;
        }
    }

    public boolean isEmpty(NHANVIEN[] list) {
        if (list == null) {
            return true;
        }
        return (list.length == 0);
    }

    public void add() {
        System.out.print("Moi nhap ma nhan vien: ");
        String maNV = check.kiemTraMaNhanVien();
        if (isEmpty(nvList)) {
            NHANVIEN nv = new NHANVIEN();
            nv.nhapNhanVien(maNV);
            nvList = add(nvList, nv);
            fnv.write(nvList);
        } else {
            while (true) {
                boolean isExist = false;
                for (int i = 0; i < nvList.length; ++i) {
                    if (nvList[i].maNhanVien.equals(maNV)) {
                        isExist = true;
                        break;
                    }
                }
                if (isExist == false) {
                    NHANVIEN nv = new NHANVIEN();
                    nv.nhapNhanVien(maNV);
                    nvList = add(nvList, nv);
                    fnv.write(nvList);
                    break;
                } else {
                    System.out.print("Da ton tai ma nhan vien\nMoi nhap lai ma nhan vien: ");
                    maNV = check.kiemTraMaNhanVien();
                }
            }
        }
    }

    public void edit() {
        System.out.print("  Moi nhap ma nhan vien cua nhan vien can sua: ");
        String maNV = check.kiemTraMaNhanVien();
        boolean isExist = false;
        for (int i = 0; i < nvList.length; ++i) {
            if (nvList[i].getMaNhanVien().equals(maNV)) {
                isExist = true;
                boolean flag = true;
                Main.editNhanVienMenu();
                while (flag) {
                    System.out.print("  Moi nhap lua chon: ");
                    int choice = (int) check.kiemTraSoNguyenDuong();
                    switch (choice) {
                        case 0: {
                            System.out.println("  Ban da thoat sua thong tin nhan vien!\n");
                            flag = false;
                            break;
                        }
                        case 1: {
                            System.out.print("\tHo ten nhan vien -> ");
                            String hoTen = check.kiemTraHoTen();
                            nvList[i].setHoTen(hoTen);
                        }

                        break;
                        case 2: {
                            System.out.println("\tNgay sinh: ");
                            NGAY ngaySinh = new NGAY();
                            ngaySinh.nhapNgay();
                            nvList[i].setNgaySinh(ngaySinh);
                        }
                        break;
                        case 3: {
                            if (nvList[i].getGioiTinh().equals("Nam")) {
                                nvList[i].setGioiTinh("Nu");
                                System.out.println("\tDa thay doi gioi tinh thanh nu");
                            } else if (nvList[i].getGioiTinh().equals("Nu")) {
                                nvList[i].setGioiTinh("Nam");
                                System.out.println("\tDa thay doi gioi tinh thanh nam");
                            }
                        }
                        break;
                        case 4: {
                            System.out.print("\tSo dien thoai -> ");
                            String soDienThoai = check.kiemTraSoDienThoai();
                            nvList[i].setSoDienThoai(soDienThoai);
                        }
                        break;
                        case 5: {
                            System.out.println("\tDia chi: ");
                            DIACHI diaChi = new DIACHI();
                            diaChi.nhapDiaChi();
                            nvList[i].setDiaChi(diaChi);
                        }
                        break;
                        case 6: {
                            System.out.print("\tChuc vu -> ");
                            nvList[i].setChucVu(check.kiemTraChuoiKyTu());
                        }
                        break;
                        case 7: {
                            System.out.println("\tThan nhan: ");
                            THANNHAN thanNhan = new THANNHAN();
                            thanNhan.nhapNhanThan();
                            nvList[i].setThanNhan(thanNhan);
                        }
                        break;
                        default: {
                            System.out.println("\tBan da nhap sai lua chon! Hay nhap dung");
                        }
                        break;
                    }
                }
            }
        }
        if (!isExist) {
            System.out.println("  Ma nhan vien \"" + maNV + "\" khong ton tai!!!");
        } else {
            fnv.write(nvList);
        }
    }

    public void delete() {
        System.out.print("  Nhap ma nhan vien cua nhan vien can xoa: ");
        String maNV = check.kiemTraMaNhanVien();
        boolean isExist = false;
        for (int i = 0; i < nvList.length; ++i) {
            if (nvList[i].getMaNhanVien().equals(maNV)) {
                isExist = true;
                this.nvList = remove(nvList, i);
                System.out.println("  Da xoa nhan vien.");
                break;
            }
        }
        if (!isExist) {
            System.out.println("  Ma nhan vien \"" + maNV + "\" khong ton tai!!!");
        } else {
            fnv.write(nvList);
        }
    }

    public void printListALL() {
        if (isEmpty(nvList)) {
            System.out.println("Danh sach rong.");
        } else {
            System.out.println("+-+-+-+-+-+-+-+ Xuat danh sach nhan vien +-+-+-+-+-+-+-+\n");
            for (int i = 0; i < nvList.length; ++i) {
                nvList[i].xuatNhanVien();
                System.out.println("-----\n");
            }
            System.out.println("+-+-+-+-+-+-+-+ Ket thuc danh sach nhan vien +-+-+-+-+-+-+-+\n");
        }
    }

    public void printPersonalInfo() {
        if (isEmpty(nvList)) {
            System.out.println("Danh sach rong.");
        } else {
            System.out.print("Moi nhap ma nhan vien can xem thong tin: ");
            String maNV = check.kiemTraMaNhanVien();
            for (NHANVIEN i : nvList) {
                if (i.getMaNhanVien().equals(maNV)) {
                    i.xuatNhanVien();
                    return;
                }
            }
            System.out.println("Khong co nhan vien trong danh sach.");
        }
    }
}
