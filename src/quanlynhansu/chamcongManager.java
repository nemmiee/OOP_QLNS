/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlynhansu;

public class chamcongManager {

    private CHAMCONG[] ccList = null;
    private FileChamCong fcc;

    CHECK check = new CHECK();

    public chamcongManager() {
        fcc = new FileChamCong();
        ccList = fcc.read();
    }

    public CHAMCONG[] getCcList() {
        return ccList;
    }

    public void setCcList(CHAMCONG[] ccList) {
        this.ccList = ccList;
    }

    public CHAMCONG[] add(CHAMCONG[] list, CHAMCONG cc) {
        if (isEmpty(list)) {
            CHAMCONG[] newList = new CHAMCONG[1];
            newList[0] = cc;
            return newList;
        } else {
            CHAMCONG[] newList = new CHAMCONG[list.length + 1];
            for (int i = 0; i < list.length; ++i) {
                newList[i] = list[i];
            }
            newList[list.length] = cc;
            return newList;
        }
    }

    public CHAMCONG[] add(CHAMCONG[] head, CHAMCONG[] tail) {
        if (isEmpty(head) && isEmpty(tail)) {
            return null;
        } else if (isEmpty(head) && !isEmpty(tail)) {
            return tail;
        } else if (!isEmpty(head) && isEmpty(tail)) {
            return head;
        } else {
            CHAMCONG[] list = new CHAMCONG[head.length + tail.length];
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

    public CHAMCONG[] remove(CHAMCONG[] list, int index) {
        if (index >= 0 && index < list.length) {
            for (int i = index; i < list.length - 1; ++i) {
                list[i] = list[i + 1];
            }
            CHAMCONG[] newList = new CHAMCONG[list.length - 1];
            for (int i = 0; i < newList.length; ++i) {
                newList[i] = list[i];
            }
            return newList;
        } else {
            return list;
        }
    }

    public static boolean isEmpty(CHAMCONG[] list) {
        if (list == null) {
            return true;
        }
        return (list.length == 0);
    }

    public boolean isExistInList(int thang, int nam) {
        for (int i = 0; i < ccList.length; ++i) {
            if (ccList[i].getThang() == thang && ccList[i].getNam() == nam) {
                return true;
            }
        }
        return false;
    }

    public static int isInList(CHAMCONG[] list, String maNV) {
        if (isEmpty(list)) {
            return -1;
        }
        for (int i = 0; i < list.length; ++i) {
            if (list[i].getMaNV().equals(maNV)) {
                return i;
            }
        }
        return -1;
    }

    public static CHAMCONG getChamCong(CHAMCONG[] list, String maNV, int thang, int nam) {
        for (int i = 0; i < list.length; ++i) {
            if (list[i].getMaNV().equals(maNV) && list[i].getThang() == thang && list[i].getNam() == nam) {
                return list[i];
            }
        }
        return null;
    }

    public void add(NHANVIEN[] nvList, int thang, int nam) {
        if (nhanvienManager.isEmpty(nvList)) {
            System.out.println("Danh sach nhan vien rong.");
        } else {
            System.out.print("Moi nhap ma nhan vien: ");
            String maNV = check.kiemTraMaNhanVien();
            boolean isExistNV = false;
            boolean isNotExistInCCList = true;
            if (nhanvienManager.isInList(nvList, maNV) != -1) {
                isExistNV = true;
                // Kiem tra bang cham cong co rong hay khong
                if (isEmpty(ccList)) {
                    CHAMCONG cc = new CHAMCONG();
                    cc.nhap(maNV, thang, nam);
                    this.ccList = add(ccList, cc);
                    fcc.write(sortByMaNV());
                } else {
                    for (int i = 0; i < ccList.length; ++i) {
                        if (ccList[i].getMaNV().equals(maNV) && ccList[i].getThang() == thang && ccList[i].getNam() == nam) {
                            isNotExistInCCList = false;
                            break;
                        }
                    }
                    if (isNotExistInCCList) {
                        CHAMCONG cc = new CHAMCONG();
                        cc.nhap(maNV, thang, nam);
                        this.ccList = add(ccList, cc);
                        fcc.write(sortByMaNV());
                    } else {
                        System.out.println("Da ton tai nhan vien trong bang cham cong.");
                    }
                }
            }
            if (isExistNV == false) {
                System.out.println("Ma nhan vien khong ton tai.");
            }
        }
    }

    public void add(NHANVIEN[] nvList) {
        String choice1 = "Y", choice2 = "Y";
        while (choice1.equals("Y")) {
            System.out.print("Moi nhap nam: ");
            int nam = (int) CHECK.kiemTraSoNguyenDuong();
            System.out.print("Moi nhap thang: ");
            int thang = (int) CHECK.kiemTraSoNguyenDuong();
            if (thang > 0 && thang < 13) {
                choice2 = "Y";
                while (choice2.equals("Y")) {
                    add(nvList, thang, nam);
                    fcc.write(sortByMaNV());
                    System.out.print("Ban co muon tiep tuc nhap thong tin vao bang cham cong " + thang + "/" + nam + " ( Y | N ): ");
                    choice2 = CHECK.yesNoChoice();
                }
                System.out.print("Ban co muon tiep tuc nhap thong tin ( Y | N ): ");
                choice1 = CHECK.yesNoChoice();
            } else {
                System.out.println("Thang khong ton tai.");
                System.out.print("Ban co muon tiep tuc nhap thong tin ( Y | N ): ");
                choice1 = CHECK.yesNoChoice();
            }
        }
    }

    public void delete(int thang, int nam) {
        System.out.print("Nhap ma nhan vien can xoa khoi bang cham cong: ");
        String maNV = check.kiemTraMaNhanVien();
        boolean isExist = false;
        for (int i = 0; i < ccList.length; ++i) {
            if (ccList[i].getMaNV().equals(maNV) && ccList[i].getThang() == thang && ccList[i].getNam() == nam) {
                isExist = true;
                ccList = remove(ccList, i);
                break;
            }
        }
        if (!isExist) {
            System.out.println("Ma nhan vien " + maNV + " khong ton tai.");
        } else {
            fcc.write(sortByMaNV());
        }
    }

    public void deleteBangChamCongTheoThang(int thang, int nam) {
        boolean isExist = false;
        for (int i = 0; i < ccList.length; ++i) {
            if (ccList[i].getThang() == thang && ccList[i].getNam() == nam) {
                isExist = true;
                ccList = remove(ccList, i);
            }
        }
        if (!isExist) {
            System.out.println("Khong co bang cham cong " + thang + "/" + nam + " trong danh sach.");
        } else {
            fcc.write(sortByMaNV());
        }
    }

    public void delete() {
        System.out.println("Nhap 1 de xoa tung ca nhan.");
        System.out.println("Nhap 2 de xoa 1 bang cham cong.");
        System.out.print("Moi lua chon: ");
        int choice = (int) CHECK.kiemTraSoNguyenDuong();
        switch (choice) {
            case 1: {
                String choice1 = "Y", choice2 = "Y";
                while (choice1.equals("Y")) {
                    choice2 = "Y";
                    System.out.print("Moi nhap nam: ");
                    int nam = (int) CHECK.kiemTraSoNguyenDuong();
                    System.out.print("Moi nhap thang: ");
                    int thang = (int) CHECK.kiemTraSoNguyenDuong();
                    if (thang > 0 && thang < 13) {
                        while (choice2.equals("Y")) {
                            delete(thang, nam);
                            System.out.print("Ban co muon tiep tuc xoa thong tin cua bang cham cong " + thang + "/" + nam + " ( Y | N ): ");
                            choice2 = CHECK.yesNoChoice();
                        }
                        System.out.print("Ban co muon tiep tuc xoa thong tin ( Y | N ): ");
                        choice1 = CHECK.yesNoChoice();
                    } else {
                        System.out.print("Thang khong ton tai.");
                        System.out.print("Ban co muon tiep tuc xoa thong tin ( Y | N ): ");
                        choice1 = CHECK.yesNoChoice();
                    }
                }
                break;
            }
            case 2: {
                System.out.print("Nhap nam cua bang cham cong can xoa: ");
                int nam = (int) CHECK.kiemTraSoNguyenDuong();
                System.out.print("Nhap thang cua bang cham cong can xoa: ");
                int thang = (int) CHECK.kiemTraSoNguyenDuong();
                if (thang > 0 && thang < 13) {
                    deleteBangChamCongTheoThang(thang, nam);
                } else {
                    System.out.println("Thang khong ton tai.");
                }
                break;
            }
            default: {
                System.out.println("Nhap sai lua chon.");
                break;
            }
        }
    }

    public void edit() {

    }

    public CHAMCONG[] sortByDate(CHAMCONG[] list) {
        if (isEmpty(list)) {
            return null;
        } else {
            int min;
            for (int i = 0; i < list.length - 1; ++i) {
                min = i;
                for (int j = i + 1; j < list.length; ++j) {
                    if (check.compareDate(list[j].getThang(), list[j].getNam(), list[min].getThang(), list[min].getNam()) == -1) {
                        min = j;
                    }
                }
                if (min != i) {
                    CHAMCONG temp = list[i];
                    list[i] = list[min];
                    list[min] = temp;
                }
            }
            return list;
        }

    }

    public CHAMCONG[] sort(CHAMCONG[] list) {
        if (isEmpty(list)) {
            return null;
        } else {
            int min;
            for (int i = 0; i < list.length - 1; ++i) {
                min = i;
                for (int j = i + 1; j < list.length; ++j) {
                    if (nhanvienManager.getNumberOfMaNV(list[j].getMaNV()) < nhanvienManager.getNumberOfMaNV(list[min].getMaNV())) {
                        min = j;
                    }
                }
                if (min != i) {
                    CHAMCONG temp = list[i];
                    list[i] = list[min];
                    list[min] = temp;
                }
            }
            return list;
        }
    }

    public CHAMCONG[] sortByMaNV() {
        if (isEmpty(ccList)) {
            return null;
        } else {
            CHAMCONG[] arrC = null;
            for (int i = 0; i < ccList.length; ++i) {
                if (nhanvienManager.getFirstLetterOfMaNV(ccList[i].getMaNV()).equals("C")) {
                    arrC = add(arrC, ccList[i]);
                }
            }
            arrC = sort(arrC);
            CHAMCONG[] arrP = null;
            for (int i = 0; i < ccList.length; ++i) {
                if (nhanvienManager.getFirstLetterOfMaNV(ccList[i].getMaNV()).equals("P")) {
                    arrP = add(arrP, ccList[i]);
                }
            }
            arrP = sort(arrP);
            CHAMCONG[] arrT = null;
            for (int i = 0; i < ccList.length; ++i) {
                if (nhanvienManager.getFirstLetterOfMaNV(ccList[i].getMaNV()).equals("T")) {
                    arrT = add(arrT, ccList[i]);
                }
            }
            arrT = sort(arrT);

            arrC = add(arrC, arrP);
            arrC = add(arrC, arrT);
            return arrC;
        }
    }

    public void printList(NHANVIEN[] nvList, int thang, int nam) {
        if (isEmpty(ccList)) {
            System.out.println("Khong ton tai bang cham cong " + thang + "/" + nam);
        } else {
            if (isExistInList(thang, nam)) {
                ccList = sortByMaNV();
                System.out.println("\n============== BANG CHAM CONG " + thang + "/" + nam + " ==============");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("| %-12s | %-30s | %-20s | %-15s | %-17s | %-18s | %-17s |\n", "Ma nhan vien",
                        "Ho ten nhan vien", "Chuc vu", "So ngay du cong", "So ngay nua cong", "So ngay khong cong", "Tong so ngay cong");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");
                for (int i = 0; i < ccList.length; ++i) {
                    if (ccList[i].getThang() == thang && ccList[i].getNam() == nam) {
                        System.out.printf("| %-12s | %-30s | %-20s | %15s | %17s | %18s | %17s |\n",
                                ccList[i].getMaNV(), nhanvienManager.getNhanVien(nvList, ccList[i].getMaNV()).getHoTen(),
                                nhanvienManager.getNhanVien(nvList, ccList[i].getMaNV()).getChucVu(), ccList[i].getDuNgayCong(),
                                ccList[i].getNuaNgayCong(), ccList[i].getKhongCong(), ccList[i].tongNgayCong());
                    }
                }
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");
            } else {
                System.out.println("Khong ton tai bang cham cong " + thang + "/" + nam);
            }
        }
    }

    public void printPersonal(NHANVIEN[] nvList) {
        if (isEmpty(ccList)) {
            System.out.println("Khong ton tai bang cham cong nao ca.");
        } else {
            System.out.print("Moi nhap ma nhan vien: ");
            String maNV = check.kiemTraMaNhanVien();
            if (nhanvienManager.isInList(nvList, maNV) != -1) {
                CHAMCONG[] list = null;
                list = add(list, ccList);
                list = sortByDate(list);
                int count = 0;
                for (int i = 0; i < list.length; ++i) {
                    if (list[i].getMaNV().equals(maNV)) {
                        ++count;
                        if (count == 1) {
                            System.out.println("\n| Ma nhan vien: " + list[i].getMaNV() + " | Ho va ten: "
                                    + nvList[nhanvienManager.isInList(nvList, maNV)].hoTen + " | Chuc vu: "
                                    + nvList[nhanvienManager.isInList(nvList, maNV)].getChucVu() + " |");
                            System.out.println("--------------------------------------------------------------------------------------------");
                            System.out.printf("| %-9s | %-15s | %-17s | %-18s | %-17s |\n", "Thang/Nam", "So ngay du cong", "So ngay nua cong",
                                    "So ngay khong cong", "Tong so ngay cong");
                            System.out.println("--------------------------------------------------------------------------------------------");
                        }
                        System.out.printf("| %2d/%-6d | %15s | %17s | %18s | %17s |\n", list[i].getThang(), list[i].getNam(),
                                list[i].getDuNgayCong(), list[i].getNuaNgayCong(), list[i].getKhongCong(), list[i].tongNgayCong());
                    }
                }
                if (count != 0) {
                    System.out.println("--------------------------------------------------------------------------------------------");
                } else {
                    System.out.println("Khong co nhan vien trong bang cham cong");
                }
            } else {
                System.out.println("Ma nhan vien khong ton tai.");
            }
        }
    }
}
