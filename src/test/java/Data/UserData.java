package Data;

public class UserData {
    private String validMail = "usermobile@test.com";
    private String validFullName = "Mobile User Test";
    private String validPassword = "Test1234*";
    private String invalidFormatMail = "wrongMailFormat123.*";
    private String invalidEmail = "invalidUser@example.com";

    private String invalidPassword = "invalidPassword";
    private String fullName = "Matnaqash Gev";
    private String mail = "gevorik@matnaqash.zuzu";
    private String password = "Test123*";
    private String number = "0987654321";

    public String getFullName(){return this.fullName;}
    public String  getMail(){return this.mail;}
    public String getPassword(){return this.password;}
    public String getNumber(){return this.number;}
    public String getValidMail(){return this.validMail;}
    public String getValidPassword(){return this.validPassword;}
    public String getValidFullName(){return this.validFullName;}
    public String getInvalidFormatEmail(){return this.invalidFormatMail;}
    public String getInvalidEmail(){return this.invalidEmail;}
    public String getInvalidPassword(){return this.invalidPassword;}
}
