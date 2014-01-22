import java.util.Arrays;


public class Multiplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(multi("99", "99"));

	}
	static String multi(String num1, String num2){
		
		int a[] =  new int[num1.length()+num2.length()];
		int carry  = 0;
		for(int i=0;i <a.length-1;i++){
		    int total = 0;
			for(int index1 = 0; index1<=i && index1<num1.length(); index1++){
				int index2 = i - index1;
				if(index2<num2.length()) {
				total += (num1.charAt(num1.length()-1- index1)-'0') * (num2.charAt( num2.length() - 1- index2)-'0');
				}
				
			}
			total+=carry;
			a[a.length-1- i]= total%10;
			carry = total/10;
		}
		a[0] = carry;
		String result  = Arrays.toString(a);
		return result;
	}
}
