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
        if (isEmpty(list)) {
            return null;
        } else {
            if (index >= 0 && index < list.length) {
                for (int i = index; i < list.length - 1; ++i) {
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

    public boolean isExistTruongPhong(String maPhong) {
        if (isEmpty(pbList)) {
            return false;
        } else {
            for (int i = 0; i < pbList.length; ++i) {
                if (pbList[i].getMaPhong().equals(maPhong) && !pbList[i].getMaTruongPhong().equals("None")) {
                    return true;
                }
            }
            return false;
        }
    }

    public void add() {
        String choice = "Y";
        while (choice.equals("Y")) {
            System.out.print("Moi nhap ma phong ban: ");
            String maPhong = check.kiemTraMaPhongBan();
            if (isEmpty(pbList)) {
                PHONGBAN pb = new PHONGBAN();
                pb.nhap(maPhong);
                pbList = add(pbList, pb);
                fpb.write(pbList);
            } else {
                if (isInList(pbList, maPhong) == -1) {
                    PHONGBAN pb = new PHONGBAN();
                    pb.nhap(maPhong);
                    pbList = add(pbList, pb);
                    fpb.write(pbList);
                } else {
                    System.out.println("Phong ban da ton tai.");
                }
            }
            System.out.print("Ban co muon tiep tuc nhap thong tin ( Y | N ): ");
            choice = CHECK.yesNoChoice();
        }
    }

    public void addTruongPhong(NHANVIEN[] nvList) {
        System.out.print("Moi nhap ma phong ban: ");
        String maPhong = check.kiemTraMaPhongBan();
        if (isInList(pbList, maPhong) != -1) {
            if (!isExistTruongPhong(maPhong)) {
                System.out.print("Moi nhap ma nhan vien cua truong phong: ");
                String maNV = check.kiemTraMaNhanVien();
                if (nhanvienManager.isInList(nvList, maNV) != -1) {
                    boolean isExist = false;
                    if (nvList[nhanvienManager.isInList(nvList, maNV)] instanceof NHANVIENCHINH nvc && nvc.getMaPhong().equals(maPhong)) {
                        for (int i = 0; i < pbList.length; ++i) {
                            if (pbList[i].getMaTruongPhong().equals(maNV)) {
                                isExist = true;
                                break;
                            }
                        }
                        if (!isExist) {
                            System.out.println("Da them truong phong thanh cong.");
                            pbList[isInList(pbList, maPhong)].setMaTruongPhong(maNV);
                            fpb.write(pbList);
                        } else {
                            System.out.println("Da ton tai ma truong phong trong phong ban khac.");
                        }
                    } else if (nvList[nhanvienManager.isInList(nvList, maNV)] instanceof THUCTAPSINH tts && tts.getMaPhong().equals(maPhong)) {
                        for (int i = 0; i < pbList.length; ++i) {
                            if (pbList[i].getMaTruongPhong().equals(maNV)) {
                                isExist = true;
                                break;
                            }
                        }
                        if (!isExist) {
                            System.out.println("Da them truong phong thanh cong.");
                            pbList[isInList(pbList, maPhong)].setMaTruongPhong(maNV);
                            fpb.write(pbList);
                        } else {
                            System.out.println("Da ton tai ma truong phong trong phong ban khac.");
                        }
                    } else {
                        System.out.println("Nhan vien nay khong thuoc phong ban " + maPhong);
                    }
                } else {
                    System.out.println("Khong ton tai ma nhan vien.");
                }
            } else {
                System.out.println("Phong ban " + maPhong + " da ton tai truong phong.");
            }
        } else {
            System.out.println("Phong ban khong ton tai.");
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
                System.out.println("Da ton tai ten phong trong danh sach.");
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
                    System.out.println("+--------------------------------------------------------+");
                    System.out.printf("| %-8s | %-25s | %-15s |\n", "Ma phong", "Ten phong ban", "Ma truong phong");
                    System.out.println("+--------------------------------------------------------+");
                }
                System.out.printf("| %-8s | %-25s | %-15s |\n", pbList[i].getMaPhong(), pbList[i].getTenPhong(), pbList[i].getMaTruongPhong());
            }
            System.out.println("+--------------------------------------------------------+");
        }
    }

    public static void printMaAndTen(PHONGBAN[] list) {
        if (isEmpty(list)) {
            System.out.println("Danh sach phong ban rong.");
        } else {
            for (int i = 0; i < list.length; ++i) {
                if (i == 0) {
                    System.out.println("\n========== DANH SACH PHONG BAN =========");
                    System.out.println("+--------------------------------------+");
                    System.out.printf("| %-8s | %-25s |\n", "Ma phong", "Ten phong ban");
                    System.out.println("+--------------------------------------+");
                }
                System.out.printf("| %-8s | %-25s |\n", list[i].getMaPhong(), list[i].getTenPhong());
            }
            System.out.println("+--------------------------------------+");
        }
    }

    public void printNVPhongBanList(NHANVIEN[] nvList) {
        if (isEmpty(pbList)) {
            System.out.println("Khong co phong ban nao trong danh sach.");
        } else {
            System.out.print("Moi nhap ma phong ban: ");
            String maPhong = check.kiemTraMaPhongBan();
            if (isInList(pbList, maPhong) != -1) {
                int count = -1;
                for (int i = 0; i < nvList.length; ++i) {
                    if (nvList[i] instanceof NHANVIENCHINH nvc && nvc.getMaPhong().equals(maPhong)) {
                        ++count;
                        if (count == 0) {
                            System.out.println("\n+-------------------------------------------------------------"
                                    + "---------------------------------------------------------------------+");
                            System.out.printf("| %-12s | %-30s | %-20s| %-12s | %-25s | %-15s |\n",
                                    "Ma nhan vien", "Ho va ten", "Chuc vu", "Ma phong ban", "Ten phong ban", "Truong phong");
                            System.out.println("+--------------------------------------------------------------"
                                    + "--------------------------------------------------------------------+");
                        }
                        System.out.printf("| %-12s | %-30s | %-20s| %-12s | %-25s | %-15s |\n",
                                nvc.getMaNhanVien(), nvc.getHoTen(), nvc.getChucVu(), maPhong,
                                pbList[isInList(pbList, maPhong)].getTenPhong(),
                                pbList[isInList(pbList, maPhong)].getMaTruongPhong());
                    } else if (nvList[i] instanceof THUCTAPSINH tts && tts.getMaPhong().equals(maPhong)) {
                        ++count;
                        if (count == 0) {
                            System.out.println("+-------------------------------------------------------------"
                                    + "---------------------------------------------------------------------+");
                            System.out.printf("| %-12s | %-30s | %-20s| %-12s | %-25s | %-15s |\n",
                                    "Ma nhan vien", "Ho va ten", "Chuc vu", "Ma phong ban", "Ten phong ban", "Truong phong");
                            System.out.println("+--------------------------------------------------------------"
                                    + "--------------------------------------------------------------------+");
                        }
                        System.out.printf("| %-12s | %-30s | %-20s| %-12s | %-25s | %-15s |\n",
                                tts.getMaNhanVien(), tts.getHoTen(), tts.getChucVu(), maPhong,
                                pbList[isInList(pbList, maPhong)].getTenPhong(),
                                pbList[isInList(pbList, maPhong)].getMaTruongPhong());
                    }
                }
                if (count != -1) {
                    System.out.println("+------------------------------------------------------------------"
                            + "----------------------------------------------------------------+");
                } else {
                    System.out.println("Phong ban \"" + maPhong + "\" khong co nhan vien nao.");
                }
            } else {
                System.out.println("Khong ton tai ma phong \"" + maPhong + "\" trong danh sach phong ban.");

            }
        }
    }

    public void printSinglePhongBanInfo() {
        if (isEmpty(pbList)) {
            System.out.println("Khong ton tai phong ban nao trong danh sach.");
        } else {
            System.out.print("Moi nhap ma phong ban: ");
            String maPhong = check.kiemTraMaPhongBan();
            if (isInList(pbList, maPhong) != -1) {
                System.out.println("\n+--------------------------------------------------------+");
                System.out.printf("| %-8s | %-25s | %-15s |\n", "Ma phong", "Ten phong ban", "Ma truong phong");
                System.out.println("+--------------------------------------------------------+");
                System.out.printf("| %-8s | %-25s | %-15s |\n",
                        pbList[isInList(pbList, maPhong)].getMaPhong(),
                        pbList[isInList(pbList, maPhong)].getTenPhong(),
                        pbList[isInList(pbList, maPhong)].getMaTruongPhong());
                System.out.println("+--------------------------------------------------------+");
            }
            else {
                System.out.println("Phong ban khong ton tai.");
            }
        }
    }

    public void printTruongPhongInfo(NHANVIEN[] nvList) {
        if (nhanvienManager.isEmpty(nvList)) {
            System.out.println("Khong co nhan vien nao trong danh sach nhan vien.");
        } else {
            if (isEmpty(pbList)) {
                System.out.println("Khong co phong ban nao trong danh sach.");
            } else {
                int count = -1;
                for (int i = 0; i < pbList.length; ++i) {
                    if (isExistTruongPhong(pbList[i].getMaPhong())) {
                        ++count;
                        if (count == 0) {
                            System.out.println("\n+------------------------------------------------------------------------------"
                                    + "----------------------------------------------------------------------------------------"
                                    + "--------------------------------------------------------------------------------------+");
                            System.out.printf("| %-12s | %-30s | %-9s | %-10s | %-13s | %-40s | %-20s| %-35s | %-9s | %-21s | %-21s |\n",
                                    "Ma nhan vien", "Ho va ten", "Gioi tinh", "Ngay sinh", "So dien thoai", "Dia chi",
                                    "Chuc vu", "Email", "Phong ban", "Ngay bat dau hop dong", "Ngay ket thuc hop dong");
                            System.out.println("+------------------------------------------------------------------------------"
                                    + "----------------------------------------------------------------------------------------"
                                    + "--------------------------------------------------------------------------------------+");
                        }
                        nhanvienManager.printPersonalInfo(nvList, pbList[i].getMaTruongPhong());
                    }
                }
                if (count != -1) {
                    System.out.println("+------------------------------------------------------------------------------"
                            + "----------------------------------------------------------------------------------------"
                            + "--------------------------------------------------------------------------------------+");
                } else {
                    System.out.println("Khong co truong phong nao trong danh sach.");
                }
            }
        }
    }

}
