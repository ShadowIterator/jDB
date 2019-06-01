import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.io.*;

public class JDBGUI extends JFrame {
    private JPanel leftPane, rightPane;
    private JTextArea sqlArea;
    private JScrollPane sqlPane;
    private JButton submitButton;
    private DefaultTableModel tableModel;
    private JTable table;
    private JScrollPane tablePane;
    private JLabel status;
    private JMenuItem open;

    private jDBClient client;


    public JDBGUI() {
        this.client = new jDBClient("127.0.0.1", 10086);

        this.leftPane = new JPanel();
        this.rightPane = new JPanel();
        prepareLeft();
        prepareRight();

        JSplitPane jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, this.leftPane, this.rightPane);
        add(jsp);

        this.status = new JLabel("Ready");
        JToolBar toolBar = new JToolBar();
        toolBar.add(this.status);
        this.getContentPane().add(toolBar, BorderLayout.SOUTH);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        this.open = new JMenuItem("Import SQL Script");
        this.open.addActionListener(new ImportMonitor());
        fileMenu.add(this.open);
        setJMenuBar(menuBar);

        setTitle("JDB Client");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        jsp.setDividerLocation(0.5);
    }

    private void prepareLeft() {
        GroupLayout gl = new GroupLayout(this.leftPane);
        this.leftPane.setLayout(gl);
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);
        this.sqlArea = new JTextArea();
        this.sqlArea.setLineWrap(true);
        this.sqlPane = new JScrollPane(this.sqlArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.submitButton = new JButton("Execute");
        this.submitButton.addActionListener(new SubmitMonitor());
        gl.setHorizontalGroup(gl.createParallelGroup(GroupLayout.Alignment.TRAILING)
            .addComponent(this.sqlPane)
            .addComponent(this.submitButton));
        gl.setVerticalGroup(gl.createSequentialGroup()
            .addComponent(this.sqlPane)
            .addComponent(this.submitButton));
    }

    private void prepareRight() {
        this.tableModel = new DefaultTableModel();
        this.table = new JTable();
        this.table.setModel(this.tableModel);
        this.tablePane = new JScrollPane(this.table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        GroupLayout gl = new GroupLayout(this.rightPane);
        this.rightPane.setLayout(gl);
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);
        gl.setHorizontalGroup(gl.createParallelGroup().addComponent(this.tablePane));
        gl.setVerticalGroup(gl.createParallelGroup().addComponent(this.tablePane));
    }

    private void fillInTable(SQLResult result) {
        int rowCount = this.tableModel.getRowCount();
        for(int i = 0; i < rowCount; ++i) {
            this.tableModel.removeRow(0);
        }
        if(result.getResultType() == 1) {
            ArrayList<String> columnNames = result.getAttributeName();
            String[] newColumns = new String[columnNames.size()];
            newColumns = columnNames.toArray(newColumns);
            this.tableModel.setColumnIdentifiers(newColumns);
            ArrayList<AbstractTuple> tuples = result.getTuples();
            ArrayList<Integer> attributeId = result.getAttributeId();
            for(AbstractTuple tuple: tuples) {
                Vector<String> newRow = new Vector<String>();
                for(Integer id: attributeId) {
                    newRow.add(tuple.getAttr(id).toString());
                }
                this.tableModel.addRow(newRow);
            }
        } else if(result.getResultType() == 2) {
            String firstTableName = result.getFirstTableName();
            String secondTableName = result.getSecondTableName();
            ArrayList<String> columnNames = result.getAttributeName();
            ArrayList<String> secondAttrName = result.getSecondAttributeName();
            int firstCount = columnNames.size();
            int secondCount = secondAttrName.size();
            for(int i = 0; i < firstCount; ++i) {
                columnNames.set(i, firstTableName + "." + columnNames.get(i));
            }
            for(int i = 0; i < secondCount; ++i) {
                secondAttrName.set(i, secondTableName + "." + secondAttrName.get(i));
            }
            columnNames.addAll(secondAttrName);
            String[] newColumns = new String[columnNames.size()];
            newColumns = columnNames.toArray(newColumns);
            this.tableModel.setColumnIdentifiers(newColumns);
            ArrayList<AbstractTuple> firstTuples = result.getTuples();
            ArrayList<AbstractTuple> secondTuples = result.getSecondTuples();
            ArrayList<Integer> firstAttrId = result.getAttributeId();
            ArrayList<Integer> secondAttrId = result.getSecondAttributeId();
            int tupleCount = firstTuples.size();
            for(int i = 0; i < tupleCount; ++i) {
                Vector<String> newRow = new Vector<String>();
                for(Integer id: firstAttrId) {
                    Object obj = firstTuples.get(i).getAttr(id);
                    if(obj == null) {
                        newRow.add("NULL");
                    } else {
                        newRow.add(obj.toString());
                    }
                }
                for(Integer id: secondAttrId) {
                    newRow.add(secondTuples.get(i).getAttr(id).toString());
                }
                this.tableModel.addRow(newRow);
            }
        }
    }

    private void reportSuccResult() {
//        System.out.println("SUCCESS~");
        this.status.setText("Success.");
    }

    private void reportFailResult(SQLResult result) {
//        System.out.println("RESULT TYPE: " + result.getResultType());
//        System.out.println(result.getResultInfo());
        this.status.setText(result.getResultInfo());
    }

    private void importFail(String filename) {
        this.status.setText("Error while trying to read file: " + filename);
    }

    private void execute(String sql) {
        ArrayList<SQLResult> results = null;
        try {
            results = client.query(sql);
        } catch(Exception ex) {
            ex.printStackTrace();
            return;
        }
        int resultLen = results.size();
        boolean isSelectResult = false;
        boolean isFailResult = false;
        for(int i = resultLen - 1; i >= 0; --i) {
            SQLResult result = results.get(i);
            if(result.getResultType() == 1 || result.getResultType() == 2) {
                fillInTable(result);
                reportSuccResult();
                isSelectResult = true;
                break;
            } else if(result.getResultType() == -2 || result.getResultType() == -1) {
                reportFailResult(result);
                isFailResult = true;
                break;
            }
        }
        if(!isSelectResult && !isFailResult) {
            reportSuccResult();
        }
    }

    public static void main(String[] args) {
        new JDBGUI();
    }

    private class SubmitMonitor implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(sqlArea.getText());
            execute(sqlArea.getText());
        }
    }

    private class ImportMonitor implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
//            System.out.println("clicked import~");
            JFileChooser jfc = new JFileChooser();
            jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            jfc.showDialog(new JLabel(), "Choose SQL Script");
            File file = jfc.getSelectedFile();
            InputStream is = null;
            String line;
            StringBuffer buffer = new StringBuffer();
            try {
                is = new FileInputStream(file);
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                line = reader.readLine();
                while(line != null) {
                    buffer.append(line);
                    buffer.append("\n");
                    line = reader.readLine();
                }
                reader.close();
                is.close();
            } catch (Exception ex) {
                ex.printStackTrace();
                importFail(file.getName());
            }
            String sql = buffer.toString();
            sqlArea.setText(sql);
            execute(sql);
        }
    }
}
