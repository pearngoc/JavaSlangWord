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
    private JLabel jDefinition;
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
        jDefinition = new JLabel("");
        jDefinition.setBackground(Color.white);
        jDefinition.setForeground(Color.BLACK);
        jDefinition.setFont(new Font("SansSerif", Font.PLAIN, 30));
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
                Main.historySlangWords.add(new HistorySlangWord(time,slang,"","NOT FOUND"));
            }else{
                String defi = y.toString().substring(1, y.toString().length()-1);
                jDefinition.setText(defi);
                Main.historySlangWords.add(new HistorySlangWord(time,slang,"",defi));
            }
        }else if(e.getSource().equals(cancelBtn)){
            this.dispose();
            new SearchController();
        }
    }
}
