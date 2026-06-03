package Person;

import java.util.Collections;
import java.util.LinkedList;
import java.util.function.Consumer;

public class PersonRegistry implements IAddPerson, IRemovePerson, IShowPeopleList
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

            // Checking if tail is null
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

    // Первое использование встроенного интерфейса Collection
    LinkedList<Person> people = new LinkedList<>();

    public String registry() {
        return list.registryInformation();
    }

    @Override public void addPerson(Person person){
        people.add(person);
        list.add(person);
    }

    @Override public void removePerson(Person person){
        people.remove(person);
        list.remove(person);
    }

    @Override public void showPeopleWithoutPets(){
        Collections.sort(people);
        for (Person p : people) {
            if(p.pet == null){
                System.out.println(p.name + " has not pet");
            }
        }
    }

    @Override public void showPeopleWithPets(){
        Collections.sort(people);
        for (Person p : people){
            if(p.pet != null){
                System.out.println(p.name + " has " + p.pet.name);
            }
        }
    }

    @Override public void showAllPeople(){
        Consumer<String> printMessage = message -> System.out.println(message);
        Collections.sort(people);
        for (Person p : people){
            if(p.pet != null){
                printMessage.accept(p.name + " has " + p.pet.name);
            }
            else{printMessage.accept(p.name + " has not pet ");}
        }
    }
}