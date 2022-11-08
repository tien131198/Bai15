package enity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/* Welcome to project
    @author: tienb
    Date: 11/6/2022
    Time: 7:45 PM
    
    ProjectName: Bai15
*/public class SinhVienTaiChuc extends SinhVienChinhQuy implements Serializable {
    private String noiDaoTao;
    public SinhVienTaiChuc(){

    }

    public SinhVienTaiChuc(String noiDaoTao) {
        this.noiDaoTao = noiDaoTao;
    }

    public SinhVienTaiChuc(String maSV, String ten, LocalDate ngaySinh, int namVaoHoc, float diemDauVao, String email, String phone, List<KetQuaHocTap> ketQua, String noiDaoTao) {
        super(maSV, ten, ngaySinh, namVaoHoc, diemDauVao, email, phone, ketQua);
        this.noiDaoTao = noiDaoTao;
    }

    public String getNoiDaoTao() {
        return noiDaoTao;
    }

    public void setNoiDaoTao(String noiDaoTao) {
        this.noiDaoTao = noiDaoTao;
    }

    @Override
    public String toString() {
        return "SinhVienTaiChuc{" +
                "noiDaoTao='" + noiDaoTao + '\'' +
                ", maSV='" + maSV + '\'' +
                ", ten='" + ten + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", namVaoHoc=" + namVaoHoc +
                ", diemDauVao=" + diemDauVao +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", ketQua=" + ketQua +
                '}';
    }
}
