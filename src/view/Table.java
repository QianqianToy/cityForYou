/*
 * Created by JFormDesigner on Thu Apr 27 20:06:29 CST 2017
 */

package view;

import domain.Task;
import service.TaskService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 * @author xxx holic
 */
public class Table extends JFrame {
    private String nameg;
    private String pyName;
    public Table(String name,String pyname) {
        initComponents();
        nameg = name;
        pyName = pyname;
        showTable();
    }

    private void showTable() {
        DefaultTableModel dtm = new DefaultTableModel();
        table1.setModel(dtm);
        List<Task> tasks = null;
        TaskService taskService = new TaskService();
        try {
            tasks = taskService.slurFindTask(nameg);
            Object [] [] data = new Object[tasks.size()][];
            for (int i = 0; i < tasks.size(); i++)
                data[i] = tasks.get(i).toStringArray();
            String [] header = {"任务编号","任务名称","任务类型","任务描述","发布者姓名","开始时间"
                    ,"结束时间","地址","赏金","违约金"};
            dtm.setDataVector(data, header);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        Table.this.setVisible(false);
        new CityForYou(pyName).setVisible(true);
    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        DefaultTableModel dtm = new DefaultTableModel();
        table1.setModel(dtm);
        List<Task> tasks = null;
        TaskService taskService = new TaskService();
        try {
            taskService.slurFindUpdataState(pyName, Integer.parseInt(textField1.getText(), 10));
            tasks = taskService.slurFindTask(nameg);
            Object [] [] data = new Object[tasks.size()][];
            for (int i = 0; i < tasks.size(); i++)
                data[i] = tasks.get(i).toStringArray();
            String [] header = {"任务编号","任务名称","任务类型","任务描述","发布者姓名","开始时间"
                    ,"结束时间","地址","赏金","违约金"};
            dtm.setDataVector(data, header);
        }catch (Exception e1){
            e1.printStackTrace();
        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - xxx holic
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }

        //---- label1 ----
        label1.setText("\u4efb\u52a1\u7f16\u53f7");

        //---- button1 ----
        button1.setText("\u63d0\u4ea4");
        button1.addActionListener(e -> button2ActionPerformed(e));

        //---- button2 ----
        button2.setText("\u8fd4\u56de");
        button2.addActionListener(e -> button1ActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label1)
                    .addGap(18, 18, 18)
                    .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(46, 46, 46)
                    .addComponent(button1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button2)
                    .addGap(81, 81, 81))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 1000, GroupLayout.PREFERRED_SIZE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button2)
                        .addComponent(button1))
                    .addGap(0, 7, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - xxx holic
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setNameg(String nameg) {
        this.nameg = nameg;
    }

    public void setpyName(String pyName) {
        this.pyName = pyName;
    }
}
