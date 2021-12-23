package Java_Slang_Word;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class HistorySlangWord {
    private String slang;
    private String definition;
    private String time;
    private String keywordSearched;

    HistorySlangWord(String time, String keywordSearched, String slang, String definition){
        this.slang = slang;
        this.definition = definition;
        this.time = time;
        this.keywordSearched = keywordSearched;
    }

    public String getSlang() {
        return slang;
    }

    public String getDefinition() {
        return definition;
    }

    public String getTime() {
        return time;
    }

    public String getKeywordSearched() {
        return keywordSearched;
    }

    //    private HashSet<String> historyList;
//
//    public HistorySlangWord(){
//        historyList = new HashSet<>();
//    }
//
//    public void addSlangWord(String s, List<String> y){
//        String item = s + ": " + y;
//        historyList.add(item);
//    }
//
//    public void exportHistory(){
//        for(String item :historyList){
//            System.out.println(item);
//        }
//    }
}