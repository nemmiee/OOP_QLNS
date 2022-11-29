/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlynhansu;

/**
 *
 * @author Admin
 */
public class duanManager {

    private DUAN[] daList;
    private FileDuAn fda;

    public duanManager() {
        fda = new FileDuAn();
        daList = fda.read();
    }

    CHECK check = new CHECK();

    public DUAN[] getDaList() {
        return daList;
    }

    public DUAN[] add(DUAN[] list, DUAN da) {
        if (isEmpty(list)) {
            DUAN[] newList = new DUAN[1];
            newList[0] = da;
            return newList;
        } else {
            DUAN[] newList = new DUAN[list.length + 1];
            for (int i = 0; i < list.length; ++i) {
                newList[i] = list[i];
            }
            newList[list.length] = da;
            return newList;
        }
    }

    public DUAN[] remove(DUAN[] list, int index) {
        if (isEmpty(list)) {
            return null;
        } else {
            if (index >= 0 && index < list.length) {
                for (int i = index; i < list.length - 1; ++i) {
                    list[i] = list[i + 1];
                }
                DUAN[] newList = new DUAN[list.length - 1];
                for (int i = 0; i < newList.length; ++i) {
                    newList[i] = list[i];
                }
                return newList;
            } else {
                return list;
            }
        }
    }

    public static boolean isEmpty(DUAN[] list) {
        if (list == null) {
            return true;
        }
        return (list.length == 0);
    }

    public static int isInList(DUAN[] list, String maDuAn) {
        if (isEmpty(list)) {
            return -1;
        }
        for (int i = 0; i < list.length; ++i) {
            if (list[i].getMaDuAn().equals(maDuAn)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isExistPhongBanPhuTrach(String maDuAn) {
        if (isEmpty(daList)) {
            return false;
        } else {
            for (int i = 0; i < daList.length; ++i) {
                if (daList[i].getMaDuAn().equals(maDuAn) && !daList[i].getMaPhongBanPhuTrach().equals("None")) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean isExistNVInNVDuAnList(DUAN da, String maNV) {
        if (da.getNvDuAnList() == null) {
            return false;
        }
        for (int i = 0; i < da.getNvDuAnList().length; ++i) {
            if (da.getNvDuAnList()[i].getMaNhanVien().equals(maNV)) {
                return true;
            }
        }
        return false;
    }

    public void add() {
        String choice = "Y";
        while (choice.equals("Y")) {
            System.out.print("Moi nhap ma du an: ");
            String maDuAn = check.kiemTraMaDuAn();
            if (isEmpty(daList)) {
                DUAN da = new DUAN();
                da.nhap(maDuAn);
                daList = add(daList, da);
                fda.write(daList);
            } else {
                if (isInList(daList, maDuAn) == -1) {
                    DUAN da = new DUAN();
                    da.nhap(maDuAn);
                    daList = add(daList, da);
                    fda.write(daList);
                } else {
                    System.out.println("Du an da ton tai.");
                }
            }
            System.out.print("Ban co muon tiep tuc nhap thong tin ( Y | N ): ");
            choice = CHECK.yesNoChoice();
        }
    }

    public void addPhongBanPhuTrachDuAn(PHONGBAN[] pbList) {
        if (isEmpty(daList)) {
            System.out.println("Khong ton tai du an nao trong danh sach.");
        } else {
            System.out.print("Moi nhap ma du an: ");
            String maDuAn = check.kiemTraMaDuAn();
            if (isInList(daList, maDuAn) != -1) {
                if (!isExistPhongBanPhuTrach(maDuAn)) {
                    phongbanManager.printMaAndTen(pbList);
                    System.out.print("Moi nhap ma phong ban phu trach du an: ");
                    String maPhong = check.kiemTraMaPhongBan();
                    if (phongbanManager.isInList(pbList, maPhong) != -1) {
                        System.out.println("Da them phong ban phu trach du an thanh cong.");
                        daList[isInList(daList, maDuAn)].setMaPhongBanPhuTrach(maPhong);
                        fda.write(daList);
                    } else {
                        System.out.println("Khong ton tai ma phong ban.");
                    }
                } else {
                    System.out.println("Du an " + maDuAn + " da ton tai phong ban phu trach.");
                }
            } else {
                System.out.println("Du an khong ton tai.");
            }
        }
    }

    public void addNVToDuAn(NHANVIEN[] nvList) {
        if (isEmpty(daList)) {
            System.out.println("Khong co du an nao trong danh sach");
        } else {
            if (nhanvienManager.isEmpty(nvList)) {
                System.out.println("Khong co nhan vien nao trong danh sach.");
            } else {
                checkFirst(nvList);
                String choice1 = "Y", choice2;
                while (choice1.equals("Y")) {
                    System.out.print("Moi nhap ma du an: ");
                    String maDuAn = check.kiemTraMaDuAn();
                    if (isInList(daList, maDuAn) != -1) {
                        choice2 = "Y";
                        while (choice2.equals("Y")) {
                            System.out.print("Moi nhap ma nhan vien: ");
                            String maNV = check.kiemTraMaNhanVien();
                            if (nhanvienManager.isInList(nvList, maNV) != -1) {
                                if (nvList[nhanvienManager.isInList(nvList, maNV)] instanceof NHANVIENPHU) {
                                    System.out.println("Khong the them nhan vien phu vao du an.");
                                } else {
                                    if (!isExistNVInNVDuAnList(daList[isInList(daList, maDuAn)], maNV)) {
                                        System.out.println("Da them thanh cong.");
                                        daList[isInList(daList, maDuAn)].addOneNvToDuAnList(nvList[nhanvienManager.isInList(nvList, maNV)]);
                                        fda.write(daList);
                                    } else {
                                        System.out.println("Da ton tai nhan vien trong du an.");
                                    }
                                }
                            } else {
                                System.out.println("Khong ton tai nhan vien trong danh sach.");
                            }
                            System.out.print("Ban co muon tiep tuc them nhan vien vao du an " + maDuAn + " ( Y | N ): ");
                            choice2 = CHECK.yesNoChoice();
                        }
                        System.out.print("Ban co muon tiep tuc them nhan vien vao du an khac (Y | N ): ");
                        choice1 = CHECK.yesNoChoice();
                    } else {
                        System.out.println("Khong ton tai ma du an trong danh sach.");
                        System.out.print("Ban co muon tiep tuc them nhan vien vao du an khac (Y | N ): ");
                        choice1 = CHECK.yesNoChoice();
                    }
                }
            }
        }
    }

    public void edit(PHONGBAN[] pbList) {
        if (isEmpty(daList)) {
            System.out.println("Khong ton tai du an nao trong danh sach.");
        } else {
            checkFirst(pbList);
            System.out.print("Moi nhap ma du an can chinh sua: ");
            String maDuAn = check.kiemTraMaDuAn();
            if (isInList(daList, maDuAn) != -1) {
                boolean flag = false;
                int choice;
                while (!flag) {
                    // In thong tin hien tai
                    System.out.println("\n============== THONG TIN HIEN TAI ==============\n"
                            + "+----------------------------------------------------------------"
                            + "-------------------------------------------------------------------------+");
                    System.out.printf("| %-8s | %-40s | %-18s | %17s | %-18s | %-19s |\n",
                            "Ma du an", "Ten du an", "Ma phong phu trach",
                            "Kinh phi (VND)", "Ngay bat dau du an", "Ngay ket thuc du an");
                    System.out.println("+----------------------------------------------------------------"
                            + "-------------------------------------------------------------------------+");
                    System.out.printf("| %-8s | %-40s | %-18s | %17s | %18s | %19s |\n",
                            daList[isInList(daList, maDuAn)].getMaDuAn(), daList[isInList(daList, maDuAn)].getTenDuAn(),
                            daList[isInList(daList, maDuAn)].getMaPhongBanPhuTrach(),
                            check.changeMoney(daList[isInList(daList, maDuAn)].getKinhPhi()),
                            daList[isInList(daList, maDuAn)].getNgayBatDauDuAn().toString(),
                            daList[isInList(daList, maDuAn)].getNgayKetThucDuAn().toString());
                    System.out.println("+----------------------------------------------------------------"
                            + "-------------------------------------------------------------------------+");
                    // Ket thuc in thong tin hien tai
                    Main.editDuAnMenu();
                    System.out.print("Moi nhap lua chon: ");
                    choice = (int) CHECK.kiemTraSoNguyenDuong();
                    switch (choice) {
                        case 0: {
                            System.out.println("Ban da thoat sua thong tin du an!\n");
                            flag = true;
                            break;
                        }
                        case 1: {
                            System.out.print("Moi nhap ten du an moi: ");
                            String newTenDuAn = Main.scan.nextLine();
                            newTenDuAn = Main.inHoaChuCaiDauTienCuaChuoi(newTenDuAn);
                            boolean isExistNameDA = false;
                            for (int i = 0; i < daList.length; ++i) {
                                if (daList[i].getTenDuAn().equals(newTenDuAn)) {
                                    isExistNameDA = true;
                                    break;
                                }
                            }
                            if (!isExistNameDA) {
                                System.out.println("Da thay doi thanh cong");
                                daList[isInList(daList, maDuAn)].setTenDuAn(newTenDuAn);
                                fda.write(daList);
                            } else {
                                System.out.println("Da ton tai ten du an trong danh sach.");
                            }
                            break;
                        }
                        case 2: {
                            if (!isExistPhongBanPhuTrach(maDuAn)) {
                                phongbanManager.printMaAndTen(pbList);
                                System.out.print("Moi nhap ma phong ban phu trach du an: ");
                                String maPhong = check.kiemTraMaPhongBan();
                                if (phongbanManager.isInList(pbList, maPhong) != -1) {
                                    System.out.println("Da them phong ban phu trach du an thanh cong.");
                                    daList[isInList(daList, maDuAn)].setMaPhongBanPhuTrach(maPhong);
                                    fda.write(daList);
                                } else {
                                    System.out.println("Khong ton tai ma phong ban.");
                                }
                            } else {
                                System.out.println("Du an " + maDuAn + " da ton tai phong ban phu trach.");
                            }
                            break;
                        }
                        case 3: {
                            if (daList[isInList(daList, maDuAn)].getMaPhongBanPhuTrach().equals("None")) {
                                System.out.println("Khong the xoa vi du an nay hien van chua co phong ban phu trach.");
                            } else {
                                System.out.println("Da xoa phong ban phu trach thanh cong.");
                                daList[isInList(daList, maDuAn)].setMaPhongBanPhuTrach("None");
                                fda.write(daList);
                            }
                            break;
                        }
                        case 4: {
                            System.out.print("Moi nhap kinh phi moi: ");
                            long newKinhPhi = CHECK.kiemTraSoNguyenDuong();
                            System.out.println("Da thay doi thanh cong");
                            daList[isInList(daList, maDuAn)].setKinhPhi(newKinhPhi);
                            fda.write(daList);
                            break;
                        }
                        case 5: {
                            System.out.println("Moi nhap ngay bat dau du an: ");
                            NGAY start = new NGAY();
                            start.nhap();
                            System.out.println("Moi nhap ngay ket thuc du an: ");
                            NGAY end = new NGAY();
                            end.nhap();
                            while (!check.kiemTraStartEndDay(start, end)) {
                                System.out.println("Ngay ket thuc phai sau ngay bat dau! Moi nhap lai:");
                                System.out.println("Nhap lai ngay bat dau du an: ");
                                start.nhap();
                                System.out.println("Nhap lai ngay ket thuc du an: ");
                                end.nhap();
                            }
                            System.out.println("Da thay doi thanh cong");
                            daList[isInList(daList, maDuAn)].setNgayBatDauDuAn(start);
                            daList[isInList(daList, maDuAn)].setNgayKetThucDuAn(end);
                            break;
                        }
                        default: {
                            System.out.println("Ban da nhap sai lua chon! Hay nhap dung");
                            break;
                        }
                    }
                }
            } else {
                System.out.println("Khong ton tai ma du an trong danh sach.");
            }
        }
    }

    public void editTenDuAn() {
        System.out.print("Moi nhap ma du an can sua ten: ");
        String maDuAn = check.kiemTraMaDuAn();
        if (isInList(daList, maDuAn) != -1) {
            System.out.println("Ten cua du an hien tai: " + daList[isInList(daList, maDuAn)].getTenDuAn());
            System.out.print("Moi nhap ten du an moi: ");
            String newTenDuAn = Main.scan.next();
            newTenDuAn = Main.inHoaChuCaiDauTienCuaChuoi(newTenDuAn);
            boolean isExistNameDA = false;
            for (int i = 0; i < daList.length; ++i) {
                if (daList[i].getTenDuAn().equals(newTenDuAn)) {
                    isExistNameDA = true;
                    break;
                }
            }
            if (!isExistNameDA) {
                daList[isInList(daList, maDuAn)].setTenDuAn(newTenDuAn);
                fda.write(daList);
            } else {
                System.out.println("Da ton tai ten du an trong danh sach.");
            }
        } else {
            System.out.println("Khong ton tai ma du an trong danh sach.");
        }
    }

    public void editPhongBanPhuTrachDuAn(PHONGBAN[] pbList) {
        if (isEmpty(daList)) {
            System.out.println("Khong co du an nao trong danh sach.");
        } else {
            System.out.print("Moi nhap ma du an can thay doi phong ban phu trach: ");
            String maDuAn = check.kiemTraMaDuAn();
            if (isInList(daList, maDuAn) != -1) {
                phongbanManager.printMaAndTen(pbList);
                System.out.println("Ma phong ban phu trach hien tai: " + daList[isInList(daList, maDuAn)].getMaPhongBanPhuTrach());
                System.out.print("Moi nhap ma phong ban phu trach moi: ");
                String newMaPhong = check.kiemTraMaPhongBan();
                if (daList[isInList(daList, maDuAn)].getMaPhongBanPhuTrach().equals(newMaPhong)) {
                    System.out.println("Ma phong ban phu trach moi trung voi ma phong ban cu.");
                } else {
                    daList[isInList(daList, maDuAn)].setMaPhongBanPhuTrach(newMaPhong);
                    fda.write(daList);
                }
            } else {
                System.out.println("Khong ton tai ma du an trong danh sach.");
            }
        }
    }

    public void delete() {
        if (isEmpty(daList)) {
            System.out.println("Khong ton tai du an nao trong danh sach.");
        } else {
            System.out.print("Moi nhap ma du an can xoa: ");
            String maDuAn = check.kiemTraMaDuAn();
            if (isInList(daList, maDuAn) != -1) {
                daList = remove(daList, isInList(daList, maDuAn));
                fda.write(daList);
                System.out.println("Da xoa du an.");
            } else {
                System.out.println("Khong ton tai du an can xoa.");
            }
        }
    }

    public void deletePhongBanPhuTrachDuAn() {
        if (isEmpty(daList)) {
            System.out.println("Khong ton tai du an nao trong danh sach.");
        } else {
            System.out.print("Moi nhap ma du an can xoa phong ban phu trach: ");
            String maDuAn = check.kiemTraMaDuAn();
            if (isInList(daList, maDuAn) != -1) {
                if (daList[isInList(daList, maDuAn)].getMaPhongBanPhuTrach().equals("None")) {
                    System.out.println("Khong the xoa vi du an nay hien van chua co phong ban phu trach.");
                } else {
                    System.out.println("Da xoa phong ban phu trach thanh cong.");
                    daList[isInList(daList, maDuAn)].setMaPhongBanPhuTrach("None");
                    fda.write(daList);
                }
            } else {
                System.out.println("Khong ton tai ma du an.");
            }
        }
    }

    public void deleteNVFromDuAn(NHANVIEN[] nvList) {
        if (isEmpty(daList)) {
            System.out.println("Khong ton tai du an nao trong danh sach.");
        } else {
            checkFirst(nvList);
            System.out.print("Moi nhap ma du an: ");
            String maDuAn = check.kiemTraMaDuAn();
            if (isInList(daList, maDuAn) != -1) {
                if (!nhanvienManager.isEmpty(daList[isInList(daList, maDuAn)].getNvDuAnList())) {
                    System.out.print("Moi nhap ma nhan vien can xoa khoi du an: ");
                    String maNV = check.kiemTraMaNhanVien();
                    if (nhanvienManager.isInList(daList[isInList(daList, maDuAn)].getNvDuAnList(), maNV) != -1) {
                        System.out.println("Da xoa thanh cong.");
                        daList[isInList(daList, maDuAn)].setNvDuAnList(nhanvienManager.remove(daList[isInList(daList, maDuAn)].getNvDuAnList(),
                                nhanvienManager.isInList(daList[isInList(daList, maDuAn)].getNvDuAnList(), maNV)));
                        fda.write(daList);
                    } else {
                        System.out.println("Khong ton tai nhan vien nay trong du an.");
                    }
                } else {
                    System.out.println("Du an khong co nhan vien nao.");
                }
            } else {
                System.out.println("Ma du an khong ton tai.");
            }
        }
    }

    public void printList() {
        if (isEmpty(daList)) {
            System.out.println("Danh sach du an rong.");
        } else {
            for (int i = 0; i < daList.length; ++i) {
                if (i == 0) {
                    System.out.println("\n========== DANH SACH DU AN =========");
                    System.out.println("+----------------------------------------------------------------"
                            + "-------------------------------------------------------------------------+");
                    System.out.printf("| %-8s | %-40s | %-18s | %17s | %-18s | %-19s |\n",
                            "Ma du an", "Ten du an", "Ma phong phu trach",
                            "Kinh phi (VND)", "Ngay bat dau du an", "Ngay ket thuc du an");
                    System.out.println("+----------------------------------------------------------------"
                            + "-------------------------------------------------------------------------+");
                }
                System.out.printf("| %-8s | %-40s | %-18s | %17s | %18s | %19s |\n",
                        daList[i].getMaDuAn(), daList[i].getTenDuAn(), daList[i].getMaPhongBanPhuTrach(),
                        check.changeMoney(daList[i].getKinhPhi()), daList[i].getNgayBatDauDuAn().toString(),
                        daList[i].getNgayKetThucDuAn().toString());
            }
            System.out.println("+----------------------------------------------------------------"
                    + "-------------------------------------------------------------------------+");
        }
    }

    public void printNVDuAnList(NHANVIEN[] nvList) {
        if (isEmpty(daList)) {
            System.out.println("Khong co du an nao trong danh sach.");
        } else {
            checkFirst(nvList);
            System.out.print("Moi nhap ma du an can xem danh sach nhan vien: ");
            String maDuAn = check.kiemTraMaDuAn();
            if (isInList(daList, maDuAn) != -1) {
                if (daList[isInList(daList, maDuAn)].getNvDuAnList() != null) {
                    for (int i = 0; i < daList[isInList(daList, maDuAn)].getNvDuAnList().length; ++i) {
                        if (i == 0) {
                            System.out.println("\n| Ma du an: " + daList[isInList(daList, maDuAn)].getMaDuAn()
                                    + " | Ten du an: " + daList[isInList(daList, maDuAn)].getTenDuAn()
                                    + " | Ma phong ban phu trach: " + daList[isInList(daList, maDuAn)].getMaPhongBanPhuTrach() + " |");
                            System.out.println("+------------------------------------------------------------------------------"
                                    + "----------------------------------------------------------------------------------------"
                                    + "--------------------------------------------------------------------------------------+");
                            System.out.printf("| %-12s | %-30s | %-9s | %-10s | %-13s | %-40s | %-20s| %-35s | %-9s | %-21s | %-21s |\n",
                                    "Ma nhan vien", "Ho va ten", "Gioi tinh", "Ngay sinh", "So dien thoai", "Dia chi",
                                    "Chuc vu", "Email", "Phong ban", "Ngay bat dau hop dong", "Ngay ket thuc hop dong");
                            System.out.println("+------------------------------------------------------------------------------"
                                    + "----------------------------------------------------------------------------------------"
                                    + "--------------------------------------------------------------------------------------+");
                        }
                        nhanvienManager.printPersonalInfo(daList[isInList(daList, maDuAn)].getNvDuAnList(),
                                daList[isInList(daList, maDuAn)].getNvDuAnList()[i].getMaNhanVien());
                    }
                    System.out.println("+------------------------------------------------------------------------------"
                            + "----------------------------------------------------------------------------------------"
                            + "--------------------------------------------------------------------------------------+");
                } else {
                    System.out.println("Du an nay khong ton tai nhan vien nao.");
                }
            } else {
                System.out.println("Khong ton tai ma du an trong danh sach.");
            }
        }
    }

    public void checkFirst(NHANVIEN[] nvList) {
        for (int i = 0; i < daList.length; ++i) {
            if (daList[i].getNvDuAnList() != null) {
                for (int j = 0; j < daList[i].getNvDuAnList().length; ++j) {
                    if (nhanvienManager.isInList(nvList, daList[i].getNvDuAnList()[j].getMaNhanVien()) == -1) {
                        daList[i].setNvDuAnList(nhanvienManager.remove(daList[i].getNvDuAnList(), j));
                    }
                }
            }
        }
        fda.write(daList);
    }

    public void checkFirst(PHONGBAN[] pbList) {
        for (int i = 0; i < daList.length; ++i) {
            if (phongbanManager.isInList(pbList, daList[i].getMaPhongBanPhuTrach()) == -1) {
                daList[i].setMaPhongBanPhuTrach("None");
            }
        }
        fda.write(daList);
    }
}
