package app;

public class Users {
	int id;
    String name;
    String email;
    String pass;
   

    public Users(int id, String name, String email, String pass) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.pass=pass;
        
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

   
}
