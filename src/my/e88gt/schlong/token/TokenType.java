package my.e88gt.schlong.token;

public enum TokenType
{
	IDENTIFIER,
	RETURN,
	NUMBER,
	SEMI,
	;
	
	@Override public String toString()
	{
		return name().toLowerCase();
	}
}
