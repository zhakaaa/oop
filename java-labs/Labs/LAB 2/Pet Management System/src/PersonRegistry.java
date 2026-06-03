import java.util.*;
public class PersonRegistry
{
    private class Node {
        private Node(Person data) {
            this.data = data;

        }
        public Person data;
        public Node next;
        public Node prev;
    }
    private class DoublyLinkedList {

        Node head = null;
        Node tail = null;

        public void add(Person val) {

            // Creating a new node
            Node temp = new Node(val);

            // Cheking if tail is null
            if(head == null) {
                head = tail = temp;
                head.prev = null;
                tail.next = null;
            }
            else{
                tail.next = temp;
                temp.prev = tail;
                tail = temp;
                tail.next = null;
            }
        }

        public void remove(Person val) {

            if (head == null) {
                return;
            }

            if (head == tail) {
                head = null;
                tail = null;
                return;
            }

            Node temp = tail;
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }

        public String registryInformation()
        {
            String result = "";
            Node current = head;
            while (current.next != null) {
                if(current.data.pet != null && current.next.data.pet == null) {
                    result += current.data.name + " has pet back";
                    break;
                }
                else if(current.next.data.pet != null && current.data.pet == null) {
                    result = current.data.name + " leaves pet to " + current.next.data.name;
                    break;
                }
                current = current.next;
            }

            return result;
        }
    }

    DoublyLinkedList list = new DoublyLinkedList();

    LinkedList <Person> people = new LinkedList<>();
//    Person person = null;

    public String registry() {
        return list.registryInformation();
    }


    public void addPerson(Person person){
//        this.person = person;
        people.add(person);
        list.add(person);
    }

    public void removePerson(Person person){
        people.remove(person);
        list.remove(person);
    }

    public void peopleWithoutPets(){
        for (Person p : people) {
            if(p.pet == null){
                System.out.println(p.name + " has not pet");
            }
        }
    }

    public void peopleWithPets(){
        for (Person p : people){
            if(p.pet != null){
                System.out.println(p.name + " has " + p.pet.getClass().getName() + " " + p.pet.name);
            }
        }
    }

    public void printAllInformation(){
        for (Person p : people){
            if(p.pet == null){
                System.out.println(p.name + " has not pet ");
            }
            else{System.out.println(p.name + " has " + p.pet.getClass().getName() + " " + p.pet.name);}
        }
    }
}