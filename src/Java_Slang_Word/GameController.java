package Java_Slang_Word;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController extends JFrame implements ActionListener {
    private JButton randomBtn, slangBtn, definitionBtn,cancelBtn;
    public GameController(){
        setTitle("Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(createAndShowGUI());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JPanel createAndShowGUI(){
        JPanel panel = new JPanel(new BorderLayout());

        JLabel la = new JLabel("PLAY GAME");
        la.setBackground(Color.white);
        la.setForeground(Color.blue);
        la.setFont(new Font("MV Boli", Font.PLAIN, 70));
        la.setOpaque(true);
        la.setHorizontalAlignment(JLabel.CENTER);
        la.setVerticalAlignment(JLabel.CENTER);

        JPanel body = new JPanel();
        body.setLayout(new GridBagLayout());
        body.setBackground(Color.white);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill= GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10,10,10,10);
        ImageIcon icon = new ImageIcon("image/umbrella.png");
        randomBtn = new JButton();
        randomBtn.setBounds(0,0,500,100);
        randomBtn.setIcon(icon);
        randomBtn.setText("Random Slang Word");
        randomBtn.setHorizontalTextPosition(JButton.CENTER);
        randomBtn.setVerticalTextPosition(JButton.BOTTOM);
        randomBtn.setFont(new Font("MV Boli", Font.PLAIN, 25));
        randomBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        randomBtn.addActionListener(this);
        body.add(randomBtn, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(10,10,10,10);
        ImageIcon icon2 = new ImageIcon("image/ferris-wheel-icon.png");
        slangBtn = new JButton();
        slangBtn.setBounds(0,0,500,100);
        slangBtn.setIcon(icon2);
        slangBtn.setText("Funny Question with SlangWord");
        slangBtn.setHorizontalTextPosition(JButton.CENTER);
        slangBtn.setVerticalTextPosition(JButton.BOTTOM);
        slangBtn.setFont(new Font("MV Boli", Font.PLAIN, 25));
        slangBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        slangBtn.addActionListener(this);
        body.add(slangBtn, gbc);


        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10,10,10,10);
        ImageIcon icon3 = new ImageIcon("image/circus-tent-icon.png");
        definitionBtn = new JButton();
        definitionBtn.setBounds(0,0,500,100);
        definitionBtn.setIcon(icon3);
        definitionBtn.setText("Funny Question with Definition");
        definitionBtn.setHorizontalTextPosition(JButton.CENTER);
        definitionBtn.setVerticalTextPosition(JButton.BOTTOM);
        definitionBtn.setFont(new Font("MV Boli", Font.PLAIN, 25));
        definitionBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        definitionBtn.addActionListener(this);
        body.add(definitionBtn, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(10,10,10,10);
        ImageIcon icon6 = new ImageIcon("image/arrow-back-icon.png");
        cancelBtn = new JButton();
        cancelBtn.setBounds(0,0,500,100);
        cancelBtn.setIcon(icon6);
        cancelBtn.setText("BACK");
        cancelBtn.setHorizontalTextPosition(JButton.CENTER);
        cancelBtn.setVerticalTextPosition(JButton.BOTTOM);
        cancelBtn.setFont(new Font("MV Boli", Font.PLAIN, 25));
        cancelBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancelBtn.addActionListener(this);
        body.add(cancelBtn, gbc);

        panel.add(BorderLayout.PAGE_START, la);
        panel.add(BorderLayout.CENTER, body);

        return panel;

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(randomBtn)){
            this.dispose();
            new RandomScreen();
        }
    }
}
