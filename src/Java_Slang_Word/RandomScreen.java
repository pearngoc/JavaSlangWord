package Java_Slang_Word;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RandomScreen extends JFrame implements ActionListener {
    private JTextArea las;
    private JButton resetBtn, cancelBtn;
    public RandomScreen(){
        setBackground(Color.white);
        setTitle("Random SlangWord");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(createAndShowGUI());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JPanel createAndShowGUI(){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.white);

        JPanel header = new JPanel();
        JLabel la = new JLabel("CLICK TO RANDOM SLANG WORDS");

        header.setBackground(Color.white);
        la.setBackground(Color.white);
        la.setForeground(Color.GRAY);
        la.setFont(new Font("MV Boli", Font.PLAIN, 30));
        la.setOpaque(true);
        la.setAlignmentX(Component.LEFT_ALIGNMENT);
        header.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        header.add(la);



        JPanel body = new JPanel();
        body.setBackground(Color.white);
        String slang = Main.slangWordList.randomSlangWord();
        String def = Main.slangWordList.getDefinition(slang);
        las = new JTextArea(3,20);
        las.setText(slang + " - " + def);
        las.setBackground(Color.white);
        las.setForeground(Color.GRAY);
        las.setWrapStyleWord(true);
        las.setLineWrap(true);
        las.setOpaque(false);
        las.setEditable(false);
        las.setFocusable(false);
        las.setFont(new Font("MV Boli", Font.PLAIN, 70));
        las.setAlignmentX(JTextArea.CENTER_ALIGNMENT);

        body.add(las);

        JPanel footer = new JPanel(new FlowLayout());
        footer.setBackground(Color.white);
        Icon icon = new ImageIcon("image/sign-sync-icon.png");
        resetBtn = new JButton();
        resetBtn.setIcon(icon);
        resetBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        resetBtn.addActionListener(this);
        resetBtn.setPreferredSize(new Dimension(120,120));
        footer.add(resetBtn);
        footer.add(Box.createRigidArea(new Dimension(30, 0)));


        Icon icon1 = new ImageIcon("image/sign-left-icon.png");
        cancelBtn = new JButton();
        cancelBtn.setIcon(icon1);
        cancelBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancelBtn.setPreferredSize(new Dimension(120,120));
        cancelBtn.addActionListener(this);
        footer.add(cancelBtn);

        panel.add(BorderLayout.PAGE_START, header);
        panel.add(BorderLayout.CENTER, body);
        panel.add(BorderLayout.PAGE_END, footer);

        return panel;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(resetBtn)){
            String slang = Main.slangWordList.randomSlangWord();
            String def = Main.slangWordList.getDefinition(slang);
            //las.setMaximumSize(new Dimension(250,250));
            las.setText(slang + " - " + def);
        }else if(e.getSource().equals(cancelBtn)){
            this.dispose();
            new GameController();
        }
    }
}
