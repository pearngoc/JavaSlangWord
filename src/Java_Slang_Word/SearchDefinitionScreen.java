package Java_Slang_Word;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SearchDefinitionScreen extends JFrame implements ActionListener {
    private JButton searchBtn, cancelBtn;
    private JTextField jDefinition;
    private JTable jTable;
    private String[] columsName ={"No", "SlangWord", "Definition"};
    public SearchDefinitionScreen(){
        setTitle("Search by Definition");
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
        la.setText("Please enter definition: ");
        la.setBackground(Color.white);
        la.setForeground(Color.BLACK);
        la.setFont(new Font("MV Boli", Font.PLAIN, 30));
        la.setOpaque(true);
        body.add(la, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(3,3,30,3);
        Font font = new Font("SansSerif", Font.BOLD, 20);
        jDefinition = new JTextField(25);
        //jSlang.setSize(150,20);
        jDefinition.setFont(font);
        body.add(jDefinition, gbc);

        int numRow = 30;
        DefaultTableModel model = new DefaultTableModel(numRow,columsName.length);
        model.setColumnIdentifiers(columsName);
        jTable = new JTable(model);
        jTable.setEnabled(false);
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable.setFillsViewportHeight(true);
        //jTable.setRowHeight(30);
        jTable.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTable.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTable.getColumnModel().getColumn(2).setPreferredWidth(500);
        JScrollPane scrollPane = new JScrollPane(jTable);

        JPanel footer =new JPanel();

        searchBtn = new JButton("Search");
        searchBtn.setFont(new Font("MV Boli", Font.PLAIN, 25));
        searchBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        searchBtn.addActionListener(this);
        footer.add(searchBtn);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setFont(new Font("MV Boli", Font.PLAIN, 25));
        cancelBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancelBtn.addActionListener(this);
        footer.add(cancelBtn);

        panel.add(BorderLayout.PAGE_START, body);
        panel.add(BorderLayout.CENTER, scrollPane);
        panel.add(BorderLayout.PAGE_END, footer);

        return panel;
    }

    public void updateTable(ArrayList<String> s){

        //convert object
        int n = s.size();
        Object[][] data = new Object[n][3];
        for(int i = 0; i < n; i++){
            data[i][0] = String.valueOf(i+1);
            data[i][1] = s.get(i);
            List<String> x = Main.slangWordList.searchSlang((String)data[i][1]);
            String temp  = x.toString().substring(1, x.toString().length()-1);
            data[i][2] = temp;
        }
        TableModel tableModel = new DefaultTableModel(data, columsName);

        jTable.setModel(tableModel);
        jTable.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTable.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTable.getColumnModel().getColumn(2).setPreferredWidth(500);
    }

    public String getSlangWord(ArrayList<String> s){
        String temp = "";
        int n = s.size();
        for(int i = 0; i < n; i++){
            temp += s.get(i) + ", ";
        }
        return temp.substring(0, temp.length()-2);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource().equals(searchBtn)){
            //get date time
            DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String time = (dft.format(now)).toString();

            String defi = jDefinition.getText();
            ArrayList<String> list = Main.slangWordList.searchDefinition(defi.trim());
            if(list == null){
                JOptionPane.showMessageDialog(null, "Not slang word suit to definition: " + defi, "Notification", JOptionPane.INFORMATION_MESSAGE);
                HistorySlangWord sa = new HistorySlangWord(time, defi, "NOT FOUND", " ");
                Main.historySlangWords.add(sa);
                FileManager.saveHistory(sa);

            }else{
                updateTable(list);
                HistorySlangWord sa = new HistorySlangWord(time, defi, getSlangWord(list), " ");
                Main.historySlangWords.add(sa);
                FileManager.saveHistory(sa);
            }
        }else if(e.getSource().equals(cancelBtn)){
            this.dispose();
            new SearchController();
        }
    }
}




