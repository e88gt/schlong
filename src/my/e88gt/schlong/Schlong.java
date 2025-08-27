package my.e88gt.schlong;

import java.nio.file.*;
import java.util.*;

import my.e88gt.schlong.token.*;

public class Schlong
{
	public static void main(String...args)throws Throwable
	{
		args=new String[] {"ex/TestReturn0.s"};
		String path=args[0],src=new String(Files.readAllBytes(Paths.get(path)));
		
		Tokenizer tokenizer = new Tokenizer(src);
		ArrayList<Token>tokens = tokenizer.tokenize();
		
		for(Token t:tokens)
			System.out.println(t);
	}
}
