
public enum DataDef {
	NO_USE,
	INT,
	DOUBLE,
	ID,
	CHAR,
	SPEC;
	
	public String toString(){
		return super.toString().toLowerCase();
	}
}
