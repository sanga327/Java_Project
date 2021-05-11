package com.example.project_2;

import java.util.*;

public class Calculate {
	
	public int arr_count=0;
	
	Stack<String> opStack = new Stack<>();  // 연산자
	Stack<String> calStack = new Stack<>(); // 후위 표기법 계산
	
    List<String> output = new ArrayList<>();
    List<String> inputArr = new ArrayList<>();
   
    
	// 연산자 우선순위
	public int opPriority(String op) {
		switch(op) {
			case "^":
			case "l":  // log
			case "r":  // root
			case "c":  // cos
			case "s":  // sin
			case "t":  // tan
			case "!":  // fac
			case "a":  // abs
			case "d":  // rad
				return 4;
			case "*":
			case "/":
			case "%":
				return 3;
			case "+":
			case "-":
				return 2;
			case "(":
				return 1;
			case "e":
			case "p":
			default:
				return -1;
		}
	}
	
	// input 
	void init() {
		if(!output.isEmpty()) {
			output.clear();
		}
		if(!inputArr.isEmpty()) {
			inputArr.clear();
		}
		output = new ArrayList<>();
		inputArr = new ArrayList<String>();
	}
	
	
	// 후위연산식 만들기
	public double postfixCalculation(ArrayList<String> inputArr) {  
		
		for(int i=0; i<inputArr.size(); i++) {
			String s = inputArr.get(i); 
		
			// 숫자일 경우
			try {
		        Double.parseDouble(s);
		        output.add(s);
		    } 
			// 숫자가 아닐 경우
			catch(NumberFormatException e) { 
				// 피연산자일 경우
		        if (s.equals("e") || s.equals("p")) {
		        	output.add(s);
		        }
		        // 여는 괄호일 경우 opStack에 push
		        if (s.equals("(")) {
		        	opStack.push(s);
		        }
		        // 닫는 괄호일 경우 여는 괄호 나올 때까지 pop
		        else if (s.equals(")")) {
		        	String start = opStack.pop();
		        	while (!start.equals("(")) {
		        		output.add(start);
		        		start = opStack.pop();
		        	}
		        }
		        // 그 외 연산자일 경우
		        else {
		        	//  우선순위 높거나 같으면 pop
		        	if(opPriority(s)>0) while(!opStack.isEmpty() && opPriority(opStack.peek())>=opPriority(s)) {
		        		output.add(opStack.pop());
		        	}
		        	// 우선순위 낮거나 stack 비어있으면 push
		        	if(opPriority(s)>0) opStack.push(s);
		        }
		    }			
		}
		// stack에 남아있는 연산자 output에 추가
		while (!opStack.isEmpty()) {
			output.add(opStack.pop());
		}
		System.out.println(output);
		return calculator();
	}
	
	
	
	// 후위연산식 계산
	public double calculator() {
		double a = 0.0;
		double b = 0.0;
		double tmp = 0.0;
		Stack<String> calStack = new Stack<>();
		Function func = new Function();
		
		for(int i =0; i <output.size(); i++) {
			String s = output.get(i);
			
			// 숫자일 경우
			try {
		        Double.parseDouble(s);
		        calStack.push(s);
		    } 
			// 숫자가 아닐 경우
			catch(NumberFormatException e) { 
				
				switch(s) {
					case "+":
						if(calStack.size()>1) {
							b = Double.parseDouble(calStack.pop());
							a = Double.parseDouble(calStack.pop());
							tmp = func.sum(a, b);
							calStack.add(String.valueOf(tmp));
						} break;
					case "-":
						if(calStack.size()>1) {
							b = Double.parseDouble(calStack.pop());
							a = Double.parseDouble(calStack.pop());
							tmp = func.sub(a, b);
							calStack.add(String.valueOf(tmp));
						} break;
					case "*":
						if(calStack.size()>1) {
							b = Double.parseDouble(calStack.pop());
							a = Double.parseDouble(calStack.pop());
							tmp = func.mul(a, b);
							calStack.add(String.valueOf(tmp));
						} break;
					case "/":
						if(calStack.size()>1) {
							b = Double.parseDouble(calStack.pop());
							a = Double.parseDouble(calStack.pop());
							tmp = func.div(a, b);
							calStack.add(String.valueOf(tmp));
						} break;
					case "%":
						if(calStack.size()>1) {
							b = Double.parseDouble(calStack.pop());
							a = Double.parseDouble(calStack.pop());
							tmp = func.mod(a, b);
							calStack.add(String.valueOf(tmp));
						} break;
					case "^":
						if(calStack.size()>1) {
							b = Double.parseDouble(calStack.pop());
							a = Double.parseDouble(calStack.pop());
							tmp = func.pow(a, b);
							calStack.add(String.valueOf(tmp));
						} break;
					case "l":
						if(calStack.size()>1) {
							a = Double.parseDouble(calStack.pop());
							b = Double.parseDouble(calStack.pop());
							tmp = func.log(a, b);
							calStack.add(String.valueOf(tmp));
						} break;
					case "a":
						if(calStack.size()>0) {
							a = Double.parseDouble(calStack.pop());
							tmp = func.abs(a);
							calStack.add(String.valueOf(tmp));
						} break;
					case "d":
						if(calStack.size()>0) {
							a = Double.parseDouble(calStack.pop());
							tmp = func.rad(a);
							calStack.add(String.valueOf(tmp));
						} break;
					case "!":
						if(calStack.size()>0) {
							a = Double.parseDouble(calStack.pop());
							tmp = func.fac(a);
							calStack.add(String.valueOf(tmp));
						} break;
					case "s":
						if(calStack.size()>0) {
							a = Double.parseDouble(calStack.pop());
							tmp = func.sin(a);
							calStack.add(String.valueOf(tmp));
						} break;
					case "c":
						if(calStack.size()>0) {
							a = Double.parseDouble(calStack.pop());
							tmp = func.cos(a);
							calStack.add(String.valueOf(tmp));
						} break;
					case "t":
						if(calStack.size()>0) {
							a = Double.parseDouble(calStack.pop());
							tmp = func.tan(a);
							calStack.add(String.valueOf(tmp));
						} break;
					case "e":
							tmp = Math.E;
					        calStack.push(String.valueOf(tmp));
					        break;
					case "p":
							tmp = Math.PI;
					        calStack.push(String.valueOf(tmp));
					        break;
					case "r":
						if(calStack.size()>1) {      

							a = Double.parseDouble(calStack.pop());
							b = Double.parseDouble(calStack.pop());
							tmp = func.root(a,b);
							calStack.add(String.valueOf(tmp));
						} break;
				}
			}
			
		}
		// 결과 return
		if(!calStack.isEmpty()) {
			return Double.parseDouble(calStack.get(0));
		} else {
			return Double.parseDouble("0");
		}
	}
	
	
	
}
