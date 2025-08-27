package my.e88gt.schlong;

import java.nio.file.*;
import java.util.*;

public class Schlong
{
	public static void main(String...args)throws Throwable
	{
		args=new String[] {"ex/TestReturn0.s"};
		String path=args[0],src=new String(Files.readAllBytes(Paths.get(path)));
		
		looping:for(int i=0;i<src.length();i++)
		{
			// who Is going To be Modifying this?
			// and When is He going To modify It?
			final char c=src.charAt(i);
			
			if(Character.isWhitespace(c))
			{
				continue looping;
			}
			else if(Character.isDigit(c))
			{
				StringBuilder numbers = new StringBuilder();
				
				while(Character.isDigit(src.charAt(i)))
				{
					numbers.append(src.charAt(i));
					i++;
				}
			}
			else if(Character.isLetter(c))
			{
				System.out.println("letter "+c);
			}
			else
			{
				System.err.println("? '"+c+"'");
			}
		}
	}
}
