package my.e88gt.schlong.token;

import java.util.*;

public class Tokenizer
{
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
			{
				continue looping;
			}
			else if(Character.isDigit(c()))
			{
				StringBuilder numbers = new StringBuilder();
				
				while(Character.isDigit(src.charAt(i)))
				{
					numbers.append(c());
					i++;
				}
				i--;
				
				tokens.add(new Token(TokenType.NUMBER));
				
				System.out.println(numbers);
			}
			else if(Character.isLetter(c()))
			{
				StringBuilder letters = new StringBuilder();
				
				while(Character.isLetter(c()))
				{
					letters.append(c());
					i++;
				}
				i--;
				
				System.out.println(letters);
			}
			else
			{
				System.err.println("? '"+c()+"'");
			}
		}
		
		return tokens;
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
