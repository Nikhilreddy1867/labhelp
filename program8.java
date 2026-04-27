import java.util.*;
class DSU{
    int[] parent;
    DSU(int n){
        parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }
    int findPar(int i){
        if(parent[i]==i) return parent[i];
        return parent[i]=findPar(parent[i]);
    }
    void union(int u,int v){
        int pv=findPar(v);
        int pu=findPar(u);
        if(pv==pu) return;
        else if(pv>pu){
            parent[pv]=pu;
        }
        else{
            parent[pu]=pv;
        }
    }
}
class program8{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        String target=sc.next();
        DSU dsu=new DSU(26);
        for(int i=0;i<s1.length();i++){
            int ch1=s1.charAt(i)-'a';
            int ch2=s2.charAt(i)-'a';
            dsu.union(ch1,ch2);
        }
        String ans="";
        for(int i=0;i<target.length();i++){
            int temp=target.charAt(i)-'a';
            char ch=(char)(dsu.findPar(temp)+'a');
            ans+=ch;
        }
        System.out.println(ans);
    }
}