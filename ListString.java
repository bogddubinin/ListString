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

public class ListString {
    StringItem head;
    
    //-------------------------------------//
    public ListString(){}
    public ListString(ListString list){
        this.head = new StringItem(list.head);
    }
    public ListString(String string){
        head = new StringItem(string);
    }
    //-------------------------------------//
    
    public void print(){
        StringItem next = head;
        while (next != null){
            next.print();
            next = next.get_next();
        }
        System.out.println();
    }
    
    public char charAt(int index){
        StringItem next = head;
        int i = next.get_size();
        
        while (i < index){
            next.compress();
            next = next.get_next();
            i += next.get_size();
        }
        
        return next.get_char((byte) (--index%16));
    }
    
    public void setCharAt(){
        
    }
}
