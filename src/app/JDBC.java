package app;

import java.sql.*;

public class JDBC {
	
	
	
	public static ReturnClass chekLogin( String email,String password) {
        String url = "jdbc:mysql://localhost:3306/workTen";
        String user = "root";
        String pass = "admin@12345";
        
        String query = "SELECT * FROM users WHERE email = ?";
            
         try (Connection connection = DriverManager.getConnection(url, user, pass);
                 PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
           
                preparedStatement.setString(1, email);
                
        
                ResultSet response = preparedStatement.executeQuery();
                
                if (response.next()) {
                	int id = response.getInt("id");
                    String name = response.getString("name");
                    String dbPassword = response.getString("password");
                    Users newUser = new Users(id,name,email,password); 
                    System.out.println(password);
                    System.out.println(dbPassword);
                    if(dbPassword.equals(password)) {
                    	return new ReturnClass(true,"Loggin Succesfull",newUser);
                    }else {
                    	return new ReturnClass(false,"Incorrect password for user "+email,newUser);
                    }                    

                   
                }else {
                	
                	return new ReturnClass(false,"No User found with the provided credentials",null);
                }
                
                
            } catch (SQLException exception) {
                System.out.println(exception);
                return null;
            }
        	
        }
	
	
	public static ReturnClass registerUser(String name, String email, String password) {
        String url = "jdbc:mysql://localhost:3306/workTen";
        String user = "root";
        String pass = "admin@12345";
        
 
        
        ReturnClass response = validEmail(email, url, user, pass);
        if(response.success==true) {
        	String query = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
            
            try (Connection connection = DriverManager.getConnection(url, user, pass);
                 PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                
                // Set the parameters for the insert query
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, email);
                preparedStatement.setString(3, password);
                
                // Execute the query and get the generated keys (id)
                int affectedRows = preparedStatement.executeUpdate();
                
                if (affectedRows > 0) {
                    try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            int generatedId = generatedKeys.getInt(1);
                            Users registeredUser = new Users(generatedId,name,email,pass);
                            return new ReturnClass(true,"User Created Succesfully",registeredUser);
                        }
                    }
                }
                return null;
                
            } catch (SQLException exception) {
                System.out.println(exception);
                return null;
            }
        }else {
        	return new ReturnClass(false,"User with this email already exist",response.user);
        	
        }
    }

    public static ReturnClass validEmail(String email, String url, String user, String pass) {
        String query = "SELECT * FROM users WHERE email = ?";

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                // Email exists, return user details
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String existingEmail = resultSet.getString("email");
                String password = resultSet.getString("password");

                Users existingUser = new Users(id, name, existingEmail, password);
                return new ReturnClass(false, "User with the email"+existingUser.email+ "already exists", existingUser);
            } else {
                return new ReturnClass(true, "User does not exist", null);
            }
            
        } catch (SQLException exception) {
            System.out.println(exception);
            return new ReturnClass(false, "Server-side exception occurred", null);
        }
    }

}





