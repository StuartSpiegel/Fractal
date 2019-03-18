//stuart spiegel
public class ComplexNumber {
//fields
	private double a;
	private double b;
	
	//constructor
	public ComplexNumber(double a, double b){
		this.a = a;
		this.b = b;
		
		
	}
	
	//method for squaring a complex number
	 public ComplexNumber square(){
	        return new ComplexNumber(this.a*this.a - this.b*this.b, 2*this.a*this.b);
	    }
	 //method for adding two complex numbers
	 public ComplexNumber add(ComplexNumber com){
	        return new ComplexNumber(this.a+com.a, this.b+com.b);
	    }
	 
	public double magnitude() {
		
		return a*a+b*b;
	}

}
