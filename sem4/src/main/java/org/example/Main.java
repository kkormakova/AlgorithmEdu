package org.example;

public class Main {
    public static void main(String[] args) {
        RedBlackTree <Integer> tree = new RedBlackTree<>();
        System.out.println(tree.add(6));
        System.out.println(tree.add(4));
        System.out.println(tree.add(2));
        System.out.println(tree.add(10));
        System.out.println(tree.add(17));
        System.out.println(tree.add(15));
        System.out.println(tree.add(20));
        System.out.println(tree.add(35));
        System.out.println("Количество нод в дереве = " + tree.counter());
    }
}