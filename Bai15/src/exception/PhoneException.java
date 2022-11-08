package exception;

/* Welcome to project
    @author: tienb
    Date: 11/8/2022
    Time: 1:28 PM
    
    ProjectName: Main.java
*/public class PhoneException extends Exception{
    private String phone;

    public PhoneException(String phone) {
        System.out.println("Nhap sai dinh dang phone (co 10 so bat dau boi 08): ");
    }
}
