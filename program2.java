import java.util.*;
public class program2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();
        int E=sc.nextInt();
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        int[] in=new int[V];
        for(int i=0;i<E;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            adj.get(a).add(b);
            in[b]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(in[i]==0){
                q.offer(i);
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            int temp=q.poll();
            ans.add(temp);
            for(int i=0;i<adj.get(temp).size();i++){
                int n_node=adj.get(temp).get(i);
                in[n_node]--;
                if(in[n_node]==0){
                    q.offer(n_node);
                }
            }
        }
        if(ans.size()!=V){
            System.out.println(-1);
        }
        else{
            for(int x:ans){
                System.out.print(x+" ");
            }
        }
    }
}
