package Java_Slang_Word;

import java.io.*;
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

    public static void saveHistory(HistorySlangWord hsw){
        BufferedWriter bw = null;
        try {
            File file = new File("history.txt");
            if(file.createNewFile()){
                System.out.println("File has been create. ");
            }
            bw = new BufferedWriter(new FileWriter(file, true));
            bw.write(hsw.getTime() + ";" + hsw.getKeywordSearched()+ ";" + hsw.getSlang() + ";" + hsw.getDefinition() + "\n");
            bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void loadHistory(){
        BufferedReader br;
        try{
            File file = new File("history.txt");
            Main.historySlangWords = new ArrayList<>();
            if(file.exists()){
                br = new BufferedReader(new FileReader(file));
                String x = br.readLine();
                while (x!=null){
                    String[] his = x.split(";");
                    Main.historySlangWords.add(new HistorySlangWord(his[0], his[1], his[2], his[3]));
                    x = br.readLine();
                }

                br.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}