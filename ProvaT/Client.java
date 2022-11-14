package ProvaT;

public class Client {
    private String Name;
    private String Email;

    public Client(String name, String mail){
        this.Email = mail;
        this.Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getName() {
        return Name;
    }
}
