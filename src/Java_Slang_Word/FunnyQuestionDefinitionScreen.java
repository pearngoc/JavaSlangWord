package Java_Slang_Word;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

public class FunnyQuestionDefinitionScreen extends JFrame implements ActionListener {
    private JButton ans1, ans2, ans3, ans4, nextBtn, cancelBtn;
    private JLabel scoreLabel, heart1, heart2, heart3, highScoreLabel;
    private JTextArea las;
    public static int heartCount = 3;
    public static  int ansOfQuestion;
    public static int score = 0;
    public static int highScore = 0;
    public FunnyQuestionDefinitionScreen(){
        try {
            setHighScore();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        setPreferredSize(new Dimension(1200,700));
        setTitle("Game: Definition");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(createAndShowGUI());
        //setDefaultLookAndFeelDecorated(true);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JPanel createAndShowGUI(){
        Random ran = new Random();
        ansOfQuestion = ran.nextInt(4);
        Set<Object> obj = createSlang();
        ArrayList<String> listAns = convertArrayString(obj);
        JPanel panel = new JPanel(new BorderLayout());

        JPanel body = new JPanel(new BorderLayout());
        //câu hỏi
        body.setBackground(Color.white);
        las = new JTextArea(2,40);
        las.setText("What is the slang word of definition " + Main.slangWordList.getDefinition(listAns.get(ansOfQuestion)) + " ? ");
        las.setBackground(Color.white);
        las.setForeground(Color.blue);
        las.setFont(new Font("MV Boli", Font.PLAIN, 40));
        las.setWrapStyleWord(true);
        las.setLineWrap(true);
        las.setOpaque(false);
        las.setEditable(false);
        las.setFocusable(false);

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
        fo.add(Box.createRigidArea(new Dimension(110, 0)));


        Icon icon1 = new ImageIcon("image/sign-right-icon.png");
        nextBtn = new JButton();
        nextBtn.setIcon(icon1);
        nextBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        nextBtn.setPreferredSize(new Dimension(140,140));
        nextBtn.addActionListener(this);
        fo.add(nextBtn);

        ans.setBorder(new EmptyBorder(30,10,10,10));

        JPanel sco = new JPanel(new GridBagLayout());
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        gbc2.insets = new Insets(0,0,15,20);
        sco.setBackground(Color.white);
        scoreLabel = new JLabel("Score: " + score + "");
        scoreLabel.setBackground(Color.black);
        scoreLabel.setForeground(Color.orange);
        scoreLabel.setFont(new Font("MV Boli", Font.PLAIN, 25));
        scoreLabel.setOpaque(true);
        sco.add(scoreLabel, gbc2);

        gbc2.gridx = 0;
        gbc2.gridy = 0;
        highScoreLabel = new JLabel("High Score: " + highScore + "");
        highScoreLabel.setBackground(Color.black);
        highScoreLabel.setForeground(Color.orange);
        highScoreLabel.setFont(new Font("MV Boli", Font.PLAIN, 25));
        highScoreLabel.setOpaque(true);
        sco.add(highScoreLabel, gbc2);


        JPanel heart = new JPanel(new GridLayout(3,1));
        heart.setBackground(Color.white);
        heart.setBorder(new EmptyBorder(30,30,30,30));
        ImageIcon imageIcon = new ImageIcon("image/Heart-icon.png"); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg);

        heart1 = new JLabel();
        heart1.setIcon(imageIcon);

        heart2 = new JLabel();
        heart2.setIcon(imageIcon);

        heart3 = new JLabel();
        heart3.setIcon(imageIcon);

        heart.add(heart1);
        heart.add(heart2);
        heart.add(heart3);


        body.add(BorderLayout.PAGE_START, las);
        body.add(BorderLayout.CENTER, ans);
        body.add(BorderLayout.LINE_END, sco);
        body.add(BorderLayout.LINE_START, heart);

        //panel.add(BorderLayout.PAGE_START, header);
        panel.add(BorderLayout.CENTER, body);
        panel.add(BorderLayout.PAGE_END, fo);
        return  panel;
    }

    public ArrayList<String> convertArrayString(Set<Object> ansObject){
        Iterator<Object> i = ansObject.iterator();
        ArrayList<String> ansQuestion = new ArrayList<>();
        while(i.hasNext()){
            ansQuestion.add((String)i.next());
        }
        return ansQuestion;
    }
    public Set<Object> createSlang(){
        Set<Object> ansObject = new HashSet<>();
        while(ansObject.size() != 4){
            String slang = Main.slangWordList.randomSlangWord();
            ansObject.add(slang);
        }
        return ansObject;
    }

    public void updateHeart1(){
        heart3.setIcon(null);
    }

    public void updateHeart2(){
        heart2.setIcon(null);
    }

    public void updateHeart3(){
        heart1.setIcon(null);
    }

    public void updateHeart(int count){
        if(count == 2){
            updateHeart1();
        }else if(count == 1){
            updateHeart2();
        }else if(count == 0){
            updateHeart3();
        }
    }
    public void resetGame(){
        ImageIcon imageIcon = new ImageIcon("image/Heart-icon.png"); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg);
        heart1.setIcon(imageIcon);
        heart2.setIcon(imageIcon);
        heart3.setIcon(imageIcon);
        score = 0;
        heartCount = 3;
        setDefaultButton();
        setLabel();
        scoreLabel.setText("Score: " + score);
    }

    public void notification(int count){
        if(count == 0){
            if(score > highScore){
                writeHighScore(score+"");
                highScore = score;
                highScoreLabel.setText("High Score: " + highScore);
            }
            JOptionPane.showMessageDialog(null, "Lose game!. Your score is " + score);
            int choose = JOptionPane.showConfirmDialog(null, "Do you want to continue game?", "Notification", JOptionPane.YES_NO_OPTION);
            heartCount = 3;
            resetGame();
            setDefaultButton();
            setLabel();
            if(choose == 1){
                this.dispose();
                new GameController();
            }
        }
    }
    public void setDefaultButton(){
        ans2.setEnabled(true);
        ans3.setEnabled(true);
        ans1.setEnabled(true);
        ans4.setEnabled(true);
        ans1.setBackground(Color.white);
        ans2.setBackground(Color.white);
        ans3.setBackground(Color.white);
        ans4.setBackground(Color.white);
    }
    public void setLabel(){
        Random ran = new Random();
        ansOfQuestion = ran.nextInt(4);
        Set<Object> obj = createSlang();
        ArrayList<String> listAns = convertArrayString(obj);

        las.setText("What is the definition of slang " + Main.slangWordList.getDefinition(listAns.get(ansOfQuestion)) + "? ");
        ans1.setText(listAns.get(0));
        ans2.setText(listAns.get(1));
        ans3.setText(listAns.get(2));
        ans4.setText(listAns.get(3));
    }

    public void setHighScore() throws FileNotFoundException {
        BufferedReader file = null;
        try {
            file = new BufferedReader(new FileReader(new File("highscore1.txt")));
            String highScore1= file.readLine();
            highScore = Integer.parseInt(highScore1);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeHighScore(String sc){

        BufferedWriter file = null;
        try {
            file = new BufferedWriter(new FileWriter(new File("highscore1.txt")));
            file.write(sc);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
                --heartCount;
            }
            ans2.setEnabled(false);
            ans3.setEnabled(false);
            ans4.setEnabled(false);
            updateHeart(heartCount);
            notification(heartCount);
        }else if(e.getSource().equals(ans2)){
            if(ansOfQuestion == 1){
                ans2.setBackground(Color.green);
                ++score;
                scoreLabel.setText("Score: " + score);
            }else{
                ans2.setBackground(Color.red);
                --heartCount;
            }

            ans1.setEnabled(false);
            ans3.setEnabled(false);
            ans4.setEnabled(false);
            updateHeart(heartCount);
            notification(heartCount);
        }else if(e.getSource().equals(ans3)){
            if(ansOfQuestion == 2){
                ans3.setBackground(Color.green);
                ++score;
                scoreLabel.setText("Score: " + score);
            }else{
                ans3.setBackground(Color.red);
                --heartCount;
            }
            ans2.setEnabled(false);
            ans1.setEnabled(false);
            ans4.setEnabled(false);
            updateHeart(heartCount);
            notification(heartCount);
        }else if(e.getSource().equals(ans4)){
            if(ansOfQuestion == 3){
                ans4.setBackground(Color.green);
                ++score;
                scoreLabel.setText("Score: " + score);

            }else{
                ans4.setBackground(Color.red);
                --heartCount;
            }
            ans2.setEnabled(false);
            ans3.setEnabled(false);
            ans1.setEnabled(false);
            updateHeart(heartCount);
            notification(heartCount);
        }else if(e.getSource().equals(nextBtn)){
            setDefaultButton();
            setLabel();
        }else if(e.getSource().equals(cancelBtn)){
            int option = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Notification", JOptionPane.YES_NO_OPTION);
            if(option == 0){
                if(score > highScore){
                    writeHighScore(score+"");
                    highScore = score;
                    highScoreLabel.setText("High Score: " + highScore);
                }
                resetGame();
                setDefaultButton();
                setLabel();
                this.dispose();
                new GameController();
            }
        }
    }
}

