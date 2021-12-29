package filesOperators;

import java.io.File;
import java.io.IOException;

public class creation {
	public String Nom;

	public creation() {
		// TODO Auto-generated constructor stub
	}
	public creation(String s) {
		this.Nom = s + ".java";
		 try {
		      File myObj = new File(Nom);
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
}