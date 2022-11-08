package service;

import exception.*;

import java.util.regex.Pattern;

/* Welcome to project
    @author: tienb
    Date: 11/6/2022
    Time: 8:04 PM
    
    ProjectName: Bai15
*/public class KiemTraNgoaiLe {
    public static void checkDiem(float score) throws ScoreException {
        if (score > 10 || score < 0) {
            throw new ScoreException(score);
        }
    }

    public static void checkYear(int year) throws YearException {
        if (year < 0 || year > 9999) {
            throw new YearException(year);
        }
    }

    public static void checkSoLuong(int number) throws NumberException {
        if (number < 0) {
            throw new NumberException(number);
        }
    }
    public static void checkEmail(String email)throws EmailException{
        Pattern p = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]+@[a-zA-Z]+(\\.[a-zA-Z]+){1,2}$");
        if (!p.matcher(email).find()){
            throw new EmailException(email);
        }
    }
    public static void checkPhone(String phone) throws PhoneException{
        Pattern p2 = Pattern.compile("^(08)[0-9]{8}$");
        if (!p2.matcher(phone).find()){
            throw new PhoneException(phone);
        }
    }
}
