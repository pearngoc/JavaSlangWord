package Java_Slang_Word;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchController extends JFrame implements ActionListener {
    private JButton searchSlangBtn, searchDefinitionBtn, cancelBtn;
    public SearchController(){
        setTitle("Search");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(createAndShowGUI());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JPanel createAndShowGUI(){
        JPanel panel = new JPanel(new BorderLayout());

        JLabel la = new JLabel("SEARCH");
        la.setBackground(Color.white);
        la.setForeground(Color.blue);
        la.setFont(new Font("MV Boli", Font.PLAIN, 70));
        la.setOpaque(true);
        la.setHorizontalAlignment(JLabel.CENTER);
        la.setVerticalAlignment(JLabel.CENTER);
        JPanel body = new JPanel();
        body.setLayout(new FlowLayout());
        body.setBackground(Color.white);

        ImageIcon icon = new ImageIcon("image/document-search-icon.png");
        searchSlangBtn = new JButton();
        searchSlangBtn.setBounds(0,0,500,100);
        searchSlangBtn.setIcon(icon);
        searchSlangBtn.setText("Search By Slang");
        searchSlangBtn.setHorizontalTextPosition(JButton.CENTER);
        searchSlangBtn.setVerticalTextPosition(JButton.BOTTOM);
        searchSlangBtn.setFont(new Font("MV Boli", Font.PLAIN, 25));
        searchSlangBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        searchSlangBtn.addActionListener(this);

        body.add(searchSlangBtn);
        body.add(Box.createRigidArea(new Dimension(30, 0)));

        ImageIcon icon1 = new ImageIcon("image/file-search-icon.png");
        searchDefinitionBtn = new JButton();
        searchDefinitionBtn.setBounds(0,0,500,100);
        searchDefinitionBtn.setIcon(icon1);
        searchDefinitionBtn.setText("Search By Definition");
        searchDefinitionBtn.setHorizontalTextPosition(JButton.CENTER);
        searchDefinitionBtn.setVerticalTextPosition(JButton.BOTTOM);
        searchDefinitionBtn.setFont(new Font("MV Boli", Font.PLAIN, 25));
        searchDefinitionBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        searchDefinitionBtn.addActionListener(this);
        body.add(searchDefinitionBtn);
        body.add(Box.createRigidArea(new Dimension(30, 0)));


        ImageIcon icon2 = new ImageIcon("image/arrow-back-icon.png");
        cancelBtn = new JButton();
        cancelBtn.setBounds(0,0,500,100);
        cancelBtn.setIcon(icon2);
        cancelBtn.setText("Cancel");
        cancelBtn.setHorizontalTextPosition(JButton.CENTER);
        cancelBtn.setVerticalTextPosition(JButton.BOTTOM);
        cancelBtn.setFont(new Font("MV Boli", Font.PLAIN, 25));
        cancelBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancelBtn.addActionListener(this);
        body.add(cancelBtn);

        panel.add(BorderLayout.PAGE_START, la);
        panel.add(BorderLayout.CENTER, body);

        return panel;

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(searchSlangBtn)){
            this.dispose();
            new SearchSlangScreen();
        }else if(e.getSource().equals(searchDefinitionBtn)){
            this.dispose();
            new SearchDefinitionScreen();
        }else if(e.getSource().equals(cancelBtn)){
            this.dispose();
            new MainScreen();
        }
    }
}
