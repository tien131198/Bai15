package exception;

/* Welcome to project
    @author: tienb
    Date: 11/8/2022
    Time: 1:23 PM
    
    ProjectName: Main.java
*/public class EmailException extends Exception{
    private String email;

    public EmailException(String email) {
        System.out.println("Email sai dinh dang: tien123@gmail.com");
    }
}
