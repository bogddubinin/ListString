            /*
Блок:
    class StringItem1
    {
        private char [] symbols = new char[16];
        private StringItem1 item;
        private byte size;
    }

Строка:
    class ListString1{
        private StringItem1 head;
    }
--------------------------------------------------------------------------------
Операции
    int length(); //длина строки
    char charAt(int index); // символ в строке в позиции index
    void setCharAt(int index, char ch); //заменить символ в позиции index на ch
    ListString1 substring(int start, int end); //взятие подстроки, от start до end, не включая end
    void append(char ch); //добавить в конец символ
    void append(ListString1 string); //добавить в конец строку ListString1
    void append(String string); //добавить в конец строку String
    void insert(int index, ListString1 string); //вставить в строку в позицию index строку ListString1
    void insert(int index, String string); //вставить в строку в позицию index строку String
    public String toString() //переопределить метод
*/
package MyString;
import java.lang.String;

public class ListString{
    private StringItem head;
    
    public ListString(){}
    
    public ListString(char[] C){
        head = new StringItem(C); 
    }
    
    public ListString(StringItem head){
        this.head = new StringItem(head);
    }
    
    public ListString(ListString list){
        this(list.head);
    }
    
    public ListString(String s){
        head = new StringItem(s.toCharArray());
    }
    
    public void print(){
        StringItem next = head;
        while(next != null){
            next.print();
            next = next.get_next();
        }
//        
//        System.out.println();
//        next = head;
//        while (next != null){
//            System.out.print("[0123456789ABCDEF]");
//            next = next.get_next();
//        }
    }
    
    public StringItem get_head(){
        return head;
    }
    //-----------------------------------
    
    public int length(){
        StringItem item = head;
        int l = 0;
        while (item != null){
            item.compress();
            l += item.get_size();
            item = item.get_next();
        } 
        return l;
    }
    
    public char charAt(int index){
        if (index <= 0) return 0;
        StringItem item = head;
        int i = item.get_size();
        while (i < index){
            item = item.get_next(); // одинаковые задачи на поиск элемента с нужным индексом
            i += item.get_size();
        }
        return item.get_char((byte) ((index-1)%16));
    }
    
    void setCharAt (int index, char ch){
        if (index <= 0) return;
        StringItem item = head;
        int i = item.get_size();
        while (i < index){
            item = item.get_next(); // одинаковые задачи на поиск элемента с нужным индексом
            i += item.get_size();
        }
        
        item.set_char((byte) ((index-1)%16), ch);
    }
    public ListString substring(int start, int end){  // одинаковые задачи на поиск элемента с нужным индексом
        StringItem head = this.head;
        int i = head.get_size();
        byte st_ix = (byte)((start-1)%head.get_const()), 
             en_ix = (byte)((end-1)%head.get_const());
        
        System.out.println("en_ix = "+en_ix);
        System.out.println("i = "+i);
        while (i < start){
            head = head.get_next(); // поиск индекса
            i += head.get_size();
        }
        
        if (i >= end){ 
            head = new StringItem(head.copy_symbols(st_ix, en_ix), null, 
                                 (byte) head.copy_symbols(st_ix, en_ix).length);
            return new ListString(head);
        }
        
        StringItem tail = head;
        while (i < end){
            tail = tail.get_next();
            i += tail.get_size();
        }
                
        head = new StringItem(head.symbols_after(st_ix), 
                              head.get_next(),
                             (byte) head.symbols_after(st_ix).length);
        StringItem next = head;

        while (next.get_next() != tail){
            next.change_next(new StringItem(next.get_next()));
            next = next.get_next();
        }
        
        next.change_next(new StringItem(tail.symbols_before(en_ix), null, (byte) tail.symbols_before(en_ix).length));
        return new ListString (head);
    }
    
    public void append(String s){
        StringItem new_item = new StringItem(s.toCharArray());
        head.last_item().bond(new_item);
    }
    
    public void append(char ch){
        StringItem tail = head.last_item();
        if (tail.get_size() > tail.get_const()){ //full?
            tail.set_char((byte)(tail.get_size() - 1), ch);
        }
        else{
            tail.change_next(new StringItem(new char[] {ch}, null, (byte) 1));
        }
    }
    
    
}
/*
        System.out.print("Head start: "+head);//
        
        System.out.println("Начальная i: "+i); //
        System.out.println("While i: "+i);//
        
        System.out.println("_______________________");//
        head.print();//
        System.out.println("_______________________");//

        StringItem head = this.head;
        int i = head.get_size();
        
        while (i < start){
            head = head.get_next();
            i += head.get_size();
        }

        head = head.copy_start((byte) ((start-1)%16));
        StringItem tail = head.get_next();

        i += tail.get_size();
        
        while (i < end){
            tail = tail.get_next();
            i += tail.get_size();
        }
        tail = tail.copy_end((byte) ((end)%16));
        
        return new ListString(head);
        
*/
