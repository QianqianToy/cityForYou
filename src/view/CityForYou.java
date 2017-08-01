/*
 * Created by JFormDesigner on Tue Apr 25 19:37:46 CST 2017
 */

package view;

import java.awt.event.*;
import domain.Task;
import service.TaskService;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.text.View;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;

/**
 * @author xxx holic
 */
public class CityForYou extends JFrame {

    private String pyName;

    public CityForYou(String pyname) {
        initComponents();
        pyName = pyname;
        display();
    }

    private void display() {
        this.setVisible(true);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private void tree1ValueChanged(TreeSelectionEvent e) {
        // TODO add your code here
        DefaultMutableTreeNode x = (DefaultMutableTreeNode)e.getPath().getLastPathComponent();
        if (x.isLeaf()){
            String name = x.toString();
            CityForYou.this.setVisible(false);
            Choose choose = new Choose(name,pyName);
            choose.setpyName(pyName);
            choose.setVisible(true);
        }
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        String nameg = textField1.getText();
        CityForYou.this.setVisible(false);
        Table table = new Table(nameg,pyName);
        table.setNameg(nameg);
        table.setpyName(pyName);
        table.setVisible(true);
    }

    private void button2ActionPerformed(ActionEvent e) {
        CityForYou.this.setVisible(false);
        MemberView memberView = new MemberView(pyName);
        memberView.setpyName(pyName);
        new MemberView(pyName).setVisible(true);
    }

    private void tree(DefaultMutableTreeNode root,String name){
        TaskService taskService = new TaskService();
        try {
            java.util.List<Task> taskList = taskService.findAllTasks(name);
            for (Object o :taskList){
                Task aptTask = (Task)o;
                DefaultMutableTreeNode x = new DefaultMutableTreeNode(aptTask.getT_name());
                root.add(x);
            }
        }catch (Exception e1){
            e1.printStackTrace();
        }
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - xxx holic
        layeredPane1 = new JLayeredPane();
        panel2 = new JPanel();
        scrollPane1 = new JScrollPane();
        tree1 = new JTree();
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        panel3 = new JPanel();

        //======== this ========
        setFont(new Font("Dialog", Font.PLAIN, 3));
        setIconImage(new ImageIcon("D:\\merc\\merc\\picture\\denglub1.jpg").getImage());
        Container contentPane = getContentPane();

        //======== layeredPane1 ========
        {

            //======== panel2 ========
            {

                // JFormDesigner evaluation mark
                panel2.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new Font("Dialog", Font.BOLD, 12),
                        Color.red), panel2.getBorder())); panel2.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


                //======== scrollPane1 ========
                {

                    //---- tree1 ----
                    tree1.addTreeSelectionListener(e -> {
			tree1ValueChanged(e);
		});
                    scrollPane1.setViewportView(tree1);
                }

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                );
            }
            layeredPane1.add(panel2, JLayeredPane.DEFAULT_LAYER);
            panel2.setBounds(0, 70, 140, 360);

            //======== panel1 ========
            {

                //---- label1 ----
                label1.setIcon(new ImageIcon("D:\\merc\\merc\\picture\\beijing.jpg"));

                //---- label2 ----
                label2.setText("\u5173\u952e\u5b57\u67e5\u8be2");

                //---- button1 ----
                button1.setText("\u67e5\u8be2");
                button1.addActionListener(e -> button1ActionPerformed(e));

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                            .addContainerGap(8, Short.MAX_VALUE)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 551, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(165, 165, 165)
                            .addComponent(label2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(button1)
                            .addContainerGap(74, Short.MAX_VALUE))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(46, 46, 46)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button1))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label1, GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                            .addGap(21, 21, 21))
                );
            }
            layeredPane1.add(panel1, JLayeredPane.DEFAULT_LAYER);
            panel1.setBounds(145, 15, 565, 427);

            //---- button2 ----
            button2.setText("\u8fdb\u5165\u4e2a\u4eba\u9875\u9762");
            button2.addActionListener(e -> {
			button2ActionPerformed(e);
		});
            layeredPane1.add(button2, JLayeredPane.DEFAULT_LAYER);
            button2.setBounds(15, 15, 125, 43);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(layeredPane1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(layeredPane1, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());

        //======== panel3 ========
        {

            // JFormDesigner evaluation mark
            panel3.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new Font("Dialog", Font.BOLD, 12),
                    Color.red), panel3.getBorder())); panel3.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


            GroupLayout panel3Layout = new GroupLayout(panel3);
            panel3.setLayout(panel3Layout);
            panel3Layout.setHorizontalGroup(
                panel3Layout.createParallelGroup()
                    .addGap(0, 640, Short.MAX_VALUE)
            );
            panel3Layout.setVerticalGroup(
                panel3Layout.createParallelGroup()
                    .addGap(0, 789, Short.MAX_VALUE)
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("r");

        DefaultMutableTreeNode n1 = new DefaultMutableTreeNode("企业管理服务");
        DefaultMutableTreeNode n2 = new DefaultMutableTreeNode("品牌创意服务");
        DefaultMutableTreeNode n3 = new DefaultMutableTreeNode("软件开发服务");
        DefaultMutableTreeNode n4 = new DefaultMutableTreeNode("个人生活服务");
        DefaultMutableTreeNode n5 = new DefaultMutableTreeNode("企业营销服务");
        root.add(n1);
        root.add(n2);
        root.add(n3);
        root.add(n4);
        root.add(n5);
        DefaultMutableTreeNode q1 = new DefaultMutableTreeNode("商标注册");
        DefaultMutableTreeNode q2 = new DefaultMutableTreeNode("开办公司");
        DefaultMutableTreeNode q3 = new DefaultMutableTreeNode("人力资源");
        DefaultMutableTreeNode q4 = new DefaultMutableTreeNode("职业培训");
        n1.add(q1);
        n1.add(q2);
        n1.add(q3);
        n1.add(q4);
        DefaultMutableTreeNode w1 = new DefaultMutableTreeNode("LOGO设计");
        DefaultMutableTreeNode w2 = new DefaultMutableTreeNode("VI设计");
        DefaultMutableTreeNode w3 = new DefaultMutableTreeNode("广告设计");
        DefaultMutableTreeNode w4 = new DefaultMutableTreeNode("视频宣传");
        DefaultMutableTreeNode w5 = new DefaultMutableTreeNode("商品包装");
        n2.add(w1);
        n2.add(w2);
        n2.add(w3);
        n2.add(w4);
        n2.add(w5);
        DefaultMutableTreeNode r1 = new DefaultMutableTreeNode("app");
        DefaultMutableTreeNode r2 = new DefaultMutableTreeNode("微信开发");
        DefaultMutableTreeNode r3 = new DefaultMutableTreeNode("UI设计");
        n3.add(r1);
        n3.add(r2);
        n3.add(r3);
        DefaultMutableTreeNode t1 = new DefaultMutableTreeNode("个人画像");
        DefaultMutableTreeNode t2 = new DefaultMutableTreeNode("翻译文献");
        DefaultMutableTreeNode t3 = new DefaultMutableTreeNode("取名");
        DefaultMutableTreeNode t4 = new DefaultMutableTreeNode("生活摄影");
        n4.add(t1);
        n4.add(t2);
        n4.add(t3);
        n4.add(t4);
        DefaultMutableTreeNode p1 = new DefaultMutableTreeNode("电商推广");
        DefaultMutableTreeNode p2 = new DefaultMutableTreeNode("网络推广");
        n5.add(p1);
        n5.add(p2);
        TaskService taskService = new TaskService();
        tree(q1,"商标注册");
        tree(q2,"开办公司");
        tree(q3,"人力资源");

        tree(q4,"职业培训");
        tree(w1,"LOGO设计");
        tree(w2,"VI设计");
        tree(w3,"广告设计");
        tree(w4,"视频宣传");
        tree(w5,"商品包装");
        tree(r1,"app");
        tree(r2,"微信开发");
        tree(r3,"UI设计");
        tree(t1,"个人画像");
        tree(t2,"翻译文献");
        tree(t3,"取名");
        tree(t4,"生活摄影");
        tree(p1,"电商推广");
        tree(p2,"网络推广");

        DefaultTreeModel dtm1 = new DefaultTreeModel(root);
        tree1.setModel(dtm1);
        tree1.setRootVisible(false);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - xxx holic
    private JLayeredPane layeredPane1;
    private JPanel panel2;
    private JScrollPane scrollPane1;
    private JTree tree1;
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    private JPanel panel3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void setpyName(String pyName) {
        this.pyName = pyName;
    }
}





