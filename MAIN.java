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
        String s = "здесь точно больше шестнадцати букавак";
        String s1 = "12345678901234567";
        char[] c = s.toCharArray();
        ListString list_1 = new ListString(s);
        ListString list_2 = new ListString(s1);
        list_2.print();
        list_2 = list_2.substring(1,17);
        list_2.print();
    }
}
