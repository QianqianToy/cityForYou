/*
 * Created by JFormDesigner on Wed Apr 26 15:02:03 CST 2017
 */

package view;

import command.FindByNameCommand;
import netword.NetClient;
import service.MemberService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 * @author xxx holic
 */
public class DengLu extends JFrame {

    private List<String> ls;
    private NetClient client;

    public DengLu() {
        initComponents();
        this.ls = ls;
        client = new NetClient();
        System.out.println("c0======");
        try {
            client.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void zhuce2ctionPerformed(ActionEvent e) {
        DengLu.this.setVisible(false);
        new Zhuce().setVisible(true);
    }

    private void denglu2ActionPerformed(ActionEvent e) {
        String text1 = textField1.getText();
        String text2 = textField2.getText();
        String comboBox = comboBox1.getSelectedItem().toString();

        MemberService memberService = new MemberService();
        int x = 0;

        try {
            FindByNameCommand fc = new FindByNameCommand();
            fc.setName(text1);
            fc.setPasskey(text2);
            fc.setType(comboBox);
            client.send(fc);
            fc = (FindByNameCommand) client.receive();
            x = (int) fc.getResult();
        } catch (Exception ee) {
            ee.printStackTrace();
        }
        show(x,text1,comboBox);
    }
    private void show(int x,String text1,String comboBox) {
        try {
            int result = x;
            if(result == 0){
                JOptionPane.showMessageDialog(null,"用户错误");
            }else{
                JOptionPane.showMessageDialog(null,(text1 + "，欢迎您！"));
                if (comboBox.equals("普通用户")) {
                    DengLu.this.setVisible(false);
                    CityForYou cfy = new CityForYou(text1);
                    cfy.setpyName(text1);
                    cfy.setVisible(true);

                }else {
                    DengLu.this.setVisible(false);
                    AdminView ad = new AdminView();
                    ad.setVisible(true);
                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }






    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - xxx holic
        layeredPane1 = new JLayeredPane();
        panel2 = new JPanel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        label5 = new JLabel();
        comboBox1 = new JComboBox<>();
        panel1 = new JPanel();
        label1 = new JLabel();

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
                label2.setText("  \u4f1a\u5458\u767b\u5f55");
                label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 12f));
                label2.setForeground(Color.black);

                //---- label3 ----
                label3.setText("\u7528\u6237\u540d\uff1a");
                label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 5f));
                label3.setForeground(Color.black);

                //---- label4 ----
                label4.setText("\u5bc6\u7801\uff1a");
                label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 5f));
                label4.setForeground(Color.black);

                //---- textField1 ----
                textField1.setCaretColor(new Color(153, 153, 153));
                textField1.setForeground(new Color(102, 102, 102));
                textField1.setSelectedTextColor(new Color(102, 102, 102));

                //---- button1 ----
                button1.setText("\u767b\u5f55");
                button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 5f));
                button1.addActionListener(e -> denglu2ActionPerformed(e));

                //---- button2 ----
                button2.setText("\u6ce8\u518c");
                button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 5f));
                button2.addActionListener(e -> zhuce2ctionPerformed(e));

                //---- label5 ----
                label5.setText("\u7528\u6237\u7c7b\u578b\uff1a");
                label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 5f));
                label5.setForeground(Color.black);

                //---- comboBox1 ----
                comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
                    "\u7ba1\u7406\u5458",
                    "\u666e\u901a\u7528\u6237"
                }));

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGroup(panel2Layout.createParallelGroup()
                                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                            .addComponent(label3)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                            .addComponent(label4)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)))
                                    .addContainerGap())
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(button1)
                                        .addComponent(label5))
                                    .addGroup(panel2Layout.createParallelGroup()
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 25, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                            .addComponent(button2)
                                            .addContainerGap())))))
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label3))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label4))
                            .addGap(18, 18, 18)
                            .addGroup(panel2Layout.createParallelGroup()
                                .addComponent(label5)
                                .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(button1)
                                .addComponent(button2)))
                );
            }
            layeredPane1.add(panel2, JLayeredPane.DEFAULT_LAYER);
            panel2.setBounds(10, 25, 200, 255);

            //======== panel1 ========
            {

                //---- label1 ----
                label1.setIcon(new ImageIcon("D:\\merc\\merc\\picture\\01.jpg"));

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 14, Short.MAX_VALUE))
                );
            }
            layeredPane1.add(panel1, JLayeredPane.DEFAULT_LAYER);
            panel1.setBounds(-5, -5, 445, 380);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(layeredPane1, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
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
    private JLabel label3;
    private JLabel label4;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JButton button2;
    private JLabel label5;
    private JComboBox<String> comboBox1;
    private JPanel panel1;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args) {
        JFrame frame = new DengLu();
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
