import java.util.*;

import org.w3c.dom.Node;

public class Clone_Graph_133 {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        Map<Node,Node>hm=new HashMap<>();
        Queue<Node>q=new LinkedList<>();
        q.add(node);
        hm.put(node,new Node(node.val));
        while(q.isEmpty()==false){
            Node first=q.remove();
            Node firstClone=hm.get(first);
            for(Node cur:first.neighbors){
                Node curClone;
                if(hm.containsKey(cur)) curClone=hm.get(cur);
                else{
                    q.add(cur);
                    curClone=new Node(cur.val);
                    hm.put(cur,curClone);
                }
                firstClone.neighbors.add(curClone);
            }
        }
        return hm.get(node);
    }
}
