import javax.swing.*;
import static javax.swing.GroupLayout.Alignment.*;

public class HelloSwing {

    public static void main(String[] args) {
        JFrame frame = new JFrame("JDB Client");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JTextArea sqlArea = new JTextArea();
        sqlArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(sqlArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JButton submitButton = new JButton("Query");

        // 列名
        String[] columnName = new String[]{"航班号", "出发时间", "飞行时间", "出发地", "目的地", "余票", "票价"};
        // 表格具体数据
        String[][] columnDate = new String[][]{
                {"1", "2019-01-18 10:05", "90分钟", "北京", "纽约", "50", "500.0"},
                {"2", "2019-01-18 10:05", "90分钟", "北京", "纽约", "10", "500.0"},
                {"3", "2019-01-18 10:05", "90分钟", "北京", "纽约", "10", "500.0"},
                {"4", "2019-01-18 10:05", "90分钟", "北京", "纽约", "40", "500.0"},
        };
        JTable table = new JTable(columnDate, columnName);
        table.setEnabled(false);
        JScrollPane tablePane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

//        panel.add(scrollPane, BorderLayout.WEST);
//        panel.add(tablePane, BorderLayout.EAST);

        GroupLayout.ParallelGroup hGroupLeft = layout.createParallelGroup(TRAILING)
                .addComponent(scrollPane).addComponent(submitButton);
        GroupLayout.SequentialGroup hSeqGroup = layout.createSequentialGroup().addGroup(hGroupLeft).addComponent(tablePane);
        layout.setHorizontalGroup(hSeqGroup);

        GroupLayout.SequentialGroup vSeqLeft = layout.createSequentialGroup().addComponent(scrollPane).addComponent(submitButton);
        GroupLayout.ParallelGroup vParaGroup = layout.createParallelGroup(CENTER).addGroup(vSeqLeft).addComponent(tablePane);
        layout.setVerticalGroup(vParaGroup);

//        GroupLayout groupLayout = new GroupLayout(myPanel);
//        groupLayout.setAutoCreateGaps(true);
//        groupLayout.setAutoCreateContainerGaps(true);
//        myPanel.setLayout(groupLayout);

//        JButton b1 = new JButton("Button One");
//        JButton b2 = new JButton("Button Two");
//        JButton b3 = new JButton("Button Three");
//
//        groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()
//                .addGroup(groupLayout.createParallelGroup(LEADING).addComponent(b1).addComponent(b3))
//                .addGroup(groupLayout.createParallelGroup(TRAILING).addComponent(b2)));

//        groupLayout.setVerticalGroup(groupLayout.createSequentialGroup()
//                .addGroup(groupLayout.createParallelGroup(BASELINE).addComponent(b1).addComponent(b2))
//                .addGroup(groupLayout.createParallelGroup(BASELINE).addComponent(b3)));
    }

}