package Java_Slang_Word;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageController extends JFrame implements ActionListener {
    private JButton addBtn, editBtn, removeBtn, viewBtn, resetBtn, cancelBtn;
    public ManageController(){
        setTitle("Search");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(createAndShowGUI());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JPanel createAndShowGUI(){
        JPanel panel = new JPanel(new BorderLayout());

        JLabel la = new JLabel("MANAGEMENT LIST SLANG WORDS");
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
        ImageIcon icon = new ImageIcon("image/Pencil-icon (1).png");
        editBtn = new JButton();
        editBtn.setBounds(0,0,500,100);
        editBtn.setIcon(icon);
        editBtn.setText("EDIT");
        editBtn.setHorizontalTextPosition(JButton.CENTER);
        editBtn.setVerticalTextPosition(JButton.BOTTOM);
        editBtn.setFont(new Font("MV Boli", Font.PLAIN, 25));
        editBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        editBtn.addActionListener(this);
        body.add(editBtn, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(10,10,10,10);
        ImageIcon icon2 = new ImageIcon("image/add-1-icon.png");
        addBtn = new JButton();
        addBtn.setBounds(0,0,500,100);
        addBtn.setIcon(icon2);
        addBtn.setText("ADD");
        addBtn.setHorizontalTextPosition(JButton.CENTER);
        addBtn.setVerticalTextPosition(JButton.BOTTOM);
        addBtn.setFont(new Font("MV Boli", Font.PLAIN, 25));
        addBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addBtn.addActionListener(this);
        body.add(addBtn, gbc);


        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = new Insets(10,10,10,10);
        ImageIcon icon3 = new ImageIcon("image/Button-Close-icon.png");
        removeBtn = new JButton();
        removeBtn.setBounds(0,0,500,100);
        removeBtn.setIcon(icon3);
        removeBtn.setText("REMOVE");
        removeBtn.setHorizontalTextPosition(JButton.CENTER);
        removeBtn.setVerticalTextPosition(JButton.BOTTOM);
        removeBtn.setFont(new Font("MV Boli", Font.PLAIN, 25));
        removeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        removeBtn.addActionListener(this);
        body.add(removeBtn, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10,10,10,10);
        ImageIcon icon4 = new ImageIcon("image/cloud-sync-icon.png");
        resetBtn = new JButton();
        resetBtn.setBounds(0,0,500,100);
        resetBtn.setIcon(icon4);
        resetBtn.setText("RESET");
        resetBtn.setHorizontalTextPosition(JButton.CENTER);
        resetBtn.setVerticalTextPosition(JButton.BOTTOM);
        resetBtn.setFont(new Font("MV Boli", Font.PLAIN, 25));
        resetBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        resetBtn.addActionListener(this);
        body.add(resetBtn, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(10,10,10,10);
        ImageIcon icon5 = new ImageIcon("image/list-icon.png");
        viewBtn = new JButton();
        viewBtn.setBounds(0,0,500,100);
        viewBtn.setIcon(icon5);
        viewBtn.setText("LIST SLANG WORD");
        viewBtn.setHorizontalTextPosition(JButton.CENTER);
        viewBtn.setVerticalTextPosition(JButton.BOTTOM);
        viewBtn.setFont(new Font("MV Boli", Font.PLAIN, 25));
        viewBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        viewBtn.addActionListener(this);
        body.add(viewBtn, gbc);

        gbc.gridx = 2;
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
        if(e.getSource().equals(cancelBtn)){
            this.dispose();
            new MainScreen();
        } else if (e.getSource().equals(removeBtn)) {
            this.dispose();
            new DeleteScreen();
        }else if(e.getSource().equals(editBtn)){
            this.dispose();
            new EditScreen();
        }else if(e.getSource().equals(resetBtn)){
            Main.slangWordList = FileManager.readFile(2);
            JOptionPane.showMessageDialog(null, "Reset successfully!", "Notification", JOptionPane.INFORMATION_MESSAGE);
        }else if(e.getSource().equals(addBtn)){
            this.dispose();
            new AddScreen();
        }else if(e.getSource().equals(viewBtn)){
            this.dispose();
            new ListSlangWordScreen();
        }
    }
}
