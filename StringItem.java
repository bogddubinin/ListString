/*
Блок:
    class StringItem
    {
        private char [] symbols = new char[16];
        private StringItem next;
        private byte size;
    }

Строка:
    class ListString1{
        private StringItem head;
    }
--------------------------------------------------------------------------------
Операции
    int length(); //длина строки
    char charAt(int index); // символ в строке в позиции index
    void setCharAt(int index, char ch); //заменить символ в позиции index на ch
    ListString1 substring(int start, int end); //взятие подстроки, от start до end, не включая
    end
    void append(char ch); //добавить в конец символ
    void append(ListString1 string); //добавить в конец строку ListString1
    void append(String string); //добавить в конец строку String
    void insert(int index, ListString1 string); //вставить в строку в позицию index строку ListString1
    void insert(int index, String string); //вставить в строку в позицию index строку String    
    public String toString() //переопределить метод
 */
package MyString;

public class StringItem {
    final byte n = 16;
    private char [] symbols = new char[n];
    private StringItem next;
    private byte size;
    
    //*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*//
    public StringItem(){}
    
    public StringItem(StringItem item){
        this.fill_symbols(item.symbols);
        this.next = new StringItem(next);
        this.size = item.size;
    }
    
    public StringItem(String string){ //проверка k 2 раза
        int k = string.length();
        if (k > n){
            this.fill_symbols(string.toCharArray());
            next = new StringItem(string.substring(n));
            size = n;
        }
        else{
            fill_symbols(string.toCharArray(), (byte) k);
            next = null;
            size = (byte) k;
        }
    }
    //*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*//
    
    public void fill_symbols(char[] c, byte start, byte end){
        byte i;
        start--;
        end--;
        for (i = start; i < end; i++){
            symbols[i] = c[i-start];
        }
    }
    
    public void fill_symbols(char[] c, byte end){ // заполняет symbols c 0 до end
        byte i;                                   // с 
        end--;
        for (i = 0; i < end; i++){
            symbols[i] = c[i];
        }
    }
    
    public void fill_symbols(char[] c){ // заполняет весь symbols до n
        byte i;
        for (i = 0; i < n; i++){
            symbols[i] = c[i];
        }
    }
    
    public void print(){
        System.out.print("[");
        System.out.print(symbols);
        System.out.print("]");
    }
    
    public StringItem get_next(){
        return next;
    }
    
    public char get_char(byte index){
        return symbols[index];
    }
    
    public byte get_size(){
        return size;
    }
    
    public void compress(){
        byte i;
        for (i = size; i < n; i++){
            symbols[i] = next.symbols[i-size];
        }
        next.fill_simbols(symbols, (byte) (size),);
    }
}
