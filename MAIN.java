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
import java.lang.String;

public class MAIN {
    public static void main(String[] args){
        String str = "12345678901234567890";
        ListString list_1 = new ListString(str);
        ListString list_2 =  new ListString(list_1);
        list_1.print();
        list_2.print();
        
    }
}
