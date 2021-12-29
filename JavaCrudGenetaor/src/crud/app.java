package crud;

import java.util.Scanner;

public class app extends classeInfo{

	public app() {
		super();
	}

	public static void main(String[] args) {
		app a = new app();
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrer le nom du classe");
		a.nomClasse = sc.nextLine();
		System.out.println("Entrer le type d'attribus du classe et son nom en line suivant");
		while(sc.hasNext()) {
			a.attributClasse.add(sc.nextLine());
			a.attributClasse.add(sc.nextLine());			
			System.out.println("print stop if you finished or anything else to continue");
			if (sc.nextLine().equals("stop"))
				break;
			a.index++;
		}
		generate g = new generate();
		g.createClass(a);
		System.out.println("Voulez vous generer des CRUDs ? tapez oui ou non\n");
		a.crud = sc.next();
		if (a.crud.equals("oui")) {
			g.add(a);
			g.update(a);
			g.delete(a);
		}
	}

}
