package habib.webservice.Model;

/**
 * Created by lenovo on 30/03/2017.
 */
public class Adherent
{
    private String login;
    private String password;

    public Adherent()
    {

    }

    public Adherent(String login,String password)
    {
        this.login=login;
        this.password=password;
    }

    //getters
    public String getLogin()
    {
        return this.login;
    }

    public String getPassword()
    {
        return this.password;
    }

    //setters

    public void setLogin(String login)
    {
        this.login=login;
    }

    public void setPassword(String password)
    {
        this.password=password;
    }
}
