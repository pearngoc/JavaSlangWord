package Java_Slang_Word;

import java.util.ArrayList;

public class Main {
    public static  SlangWordList slangWordList;
    public static ArrayList<HistorySlangWord> historySlangWords;
    public static void main(String[] args){
        slangWordList = FileManager.readFile(1);
        FileManager.loadHistory();
        new MainScreen();
    }
}

