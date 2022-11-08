package exception;

/* Welcome to project
    @author: tienb
    Date: 11/8/2022
    Time: 10:37 AM
    
    ProjectName: Main.java
*/public class YearException extends Exception{
    int year;
    public YearException(int year){
        System.out.println("Nam tu 0 -> 9999 :" + year + " khong hop le");
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
