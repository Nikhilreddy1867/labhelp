import java.util.*;
class TreeNode{
    TreeNode left,right;
    int data;
    TreeNode(int n){
        left=right=null;
        this.data=n;
    }
}
public class program6 {
    private static TreeNode insert(TreeNode root,Integer val){
        if(root==null) return new TreeNode(val);
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp.left==null){
                temp.left=new TreeNode(val);
                break;
            }
            else{
                q.offer(temp.left);
            }
            if(temp.right==null){
                temp.right=new TreeNode(val);
                break;
            }
            else{
                q.offer(temp.right);
            }
        }
        return root;
    }
    private static TreeNode search(TreeNode root,int val){
        if(root==null) return null;
        if(root.data==val) return root;
        TreeNode left=search(root.left,val);
        if(left!=null){
            return left;
        }
        return search(root.right,val);
    }
    private static TreeNode helper(TreeNode root,TreeNode q,TreeNode p){
        if(root==null){
            return null;
        }
        if(root==p || root==q){
            return root;
        }
        TreeNode left=helper(root.left,q,p);
        TreeNode right=helper(root.right,q,p);
        if(left!=null && right!=null) return root;
        if(left!=null) return left;
        else{
            return right;
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] arr=sc.nextLine().split(" ");
        TreeNode root=null;
        for(String s:arr){
            root=insert(root,Integer.parseInt(s));
        }
        TreeNode p=search(root,sc.nextInt());
        TreeNode q=search(root,sc.nextInt());
        TreeNode ans=helper(root,p,q);
        if (ans != null)
            System.out.println("Lowest Common Ancestor is: " + ans.data);
        else
            System.out.println("No LCA found");

    }
}
