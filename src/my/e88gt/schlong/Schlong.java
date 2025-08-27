package my.e88gt.schlong;

import java.nio.file.*;

public class Schlong
{
	public static void main(String...args)throws Throwable
	{
		args=new String[] {"res/examples/TestReturn.s"};
		String path=args[0],src=new String(Files.readAllBytes(Paths.get(path)));
		
		looping:for(int i=0;i<src.length();i++)
		{
			// who Is going To be Modifying this?
			// and When is He going To modify It?
			final char c=src.charAt(i);
			
			if(Character.isWhitespace(c))
			{
			}
		}
	}
}
