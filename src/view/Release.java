/*
 * Created by JFormDesigner on Fri Apr 28 10:46:46 CST 2017
 */

package view;

import domain.Task;
import service.SenseService;
import service.TaskService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author xxx holic
 */
public class Release extends JFrame {

    private SenseService senseService = new SenseService();
    private TaskService taskService = new TaskService();

    private String pyName;
    public Release(String pyname) {
        initComponents();
        pyName = pyname;
    }

    private void button1ActionPerformed(ActionEvent e) {
        try {
            String t_name = textField1.getText();
            String t_type = comboBox1.getSelectedItem().toString();
            String me_name = pyName;
            String start_time = textField5.getText();
            String end_time = textField6.getText();
            String address = textField7.getText();
            Integer reward = Integer.parseInt(textField8.getText());
            Integer penalty = Integer.parseInt(textField9.getText());
            String content = textPane1.getText();
            String state = "待接受";
            boolean flag = senseService.badWordNotice(content);
            if(flag) {
                Task t = new Task();
                t.setT_name(t_name);
                t.setT_type(t_type);
                t.setT_content(content);
                t.setMe_name(me_name);
                t.setStart_time(start_time);
                t.setEnd_time(end_time);
                t.setAddress(address);
                t.setReward(reward);
                t.setPenalty(penalty);
                t.setState(state);
                taskService.taskUpSend(t);

                JOptionPane.showMessageDialog(null,"通过敏感字审核，发布成功！请刷新任务大厅查看！");
                Release.this.setVisible(false);
                new MemberView(pyName).setVisible(true);
            }else {
                JOptionPane.showMessageDialog(null,"内容有敏感字");
            }
        }
        catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - xxx holic
        label1 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label13 = new JLabel();
        label14 = new JLabel();
        label15 = new JLabel();
        label16 = new JLabel();
        label17 = new JLabel();
        scrollPane1 = new JScrollPane();
        textPane1 = new JTextPane();
        textField1 = new JTextField();
        textField5 = new JTextField();
        textField6 = new JTextField();
        textField7 = new JTextField();
        textField8 = new JTextField();
        textField9 = new JTextField();
        button1 = new JButton();
        panel1 = new JPanel();
        comboBox1 = new JComboBox<>();

        //======== this ========
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("                            \u6b22\u8fce\u6765\u5230\u4efb\u52a1\u53d1\u5e03\u7cfb\u7edf\uff01\uff01\uff01");

        //---- label8 ----
        label8.setText("\u4efb\u52a1\u540d\u79f0\uff1a");

        //---- label9 ----
        label9.setText("\u4efb\u52a1\u7c7b\u578b\uff1a");

        //---- label10 ----
        label10.setText("\u4efb\u52a1\u5185\u5bb9\u63cf\u8ff0\uff1a");

        //---- label13 ----
        label13.setText("\u4efb\u52a1\u53d1\u5e03\u65f6\u95f4\uff1a");

        //---- label14 ----
        label14.setText("\u4efb\u52a1\u622a\u6b62\u65f6\u95f4\uff1a");

        //---- label15 ----
        label15.setText("\u96c7\u4e3b\u5730\u5740\uff08\u9009\u586b\uff09\uff1a");

        //---- label16 ----
        label16.setText("\u4efb\u52a1\u60ac\u8d4f\u91d1\u989d\uff1a");

        //---- label17 ----
        label17.setText("\u4efb\u52a1\u8fdd\u7ea6\u7f5a\u6b3e\uff1a");

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textPane1);
        }

        //---- button1 ----
        button1.setText("\u63d0\u4ea4");
        button1.addActionListener(e -> button1ActionPerformed(e));

        //======== panel1 ========
        {

            // JFormDesigner evaluation mark
            panel1.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new Font("Dialog", Font.BOLD, 12),
                    Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
            );
        }

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "\u5546\u6807\u6ce8\u518c",
            "\u5f00\u529e\u516c\u53f8",
            "\u4eba\u529b\u8d44\u6e90",
            "\u804c\u4e1a\u57f9\u8bad",
            "LOGO\u8bbe\u8ba1",
            "VI\u8bbe\u8ba1",
            "\u5e7f\u544a\u8bbe\u8ba1",
            "\u89c6\u9891\u5ba3\u4f20",
            "\u5546\u54c1\u5305\u88c5",
            "app",
            "\u5fae\u4fe1\u5f00\u53d1",
            "UI\u8bbe\u8ba1",
            "\u4e2a\u4eba\u753b\u50cf",
            "\u7ffb\u8bd1\u6587\u732e",
            "\u53d6\u540d",
            "\u751f\u6d3b\u6444\u5f71",
            "\u7535\u5546\u63a8\u5e7f",
            "\u7f51\u7edc\u63a8\u5e7f"
        }));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(407, 407, 407)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 398, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(393, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(0, 1080, Short.MAX_VALUE)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addGap(14, 14, 14)
                                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(label9, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label8, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label13, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(label14, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                    .addGap(0, 11, Short.MAX_VALUE)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(label16, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label15, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label17, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)))
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField5, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField6, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField7, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField8, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField9, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 533, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label10, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))))
                    .addGap(15, 15, 15))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(68, 68, 68)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label8, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label9, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label13, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                            .addGap(22, 22, 22)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label14, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textField7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label15, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textField8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label16, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                            .addGap(23, 23, 23)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textField9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label17, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label10, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(button1)
                    .addContainerGap(13, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - xxx holic
    private JLabel label1;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label13;
    private JLabel label14;
    private JLabel label15;
    private JLabel label16;
    private JLabel label17;
    private JScrollPane scrollPane1;
    private JTextPane textPane1;
    private JTextField textField1;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JButton button1;
    private JPanel panel1;
    private JComboBox<String> comboBox1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        JFrame frame=new Release("dbj");
        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
