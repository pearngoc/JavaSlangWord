package Java_Slang_Word;

import java.util.ArrayList;

public class Main {
    public static  SlangWordList slangWordList;
    public static ArrayList<HistorySlangWord> historySlangWords;
    public static void main(String[] args){
        slangWordList = FileManager.readFile();
        historySlangWords = new ArrayList<>();
        new MainScreen();
        //HISTORY
//        HistorySlangWord y = new HistorySlangWord();
//
//        Scanner scanner = new Scanner(System.in);
//        int count = 10;
//        while(count != 0){
//            List<String> item = new ArrayList<>();
//            System.out.println("Input: ");
//            String slang = scanner.next();
//            item = x.searchSlang(slang);
//            y.addSlangWord(slang, item);
//            count--;
//        }
//
//        y.exportHistory();

        //x.exportListSlangWord();

        // SEARCH SLANG
//        List<String> y = new ArrayList<>();
//        y = x.searchSlang(">_>");

//            System.out.println(y);

        //SEARCH DEFINITION
//         ArrayList<String> y = x.searchDefinition("love you");
//        int n = y.size();
//        for(int i = 0; i < n; i++){
//            System.out.println(y.get(i) + ": " + x.searchSlang(y.get(i)) );
//        }

        //      ADD SLANG WORD
//        Scanner sc = new Scanner(System.in);
//        ArrayList<String> a = new ArrayList<>();
//        System.out.print("Nhap Slang: ");
//        String s = sc.nextLine();
//        while(true){
//            String def;
//            System.out.print("Nhap Definition: ");
//            def = sc.nextLine();
//            if(def.equals("-1"))
//                break;
//            a.add(def);
//        }
//        x.addSlangWord(new SlangWord(s, a));
//        List<String> y = new ArrayList<>();
//        y = x.searchSlang("ABC11");
//
//        System.out.println(y);

        //EDIT
//        Scanner sc = new Scanner(System.in);
//        List<String> y = new ArrayList<>();
//        y = x.searchSlang(">_>");
//
//        System.out.println(y);
//        //System.out.print("Enter new definition: ");
//
//        ArrayList<String> a = new ArrayList<>();
//        while(true){
//            String def;
//            System.out.print("Nhap Definition: ");
//            def = sc.nextLine();
//            if(def.equals("-1"))
//                break;
//            a.add(def);
//        }
//
//        x.addSlangWord(new SlangWord(">_>", a));
//
//        y = x.searchSlang(">_>");
//
//        System.out.println(y);

        // DELETE
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Moi ban nhap slang word muon xoa: ");
//        String s = sc.nextLine();
//
//        x.deleteSlangWord(s);
//
//        List<String> y = new ArrayList<>();
//        y = x.searchSlang(">_>");
//        System.out.println(y);

        //RESET
//        x = FileManager.readFile();
//
//        y = x.searchSlang("ABC11");
//
//        System.out.println(y);

        //RANDOM
//        String s = x.randomSlangWord();
//       System.out.println(x.getDefinition(s));

        //DO VUI VOI SLANG DOAN DEFINITION

        // Tạo danh sách các câu trả lời
//        Set<Object> ansObject = new HashSet<>();
//        while(ansObject.size() != 4){
//            String randomAns = x.randomSlangWord();
//            ArrayList<String> A = x.getDefinition(randomAns);
//            ansObject.add(A);
//        }
//
//        // đưa danh sách các câu trả lời vào mảng
//        Iterator<Object> i = ansObject.iterator();
//        ArrayList<String> ansQuestion = new ArrayList<>();
//        while(i.hasNext()){
//            ArrayList<String> b = (ArrayList<String>) i.next();
//            ansQuestion.add(String.join(" | ", b));
//        }
//
//        // khởi tạo đáp án ngẫu nhiên
//        Iterator<Object> k = ansObject.iterator();
//        Random rand = new Random();
//        int ans = rand.nextInt(4);
//        int count = 0;
//        String slang = null;
//       while(count != 4 && k.hasNext()){
//           if(ans == count){
//               ArrayList<String> aaa = (ArrayList<String>) k.next();
//               slang = x.getSlangWord(aaa);
//           }
//           k.next();
//           ++count;
//       }
//        System.out.println("What is definition " + slang + " ?");
//        System.out.println("1. " + ansQuestion.get(0));
//        System.out.println("2. " + ansQuestion.get(1));
//        System.out.println("3. " + ansQuestion.get(2));
//        System.out.println("4. " + ansQuestion.get(3));
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Your choice: ");
//        Integer yourAns = Integer.parseInt(sc.nextLine());
//        if(yourAns - 1 == ans){
//            System.out.println("Ban tra loi dung");
//        }else{
//            System.out.println("Ban tra loi sai");
//        }

        // DO VUI DEFINITION VỚI SLANG
    }
}

