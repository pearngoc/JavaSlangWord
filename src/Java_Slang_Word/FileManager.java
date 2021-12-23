package Java_Slang_Word;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class FileManager {
    public static SlangWordList readFile(){
        File file = new File("slang.txt");
        BufferedReader buff = null;
        boolean checkFile = file.exists();

        if(checkFile){
            List<String> arrayString = null;
            SlangWordList listSlangWord = new SlangWordList();
            try{
                String sla = null;
                buff = new BufferedReader(new FileReader(file));
                while(true){
                    sla = buff.readLine();
                    if(sla == null){
                        break;
                    }
                    int a = sla.indexOf('`');
                    if(a < 0){
                        System.out.println(sla);
                    }
                    // 0: slang, 1: definition
                    String slaItem[] = sla.split("`");

                    // process definition
                    String slaDefinition[] = slaItem[1].split("\\|");

                    arrayString = new ArrayList<String>();
                    for(String s : slaDefinition){
                        arrayString.add(s.trim());
                    }
                    listSlangWord.addSlangWord(new SlangWord(slaItem[0], arrayString));

                }
            }catch(Exception e){
                System.out.println(e);
            }
            return listSlangWord;
        }else{
            System.out.println("File not exists!!!");
            return null;
        }

    }
}