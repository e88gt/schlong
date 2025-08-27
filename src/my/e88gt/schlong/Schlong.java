package my.e88gt.schlong;

import java.nio.file.*;
import java.util.*;

import my.e88gt.schlong.token.*;

public class Schlong
{
	public static void main(String...args)throws Throwable
	{
		args=new String[] {"tests/TestReturn0.s"};
		String path=args[0],src=new String(Files.readAllBytes(Paths.get(path)));
		
		Tokenizer tokenizer = new Tokenizer(src);
		ArrayList<Token>tokens = tokenizer.tokenize();
		
		for(int i=0;i<tokenizer.getErrors().size();i++)
		{
			String error = tokenizer.getErrors().get(i);
			System.err.println("Error "+(1+i)+": "+error);
		}
		
		Parser parser = new Parser(tokens);
		parser.parse();
	}
}
