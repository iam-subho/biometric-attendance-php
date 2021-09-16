package subhojit.attendance.biometric;

import MFS100.DeviceInfo;
import MFS100.FingerData;
import MFS100.MFS100;
import MFS100.MFS100Event;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.commons.io.FileUtils;


public class SubhojitStudent extends javax.swing.JFrame implements MFS100Event {

    String appTitle="MANTRA.MFS100.Test";
    String key = "";
    MFS100 mfs100 = null;
    DeviceInfo deviceInfo = new DeviceInfo();
    int quality = 60;
    int timeout = 10000;
    byte[] ISOTemplate = null;
    byte[] ANSITemplate = null;
    private MyIcon m_FingerPrintImage;
    private FingerData lastCapFingerData = null;
    

    public SubhojitStudent() {
        initComponents();
        m_FingerPrintImage = new MyIcon(lblFinger.getWidth(), lblFinger.getHeight());
        lblFinger.setIcon(null);
        mfs100 = new MFS100(this, key);
        lblSerial.setText("");
        int ret = mfs100.Init();
        if (ret == 0) {
            deviceInfo = mfs100.GetDeviceInfo();
            lblSerial.setText("Serial No: " + deviceInfo.SerialNo() + "     Make: " + deviceInfo.Make() + "     Model: " + deviceInfo.Model());
            System.out.println("Width: " + String.valueOf(deviceInfo.Width()));
            System.out.println("Height: " + String.valueOf(deviceInfo.Height()));
            //JOptionPane.showMessageDialog(rootPane, "Scanner Initialized",appTitle,JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Error: " + mfs100.GetLastError() + " (" + String.valueOf(ret) + ")",appTitle,JOptionPane.ERROR_MESSAGE);

        }
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, 
        size.height/2 - getHeight()/2);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSerial = new javax.swing.JLabel();
        lblFinger = new javax.swing.JLabel();
        lblSerial1 = new javax.swing.JLabel();
        lblQuality = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        staffid = new javax.swing.JTextField();
        firstname = new javax.swing.JTextField();
        surname = new javax.swing.JTextField();
        captureansave = new javax.swing.JButton();
        backtoI = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblSerial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSerial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblFinger.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblFinger.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFingerMouseClicked(evt);
            }
        });

        lblSerial1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSerial1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSerial1.setText("Subhojit Kundu");

        lblQuality.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel1.setText("Satff ID");

        jLabel2.setText("First Name");

        jLabel3.setText("Surname");

        captureansave.setText("Capture & Save");
        captureansave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                captureansaveActionPerformed(evt);
            }
        });

        backtoI.setText("BACK");
        backtoI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backtoIMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(310, 310, 310)
                                .addComponent(lblQuality, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(staffid)
                                    .addComponent(firstname)
                                    .addComponent(surname, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblFinger, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(captureansave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(71, 71, 71))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblSerial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSerial1, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backtoI, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSerial1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backtoI, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(staffid, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(surname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(119, 119, 119)
                        .addComponent(lblQuality, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSerial, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFinger, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(captureansave, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents




    private void captureansaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_captureansaveActionPerformed
        int ret = mfs100.StartCapture(quality, timeout,true);
        if (ret != 0) {
            JOptionPane.showMessageDialog(rootPane, "Error: " + mfs100.GetLastError() + " (" + String.valueOf(ret) + ")",appTitle,JOptionPane.ERROR_MESSAGE);
        }    
    }//GEN-LAST:event_captureansaveActionPerformed

    private void backtoIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backtoIMouseClicked
                   MainMenu j = new MainMenu();
                   j.setVisible(true);
                   this.dispose();      // TODO add your handling code here:
    }//GEN-LAST:event_backtoIMouseClicked

    private void lblFingerMouseClicked(java.awt.event.MouseEvent evt){
    
    }
    @Override
    public void OnPreview(final FingerData fingerData) {
        //System.out.println("OnPreview");

        Runnable runnable = new Runnable() {
            public void run() {
                m_FingerPrintImage.setImage(mfs100.BytesToBitmap(fingerData.FingerImage()));
                lblFinger.setIcon(m_FingerPrintImage);
                lblFinger.repaint();
            }
        };
        Thread trd = new Thread(runnable);
        trd.start();

    }

    @Override
    public void OnCaptureCompleted(boolean status, int errorCode, String errorMsg, final FingerData fingerData) {
        if (status) {          
                    m_FingerPrintImage.setImage(mfs100.BytesToBitmap(fingerData.FingerImage()));
                    lblFinger.setIcon(m_FingerPrintImage);
                    lblFinger.repaint();
                    WriteBytesToFileTemp("ISOTemplate.iso", fingerData.ISOTemplate());
                    String FilePath = System.getProperty("user.dir");
                    FilePath += "\\FingerData\\tmp\\ISOTemplate.iso";
                    try{ 
                       byte[] fileContent = FileUtils.readFileToByteArray(new File(FilePath));
                       String encodedString = Base64.getEncoder().encodeToString(fileContent);
                       
                              String dbURL = "jdbc:mysql://localhost:3306/std";
                              String username ="root";
                              String password = "";      
                                 try {
                                    Connection dbCon = null;
                                     ResultSet rs1 = null;
                                      //getting database connection to MySQL server
                                      dbCon = DriverManager.getConnection(dbURL, username, password);
                                      PreparedStatement stmt1 = dbCon.prepareStatement("insert into staffdata(id,first_name,surname,fingerdata) values (?,?,?,?)");
                                      stmt1.setString(1,staffid.getText());
                                      stmt1.setString(2,firstname.getText());
                                      stmt1.setString(3,surname.getText());
                                      stmt1.setString(4, encodedString);
                                      int i=stmt1.executeUpdate();  
                                      System.out.println(i+" records inserted"); 
                                      JOptionPane.showMessageDialog(rootPane, "Capture Success.\nFinger data is saved at database",appTitle,JOptionPane.INFORMATION_MESSAGE);
                                            dbCon.close();         
                                          } catch (SQLException ex) {
                                   ex.printStackTrace();
                                    
                              } finally{
                            //close connection ,stmt and resultset here
                          }
                      } catch (Exception ex) {
                          ex.printStackTrace();
                      }
                      System.out.println(FilePath);                   
               } else {
            JOptionPane.showMessageDialog(rootPane, errorMsg + " (" + String.valueOf(errorCode) + ")",appTitle,JOptionPane.ERROR_MESSAGE);
        }
    }

        private void WriteBytesToFileTemp(String FileName, byte[] Bytes) {
        try {
            String FilePath = System.getProperty("user.dir");
            FilePath += "\\FingerData\\tmp";
            File file = new File(FilePath);
            if (!file.exists()) {
                file.mkdir();
            }
            FilePath += "\\" + FileName;
            FileOutputStream fos = new FileOutputStream(FilePath);
            fos.write(Bytes);
            fos.close();
        } catch (Exception ex) {
             ex.printStackTrace();
        }
    }



    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SubhojitStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backtoI;
    private javax.swing.JButton captureansave;
    private javax.swing.JTextField firstname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblFinger;
    private javax.swing.JLabel lblQuality;
    private javax.swing.JLabel lblSerial;
    private javax.swing.JLabel lblSerial1;
    private javax.swing.JTextField staffid;
    private javax.swing.JTextField surname;
    // End of variables declaration//GEN-END:variables

    public class MyIcon implements Icon {

        int _Width = 0;
        int _Height = 0;

        public MyIcon(int Width, int Height) {
            this._Width = Width;
            this._Height = Height;
            m_Image = null;
        }

        public void paintIcon(Component c, Graphics g, int x, int y) {
            if (m_Image != null) {
                g.drawImage(m_Image, x, y, getIconWidth(), getIconHeight(), null);
            } else {
                g.fillRect(x, y, getIconWidth(), getIconHeight());
            }
        }

        public int getIconWidth() {
            return _Width;
        }

        public int getIconHeight() {
            return _Height;
        }

        public boolean LoadImage(String path) {
            boolean bRetCode = false;
            Image newImg;
            try {
                File f = new File(path);
                newImg = ImageIO.read(f);
                bRetCode = true;
                setImage(newImg);
            } catch (IOException e) {
            }

            return bRetCode;
        }

        public void setImage(Image Img) {
            if (Img != null) {
                m_Image = Img.getScaledInstance(getIconWidth(), getIconHeight(), Image.SCALE_FAST);
            } else {
                m_Image = null;
            }
        }

        private Image m_Image;
    }
}
