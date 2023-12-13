import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * MainView.java
 * @version 12/10/2023
 * @author Abderrahmane Fadli
 */
public class MainView extends javax.swing.JFrame {

    /*  variables */
    private javax.swing.JPanel MainViewPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    /*  end  */


    /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        MainViewPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jButton1.setText("New User");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Existing User");
        jButton2.setMaximumSize(new java.awt.Dimension(94, 24));
        jButton2.setMinimumSize(new java.awt.Dimension(94, 24));
        jButton2.setPreferredSize(new java.awt.Dimension(94, 24));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MainViewPanelLayout = new javax.swing.GroupLayout(MainViewPanel);
        MainViewPanel.setLayout(MainViewPanelLayout);
        MainViewPanelLayout.setHorizontalGroup(
            MainViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainViewPanelLayout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(197, Short.MAX_VALUE))
        );
        MainViewPanelLayout.setVerticalGroup(
            MainViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainViewPanelLayout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addGroup(MainViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(249, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainViewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainViewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    /**
     * When new User button is clicked, the main view gui is closed and 
     * new NewuserView object is instantiated 
     * 
     */
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {
        this.dispose();
        new NewUserView().setVisible(true);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        JFileChooser fileChooser = new JFileChooser("./");
        fileChooser.setDialogTitle("Choose a JPG File");

        // Set file filter to only allow PNG files
        FileNameExtensionFilter jpgFilter = new FileNameExtensionFilter("JPG Files", "jpg");
        fileChooser.setFileFilter(jpgFilter);

        // Show the file chooser dialog
        int userSelection = fileChooser.showOpenDialog(null);
        
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            try {
                File selectedFile = fileChooser.getSelectedFile();
                this.dispose();
                ExistingUserView exiting_user = new ExistingUserView(selectedFile.getAbsolutePath());
                exiting_user.setVisible(true);
            } catch (Exception e) {
                System.err.println("[ERROR]: Existing user function"); 
            }
        } else {
            System.out.println("File selection canceled.");
        }
    }

    public static void main(String args[]) {       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }
}
