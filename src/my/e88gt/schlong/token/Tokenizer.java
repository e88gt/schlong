
package my.e88gt.schlong.token;

import java.util.*;

import my.e88gt.schlong.*;
import my.e88gt.schlong.utils.*;

public class Tokenizer
{
	private final ArrayList<String> errorStack = new ArrayList<>();
	private int i = 0;
	private final int len;
	private final String src;
	
	public Tokenizer(String source)
	{
		i = 00;
		src = source;
		len = source.length();
	}
	
	public ArrayList<Token> tokenize()
	{
		ArrayList<Token> tokens = new ArrayList<>();
		
		looping: while (!isEOF())
		{
			// who Is going To be Modifying this?
			// and When is He going To modify It?
			if (Character.isWhitespace(current().value()))
			{
				next();
				continue looping;
			}
			else if (Character.isDigit(current().value()))
			{
				StringBuilder numbers = new StringBuilder();
				
				while (Character.isDigit(current().value()))
				{
					numbers.append(current().value());
					next();
				}
				
				tokens.add(new Token(TokenType.NUMBER, new Nullable<String>(numbers.toString())));
				
				continue looping;
			}
			else if (Character.isLetter(current().value()) || current().value() == '_')
			{
				StringBuilder letters = new StringBuilder();
				
				while (Character.isLetterOrDigit(current().value()) || current().value() == '_')
				{
					letters.append(current().value());
					next();
				}
				
				if (letters.toString().equals(Keywords.RETURN))
				{
					tokens.add(new Token(TokenType.RETURN, null));
				}
				else
				{
					tokens.add(new Token(TokenType.IDENTIFIER, new Nullable<String>(letters.toString())));
				}
				
				continue looping;
			}
			else if (current().value() == ';')
			{
				tokens.add(new Token(TokenType.SEMI, null));
				next();
				continue looping;
			}
			else
			{
				errorStack.add("Unknown character '" + current().value() + "' at the index of " + i);
				next();
			}
		}
		
		return tokens;
	}
	
	public ArrayList<String> getErrors()
	{
		return errorStack;
	}
	
	private Nullable<Character> current()
	{
		if (isEOF())
			return new Nullable<Character>(null);
		
		return new Nullable<Character>(src.charAt(i));
	}
	
	private Nullable<Character> next()
	{
		if (isEOF())
			return new Nullable<Character>(null);
		
		return new Nullable<Character>(src.charAt(i++));
	}
	
	private boolean isEOF()
	{
		return i >= len;
	}
}
