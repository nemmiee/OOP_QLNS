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

    public void setNhanVienList(NHANVIEN[] nvList) {
        this.nvList = nvList;
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

    public NHANVIEN[] add(NHANVIEN[] head, NHANVIEN[] tail) {
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
                    fnv.write(sortByMaNV());
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
                System.out.println("\n======== " + nvList[i].getHoTen());
                Main.editNhanVienMenu();
                while (flag) {
                    System.out.print("  Moi nhap lua chon: ");
                    int choice = (int) CHECK.kiemTraSoNguyenDuong();
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
            fnv.write(sortByMaNV());
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
            fnv.write(sortByMaNV());
        }
    }

    public static String getFirstLetterOfMaNV(String maNV) {
        return maNV.substring(0, 1);
    }

    public static int getNumberOfMaNV(String maNV) {
        return Integer.parseInt(maNV.substring(1));
    }

    public NHANVIEN[] sort(NHANVIEN[] array) {
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

    public NHANVIEN[] sortByMaNV() {
        if (isEmpty(this.nvList)) {
            return null;
        } else {
            NHANVIEN[] arrC = null;
            for (int i = 0; i < nvList.length; ++i) {
                if (nhanvienManager.getFirstLetterOfMaNV(nvList[i].getMaNhanVien()).equals("C")) {
                    arrC = add(arrC, nvList[i]);
                }
            }
            arrC = sort(arrC);
            NHANVIEN[] arrP = null;
            for (int i = 0; i < nvList.length; ++i) {
                if (nhanvienManager.getFirstLetterOfMaNV(nvList[i].getMaNhanVien()).equals("P")) {
                    arrP = add(arrP, nvList[i]);
                }
            }
            arrP = sort(arrP);
            NHANVIEN[] arrT = null;
            for (int i = 0; i < nvList.length; ++i) {
                if (nhanvienManager.getFirstLetterOfMaNV(nvList[i].getMaNhanVien()).equals("T")) {
                    arrT = add(arrT, nvList[i]);
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

    public void printListALL() {
        if (isEmpty(nvList)) {
            System.out.println("Danh sach rong.");
        } else {
            System.out.println("+-+-+-+-+-+-+-+-+-+ Danh sach nhan vien +-+-+-+-+-+-+-+-+-+\n");
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
