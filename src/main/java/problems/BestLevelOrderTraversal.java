package problems;

import java.util.Scanner;

class BestLevelOrderTraversal{

    static void levelOrder(Node root){
        //Write your code here
        for (int i=1; i<=getHeight(root); i++) {
            printLevel(root, i);
        }
    }

    static void printLevel(Node root, int level) {
        if (root == null)
            return;
        if (level == 1) {
            System.out.print(root.data + " ");
        } else if (level > 1) {
            printLevel(root.left, level - 1);
            printLevel(root.right, level - 1);
        }
    }


    public static int getHeight(Node root){
        //Write your code here
        if (root == null) {
            return 0;
        }

        int lefth = getHeight(root.left);
        int righth = getHeight(root.right);

        if (lefth > righth) {
            return lefth + 1;
        } else {
            return righth + 1;
        }
    }

    public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else{
            Node cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        Node root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        levelOrder(root);
    }
}
