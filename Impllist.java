public class Impllist {
    Node head;

    public Impllist() {
        this.head = null;
    }

    public static class Node {
        int data;
        Node next;
        
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = this.head;
        this.head = new_node;
    }

    public void printList() {
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void insertionSort() {
        if (this.head == null || this.head.next == null) {
            return;
        }
        
        Node sorted_list = null;
        
        Node curr = this.head;
        while (curr != null) {
            Node next_node = curr.next;
            
            sorted_list = sortedInsert(sorted_list, curr);
            
            curr = next_node;
        }
        
        this.head = sorted_list;
    }
    
    public Node sortedInsert(Node sorted_list, Node new_node) {
        if (sorted_list == null || sorted_list.data >= new_node.data) {
            new_node.next = sorted_list;
            sorted_list = new_node;
            return sorted_list;
        }
        
        Node curr = sorted_list;
        while (curr.next != null && curr.next.data < new_node.data) {
            curr = curr.next;
        }
        
        new_node.next = curr.next;
        curr.next = new_node;
        
        return sorted_list;
    }
    
    public static void main(String[] args) {
        Impllist llist = new Impllist();
        llist.push(10);
        llist.push(30);
        llist.push(20);
        llist.push(50);
        llist.push(40);
        
        System.out.println("Original linked list:");
        llist.printList();
        
        llist.insertionSort();
        
        System.out.println("Sorted linked list:");
        llist.printList();
    }    
}