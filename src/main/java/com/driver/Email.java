package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if(!oldPassword.equals(newPassword)) return;
        boolean c1 = newPassword.length() >= 8 ? true : false;
        boolean c2 = hasUpperCase(newPassword);
        boolean c3 = hasLowerCase(newPassword);
        boolean c4 = hasDigit(newPassword);
        boolean c5 = hasSpecialChar(newPassword);
        if(c1&& c2&& c3 && c4 && c5){
            this.password = newPassword;
        }
    }
    public boolean hasUpperCase(String pwd){
        for(char ch : pwd.toCharArray()){
            if(ch >= 'A' && ch <= 'Z') {
                return true;
            }
        }
        return  false;
    }
    public boolean hasLowerCase(String pwd){
        for(char ch : pwd.toCharArray()){
            if(ch >= 'a' && ch <= 'z') {
                return true;
            }
        }
        return  false;
    }
    public boolean hasDigit(String pwd){
        for(char ch : pwd.toCharArray()){
            if(Character.isDigit(ch)) return true;
        }
        return  false;
    }
    public boolean hasSpecialChar(String pwd){
        for(char ch : pwd.toCharArray()){
            if(!Character.isLetterOrDigit(ch)) {
                return true;
            }
        }
        return  false;
    }

}
