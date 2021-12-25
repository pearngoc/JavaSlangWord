package Java_Slang_Word;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ListSlangWordScreen extends JFrame implements ActionListener {
    private JTable jTable;
    private String[] columsName = {"No", "SlangWord", "Definition"};
    private JButton cancelBtn, saveBtn;
    public ListSlangWordScreen(){
        setTitle("List Slang Word");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(createAndShowGUI());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JPanel createAndShowGUI() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(740,500));

        JLabel la = new JLabel("LIST SLANG WORDS");
        la.setBackground(Color.white);
        la.setHorizontalAlignment(JLabel.CENTER);
        la.setForeground(Color.blue);
        la.setFont(new Font("MV Boli", Font.PLAIN, 70));
        la.setOpaque(true);

        int numRow = 30;
        DefaultTableModel model = new DefaultTableModel(numRow, columsName.length);
        model.setColumnIdentifiers(columsName);
        jTable = new JTable(model);
        jTable.setEnabled(false);
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable.setFillsViewportHeight(true);
        update();
        JScrollPane scrollPane = new JScrollPane(jTable);

        JPanel footer = new JPanel();
        cancelBtn = new JButton("Cancel");
        cancelBtn.setFont(new Font("MV Boli", Font.PLAIN, 25));
        cancelBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancelBtn.addActionListener(this);
        footer.add(cancelBtn);
        footer.add(Box.createRigidArea(new Dimension(30, 0)));


        saveBtn = new JButton("Save");
        saveBtn.setFont(new Font("MV Boli", Font.PLAIN, 25));
        saveBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        saveBtn.addActionListener(this);
        footer.add(saveBtn);

        panel.add(BorderLayout.PAGE_START, la);
        panel.add(BorderLayout.CENTER, scrollPane);
        panel.add(BorderLayout.PAGE_END, footer);

        return panel;
    }

    public void update(){
        int n = Main.slangWordList.getLength();
        //System.out.println("AAAA" + n);
        Object[][] data = new Object[n][3];
        int temp = 0;
        Iterator iter =Main.slangWordList.getListHashMap().entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry mapElement = (Map.Entry)iter.next();
            data[temp][0] = String.valueOf(temp+1);
            data[temp][1] = (String) mapElement.getKey();
            java.util.List<String> definition = (List<String>) mapElement.getValue();
            String def = "";
            for(String x: definition){
                def += x + ", ";
            }
            data[temp][2] = def.substring(0, def.length()-2);
            ++temp;
        }
        TableModel tableModel = new DefaultTableModel(data, columsName);
        jTable.setModel(tableModel);
        jTable.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTable.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTable.getColumnModel().getColumn(2).setPreferredWidth(450);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(cancelBtn)){
            this.dispose();
            new MainScreen();
        }else if(e.getSource().equals(saveBtn)){
            FileManager.saveNewSlang();
            JOptionPane.showMessageDialog(null, "Save list slang word successfully!", "Save file",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
