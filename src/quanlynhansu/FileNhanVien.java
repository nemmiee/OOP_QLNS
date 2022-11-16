/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlynhansu;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileNhanVien {
    private static final String NHANVIEN_FILE_NAME = "D:/Study Space/HK1_2022_2023/OOP_QLNS/QUANLYNHANSU/nhanvien.txt";
    
    public void write(NHANVIEN[] nvList) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(new File(NHANVIEN_FILE_NAME));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(nvList);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            closeStream(fos);
            closeStream(oos);
        }
    }
    
    public NHANVIEN[] read() {
        NHANVIEN[] nvList = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File(NHANVIEN_FILE_NAME));
            ois = new ObjectInputStream(fis);
            nvList = (NHANVIEN[]) ois.readObject();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            closeStream(fis);
            closeStream(ois);
        }
        return nvList;
    }
    
    private void closeStream(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void closeStream(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
