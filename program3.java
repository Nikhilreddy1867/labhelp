import java.util.*;
public class program3 {
    static int timer=0;
    private static void rec(int node,int parent,List<List<Integer>> adj,int[] tin,int[] low,int[] mark,int[] vis){
        vis[node]=1;
        tin[node]=low[node]=timer++;
        int child=0;
        for(int i=0;i<adj.get(node).size();i++){
            int n_node=adj.get(node).get(i);
            if(n_node==parent) continue;
            if(vis[n_node]==0){
                rec(n_node,node,adj,tin,low,mark,vis);
                low[node]=Math.min(low[node],low[n_node]);
                if(parent!=-1 && low[n_node]>=tin[node]){
                    mark[node]=1;
                }
                child++;
            }
            else{
                low[node]=Math.min(low[node],tin[n_node]);
            }
        }
        if(parent==-1 && child>1){
            mark[node]=1;
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();
        int E=sc.nextInt();
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<E;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        int[] vis=new int[V];
        int[] tin=new int[V];
        int[] low=new int[V];
        int[] mark=new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                rec(i,-1,adj,tin,low,mark,vis);
            }
        }
        boolean found=false;
        for(int i=0;i<V;i++){
            if(mark[i]==1){
                System.out.print(i+" ");
                found=true;
            }
        }
        if(!found){
            System.out.println(-1);
        }
    }
}
