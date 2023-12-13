import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JOptionPane;

/**
 * BarCodeIcon.java
 * This class is responsible of displying the generated bar code.
 * @version 12/10/2023
 * @author Abderrahmane Fadli
 */
public class BarCodeIcon extends javax.swing.JFrame {

    /**
     * Creates new form BardCodeIcon
     */
    public BarCodeIcon() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        iconeLabel = new javax.swing.JLabel();
        iconeBarcodeLabel = new javax.swing.JLabel();
        barcodeIconeMenu = new javax.swing.JMenuBar();
        barcodeIconePrint = new javax.swing.JMenu();
        barcodeIconeEdit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setName("barcodeIconPanel"); 
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        iconeBarcodeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        barcodeIconePrint.setText("Print");
        barcodeIconePrint.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        barcodeIconePrint.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        barcodeIconePrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                barcodeIconePrintMousePressed(evt);
            }
        });
        barcodeIconeMenu.add(barcodeIconePrint);

        barcodeIconeEdit.setText("Close");
        barcodeIconeEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                barcodeIconeEditMousePressed(evt);
            }
        });
        barcodeIconeMenu.add(barcodeIconeEdit);

        setJMenuBar(barcodeIconeMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(304, 304, 304)
                        .addComponent(iconeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(iconeBarcodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(201, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(iconeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(iconeBarcodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(174, Short.MAX_VALUE))
        );

        pack();
    }

    /**
     * When user clicks on 'Print', the user is prompted to print the barcode.
     * 
     * @param evt 
     */
    private void barcodeIconePrintMousePressed(java.awt.event.MouseEvent evt) {
        //https://www.youtube.com/watch?v=ivSPqBGT4EQ&ab_channel=JobMETechSolutions
        
        PrinterJob printFrame = PrinterJob.getPrinterJob();
        printFrame.setJobName("Print BarCode");
        printFrame.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if (pageIndex > 0){
                    return Printable.NO_SUCH_PAGE;
                }
                
                // make 2d graph and paint it
                Graphics2D graph = (Graphics2D) graphics;
                graph.translate(pageFormat.getImageableX()*2, pageFormat.getImageableY()*2);
                graph.scale(0.5, 0.5);
                paint(graph);
                
                // return if page exist
                return Printable.PAGE_EXISTS;
            }
        });
        
        boolean printResult = printFrame.printDialog();
        
        // check if dialog is showing
        if (printResult){
            
            try {
                // call print method 
                printFrame.print();
            } catch (PrinterException pe){
                JOptionPane.showMessageDialog(this, "Error message: " + pe.getMessage());
            }
        }
    }

    private void barcodeIconeEditMousePressed(java.awt.event.MouseEvent evt) {
        this.dispose();
    }

    private void formWindowClosed(java.awt.event.WindowEvent evt) {
        this.dispose();
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        this.dispose();
    }


    // Variables declaration - do not modify
    private javax.swing.JMenu barcodeIconeEdit;
    private javax.swing.JMenuBar barcodeIconeMenu;
    private javax.swing.JMenu barcodeIconePrint;
    public javax.swing.JLabel iconeBarcodeLabel;
    public javax.swing.JLabel iconeLabel;
    // End of variables declaration
}
