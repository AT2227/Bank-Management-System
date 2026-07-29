package pkgfinal.project;

public class EmployeeUser 
{
    private String username;
    private String password;

    public EmployeeUser(String username,String password) 
    {
        setUsername(username);
        setPassword(password);
    }
    //----------------------------------------Setters----------------------------------------//
    public void setUsername(String username)
    {
        this.username=username;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }
    //----------------------------------------Getters----------------------------------------//
    public String getUsername()
    {
        return this.username;
    }
    public String getPassword()
    {
        return this.password;
    }
}
