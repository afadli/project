import java.io.File;
import java.sql.DriverManager;
import java.time.format.*;
import java.time.*;
import java.util.regex.*;
import java.util.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.BorderFactory;

/**
 * NewUserView.java
 * @version 12/10/2023
 * @author Abderrahmane Fadli
 */
public class NewUserView extends javax.swing.JFrame {
    /*  variable   */
    JPanel infoPanel = new JPanel();
    JLabel newUserFnLabel = new JLabel();
    JLabel newUserLnLabel = new JLabel();
    JTextField newUserFnField = new JTextField();
    JTextField newUserLnField = new JTextField();
    JLabel newUserAddLabel = new JLabel();
    JScrollPane jScrollPane1 = new JScrollPane();
    JTextArea newUserAdderField = new JTextArea();
    JLabel newUserPhoneLabel = new JLabel();
    JLabel newUserEmailLabel = new JLabel();
    JTextField newUserEmailField = new JTextField();
    JLabel newUserDobLabel = new JLabel();
    JLabel newUserlicLabel = new JLabel();
    JTextField newUserLicField = new JTextField();
    JFormattedTextField newUserPhoneField = new JFormattedTextField();
    JFormattedTextField newUserBodField = new JFormattedTextField();
    JLabel newUserEthLabel = new JLabel();
    JComboBox newUserEthmenu = new JComboBox<>();
    JLabel newUserDateTime = new JLabel();
    JLabel dateLabel = new JLabel();
    JPanel bloodSamplePanel = new JPanel();
    JLabel wbcLabel = new JLabel();
    JLabel rbcLabel = new JLabel();
    JLabel hbgBloodLabel = new JLabel();
    JLabel hctBloodLabel = new JLabel();
    JLabel mcvBloodLabel = new JLabel();
    JLabel mchBloodLabel = new JLabel();
    JLabel mchcBloodLabel = new JLabel();
    JLabel rdwBloodLabel = new JLabel();
    JLabel plateletBloodLabel = new JLabel();
    JLabel mpvBloodLabel = new JLabel();
    JTextField wbcBloodField = new JTextField();
    JTextField rbcBloodField = new JTextField();
    JTextField hbgBloodField = new JTextField();
    JTextField hctBloodField = new JTextField();
    JTextField mpvBloodField = new JTextField();
    JTextField mchBloodField = new JTextField();
    JTextField mchcBloodField = new JTextField();
    JTextField rdwBloodField = new JTextField();
    JTextField plateletBloodField = new JTextField();
    JTextField mcvBloodField = new JTextField();
    JPanel buttonsPanel = new JPanel();
    JButton cancelButton = new JButton();
    JButton saveButton = new JButton();

    /*  end */

    /**
     * Creates new form NewUserView
     */
    public NewUserView() {
        initComponents();
        curDateTime();
    }

    /**
     * Helpers methods 
     */
    
    /**
     * This fuction calls DateTime from HelperMethods()
     */
    private void curDateTime(){
        newUserDateTime.setText(HelperMethods.DateTime());   
    }
    

    /**
     * This function reste fields to default values.
     */
    private void resetFields(){
        newUserFnField.setText("");
        newUserLnField.setText("");
        newUserPhoneField.setText("");
        newUserBodField.setText("");
        newUserEmailField.setText("");
        newUserAdderField.setText("");
        newUserLicField.setText("");
        
        wbcBloodField.setText("0.0");
        rbcBloodField.setText("0.0");
        hbgBloodField.setText("0.0");
        hctBloodField.setText("0.0");
        mpvBloodField.setText("0.0");
        
    }
    
    /* End of helpers methods */
    
    @SuppressWarnings("unchecked")
    private void initComponents() {

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("NewUserView");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        infoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Personal Inofrmation", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 12))); 
        infoPanel.setPreferredSize(new java.awt.Dimension(880, 250));

        newUserFnLabel.setText("First Name");

        newUserFnField.setName("Firstname"); 
        newUserFnField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                newUserFnFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                newUserFnFieldKeyTyped(evt);
            }
        });

        newUserLnLabel.setText("Last Name");

        newUserLnField.setName("Lastname"); 

        newUserAddLabel.setText("Address");

        newUserAdderField.setColumns(20);
        newUserAdderField.setRows(5);
        newUserAdderField.setName("Address"); 
        jScrollPane1.setViewportView(newUserAdderField);

        newUserPhoneLabel.setText("Phone Number");

        newUserEmailLabel.setText("Email");

        newUserEmailField.setName("Email"); 

        newUserDobLabel.setText("<html>\nDate of Birth</br>\nMM/DD/YYYY\n</html>");

        newUserlicLabel.setText("Driver License");

        newUserLicField.setName("Drive License"); 

        try {
            newUserPhoneField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(###)###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        newUserPhoneField.setName("Phone"); 
        newUserPhoneField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newUserPhoneFieldActionPerformed(evt);
            }
        });

        try {
            newUserBodField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        newUserBodField.setName("DOB"); 

        newUserEthLabel.setText("Ethnicity");

        newUserEthmenu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alaska Natives", "Asian", "Black or African Americans", "Caribbean", "Hispanic or Latino", "Native Americans", "Pacific Islander", "White", "Other" }));

        newUserDateTime.setText("DateTime");

        dateLabel.setText("Date");

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newUserFnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newUserFnField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newUserLnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newUserLnField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newUserAddLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(newUserPhoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(newUserDobLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95))
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newUserEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newUserPhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newUserlicLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newUserEmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newUserLicField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoPanelLayout.createSequentialGroup()
                                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(newUserBodField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(newUserEthmenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(newUserEthLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(95, 95, 95))
                            .addGroup(infoPanelLayout.createSequentialGroup()
                                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(newUserDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())))))
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newUserFnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newUserDobLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newUserPhoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(newUserFnField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newUserBodField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newUserPhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newUserLnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newUserEmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newUserEthLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newUserLnField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(newUserEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(newUserEthmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newUserAddLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newUserlicLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoPanelLayout.createSequentialGroup()
                        .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(newUserLicField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(newUserDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        newUserFnLabel.getAccessibleContext().setAccessibleName("newUserFnLabel");
        newUserPhoneLabel.getAccessibleContext().setAccessibleName("newUserPhoneLabel");
        newUserEmailLabel.getAccessibleContext().setAccessibleName("newUserEmailLabel");
        newUserEmailField.getAccessibleContext().setAccessibleName("newUserEmailField");
        newUserLicField.getAccessibleContext().setAccessibleName("newUserLicFrame");
        newUserLicField.getAccessibleContext().setAccessibleDescription("");

        bloodSamplePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Blood Sample Information", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 12))); 
        bloodSamplePanel.setPreferredSize(new java.awt.Dimension(880, 250));
        bloodSamplePanel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bloodSamplePanelFocusGained(evt);
            }
        });

        wbcLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wbcLabel.setText("WBC");

        rbcLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbcLabel.setText("RBC");
        rbcLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        hbgBloodLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hbgBloodLabel.setText("Hemoglobin");

        hctBloodLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hctBloodLabel.setText("Hematocrit");

        mcvBloodLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mcvBloodLabel.setText("Mean Cell Volume");

        mchBloodLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mchBloodLabel.setText("Mean Cell Hemoglobin");

        mchcBloodLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mchcBloodLabel.setText("Mean Cell Hb Conc");

        rdwBloodLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rdwBloodLabel.setText("Red Cell Dist Width");

        plateletBloodLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        plateletBloodLabel.setText("Platelet Count");

        mpvBloodLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mpvBloodLabel.setText("Mean Platelet Volume");

        wbcBloodField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        wbcBloodField.setText("0.0");
        wbcBloodField.setName("WBC"); 
        wbcBloodField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                wbcBloodFieldFocusLost(evt);
            }
        });
        wbcBloodField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                wbcBloodFieldMouseClicked(evt);
            }
        });

        rbcBloodField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        rbcBloodField.setText("0.0");
        rbcBloodField.setName("RBC"); 
        rbcBloodField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                rbcBloodFieldFocusLost(evt);
            }
        });
        rbcBloodField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbcBloodFieldMouseClicked(evt);
            }
        });

        hbgBloodField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        hbgBloodField.setText("0.0");
        hbgBloodField.setName("Hemoglobin"); 
        hbgBloodField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                hbgBloodFieldFocusLost(evt);
            }
        });
        hbgBloodField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hbgBloodFieldMouseClicked(evt);
            }
        });

        hctBloodField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        hctBloodField.setText("0.0");
        hctBloodField.setName("Hematocrit"); 
        hctBloodField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                hctBloodFieldFocusLost(evt);
            }
        });
        hctBloodField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hctBloodFieldMouseClicked(evt);
            }
        });

        mpvBloodField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mpvBloodField.setText("0.0");
        mpvBloodField.setName("Mean Platelet Volume"); 
        mpvBloodField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                mpvBloodFieldFocusLost(evt);
            }
        });
        mpvBloodField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mpvBloodFieldMouseClicked(evt);
            }
        });

        mchBloodField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mchBloodField.setText("0.0");
        mchBloodField.setName("Mean Cell Hemoglobin"); 
        mchBloodField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                mchBloodFieldFocusLost(evt);
            }
        });
        mchBloodField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mchBloodFieldMouseClicked(evt);
            }
        });

        mchcBloodField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mchcBloodField.setText("0.0");
        mchcBloodField.setName("Mean Cell Hb Conc"); 
        mchcBloodField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                mchcBloodFieldFocusLost(evt);
            }
        });
        mchcBloodField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mchcBloodFieldMouseClicked(evt);
            }
        });

        rdwBloodField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        rdwBloodField.setText("0.0");
        rdwBloodField.setName("Red Cell Dist Width"); 
        rdwBloodField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                rdwBloodFieldFocusLost(evt);
            }
        });
        rdwBloodField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdwBloodFieldMouseClicked(evt);
            }
        });

        plateletBloodField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        plateletBloodField.setText("0.0");
        plateletBloodField.setName("Platelet Count"); 
        plateletBloodField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                plateletBloodFieldFocusLost(evt);
            }
        });
        plateletBloodField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plateletBloodFieldMouseClicked(evt);
            }
        });

        mcvBloodField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mcvBloodField.setText("0.0");
        mcvBloodField.setName("Mean Cell Volume"); 
        mcvBloodField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                mcvBloodFieldFocusLost(evt);
            }
        });
        mcvBloodField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mcvBloodFieldMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout bloodSamplePanelLayout = new javax.swing.GroupLayout(bloodSamplePanel);
        bloodSamplePanel.setLayout(bloodSamplePanelLayout);
        bloodSamplePanelLayout.setHorizontalGroup(
            bloodSamplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bloodSamplePanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(bloodSamplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bloodSamplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(mchBloodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(wbcLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(mchBloodField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wbcBloodField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(bloodSamplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mchcBloodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbcLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbcBloodField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mchcBloodField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(bloodSamplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdwBloodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hbgBloodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hbgBloodField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdwBloodField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(bloodSamplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(plateletBloodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hctBloodField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hctBloodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(plateletBloodField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(bloodSamplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mcvBloodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mpvBloodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mpvBloodField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mcvBloodField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bloodSamplePanelLayout.setVerticalGroup(
            bloodSamplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bloodSamplePanelLayout.createSequentialGroup()
                .addGroup(bloodSamplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bloodSamplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbcLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(wbcLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bloodSamplePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(bloodSamplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hbgBloodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hctBloodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mpvBloodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(bloodSamplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bloodSamplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(wbcBloodField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rbcBloodField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(hbgBloodField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hctBloodField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mpvBloodField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(bloodSamplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bloodSamplePanelLayout.createSequentialGroup()
                        .addGroup(bloodSamplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mchcBloodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdwBloodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mchBloodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mcvBloodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(bloodSamplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mchBloodField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mchcBloodField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdwBloodField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(plateletBloodField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mcvBloodField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(plateletBloodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(164, Short.MAX_VALUE))
        );

        buttonsPanel.setPreferredSize(new java.awt.Dimension(880, 113));

        cancelButton.setText("Cancel");
        cancelButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelButtonMouseClicked(evt);
            }
        });
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(cancelButton);

        saveButton.setText("Save");
        saveButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        saveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveButtonMouseClicked(evt);
            }
        });
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(saveButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 948, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bloodSamplePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bloodSamplePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {}

    private void newUserFnFieldKeyReleased(java.awt.event.KeyEvent evt) {}

    private void newUserFnFieldKeyTyped(java.awt.event.KeyEvent evt) {}

    private void newUserPhoneFieldActionPerformed(java.awt.event.ActionEvent evt) {}

    private void saveButtonMouseClicked(java.awt.event.MouseEvent evt) {
        String fName = "";
        String lName = "";
        String phoneNumer = "";
        String dob = "";
        int dateDay, dateMonth, dateYear ;
        dateDay = dateMonth = dateYear = -1 ;
        String email = "";
        String ethnicity = String.valueOf(newUserEthmenu.getSelectedItem().toString());
        String address = "";
        String driveLicense = "";
        String date = newUserDateTime.getText();
        
        // Blood info
        String wbc, rbc , hbg , hct , mpv;
        wbc = rbc = hbg = hct = mpv = "";
        String mch , mchc , rdw , pc , mcv ;
        mch = mchc = rdw = pc = mcv = "";
        
        // variable needed to check if we get needed information
        final int NUM_FIELDS = 17;
        int numCorrectFields = 0;
        StringBuilder errorMsg = new StringBuilder("");
        
        // Get the firstname. Check if its lengthgreater than 3 char
        if ( newUserFnField.getText().isEmpty()){
            errorMsg.append("Firstname field is empty\n");
        } else if (!newUserFnField.getText().toLowerCase().matches("[a-zA-Z]+")) {
            errorMsg.append("Firstname field is invalid\n");
        } else if (newUserFnField.getText().length() < 3) {
            errorMsg.append("Firstname should be greater than 3 characters\n");
        } else {
            numCorrectFields++;
            fName =  newUserFnField.getText();   
        }
        
        // Get the lastname. Check if its length is greater than 3 char
        if (newUserLnField.getText().isEmpty()){
            errorMsg.append("Lastname field is empty\n");
        } else if (!newUserLnField.getText().toLowerCase().matches("[a-zA-Z]+")) {
            errorMsg.append("Lastname field is invalid\n");
        } else if (newUserLnField.getText().length() < 3) {
            errorMsg.append("Lastname should be greater than 3 characters\n");
        } else {
            numCorrectFields++;
            lName = newUserLnField.getText();
        }
        
        // get the phone numer       
        if (newUserPhoneField.getText().matches("^\\(?\\d{3}\\)?[- ]?\\d{3}[- ]?\\d{4}$")) {
            numCorrectFields++;
            phoneNumer = newUserPhoneField.getText();
        }else {
            errorMsg.append("Phone number field is invalid\n");
        }
        
        // get DOB
        if(newUserBodField.getText().isEmpty()){
            errorMsg.append("DOB field is Emtpy\n");
        } else {
            dob = newUserBodField.getText();
            String[] dobTokens = dob.split("/"); 
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            LocalDate dobDate = null;
            try{
                int yy = Integer.parseInt(dobTokens[2]);
                int year = Year.now().getValue();
                if (yy < 1900 || yy > year){
                    errorMsg.append("DOB year is in valid\n");
                }          
            } catch (NumberFormatException e){
                errorMsg.append("DOB year is invalid\n");
            }

            try {
                dobDate = LocalDate.parse(dob, dtf);
                numCorrectFields++;
            } catch (DateTimeParseException e) {
                errorMsg.append("Date of birth field is invalid\n");
            }
        }
        
        // Check if the email format is valid
        /* https://www.geeksforgeeks.org/check-email-address-valid-not-java/ */
        
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                "[a-zA-Z0-9_+&*-]+)*@" + 
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"; 
        
        Pattern emailPattern = Pattern.compile(emailRegex);
        if (newUserEmailField.getText().isEmpty()){
            errorMsg.append("Email field is empty\n");
        } else {
            email = newUserEmailField.getText();
            if(emailPattern.matcher(email).matches()){
                numCorrectFields++;
            } else {
                errorMsg.append("Email address is not valid\n");
            }
        }
        
        // Get the address
        
        if (newUserAdderField.getText().isEmpty()){
            errorMsg.append("Address field is empty\n");
        } else {
            address = newUserAdderField.getText();
            numCorrectFields++;
        }
        
        // Get drive license. Check if it is a valid MA license. format is 
        // S12345678, SA1234567 or S1234567
        
        if(newUserLicField.getText().isEmpty()){
            errorMsg.append("Drive license field is empty\n");
        } else if (newUserLicField.getText().matches("^((?i)S|SA)[0-9]{7,8}")){
            driveLicense = newUserLicField.getText();
            numCorrectFields++;
        } else {
            errorMsg.append("Drive license is invalid. Format is S|SA with 7 or 8 #\n");
        }
        
        date = newUserDateTime.getText();
        
        // Blood entries shou
        wbc = HelperMethods.parseBloodInfo(wbcBloodField.getName(), wbcBloodField.getText());
        if ( !wbc.matches("^\\d*\\.\\d+|\\d+.\\d*$|\\d*$")){
            errorMsg.append(wbc.concat(" Should be in form ##.##\n"));
        } else if (Double.parseDouble(wbc) > 130 || Double.parseDouble(wbc) < 0) {
            errorMsg.append("Invalid WBC input\n");
        } else {
            numCorrectFields++;
        }
        
        rbc = HelperMethods.parseBloodInfo(rbcBloodField.getName(), rbcBloodField.getText());
        if (!rbc.matches("^\\d*\\.\\d+|\\d+.\\d*$|\\d*$")){
            errorMsg.append(rbc.concat(" Should be in form ##.##\n"));
        } else if (Double.parseDouble(rbc) > 130 || Double.parseDouble(rbc) < 0) {
            errorMsg.append("Invalid RBC input\n");
        } else {
            numCorrectFields++;
        }

        hbg = HelperMethods.parseBloodInfo(hbgBloodField.getName(), hbgBloodField.getText());
        if (!hbg.matches("^\\d*\\.\\d+|\\d+.\\d*$|\\d*$")){
            errorMsg.append(hbg.concat(" Should be in form ##.##\n"));
        } else if (Double.parseDouble(hbg) > 130 || Double.parseDouble(hbg) < 0) {
            errorMsg.append("Invalid Hemoglobin input\n");
        } else {
            numCorrectFields++;
        }
        
        hct = HelperMethods.parseBloodInfo(hctBloodField.getName(), hctBloodField.getText());
        if (!hct.matches("^\\d*\\.\\d+|\\d+.\\d*$|\\d*$")){
            errorMsg.append(hct.concat(" Should be in form ##.##\n"));
        } else if (Double.parseDouble(hct) > 130 || Double.parseDouble(hct) < 0){
            errorMsg.append("Invalid Hematocrit input\n");
        } else {
            numCorrectFields++;
        }      
        
        mpv = HelperMethods.parseBloodInfo(mpvBloodField.getName(), mpvBloodField.getText());
        if (!mpv.matches("^\\d*\\.\\d+|\\d+.\\d*$|\\d*$")){
            errorMsg.append(mpv.concat(" Should be in form ##.##\n"));
        } else if (Double.parseDouble(mpv) > 130 || Double.parseDouble(mpv) < 0){
            errorMsg.append("Invalid Mean Platelet Volume input\n");
        } else {
            numCorrectFields++;
        }   
        
        mch = HelperMethods.parseBloodInfo(mchBloodField.getName(), mchBloodField.getText());
        if (!mch.matches("^\\d*\\.\\d+|\\d+.\\d*$|\\d*$")){
            errorMsg.append(mch.concat(" Should be in form ##.##\n"));
        } else if (Double.parseDouble(mch) > 130 || Double.parseDouble(mch) < 0){
            errorMsg.append("Invalid Mean Cell Hemoglobin input\n");
        } else {
            numCorrectFields++;
        }
        
        
        mchc = HelperMethods.parseBloodInfo(mchcBloodField.getName(), mchcBloodField.getText());
        if (!mchc.matches("^\\d*\\.\\d+|\\d+.\\d*$|\\d*$")){
            errorMsg.append(mchc.concat(" Should be in form ##.##\n"));
        } else if (Double.parseDouble(mchc) > 130 || Double.parseDouble(mchc) < 0){
            errorMsg.append("Invalid Mean Cell Hb Conc input\n");
        } else {
            numCorrectFields++;
        }
        
        
        rdw = HelperMethods.parseBloodInfo(rdwBloodField.getName(), rdwBloodField.getText());
        if (!rdw.matches("^\\d*\\.\\d+|\\d+.\\d*$|\\d*$")){
            errorMsg.append(rdw.concat(" Should be in form ##.##\n"));
        } else if (Double.parseDouble(rdw) > 130 || Double.parseDouble(rdw) < 0){
            errorMsg.append("Input Red Cell Width is invalid\n");
        } else {
            numCorrectFields++;
        }
        
        pc = HelperMethods.parseBloodInfo(plateletBloodField.getName(), plateletBloodField.getText());
        if (!pc.matches("^\\d*\\.\\d+|\\d+.\\d*$|\\d*$")){
            errorMsg.append(pc.concat(" Should be in form ##.##\n"));
        } else if (Double.parseDouble(pc) > 130 || Double.parseDouble(pc) < 0){
            errorMsg.append("Input Platelet is invalid\n");
        } else {
            numCorrectFields++;
        }
        
        mcv = HelperMethods.parseBloodInfo(mcvBloodField.getName(), mcvBloodField.getText());
        if (!mcv.matches("^\\d*\\.\\d+|\\d+.\\d*$|\\d*$")){
            errorMsg.append(mcv.concat(" Should be in form ##.##\n"));
        } else if (Double.parseDouble(mcv) > 130 || Double.parseDouble(mcv) < 0){
            errorMsg.append("Input MEan Cell Vol is invalid\n");
        }else {
            numCorrectFields++;
        }
        
        // If total number of files is 16 we are good, otherwise error out 
        if (numCorrectFields < NUM_FIELDS){
            JOptionPane.showMessageDialog(null, errorMsg.toString(),"Incomplete/Invalid Data",JOptionPane.ERROR_MESSAGE);
        } else {
            // printing data
            System.out.println("using db now!");
            
            /*
             User's info are saved into one hashmap, and his samples
             in another one
            */            
            HashMap<Integer, String> user = new HashMap<>();
            HashMap<Integer, Double> samples = new HashMap<>();
            
            user.put(1, fName);
            user.put(2, lName);
            user.put(3, email);
            user.put(4, dob );
            user.put(5, address);
            
            
            samples.put(1, Double.valueOf(wbc));
            samples.put(2, Double.valueOf(rbc));
            samples.put(3, Double.valueOf(hbg));
            samples.put(4, Double.valueOf(hct));
            samples.put(5, Double.valueOf(mpv));
            samples.put(6, Double.valueOf(mch));
            samples.put(7, Double.valueOf(mchc));
            samples.put(8, Double.valueOf(rdw));
            samples.put(9, Double.valueOf(pc));
            samples.put(10, Double.valueOf(mcv));
            
            System.out.println("Saving data to db!");
            
            /*
             Checking the record. If the user exist we append user's samples,
            otherwiae, we create a new row for the user.
            Barcode path is returned to be used to displayed to the user.
            */
            String barcodeImage = ConnectDb.checkRecord(user, samples);
            if (barcodeImage != null ){   
                File imageFile = null;
                try {
                    imageFile = new File(barcodeImage);                 
                } catch (Exception e){
                    System.err.println("[ERROR] " + e.getMessage());
                }
                if (imageFile != null && imageFile.exists()){
                    ImageIcon barcodeIcon = new ImageIcon(imageFile.getAbsolutePath());
                    BarCodeIcon barcodeFrame = new BarCodeIcon();
                    barcodeFrame.iconeBarcodeLabel.setIcon(barcodeIcon);
                    barcodeFrame.setVisible(true);
                }
            }
            
            resetFields();
            
        }
    }

    private void cancelButtonMouseClicked(java.awt.event.MouseEvent evt){}
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
       this.dispose();
       new MainView().setVisible(true);
    }

    private void bloodSamplePanelFocusGained(java.awt.event.FocusEvent evt) {}

    private void wbcBloodFieldMouseClicked(java.awt.event.MouseEvent evt) {
        wbcBloodField.setText("");
    }

    private void rbcBloodFieldMouseClicked(java.awt.event.MouseEvent evt) {
        rbcBloodField.setText("");
    }

    private void wbcBloodFieldFocusLost(java.awt.event.FocusEvent evt) {
        if (wbcBloodField.getText().isEmpty()){
            wbcBloodField.setText("0.0");
        }
    }

    private void rbcBloodFieldFocusLost(java.awt.event.FocusEvent evt) {
        if (rbcBloodField.getText().isEmpty()){
            rbcBloodField.setText("0.0");
        }
    }

    private void hbgBloodFieldFocusLost(java.awt.event.FocusEvent evt) {
        if (hbgBloodField.getText().isEmpty()){
            hbgBloodField.setText("0.0");
        }
    }

    private void hbgBloodFieldMouseClicked(java.awt.event.MouseEvent evt) {
        hbgBloodField.setText("");
    }

    private void hctBloodFieldFocusLost(java.awt.event.FocusEvent evt) {
        if (hctBloodField.getText().isEmpty()){
            hctBloodField.setText("0.0");
        }
    }

    private void hctBloodFieldMouseClicked(java.awt.event.MouseEvent evt) {
        hctBloodField.setText("");
    }

    private void mpvBloodFieldFocusLost(java.awt.event.FocusEvent evt) {
        if (mpvBloodField.getText().isEmpty()){
            mpvBloodField.setText("0.0");
        }
    }

    private void mpvBloodFieldMouseClicked(java.awt.event.MouseEvent evt) {
        mpvBloodField.setText("");
    }

    private void mchBloodFieldFocusLost(java.awt.event.FocusEvent evt) {
        if (mchBloodField.getText().isEmpty()){
            mchBloodField.setText("0.0");
        }
    }

    private void mchBloodFieldMouseClicked(java.awt.event.MouseEvent evt) {
       mchBloodField.setText("");
    }

    private void mchcBloodFieldFocusLost(java.awt.event.FocusEvent evt) {
        if (mchcBloodField.getText().isEmpty()){
            mchcBloodField.setText("0.0");
        } 
    }

    private void mchcBloodFieldMouseClicked(java.awt.event.MouseEvent evt) {
        mchcBloodField.setText("");
    }

    private void rdwBloodFieldFocusLost(java.awt.event.FocusEvent evt) {
        if (rdwBloodField.getText().isEmpty()){
            rdwBloodField.setText("0.0");
        }
    }

    private void rdwBloodFieldMouseClicked(java.awt.event.MouseEvent evt) {
        rdwBloodField.setText("");
    }

    private void plateletBloodFieldFocusLost(java.awt.event.FocusEvent evt) {
        if(plateletBloodField.getText().isEmpty()){
            plateletBloodField.setText("0.0");
        }
    }

    private void plateletBloodFieldMouseClicked(java.awt.event.MouseEvent evt) {
        plateletBloodField.setText("");
    }

    private void mcvBloodFieldFocusLost(java.awt.event.FocusEvent evt) {
        if (mcvBloodField.getText().isEmpty()){
            mcvBloodField.setText("0.0");
        }
    }

    private void mcvBloodFieldMouseClicked(java.awt.event.MouseEvent evt) {
        mcvBloodField.setText("");
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        this.dispose();
        new MainView().setVisible(true);
    }
}
