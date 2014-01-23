
public class Stock3 {

	static class Transaction {
		int buy;
		int sell;
		public Transaction(int buy, int sell){
			
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max = maxProfit(new int[]{6,1,3,2,4,7});
		System.out.println(max);
	}
	
	static public int maxProfit(int[] prices) {
        if(prices == null || prices.length<2) {
            return 0;
        }
        int[] profitIndex  = maxProfit1(prices, 0, prices.length -1);
        int maxProfit = prices[profitIndex[1]] - prices[profitIndex[0]];
        if(maxProfit<=0){
            return 0;
        }
        
        int[] profitIndex1  = maxProfit1(prices, 0, profitIndex[0] -1);
        int profitLeft = -1;
        if(profitIndex1!=null){
        	profitLeft = prices[profitIndex1[1]] - prices[profitIndex1[0]];
        }
        
        int[] profitIndex2  = maxProfit1(prices, profitIndex[1] +1, prices.length-1);
        
        int profitRight = -1;
        if(profitIndex2!=null){
        	profitRight = prices[profitIndex2[1]] - prices[profitIndex2[0]];
        }
        int maxLR = Math.max(profitLeft, profitRight);
        if(maxLR>0){
        	maxProfit += maxLR;
        }
        int maxProfit2 = maxProfit2( prices, profitIndex[0], profitIndex[1]);
        return Math.max(maxProfit, maxProfit2);
        
        
    }
	
	static  int[] maxProfit1(int[] prices, int start, int end) {
		if(end-start+1<2){
			return null;
		}
	    int minIndex = start;
        int maxIndex = start+1;
     
        int minValIndex = prices[start]<prices[start+1]? start: start+ 1;
        for(int i=start+2; i<= end; i++){
        	int maxProfit = prices[maxIndex] - prices[minIndex];
        	if(prices[i]- prices[minValIndex]> maxProfit){
        		minIndex =  minValIndex;
        		maxIndex  = i;
        	} 
        	if(prices[i]<prices[minValIndex]){
        		minValIndex = i;
        	}
        }
        return new int[]{minIndex, maxIndex};
    }
	
	static  int maxProfit2(int[] prices, int start, int end) {
		if(end-start+1<4){
			return 0;
		}
	    int maxVal = prices[start+1];
        int maxProfit  = 0;
     
       
        for(int i=start+2; i<= end; i++){
        	int profit = maxVal - prices[start] + prices[end] - prices[i];
        	if(profit>maxProfit) {
        		maxProfit = profit;
        	}
        	if(maxVal<prices[i]){
        		maxVal = prices[i];
        	}
        }
        return maxProfit;
    }

}
