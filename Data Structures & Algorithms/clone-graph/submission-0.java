/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        
        Map<Node,Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        q.add(node);
        map.put(node, new Node(node.val));
        

        while(!q.isEmpty()){
            Node oldNode = q.poll();
            for(int i=0;i<oldNode.neighbors.size();i++){
                Node adjNode = oldNode.neighbors.get(i);
                if(!map.containsKey(adjNode)){
                    map.put(adjNode, new Node(adjNode.val));
                    q.add(adjNode);
                }
                map.get(oldNode).neighbors.add(map.get(adjNode));   
            } 
        }

        return map.get(node);
    }
}