package Java_Slang_Word;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

public class HistoryScreen extends JFrame implements ActionListener {
    private JTable jTable;
    private String[] columsName = {"No","Time", "Keyword searched", "SlangWord", "Definition"};
    private JButton cancelBtn, deleteBtn;
    private TableModel tableModel;
    public HistoryScreen(){
        setTitle("History");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(createAndShowGUI());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JPanel createAndShowGUI() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(880,500));

        JLabel la = new JLabel("HISTORY");
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

        deleteBtn = new JButton("Delete");
        deleteBtn.setFont(new Font("MV Boli", Font.PLAIN, 25));
        deleteBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        deleteBtn.addActionListener(this);
        footer.add(deleteBtn);
        footer.add(Box.createRigidArea(new Dimension(30, 0)));

        cancelBtn = new JButton("Cancel");
        cancelBtn.setFont(new Font("MV Boli", Font.PLAIN, 25));
        cancelBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancelBtn.addActionListener(this);
        footer.add(cancelBtn);



        panel.add(BorderLayout.PAGE_START, la);
        panel.add(BorderLayout.CENTER, scrollPane);
        panel.add(BorderLayout.PAGE_END, footer);

        return panel;
    }

    public void update(){
        int n = Main.historySlangWords.size();
        Object[][] data = new Object[n][6];
        for(int i = 0; i < n; i++){
            data[i][0] = String.valueOf(i+1);
            data[i][1] = Main.historySlangWords.get(i).getTime();
            data[i][2] = Main.historySlangWords.get(i).getKeywordSearched();
            data[i][3] = Main.historySlangWords.get(i).getSlang();
            data[i][4] = Main.historySlangWords.get(i).getDefinition();
        }
        tableModel = new DefaultTableModel(data, columsName);
        jTable.setModel(tableModel);
        jTable.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTable.getColumnModel().getColumn(1).setPreferredWidth(140);
        jTable.getColumnModel().getColumn(2).setPreferredWidth(140);
        jTable.getColumnModel().getColumn(3).setPreferredWidth(200);
        jTable.getColumnModel().getColumn(4).setPreferredWidth(400);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(cancelBtn)){
            this.dispose();
            new MainScreen();
        }else if(e.getSource().equals(deleteBtn)){
            int option = JOptionPane.showConfirmDialog(null, "Do you want to clear history?", "Confirm", JOptionPane.YES_NO_OPTION);
            if(option == 0){
                DefaultTableModel mode = (DefaultTableModel) jTable.getModel();
                mode.setRowCount(0);
                File file = new File("history.txt");
                if(file.exists())
                    file.delete();
                FileManager.loadHistory();
                JOptionPane.showMessageDialog(null, "Delete successfully!", "Notification", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
