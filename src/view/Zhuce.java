/*
 * Created by JFormDesigner on Wed Apr 26 09:58:53 CST 2017
 */

package view;

import domain.Member;
import service.MemberService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author xxx holic
 */
public class Zhuce extends JFrame {

    public Zhuce() {
        initComponents();
        afterInit();
    }

    private void afterInit() {

    }

    private void memberActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void quedingActionPerformed(ActionEvent e) {
        MemberService memberService = new MemberService();
        String text1 = textField6.getText();//获取文本框值
        String text2 = textField7.getText();
        String text3 = textField8.getText();
        String text4 = textField9.getText();

        Member member = new Member();
        member.setMe_name(text1);
        member.setSex(text2);
        member.setPhone(text3);
        member.setPassword(text4);

        try {
            if (text1==null || memberService.judge(text1)==true) {
                JOptionPane.showMessageDialog(null, "用户错误！");
            }else {
                memberService.register(member);
                JOptionPane.showMessageDialog(null,"注册成功");
                Zhuce.this.setVisible(false);//关闭注册窗口
                new DengLu().setVisible(true);//打开CityForYou窗口
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }


    private void quxiaoActionPerformed(ActionEvent e) {
        Zhuce.this.setVisible(false);
        new DengLu().setVisible(true);
    }

    private void button4ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void button3ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - xxx holic
        layeredPane1 = new JLayeredPane();
        panel2 = new JPanel();
        label2 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label3 = new JLabel();
        textField6 = new JTextField();
        textField7 = new JTextField();
        textField8 = new JTextField();
        textField9 = new JTextField();
        button3 = new JButton();
        button4 = new JButton();
        panel1 = new JPanel();
        label6 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();

        //======== layeredPane1 ========
        {

            //======== panel2 ========
            {
                panel2.setOpaque(false);

                // JFormDesigner evaluation mark
                panel2.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new Font("Dialog", Font.BOLD, 12),
                        Color.red), panel2.getBorder())); panel2.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


                //---- label2 ----
                label2.setText("\u7528\u6237\u540d\uff1a");
                label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 5f));
                label2.setForeground(Color.black);

                //---- label4 ----
                label4.setText("\u6027\u522b\uff1a");
                label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 5f));
                label4.setForeground(Color.black);

                //---- label5 ----
                label5.setText("\u624b\u673a\u53f7\uff1a");
                label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 5f));
                label5.setForeground(Color.black);

                //---- label3 ----
                label3.setText("\u5bc6\u7801\uff1a");
                label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 5f));
                label3.setForeground(Color.black);

                //---- textField6 ----
                textField6.addActionListener(e -> memberActionPerformed(e));

                //---- button3 ----
                button3.setText("\u786e\u5b9a");
                button3.setFont(button3.getFont().deriveFont(button3.getFont().getSize() + 5f));
                button3.addActionListener(e -> {
			button3ActionPerformed(e);
			quedingActionPerformed(e);
		});

                //---- button4 ----
                button4.setText("\u53d6\u6d88");
                button4.setFont(button4.getFont().deriveFont(button4.getFont().getSize() + 5f));
                button4.addActionListener(e -> {
			quxiaoActionPerformed(e);
			button4ActionPerformed(e);
			quxiaoActionPerformed(e);
		});

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                            .addContainerGap(73, Short.MAX_VALUE)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGroup(panel2Layout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                            .addGroup(panel2Layout.createParallelGroup()
                                                .addComponent(label2)
                                                .addComponent(label4))
                                            .addGap(47, 47, 47))
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                            .addGroup(panel2Layout.createParallelGroup()
                                                .addComponent(label3)
                                                .addComponent(label5))
                                            .addGap(49, 49, 49)))
                                    .addGroup(panel2Layout.createParallelGroup()
                                        .addComponent(textField9, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textField8, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textField7, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textField6, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
                                    .addGap(142, 142, 142))
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addComponent(button3)
                                    .addGap(80, 80, 80)
                                    .addComponent(button4)
                                    .addGap(130, 130, 130))))
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addContainerGap(119, Short.MAX_VALUE)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label2)
                                .addComponent(textField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label4)
                                .addComponent(textField7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(5, 5, 5)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label5)
                                .addComponent(textField8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textField9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label3))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(button3)
                                .addComponent(button4))
                            .addGap(19, 19, 19))
                );
            }
            layeredPane1.add(panel2, JLayeredPane.DEFAULT_LAYER);
            panel2.setBounds(10, 20, 505, 310);

            //======== panel1 ========
            {

                //---- label6 ----
                label6.setIcon(new ImageIcon("D:\\merc\\merc\\picture\\A7Z(6E5NZZ]{_MTGGI~9_MP.png"));

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addComponent(label6)
                            .addGap(0, 0, Short.MAX_VALUE))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addComponent(label6, GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                            .addContainerGap())
                );
            }
            layeredPane1.add(panel1, JLayeredPane.DEFAULT_LAYER);
            panel1.setBounds(0, 0, 530, 370);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(layeredPane1, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(layeredPane1, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - xxx holic
    private JLayeredPane layeredPane1;
    private JPanel panel2;
    private JLabel label2;
    private JLabel label4;
    private JLabel label5;
    private JLabel label3;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JButton button3;
    private JButton button4;
    private JPanel panel1;
    private JLabel label6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        JFrame frame = new Zhuce();
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
