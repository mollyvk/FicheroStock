package calculos;

public class Preubas {

	public static void main(String[] args) {
	
		String st = "Pabloa";
		
		
		String substr = st.substring(0,5);
		System.out.println(substr.matches("^[A-z]{5}[-]*"));
		
	}
	
	
	
	
}
