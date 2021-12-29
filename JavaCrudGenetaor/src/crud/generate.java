package crud;

import java.io.FileWriter;
import java.io.IOException;

import filesOperators.creation;

public class generate implements interfaceCrud{
	public creation c;

	public generate() {
	}
	
	@Override
	public void createClass(app a) {
		creation c = new creation(a.nomClasse);
		try {
		      FileWriter myWriter = new FileWriter(c.Nom);
		      myWriter.write("package bean;\n");
		      myWriter.write("public class "+ a.nomClasse+" {\n\n");
		      for (int i = 0; i < a.attributClasse.size() - 1; i++) {
		    	  myWriter.write("public "+ a.attributClasse.get(i) + " "+ a.attributClasse.get(i+1) + ";\n");
		    	  i+=1;
		      }
		      
		      myWriter.write("}\n\n");
		      myWriter.close();
		      System.out.println("Successfully wrote to the class " +a.nomClasse+ " file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}

	@Override
	public void add(app a) {
		creation c = new creation("add_"+ a.nomClasse);
		try {
		      FileWriter myWriter = new FileWriter(c.Nom);
		      String temp = a.nomClasse.substring(0,a.nomClasse.length()-1);
		      myWriter.write("public class add_"+ a.nomClasse + "( "+a.nomClasse+" "+temp+") {\n"
		    		+ "public void add_"+ a.nomClasse + "( "+a.nomClasse+" "+temp+") {\n"
		      		+ "\n"
		      		+ "        String sql = \"insert into hero values(null,?,?,?)\";\n"
		      		+ "        try (Connection c = getConnection();"
		      		+ "			PreparedStatement ps = c.prepareStatement(sql);) {\n"
		      		+ "\n"
		      		+ "            ps.setInt(1, "+temp+".id);\n"
		      		+ "            ps.setString(2, "+temp+".username);\n"
		      		+ "            ps.setString(3, "+temp+".password);\n"
		      		+ "\n"
		      		+ "            ps.execute();\n"
		      		+ "\n"
		      		+ "            ResultSet rs = ps.getGeneratedKeys();\n"
		      		+ "            if (rs.next()) {\n"
		      		+ "                int id = rs.getInt(1);\n"
		      		+ "                "+temp+".id = id;\n"
		      		+ "            }\n"
		      		+ "        } catch (SQLException e) {\n"
		      		+ "\n"
		      		+ "            e.printStackTrace();\n"
		      		+ "        }\n"
		      		+ "        }\n"
		      		+ "    }");
		      myWriter.close();
		      System.out.println("Successfully wrote to the add file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}

	@Override
	public void update(app a) {
		creation c = new creation("update_"+a.nomClasse);
		try {
		      FileWriter myWriter = new FileWriter(c.Nom);
		      String temp = a.nomClasse.substring(0,a.nomClasse.length()-1);
		      myWriter.write("public class update_"+ a.nomClasse + "("+a.nomClasse+" "+temp+") {\n"
		      		+ "\n public void update_"+ a.nomClasse + "("+a.nomClasse+" "+temp+") {\n"
				    + "\n"
		      		+ "        String sql = \"update "+temp+" set id= ?, username = ? , password = ? where id = i\";\n"
		      		+ "        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {\n"
		      		+ "\n"
		      		+ "            ps.setInt(1, "+temp+".id);\n"
		      		+ "            ps.setString(2, "+temp+".username);\n"
		      		+ "            ps.setString(3, "+temp+".password);\n"
		      		+ "\n"
		      		+ "            ps.execute();\n"
		      		+ "\n"
		      		+ "        } catch (SQLException e) {\n"
		      		+ "\n"
		      		+ "            e.printStackTrace();\n"
		      		+ "        }\n"
		      		+ "        }\n");
		      myWriter.close();
		      System.out.println("Successfully wrote to the update file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }		
	}

	@Override
	public void delete(app a) {
		creation c = new creation("delete_"+a.nomClasse);
		try {
		      FileWriter myWriter = new FileWriter(c.Nom);
		      myWriter.write("public class delete_"+a.nomClasse+ "(int id) {\n"
		      		+ "\npublic void delete_"+a.nomClasse+ "(int id) {\n"
		      		+ "        try (Connection c = getConnection(); Statement s = c.createStatement();) {\n"
		      		+ "\n"
		      		+ "            String sql = \"delete from hero where id = \" + id;\n"
		      		+ "\n"
		      		+ "            s.execute(sql);\n"
		      		+ "\n"
		      		+ "        } catch (SQLException e) {\n"
		      		+ "\n"
		      		+ "            e.printStackTrace();\n"
		      		+ "        }\n"
		      		+ "    }");
		      myWriter.close();
		      System.out.println("Successfully wrote to the delete file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }		
	}



}
