package my.e88gt.schlong.parse;

import java.util.*;

import my.e88gt.schlong.expression.*;
import my.e88gt.schlong.token.*;
import my.e88gt.schlong.utils.*;

public class Parser
{
	private final ArrayList<String> errors = new ArrayList<>();
	private int i = 0;
	private final int len;
	private final ArrayList<Token> tokens;
	
	public Parser(ArrayList<Token> tokens)
	{
		len = tokens.size();
		this.tokens = tokens;
	}
	
	public Nullable<ExitNode> parse()
	{
		Nullable<ExitNode> exit = new Nullable<ExitNode>(new ExitNode());
		
		while(current().hasValue())
		{
			if(current().value().type() == TokenType.RETURN)
			{
				if (new Object() != null)
				{
				}
			}
		}
		
		return exit;
	}
	
	private Nullable<ExpressionNode> parseExpression()
	{
		return null;
	}
	
	private Nullable<Token> current()
	{
		return new Nullable<Token>(isEOF()?null:tokens.get(i));
	}
	
	private Token next()
	{
		return tokens.get(i++);
	}
	
	private boolean isEOF()
	{
		return (i >= len);
	}
	
	public ArrayList<String>getErrors()
	{
		return errors;
	}
}
