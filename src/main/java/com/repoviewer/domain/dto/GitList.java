package com.repoviewer.domain.dto;

import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;

public class GitList<S> {

    private GitNode<S> firstNode;
    private GitNode<S> lastNode;

    public GitList() {
        firstNode = lastNode = null;
    }

    public boolean isEmpty(){
        return ((firstNode = lastNode) == null);
    }

    public void addFirst(GitNode<S> node, S s){
        if(isEmpty()){
            firstNode = lastNode = new GitNode<S>(node, s);
            return;
        }
        var currentNode = firstNode;

        firstNode = node;
        firstNode.nextNode = currentNode;

    }

    public void addLast(GitNode node, S s){
        if (isEmpty()){
            firstNode = lastNode = new GitNode(node, s);
            return;
        }
        var currentNode = lastNode;

        lastNode.nextNode = node;
        node.nextNode = currentNode;
    }

    public GitNode removeFirst(){
        return null;
    }
    public GitNode removeLast(){
        return null;
    }
    static class GitNode<T> {
        private GitNode<T> nextNode;
        private T data;

        public GitNode( GitNode node, T data) {
            this.nextNode = node;
            this.data = data;
        }

    }

    public static void main(String[] args){
        GitList<String> list = new GitList<>();

        GitNode<String> node1 = new GitNode<String>(null, "One");
        GitNode<String> node2 = new GitNode<String>( new GitNode<>(node1,"Two"),"Two");
        GitNode<String> node3 = new GitNode<String>( new GitNode<>(node2,"Three"),"Three");

    }

}
