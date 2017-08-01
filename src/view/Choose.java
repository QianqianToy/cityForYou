/*
 * Created by JFormDesigner on Thu Apr 27 10:23:28 CST 2017
 */

package view;

import domain.Task;
import service.TaskService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author xxx holic
 */
public class Choose extends JFrame {

    private String name;
    private String pyName;

    public Choose(String name,String pyname){
        initComponents();
        showTaskTable(name);
        this.name = name;
        this.pyName = pyname;
    }

    private void showTaskTable(String name) {
        DefaultTableModel dtm = new DefaultTableModel();
        table1.setModel(dtm);
        java.util.List<Task> tasks = null;
        TaskService taskService = new TaskService();

        try {
            tasks = taskService.getAptTask(name);
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

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        Choose.this.setVisible(false);
        new CityForYou(pyName).setVisible(true);
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        TaskService taskService = new TaskService();
        try {
            taskService.updataStateByTname(pyName);
            taskService.updateStateByName(name);
            JOptionPane.showMessageDialog(null,"接受成功");
            dispose();
        }catch (Exception e1){
            e1.printStackTrace();
        }
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - xxx holic
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }

        //---- button1 ----
        button1.setText("\u63a5\u53d7");
        button1.addActionListener(e -> {
			button2ActionPerformed(e);
			button1ActionPerformed(e);
			button1ActionPerformed(e);
			button1ActionPerformed(e);
		});

        //---- button2 ----
        button2.setText("\u8fd4\u56de");
        button2.addActionListener(e -> {
			button2ActionPerformed(e);
			button1ActionPerformed(e);
		});

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(60, 60, 60)
                    .addComponent(button1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button2)
                    .addGap(217, 217, 217))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 1001, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                    .addGap(42, 42, 42)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button2))
                    .addGap(0, 86, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - xxx holic
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setpyName(String pyName) {
        this.pyName = pyName;
    }
}
