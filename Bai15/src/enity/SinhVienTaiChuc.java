package enity;

import java.time.LocalDate;
import java.util.List;

/* Welcome to project
    @author: tienb
    Date: 11/6/2022
    Time: 7:45 PM
    
    ProjectName: Bai15
*/public class SinhVienTaiChuc extends SinhVienChinhQuy{
    private String noiDaoTao;
    public SinhVienTaiChuc(){

    }

    public SinhVienTaiChuc(String noiDaoTao) {
        this.noiDaoTao = noiDaoTao;
    }

    public SinhVienTaiChuc(String maSV, String ten, LocalDate ngaySinh, int namVaoHoc, int diemDauVao, List<KetQuaHocTap> ketQua, String noiDaoTao) {
        super(maSV, ten, ngaySinh, namVaoHoc, diemDauVao, ketQua);
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
                ", ketQua=" + ketQua +
                '}';
    }
}
