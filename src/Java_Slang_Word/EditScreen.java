package Java_Slang_Word;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class EditScreen extends JFrame implements ActionListener {
    private JButton editBtn, cancelBtn, findBtn;
    private JTextField jSlang, jDefinition;
    public EditScreen(){
        setTitle("Edit SlangWord");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(createAndShowGUI());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JPanel createAndShowGUI(){
        JPanel panel = new JPanel(new BorderLayout());

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


        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = new Insets(3,3,30,3);
        findBtn = new JButton("Find");
        findBtn.setFont(new Font("MV Boli", Font.PLAIN, 25));
        findBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        findBtn.addActionListener(this);
        body.add(findBtn, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(3,3,30,3);
        JLabel las = new JLabel();
        las.setText("Definition: ");
        las.setBackground(Color.white);
        las.setForeground(Color.BLACK);
        las.setFont(new Font("MV Boli", Font.PLAIN, 30));
        las.setOpaque(true);
        body.add(las, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth=2;
        gbc.insets = new Insets(3,3,30,3);
        jDefinition = new JTextField();
        //jSlang.setSize(150,20);
        jDefinition.setFont(font);
        jDefinition.setEnabled(false);
        body.add(jDefinition, gbc);

        JPanel footer = new JPanel();
        cancelBtn = new JButton("Cancel");
        cancelBtn.setFont(new Font("MV Boli", Font.PLAIN, 25));
        cancelBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancelBtn.addActionListener(this);

        editBtn = new JButton("Confirm");
        editBtn.setFont(new Font("MV Boli", Font.PLAIN, 25));
        editBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        editBtn.addActionListener(this);

        footer.add(editBtn);
        footer.add(cancelBtn);
        panel.add(body, BorderLayout.CENTER);
        panel.add(footer, BorderLayout.PAGE_END);
        return panel;


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String slang = jSlang.getText();
        if(e.getSource().equals(findBtn)){
            List<String> y = Main.slangWordList.searchSlang(slang);
            if(y == null){
                JOptionPane.showMessageDialog(null,"Slang word: " + slang + " is not exists!", "Error", JOptionPane.WARNING_MESSAGE);
            }
            else{
                jDefinition.setEnabled(true);
                jSlang.setEditable(false);
                String defi = y.toString().substring(1, y.toString().length()-1);
                jDefinition.setText(defi);
            }
        }else if(e.getSource().equals(editBtn)){
            String definition = jDefinition.getText();
            String data[] = definition.split(", ");
            List<String> def = new ArrayList<>();
            int n = data.length;
            for(int i = 0; i < n; i++){
                def.add(data[i]);
            }
            Main.slangWordList.updateSlangWord(slang, def);
            JOptionPane.showMessageDialog(null, "Edit successfully", "Notification", JOptionPane.INFORMATION_MESSAGE);
            jSlang.setEditable(true);
            jDefinition.setText("");
            jSlang.setText("");
        }else if(e.getSource().equals(cancelBtn)){
            this.dispose();
            new ManageController();
        }
    }
}
