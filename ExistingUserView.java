import java.awt.Color;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 * ExistingUserView.java
 * @version 12/10/2023
 * @author Abderrahmane Fadli
 */
public class ExistingUserView extends javax.swing.JFrame {

    /* variables */
    private javax.swing.JLabel ExistingUserLabelResult;
    private javax.swing.JPanel ExistingUserPanel;
    private javax.swing.JPanel ExistingUserPanelLow;
    private javax.swing.JLabel existinUserBodLabel;
    private javax.swing.JLabel existinUserBodview;
    private javax.swing.JLabel existinUserFnLabel;
    private javax.swing.JLabel existinUserFnView;
    private javax.swing.JLabel existinUserLnLabel;
    private javax.swing.JLabel existinUserLnView;
    private javax.swing.JLabel existinUserWorkLabel;
    private javax.swing.JLabel existinUserWorkView;
    private javax.swing.JLabel existingUSerDateLabel;
    private javax.swing.JLabel existingUserDate;
    private static javax.swing.JTable existingUserResultTable;
    private javax.swing.JScrollPane jScrollPane1;

    /*  end */


    /**
     * Creates new form ExistingUserView
     */
    public ExistingUserView() {
        initComponents();
        curDateTime();
    }
    
    String data = null;
    static HashMap<Integer, String> list = null;
    static String[] tokens = null;
    static StringBuilder result = new StringBuilder();
    
    // Constracture with ine parameter 
    public ExistingUserView(String data){
        initComponents();
        curDateTime();
        this.data = data;
        parseData(this.data);
    }
    
    
    /**
     * Helper method to get the current time
     */
    private void curDateTime(){
        existingUserDate.setText(HelperMethods.DateTime());
    }

    /**
     * Helper method to take string data and display it into JTable
     * @param data String data of information needed to be displayed
     *              in the JTable 
     */
    private static void parseData(String data){
        String decodedBarcode = BarCode.readFromBarCode(data);
        DefaultTableModel tableModel = (DefaultTableModel) existingUserResultTable.getModel();
        
        tokens = decodedBarcode.split("\\$");
        list = ConnectDb.retrieveRecord(tokens);

        for (int i = 0; i < list.size(); i += 11) {
            tableModel.addRow(new Object[]{
                    list.get((i+1)),
                    Double.valueOf(list.get((i+2))),
                    Double.valueOf(list.get((i+3))),
                    Double.valueOf(list.get((i+4))),
                    Double.valueOf(list.get((i+5))),
                    Double.valueOf(list.get((i+6))),
                    Double.valueOf(list.get((i+7))),
                    Double.valueOf(list.get((i+8))),
                    Double.valueOf(list.get((i+9))),
                    Double.valueOf(list.get((i+10))),
                    Double.valueOf(list.get((i+11))),
                    
            });
        }
        
    }

    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        ExistingUserPanel = new javax.swing.JPanel();
        existinUserFnLabel = new javax.swing.JLabel();
        existinUserLnLabel = new javax.swing.JLabel();
        existinUserFnView = new javax.swing.JLabel();
        existinUserLnView = new javax.swing.JLabel();
        existinUserBodview = new javax.swing.JLabel();
        existinUserBodLabel = new javax.swing.JLabel();
        existinUserWorkLabel = new javax.swing.JLabel();
        existinUserWorkView = new javax.swing.JLabel();
        ExistingUserLabelResult = new javax.swing.JLabel();
        existingUserDate = new javax.swing.JLabel();
        existingUSerDateLabel = new javax.swing.JLabel();
        ExistingUserPanelLow = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        existingUserResultTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("ExistingUserView");
        setName("ExistingUserViewFrame"); 
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        ExistingUserPanel.setPreferredSize(new java.awt.Dimension(880, 250));

        existinUserFnLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        existinUserFnLabel.setText("Firstname");

        existinUserLnLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        existinUserLnLabel.setText("Lastname");

        existinUserFnView.setBackground(new java.awt.Color(255, 255, 255));
        existinUserFnView.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        existinUserLnView.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        existinUserBodview.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        existinUserBodLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        existinUserBodLabel.setText("Date of Birth");

        existinUserWorkLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        existinUserWorkLabel.setText("Blood work date");

        existinUserWorkView.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        ExistingUserLabelResult.setFont(new java.awt.Font("Times New Roman", 1, 18)); 
        ExistingUserLabelResult.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ExistingUserLabelResult.setText("Results");

        existingUSerDateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        existingUSerDateLabel.setText("Date");

        javax.swing.GroupLayout ExistingUserPanelLayout = new javax.swing.GroupLayout(ExistingUserPanel);
        ExistingUserPanel.setLayout(ExistingUserPanelLayout);
        ExistingUserPanelLayout.setHorizontalGroup(
            ExistingUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExistingUserPanelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(ExistingUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(ExistingUserPanelLayout.createSequentialGroup()
                        .addComponent(existinUserFnView, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(existinUserLnView, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ExistingUserPanelLayout.createSequentialGroup()
                        .addComponent(existinUserFnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(existinUserLnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58)
                .addGroup(ExistingUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(existinUserBodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(existinUserBodview, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(ExistingUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(existinUserWorkView, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(existinUserWorkLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(165, Short.MAX_VALUE))
            .addGroup(ExistingUserPanelLayout.createSequentialGroup()
                .addGap(283, 283, 283)
                .addComponent(ExistingUserLabelResult, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ExistingUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(existingUserDate, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(existingUSerDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ExistingUserPanelLayout.setVerticalGroup(
            ExistingUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExistingUserPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(ExistingUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ExistingUserLabelResult, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ExistingUserPanelLayout.createSequentialGroup()
                        .addComponent(existingUSerDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(existingUserDate, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addGroup(ExistingUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(existinUserFnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(existinUserLnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(existinUserBodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(existinUserWorkLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ExistingUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(existinUserFnView, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(existinUserLnView, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(existinUserBodview, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(existinUserWorkView, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        ExistingUserPanelLow.setPreferredSize(new java.awt.Dimension(880, 100));

        existingUserResultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Drawn", "WBC", "RBC", "HBG", "HCT", "MPV", "MCH", "MCHC", "RDW", "Platelet", "MCV"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        existingUserResultTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(existingUserResultTable);
        if (existingUserResultTable.getColumnModel().getColumnCount() > 0) {
            existingUserResultTable.getColumnModel().getColumn(1).setResizable(false);
            existingUserResultTable.getColumnModel().getColumn(2).setResizable(false);
            existingUserResultTable.getColumnModel().getColumn(3).setResizable(false);
            existingUserResultTable.getColumnModel().getColumn(4).setResizable(false);
            existingUserResultTable.getColumnModel().getColumn(5).setResizable(false);
            existingUserResultTable.getColumnModel().getColumn(6).setResizable(false);
            existingUserResultTable.getColumnModel().getColumn(7).setResizable(false);
            existingUserResultTable.getColumnModel().getColumn(8).setResizable(false);
            existingUserResultTable.getColumnModel().getColumn(9).setResizable(false);
            existingUserResultTable.getColumnModel().getColumn(10).setResizable(false);
        }

        javax.swing.GroupLayout ExistingUserPanelLowLayout = new javax.swing.GroupLayout(ExistingUserPanelLow);
        ExistingUserPanelLow.setLayout(ExistingUserPanelLowLayout);
        ExistingUserPanelLowLayout.setHorizontalGroup(
            ExistingUserPanelLowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExistingUserPanelLowLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        ExistingUserPanelLowLayout.setVerticalGroup(
            ExistingUserPanelLowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExistingUserPanelLowLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(154, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ExistingUserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 948, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(ExistingUserPanelLow, javax.swing.GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ExistingUserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ExistingUserPanelLow, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        this.dispose();
        new MainView().setVisible(true);
    }

    private void formWindowActivated(java.awt.event.WindowEvent evt) {
        existinUserFnView.setBackground(Color.WHITE);
        existinUserFnView.setText(tokens[1]);
        existinUserLnView.setText(tokens[2]);
        existinUserBodview.setText(tokens[3]);
    }
}
