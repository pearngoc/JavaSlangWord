package Java_Slang_Word;

import java.util.*;

public class SlangWordList {
    private HashMap<String, List<String>> listHashMap;

    public SlangWordList(){
        listHashMap = new HashMap<>();
    }
    public void addSlangWord(SlangWord sla){
        listHashMap.put(sla.getSlang(), sla.getDefinition());
    }

    public void deleteSlangWord(String slangWord){listHashMap.remove(slangWord);}
    public void exportListSlangWord(){
        Iterator iter = listHashMap.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry mapElement = (Map.Entry)iter.next();
            String slang = (String) mapElement.getKey();
            List<String> definition = (List<String>) mapElement.getValue();
            String def = "";
            for(String x: definition){
                def += x;
            }
            System.out.println(slang + ": " + def);
        }
    }

    public List<String> searchSlang(String slang){
        return listHashMap.get(slang);
    }
    public String getSlangWord(ArrayList<String> s){
        Iterator iter = listHashMap.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry mapElement = (Map.Entry)iter.next();
            String slang = (String) mapElement.getKey();
            List<String> definition = (List<String>) mapElement.getValue();
            if(definition.equals(s)){
                return slang;
            }
        }
        return null;
    }

    public ArrayList<String> searchDefinition(String definition){
        ArrayList<String> x = new ArrayList<>();
        definition = definition.toLowerCase();
        for(Map.Entry<String, List<String>> entry: listHashMap.entrySet()){
            List<String> def = entry.getValue();
            for(String item : def){
                item = item.toLowerCase();
                if(item.contains(definition)){
                    x.add(entry.getKey());
                }
            }
        }
        if(x.size() != 0) return x;
        else return null;
    }

    public String randomSlangWord(){
        Random r = new Random();
        String[] keyList = listHashMap.keySet().toArray(new String[0]);
        String randomSl = keyList[r.nextInt(listHashMap.size())];
        return randomSl;
    }

    public ArrayList<String> getDefinition(String slang){
        return (ArrayList<String>) listHashMap.get(slang);
    }



}