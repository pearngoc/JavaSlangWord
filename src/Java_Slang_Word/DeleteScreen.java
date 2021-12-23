package Java_Slang_Word;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class DeleteScreen extends JFrame implements ActionListener {
    private JButton deleteBtn, cancelBtn;
    private JTextField jSlang;
    public DeleteScreen(){
        setTitle("Remove SlangWord");
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
        deleteBtn = new JButton("Delete");
        deleteBtn.setFont(new Font("MV Boli", Font.PLAIN, 25));
        deleteBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        deleteBtn.addActionListener(this);
        body.add(deleteBtn, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
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
        if(e.getSource().equals(deleteBtn)){
            String slang = jSlang.getText();
            if(Main.slangWordList.searchSlang(slang.trim()) == null){
                JOptionPane.showMessageDialog(null, "Slang word: "+ slang + " not exists!", "Error",JOptionPane.WARNING_MESSAGE);
            }else{
                int choose = JOptionPane.showConfirmDialog(null, "Do you want delete slang word: " + slang, "Delete",JOptionPane.YES_NO_CANCEL_OPTION);
                if(choose == 0){
                    Main.slangWordList.deleteSlangWord(slang.trim());
                    JOptionPane.showMessageDialog(null, "Slang word has been deleted successfully!", "Notificaiton", JOptionPane.INFORMATION_MESSAGE);
                    jSlang.setText("");
                }
            }
        }else if(e.getSource().equals(cancelBtn)){
            this.dispose();
            new ManageController();
        }
    }
}
