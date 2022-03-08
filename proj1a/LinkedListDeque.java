       /*
        DLList<String> d2 = new DLList<>("hello");
        d2.addLast("world");

        DLList<Integer> d1 = new DLList<>(5);
        d1.insertFront(10);
       */

public class LinkedListDeque<T> {

    private int size;
    private IntNode<T> sentinel;

    public class IntNode<T> {
        public IntNode<T> prev;
        public T item;
        public IntNode<T> next;

        public IntNode(T i, IntNode<T> pre, IntNode<T> nex) {
            this.item = i;
            this.next = nex;
            this.prev = pre;
        }
    }

    public LinkedListDeque() {
        sentinel = new IntNode<>(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /*
    public LinkedListDeque(T i) {
        sentinel = new IntNode<> (null, null, null);
        sentinel.next = new IntNode (i, null, null);
    }
    */

    public void addFirst(T item) {
        IntNode<T> temp;

        if (size == 0) {
            temp = new IntNode<>(item, sentinel, sentinel);
            sentinel.prev = sentinel.next = temp;
        } else {
            temp = sentinel.next;
            sentinel.next = new IntNode<>(item, sentinel, temp);
            temp.prev = sentinel.next;
        }

        size = size + 1;
    }

    public boolean isEmpty() {
       return (size == 0);
    }


    public void addLast(T item) {
        IntNode<T> temp;

        if (size == 0) {
            temp = new IntNode<>(item, sentinel, sentinel);
            sentinel.prev = sentinel.next = temp;
        } else {
            temp = new IntNode<>(item, sentinel.prev, sentinel);
            sentinel.prev.next = temp;
            sentinel.prev = temp;
        }

        size = size + 1;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        IntNode<T> temp = sentinel.next;
        int counter = size;
        while (counter > 0 ){
            System.out.print(temp.item + " ");
            temp = temp.next;
            counter = counter - 1;
        }
        System.out.println();
    }

    public T removeFirst(){
        if (size == 0){
            return null;
        }else if (size == 1){
            IntNode<T> tmp = sentinel.next;
            sentinel.prev = sentinel;
            sentinel.next = sentinel;
            size = size - 1;
            return tmp.item;
        }else {
            IntNode<T> tmp = sentinel.next;
            sentinel.next.next.prev = sentinel;
            sentinel.next = sentinel.next.next;
            size = size - 1;
            return tmp.item;
        }
    }

    public T removeLast(){
        if (size == 0){
            return null;
        }else if (size == 1){
            IntNode<T> tmp = sentinel.next;
            sentinel.prev = sentinel;
            sentinel.next = sentinel;
            size = size - 1;
            return tmp.item;
        }else {
            IntNode<T> tmp = sentinel.prev;
            sentinel.prev.prev.next = sentinel;
            sentinel.prev = sentinel.prev.prev;
            size = size - 1;
            return tmp.item;
        }


    }

    public T get(int index) {
        if ((index == 0) || (index > size)){
            return null;
        }else {
            IntNode<T> temp = sentinel;

            while (index > 0){
                temp = temp.next;
                index = index - 1;
            }
            return temp.item;
        }

    }

    /*
    public T getRecursive(int index) {
        if ((index == 0) || (index > size)){
            return null;
        }else {
            if (index == 1){
                return sentinel.next.item;
            } else {
                IntNode<T> temp = sentinel.next.next;
                temp = temp.next;
                temp = getRecursive(index -1);
            }

    }
    */

    public LinkedListDeque(LinkedListDeque other) {

        sentinel = new IntNode<>(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
        int index = other.size;

        for (int i = 1; i < index + 1; i++) {
            addLast((T)other.get(i));
        }

    }


}


