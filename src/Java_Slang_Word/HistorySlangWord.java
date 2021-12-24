package Java_Slang_Word;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.PublicKey;

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



}