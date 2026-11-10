class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Queue<String>> group = new HashMap<>();
        for (var ticket : tickets) {
            group.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            group.get(ticket.get(0)).add(ticket.get(1));
        }
        LinkedList<String> list = new LinkedList<>();
        helper("JFK", group, list);
        return list;
    }

    private void helper(String current, Map<String, Queue<String>> group, LinkedList<String> list) {
        var next = group.get(current);
        while (next != null && !next.isEmpty())
            helper(group.get(current).poll(), group, list);
        list.addFirst(current);
    }
}
