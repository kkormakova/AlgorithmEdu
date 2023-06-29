package org.example;

import java.util.Iterator;
import java.util.LinkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList<Contact> contactList = new LinkedList<>();
        contactList.addToEnd(new Contact(1, "Петр Калинин", "+79176548890"));
        contactList.addToEnd(new Contact(2, "Василий Вакуленко", "+79365489033"));
        contactList.addToEnd(new Contact(3, "Мария Жаворонок", "+79078467635"));
        contactList.addToEnd(new Contact(4, "Иван Абрамов", "+75625477099"));
        contactList.addToEnd(new Contact(5, "Никита Полунин", "+79659085544"));

        for (Contact contact: contactList){
            System.out.println(contact);
        }
        contactList.reverse();
        System.out.println("--------------------------------");
        for (Contact contact: contactList){
            System.out.println(contact);
        }
    }
     static class Contact {
        int id;
        String name;
        String phone;

         public Contact(int id, String name, String phone) {
             this.id = id;
             this.name = name;
             this.phone = phone;
         }

         @Override
         public String toString() {
             return "Contact{" +
                     "id=" + id +
                     ", name='" + name + '\'' +
                     ", phone='" + phone + '\'' +
                     '}';
         }
     }
    public static class LinkedList<T> implements Iterable<T>{
        Node<T> head;
        Node<T> tail;

        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                Node<T> current = head;

                @Override
                public boolean hasNext() {
                    return current != null;
                }

                @Override
                public T next() {
                    T data = current.data;
                    current = current.next;
                    return data;
                }
            };
        }

        public static class Node<T>{
            T data;
            Node<T> next;
        }
        public boolean isEmpty(){
            return head == null;
        }
        public void addToEnd(T item){
            Node<T> newItem = new Node<>();
            newItem.data = item;
            if (isEmpty()){
                head = newItem;
                tail = newItem;
            } else {
                tail.next = newItem;
                tail = newItem;
            }
        }

        public void reverse(){
            if (!isEmpty() && head.next != null){
                tail = head;
                Node<T> current = head.next;
                head.next = null;
                while (current != null){
                    Node<T> next = current.next;
                    current.next = head;
                    head = current;
                    current = next;
                }
            }
        }
    }
}