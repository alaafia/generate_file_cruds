package filesOperators;

public class SetType {
	public SetType() {
		
	}

	public String setType(String type) {
		return "set"+ type.substring(0, 1).toUpperCase() + type.substring(1);

	}

}
