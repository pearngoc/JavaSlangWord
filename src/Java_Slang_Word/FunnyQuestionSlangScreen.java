package Java_Slang_Word;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class FunnyQuestionSlangScreen extends JFrame implements ActionListener {
    private JButton ans1, ans2, ans3, ans4, nextBtn, cancelBtn;
    private JLabel las, scoreLabel;
    public static  int ansOfQuestion;
    public static int score = 0;
    public FunnyQuestionSlangScreen(){
        setPreferredSize(new Dimension(1200,700));
        setTitle("Game: SlangWord");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(createAndShowGUI());
        setDefaultLookAndFeelDecorated(true);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JPanel createAndShowGUI(){
        Set<Object> obj = createDefi();
        JPanel panel = new JPanel(new BorderLayout());

        JPanel header = new JPanel();
        JLabel la = new JLabel("Funny Question with slang word?");
        la.setBackground(Color.black);
        la.setForeground(Color.orange);
        la.setFont(new Font("MV Boli", Font.PLAIN, 25));
        la.setOpaque(true);

        JPanel body = new JPanel(new BorderLayout());
        //câu hỏi
        body.setBackground(Color.white);
        las = new JLabel();
        String x = createSlang(obj);
        las.setText("What is the definition of slang " + x + "? ");
        las.setBackground(Color.white);
        las.setForeground(Color.blue);
        las.setFont(new Font("MV Boli", Font.PLAIN, 35));

        ArrayList<String> listAns = convertArrayString(obj);
        // câu trả lời
        JPanel ans = new JPanel();
        ans.setBackground(Color.white);
        ans.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill= GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(3,3,30,3);
        ans1 = new JButton();
        ans1.setText((String)listAns.get(0));
        ans1.setBackground(Color.white);
        ans1.setForeground(Color.BLACK);
        ans1.setFont(new Font("MV Boli", Font.PLAIN, 30));
        ans1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ans1.addActionListener(this);
        ans.add(ans1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(3,3,30,3);
        ans2 = new JButton();
        ans2.setText((String)listAns.get(1));
        ans2.setBackground(Color.white);
        ans2.setForeground(Color.BLACK);
        ans2.setFont(new Font("MV Boli", Font.PLAIN, 30));
        ans2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ans2.addActionListener(this);

        ans.add(ans2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(3,3,30,3);
        ans3 = new JButton();
        ans3.setText((String)listAns.get(2));
        ans3.setBackground(Color.white);
        ans3.setForeground(Color.BLACK);
        ans3.setFont(new Font("MV Boli", Font.PLAIN, 30));
        ans3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ans3.addActionListener(this);

        ans.add(ans3, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(3,3,30,3);
        ans4 = new JButton();
        ans4.setText((String)listAns.get(3));
        ans4.setBackground(Color.white);
        ans4.setForeground(Color.BLACK);
        ans4.setFont(new Font("MV Boli", Font.PLAIN, 30));
        ans4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ans4.addActionListener(this);

        ans.add(ans4, gbc);

        JPanel fo = new JPanel();
        fo.setBackground(Color.white);
        Icon icon = new ImageIcon("image/Button-Close-icon.png");
        cancelBtn = new JButton();
        cancelBtn.setIcon(icon);
        cancelBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancelBtn.setPreferredSize(new Dimension(140,140));
        cancelBtn.addActionListener(this);
        fo.add(cancelBtn);
        fo.add(Box.createRigidArea(new Dimension(80, 0)));


        Icon icon1 = new ImageIcon("image/sign-right-icon.png");
        nextBtn = new JButton();
        nextBtn.setIcon(icon1);
        nextBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        nextBtn.setPreferredSize(new Dimension(140,140));
        nextBtn.addActionListener(this);
        fo.add(nextBtn);

        ans.setBorder(new EmptyBorder(30,10,10,10));

        JPanel sco = new JPanel();
        sco.setBackground(Color.white);
        scoreLabel = new JLabel("Score: " + score + "");
        scoreLabel.setBackground(Color.black);
        scoreLabel.setForeground(Color.orange);
        scoreLabel.setFont(new Font("MV Boli", Font.PLAIN, 25));
        scoreLabel.setOpaque(true);
        sco.add(scoreLabel);
        body.add(BorderLayout.PAGE_START, las);
        body.add(BorderLayout.CENTER, ans);
        body.add(BorderLayout.LINE_END, sco);

        panel.add(BorderLayout.PAGE_START, header);
        panel.add(BorderLayout.CENTER, body);
        panel.add(BorderLayout.PAGE_END, fo);
        return  panel;
    }

    public ArrayList<String> convertArrayString(Set<Object> ansObject){
        Iterator<Object> i = ansObject.iterator();
        ArrayList<String> ansQuestion = new ArrayList<>();
        while(i.hasNext()){
            ArrayList<String> b = (ArrayList<String>) i.next();
            ansQuestion.add(String.join(" | ", b));
        }
        return ansQuestion;
    }
    public Set<Object> createDefi(){
        Set<Object> ansObject = new HashSet<>();
        while(ansObject.size() != 4){
            String randomAns = Main.slangWordList.randomSlangWord();
            ArrayList<String> A = Main.slangWordList.getDefinition2(randomAns);
            ansObject.add(A);
        }
        return ansObject;
    }
    public String createSlang(Set<Object> ansObject){
        Iterator<Object> k = ansObject.iterator();
        Random rand = new Random();
        ansOfQuestion = rand.nextInt(4);
        System.out.println(ansOfQuestion);
        int count = 0;
        String slang = null;
        while(count != 4 && k.hasNext()){
           if(ansOfQuestion == count){
               ArrayList<String> aaa = (ArrayList<String>) k.next();
               slang = Main.slangWordList.getSlangWord(aaa);
               break;
           }
           k.next();
           ++count;
       }
       return slang;
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
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(ans1)){
            if(ansOfQuestion == 0){
                ++score;
                scoreLabel.setText("Score: " + score);
                ans1.setBackground(Color.green);
            }else{
                ans1.setBackground(Color.red);
            }
            ans2.setEnabled(false);
            ans3.setEnabled(false);
            ans4.setEnabled(false);

        }else if(e.getSource().equals(ans2)){
            if(ansOfQuestion == 1){
                ans2.setBackground(Color.green);
                ++score;
                scoreLabel.setText("Score: " + score);

            }else{
                ans2.setBackground(Color.red);
            }
            ans1.setEnabled(false);
            ans3.setEnabled(false);
            ans4.setEnabled(false);
        }else if(e.getSource().equals(ans3)){
            if(ansOfQuestion == 2){
                ans3.setBackground(Color.green);
                ++score;
                scoreLabel.setText("Score: " + score);

            }else{
                ans3.setBackground(Color.red);
            }
            ans2.setEnabled(false);
            ans1.setEnabled(false);
            ans4.setEnabled(false);
        }else if(e.getSource().equals(ans4)){
            if(ansOfQuestion == 3){
                ans4.setBackground(Color.green);
                ++score;
                scoreLabel.setText("Score: " + score);

            }else{
                ans4.setBackground(Color.red);
            }
            ans2.setEnabled(false);
            ans3.setEnabled(false);
            ans1.setEnabled(false);
        }else if(e.getSource().equals(nextBtn)){
            ans2.setEnabled(true);
            ans3.setEnabled(true);
            ans1.setEnabled(true);
            ans4.setEnabled(true);
            ans1.setBackground(Color.white);
            ans2.setBackground(Color.white);
            ans3.setBackground(Color.white);
            ans4.setBackground(Color.white);
            Set<Object> obj = createDefi();
            ArrayList<String> listAns = convertArrayString(obj);

            String x = createSlang(obj);
            las.setText("What is the definition of slang " + x + "? ");
            ans1.setText(listAns.get(0));
            ans2.setText(listAns.get(1));
            ans3.setText(listAns.get(2));
            ans4.setText(listAns.get(3));
        }
    }
}
