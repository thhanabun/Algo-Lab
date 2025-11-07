package th.ac.kmutt.cpe.algorithm.thanaboon;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffManTree {
    public Node root;
    public Map<String,Character> encodedMap;
    
    public HuffManTree(){
        this.root = null;
        encodedMap = new HashMap<>();
    }

    public Node getRoot(){
        return this.root;
    }

    public char decode(String encoded){
        return encodedMap.get(encoded);
    }

    public void encode(String curStr,Node curNode){
        if(curNode.lNode == null && curNode.rNode == null){
            encodedMap.put(curStr,curNode.ch);
            return;
        }
        encode(curStr + '0', curNode.lNode);
        encode(curStr + '1', curNode.rNode);
    }

    public String encodeCh(char ch){
        for (String s : encodedMap.keySet()) {
            if(encodedMap.get(s) == ch){
                return s;
            }
        }
        return "";
    }
    public void buildTree(String str){
        Map<Character,Integer> freq = new HashMap<>();

        for (int i = 0; i < str.length() ; i++) {
            char curCh = str.charAt(i);
            freq.put(curCh,freq.getOrDefault(curCh, 0)+1);
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> {
            if(a.freq < b.freq) return -1;
            return 1;
        });

        for ( char ch :freq.keySet()){
            pq.add(new Node(freq.get(ch),ch));
        }

        while(pq.size()>=2){
            Node tempL = pq.poll();
            Node tempR = pq.poll();
            Node newNode = new Node(tempL.freq + tempR.freq);
            newNode.lNode = tempL;
            newNode.rNode = tempR;
            pq.add(newNode);
        }
        this.root = pq.poll();
    }

}
