package my.e88gt.schlong;

import java.util.*;

import my.e88gt.schlong.token.*;

public class Parser
{
	private final ArrayList<String>errs=new ArrayList<>();
	private int i = 0;
	private final int len;
	private final ArrayList<Token>tokens;
	
	public Parser(ArrayList<Token>tokens)
	{
		len=tokens.size();
		this.tokens=tokens;
	}
	
	public void parse()
	{
		for(;!isEOF();i++)
		{
			if(current().type() == TokenType.RETURN)
			{
				parseReturn();
			}
			else if(current().type() == TokenType.IDENTIFIER)
			{
//				System.out.println("identifier");
			}
			else
			{
				errs.add("Unknown token " + current() + " found at " + i);
			}
		}
	}
	
	private void parseReturn()
	{
	}
	
	private Token current()
	{
		return isEOF() ? null : tokens.get(i);
	}
	
	private boolean isEOF()
	{
		return i>=len;
	}
}
