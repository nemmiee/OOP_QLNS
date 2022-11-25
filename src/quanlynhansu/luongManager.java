/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlynhansu;

public class luongManager {

    private LUONG[] luongList = null;
    private FileLuong fl;

    CHECK check = new CHECK();

    public luongManager() {
        fl = new FileLuong();
        luongList = fl.read();
    }

    public LUONG[] getLuongList() {
        return luongList;
    }

    public void setLuongList(LUONG[] luongList) {
        this.luongList = luongList;
    }

    public LUONG[] add(LUONG[] list, LUONG luong) {
        if (isEmpty(list)) {
            LUONG[] newList = new LUONG[1];
            newList[0] = luong;
            return newList;
        } else {
            LUONG[] newList = new LUONG[list.length + 1];
            for (int i = 0; i < list.length; ++i) {
                newList[i] = list[i];
            }
            newList[list.length] = luong;
            return newList;
        }
    }

    public LUONG[] add(LUONG[] head, LUONG[] tail) {
        if (isEmpty(head) && isEmpty(tail)) {
            return null;
        } else if (isEmpty(head) && !isEmpty(tail)) {
            return tail;
        } else if (!isEmpty(head) && isEmpty(tail)) {
            return head;
        } else {
            LUONG[] list = new LUONG[head.length + tail.length];
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

    public LUONG[] remove(LUONG[] list, int index) {
        if (index >= 0 && index < list.length) {
            for (int i = index; i < list.length - 1; ++i) {
                list[i] = list[i + 1];
            }
            LUONG[] newList = new LUONG[list.length - 1];
            for (int i = 0; i < newList.length; ++i) {
                newList[i] = list[i];
            }
            return newList;
        } else {
            return list;
        }
    }

    public boolean isEmpty(LUONG[] list) {
        if (list == null) {
            return true;
        }
        return (list.length == 0);
    }

    public boolean isExistInList(int thang, int nam) {
        if (isEmpty(luongList)) {
            return false;
        }
        for (int i = 0; i < luongList.length; ++i) {
            if (luongList[i].getThang() == thang && luongList[i].getNam() == nam) {
                return true;
            }
        }
        return false;
    }

    public void add(NHANVIEN[] nvList, CHAMCONG[] ccList, int thang, int nam) {
        if (nhanvienManager.isEmpty(nvList) && !chamcongManager.isEmpty(ccList)) {
            System.out.println("Danh sach nhan vien rong.");
        } else if (!nhanvienManager.isEmpty(nvList) && chamcongManager.isEmpty(ccList)) {
            System.out.println("Danh sach cham cong rong.");
        } else if ((nhanvienManager.isEmpty(nvList)) && (chamcongManager.isEmpty(ccList))) {
            System.out.println("Danh sach nhan vien va danh sach cham cong rong.");
        } else {
            checkFirst(nvList);
            System.out.print("Moi nhap ma nhan vien: ");
            String maNV = check.kiemTraMaNhanVien();
            boolean isExistNV = false;
            boolean isNotExistInLuongList = true;
            // Kiểm tra có tồn tại mã nhân viên trong file nhân viên và trong file chứa tất cả các bảng chấm công hay không
            if (nhanvienManager.isInList(nvList, maNV) != -1 && chamcongManager.isInList(ccList, maNV) != -1) {
                isExistNV = true;
                // Kiểm tra file lương có rỗng hay không
                if (isEmpty(luongList)) {
                    int pos = -1;
                    // Kiểm tra có tồn tại nhân viên trong bảng chấm công tại tháng và năm truyền vào không
                    for (int i = 0; i < ccList.length; ++i) {
                        if (ccList[i].getMaNV().equals(maNV) && ccList[i].getThang() == thang && ccList[i].getNam() == nam) {
                            pos = i;
                            break;
                        }
                    }
                    if (pos != -1) {
                        LUONG luong = new LUONG();
                        luong.nhap(maNV, thang, nam, ccList[pos].tongNgayCong());
                        this.luongList = add(luongList, luong);
                        fl.write(sortByMaNV());
                    } else {
                        System.out.println("Khong co nhan vien trong bang cham cong " + thang + "/" + nam);
                    }
                } else { // Trường hợp file lương không rỗng
                    // Kiểm tra có tồn tại nhân viên trong bảng chấm công tại tháng và năm truyền vào không
                    int pos = -1;
                    for (int i = 0; i < ccList.length; ++i) {
                        if (ccList[i].getMaNV().equals(maNV) && ccList[i].getThang() == thang && ccList[i].getNam() == nam) {
                            pos = i;
                            break;
                        }
                    }
                    // Kiểm tra có tồn tại nhân viên trong bảng lương tại thời tháng và năm truyền vào không
                    for (int i = 0; i < luongList.length; ++i) {
                        if (luongList[i].getMaNV().equals(maNV) && luongList[i].getThang() == thang && luongList[i].getNam() == nam) {
                            isNotExistInLuongList = false;
                            break;
                        }
                    }
                    if (isNotExistInLuongList && pos != -1) {
                        LUONG luong = new LUONG();
                        luong.nhap(maNV, thang, nam, ccList[pos].tongNgayCong());
                        this.luongList = add(luongList, luong);
                        fl.write(sortByMaNV());
                    } else if (pos == -1) {
                        System.out.println("Khong co nhan vien trong bang cham cong " + thang + "/" + nam);
                    } else {
                        System.out.println("Da ton tai nhan vien trong bang luong.");
                    }
                }
            }
            if (isExistNV == false) {
                System.out.println("Ma nhan vien khong ton tai.");
            }
        }
    }

    public void add(NHANVIEN[] nvList, CHAMCONG[] ccList) {
        checkFirst(nvList);
        String choice1 = "Y", choice2 = "Y";
        while (choice1.equals("Y")) {
            System.out.print("Moi nhap nam: ");
            int nam = (int) CHECK.kiemTraSoNguyenDuong();
            System.out.print("Moi nhap thang: ");
            int thang = (int) CHECK.kiemTraSoNguyenDuong();
            if (thang > 0 && thang < 13) {
                choice2 = "Y";
                while (choice2.equals("Y")) {
                    add(nvList, ccList, thang, nam);
                    fl.write(sortByMaNV());
                    System.out.print("Ban co muon tiep tuc nhap thong tin vao bang luong " + thang + "/" + nam + " ( Y | N ): ");
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
        System.out.print("Nhap ma nhan vien can xoa khoi bang luong: ");
        String maNV = check.kiemTraMaNhanVien();
        boolean isExist = false;
        for (int i = 0; i < luongList.length; ++i) {
            if (luongList[i].getMaNV().equals(maNV) && luongList[i].getThang() == thang && luongList[i].getNam() == nam) {
                isExist = true;
                luongList = remove(luongList, i);
                break;
            }
        }
        if (!isExist) {
            System.out.println("Ma nhan vien " + maNV + " khong ton tai.");
        } else {
            fl.write(sortByMaNV());
        }
    }

    public void deleteBangLuongTheoThang(int thang, int nam) {
        boolean isExist = false;
        for (int i = 0; i < luongList.length; ++i) {
            if (luongList[i].getThang() == thang && luongList[i].getNam() == nam) {
                isExist = true;
                luongList = remove(luongList, i);
            }
        }
        if (!isExist) {
            System.out.println("Khong co bang luong " + thang + "/" + nam + " trong danh sach.");
        } else {
            fl.write(sortByMaNV());
        }
    }

    public void delete(NHANVIEN[] nvList) {
        if (isEmpty(luongList)) {
            System.out.println("Khong ton tai bang cham luong nao.");
        } else {
            checkFirst(nvList);
            System.out.println("Nhap 1 de xoa luong tung ca nhan.");
            System.out.println("Nhap 2 de xoa 1 bang luong.");
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
                                System.out.print("Ban co muon tiep tuc xoa thong tin cua bang luong " + thang + "/" + nam + " ( Y | N ): ");
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
                    System.out.print("Nhap nam cua bang luong can xoa: ");
                    int nam = (int) CHECK.kiemTraSoNguyenDuong();
                    System.out.print("Nhap thang cua bang luong can xoa: ");
                    int thang = (int) CHECK.kiemTraSoNguyenDuong();
                    if (thang > 0 && thang < 13) {
                        deleteBangLuongTheoThang(thang, nam);
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
    }

    public LUONG[] sortByDate(LUONG[] list) {
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
                    LUONG temp = list[i];
                    list[i] = list[min];
                    list[min] = temp;
                }
            }
            return list;
        }
    }

    public LUONG[] sort(LUONG[] list) {
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
                    LUONG temp = list[i];
                    list[i] = list[min];
                    list[min] = temp;
                }
            }
            return list;
        }
    }

    public LUONG[] sortByMaNV() {
        if (isEmpty(luongList)) {
            return null;
        } else {
            LUONG[] arrC = null;
            for (int i = 0; i < luongList.length; ++i) {
                if (nhanvienManager.getFirstLetterOfMaNV(luongList[i].getMaNV()).equals("C")) {
                    arrC = add(arrC, luongList[i]);
                }
            }
            arrC = sort(arrC);
            LUONG[] arrP = null;
            for (int i = 0; i < luongList.length; ++i) {
                if (nhanvienManager.getFirstLetterOfMaNV(luongList[i].getMaNV()).equals("P")) {
                    arrP = add(arrP, luongList[i]);
                }
            }
            arrP = sort(arrP);
            LUONG[] arrT = null;
            for (int i = 0; i < luongList.length; ++i) {
                if (nhanvienManager.getFirstLetterOfMaNV(luongList[i].getMaNV()).equals("T")) {
                    arrT = add(arrT, luongList[i]);
                }
            }
            arrT = sort(arrT);

            arrC = add(arrC, arrP);
            arrC = add(arrC, arrT);
            return arrC;
        }
    }

    public void printList(NHANVIEN[] nvList, CHAMCONG[] ccList, int thang, int nam) {
        if (isEmpty(luongList)) {
            System.out.println("Khong ton tai bang luong " + thang + "/" + nam);
        } else {
            checkFirst(nvList);
            luongList = checkFirst(ccList);
            fl.write(sortByMaNV());
            if (isExistInList(thang, nam) == true) {
                luongList = sortByMaNV();
                System.out.println("\n============== BANG LUONG " + thang + "/" + nam + " ==============");
                System.out.println("+-------------------------------------------------------------------------"
                        + "---------------------------------------------------------------------------+");
                System.out.printf("| %-12s | %-30s | %-20s | %-12s | %-10s | %-17s | %-26s |\n", "Ma nhan vien",
                        "Ho ten nhan vien", "Chuc vu", "Luong co ban", "He so luong", "Tong so ngay cong", "Luong thang (Don vi: dong)");
                System.out.println("+------------------------------------------------------------------------"
                        + "----------------------------------------------------------------------------+");
                for (int i = 0; i < luongList.length; ++i) {
                    if (luongList[i].getThang() == thang && luongList[i].getNam() == nam) {
                        System.out.printf("| %-12s | %-30s | %-20s | %12s | %11s | %17s | %26s |\n",
                                luongList[i].getMaNV(), nhanvienManager.getNhanVien(nvList, luongList[i].getMaNV()).getHoTen(),
                                nhanvienManager.getNhanVien(nvList, luongList[i].getMaNV()).getChucVu(), luongList[i].getLuongCoBan(),
                                luongList[i].getHeSoLuong(), chamcongManager.getChamCong(ccList, luongList[i].getMaNV(), thang, nam).tongNgayCong(),
                                luongList[i].getLuong());
                    }
                }
                System.out.println("+----------------------------------------------------------------------"
                        + "------------------------------------------------------------------------------+");
            } else {
                System.out.println("Khong ton tai bang luong " + thang + "/" + nam);
            }
        }
    }

    public void printPersonal(NHANVIEN[] nvList, CHAMCONG[] ccList) {
        if (isEmpty(luongList)) {
            System.out.println("Khong ton tai bang cham luong nao.");
        } else {
            checkFirst(nvList);
            // Kiểm tra lại bảng lương và bảng chấm công có khớp dữ liệu với nhau không
            // Ví dụ khi ta xóa dữ liệu bên bảng chấm công thì bảng lương cũng sẽ tự xóa dữ liệu
            luongList = checkFirst(ccList);
            fl.write(sortByMaNV());
            System.out.print("Moi nhap ma nhan vien: ");
            String maNV = check.kiemTraMaNhanVien();
            if (nhanvienManager.isInList(nvList, maNV) != -1 && chamcongManager.isInList(ccList, maNV) != -1) {
                LUONG[] list = null;
                list = add(list, luongList);
                list = sortByDate(list);
                int count = 0;
                for (int i = 0; i < list.length; ++i) {
                    if (list[i].getMaNV().equals(maNV)) {
                        ++count;
                        if (count == 1) {
                            System.out.println("\n| Ma nhan vien: " + list[i].getMaNV() + " | Ho va ten: "
                                    + nvList[nhanvienManager.isInList(nvList, maNV)].hoTen + " | Chuc vu: "
                                    + nvList[nhanvienManager.isInList(nvList, maNV)].getChucVu() + " |");
                            System.out.println("+-----------------------------------------------------------------------------------------+");
                            System.out.printf("| %-9s | %-12s | %-10s | %-17s | %-26s |\n", "Thang/Nam", "Luong co ban", "He so luong",
                                    "Tong so ngay cong", "Luong thang (Don vi: dong)");
                            System.out.println("+-----------------------------------------------------------------------------------------+");
                        }
                        System.out.printf("| %2d/%-6d | %12s | %10s | %17s  | %26s |\n", list[i].getThang(), list[i].getNam(),
                                list[i].getLuongCoBan(), list[i].getHeSoLuong(),
                                chamcongManager.getChamCong(ccList, list[i].getMaNV(), list[i].getThang(), list[i].getNam()).tongNgayCong(), list[i].getLuong());
                    }
                }
                if (count != 0) {
                    System.out.println("+-----------------------------------------------------------------------------------------+");
                } else {
                    System.out.println("Khong co nhan vien trong bang luong");
                }
            } else {
                System.out.println("Ma nhan vien khong ton tai.");
            }
        }
    }
    
    public LUONG[] checkFirst(CHAMCONG[] ccList) {
        for (int i = 0; i < luongList.length; ++i) {
            if (chamcongManager.getChamCong(ccList, luongList[i].getMaNV(), luongList[i].getThang(), luongList[i].getNam()) == null) {
                luongList = remove(luongList, i);
            }
        }
        return luongList;
    }
    
    public void checkFirst(NHANVIEN[] nvList) {
        boolean flag = false;
        for (int i = 0; i < luongList.length; i++) {
            if (nhanvienManager.isInList(nvList, luongList[i].getMaNV()) == -1) {
                flag = true;
                luongList = remove(luongList, i);
                i--;
            }
        }
        if (flag) {
            fl.write(sortByMaNV());
        }
    }
}
