package th.ac.kmutt.cpe.algorithm.thanaboon;

public class Node {

    public int freq;
    public char ch;
    public Node rNode;
    public Node lNode;

    public Node(int freq){
        this.freq = freq;
        this.lNode = null;
        this.rNode = null;
    }

    public Node(int freq,char ch){
        this.freq = freq;
        this.ch = ch;
        this.lNode = null;
        this.rNode = null;
    }

}
