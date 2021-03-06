package Java_Slang_Word;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SearchSlangScreen extends JFrame implements ActionListener {
    private JButton searchBtn, cancelBtn;
    private JTextField jSlang;
    private JTextArea jDefinition;
    public SearchSlangScreen(){
        setTitle("Search by SlangWord");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(createAndShowGUI());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JPanel createAndShowGUI(){
        JPanel panel = new JPanel();

        JPanel body = new JPanel();
        body.setBackground(Color.white);
        body.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill= GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(3,3,30,3);
        JLabel la = new JLabel();
        la.setText("Please enter slang word: ");
        la.setBackground(Color.white);
        la.setForeground(Color.BLACK);
        la.setFont(new Font("MV Boli", Font.PLAIN, 30));
        la.setOpaque(true);
        body.add(la, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(3,3,30,3);
        Font font = new Font("SansSerif", Font.BOLD, 20);
        jSlang = new JTextField(25);
        //jSlang.setSize(150,20);
        jSlang.setFont(font);
        body.add(jSlang, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(3,3,30,3);
        JLabel label = new JLabel();
        label.setText("Definition: ");
        label.setBackground(Color.white);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("MV Boli", Font.PLAIN, 30));
        label.setOpaque(true);
        body.add(label, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(3,3,30,3);
        jDefinition = new JTextArea(3, 20);


        jDefinition.setBackground(Color.white);
        jDefinition.setForeground(Color.BLACK);
        jDefinition.setFont(new Font("SansSerif", Font.PLAIN, 30));
        jDefinition.setWrapStyleWord(true);
        jDefinition.setLineWrap(true);
        jDefinition.setOpaque(false);
        jDefinition.setEditable(false);
        jDefinition.setFocusable(false);
        jDefinition.setOpaque(true);
        body.add(jDefinition, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(3,3,30,3);
        searchBtn = new JButton("Search");
        searchBtn.setFont(new Font("MV Boli", Font.PLAIN, 25));
        searchBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        searchBtn.addActionListener(this);
        body.add(searchBtn, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(3,3,30,3);
        cancelBtn = new JButton("Cancel");
        cancelBtn.setFont(new Font("MV Boli", Font.PLAIN, 25));
        cancelBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancelBtn.addActionListener(this);
        body.add(cancelBtn, gbc);

        panel.add(body);

        return panel;


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(searchBtn)){
            String slang = jSlang.getText();
            List<String> y = new ArrayList<>();
            y = Main.slangWordList.searchSlang(slang);
            DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String time = (dft.format(now)).toString();
            if(y == null){
                jDefinition.setText("NOT FOUND");
                HistorySlangWord sa = new HistorySlangWord(time,slang," ","NOT FOUND");
                Main.historySlangWords.add(sa);
                FileManager.saveHistory(sa);
            }else{
                String defi = y.toString().substring(1, y.toString().length()-1);
                int i = 1;
                String newSlang = slang + "(" + i + ")";
                while(Main.slangWordList.searchSlang(newSlang)!=null){
                    List<String> temp = Main.slangWordList.searchSlang(newSlang);
                    String temp2 = temp.toString().substring(1, temp.toString().length()-1);
                    defi = defi + ", " + temp2;
                    ++i;
                    newSlang = slang + "(" + i + ")";
                }
                jDefinition.setText(defi);
                HistorySlangWord sa = new HistorySlangWord(time,slang," ",defi);
                Main.historySlangWords.add(sa);
                FileManager.saveHistory(sa);
            }
        }else if(e.getSource().equals(cancelBtn)){
            this.dispose();
            new SearchController();
        }
    }
}
