package crud;

import java.util.ArrayList;
import java.util.List;

public class classeInfo {
	public  String nomClasse;
	public  List<String> attributClasse;
	public  int index;
	public String crud;

	public classeInfo() {
		index = 1;
		attributClasse = new ArrayList<String>();
	}

	
	public String getCrud() {
		return crud;
	}


	public void setCrud(String crud) {
		this.crud = crud;
	}




	public String getNomClasse() {
		return nomClasse;
	}


	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
	}


	public List<String> getAttributClasse() {
		return attributClasse;
	}


	public void setAttributClasse(List<String> attributClasse) {
		this.attributClasse = attributClasse;
	}


	public int getIndex() {
		return index;
	}


	public void setIndex(int index) {
		this.index = index;
	}
	
}
