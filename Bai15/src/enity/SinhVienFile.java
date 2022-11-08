package enity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Welcome to project
    @author: tienb
    Date: 11/8/2022
    Time: 3:14 PM
    
    ProjectName: Main.java
*/public class SinhVienFile implements Serializable{
    private static final String FILE_STUDENT = "student.txt";

    // ghi du lieu vao file
    public void write(List<SinhVienChinhQuy> listSVCQ) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(FILE_STUDENT);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(listSVCQ);
        } catch (FileNotFoundException e) {
            System.out.println("khong tim thay file");
        } catch (IOException e) {
            System.out.println("IO exception1");
        } finally {
            if (oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    System.out.println("IO exception2");
                }
            }
            try {
                fos.close();
            } catch (IOException e) {
                System.out.println("IO exception");
            }

        }
    }

    // lay du lieu tu file
    public List<SinhVienChinhQuy> read() {
        List<SinhVienChinhQuy> listSVCQ = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(FILE_STUDENT);
            ois = new ObjectInputStream(fis);
            listSVCQ = (List<SinhVienChinhQuy>)ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("class not found exception");
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                System.out.println("IO exception 4");
            }
            try {
                fis.close();
            } catch (IOException e) {
                System.out.println("IO exception 5");;
            }
        }
        return listSVCQ;
    }

}
