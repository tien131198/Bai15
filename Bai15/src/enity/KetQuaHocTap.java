package enity;

/* Welcome to project
    @author: tienb
    Date: 11/6/2022
    Time: 7:45 PM
    
    ProjectName: Bai15
*/public class KetQuaHocTap {
    private String hocKi;
    private float diemTrungBinh;

    public KetQuaHocTap() {
    }

    public KetQuaHocTap(String hocKi, float diemTrungBinh) {
        this.hocKi = hocKi;
        this.diemTrungBinh = diemTrungBinh;
    }

    public String getHocKi() {
        return hocKi;
    }

    public void setHocKi(String hocKi) {
        this.hocKi = hocKi;
    }

    public float getDiemTrungBinh() {
        return diemTrungBinh;
    }

    public void setDiemTrungBinh(float diemTrungBinh) {
        this.diemTrungBinh = diemTrungBinh;
    }

    @Override
    public String toString() {
        return "KetQuaHocTap{" +
                "hocKi='" + hocKi + '\'' +
                ", diemTrungBinh=" + diemTrungBinh +
                '}';
    }
}
