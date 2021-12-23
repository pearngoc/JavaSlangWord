package Java_Slang_Word;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AddScreen extends JFrame implements ActionListener {
    private JButton addBtn, cancelBtn;
    private JTextField jSlang, jDefinition;
    public AddScreen(){
        setTitle("Add SlangWord");
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


        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(3,3,30,3);
        JLabel las = new JLabel();
        las.setText("Please enter definition: ");
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
        body.add(jDefinition, gbc);

        JPanel footer = new JPanel();
        cancelBtn = new JButton("Cancel");
        cancelBtn.setFont(new Font("MV Boli", Font.PLAIN, 25));
        cancelBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancelBtn.addActionListener(this);

        addBtn = new JButton("Add");
        addBtn.setFont(new Font("MV Boli", Font.PLAIN, 25));
        addBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addBtn.addActionListener(this);

        footer.add(addBtn);
        footer.add(cancelBtn);
        panel.add(body, BorderLayout.CENTER);
        panel.add(footer, BorderLayout.PAGE_END);
        return panel;


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String slang = jSlang.getText();
        String defi = jDefinition.getText();
        String data[] = defi.split(", ");
        List<String> def = new ArrayList<>();
        int n = data.length;
        for(int i = 0; i < n; i++){
            def.add(data[i]);
        }
        if(e.getSource().equals(addBtn)){
            if(Main.slangWordList.searchSlang(slang) == null){
                Main.slangWordList.addSlangWord(new SlangWord(slang, def));
                JOptionPane.showMessageDialog(null, "Add successfully!", "Notification", JOptionPane.INFORMATION_MESSAGE);
            }else {
                String[] temp = {"Duplicate", "Overwrite", "Cancel"};
                int option = JOptionPane.showOptionDialog(null, "Slang word " + slang + " has been existed!", "Notification", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, temp, 0);
                if (option == 0) {
                    int i = 1;
                    String slangNew = slang + "(" + i + ")" + "";
                    List<String> defis = Main.slangWordList.searchSlang(slangNew);
                    while (defis != null){
                        ++i;
                        slangNew = slang + "(" + i + ")" + "";
                        defis = Main.slangWordList.searchSlang(slangNew);
                    }
                    Main.slangWordList.addSlangWord(new SlangWord(slangNew, def));
                    JOptionPane.showMessageDialog(null, "Duplicate successfully!", "Notification", JOptionPane.INFORMATION_MESSAGE);
                } else if (option == 1) {
                    int i = 1;
                    String slangNew = slang + "(" + i + ")";
                    while(Main.slangWordList.searchSlang(slangNew)!=null){
                        Main.slangWordList.deleteSlangWord(slangNew);
                        ++i;
                        slangNew = slang + "(" + i + ")";
                    }
                    Main.slangWordList.updateSlangWord(slang, def);
                    JOptionPane.showMessageDialog(null, "Overwrite successfully!", "Notification", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }else if(e.getSource().equals(cancelBtn)){
            this.dispose();
            new ManageController();
        }
    }

}
