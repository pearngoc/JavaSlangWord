package Java_Slang_Word;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame implements ActionListener {
    private JButton searchBtn, editBtn, historyBtn, randomBtn;
    public MainScreen(){
        setTitle("Slang Word Application");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(createAndShowGUI());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JPanel createAndShowGUI(){
        JPanel panel = new JPanel(new BorderLayout());

        JLabel la = new JLabel("SLANG WORD APPLICATION");
        la.setBackground(Color.white);
        la.setForeground(Color.blue);
        la.setFont(new Font("MV Boli", Font.PLAIN, 70));
        la.setOpaque(true);

        JPanel body = new JPanel();
        body.setBackground(Color.white);
        body.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill= GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(3,3,30,3);
        ImageIcon icon = new ImageIcon("image/document-search-icon.png");
        searchBtn = new JButton();
        searchBtn.setBounds(0,0,500,100);
        searchBtn.setIcon(icon);
        searchBtn.setText("Search");
        searchBtn.setHorizontalTextPosition(JButton.CENTER);
        searchBtn.setVerticalTextPosition(JButton.BOTTOM);
        searchBtn.setFont(new Font("MV Boli", Font.PLAIN, 25));
        searchBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        searchBtn.addActionListener(this);
        body.add(searchBtn, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(3,60,30,60);
        ImageIcon icon1 = new ImageIcon("image/notepad-icon.png");
        editBtn = new JButton();
        editBtn.setBounds(0,0,500,100);
        editBtn.setIcon(icon1);
        editBtn.setText("Management SlangWord");
        editBtn.setHorizontalTextPosition(JButton.CENTER);
        editBtn.setVerticalTextPosition(JButton.BOTTOM);
        editBtn.setFont(new Font("MV Boli", Font.PLAIN, 25));
        editBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        editBtn.addActionListener(this);

        body.add(editBtn, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(3,3,3,3);
        ImageIcon icon2 = new ImageIcon("image/game-controller-icon.png");
        randomBtn = new JButton();
        randomBtn.setBounds(0,0,500,100);
        randomBtn.setIcon(icon2);
        randomBtn.setText("Funny Question");
        randomBtn.setHorizontalTextPosition(JButton.CENTER);
        randomBtn.setVerticalTextPosition(JButton.BOTTOM);
        randomBtn.setFont(new Font("MV Boli", Font.PLAIN, 25));
        randomBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        randomBtn.addActionListener(this);

        body.add(randomBtn, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(3,60,3,60);
        ImageIcon icon3 = new ImageIcon("image/rules-icon.png");
        historyBtn = new JButton();
        historyBtn.setBounds(0,0,500,100);
        historyBtn.setIcon(icon3);
        historyBtn.setText("History");
        historyBtn.setHorizontalTextPosition(JButton.CENTER);
        historyBtn.setVerticalTextPosition(JButton.BOTTOM);
        historyBtn.setFont(new Font("MV Boli", Font.PLAIN, 25));
        historyBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        historyBtn.addActionListener(this);

        body.add(historyBtn, gbc);

        panel.add(BorderLayout.PAGE_START, la);
        panel.add(BorderLayout.CENTER, body);


        return panel;

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(searchBtn)){
            this.dispose();
            new SearchController();
        }else if(e.getSource().equals(historyBtn)){
            this.dispose();
            new HistoryScreen();
        }
    }

}
