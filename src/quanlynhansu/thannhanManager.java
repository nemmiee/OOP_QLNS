/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlynhansu;

public class thannhanManager {

    private THANNHAN[] tnList = null;
    private FileThanNhan ftn;

    CHECK check = new CHECK();

    public thannhanManager() {
        ftn = new FileThanNhan();
        tnList = ftn.read();
    }

    public thannhanManager(thannhanManager copy) {
        this.tnList = copy.tnList;
    }

    public THANNHAN[] getTnList() {
        return tnList;
    }

    public void setTnList(THANNHAN[] tnList) {
        this.tnList = tnList;
    }

    public THANNHAN[] add(THANNHAN[] list, THANNHAN tn) {
        if (isEmpty(list)) {
            THANNHAN[] newList = new THANNHAN[1];
            newList[0] = tn;
            return newList;
        } else {
            THANNHAN[] newList = new THANNHAN[list.length + 1];
            for (int i = 0; i < list.length; ++i) {
                newList[i] = list[i];
            }
            newList[list.length] = tn;
            return newList;
        }
    }

    public THANNHAN[] remove(THANNHAN[] list, int index) {
        if (index >= 0 && index < list.length) {
            for (int i = index; i < list.length - 1; ++i) {
                list[i] = list[i + 1];
            }
            THANNHAN[] newList = new THANNHAN[list.length - 1];
            for (int i = 0; i < newList.length; ++i) {
                newList[i] = list[i];
            }
            return newList;
        } else {
            return list;
        }
    }

    public boolean isEmpty(THANNHAN[] list) {
        if (list == null) {
            return true;
        }
        return (list.length == 0);
    }

    public static int isInList(THANNHAN[] list, String maNV) {
        for (int i = 0; i < list.length; ++i) {
            if (list[i].getMaNV().equals(maNV)) {
                return i;
            }
        }
        return -1;
    }

    public static int isInList(THANNHAN[] list, String maNV, String tnName) {
        for (int i = 0; i < list.length; ++i) {
            if (list[i].getMaNV().equals(maNV) && list[i].getHoTenThanNhan().equals(tnName)) {
                return i;
            }
        }
        return -1;
    }

    public void add(NHANVIEN[] nvList) {
        if (nhanvienManager.isEmpty(nvList)) {
            System.out.println("Danh sach nhan vien rong");
        } else {
            String choice = "Y";
            while (choice.equals("Y")) {
                System.out.print("Moi nhap ma nhan vien: ");
                String maNV = check.kiemTraMaNhanVien();
                if (nhanvienManager.isInList(nvList, maNV) != -1) {
                    THANNHAN tn = new THANNHAN();
                    tn.nhap(maNV);
                    this.tnList = add(tnList, tn);
                    ftn.write(sortByMaNV());
                } else {
                    System.out.println("Khong co nhan vien trong danh sach.");
                }
                System.out.print("Ban co muon tiep tuc nhap thong tin ( Y | N ): ");
                choice = CHECK.yesNoChoice();
            }

        }
    }

    public THANNHAN[] add(THANNHAN[] head, THANNHAN[] tail) {
        if (isEmpty(head) && isEmpty(tail)) {
            return null;
        } else if (isEmpty(head) && !isEmpty(tail)) {
            return tail;
        } else if (!isEmpty(head) && isEmpty(tail)) {
            return head;
        } else {
            THANNHAN[] list = new THANNHAN[head.length + tail.length];
            int count = 0;
            for (int i = 0; i < head.length; ++i) {
                list[count] = head[i];
                ++count;
            }
            for (int i = 0; i < tail.length; ++i) {
                list[count] = tail[i];
                ++count;
            }
            return list;
        }
    }

    public void delete(NHANVIEN[] nvList) {
        System.out.print("Nhap ma nhan vien cua than nhan can xoa: ");
        String maNV = check.kiemTraMaNhanVien();
        if (nhanvienManager.isInList(nvList, maNV) != -1) {
            System.out.print("Nhap ho ten cua than nhan can xoa: ");
            String name = check.kiemTraHoTen();
            if (isInList(tnList, maNV, name) != -1) {
                this.tnList = remove(tnList, isInList(tnList, maNV, name));
                ftn.write(sortByMaNV());
                System.out.println("Da xoa than nhan.");
            } else {
                System.out.println("Khong ton tai than nhan ban muon xoa.");
            }
        } else {
            System.out.println("Ma nhan vien \"" + maNV + "\" khong ton tai.");
            return;
        }
    }

    public void edit() {
        if (isEmpty(tnList)) {
            System.out.println("Danh sach than nhan rong.");
        } else {
            System.out.print("Moi nhap ma nhan vien co than nhan can chinh sua thong tin: ");
            String maNV = check.kiemTraMaNhanVien();
            if (isInList(tnList, maNV) != -1) {
                System.out.print("Moi nhap ho ten than nhan can chinh sua: ");
                String name = check.kiemTraHoTen();
                if (isInList(tnList, maNV, name) != -1) {
                    while (true) {
                        System.out.println("\n============== THONG TIN HIEN TAI ==============");
                        System.out.println("---------------------------------------------------------------------------");
                        System.out.printf("| %-30s | %-9s | %-13s | %-10s |\n", "Ho va ten than nhan", "Gioi tinh", "Ngay sinh", "Quan he");
                        System.out.println("---------------------------------------------------------------------------");
                        System.out.printf("| %-30s | %-9s | %-13s | %-10s |\n", tnList[isInList(tnList, maNV, name)].getHoTenThanNhan(),
                                tnList[isInList(tnList, maNV, name)].getGioiTinh(), tnList[isInList(tnList, maNV, name)].getNgaySinhThanNhan(),
                                tnList[isInList(tnList, maNV, name)].getQuanHeThanNhan());
                        System.out.println("---------------------------------------------------------------------------");
                        Main.editThanNhanMenu();
                        System.out.print("Moi nhap lua chon: ");
                        int choice = Main.kiemTraChoice();
                        switch (choice) {
                            case 0: {
                                System.out.println("Ban da thoat chinh sua thong tin than nhan.");
                                break;
                            }
                            case 1: {
                                System.out.print("Moi nhap ho va ten moi cua than nhan: ");
                                String newName = check.kiemTraHoTen();
                                if (tnList[isInList(tnList, maNV, name)].getHoTenThanNhan().equals(newName)) {
                                    System.out.println("Trung voi ten cu.");
                                } else {
                                    tnList[isInList(tnList, maNV, name)].setHoTenThanNhan(newName);
                                }
                                break;
                            }
                            case 2: {
                                if (tnList[isInList(tnList, maNV, name)].getGioiTinh().equals("Nam")) {
                                    tnList[isInList(tnList, maNV, name)].setGioiTinh("Nu");
                                    System.out.println("Da doi gioi tinh sang nu");
                                } else {
                                    tnList[isInList(tnList, maNV, name)].setGioiTinh("Nam");
                                    System.out.println("Da doi gioi tinh sang nam");
                                }
                                break;
                            }
                            case 3: {
                                NGAY newBirthDay = new NGAY();
                                newBirthDay.nhapNgay();
                                if (tnList[isInList(tnList, maNV, name)].getNgaySinhThanNhan().equals(newBirthDay)) {
                                    System.out.println("Trung voi ngay sinh cu.");
                                } else {
                                    tnList[isInList(tnList, maNV, name)].setNgaySinhThanNhan(newBirthDay);
                                }
                                break;
                            }
                            case 4: {
                                System.out.print("Moi nhap quan he than nhan moi: ");
                                String newQuanHeTN = check.kiemTraChuoiKyTu();
                                if (tnList[isInList(tnList, maNV, name)].getQuanHeThanNhan().equals(newQuanHeTN)) {
                                    System.out.println("Trung voi quan he than nhan cu.");
                                } else {
                                    tnList[isInList(tnList, maNV, name)].setQuanHeThanNhan(newQuanHeTN);
                                }
                                break;
                            }
                            default:
                                System.out.println("Sai lua chon.");
                                break;
                        }
                        if (choice == 0) {
                            break;
                        }
                    }
                    ftn.write(sortByMaNV());
                } else {
                    System.out.println("Khong co than nhan trong danh sach.");
                }
            } else {
                System.out.println("Khong co nhan vien trong danh sach.");
            }
        }
    }

//    public void edit() {
//        if (isEmpty(tnList)) {
//            System.out.println("Danh sach than nhan rong.");
//        } else {
//            System.out.print("Moi nhap ma nhan vien co than nhan can chinh sua thong tin: ");
//            String maNV = check.kiemTraMaNhanVien();
//            int[] temp = new int[5];
//            int count = 0;
//            boolean isExist = false;
//            for (int i = 0; i < tnList.length; ++i) {
//                if (tnList[i].getMaNV().equals(maNV)) {
//                    temp[count] = i;
//                    count++;
//                }
//            }
//            if (count > 0) {
//                System.out.print("Nhap ho ten cua than nhan: ");
//                String name = check.kiemTraHoTen();
//                for (int i = 0; i < count; ++i) {
//                    if (tnList[temp[i]].getHoTenThanNhan().equals(name)) {
//                        isExist = true;
//                        while (true) {
//                            Main.editThanNhanMenu();
//                            System.out.print("Moi nhap lua chon: ");
//                            int choice = Main.kiemTraChoice();
//                            switch (choice) {
//                                case 0: {
//                                    System.out.println("Ban da thoat chinh sua thong tin than nhan.");
//                                    break;
//                                }
//                                case 1: {
//                                    System.out.print("Nhap ho va ten moi cua than nhan: ");
//                                    String newName = check.kiemTraHoTen();
//                                    if (tnList[temp[i]].getHoTenThanNhan().equals(newName)) {
//                                        System.out.println("Trung voi ten cu.");
//                                    } else {
//                                        tnList[temp[i]].setHoTenThanNhan(newName);
//                                    }
//                                    break;
//                                }
//                                case 2: {
//                                    if (tnList[temp[i]].getGioiTinh().equals("Nam")) {
//                                        tnList[temp[i]].setGioiTinh("Nu");
//                                        System.out.println("Da doi gioi tinh sang nu");
//                                    } else {
//                                        tnList[temp[i]].setGioiTinh("Nam");
//                                        System.out.println("Da doi gioi tinh sang nam");
//                                    }
//                                    break;
//                                }
//                                case 3: {
//                                    NGAY newBirthDay = new NGAY();
//                                    newBirthDay.nhapNgay();
//                                    if (tnList[temp[i]].getNgaySinhThanNhan().equals(newBirthDay)) {
//                                        System.out.println("Trung voi ngay sinh cu.");
//                                    } else {
//                                        tnList[temp[i]].setNgaySinhThanNhan(newBirthDay);
//                                    }
//                                    break;
//                                }
//                                case 4: {
//                                    System.out.print("Nhap quan he than nhan moi: ");
//                                    String newQuanHeTN = check.kiemTraChuoiKyTu();
//                                    if (tnList[temp[i]].getQuanHeThanNhan().equals(newQuanHeTN)) {
//                                        System.out.println("Trung voi quan he than nhan cu.");
//                                    } else {
//                                        tnList[temp[i]].setQuanHeThanNhan(newQuanHeTN);
//                                    }
//                                    break;
//                                }
//                                default:
//                                    System.out.println("Sai lua chon.");
//                                    break;
//                            }
//                            if (choice == 0) {
//                                break;
//                            }
//                        }
//                        break;
//                    }
//                }
//            }
//            if (isExist == true) {
//                ftn.write(sortByMaNV());
//            } else {
//                System.out.println("Khong co than nhan ban can tim trong danh sach.");
//            }
//        }
//    }
    public THANNHAN[] sort(THANNHAN[] tnArr) {
        if (isEmpty(tnArr)) {
            return null;
        } else {
            int min;
            for (int i = 0; i < tnArr.length - 1; ++i) {
                min = i;
                for (int j = i + 1; j < tnArr.length; ++j) {
                    if (nhanvienManager.getNumberOfMaNV(tnArr[j].getMaNV()) < nhanvienManager.getNumberOfMaNV(tnArr[min].getMaNV())) {
                        min = j;
                    }
                }
                if (min != i) {
                    THANNHAN temp = tnArr[i];
                    tnArr[i] = tnArr[min];
                    tnArr[min] = temp;
                }
            }
            return tnArr;
        }
    }

    public THANNHAN[] sortByMaNV() {
        if (isEmpty(tnList)) {
            return null;
        } else {
            THANNHAN[] arrC = null;
            for (int i = 0; i < tnList.length; ++i) {
                if (nhanvienManager.getFirstLetterOfMaNV(tnList[i].getMaNV()).equals("C")) {
                    arrC = add(arrC, tnList[i]);
                }
            }
            arrC = sort(arrC);
            THANNHAN[] arrP = null;
            for (int i = 0; i < tnList.length; ++i) {
                if (nhanvienManager.getFirstLetterOfMaNV(tnList[i].getMaNV()).equals("P")) {
                    arrP = add(arrP, tnList[i]);
                }
            }
            arrP = sort(arrP);
            THANNHAN[] arrT = null;
            for (int i = 0; i < tnList.length; ++i) {
                if (nhanvienManager.getFirstLetterOfMaNV(tnList[i].getMaNV()).equals("T")) {
                    arrT = add(arrT, tnList[i]);
                }
            }
            arrT = sort(arrT);

            arrC = add(arrC, arrP);
            arrC = add(arrC, arrT);
            return arrC;
        }
    }

    public void printThanNhanList() {
        if (isEmpty(tnList)) {
            System.out.println("Danh sach than nhan rong.");
        } else {
            System.out.println("\n============== DANH SACH THAN NHAN ==============");
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.printf("| %-12s | %-30s | %-9s | %-13s | %-10s |\n", "Ma nhan vien", "Ho va ten than nhan",
                    "Gioi tinh", "Ngay sinh", "Quan he");
            System.out.println("------------------------------------------------------------------------------------------");
            for (int i = 0; i < tnList.length; ++i) {
                System.out.printf("| %-12s | %-30s | %-9s | %-13s | %-10s |\n", tnList[i].getMaNV(),
                        tnList[i].getHoTenThanNhan(), tnList[i].getGioiTinh(), tnList[i].getNgaySinhThanNhan(),
                        tnList[i].getQuanHeThanNhan());
            }
            System.out.println("------------------------------------------------------------------------------------------");
        }
    }

    public void printPersonalThanNhan(NHANVIEN[] nvList) {
        if (isEmpty(tnList)) {
            System.out.println("Danh sach than nhan rong.");
        } else {
            if (nhanvienManager.isEmpty(nvList)) {
                System.out.println("Danh sach nhan vien rong.");
            } else {
                System.out.print("Moi nhap ma nhan vien: ");
                String maNV = check.kiemTraMaNhanVien();
                if (nhanvienManager.isInList(nvList, maNV) != -1) {
                    boolean isExist = false;
                    int count = 0;
                    for (int i = 0; i < tnList.length; ++i) {
                        if (tnList[i].getMaNV().equals(maNV)) {
                            isExist = true;
                            ++count;
                            if (count == 1) {
                                System.out.println("\n| " + tnList[i].getMaNV() + " | " + nvList[nhanvienManager.isInList(nvList, maNV)].getHoTen()
                                        + " | " + nvList[nhanvienManager.isInList(nvList, maNV)].getChucVu() + " |");
                                System.out.println("---------------------------------------------------------------------------");
                                System.out.printf("| %-30s | %-9s | %-13s | %-10s |\n", "Ho va ten than nhan", "Gioi tinh", "Ngay sinh", "Quan he");
                                System.out.println("---------------------------------------------------------------------------");
                            }
                            System.out.printf("| %-30s | %-9s | %-13s | %-10s |\n", tnList[i].getHoTenThanNhan(), tnList[i].getGioiTinh(), tnList[i].getNgaySinhThanNhan(), tnList[i].getQuanHeThanNhan());
                        }
                    }
                    if (isExist) {
                        System.out.println("---------------------------------------------------------------------------");
                    } else {
                        System.out.println("Khong ton tai than nhan cua nhan vien.");
                    }
                } else {
                    System.out.println("Khong ton tai nhan vien.");
                }
            }
        }
    }
}
