class SequenceItem{
    private String data;

    public SequenceItem(){}
    public SequenceItem(String d){
        data  = d;
    }
    public String getData(){
        return data;
    }
    public void setData(String d){
        data = d;
    }
    public boolean equals(SequenceItem s){
        return data.equals(s.getData());
    }
    public String toString(){
        return data;
    }
}

interface Sequence{
    void add(SequenceItem si);
    SequenceItem get(int i);
    void remove(SequenceItem si);
    boolean contains(SequenceItem si);
    int size();
    boolean isEmpty();
    SeqIterator iterator();
    SeqIterator reverseIterator();
    BiSeqIterator biIterator();
    SequenceItem[] toArray();
    boolean equals(Sequence s);
    String toString();
}

interface SeqIterator{
    boolean hasNext();
    SequenceItem next();
}

interface BiSeqIterator extends SeqIterator{
    boolean hasPrevious();
    SequenceItem previous();
}

public class LinkedSequence{

    private Node head;
    private int length = 0;

    class Node {
        private Node next;
        private Node previous;
        private SequenceItem content;
        public Node(SequenceItem c, Node n, Node p){
            next = n;
            previous = p;
            content = c;
        }

        public Node(SequenceItem c){
            content = c;
        }

        public Node(){ }

        public Node getNext(){
            return next;
        }
        public void setNext(Node nd){
            next = nd;
        }
        public Node getPrevious(){
            return previous;
        }
        public void setPrevious(Node nd){
            previous = nd;
        }
        public SequenceItem getContent(){
            return content;
        }
        public void setContent(SequenceItem s){
            content = s;
        }
    }

    public LinkedSequence(){
        head = new Node(new SequenceItem("HEAD"));
        head.setNext(head);
        head.setPrevious(head);
    }

    public void add(SequenceItem s){
        Node nd = new Node(s);
        Node tail = head.getPrevious();
        tail.setNext(nd);
        nd.setPrevious(tail);
        nd.setNext(head);
        head.setPrevious(nd);
        length += 1; 
    }

    public SequenceItem get(int i){
        if (i >= length){
            System.out.println("out of bound");
            return null;
        }
        SeqIterator it = iterator();
        SequenceItem r = null;
        while(it.hasNext()){
            r = it.next();
            if(i-- == 0)
                break;
        }
        return r;
    }

    public void remove(SequenceItem s){
        SeqIterator it = iterator();
        Node r = head;
        while(r != null){
            if(r.getContent().equals(s)){
                Node p = r.getPrevious();
                Node n = r.getNext();
                p.setNext(n);
                n.setPrevious(p);
                r.setNext(null);
                r.setPrevious(null);
                length--;
                break;
            }
            r = r.getNext();
        }
    }

    public boolean contains(SequenceItem s){
        SeqIterator it = iterator();
        boolean r = false;
        while(it.hasNext()){
            if(it.next().equals(s)){
                r = true;
                break;
            }
        }
        return r;
    }
    public int size(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public SeqIterator iterator(){
        return new SeqIterator(){
            private Node cur = head.getNext();
            public boolean hasNext(){
                return cur != head;
            }
            public SequenceItem next(){
                Node r = cur;
                cur = cur.getNext();
                return r.getContent();
            }
        };
    }

    public SeqIterator reverseIterator(){
        return new SeqIterator(){
            private Node cur = head.getPrevious();
            public boolean hasNext(){
                return cur != head;
            }
            public SequenceItem next(){
                Node r = cur;
                cur = cur.getPrevious();
                return r.getContent();
            }
        };
    }

    public BiSeqIterator biIterator(){
        return new BiSeqIterator(){
            private Node cur = head.getNext();
            public boolean hasNext(){
                return cur != head;
            }
            public boolean hasPrevious(){
                return cur != head;
            }
            public SequenceItem next(){
                Node r = cur;
                cur = cur.getNext();
                return r.getContent();
            }
            public SequenceItem previous(){
                Node r = cur;
                cur = cur.getPrevious();
                return r.getContent();
            }
        };
    }

    public SequenceItem[] toArray(){
        SequenceItem[] r = new SequenceItem[length];
        SeqIterator it = iterator();
        int i  = 0;
        while(it.hasNext()){
            r[i++] = it.next();
        }
        return r;
    }

    public boolean equals(LinkedSequence s){
        if (s.size() != length)
            return false;
        SeqIterator it = iterator();
        SeqIterator sit = s.iterator();
        boolean r = true;
        while (it.hasNext()){
            if(!it.next().equals(sit.next())){
                r = false;
                break;
            }
        }
        return r;
    }

    public String toString(){
        SeqIterator it = iterator();
        StringBuilder s = new StringBuilder();
        while (it.hasNext()){
            s.append(it.next()+"->");
        }
        return s.toString();
    }

    public static void main(String []args){
        LinkedSequence l = new LinkedSequence();
        LinkedSequence m = new LinkedSequence();
        l.add(new SequenceItem("1"));
        l.add(new SequenceItem("2"));
        l.add(new SequenceItem("3"));
        System.out.println(l);

        m.add(new SequenceItem("1"));
        m.add(new SequenceItem("2"));
        m.add(new SequenceItem("3"));
        System.out.println(m);
        System.out.println(l.equals(m));

        SeqIterator it = l.reverseIterator();
        while(it.hasNext())
            System.out.print(it.next() + " ");
        System.out.println("");

        BiSeqIterator bit = l.biIterator();
        while(bit.hasNext()){
            System.out.print(bit.next() + " ");
            System.out.print(bit.previous() + " ");
            System.out.print(bit.next() + " ");
        }
        System.out.println("");

        l.remove(new SequenceItem("2"));
        System.out.println(l);

        System.out.println("contains " + l.contains(new SequenceItem("1")));

        System.out.println("size " + l.size());

        System.out.println("empty " + l.isEmpty());

        System.out.println("get " + m.get(0));
        System.out.println("get " + m.get(1));
        System.out.println("get " + m.get(2));

        SequenceItem []sarray = m.toArray();
        for (SequenceItem s: sarray)
            System.out.println(s);
    }
}
