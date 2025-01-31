package br.edu.ifsp.dsw1.model.entity;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class User {

	private String name;
	private String password;
	private String email;
	//private List<Link> listaLinks;
	
	public User() {
		
	}
	
    public User(String name, String email, String password) {
        this(name, email, password, false);
    }


	public User(String name, String email, String password, boolean fromDB) {
		 this.name = name;
	     this.email = email;
	     
	   if (fromDB) {
            this.password = password;
        } else {
            this.password = hashSHA256(password);
        }
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
		
	}
	
	public static boolean authenticate(User user, String email, String password) {
		
		if(user != null) {
			return hashSHA256(password).equals(user.getPassword()) && email.equals(user.getEmail());
		}
		
		return false;
	}
	
	
	private static String hashSHA256(String password) {
		
		try {
          
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

          
            byte[] hashBytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));

        
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao criptografar");
        }
		
		
	}
	
	
}
