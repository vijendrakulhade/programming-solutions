package com.kulhade.datastructure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTree<T extends Comparable<T>> {
    private BTNode<T> root;
    private class BTNode<T>{
        private T data;
        private BTNode<T> left;
        private BTNode<T> right;
        public BTNode(T t){
            this.data=t;
            this.left=null;
            this.right=null;
        }
        public BTNode<T> getLeft() {
            return left;
        }
        public BTNode<T> getRight() {
            return right;
        }
        public T getData(){return data;}
    }

    public void add(T t){
        this.root = this.add(this.root,t);
    }

    private BTNode<T> add(BTNode node,T t){
        if(node==null){
            return new BTNode<>(t);
        }
        if(node.right==null){
            node.right=add(node.right,t);
        }else{
            node.left=add(node.left,t);
        }
        return node;
    }

    public boolean isBalanced(){
        return isBalanced(this.root);
    }

    private boolean isBalanced(BTNode ptr){
        if(ptr==null) return true;

        if(height(ptr.left)-height(ptr.right)<=1 && isBalanced(ptr.left) && isBalanced(ptr.right))
            return true;
        return false;
    }

    public int balancedHeight(){
        return height(this.root);
    }

    private int height(BTNode node){
        if(node==null) return 0;
        return 1+Math.max(height(node.left),height(node.right));
    }

    public List<T> preOrder(){
        List<T> preOrderList = new ArrayList<T>();
        preOrder(root,preOrderList);
        return preOrderList;
    }

    private void preOrder(BTNode node,List<T> preOrderList){
        if(node!=null){
            preOrderList.add((T)node.getData());
            preOrder(node.left,preOrderList);
            preOrder(node.right,preOrderList);
        }
    }

    /**
     * This is preOrder traversal of the tree
     * @return
     */
    public String toString(){
        StringBuilder tree = new StringBuilder();
        BTNode ptr = this.root;
        if(ptr!=null) {
            ArrayDeque<BTNode> stack = new ArrayDeque<>();
            stack.push(ptr);
            while (!stack.isEmpty()) {
                BTNode temp = stack.pop();
                tree.append(temp.data).append(" ");
                if (temp.right != null) {
                    stack.push(temp.right);
                }
                if (temp.left != null) {
                    stack.push(temp.left);
                }
            }
            return tree.toString();
        }else{
            return String.valueOf(this.hashCode());
        }

    }


}
