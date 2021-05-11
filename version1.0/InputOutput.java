package com.example.project_2;

import java.util.ArrayList;

public class InputOutput {
	public ArrayList input_array = new ArrayList();
	public String str=""; //input_string for calculator
	public ArrayList str_expression = new ArrayList();

	String[] operator = {"+","-","*","/","^","!","%","a","d","l","r","s","c","t","(",")"};
	
	public void input(String in) //input
	{
		if (in=="-" && (str =="" || str_expression.get(str_expression.size()-1)=="\\(")) in="_";
		if(in=="_") str+="-";
		if(!str.isEmpty()) for(String o:operator){if(in==o) {if(o=="(") break; str+=" ";}}
		if(in!="_") str=str.concat(in);
		for(String o:operator){if(in==o) {if(o==")") break;str+=" ";}}

		switch (in){
			case"r":
				str_expression.add("root");
				break;
			case"l":
				str_expression.add("log");
				break;
			case"s":
				str_expression.add("sin");
				break;
			case"c":
				str_expression.add("cos");
				break;
			case"t":
				str_expression.add("tan");
				break;
			case"a":
				str_expression.add("abs");
				break;
			case"d":
				str_expression.add("deg");
				break;
			case"_":
				str_expression.add("-");
				break;
			case"p":
				str_expression.add("PI");
				break;
			case"e":
				str_expression.add("exp");
				break;

			default:
				str_expression.add(in);
				break;
		}
	    return;
	}
	 	 
	
	public void str_to_array()
	{
		String[] arr = str.split(" ");
		for(int i=0;i<arr.length;i++)
		{	
			input_array.add(arr[i]);
		}
	}
	
	
	public void delete(String in)
	{
		if (str=="" || str_expression.isEmpty()) {
			return;}
		
		if(in=="Del")
		 {
			if(str.endsWith(" ")){str=str.substring(0, str.length()-1);}
			str=str.substring(0, str.length()-1);
			str_expression.remove(str_expression.size()-1);
		 }
		 else if(in=="AC") 
		 {
			 str="";
			 str_expression.clear();
		 }
	 }
	


	
	
}