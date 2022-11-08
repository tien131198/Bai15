package exception;

/* Welcome to project
    @author: tienb
    Date: 11/8/2022
    Time: 10:45 AM
    
    ProjectName: Main.java
*/public class NumberException extends Exception{
    private int number;
    public NumberException(int number){
        System.out.println("Yeu cau >0 " + number + " khong hop le");
    }
}
