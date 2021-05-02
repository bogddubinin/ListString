/*
Блок:
    class StringItem1
    {
        private char [] symbols = new char[16];
        private StringItem1 next;
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

public class StringItem{
    final byte n = 16;
    private char[] symbols = new char[n];
    private StringItem next;
    private byte size;
    
/*____________________________________________________________________________*/    
    public StringItem(){}
    
    public StringItem(char[] C){
        int i;
        if (C.length > n){
            for (i = 0; i < n; i++){
                symbols[i] = C[i];
            }
            char[] c1 = new char[C.length-n];
            for (i = 0; i < c1.length; i++){
                c1[i] = C[i+n];
            }
            next = new StringItem(c1);
            size = n;
        }
        else{
            for (i = 0; i < C.length; i++){
                symbols[i] = C[i];
            }
            next = null;
            size = (byte) C.length;
        }
    }
    
    public StringItem(char[] symbols, StringItem next, byte size){
        System.out.println("2!!!!!!2\n"+next+"\n2!!!!!!2");
        this.symbols = symbols;
        this.next = next;
        this.size = size;
    }
    
    public StringItem (StringItem item){
//        this(item.copy_symbols(), item.next, item.size);
        this(item.copy_symbols(), item.next,(byte) item.size);
        System.out.println("1!!!!!!1\n"+item.next+"\n1!!!!!!1");
//        symbols = item.copy_symbols();
//        next = item.next;
//        size = item.size;
    }
/*____________________________________________________________________________*/
    
    public void print(){
        System.out.print("[");
        for (char c : symbols){
            System.out.print(c);
        }
        System.out.print("]");
    }
    
    
    public StringItem get_next(){
        return next;
    }    
    public byte get_size(){
        return size;
    }    
    public int get_const(){
        return n;
    }    
    public char get_char(byte index){
        return symbols[index];
    }    
    public void set_char(byte index, char ch){
        symbols[index] = ch;
    }
    
    
    public void delete_next(){
        next = null;
    }
    public void change_next(StringItem item){
        next = item;
    }
    public void compress(){
        this.new Correct().compress();
    }
    public void bond(StringItem tail){
        next = tail;
    }
    
    
    public StringItem last_item(){
        StringItem item = this;
        
        while (item.get_next() != null){
            item = item.get_next();
        }
        return item;
    }
   
/*____________________________________________________________________________*/    
    public char[] copy_symbols(){
        char[] C = new char[n];
        byte i;
        for (i = 0; i < n; i++){
            C[i] = symbols[i];
        }
        return C;
    }
    
    public char[] copy_symbols(byte start, byte end){
        char[] C = new char[n];
        byte i;
        for (i = start; i < end; i++){
            C[i-start] = symbols[i];
        }
        return C;
    }
    
    public char[]  symbols_after(byte start){
        char[] C = new char[n];
        byte i;
        for (i = start; i < n; i++){
            C[i-start] = symbols[i];
        }
        return C;
    }
    
    public char[] symbols_before(byte end){
        char[] C = new char[n];
        byte i;
        for (i = 0; i < end; i++){
            C[i] = symbols[i];
        }
        return C;
    }
/*____________________________________________________________________________*/    
    
    
    private class Correct{
        
        private void cut_next_element(){
            StringItem newNext = next.next;
            next.next = null;
            next = newNext;
        }
        
        private void compress(){
            if (next == null) return;
            byte i;
            byte num = (byte) ((n - size) > next.size? next.size : (n - size));
            
            for (i = 0; i < num; i++){
                symbols[size+i] = next.symbols[i];
            }
            for (i = num; i < n; i++){
                symbols[i-num] = symbols[i];
            }
            
            next.size -= num;
            if (next.size < 1) next = null;
        }
    }
}
