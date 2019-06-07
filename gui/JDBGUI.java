//import com.sun.codemodel.internal.fmt.JTextFile;

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
    private JMenuItem connectDialog;

    private jDBClient client;
    LoginDialog loginManager;

    private class LoginDialog extends JDialog {
        JTextField ip;
        JTextField port;
        JLabel errorMsg;
        String title;
        JButton connect;

        @Override
        public String getTitle() {
            return this.title;
        }

        public LoginDialog(Frame owner, String _title) {
            super(owner, _title);
            setLayout(new FlowLayout());
            this.ip = new JTextField(16);
            this.port = new JTextField(16);
            this.connect = new JButton("Connect");
            this.errorMsg = new JLabel();
            this.connect.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    errorMsg.setText("");
                    String _ip = ip.getText();
                    String _port = port.getText();
                    int port = -1;
                    try {
                        port = Integer.parseInt(_port);
                    } catch(Exception ex) {
                        errorMsg.setText("Port need to be an integer.");
                        return;
                    }
                    client = new jDBClient(_ip, port);
                    try {
                        client.tryConnection();
                    } catch (Exception ex) {
                        errorMsg.setText("Cannot connect to server.");
                        client = null;
                        return;
                    }
                    setVisible(false);
                }
            });
            add(new JLabel("Server IP"));
            add(this.ip);
            add(new JLabel("Server Port"));
            add(this.port);
            add(this.errorMsg);
            add(this.connect);
            setBounds(100, 100, 300, 150);
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setVisible(true);
        }
    }

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
        this.connectDialog = new JMenuItem("Connect to server");
        this.connectDialog.addActionListener(new ConnectMonitor());
        fileMenu.add(this.connectDialog);
        this.open = new JMenuItem("Import SQL Script");
        this.open.addActionListener(new ImportMonitor());
        fileMenu.add(this.open);
        setJMenuBar(menuBar);
        setTitle("JDB Client");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        jsp.setDividerLocation(0.5);
//        this.loginManager = new LoginDialog(this, "Login");
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

    private void clearTable() {
        int rowCount = this.tableModel.getRowCount();
        for(int i = 0; i < rowCount; ++i) {
            this.tableModel.removeRow(0);
        }
        String[] newColumns = new String[1];
        newColumns[0] = "";
        this.tableModel.setColumnIdentifiers(newColumns);
    }

    private void fillInTable(SQLResult result) {
        clearTable();
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
                    Object obj = tuple.getAttr(id);
                    if(obj == null) {
                        newRow.add("NULL");
                    } else {
                        newRow.add(obj.toString());
                    }
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

    private void reportSuccResult(double costTime) {
//        System.out.println("SUCCESS~");
        this.status.setText("Success. Cost " + costTime + "ms");
    }

    private void reportFailResult(SQLResult result) {
//        System.out.println("RESULT TYPE: " + result.getResultType());
//        System.out.println(result.getResultInfo());
        if(result.getResultInfo() == null) {
            this.status.setText("Some Unknown Error.");
        } else {
            this.status.setText("Error: " + result.getResultInfo());
        }
    }

    private void importFail(String filename) {
        this.status.setText("Error while trying to read file: " + filename);
    }

    private void execute(String sql) {
        this.status.setText("Executing...");
        ArrayList<SQLResult> results = null;
        try {
            results = client.query(sql);
        } catch(Exception ex) {
            ex.printStackTrace();
            reportFailResult(new SQLResult(-1, ex.getMessage()));
            return;
        }
        int resultLen = results.size();
        boolean isSelectResult = false;
        boolean isFailResult = false;
        double costTime = 0;
        for(int i = 0; i < resultLen; ++i) {
            costTime += results.get(i).getCostTime();
        }
        for(int i = resultLen - 1; i >= 0; --i) {
            SQLResult result = results.get(i);
            if(result.getResultType() == 1 || result.getResultType() == 2) {
                fillInTable(result);
                reportSuccResult(costTime);
                isSelectResult = true;
                break;
            } else if(result.getResultType() == -2 || result.getResultType() == -1) {
                clearTable();
                reportFailResult(result);
                isFailResult = true;
                break;
            }
        }
        if(!isSelectResult && !isFailResult) {
            reportSuccResult(costTime);
        }
    }

    public static void main(String[] args) {
        new JDBGUI();
    }

    private class SubmitMonitor implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(client == null) {
                JOptionPane.showConfirmDialog(null, "Please connect to server first.", "No connection.", JOptionPane.YES_OPTION);
                return;
            }
//            System.out.println(sqlArea.getText());
            execute(sqlArea.getText());
        }
    }

    private class ImportMonitor implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
//            System.out.println("clicked import~");
            if(client == null) {
                JOptionPane.showConfirmDialog(null, "Please connect to server first.", "No connection.", JOptionPane.YES_OPTION);
                return;
            }
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
//            sqlArea.setText(sql);
            execute(sql);
        }
    }

    private class ConnectMonitor implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            loginManager.setVisible(true);
        }
    }
}
