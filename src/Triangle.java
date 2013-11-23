import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Result {
	int sum;
	ArrayList<Integer> chain;
	public Result(int sum, ArrayList<Integer> chain){
		this.sum=sum;
		this.chain=chain;
	}
}
public class Triangle {
	/*
	Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

	For example, given the following triangle
	[
	     [2],
	    [3,4],
	   [6,5,7],
	  [4,1,8,3]
	]
	
	The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
	*/
	
	
	public static void main(String[] args) {
		 List<Integer> a1=Arrays.asList(2);
		 List<Integer> a2=Arrays.asList(3,4);
		 List<Integer> a3=Arrays.asList(6,5,7);
		 List<Integer> a4=Arrays.asList(4,1,8,3);
		 ArrayList<ArrayList<Integer>> aa = new ArrayList<ArrayList<Integer>>();

		
		 aa.add(new ArrayList(a1));
		 aa.add(new ArrayList(a2));
		 aa.add(new ArrayList(a3));
		 aa.add(new ArrayList(a4));
		 Result r = f(aa);
		 System.out.println(r.sum);
		 for(int i: r.chain){
			 System.out.print(i);
			 System.out.print(" ");
		 }
		 

	}
	static Result f(ArrayList<ArrayList<Integer>> chains){
		 
		if(chains == null){
			throw new IllegalArgumentException();
		}
		ArrayList<Integer> bottom = chains.get(chains.size()-1);
		Result[] r = new Result[bottom.size()];
		for(int i=0;i<bottom.size();i++){
			ArrayList<Integer> array = new ArrayList<Integer>();
			array.add(bottom.get(i));
			r[i] = new Result(bottom.get(i), array);
		}
		
		for(int i=chains.size()-2;i>=0;i--){
			ArrayList<Integer> current = chains.get(i);
			for(int j=0;j<current.size();j++){
				int index=r[j].sum<r[j+1].sum? j: j+1;
				r[j].sum = current.get(j)+r[index].sum;
				ArrayList<Integer> chain = new ArrayList<Integer>();
				chain.add(current.get(j));
				chain.addAll(r[index].chain);
				r[j].chain = chain;
			}
			
		}
		return r[0];
	}
	
	

}
