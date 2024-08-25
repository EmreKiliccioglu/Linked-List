package linkedlist;
public class LinkedList {

    public static void main(String[] args) {
      
        LinkedList linkedList = new LinkedList();
      
        linkedList.addFirst(20);
        System.out.print("20 sayisini listenin basina ekle = ");
        linkedList.print();
        
        linkedList.addFirst(10);
        System.out.print("10 sayisini listenin basina ekle = ");
        linkedList.print();
        
        linkedList.addLast(30);
        System.out.print("30 sayisini listenin sonuna ekle = ");
        linkedList.print();
        
        linkedList.addLast(40);
        System.out.print("40 sayisini listenin sonuna ekle = ");
        linkedList.print();
        
        linkedList.addFirst(5);
        System.out.print("5 sayisini listenin basina ekle = ");
        linkedList.print();
        
        linkedList.add(4,25);
        System.out.print("25 sayisini listenin 4. indeksine ekle = ");
        linkedList.print();
        
        linkedList.deleteFirst();
        System.out.print("Listenin ilk elemanini sil = ");
        linkedList.print();
        
        linkedList.deleteLast();
        System.out.print("Listenin son elemanini sil = ");
        linkedList.print();
    }
    
    class Node  // Dügümün olusturuldugu sinif 
    {
        int val;
        Node next;
        
        public Node(int val)
        {
            this.val = val;
            this.next = null;
        }  
    }
    
    private Node head; // Listenin ilk dügümü 
    private Node tail; // Listenin son dügümü
    
    public void addFirst(int val) //Listenin basina eleman ekleme metodu
    {
        if(isEmpty())
        {
            head = new Node(val);
            tail = head;
            return;
        }
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }
    
    public void addLast(int val) // Listenin sonuna eleman ekleme metodu
    {
        if(isEmpty())
        {
            head = new Node(val);
            tail = head;
            return;
        }
        Node newNode = new Node(val);
        tail.next = newNode;
        tail = newNode;
    }
    
    public void add(int pos , int val) // Listenin istenilen indeksine eleman ekleme metodu
    {
        if(pos == 1)
        {
            addFirst(val);
            return;
        }
        Node current = head;
        int count = 1;
        while(count < pos-1)
        {
            count++;
            current = current.next;
        }
        Node newNode = new Node(val);
        newNode.next = current.next;
        current.next = newNode;
    }
    
    public int deleteFirst() // Listenin ilk dügümünü silme metodu
    {
        if(isEmpty())
        {
            throw new RuntimeException("Liste Bos");
        }
        Node current = head;
        head = head.next;
        current.next = null;
        if(isEmpty())
        {
            tail = null;
        }
        return current.val;
    }
    
    public int deleteLast() // Listenin son dügümünü silme metodu
    {
        if(isEmpty())
        {
            throw new RuntimeException("Liste Bos");
        }
        if(head== tail)
        {
            int val = head.val;
            head = null;
            tail = null;
            return val;
        }
        Node current = head;
        Node prev = null;
        while(current.next != null)
        {
            prev = current;
            current = current.next;
        }
        prev.next = null;
        tail = prev;
        return current.val;     
    }
    
    public int delete(int pos) // Listenin istenilen indeksindeki dügümü silme metodu
    {
        if(isEmpty())
        {
            throw new RuntimeException("Liste Bos");
        }
        if(pos == 1)
        {
            deleteFirst();
        }
        Node current = head;
        Node prev = null;
        int count = 1;
        
        while(count < pos)
        {
            count++;
            prev = current;
            current = current.next;
        }
        prev.next = current.next;
        current.next = null;
        return current.val;     
    }
    
    public boolean search(int val) // Liste icinde eleman arama metodu
    {
        Node current = head;
        while(current != null)
        {
            if(val == current.val)
            {
                return true;
            }
            current = current.next;
        }
       return false;
    }
    
    public boolean isEmpty() // Liste bos mu kontrol metodu
    {
        return head == null;
    }
   
    public void print() // Listenin elemanlarini yazdirma metodu
    {
        Node current = head;
        
        while(current != null)
        {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }
}
