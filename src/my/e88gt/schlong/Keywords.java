package my.e88gt.schlong;

public enum Keywords
{;
	public static final String RETURN = "return";
	
	@Override public String toString()
	{
		StringBuilder string = new StringBuilder(name().toLowerCase());
//		string.setCharAt(0, Character.toUpperCase(name().charAt(0)));
		return string.toString();
	}
}
