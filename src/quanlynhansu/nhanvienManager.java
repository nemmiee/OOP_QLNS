/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlynhansu;

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

    public NHANVIEN[] getNhanVienList() {
        return nvList;
    }

    /**
     *
     * @param list
     * @param nv
     * @return Tra ve mang moi sau khi them 1 doi tuong nhan vien
     */
    public static NHANVIEN[] add(NHANVIEN[] list, NHANVIEN nv) {
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

    public static NHANVIEN[] add(NHANVIEN[] head, NHANVIEN[] tail) {
        if (isEmpty(head) && isEmpty(tail)) {
            return null;
        } else if (isEmpty(head) && !isEmpty(tail)) {
            return tail;
        } else if (!isEmpty(head) && isEmpty(tail)) {
            return head;
        } else {
            NHANVIEN[] list = new NHANVIEN[head.length + tail.length];
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

    /**
     *
     * @param list
     * @param index
     * @return Tra ve mang moi sau khi xoa nhan vien tai vi tri index
     */
    public static NHANVIEN[] remove(NHANVIEN[] list, int index) {
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

    /**
     *
     * @param list
     * @return Kiem tra mang truyen vao co rong hay khong
     */
    public static boolean isEmpty(NHANVIEN[] list) {
        if (list == null) {
            return true;
        }
        return (list.length == 0);
    }

    /**
     *
     * @param list
     * @param maNV
     * @return Tra ve vi tri cua doi tuong co chung maNV trong danh sach neu
     * khong co doi tuong se tra ve -1
     */
    public static int isInList(NHANVIEN[] list, String maNV) {
        if (isEmpty(list)) {
            return -1;
        }
        for (int i = 0; i < list.length; ++i) {
            if (list[i].maNhanVien.equals(maNV)) {
                return i;
            }
        }
        return -1;
    }

    public void add(PHONGBAN[] pbList) {
        if (phongbanManager.isEmpty(pbList)) {
            System.out.println("Khong co phong ban nao.");
        } else {
            String choice = "Y";
            int input;
            while (choice.equals("Y")) {
                Main.loaiNhanVien();
                System.out.print("Moi nhap lua chon: ");
                input = (int) CHECK.kiemTraSoNguyenDuong();
                switch (input) {
                    case 1: {
                        System.out.print("Moi nhap ma nhan vien chinh: ");
                        String maNV = check.kiemTraMaNVChinh();
                        if (isEmpty(nvList)) {
                            NHANVIEN nv = new NHANVIENCHINH();
                            nv.nhap(maNV);
                            String maPhong;
                            while (true) {
                                phongbanManager.printMaAndTen(pbList);
                                System.out.print("\nMoi nhap ma phong: ");
                                maPhong = check.kiemTraMaPhongBan();
                                if (phongbanManager.isInList(pbList, maPhong) != -1) {
                                    ((NHANVIENCHINH) nv).setMaPhong(maPhong);
                                    break;
                                } else {
                                    System.out.println("Khong ton tai ma phong.");
                                }
                            }
                            nvList = add(nvList, nv);
                            fnv.write(nvList);
                        } else {
                            if (isInList(nvList, maNV) == -1) {
                                NHANVIEN nv = new NHANVIENCHINH();
                                nv.nhap(maNV);
                                String maPhong;
                                while (true) {
                                    phongbanManager.printMaAndTen(pbList);
                                    System.out.print("\nMoi nhap ma phong: ");
                                    maPhong = check.kiemTraMaPhongBan();
                                    if (phongbanManager.isInList(pbList, maPhong) != -1) {
                                        ((NHANVIENCHINH) nv).setMaPhong(maPhong);
                                        break;
                                    } else {
                                        System.out.println("Khong ton tai ma phong.");
                                    }
                                }
                                nvList = add(nvList, nv);
                                fnv.write(sortByMaNV(this.nvList));
                            } else {
                                System.out.println("Da ton tai ma nhan vien.");
                            }
                        }
                        break;
                    }
                    case 2: {
                        System.out.print("Moi nhap ma nhan vien phu: ");
                        String maNV = check.kiemTraMaNVPhu();
                        if (isEmpty(nvList)) {
                            NHANVIEN nv = new NHANVIENPHU();
                            nv.nhap(maNV);
                            nvList = add(nvList, nv);
                            fnv.write(nvList);
                        } else {
                            if (isInList(nvList, maNV) == -1) {
                                NHANVIEN nv = new NHANVIENPHU();
                                nv.nhap(maNV);
                                nvList = add(nvList, nv);
                                fnv.write(sortByMaNV(this.nvList));
                            } else {
                                System.out.println("Da ton tai ma nhan vien.");
                            }
                        }
                        break;
                    }
                    case 3: {
                        System.out.print("Moi nhap ma nhan vien cua thuc tap sinh: ");
                        String maNV = check.kiemTraMaThucTapSinh();
                        if (isEmpty(nvList)) {
                            NHANVIEN nv = new THUCTAPSINH();
                            nv.nhap(maNV);
                            String maPhong;
                            while (true) {
                                phongbanManager.printMaAndTen(pbList);
                                System.out.print("\nMoi nhap ma phong: ");
                                maPhong = check.kiemTraMaPhongBan();
                                if (phongbanManager.isInList(pbList, maPhong) != -1) {
                                    ((THUCTAPSINH) nv).setMaPhong(maPhong);
                                    break;
                                } else {
                                    System.out.println("Khong ton tai ma phong.");
                                }
                            }
                            nvList = add(nvList, nv);
                            fnv.write(nvList);
                        } else {
                            if (isInList(nvList, maNV) == -1) {
                                NHANVIEN nv = new THUCTAPSINH();
                                nv.nhap(maNV);
                                String maPhong;
                                while (true) {
                                    phongbanManager.printMaAndTen(pbList);
                                    System.out.print("\nMoi nhap ma phong: ");
                                    maPhong = check.kiemTraMaPhongBan();
                                    if (phongbanManager.isInList(pbList, maPhong) != -1) {
                                        ((THUCTAPSINH) nv).setMaPhong(maPhong);
                                        break;
                                    } else {
                                        System.out.println("Khong ton tai ma phong.");
                                    }
                                }
                                nvList = add(nvList, nv);
                                fnv.write(sortByMaNV(this.nvList));
                                break;
                            } else {
                                System.out.println("Da ton tai ma nhan vien.");
                            }
                        }
                        break;
                    }
                    default: {
                        System.out.println("Nhap sai lua chon.");
                        break;
                    }
                }
                System.out.print("Ban co muon tiep tuc nhap thong tin ( Y | N ): ");
                choice = CHECK.yesNoChoice();
            }
        }
    }

    public void edit(PHONGBAN[] pbList) {
        checkFirst(pbList);
        System.out.print("Moi nhap ma nhan vien cua nhan vien can sua: ");
        String maNV = check.kiemTraMaNhanVien();
        if (isInList(nvList, maNV) != -1) {
            boolean flag = true;
            int choice;
            while (flag) {
                // In thong tin hien tai
                System.out.println("\n============== THONG TIN HIEN TAI ==============\n"
                        + "+------------------------------------------------------------------------------"
                        + "----------------------------------------------------------------------------------------"
                        + "--------------------------------------------------------------------------------------+");
                System.out.printf("| %-12s | %-30s | %-9s | %-10s | %-13s | %-40s | %-20s| %-35s | %-9s | %-21s | %-21s |\n",
                        "Ma nhan vien", "Ho va ten", "Gioi tinh", "Ngay sinh", "So dien thoai", "Dia chi",
                        "Chuc vu", "Email", "Phong ban", "Ngay bat dau hop dong", "Ngay ket thuc hop dong");
                System.out.println("+------------------------------------------------------------------------------"
                        + "----------------------------------------------------------------------------------------"
                        + "--------------------------------------------------------------------------------------+");
                    if (nvList[isInList(nvList, maNV)] instanceof NHANVIENCHINH nhanvienchinh) {
                        System.out.printf("| %-12s | %-30s | %-9s | %-10s | %-13s | %-40s | %-20s| %-35s | %-9s | %-21s | %-21s  |\n",
                                nvList[isInList(nvList, maNV)].maNhanVien, nvList[isInList(nvList, maNV)].hoTen, nvList[isInList(nvList, maNV)].gioiTinh, nvList[isInList(nvList, maNV)].ngaySinh,
                                nvList[isInList(nvList, maNV)].soDienThoai, nvList[isInList(nvList, maNV)].diaChi, nvList[isInList(nvList, maNV)].chucVu,
                                nhanvienchinh.getEmail(), nhanvienchinh.getMaPhong(),
                                nvList[isInList(nvList, maNV)].getHopDong().getNgayBatDauHopDong().toString(),
                                nvList[isInList(nvList, maNV)].getHopDong().getNgayKetThucHopDong().toString());
                    } else if (nvList[isInList(nvList, maNV)] instanceof THUCTAPSINH thuctapsinh) {
                        System.out.printf("| %-12s | %-30s | %-9s | %-10s | %-13s | %-40s | %-20s| %-35s | %-21s | %-21s  |\n",
                                nvList[isInList(nvList, maNV)].maNhanVien, nvList[isInList(nvList, maNV)].hoTen, nvList[isInList(nvList, maNV)].gioiTinh, nvList[isInList(nvList, maNV)].ngaySinh,
                                nvList[isInList(nvList, maNV)].soDienThoai, nvList[isInList(nvList, maNV)].diaChi, nvList[isInList(nvList, maNV)].chucVu,
                                thuctapsinh.getEmail(), thuctapsinh.getMaPhong(),
                                nvList[isInList(nvList, maNV)].getHopDong().getNgayBatDauHopDong().toString(),
                                nvList[isInList(nvList, maNV)].getHopDong().getNgayKetThucHopDong().toString());
                    } else {
                        System.out.printf("| %-12s | %-30s | %-9s | %-10s | %-13s | %-40s | %-20s| %-35s | %-21s | %-21s  |\n",
                                nvList[isInList(nvList, maNV)].maNhanVien, nvList[isInList(nvList, maNV)].hoTen, nvList[isInList(nvList, maNV)].gioiTinh, nvList[isInList(nvList, maNV)].ngaySinh,
                                nvList[isInList(nvList, maNV)].soDienThoai, nvList[isInList(nvList, maNV)].diaChi, nvList[isInList(nvList, maNV)].chucVu,
                                ((NHANVIENPHU) nvList[isInList(nvList, maNV)]).getEmail(), ((NHANVIENPHU) nvList[isInList(nvList, maNV)]).getMaPhong(),
                                nvList[isInList(nvList, maNV)].getHopDong().getNgayBatDauHopDong().toString(),
                                nvList[isInList(nvList, maNV)].getHopDong().getNgayKetThucHopDong().toString());
                    }
                System.out.println("+------------------------------------------------------------------------------"
                        + "----------------------------------------------------------------------------------------"
                        + "--------------------------------------------------------------------------------------+");
                // Ket thuc in thong tin hien tai
                Main.editNhanVienMenu();
                System.out.print("Moi nhap lua chon: ");
                choice = (int) CHECK.kiemTraSoNguyenDuong();
                switch (choice) {
                    case 0: {
                        System.out.println("Ban da thoat sua thong tin nhan vien!\n");
                        flag = false;
                        break;
                    }
                    case 1: {
                        System.out.print("Moi nhap ho va ten moi nhan vien: ");
                        String hoTen = check.kiemTraHoTen();
                        nvList[isInList(nvList, maNV)].setHoTen(hoTen);
                        System.out.println("Da doi thanh cong.");
                        break;
                    }
                    case 2: {
                        if (nvList[isInList(nvList, maNV)].getGioiTinh().equals("Nam")) {
                            nvList[isInList(nvList, maNV)].setGioiTinh("Nu");
                            System.out.println("Da thay doi gioi tinh thanh nu");
                        } else if (nvList[isInList(nvList, maNV)].getGioiTinh().equals("Nu")) {
                            nvList[isInList(nvList, maNV)].setGioiTinh("Nam");
                            System.out.println("Da thay doi gioi tinh thanh nam");
                        }
                        break;
                    }
                    case 3: {
                        System.out.println("Moi nhap ngay sinh moi: ");
                        NGAY ngaySinh = new NGAY();
                        ngaySinh.nhap();
                        nvList[isInList(nvList, maNV)].setNgaySinh(ngaySinh);
                        System.out.println("Da doi thanh cong.");
                        break;
                    }
                    case 4: {
                        System.out.print("Moi nhap so dien thoai moi: ");
                        String soDienThoai = check.kiemTraSoDienThoai();
                        nvList[isInList(nvList, maNV)].setSoDienThoai(soDienThoai);
                        System.out.println("Da doi thanh cong.");
                        break;
                    }
                    case 5: {
                        System.out.println("Moi nhap dia chi moi: ");
                        DIACHI diaChi = new DIACHI();
                        diaChi.nhapDiaChi();
                        nvList[isInList(nvList, maNV)].setDiaChi(diaChi);
                        System.out.println("Da doi thanh cong.");
                        break;
                    }
                    case 6: {
                        System.out.print("Moi nhap chuc vu moi: ");
                        nvList[isInList(nvList, maNV)].setChucVu(check.kiemTraChuoiKyTu());
                        System.out.println("Da doi thanh cong.");
                        break;
                    }
                    case 7: {
                        if (nvList[isInList(nvList, maNV)] instanceof NHANVIENCHINH nvChinh) {
                            System.out.print("Moi nhap email moi: ");
                            String email = check.kiemTraEmail();
                            nvChinh.setEmail(email);
                            System.out.println("Da doi thanh cong.");
                        } else if (nvList[isInList(nvList, maNV)] instanceof THUCTAPSINH ttSinh) {
                            System.out.print("Moi nhap email moi: ");
                            String email = check.kiemTraEmail();
                            ttSinh.setEmail(email);
                            System.out.println("Da doi thanh cong.");
                        } else {
                            System.out.println("Khong the doi email vi nhan vien phu " + nvList[isInList(nvList, maNV)].getMaNhanVien()
                                    + " khong co email.");
                        }
                        break;
                    }
                    case 8: {
                        String maPhong;
                        while (true) {
                            phongbanManager.printMaAndTen(pbList);
                            System.out.print("\nMoi nhap ma phong moi: ");
                            maPhong = check.kiemTraMaPhongBan();
                            if (phongbanManager.isInList(pbList, maPhong) != -1) {
                                if (nvList[isInList(nvList, maNV)] instanceof NHANVIENCHINH nvc) {
                                    nvc.setMaPhong(maPhong);
                                    System.out.println("Da doi thanh cong.");
                                } else if (nvList[isInList(nvList, maNV)] instanceof THUCTAPSINH tts) {
                                    tts.setMaPhong(maPhong);
                                    System.out.println("Da doi thanh cong.");
                                } else {
                                    System.out.println("Khong the doi ma phong cua nhan vien phu.");
                                }
                                break;
                            } else {
                                System.out.println("Khong ton tai ma phong.");
                            }
                        }
                        break;
                    }
                    default: {
                        System.out.println("Ban da nhap sai lua chon! Hay nhap dung");
                        break;
                    }
                }
            }
            fnv.write(sortByMaNV(this.nvList));
        } else {
            System.out.println("  Ma nhan vien \"" + maNV + "\" khong ton tai!!!");
        }
    }

    public void delete() {
        System.out.print("Nhap ma nhan vien cua nhan vien can xoa: ");
        String maNV = check.kiemTraMaNhanVien();
        boolean isExist = false;
        for (int i = 0; i < nvList.length; ++i) {
            if (nvList[i].getMaNhanVien().equals(maNV)) {
                isExist = true;
                this.nvList = remove(nvList, i);
                System.out.println("Da xoa nhan vien.");
                break;
            }
        }
        if (!isExist) {
            System.out.println("Ma nhan vien \"" + maNV + "\" khong ton tai!!!");
        } else {
            fnv.write(sortByMaNV(this.nvList));
        }
    }

    public void deleteNVFromPhongBan(PHONGBAN[] pbList) {
        System.out.print("Moi nhap ma phong: ");
        String maPhong = check.kiemTraMaPhongBan();
        if (phongbanManager.isInList(pbList, maPhong) != -1) {
            System.out.print("Moi nhap ma nhan vien can xoa khoi phong ban: ");
            String maNV = check.kiemTraMaNhanVien();
            if (isInList(nvList, maNV) != -1) {
                if (nvList[isInList(nvList, maNV)] instanceof NHANVIENCHINH nvc && nvc.getMaPhong().equals(maPhong)) {
                    nvc.setMaPhong("None");
                    System.out.println("Da xoa nhan vien khoi phong ban.");
                } else if (nvList[isInList(nvList, maNV)] instanceof THUCTAPSINH tts && tts.getMaPhong().equals(maPhong)) {
                    tts.setMaPhong("None");
                    System.out.println("Da xoa nhan vien khoi phong ban.");
                } else {
                    System.out.println("Khong co nhan vien nay trong phong ban.");
                }
            } else {
                System.out.println("Khong ton tai nhan vien trong danh sach.");
            }
        } else {
            System.out.println("Khong ton tai phong ban.");
        }
    }

    public static String getFirstLetterOfMaNV(String maNV) {
        return maNV.substring(0, 1);
    }

    public static int getNumberOfMaNV(String maNV) {
        return Integer.parseInt(maNV.substring(1));
    }

    public static NHANVIEN[] sort(NHANVIEN[] array) {
        if (isEmpty(array)) {
            return null;
        } else {
            int min;
            for (int i = 0; i < array.length - 1; ++i) {
                min = i;
                for (int j = i + 1; j < array.length; ++j) {
                    if (getNumberOfMaNV(array[min].getMaNhanVien()) > getNumberOfMaNV(array[j].getMaNhanVien())) {
                        min = j;
                    }
                }
                if (min != i) {
                    NHANVIEN temp = array[i];
                    array[i] = array[min];
                    array[min] = temp;
                }
            }
            return array;
        }
    }

    public static NHANVIEN[] sortByMaNV(NHANVIEN[] list) {
        if (isEmpty(list)) {
            return null;
        } else {
            NHANVIEN[] arrC = null;
            for (int i = 0; i < list.length; ++i) {
                if (nhanvienManager.getFirstLetterOfMaNV(list[i].getMaNhanVien()).equals("C")) {
                    arrC = add(arrC, list[i]);
                }
            }
            arrC = sort(arrC);
            NHANVIEN[] arrP = null;
            for (int i = 0; i < list.length; ++i) {
                if (nhanvienManager.getFirstLetterOfMaNV(list[i].getMaNhanVien()).equals("P")) {
                    arrP = add(arrP, list[i]);
                }
            }
            arrP = sort(arrP);
            NHANVIEN[] arrT = null;
            for (int i = 0; i < list.length; ++i) {
                if (nhanvienManager.getFirstLetterOfMaNV(list[i].getMaNhanVien()).equals("T")) {
                    arrT = add(arrT, list[i]);
                }
            }
            arrT = sort(arrT);

            arrC = add(arrC, arrP);
            arrC = add(arrC, arrT);
            return arrC;
        }
    }

    public static NHANVIEN getNhanVien(NHANVIEN[] list, String maNV) {
        for (int i = 0; i < list.length; ++i) {
            if (list[i].getMaNhanVien().equals(maNV)) {
                return list[i];
            }
        }
        return null;
    }

    public void printListALL(PHONGBAN[] pbList) {
        if (isEmpty(nvList)) {
            System.out.println("Danh sach rong.");
        } else {
            checkFirst(pbList);
            System.out.println("\n============== DANH SACH NHAN VIEN ==============");
            System.out.println("+------------------------------------------------------------------------------"
                    + "----------------------------------------------------------------------------------------"
                    + "--------------------------------------------------------------------------------------+");
            System.out.printf("| %-12s | %-30s | %-9s | %-10s | %-13s | %-40s | %-20s| %-35s | %-9s | %-21s | %-21s |\n",
                    "Ma nhan vien", "Ho va ten", "Gioi tinh", "Ngay sinh", "So dien thoai", "Dia chi",
                    "Chuc vu", "Email", "Phong ban", "Ngay bat dau hop dong", "Ngay ket thuc hop dong");
            System.out.println("+------------------------------------------------------------------------------"
                    + "----------------------------------------------------------------------------------------"
                    + "--------------------------------------------------------------------------------------+");
            for (int i = 0; i < nvList.length; ++i) {
                if (nvList[i] instanceof NHANVIENCHINH nhanvienchinh) {
                    System.out.printf("| %-12s | %-30s | %-9s | %-10s | %-13s | %-40s | %-20s| %-35s | %-9s | %-21s | %-21s  |\n",
                            nvList[i].maNhanVien, nvList[i].hoTen, nvList[i].gioiTinh, nvList[i].ngaySinh,
                            nvList[i].soDienThoai, nvList[i].diaChi, nvList[i].chucVu,
                            nhanvienchinh.getEmail(), nhanvienchinh.getMaPhong(),
                            nvList[i].getHopDong().getNgayBatDauHopDong().toString(),
                            nvList[i].getHopDong().getNgayKetThucHopDong().toString());
                } else if (nvList[i] instanceof THUCTAPSINH thuctapsinh) {
                    System.out.printf("| %-12s | %-30s | %-9s | %-10s | %-13s | %-40s | %-20s| %-35s | %-9s | %-21s | %-21s  |\n",
                            nvList[i].maNhanVien, nvList[i].hoTen, nvList[i].gioiTinh, nvList[i].ngaySinh,
                            nvList[i].soDienThoai, nvList[i].diaChi, nvList[i].chucVu,
                            thuctapsinh.getEmail(), thuctapsinh.getMaPhong(),
                            nvList[i].getHopDong().getNgayBatDauHopDong().toString(),
                            nvList[i].getHopDong().getNgayKetThucHopDong().toString());
                } else {
                    System.out.printf("| %-12s | %-30s | %-9s | %-10s | %-13s | %-40s | %-20s| %-35s | %-9s | %-21s | %-21s  |\n",
                            nvList[i].maNhanVien, nvList[i].hoTen, nvList[i].gioiTinh, nvList[i].ngaySinh,
                            nvList[i].soDienThoai, nvList[i].diaChi, nvList[i].chucVu,
                            ((NHANVIENPHU) nvList[i]).getEmail(), ((NHANVIENPHU) nvList[i]).getMaPhong(),
                            nvList[i].getHopDong().getNgayBatDauHopDong().toString(),
                            nvList[i].getHopDong().getNgayKetThucHopDong().toString());
                }
            }
            System.out.println("+------------------------------------------------------------------------------"
                    + "----------------------------------------------------------------------------------------"
                    + "--------------------------------------------------------------------------------------+");
        }
    }

    public void printPersonalInfo(PHONGBAN[] pbList) {
        if (isEmpty(nvList)) {
            System.out.println("Danh sach nhan vien rong.");
        } else {
            checkFirst(pbList);
            System.out.print("Moi nhap ma nhan vien can xem thong tin: ");
            String maNV = check.kiemTraMaNhanVien();
            if (isInList(nvList, maNV) != -1) {
                System.out.println("\n+------------------------------------------------------------------------------"
                        + "----------------------------------------------------------------------------------------"
                        + "--------------------------------------------------------------------------------------+");
                System.out.printf("| %-12s | %-30s | %-9s | %-10s | %-13s | %-40s | %-20s| %-35s | %-9s | %-21s | %-21s |\n",
                        "Ma nhan vien", "Ho va ten", "Gioi tinh", "Ngay sinh", "So dien thoai", "Dia chi",
                        "Chuc vu", "Email", "Phong ban", "Ngay bat dau hop dong", "Ngay ket thuc hop dong");
                System.out.println("+------------------------------------------------------------------------------"
                        + "----------------------------------------------------------------------------------------"
                        + "--------------------------------------------------------------------------------------+");
                if (getLoaiNV(nvList[isInList(nvList, maNV)]) == 1) {
                    System.out.printf("| %-12s | %-30s | %-9s | %-10s | %-13s | %-40s | %-20s| %-35s | %-9s | %-21s | %-21s  |\n",
                            nvList[isInList(nvList, maNV)].maNhanVien, nvList[isInList(nvList, maNV)].hoTen,
                            nvList[isInList(nvList, maNV)].gioiTinh, nvList[isInList(nvList, maNV)].ngaySinh,
                            nvList[isInList(nvList, maNV)].soDienThoai, nvList[isInList(nvList, maNV)].diaChi,
                            nvList[isInList(nvList, maNV)].chucVu,
                            ((NHANVIENCHINH) nvList[isInList(nvList, maNV)]).getEmail(),
                            ((NHANVIENCHINH) nvList[isInList(nvList, maNV)]).getMaPhong(),
                            nvList[isInList(nvList, maNV)].getHopDong().getNgayBatDauHopDong().toString(),
                            nvList[isInList(nvList, maNV)].getHopDong().getNgayKetThucHopDong().toString());
                } else if (getLoaiNV(nvList[isInList(nvList, maNV)]) == -1) {
                    System.out.printf("| %-12s | %-30s | %-9s | %-10s | %-13s | %-40s | %-20s| %-35s | %-9s | %-21s | %-21s  |\n",
                            nvList[isInList(nvList, maNV)].maNhanVien, nvList[isInList(nvList, maNV)].hoTen,
                            nvList[isInList(nvList, maNV)].gioiTinh, nvList[isInList(nvList, maNV)].ngaySinh,
                            nvList[isInList(nvList, maNV)].soDienThoai, nvList[isInList(nvList, maNV)].diaChi,
                            nvList[isInList(nvList, maNV)].chucVu,
                            ((THUCTAPSINH) nvList[isInList(nvList, maNV)]).getEmail(),
                            ((THUCTAPSINH) nvList[isInList(nvList, maNV)]).getMaPhong(),
                            nvList[isInList(nvList, maNV)].getHopDong().getNgayBatDauHopDong().toString(),
                            nvList[isInList(nvList, maNV)].getHopDong().getNgayKetThucHopDong().toString());
                } else {
                    System.out.printf("| %-12s | %-30s | %-9s | %-10s | %-13s | %-40s | %-20s| %-35s | %-9s | %-21s | %-21s  |\n",
                            nvList[isInList(nvList, maNV)].maNhanVien, nvList[isInList(nvList, maNV)].hoTen,
                            nvList[isInList(nvList, maNV)].gioiTinh, nvList[isInList(nvList, maNV)].ngaySinh,
                            nvList[isInList(nvList, maNV)].soDienThoai, nvList[isInList(nvList, maNV)].diaChi,
                            nvList[isInList(nvList, maNV)].chucVu,
                            ((NHANVIENPHU) nvList[isInList(nvList, maNV)]).getEmail(),
                            ((NHANVIENPHU) nvList[isInList(nvList, maNV)]).getMaPhong(),
                            nvList[isInList(nvList, maNV)].getHopDong().getNgayBatDauHopDong().toString(),
                            nvList[isInList(nvList, maNV)].getHopDong().getNgayKetThucHopDong().toString());
                }
                System.out.println("+------------------------------------------------------------------------------"
                        + "----------------------------------------------------------------------------------------"
                        + "--------------------------------------------------------------------------------------+");
            } else {
                System.out.println("Khong co nhan vien trong danh sach.");
            }
        }
    }

    public static void printPersonalInfo(NHANVIEN[] list, String maNV) {
        if (list[isInList(list, maNV)] instanceof NHANVIENCHINH nvc) {
            System.out.printf("| %-12s | %-30s | %-9s | %-10s | %-13s | %-40s | %-20s| %-35s | %-9s | %-21s | %-21s  |\n",
                    list[isInList(list, maNV)].maNhanVien, list[isInList(list, maNV)].hoTen,
                    list[isInList(list, maNV)].gioiTinh, list[isInList(list, maNV)].ngaySinh,
                    list[isInList(list, maNV)].soDienThoai, list[isInList(list, maNV)].diaChi,
                    list[isInList(list, maNV)].chucVu,
                    nvc.getEmail(), nvc.getMaPhong(),
                    list[isInList(list, maNV)].getHopDong().getNgayBatDauHopDong().toString(),
                    list[isInList(list, maNV)].getHopDong().getNgayKetThucHopDong().toString());
        } else if (list[isInList(list, maNV)] instanceof THUCTAPSINH tts) {
            System.out.printf("| %-12s | %-30s | %-9s | %-10s | %-13s | %-40s | %-20s| %-35s | %-9s | %-21s | %-21s  |\n",
                    list[isInList(list, maNV)].maNhanVien, list[isInList(list, maNV)].hoTen,
                    list[isInList(list, maNV)].gioiTinh, list[isInList(list, maNV)].ngaySinh,
                    list[isInList(list, maNV)].soDienThoai, list[isInList(list, maNV)].diaChi,
                    list[isInList(list, maNV)].chucVu,
                    tts.getEmail(), tts.getMaPhong(),
                    list[isInList(list, maNV)].getHopDong().getNgayBatDauHopDong().toString(),
                    list[isInList(list, maNV)].getHopDong().getNgayKetThucHopDong().toString());
        } else {
            System.out.printf("| %-12s | %-30s | %-9s | %-10s | %-13s | %-40s | %-20s| %-35s | %-9s | %-21s | %-21s  |\n",
                    list[isInList(list, maNV)].maNhanVien, list[isInList(list, maNV)].hoTen,
                    list[isInList(list, maNV)].gioiTinh, list[isInList(list, maNV)].ngaySinh,
                    list[isInList(list, maNV)].soDienThoai, list[isInList(list, maNV)].diaChi,
                    list[isInList(list, maNV)].chucVu,
                    ((NHANVIENPHU) list[isInList(list, maNV)]).getEmail(),
                    ((NHANVIENPHU) list[isInList(list, maNV)]).getMaPhong(),
                    list[isInList(list, maNV)].getHopDong().getNgayBatDauHopDong().toString(),
                    list[isInList(list, maNV)].getHopDong().getNgayKetThucHopDong().toString());
        }
    }

    public void printNVByName(PHONGBAN[] pbList) {
        if (isEmpty(nvList)) {
            System.out.println("Khong co nhan vien nao trong danh sach.");
        } else {
            checkFirst(pbList);
            System.out.print("Moi nhap ho va ten nhan vien: ");
            String name = check.kiemTraHoTen();
            int count = -1;
            for (int i = 0; i < nvList.length; ++i) {
                if (nvList[i].getHoTen().equals(name)) {
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
                    if (getLoaiNV(nvList[i]) == 1) {
                        System.out.printf("| %-12s | %-30s | %-9s | %-10s | %-13s | %-40s | %-20s| %-35s | %-9s | %-21s | %-21s  |\n",
                                nvList[i].maNhanVien, nvList[i].hoTen,
                                nvList[i].gioiTinh, nvList[i].ngaySinh,
                                nvList[i].soDienThoai, nvList[i].diaChi,
                                nvList[i].chucVu, ((NHANVIENCHINH) nvList[i]).getEmail(),
                                nvList[i].chucVu, ((NHANVIENCHINH) nvList[i]).getMaPhong(),
                                nvList[i].getHopDong().getNgayBatDauHopDong().toString(),
                                nvList[i].getHopDong().getNgayKetThucHopDong().toString());
                    } else if (getLoaiNV(nvList[i]) == -1) {
                        System.out.printf("| %-12s | %-30s | %-9s | %-10s | %-13s | %-40s | %-20s| %-35s | %-9s | %-21s | %-21s  |\n",
                                nvList[i].maNhanVien, nvList[i].hoTen,
                                nvList[i].gioiTinh, nvList[i].ngaySinh,
                                nvList[i].soDienThoai, nvList[i].diaChi,
                                nvList[i].chucVu, ((THUCTAPSINH) nvList[i]).getEmail(),
                                nvList[i].chucVu, ((THUCTAPSINH) nvList[i]).getMaPhong(),
                                nvList[i].getHopDong().getNgayBatDauHopDong().toString(),
                                nvList[i].getHopDong().getNgayKetThucHopDong().toString());
                    } else {
                        System.out.printf("| %-12s | %-30s | %-9s | %-10s | %-13s | %-40s | %-20s| %-35s | %-9s | %-21s | %-21s  |\n",
                                nvList[i].maNhanVien, nvList[i].hoTen,
                                nvList[i].gioiTinh, nvList[i].ngaySinh,
                                nvList[i].soDienThoai, nvList[i].diaChi,
                                nvList[i].chucVu, ((NHANVIENPHU) nvList[i]).getEmail(),
                                nvList[i].chucVu, ((NHANVIENPHU) nvList[i]).getMaPhong(),
                                nvList[i].getHopDong().getNgayBatDauHopDong().toString(),
                                nvList[i].getHopDong().getNgayKetThucHopDong().toString());
                    }
                }
            }
            if (count != -1) {
                System.out.println("+------------------------------------------------------------------------------"
                        + "----------------------------------------------------------------------------------------"
                        + "--------------------------------------------------------------------------------------+");
            } else {
                System.out.println("Khong co nhan vien nao co ten \"" + name + "\" trong danh sach.");
            }
        }
    }

    public void printNVByGender(PHONGBAN[] pbList) {
        if (isEmpty(nvList)) {
            System.out.println("Khong co nhan vien nao trong danh sach.");
        } else {
            checkFirst(pbList);
            System.out.print("Moi nhap gioi tinh (Nam | Nu): ");
            String gender = check.kiemTraGioiTinh();
            int count = -1;
            for (int i = 0; i < nvList.length; ++i) {
                if (nvList[i].getGioiTinh().equals(gender)) {
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
                    if (getLoaiNV(nvList[i]) == 1) {
                        System.out.printf("| %-12s | %-30s | %-9s | %-10s | %-13s | %-40s | %-20s| %-35s | %-9s | %-21s | %-21s  |\n",
                                nvList[i].maNhanVien, nvList[i].hoTen,
                                nvList[i].gioiTinh, nvList[i].ngaySinh,
                                nvList[i].soDienThoai, nvList[i].diaChi,
                                nvList[i].chucVu, ((NHANVIENCHINH) nvList[i]).getEmail(),
                                nvList[i].chucVu, ((NHANVIENCHINH) nvList[i]).getMaPhong(),
                                nvList[i].getHopDong().getNgayBatDauHopDong().toString(),
                                nvList[i].getHopDong().getNgayKetThucHopDong().toString());
                    } else if (getLoaiNV(nvList[i]) == -1) {
                        System.out.printf("| %-12s | %-30s | %-9s | %-10s | %-13s | %-40s | %-20s| %-35s | %-9s | %-21s | %-21s  |\n",
                                nvList[i].maNhanVien, nvList[i].hoTen,
                                nvList[i].gioiTinh, nvList[i].ngaySinh,
                                nvList[i].soDienThoai, nvList[i].diaChi,
                                nvList[i].chucVu, ((THUCTAPSINH) nvList[i]).getEmail(),
                                nvList[i].chucVu, ((THUCTAPSINH) nvList[i]).getMaPhong(),
                                nvList[i].getHopDong().getNgayBatDauHopDong().toString(),
                                nvList[i].getHopDong().getNgayKetThucHopDong().toString());
                    } else {
                        System.out.printf("| %-12s | %-30s | %-9s | %-10s | %-13s | %-40s | %-20s| %-35s | %-9s | %-21s | %-21s  |\n",
                                nvList[i].maNhanVien, nvList[i].hoTen,
                                nvList[i].gioiTinh, nvList[i].ngaySinh,
                                nvList[i].soDienThoai, nvList[i].diaChi,
                                nvList[i].chucVu, ((NHANVIENPHU) nvList[i]).getEmail(),
                                nvList[i].chucVu, ((NHANVIENPHU) nvList[i]).getMaPhong(),
                                nvList[i].getHopDong().getNgayBatDauHopDong().toString(),
                                nvList[i].getHopDong().getNgayKetThucHopDong().toString());
                    }
                }
            }
            if (count != -1) {
                System.out.println("+------------------------------------------------------------------------------"
                        + "----------------------------------------------------------------------------------------"
                        + "--------------------------------------------------------------------------------------+");
            } else {
                System.out.println("Khong co nhan vien nao co gioi tinh \"" + gender + "\" trong danh sach.");
            }
        }
    }

    public void printNVChinhList(PHONGBAN[] pbList) {
        if (isEmpty(nvList)) {
            System.out.println("Khong co nhan vien nao trong danh sach.");
        } else {
            checkFirst(pbList);
            int count = -1;
            for (int i = 0; i < nvList.length; ++i) {
                if (nvList[i] instanceof NHANVIENCHINH) {
                    ++count;
                    if (count == 0) {
                        System.out.println("\n========== DANH SACH NHAN VIEN CHINH ==========");
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
                    System.out.printf("| %-12s | %-30s | %-9s | %-10s | %-13s | %-40s | %-20s| %-35s | %-9s | %-21s | %-21s  |\n",
                            nvList[i].maNhanVien, nvList[i].hoTen,
                            nvList[i].gioiTinh, nvList[i].ngaySinh,
                            nvList[i].soDienThoai, nvList[i].diaChi,
                            nvList[i].chucVu, ((NHANVIENCHINH) nvList[i]).getEmail(),
                            nvList[i].chucVu, ((NHANVIENCHINH) nvList[i]).getMaPhong(),
                            nvList[i].getHopDong().getNgayBatDauHopDong().toString(),
                            nvList[i].getHopDong().getNgayKetThucHopDong().toString());
                }
            }
            if (count != -1) {
                System.out.println("+------------------------------------------------------------------------------"
                        + "----------------------------------------------------------------------------------------"
                        + "--------------------------------------------------------------------------------------+");
            } else {
                System.out.println("Khong co nhan vien chinh nao trong danh sach.");
            }
        }
    }

    public void printNVPhuList(PHONGBAN[] pbList) {
        if (isEmpty(nvList)) {
            System.out.println("Khong co nhan vien nao trong danh sach.");
        } else {
            checkFirst(pbList);
            int count = -1;
            for (int i = 0; i < nvList.length; ++i) {
                if (nvList[i] instanceof NHANVIENPHU) {
                    ++count;
                    if (count == 0) {
                        System.out.println("\n========== DANH SACH NHAN VIEN PHU ==========");
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
                    System.out.printf("| %-12s | %-30s | %-9s | %-10s | %-13s | %-40s | %-20s| %-35s | %-9s | %-21s | %-21s  |\n",
                            nvList[i].maNhanVien, nvList[i].hoTen,
                            nvList[i].gioiTinh, nvList[i].ngaySinh,
                            nvList[i].soDienThoai, nvList[i].diaChi,
                            nvList[i].chucVu, ((NHANVIENPHU) nvList[i]).getEmail(),
                            nvList[i].chucVu, ((NHANVIENPHU) nvList[i]).getMaPhong(),
                            nvList[i].getHopDong().getNgayBatDauHopDong().toString(),
                            nvList[i].getHopDong().getNgayKetThucHopDong().toString());
                }
            }
            if (count != -1) {
                System.out.println("+------------------------------------------------------------------------------"
                        + "----------------------------------------------------------------------------------------"
                        + "--------------------------------------------------------------------------------------+");
            } else {
                System.out.println("Khong co nhan vien phu nao trong danh sach.");
            }
        }
    }

    public void printThucTapSinhList(PHONGBAN[] pbList) {
        if (isEmpty(nvList)) {
            System.out.println("Khong co nhan vien nao trong danh sach.");
        } else {
            checkFirst(pbList);
            int count = -1;
            for (int i = 0; i < nvList.length; ++i) {
                if (nvList[i] instanceof THUCTAPSINH) {
                    ++count;
                    if (count == 0) {
                        System.out.println("\n========== DANH SACH THUC TAP SINH ==========");
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
                    System.out.printf("| %-12s | %-30s | %-9s | %-10s | %-13s | %-40s | %-20s| %-35s | %-9s | %-21s | %-21s  |\n",
                            nvList[i].maNhanVien, nvList[i].hoTen,
                            nvList[i].gioiTinh, nvList[i].ngaySinh,
                            nvList[i].soDienThoai, nvList[i].diaChi,
                            nvList[i].chucVu, ((THUCTAPSINH) nvList[i]).getEmail(),
                            nvList[i].chucVu, ((THUCTAPSINH) nvList[i]).getMaPhong(),
                            nvList[i].getHopDong().getNgayBatDauHopDong().toString(),
                            nvList[i].getHopDong().getNgayKetThucHopDong().toString());
                }
            }
            if (count != -1) {
                System.out.println("+------------------------------------------------------------------------------"
                        + "----------------------------------------------------------------------------------------"
                        + "--------------------------------------------------------------------------------------+");
            } else {
                System.out.println("Khong co thuc tap sinh nao trong danh sach.");
            }
        }
    }

    public void printNVKhongCoPhongBan() {
        if (isEmpty(nvList)) {
            System.out.println("Khong ton tai nhan vien nao trong danh sach nhan vien.");
        } else {
            int count = -1;
            for (int i = 0; i < nvList.length; ++i) {
                if (nvList[i] instanceof NHANVIENCHINH nvc) {
                    if (nvc.getMaPhong().equals("None")) {
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
                        nhanvienManager.printPersonalInfo(nvList, nvc.getMaNhanVien());
                    }
                } else if (nvList[i] instanceof THUCTAPSINH tts) {
                    if (tts.getMaPhong().equals("None")) {
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
                        nhanvienManager.printPersonalInfo(nvList, tts.getMaNhanVien());
                    }
                } else {
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
                    nhanvienManager.printPersonalInfo(nvList, nvList[i].getMaNhanVien());
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

    public int getLoaiNV(NHANVIEN nv) {
        // 1: Nhân viên chính
        // 0: Nhân viên phụ
        // -1: Thực tập sinh
//        if (getFirstLetterOfMaNV(nv.getMaNhanVien()).equals("C")) {
//            return 1;
//        } else if (getFirstLetterOfMaNV(nv.getMaNhanVien()).equals("P")) {
//            return 0;
//        } else {
//            return -1;
//        }
        if (nv instanceof NHANVIENCHINH) {
            return 1;
        } else if (nv instanceof NHANVIENPHU) {
            return 0;
        } else {
            return -1;
        }
    }

    public int getSoLuongNVChinh() {
        int count = 0;
        for (int i = 0; i < nvList.length; ++i) {
            if (getLoaiNV(nvList[i]) == 1) {
                ++count;
            }
        }
        return count;
    }

    public int getSoLuongNVPhu() {
        int count = 0;
        for (int i = 0; i < nvList.length; ++i) {
            if (getLoaiNV(nvList[i]) == 0) {
                ++count;
            }
        }
        return count;
    }

    public int getSoLuongThucTapSinh() {
        int count = 0;
        for (int i = 0; i < nvList.length; ++i) {
            if (getLoaiNV(nvList[i]) == -1) {
                ++count;
            }
        }
        return count;
    }

    public void checkFirst(PHONGBAN[] pbList) {
        for (int i = 0; i < nvList.length; ++i) {
            if (nvList[i] instanceof NHANVIENCHINH nvc) {
                if (phongbanManager.isInList(pbList, nvc.getMaPhong()) == -1) {
                    nvc.setMaPhong("None");
                }
            } else if (nvList[i] instanceof THUCTAPSINH tts) {
                if (phongbanManager.isInList(pbList, tts.getMaPhong()) == -1) {
                    tts.setMaPhong("None");
                }
            }
        }
        fnv.write(sortByMaNV(this.nvList));
    }
}
