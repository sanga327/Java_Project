package com.example.project_2;
import java.lang.Math;


public class Function {
	public double sum(double x, double y) {  // x+y
        return x+y;
    }
	
	public double sub(double x, double y) {  // x-y
		return x-y;
	}
	
	public double mul(double x, double y) {  // x*y
		return x*y;
	}
	
	public double div(double x, double y) {  // x/y
		return x/y;
	}
	
	public double mod(double x, double y) {  // x%y
		return x%y;
	}
	
	public double pow(double x, double y) {  // x^y
		return Math.pow(x,y);
	}
	
	public double log(double x, double y) {   // logy(x)
		return Math.log(x) / Math.log(y);
	}

	public double abs(double x) {             // |x|
		return Math.abs(x);
	}
		
	public double fac(double x) {             // x!
		
		double tmp = Math.abs(x)-1;
		double res = Math.abs(x);
		
		while(tmp!=0){
			res *= tmp;
			tmp--;
		}
		if (x<0) {return -res;}
		else {return res;}
	}
	
	public double sin(double x) {             // sin(x)
		return Math.sin(x);
	}
	
	public double cos(double x) {             // cos(x)
		return Math.cos(x);
	}
	
	public double tan(double x) {             // tan(x)
		return Math.tan(x);
	}
	
	public double rad(double x) {        // 라디안값
		return Math.toRadians(x);        
	}

	public double root(double x, double y) {  //  x의 y제곱근
		return Math.pow(x, 1.0/y);            
	}
	

}






