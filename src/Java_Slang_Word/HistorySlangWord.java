package Java_Slang_Word;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class HistorySlangWord {
    private HashSet<String> historyList;

    public HistorySlangWord(){
        historyList = new HashSet<>();
    }

    public void addSlangWord(String s, List<String> y){
        String item = s + ": " + y;
        historyList.add(item);
    }

    public void exportHistory(){
        for(String item :historyList){
            System.out.println(item);
        }
    }
}