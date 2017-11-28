/**
 * Created by songchiyun on 2017. 11. 28..
 * problem : https://www.acmicpc.net/problem/1920
 */
import java.util.*;
public class findNum {
    static class Node{
        private int number;
        private Node leftNode, rightNode;
        Node(int number){
            this.number = number;
            this.leftNode = null;
            this.rightNode = null;
        }

        public int getNumber() {
            return number;
        }

        public Node getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }

        public Node getRightNode() {
            return rightNode;
        }

        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }
    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Node root = null;
        for(int i = 0;i<N;i++){
            int num = sc.nextInt();
            if(root == null){
                root = new Node(num);
                continue;
            }
            Node newNode = new Node(num);
            addNode(root, newNode);
        }

        int M = sc.nextInt();
        for(int i=0;i<M;i++){
            int num = sc.nextInt();
            if(findNum(root, num))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
    static boolean findNum(Node root, int num){
        Node node = root;
        while(node != null){
            if(node.getNumber() == num)
                return true;
            else if(node.getNumber() > num){
                node = node.getLeftNode();
            }
            else
                node = node.getRightNode();
        }
        return false;
    }
    static boolean addNode(Node root, Node newNode){

        Node node = root;
        while(true){
            if(node.getNumber() == newNode.getNumber())
                return false;
            else if(node.getNumber() < newNode.getNumber()){
                if(node.getRightNode() == null) {
                    node.setRightNode(newNode);
                    return true;
                }
                node = node.getRightNode();
            }
            else{
                if(node.getLeftNode() == null){
                    node.setLeftNode(newNode);
                    return true;
                }
                node = node.getLeftNode();
            }
        }
    }
}
