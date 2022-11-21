/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlynhansu;

public class phongbanManager {

    private PHONGBAN[] pbList = null;
    private FilePhongBan fpb;

    CHECK check = new CHECK();

    public phongbanManager() {
        fpb = new FilePhongBan();
        pbList = fpb.read();
    }

    public PHONGBAN[] getPbList() {
        return pbList;
    }

    public PHONGBAN[] add(PHONGBAN[] list, PHONGBAN pb) {
        if (isEmpty(list)) {
            PHONGBAN[] newList = new PHONGBAN[1];
            newList[0] = pb;
            return newList;
        } else {
            PHONGBAN[] newList = new PHONGBAN[list.length + 1];
            for (int i = 0; i < list.length; ++i) {
                newList[i] = list[i];
            }
            newList[list.length] = pb;
            return newList;
        }
    }

    public PHONGBAN[] remove(PHONGBAN[] list, int index) {
        if (index >= 0 && index < list.length) {
            for (int i = index; i < list.length; ++i) {
                list[i] = list[i + 1];
            }
            PHONGBAN[] newList = new PHONGBAN[list.length - 1];
            for (int i = 0; i < newList.length; ++i) {
                newList[i] = list[i];
            }
            return newList;
        } else {
            return list;
        }
    }

    public static boolean isEmpty(PHONGBAN[] list) {
        if (list == null) {
            return true;
        }
        return (list.length == 0);
    }

    public static int isInList(PHONGBAN[] list, String maPhong) {
        if (isEmpty(list)) {
            return -1;
        }
        for (int i = 0; i < list.length; ++i) {
            if (list[i].getMaPhong().equals(maPhong)) {
                return i;
            }
        }
        return -1;
    }

    public void add(NHANVIEN[] nvList) {
        String choice = "Y";
        while (choice.equals("Y")) {
            System.out.print("Moi nhap ma phong ban: ");
            String maPhong = check.kiemTraMaPhongBan();
            if (isEmpty(pbList)) {
                System.out.print("Moi nhap ma nhan vien cua truong phong: ");
                String maNV = check.kiemTraMaNhanVien();
                if (nhanvienManager.isInList(nvList, maNV) != -1) {
                    PHONGBAN pb = new PHONGBAN();
                    pb.nhap(maPhong, maNV);
                    pbList = add(pbList, pb);
                    fpb.write(pbList);
                } else {
                    System.out.println("Khong ton tai ma nhan vien.");
                }
            } else {
                boolean isExist = false;
                for (int i = 0; i < pbList.length; ++i) {
                    if (pbList[i].getMaPhong().equals(maPhong)) {
                        isExist = true;
                        break;
                    }
                }
                if (!isExist) {
                    System.out.print("Moi nhap ma nhan vien cua truong phong: ");
                    String maNV = check.kiemTraMaNhanVien();
                    if (nhanvienManager.isInList(nvList, maNV) != -1) {
                        PHONGBAN pb = new PHONGBAN();
                        pb.nhap(maPhong, maNV);
                        pbList = add(pbList, pb);
                        fpb.write(pbList);
                    } else {
                        System.out.println("Khong ton tai ma nhan vien.");
                    }
                } else {
                    System.out.println("Phong ban da ton tai.");
                }
            }
            System.out.print("Ban co muon tiep tuc nhap thong tin ( Y | N ): ");
            choice = CHECK.yesNoChoice();
        }
    }

    public void editTenPhongBan() {
        System.out.print("Moi nhap ma phong ban can sua: ");
        String maPhong = check.kiemTraMaPhongBan();
        if (isInList(pbList, maPhong) != -1) {
            System.out.println("Ten cua phong ban hien tai: " + pbList[isInList(pbList, maPhong)].getTenPhong());
            System.out.print("Moi nhap ten phong ban moi: ");
            String newTenPhong = check.kiemTraChuoiKyTu();
            boolean isExistNamePB = false;
            for (int i = 0; i < pbList.length; ++i) {
                if (pbList[i].getTenPhong().equals(newTenPhong)) {
                    isExistNamePB = true;
                    break;
                }
            }
            if (!isExistNamePB) {
                pbList[isInList(pbList, maPhong)].setTenPhong(newTenPhong);
                fpb.write(pbList);
            } else {
                System.out.print("Da ton tai ten phong trong danh sach.");
            }
        } else {
            System.out.println("Khong ton tai ma phong ban trong danh sach.");
        }
    }

    public void editTruongPhong() {
        System.out.print("Moi nhap ma phong ban can sua: ");
        String maPhong = check.kiemTraMaPhongBan();
        if (isInList(pbList, maPhong) != -1) {
            System.out.println("Ma truong phong cua phong ban hien tai: " + pbList[isInList(pbList, maPhong)].getMaTruongPhong());
            System.out.print("Moi nhap ma truong phong moi: ");
            String newMaNV = check.kiemTraMaNhanVien();
            if (pbList[isInList(pbList, maPhong)].getMaTruongPhong().equals(newMaNV)) {
                System.out.println("Ma truong phong trung voi ma truong phong cu.");
            } else {
                pbList[isInList(pbList, maPhong)].setMaTruongPhong(newMaNV);
                fpb.write(pbList);
            }
        } else {
            System.out.println("Khong ton tai ma phong ban trong danh sach.");
        }
    }

    public void delete() {
        System.out.print("Moi nhap ma phong ban can xoa: ");
        String maPhong = check.kiemTraMaPhongBan();
        if (isInList(pbList, maPhong) != -1) {
            pbList = remove(pbList, isInList(pbList, maPhong));
            fpb.write(pbList);
            System.out.println("Da xoa phong ban.");
        } else {
            System.out.println("Khong ton tai phong ban can xoa.");
        }
    }

    public void printList() {
        if (isEmpty(pbList)) {
            System.out.println("Danh sach phong ban rong.");
        } else {
            for (int i = 0; i < pbList.length; ++i) {
                if (i == 0) {
                    System.out.println("\n========== DANH SACH PHONG BAN =========");
                    System.out.println("----------------------------------------------------------");
                    System.out.printf("| %-8s | %-25s | %-15s |\n", "Ma phong", "Ten phong ban", "Ma truong phong");
                    System.out.println("----------------------------------------------------------");
                }
                System.out.printf("| %-8s | %-25s | %-15s |\n", pbList[i].getMaPhong(), pbList[i].getTenPhong(), pbList[i].getMaTruongPhong());
            }
            System.out.println("----------------------------------------------------------");
        }
    }

}
