package models;

public class TestBlankForm {
	public String firstName = "Tom";
    public String lastName = "Smith";
    public String email ="Tom.Smith@tom.com";
    public String comment = "Testing comment";
    
    public TestBlankForm() {}
    
    public TestBlankForm(
            String firstName,
            String lastName,
            String email,
            String comment)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.comment = comment;
    }
}
