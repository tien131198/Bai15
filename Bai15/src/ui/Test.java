package ui;

import com.sun.source.tree.WhileLoopTree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Welcome to project
    @author: tienb
    Date: 11/7/2022
    Time: 12:38 PM
    
    ProjectName: SinhVienChinhQuy.java
*/public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        // regular experessions
        // thay the khoang trang
        // nhap dung dinh dang msv
        // dinh dang so dien thoai
        // dinh lai email
        // pattern class: mot lop the hien cho bieu thuc chinh quy, co phuong thuc compli
        // trar ve 1 doi tuong pattern - matcher class truyen vao 1 dau vao
        /**
         * [^a-z]
         */

        //tranhung1666@xmail.com
//        String regex = "^[a-zA-Z]+[a-z0-9]*@{1}\\w+mail.com$";
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(input);
//        if (matcher.find()){
//            System.out.println("Dung dinh dang");
//
//        }else{
//            System.out.println("kiem tra lai");
//        }
        //
        //   ^[a-zA-Z][a-zA-Z0-9]+@[a-zA-Z]+(\\.[a-zA-Z]+){1}$
//        Scanner scanner = new Scanner(System.in);
////        Pattern p = Pattern.compile("^\\([0-9]{3}\\)-[0-9]{3}-[0-9]{4}$");
//        Pattern p = Pattern.compile("^(08)[0-9]{8}$");
//        while (true) {
//            String txt = scanner.nextLine();
//            if (p.matcher(txt).find()) {
//                System.out.println("txt ok");
//                break;
//            } else {
//                System.out.println("txt not ok");
//            }
//        }
//        public String getPhone(){
        String path ="E:\\WorkspaceJava\\BaiTapTuLuLuyen\\Bai15\\Bai15\\Bai15\\test.txt";
        FileInputStream f = new FileInputStream(path);
        FileOutputStream f2 = new FileOutputStream(path);
        int data;
        String mes = "hi";
        try {
            f2.write(mes.getBytes());
            f2.close();
        } catch (IOException e) {
            System.out.println("co loi khi ghi filae");;
        }
//        while (true){
//            try {
//                if((data = f.read()) != -1){
//                    System.out.print((char)data);
//                }
//            } catch (IOException e) {
//                System.out.println("loi doc file ");
//            }
//        }

    }

}
