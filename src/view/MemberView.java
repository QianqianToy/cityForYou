/*
 * Created by JFormDesigner on Mon May 01 17:02:56 CST 2017
 */

package view;

import domain.Member;
import domain.Task;
import service.ComplaintService;
import service.MemberService;
import service.TaskService;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;


/**
 * @author xxx holic
 */
public class MemberView extends JFrame {

    private MemberService memberService = new MemberService();
    private TaskService taskService = new TaskService();
    private AdminView adminView = new AdminView();
    private ComplaintService complaintService = new ComplaintService();
    private String pyName;

    public MemberView(String pyname) {
        initComponents();
        pyName = pyname;
        findMemberByName(pyName);
        findTaskByNameAndStateToTable(table5, pyName, "已接受", "已接受");
        findTaskByNameAndStateToTable(table7, pyName, "待接受", "待接受");
        findTaskByNameAndStateToTable(table6, pyName, "已完成", "已放弃");
        adminView.findTaskByStateToTable(table4,"待接受", "待接受");
        adminView.findComplaintToTable(table2);
        adminView.findNoticeToTable(table3);
    }

    public void findMemberByName(String pyName) {
        DefaultTableModel dtm = new DefaultTableModel();
        table1.setModel(dtm);
        List<Member> members = null;
        try {
            members = memberService.findByName(pyName);
            Object [] [] data = new Object[members.size()][];
            for (int i = 0; i < members.size(); i++)
                data[i] = members.get(i).toStringArray();
            String [] header = {"账号","密码","用户类别","电话","性别","信用度"};
            dtm.setDataVector(data, header);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void findTaskByNameAndStateToTable(JTable jTable, String me_name, String state1, String state2) {
        DefaultTableModel dtm = new DefaultTableModel();
        jTable.setModel(dtm);
        List<Task> tasks = null;
        try {
            tasks = taskService.findTaskByNameAndState(me_name, state1, state2);
            Object [] [] data = new Object[tasks.size()][];
            for (int i = 0; i < tasks.size(); i++)
                data[i] = tasks.get(i).taskToStringArray();
            String [] header = {"任务编号","任务名称","任务类型","任务描述","发布者","接收者","开始时间"
                    ,"结束时间","地址","赏金","违约金"};
            dtm.setDataVector(data, header);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    private void button1ActionPerformed(ActionEvent e) {
        MemberView.this.setVisible(false);
        UpdateMember updateMember = new UpdateMember(pyName);
        updateMember.setVisible(true);
    }

    private void button7ActionPerformed(ActionEvent e) {
        try{
            String c_tname = textArea5.getText();
            String me_name = pyName;
            String content = textArea6.getText();
            complaintService.addComplaint(content,c_tname,me_name);
        }catch (Exception e1){
            e1.printStackTrace();
        }
        JOptionPane.showMessageDialog(null,"投诉成功!");
    }

    private void button5ActionPerformed(ActionEvent e) {
        try {
            taskService.delTaskById(Integer.parseInt(textArea3.getText()));
            JOptionPane.showMessageDialog(null,"删除成功!");
            dispose();
            new MemberView(pyName).setVisible(true);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }

    private void button6ActionPerformed(ActionEvent e) {
        try {
            taskService.delTaskById(Integer.parseInt(textArea4.getText()));
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }

    private void button2ActionPerformed(ActionEvent e) {
        DefaultTableModel dtm = new DefaultTableModel();
        table4.setModel(dtm);
        List<Task> tasks = null;
        try {
            tasks = taskService.slurFindTask(textArea1.getText());
            Object [] [] data = new Object[tasks.size()][];
            for (int i = 0; i < tasks.size(); i++)
                data[i] = tasks.get(i).taskToStringArray();
            String [] header = {"任务编号","任务名称","任务类型","任务描述","发布者","接收者","开始时间"
                    ,"结束时间","地址","赏金","违约金"};
            dtm.setDataVector(data, header);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    private void button10ActionPerformed(ActionEvent e) {
        MemberView.this.setVisible(false);
        new CityForYou(pyName).setVisible(true);
    }

    private void button8ActionPerformed(ActionEvent e) {
        MemberView.this.setVisible(false);
        new Release(pyName).setVisible(true);
    }

    private void tabbedPane4StateChanged(ChangeEvent e) {
        adminView.findComplaintToTable(table2);
    }

    private void button3ActionPerformed(ActionEvent e) {
        try {
            taskService.changeTaskState(Integer.parseInt(textArea2.getText()), "已完成");
            memberService.addReputation(pyName);
            JOptionPane.showMessageDialog(null,"提交成功!");
            dispose();
            new MemberView(pyName).setVisible(true);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    private void button4ActionPerformed(ActionEvent e) {
        try {
            taskService.changeTaskState(Integer.parseInt(textArea2.getText()), "已放弃");
            memberService.subReputation(pyName);
            JOptionPane.showMessageDialog(null,"放弃成功!");
            dispose();
            new MemberView(pyName).setVisible(true);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    private void button9ActionPerformed(ActionEvent e) {
        try {
            taskService.slurFindUpdataState(pyName, Integer.parseInt(textArea7.getText()));
            JOptionPane.showMessageDialog(null,"接受成功!");
            dispose();
            new MemberView(pyName).setVisible(true);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - xxx holic
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        tabbedPane2 = new JTabbedPane();
        panel5 = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button10 = new JButton();
        panel2 = new JPanel();
        tabbedPane3 = new JTabbedPane();
        panel9 = new JPanel();
        scrollPane8 = new JScrollPane();
        table6 = new JTable();
        label3 = new JLabel();
        scrollPane9 = new JScrollPane();
        textArea3 = new JTextArea();
        button5 = new JButton();
        panel10 = new JPanel();
        scrollPane10 = new JScrollPane();
        table7 = new JTable();
        label4 = new JLabel();
        scrollPane11 = new JScrollPane();
        textArea4 = new JTextArea();
        button6 = new JButton();
        button8 = new JButton();
        panel6 = new JPanel();
        scrollPane4 = new JScrollPane();
        table4 = new JTable();
        scrollPane5 = new JScrollPane();
        textArea1 = new JTextArea();
        label1 = new JLabel();
        button2 = new JButton();
        label7 = new JLabel();
        scrollPane14 = new JScrollPane();
        textArea7 = new JTextArea();
        button9 = new JButton();
        panel7 = new JPanel();
        scrollPane6 = new JScrollPane();
        table5 = new JTable();
        scrollPane7 = new JScrollPane();
        textArea2 = new JTextArea();
        label2 = new JLabel();
        button3 = new JButton();
        button4 = new JButton();
        panel3 = new JPanel();
        tabbedPane4 = new JTabbedPane();
        panel12 = new JPanel();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        panel13 = new JPanel();
        label5 = new JLabel();
        scrollPane12 = new JScrollPane();
        textArea5 = new JTextArea();
        label6 = new JLabel();
        scrollPane13 = new JScrollPane();
        textArea6 = new JTextArea();
        button7 = new JButton();
        panel4 = new JPanel();
        tabbedPane5 = new JTabbedPane();
        panel14 = new JPanel();
        scrollPane3 = new JScrollPane();
        table3 = new JTable();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== tabbedPane1 ========
        {

            //======== panel1 ========
            {

                // JFormDesigner evaluation mark
                panel1.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new Font("Dialog", Font.BOLD, 12),
                        Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


                //======== tabbedPane2 ========
                {
                    tabbedPane2.setTabPlacement(SwingConstants.LEFT);

                    //======== panel5 ========
                    {

                        //======== scrollPane1 ========
                        {
                            scrollPane1.setViewportView(table1);
                        }

                        //---- button1 ----
                        button1.setText("\u4fee\u6539\u4e2a\u4eba\u4fe1\u606f");
                        button1.addActionListener(e -> {
			button1ActionPerformed(e);
			button1ActionPerformed(e);
		});

                        //---- button10 ----
                        button10.setText("\u8fd4\u56de\u4e3b\u9875");
                        button10.addActionListener(e -> button10ActionPerformed(e));

                        GroupLayout panel5Layout = new GroupLayout(panel5);
                        panel5.setLayout(panel5Layout);
                        panel5Layout.setHorizontalGroup(
                            panel5Layout.createParallelGroup()
                                .addGroup(panel5Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                                    .addContainerGap())
                                .addGroup(GroupLayout.Alignment.TRAILING, panel5Layout.createSequentialGroup()
                                    .addGap(21, 21, 21)
                                    .addComponent(button10)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 279, Short.MAX_VALUE)
                                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                                    .addGap(19, 19, 19))
                        );
                        panel5Layout.setVerticalGroup(
                            panel5Layout.createParallelGroup()
                                .addGroup(panel5Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(panel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        );
                    }
                    tabbedPane2.addTab("\u4e2a\u4eba\u4fe1\u606f\u8be6\u60c5", panel5);
                }

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addComponent(tabbedPane2)
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addComponent(tabbedPane2)
                );
            }
            tabbedPane1.addTab("\u4e2a\u4eba\u4fe1\u606f", panel1);

            //======== panel2 ========
            {

                //======== tabbedPane3 ========
                {
                    tabbedPane3.setTabPlacement(SwingConstants.LEFT);

                    //======== panel9 ========
                    {

                        //======== scrollPane8 ========
                        {
                            scrollPane8.setViewportView(table6);
                        }

                        //---- label3 ----
                        label3.setText("\u8bf7\u8f93\u5165\u4efb\u52a1\u7f16\u53f7\uff1a");

                        //======== scrollPane9 ========
                        {
                            scrollPane9.setViewportView(textArea3);
                        }

                        //---- button5 ----
                        button5.setText("\u5220\u9664");
                        button5.addActionListener(e -> {
			button5ActionPerformed(e);
			button5ActionPerformed(e);
		});

                        GroupLayout panel9Layout = new GroupLayout(panel9);
                        panel9.setLayout(panel9Layout);
                        panel9Layout.setHorizontalGroup(
                            panel9Layout.createParallelGroup()
                                .addGroup(panel9Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(scrollPane8, GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                                    .addContainerGap())
                                .addGroup(panel9Layout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(scrollPane9, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(button5, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(86, Short.MAX_VALUE))
                        );
                        panel9Layout.setVerticalGroup(
                            panel9Layout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, panel9Layout.createSequentialGroup()
                                    .addContainerGap(13, Short.MAX_VALUE)
                                    .addGroup(panel9Layout.createParallelGroup()
                                        .addComponent(scrollPane9, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button5, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label3, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addComponent(scrollPane8, GroupLayout.PREFERRED_SIZE, 371, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap())
                        );
                    }
                    tabbedPane3.addTab("\u67e5\u770b\u4e2a\u4eba\u5386\u53f2\u4efb\u52a1", panel9);

                    //======== panel10 ========
                    {

                        //======== scrollPane10 ========
                        {
                            scrollPane10.setViewportView(table7);
                        }

                        //---- label4 ----
                        label4.setText("\u8bf7\u8f93\u5165\u4efb\u52a1\u7f16\u53f7\uff1a");

                        //======== scrollPane11 ========
                        {
                            scrollPane11.setViewportView(textArea4);
                        }

                        //---- button6 ----
                        button6.setText("\u64a4\u9500");
                        button6.addActionListener(e -> button6ActionPerformed(e));

                        //---- button8 ----
                        button8.setText("\u6211\u8981\u53d1\u5e03\u4efb\u52a1");
                        button8.addActionListener(e -> button8ActionPerformed(e));

                        GroupLayout panel10Layout = new GroupLayout(panel10);
                        panel10.setLayout(panel10Layout);
                        panel10Layout.setHorizontalGroup(
                            panel10Layout.createParallelGroup()
                                .addGroup(panel10Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(panel10Layout.createParallelGroup()
                                        .addComponent(scrollPane10, GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                                        .addGroup(panel10Layout.createSequentialGroup()
                                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(scrollPane11, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                                            .addGap(31, 31, 31)
                                            .addComponent(button6, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                            .addContainerGap(71, Short.MAX_VALUE))))
                                .addGroup(GroupLayout.Alignment.TRAILING, panel10Layout.createSequentialGroup()
                                    .addContainerGap(355, Short.MAX_VALUE)
                                    .addComponent(button8, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                    .addGap(15, 15, 15))
                        );
                        panel10Layout.setVerticalGroup(
                            panel10Layout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, panel10Layout.createSequentialGroup()
                                    .addContainerGap(11, Short.MAX_VALUE)
                                    .addGroup(panel10Layout.createParallelGroup()
                                        .addGroup(panel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(label4, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                                            .addComponent(scrollPane11, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                                        .addComponent(button6, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                    .addComponent(scrollPane10, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(button8)
                                    .addGap(10, 10, 10))
                        );
                    }
                    tabbedPane3.addTab("\u67e5\u770b\u4e2a\u4eba\u53d1\u5e03\u7684\u4efb\u52a1", panel10);

                    //======== panel6 ========
                    {

                        //======== scrollPane4 ========
                        {
                            scrollPane4.setViewportView(table4);
                        }

                        //======== scrollPane5 ========
                        {
                            scrollPane5.setViewportView(textArea1);
                        }

                        //---- label1 ----
                        label1.setText("\u8bf7\u8f93\u5165\u4efb\u52a1\u540d\uff1a");

                        //---- button2 ----
                        button2.setText("\u641c\u7d22");
                        button2.addActionListener(e -> button2ActionPerformed(e));

                        //---- label7 ----
                        label7.setText("\u8bf7\u8f93\u5165\u4efb\u52a1\u7f16\u53f7\uff1a");

                        //======== scrollPane14 ========
                        {
                            scrollPane14.setViewportView(textArea7);
                        }

                        //---- button9 ----
                        button9.setText("\u63a5\u53d7");
                        button9.addActionListener(e -> button9ActionPerformed(e));

                        GroupLayout panel6Layout = new GroupLayout(panel6);
                        panel6.setLayout(panel6Layout);
                        panel6Layout.setHorizontalGroup(
                            panel6Layout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, panel6Layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addGroup(panel6Layout.createParallelGroup()
                                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel6Layout.createParallelGroup()
                                        .addComponent(scrollPane5, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(scrollPane14))
                                    .addGap(18, 18, 18)
                                    .addGroup(panel6Layout.createParallelGroup()
                                        .addComponent(button9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panel6Layout.createSequentialGroup()
                                            .addComponent(button2, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE)))
                                    .addGap(75, 75, 75))
                                .addGroup(panel6Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(scrollPane4)
                                    .addContainerGap())
                        );
                        panel6Layout.setVerticalGroup(
                            panel6Layout.createParallelGroup()
                                .addGroup(panel6Layout.createSequentialGroup()
                                    .addGroup(panel6Layout.createParallelGroup()
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panel6Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(scrollPane5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(button2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel6Layout.createParallelGroup()
                                        .addComponent(label7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel6Layout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addGroup(panel6Layout.createParallelGroup()
                                                .addGroup(GroupLayout.Alignment.TRAILING, panel6Layout.createSequentialGroup()
                                                    .addComponent(scrollPane14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(1, 1, 1))
                                                .addComponent(button9, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(scrollPane4, GroupLayout.PREFERRED_SIZE, 354, GroupLayout.PREFERRED_SIZE)
                                    .addGap(8, 8, 8))
                        );
                    }
                    tabbedPane3.addTab("\u67e5\u770b\u53ef\u63a5\u53d7\u4efb\u52a1", panel6);

                    //======== panel7 ========
                    {

                        //======== scrollPane6 ========
                        {
                            scrollPane6.setViewportView(table5);
                        }

                        //======== scrollPane7 ========
                        {
                            scrollPane7.setViewportView(textArea2);
                        }

                        //---- label2 ----
                        label2.setText("\u8bf7\u8f93\u5165\u4efb\u52a1\u7f16\u53f7\uff1a");

                        //---- button3 ----
                        button3.setText("\u63d0\u4ea4");
                        button3.addActionListener(e -> button3ActionPerformed(e));

                        //---- button4 ----
                        button4.setText("\u653e\u5f03");
                        button4.addActionListener(e -> button4ActionPerformed(e));

                        GroupLayout panel7Layout = new GroupLayout(panel7);
                        panel7.setLayout(panel7Layout);
                        panel7Layout.setHorizontalGroup(
                            panel7Layout.createParallelGroup()
                                .addGroup(panel7Layout.createSequentialGroup()
                                    .addGroup(panel7Layout.createParallelGroup()
                                        .addGroup(panel7Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(scrollPane6, GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE))
                                        .addGroup(panel7Layout.createSequentialGroup()
                                            .addGap(22, 22, 22)
                                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(scrollPane7, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(button3, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(button4, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)))
                                    .addContainerGap())
                        );
                        panel7Layout.setVerticalGroup(
                            panel7Layout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, panel7Layout.createSequentialGroup()
                                    .addGroup(panel7Layout.createParallelGroup()
                                        .addGroup(panel7Layout.createSequentialGroup()
                                            .addContainerGap(23, Short.MAX_VALUE)
                                            .addGroup(panel7Layout.createParallelGroup()
                                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(scrollPane7)))
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel7Layout.createSequentialGroup()
                                            .addContainerGap(20, Short.MAX_VALUE)
                                            .addGroup(panel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(button3)
                                                .addComponent(button4))))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(scrollPane6, GroupLayout.PREFERRED_SIZE, 367, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap())
                        );
                    }
                    tabbedPane3.addTab("\u67e5\u770b\u4e2a\u4eba\u5df2\u63a5\u53d7\u4efb\u52a1", panel7);
                }

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(tabbedPane3)
                            .addContainerGap())
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addComponent(tabbedPane3, GroupLayout.Alignment.TRAILING)
                );
            }
            tabbedPane1.addTab("\u4efb\u52a1", panel2);

            //======== panel3 ========
            {

                //======== tabbedPane4 ========
                {
                    tabbedPane4.setTabPlacement(SwingConstants.LEFT);
                    tabbedPane4.addChangeListener(e -> tabbedPane4StateChanged(e));

                    //======== panel12 ========
                    {

                        //======== scrollPane2 ========
                        {
                            scrollPane2.setViewportView(table2);
                        }

                        GroupLayout panel12Layout = new GroupLayout(panel12);
                        panel12.setLayout(panel12Layout);
                        panel12Layout.setHorizontalGroup(
                            panel12Layout.createParallelGroup()
                                .addGroup(panel12Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                                    .addContainerGap())
                        );
                        panel12Layout.setVerticalGroup(
                            panel12Layout.createParallelGroup()
                                .addGroup(panel12Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(8, Short.MAX_VALUE))
                        );
                    }
                    tabbedPane4.addTab("\u67e5\u770b\u6295\u8bc9", panel12);

                    //======== panel13 ========
                    {

                        //---- label5 ----
                        label5.setText("\u8bf7\u586b\u5199\u88ab\u6295\u8bc9\u4eba\uff1a");

                        //======== scrollPane12 ========
                        {
                            scrollPane12.setViewportView(textArea5);
                        }

                        //---- label6 ----
                        label6.setText("\u6295\u8bc9\u5185\u5bb9\uff1a");

                        //======== scrollPane13 ========
                        {
                            scrollPane13.setViewportView(textArea6);
                        }

                        //---- button7 ----
                        button7.setText("\u6295\u8bc9");
                        button7.addActionListener(e -> button7ActionPerformed(e));

                        GroupLayout panel13Layout = new GroupLayout(panel13);
                        panel13.setLayout(panel13Layout);
                        panel13Layout.setHorizontalGroup(
                            panel13Layout.createParallelGroup()
                                .addGroup(panel13Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(panel13Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(button7, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panel13Layout.createParallelGroup()
                                            .addComponent(scrollPane13, GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE)
                                            .addGroup(panel13Layout.createSequentialGroup()
                                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(scrollPane12, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
                                            .addComponent(label6, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)))
                                    .addContainerGap(34, Short.MAX_VALUE))
                        );
                        panel13Layout.setVerticalGroup(
                            panel13Layout.createParallelGroup()
                                .addGroup(panel13Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(panel13Layout.createParallelGroup()
                                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(scrollPane12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, Short.MAX_VALUE)
                                    .addComponent(label6, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(scrollPane13, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                                    .addGap(47, 47, 47)
                                    .addComponent(button7)
                                    .addGap(46, 46, 46))
                        );
                    }
                    tabbedPane4.addTab("\u6211\u8981\u6295\u8bc9", panel13);
                }

                GroupLayout panel3Layout = new GroupLayout(panel3);
                panel3.setLayout(panel3Layout);
                panel3Layout.setHorizontalGroup(
                    panel3Layout.createParallelGroup()
                        .addComponent(tabbedPane4)
                );
                panel3Layout.setVerticalGroup(
                    panel3Layout.createParallelGroup()
                        .addComponent(tabbedPane4)
                );
            }
            tabbedPane1.addTab("\u6295\u8bc9", panel3);

            //======== panel4 ========
            {

                //======== tabbedPane5 ========
                {
                    tabbedPane5.setTabPlacement(SwingConstants.LEFT);

                    //======== panel14 ========
                    {

                        //======== scrollPane3 ========
                        {
                            scrollPane3.setViewportView(table3);
                        }

                        GroupLayout panel14Layout = new GroupLayout(panel14);
                        panel14.setLayout(panel14Layout);
                        panel14Layout.setHorizontalGroup(
                            panel14Layout.createParallelGroup()
                                .addGroup(panel14Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                                    .addContainerGap())
                        );
                        panel14Layout.setVerticalGroup(
                            panel14Layout.createParallelGroup()
                                .addGroup(panel14Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        );
                    }
                    tabbedPane5.addTab("\u67e5\u770b\u516c\u544a", panel14);
                }

                GroupLayout panel4Layout = new GroupLayout(panel4);
                panel4.setLayout(panel4Layout);
                panel4Layout.setHorizontalGroup(
                    panel4Layout.createParallelGroup()
                        .addComponent(tabbedPane5)
                );
                panel4Layout.setVerticalGroup(
                    panel4Layout.createParallelGroup()
                        .addComponent(tabbedPane5)
                );
            }
            tabbedPane1.addTab("\u516c\u544a", panel4);
        }
        contentPane.add(tabbedPane1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - xxx holic
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JTabbedPane tabbedPane2;
    private JPanel panel5;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button10;
    private JPanel panel2;
    private JTabbedPane tabbedPane3;
    private JPanel panel9;
    private JScrollPane scrollPane8;
    private JTable table6;
    private JLabel label3;
    private JScrollPane scrollPane9;
    private JTextArea textArea3;
    private JButton button5;
    private JPanel panel10;
    private JScrollPane scrollPane10;
    private JTable table7;
    private JLabel label4;
    private JScrollPane scrollPane11;
    private JTextArea textArea4;
    private JButton button6;
    private JButton button8;
    private JPanel panel6;
    private JScrollPane scrollPane4;
    private JTable table4;
    private JScrollPane scrollPane5;
    private JTextArea textArea1;
    private JLabel label1;
    private JButton button2;
    private JLabel label7;
    private JScrollPane scrollPane14;
    private JTextArea textArea7;
    private JButton button9;
    private JPanel panel7;
    private JScrollPane scrollPane6;
    private JTable table5;
    private JScrollPane scrollPane7;
    private JTextArea textArea2;
    private JLabel label2;
    private JButton button3;
    private JButton button4;
    private JPanel panel3;
    private JTabbedPane tabbedPane4;
    private JPanel panel12;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JPanel panel13;
    private JLabel label5;
    private JScrollPane scrollPane12;
    private JTextArea textArea5;
    private JLabel label6;
    private JScrollPane scrollPane13;
    private JTextArea textArea6;
    private JButton button7;
    private JPanel panel4;
    private JTabbedPane tabbedPane5;
    private JPanel panel14;
    private JScrollPane scrollPane3;
    private JTable table3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

//    public static void main(String[] args) {
//        JFrame frame = new MemberView();
//        frame.pack();
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }

    public void setpyName(String pyName) {
        this.pyName = pyName;
    }
}
