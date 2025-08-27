package my.e88gt.schlong.token;

import java.util.*;

public class Tokenizer
{
	final ArrayList<String>errs=new ArrayList<>();
	int i;
	final int len;
	final String src;
	
	public Tokenizer(String source)
	{
		i=00;
		src=source;
		len=source.length();
	}
	
	public ArrayList<Token> tokenize()
	{
		ArrayList<Token>tokens=new ArrayList<>();
		
		looping:for(;!isEOF();i++)
		{
			// who Is going To be Modifying this?
			// and When is He going To modify It?
			if(Character.isWhitespace(c()))
				continue looping;
				
			else if(Character.isDigit(c()))
			{
				StringBuilder numbers = new StringBuilder();
				
				while(Character.isDigit(src.charAt(i)))
				{
					numbers.append(c());
					i++;
				}
				i--;
				
				tokens.add(new Token(TokenType.NUMBER, numbers.toString()));
			}
			else if(Character.isLetter(c()))
			{
				StringBuilder letters = new StringBuilder();
				
				while(Character.isLetterOrDigit(c()))
				{
					letters.append(c());
					i++;
				}
				i--;
				
				if(letters.toString().equals("return"))
				{
					tokens.add(new Token(TokenType.RETURN, null));
				}
				else
				{
					errs.add("Unknown token '" + letters + "' at " + i);
				}
			}
			else if(c()==';')
			{
				tokens.add(new Token(TokenType.SEMI, null));
			}
			else
			{
				errs.add("Unknown character '" + c() + "' at " + i);
			}
		}
		
		return tokens;
	}
	
	public ArrayList<String>getErrors()
	{
		return errs;
	}
	
	private char c()
	{
		return src.charAt(i);
	}
	
	private boolean isEOF()
	{
		return i>=len;
	}
}
