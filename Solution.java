class Solution {
	
	private class Node{
		int capital, profit;
		public Node(int capital, int profit) {
			this.capital = capital;
			this.profit = profit;
		}
	}
	
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Queue<Node> max = new PriorityQueue<>(Comparator.comparingInt(x -> x.profit));
        Queue<Node> min = new PriorityQueue<>(Comparator.comparingInt(x -> x.capital));
        
        for (int i = 0; i<profits.length; i++)
        	min.add(new Node(capital[i], profits[i]));
        
        while (k-- > 0) {
        	while (min.size() > 0 && min.peek().capital <= w) {
        		var top = min.poll();
        		top.profit *= -1;
        		max.add(top);
        	}
        	
        	if (max.size() == 0)
        		break;
        	
        	w += (-1) * max.poll().profit;
        }
        
        return w;
    }
}