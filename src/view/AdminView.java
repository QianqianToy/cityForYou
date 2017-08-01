/*
 * Created by JFormDesigner on Mon May 01 11:44:08 CST 2017
 */

package view;


import java.awt.event.*;
import javax.swing.event.*;

import domain.*;
import service.*;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * @author xxx holic
 */
public class AdminView extends JFrame {

    private MemberService memberService = new MemberService();
    private TaskService taskService = new TaskService();
    private ComplaintService complaintService = new ComplaintService();
    private NoticeService noticeService = new NoticeService();
    private SenseService senseService = new SenseService();

    public AdminView() {
        initComponents();
        afterInit();
    }

    private void afterInit() {
        findAllMember();
        findTaskByStateToTable(table8, "待接受", "");
        findTaskByStateToTable(table9, "已接受", "");
        findTaskByStateToTable(table10, "已完成", "已放弃");
        findNoticeToTable(table11);
        findComplaintToTable(table12);
        findSenesToTable(table1);
    }

    private void findSenesToTable(JTable table) {
        DefaultTableModel dtm1 = new DefaultTableModel();
        table.setModel(dtm1);
        List<Senses> senses = null;
        try {
            senses = senseService.view();
            Object [] [] data = new Object[senses.size()][];
            for (int i = 0; i < senses.size(); i++)
                data[i] = senses.get(i).toStringArrays();
            String [] header = {"敏感字"};
            dtm1.setDataVector(data, header);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void findAllMember() {
        DefaultTableModel dtm = new DefaultTableModel();
        table7.setModel(dtm);
        List<Member> members = null;
        try {
            members = memberService.findAll();
            Object [] [] data = new Object[members.size()][];
            for (int i = 0; i < members.size(); i++)
                data[i] = members.get(i).toStringArray();
            String [] header = {"账号","密码","用户类别","电话","性别","信用度"};
            dtm.setDataVector(data, header);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void findTaskByStateToTable(JTable jTable, String state1, String state2) {
        DefaultTableModel dtm = new DefaultTableModel();
        jTable.setModel(dtm);
        List<Task> tasks = null;
        try {
            tasks = taskService.findTaskByState(state1, state2);
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

    public void findNoticeToTable(JTable jTable) {
        DefaultTableModel dtm = new DefaultTableModel();
        jTable.setModel(dtm);

        List<Notice> find = null;
        try {
            find = noticeService.findNotice();//什么都不需要传进去,不需要Notice notice
            Object [] [] data = new Object[find.size()][];
            for (int i = 0; i < find.size(); i++)
                data[i] = find.get(i).toStringArray();
            String [] header = {"公告编号","公告内容","发布时间"};
            dtm.setDataVector(data, header);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }

    public void findComplaintToTable(JTable jTable) {
        DefaultTableModel dtm = new DefaultTableModel();
        jTable.setModel(dtm);

        List<Complaint> find = null;
        try {
            find = complaintService.findComplaint();
            Object [] [] data = new Object[find.size()][];
            for (int i = 0; i < find.size(); i++)
                data[i] = find.get(i).toStringArray();//1
            String [] header = {"投诉编号","投诉内容","投诉时间","被投诉人","投诉人"};
            dtm.setDataVector(data, header);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    private void button6ActionPerformed(ActionEvent e) {

        try{
            String n_content = textArea4.getText();//获取文本框的内容
            //调用service中的addNotice方法,传递notice实例
            noticeService.addNotice(n_content);
        }catch (Exception e1){
            e1.printStackTrace();
        }
        //弹出窗口显示发布成功
        JOptionPane.showMessageDialog(null,"发布成功!");
        AdminView.this.setVisible(false);
        new AdminView().setVisible(true);
    }

    private void button1ActionPerformed(ActionEvent e) {
        int n_id = Integer.parseInt(textArea1.getText());
        try {
            noticeService.delNotice(n_id);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        JOptionPane.showMessageDialog(null,"删除成功!");
        AdminView.this.setVisible(false);
        new AdminView().setVisible(true);
    }

    private void button4ActionPerformed(ActionEvent e) {
        DefaultTableModel dtm = new DefaultTableModel();
        table7.setModel(dtm);
        List<Member> members = null;
        try {
            members = memberService.findByName(textArea3.getText());
            Object [] [] data = new Object[members.size()][];
            for (int i = 0; i < members.size(); i++)
                data[i] = members.get(i).toStringArray();
            String [] header = {"账号","密码","用户类别","电话","性别","信用度"};
            dtm.setDataVector(data, header);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

   private void button5ActionPerformed(ActionEvent e) {
       try {
           memberService.delByName(textArea3.getText());
       } catch (Exception e1) {
           e1.printStackTrace();
       }
       AdminView.this.setVisible(false);
       new AdminView().setVisible(true);
   }

   private void button3ActionPerformed(ActionEvent e) {
       // TODO add your code here
       dispose();
       new BadAdd().setVisible(true);
   }

   private void button7ActionPerformed(ActionEvent e) {
       // TODO add your code here
       dispose();
       new BadDel().setVisible(true);
   }

   private void button8ActionPerformed(ActionEvent e) {
       // TODO add your code here

       DefaultTableModel dtm = new DefaultTableModel();
       table1.setModel(dtm);
       List<Senses> senses = null;
       try {
           senses = senseService.view();
           Object [] [] data = new Object[senses.size()][];
           for (int i = 0; i < senses.size(); i++)
               data[i] = senses.get(i).toStringArrays();
           String [] header = {"敏感字"};
           dtm.setDataVector(data, header);
       } catch (Exception e1) {
           e1.printStackTrace();
       }
   }

   private void tabbedPane10StateChanged(ChangeEvent e) {
       // TODO add your code here

   }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - xxx holic
        tabbedPane10 = new JTabbedPane();
        panel12 = new JPanel();
        tabbedPane11 = new JTabbedPane();
        panel13 = new JPanel();
        scrollPane9 = new JScrollPane();
        table7 = new JTable();
        label5 = new JLabel();
        scrollPane10 = new JScrollPane();
        textArea3 = new JTextArea();
        button4 = new JButton();
        button5 = new JButton();
        tabbedPane12 = new JTabbedPane();
        panel20 = new JPanel();
        scrollPane11 = new JScrollPane();
        table8 = new JTable();
        panel21 = new JPanel();
        scrollPane12 = new JScrollPane();
        table9 = new JTable();
        panel22 = new JPanel();
        scrollPane13 = new JScrollPane();
        table10 = new JTable();
        tabbedPane13 = new JTabbedPane();
        panel23 = new JPanel();
        scrollPane14 = new JScrollPane();
        table11 = new JTable();
        label1 = new JLabel();
        textArea1 = new JTextArea();
        button1 = new JButton();
        panel24 = new JPanel();
        label6 = new JLabel();
        scrollPane15 = new JScrollPane();
        textArea4 = new JTextArea();
        button6 = new JButton();
        tabbedPane14 = new JTabbedPane();
        panel25 = new JPanel();
        scrollPane16 = new JScrollPane();
        table12 = new JTable();
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button3 = new JButton();
        button7 = new JButton();
        button8 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== tabbedPane10 ========
        {
            tabbedPane10.addChangeListener(e -> tabbedPane10StateChanged(e));

            //======== panel12 ========
            {

                // JFormDesigner evaluation mark
                panel12.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new Font("Dialog", Font.BOLD, 12),
                        Color.red), panel12.getBorder())); panel12.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


                //======== tabbedPane11 ========
                {
                    tabbedPane11.setTabPlacement(SwingConstants.LEFT);

                    //======== panel13 ========
                    {

                        //======== scrollPane9 ========
                        {
                            scrollPane9.setViewportView(table7);
                        }

                        //---- label5 ----
                        label5.setText("\u8bf7\u8f93\u5165\u7528\u6237\u540d\uff1a");

                        //======== scrollPane10 ========
                        {
                            scrollPane10.setViewportView(textArea3);
                        }

                        //---- button4 ----
                        button4.setText("\u67e5\u627e");
                        button4.addActionListener(e -> button4ActionPerformed(e));

                        //---- button5 ----
                        button5.setText("\u5220\u9664");
                        button5.addActionListener(e -> button5ActionPerformed(e));

                        GroupLayout panel13Layout = new GroupLayout(panel13);
                        panel13.setLayout(panel13Layout);
                        panel13Layout.setHorizontalGroup(
                            panel13Layout.createParallelGroup()
                                .addGroup(panel13Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(panel13Layout.createParallelGroup()
                                        .addComponent(scrollPane9, GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                                        .addGroup(panel13Layout.createSequentialGroup()
                                            .addGap(11, 11, 11)
                                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(scrollPane10, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
                                            .addGap(31, 31, 31)
                                            .addComponent(button4, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(button5, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 104, Short.MAX_VALUE)))
                                    .addContainerGap())
                        );
                        panel13Layout.setVerticalGroup(
                            panel13Layout.createParallelGroup()
                                .addGroup(panel13Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(panel13Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(label5, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                                        .addGroup(GroupLayout.Alignment.LEADING, panel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(button4, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                                            .addComponent(button5, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                                        .addComponent(scrollPane10, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                                    .addGap(11, 11, 11)
                                    .addComponent(scrollPane9, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                                    .addContainerGap())
                        );
                    }
                    tabbedPane11.addTab("\u7528\u6237\u4fe1\u606f", panel13);
                }

                GroupLayout panel12Layout = new GroupLayout(panel12);
                panel12.setLayout(panel12Layout);
                panel12Layout.setHorizontalGroup(
                    panel12Layout.createParallelGroup()
                        .addComponent(tabbedPane11)
                );
                panel12Layout.setVerticalGroup(
                    panel12Layout.createParallelGroup()
                        .addComponent(tabbedPane11)
                );
            }
            tabbedPane10.addTab("\u7528\u6237\u7ba1\u7406", panel12);

            //======== tabbedPane12 ========
            {
                tabbedPane12.setTabPlacement(SwingConstants.LEFT);

                //======== panel20 ========
                {

                    //======== scrollPane11 ========
                    {
                        scrollPane11.setViewportView(table8);
                    }

                    GroupLayout panel20Layout = new GroupLayout(panel20);
                    panel20.setLayout(panel20Layout);
                    panel20Layout.setHorizontalGroup(
                        panel20Layout.createParallelGroup()
                            .addComponent(scrollPane11, GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                    );
                    panel20Layout.setVerticalGroup(
                        panel20Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panel20Layout.createSequentialGroup()
                                .addGap(0, 3, Short.MAX_VALUE)
                                .addComponent(scrollPane11, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE))
                    );
                }
                tabbedPane12.addTab("\u67e5\u770b\u5f85\u63a5\u53d7\u4efb\u52a1", panel20);

                //======== panel21 ========
                {

                    //======== scrollPane12 ========
                    {
                        scrollPane12.setViewportView(table9);
                    }

                    GroupLayout panel21Layout = new GroupLayout(panel21);
                    panel21.setLayout(panel21Layout);
                    panel21Layout.setHorizontalGroup(
                        panel21Layout.createParallelGroup()
                            .addGroup(panel21Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane12, GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                                .addContainerGap())
                    );
                    panel21Layout.setVerticalGroup(
                        panel21Layout.createParallelGroup()
                            .addGroup(panel21Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane12, GroupLayout.PREFERRED_SIZE, 399, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                }
                tabbedPane12.addTab("\u67e5\u770b\u5df2\u63a5\u53d7\u4efb\u52a1", panel21);

                //======== panel22 ========
                {

                    //======== scrollPane13 ========
                    {
                        scrollPane13.setViewportView(table10);
                    }

                    GroupLayout panel22Layout = new GroupLayout(panel22);
                    panel22.setLayout(panel22Layout);
                    panel22Layout.setHorizontalGroup(
                        panel22Layout.createParallelGroup()
                            .addGroup(panel22Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane13, GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                                .addContainerGap())
                    );
                    panel22Layout.setVerticalGroup(
                        panel22Layout.createParallelGroup()
                            .addGroup(panel22Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane13, GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                                .addContainerGap())
                    );
                }
                tabbedPane12.addTab("\u67e5\u770b\u5386\u53f2\u4efb\u52a1", panel22);
            }
            tabbedPane10.addTab("\u4efb\u52a1\u7ba1\u7406", tabbedPane12);

            //======== tabbedPane13 ========
            {
                tabbedPane13.setTabPlacement(SwingConstants.LEFT);

                //======== panel23 ========
                {

                    //======== scrollPane14 ========
                    {
                        scrollPane14.setViewportView(table11);
                    }

                    //---- label1 ----
                    label1.setText("\u8bf7\u8f93\u5165\u54e6\u516c\u544a\u7f16\u53f7\uff1a");

                    //---- button1 ----
                    button1.setText("\u5220\u9664");
                    button1.addActionListener(e -> button1ActionPerformed(e));

                    GroupLayout panel23Layout = new GroupLayout(panel23);
                    panel23.setLayout(panel23Layout);
                    panel23Layout.setHorizontalGroup(
                        panel23Layout.createParallelGroup()
                            .addGroup(panel23Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane14, GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(panel23Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(label1)
                                .addGap(18, 18, 18)
                                .addComponent(textArea1, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(113, Short.MAX_VALUE))
                    );
                    panel23Layout.setVerticalGroup(
                        panel23Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panel23Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panel23Layout.createParallelGroup()
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel23Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(button1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                                        .addComponent(textArea1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(scrollPane14, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                    );
                }
                tabbedPane13.addTab("\u67e5\u770b\u516c\u544a", panel23);

                //======== panel24 ========
                {

                    //---- label6 ----
                    label6.setText("\u8bf7\u8f93\u5165\u516c\u544a\u5185\u5bb9\uff1a");
                    label6.setIcon(null);

                    //======== scrollPane15 ========
                    {
                        scrollPane15.setViewportView(textArea4);
                    }

                    //---- button6 ----
                    button6.setText("\u53d1\u5e03");
                    button6.addActionListener(e -> button6ActionPerformed(e));

                    GroupLayout panel24Layout = new GroupLayout(panel24);
                    panel24.setLayout(panel24Layout);
                    panel24Layout.setHorizontalGroup(
                        panel24Layout.createParallelGroup()
                            .addGroup(panel24Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel24Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(button6, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel24Layout.createParallelGroup()
                                        .addComponent(scrollPane15, GroupLayout.PREFERRED_SIZE, 468, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(95, Short.MAX_VALUE))
                    );
                    panel24Layout.setVerticalGroup(
                        panel24Layout.createParallelGroup()
                            .addGroup(panel24Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label6, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollPane15, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(button6)
                                .addContainerGap(42, Short.MAX_VALUE))
                    );
                }
                tabbedPane13.addTab("\u53d1\u5e03\u516c\u544a", panel24);
            }
            tabbedPane10.addTab("\u516c\u544a\u7ba1\u7406", tabbedPane13);

            //======== tabbedPane14 ========
            {
                tabbedPane14.setTabPlacement(SwingConstants.LEFT);

                //======== panel25 ========
                {

                    //======== scrollPane16 ========
                    {
                        scrollPane16.setViewportView(table12);
                    }

                    GroupLayout panel25Layout = new GroupLayout(panel25);
                    panel25.setLayout(panel25Layout);
                    panel25Layout.setHorizontalGroup(
                        panel25Layout.createParallelGroup()
                            .addGroup(panel25Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane16, GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                                .addContainerGap())
                    );
                    panel25Layout.setVerticalGroup(
                        panel25Layout.createParallelGroup()
                            .addGroup(panel25Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane16, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                }
                tabbedPane14.addTab("\u67e5\u770b\u6295\u8bc9", panel25);
            }
            tabbedPane10.addTab("\u6295\u8bc9\u7ba1\u7406", tabbedPane14);

            //======== tabbedPane1 ========
            {
                tabbedPane1.setTabPlacement(SwingConstants.LEFT);

                //======== panel1 ========
                {

                    //======== scrollPane1 ========
                    {
                        scrollPane1.setViewportView(table1);
                    }

                    //---- button3 ----
                    button3.setText("\u6dfb\u52a0");
                    button3.addActionListener(e -> button3ActionPerformed(e));

                    //---- button7 ----
                    button7.setText("\u5220\u9664");
                    button7.addActionListener(e -> button7ActionPerformed(e));

                    //---- button8 ----
                    button8.setText("\u5237\u65b0");
                    button8.addActionListener(e -> button8ActionPerformed(e));

                    GroupLayout panel1Layout = new GroupLayout(panel1);
                    panel1.setLayout(panel1Layout);
                    panel1Layout.setHorizontalGroup(
                        panel1Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addContainerGap(264, Short.MAX_VALUE)
                                .addComponent(button8)
                                .addGap(59, 59, 59)
                                .addComponent(button3)
                                .addGap(50, 50, 50)
                                .addComponent(button7)
                                .addGap(22, 22, 22))
                    );
                    panel1Layout.setVerticalGroup(
                        panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(button3)
                                    .addComponent(button7)
                                    .addComponent(button8))
                                .addGap(23, 23, 23))
                    );
                }
                tabbedPane1.addTab("\u654f\u611f\u5b57\u7ba1\u7406", panel1);
            }
            tabbedPane10.addTab("\u654f\u611f\u5b57\u7ba1\u7406", tabbedPane1);
        }
        contentPane.add(tabbedPane10, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - xxx holic
    private JTabbedPane tabbedPane10;
    private JPanel panel12;
    private JTabbedPane tabbedPane11;
    private JPanel panel13;
    private JScrollPane scrollPane9;
    private JTable table7;
    private JLabel label5;
    private JScrollPane scrollPane10;
    private JTextArea textArea3;
    private JButton button4;
    private JButton button5;
    private JTabbedPane tabbedPane12;
    private JPanel panel20;
    private JScrollPane scrollPane11;
    private JTable table8;
    private JPanel panel21;
    private JScrollPane scrollPane12;
    private JTable table9;
    private JPanel panel22;
    private JScrollPane scrollPane13;
    private JTable table10;
    private JTabbedPane tabbedPane13;
    private JPanel panel23;
    private JScrollPane scrollPane14;
    private JTable table11;
    private JLabel label1;
    private JTextArea textArea1;
    private JButton button1;
    private JPanel panel24;
    private JLabel label6;
    private JScrollPane scrollPane15;
    private JTextArea textArea4;
    private JButton button6;
    private JTabbedPane tabbedPane14;
    private JPanel panel25;
    private JScrollPane scrollPane16;
    private JTable table12;
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button3;
    private JButton button7;
    private JButton button8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args) {
        JFrame frame = new AdminView();
        frame.setSize(1500,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
