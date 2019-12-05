package com.mypackage.algs4;

import com.sun.jdi.Value;

public class BST <Key extends Comparable<Key>,value> {
    private Node root;

    private class Node{
        private Key key;
        private Value val;
        private Node left, right;
        private int N;
        public Node(Key key,Value val,int N){
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    public int size(){
        return size(root);
    }

    public  int size(Node x){
        if (x == null)
            return 0;
        else
            return x.N;
    }

    public Value get(Key key){
        return get(root,key);
    }

    public Value get(Node x,Key key){
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return get(x.left,key);
        else if (cmp > 0)
            return get(x.right,key);
        else
            return x.val;
    }

    public void put(Key key,Value val){
        put(root,key,val);
    }

    public Node put(Node x, Key key, Value val){
        if (x == null)
            return new Node(key,val,1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = put(x.left,key,val);
        else if (cmp > 0)
            x.right = put(x.right,key,val);
        else
            x.val = val;
        x.N = size(x.left)+size(x.right)+1;
        return x;
    }

    public Key min(){
        return min(root).key;
    }

    public Node min(Node x){
        if (x.left == null)
            return x;
        return min(x.left);
    }

    public Key floor(Key key){
        Node x = floor(root,key);
        if(x == null)
            return null;
        return x.key;
    }

    public Node floor(Node x,Key key){
        if(x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return floor(x.left,key);
        if (cmp == 0)
            return x;
        Node t = floor(x.right,key);
        if (t != null)
            return t;
        else
            return x;
    }

    //选择
    public Key select(int k){
        return select(root,k).key;
    }

    public Node select(Node x,int k){
        if (x == null)
            return null;
        int t = size(x.left);
        if (t > k)
            return select(x.left,k);
        else if (t < k)
            return select(x.right,k-t-1);
        else
            return x;
    }

    //等级
    public int rank(Key key){
        return rank(root,key);
    }

    public int rank(Node x,Key key){
        if (x == null)
            return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return rank(x.left,key);
        else if (cmp > 0)
            return rank(x.right,key)+size(x.left)+1;
        else
            return size(x.left);
    }

    //删除
    public void deleteMin(){
        root = deleteMin(root);
    }

    public Node deleteMin(Node x){
        if (x.left == null)
            return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left)+size(x.right)+1;
        return x;
    }

    public void deleteMax(){
        root = deleteMax(root);
    }

    public Node deleteMax(Node x){
        if (x.right == null)
            return x.left;
        x.right = deleteMax(x.right);
        x.N = size(x.right)+size(x.left)+1;
        return x;
    }

    public void delete(Key key){
        root = delete(root,key);
    }

    public Node delete(Node x,Key key){
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return delete(x.left,key);
        else if (cmp > 0)
            return delete(x.right,key);
        else{
            if (x.left == null)
                return x.right;
            if (x.right == null)
                return x.left;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left  = t.left;
            x.N = size(x.right)+size(x.left);
            return x;
        }
    }

}
