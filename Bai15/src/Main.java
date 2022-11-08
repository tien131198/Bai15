import ui.UI;

import java.io.Serializable;
import java.util.Scanner;

/* Welcome to project
    @author: tienb
    Date: 11/6/2022
    Time: 7:42 PM
    ProjectName: Bai15
*/public class Main {
    public static void main(String[] args) {
        UI ui = new UI();
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Chuong trinh quan ly sinh vien");
            System.out.println("Chon 1 : Them sinh vien");
            System.out.println("Chon 2 : Tim sinh vien theo id");
            System.out.println("Chon 3 : Hien thi toan bo thong tin sinh vien");
            System.out.println("Chon 4 : Xac dinh tong so sinh vien cua khoa");
            System.out.println("Chon 5 : Xac dinh so luong sinh vien chinh quy");
            System.out.println("Chon 6 : Xac dinh sinh vien co diem dau vao cao nhat");
            System.out.println("Chon 7 : Danh sach sinh vien tai chuc");
            System.out.println("Chon 8 : Danh sach sinh vien co diem hoc ki gan nhat >=8");
            System.out.println("Chon 9 : Xac dinh sinh vien co diem trung binh cao nhat trong tat ca ca ki hoc");
            System.out.println("Chon 10: Danh sach sinh vien duoc sap xep theo tieu chi");
            System.out.println("Chon 11: Thong ke so luong sinh vien theo nam vao hoc");
            System.out.println("Chon 12: Xac dinh tong so luong sinh vien cua khoa");
            System.out.println("Chon 13: Thoat khoi chuong trinh");
            String chon = scanner.nextLine();
            switch (chon){
                case "1":{
                    ui.themThongTinSinhVien(scanner);
                    break;
                }
                case "2":{
                    ui.searchByID(scanner);
                    break;
                }
                case "3":{
                    ui.showAll();
                    break;
                }
                case "4":{
                    ui.soLuongSV();
                    break;
                }
                case "5":{
                    ui.tongSoSVCQ();
                    break;
                }
                case "6":{
                    ui.sVDiemDauVaoCaoNhat();
                    break;
                }
                case "7":{
                    ui.dSSVTaiChuc(scanner);
                    break;
                }
                case "8":{
                    ui.dSSVDiemLonHon8();
                    break;
                }
                case "9":{
                    ui.timSVDiemCaoNhat();
                    break;
                }
                case "10":{
                    ui.sapXepDanhSachSV();
                    break;
                }
                case "11":{
                    ui.thongKeSoLuongSVTheoNam(scanner);
                    break;
                }
                case "12":{
                    ui.soLuongSV();
                    break;
                }
                case "13":{
                    System.out.println("Thoat khoi chuong trinh: ");
                    System.exit(0);
                }
                default:
                    break;
            }
        }
    }
}
