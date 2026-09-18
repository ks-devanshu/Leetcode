class Solution {
	private int[][] points;
	private class Edge{
		int i, j;
		int distance;
		
		public Edge(int i, int j) {
			this.i = i;
			this.j = j;
			distance = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
		}
	}
	
    public int minCostConnectPoints(int[][] points) {
    	this.points = points;
        
        Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x.distance));
        
        int n = points.length;
        
        for (int i = 1; i<n; i++)
        	queue.add(new Edge(0, i));
        
        int result = 0;
        Set<String> visited = new HashSet<>();
        visited.add(Arrays.toString(points[0]));
        
        while (!queue.isEmpty()) {
        	var current = queue.poll();
        	if (visited.contains(Arrays.toString(points[current.j])))
        		continue;

        	result += current.distance;
        	for (int i = 0; i<n; i++) {
        		queue.add(new Edge(current.j, i));
        	}
        	visited.add(Arrays.toString(points[current.j]));
        }
        
        return result;
    }
}