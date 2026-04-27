import java.util.*;
class Node{
    Node[] links=new Node[26];
    boolean flag=false;
    public boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }
    public void put(char ch,Node node){
        links[ch-'a']=node;
    }
    public Node get(char ch){
        return links[ch-'a'];
    }
    public void setEnd(){
        flag=true;
    }
    public boolean isEnd(){
        return flag;
    }
}
class Trie{
    Node root;
    Trie(){
        root=new Node();
    }
    public void insert(String s){
        Node node=root;
        for(char ch:s.toCharArray()){
            if(!node.containsKey(ch)){
                node.put(ch,new Node());
            }
            node=node.get(ch);
        }
        node.setEnd();
    }
}
public class program5 {
    public static void main(String[] args){
        
        Scanner sc=new Scanner(System.in);
        String text=sc.nextLine();
        String[] arr=sc.nextLine().split(" ");
        List<int[]> ans=new ArrayList<>();
        Trie trie=new Trie();
        for(String s:arr){
            trie.insert(s);
        }
        for(int i=0;i<text.length();i++){
            Node node=trie.root;
            for(int j=i;j<text.length();j++){
                char ch=text.charAt(j);
                if(!node.containsKey(ch)) break;
                node=node.get(ch);
                if(node.isEnd()){
                    ans.add(new int[]{i,j});
                }
            }
        }
        for(int[] ar:ans){
            System.out.println("["+ar[0]+","+ar[1]+"]");
        }
    }
}
