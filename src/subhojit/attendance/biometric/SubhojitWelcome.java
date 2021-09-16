package subhojit.attendance.biometric;

import MFS100.DeviceInfo;
import MFS100.FingerData;
import MFS100.MFS100;
import MFS100.MFS100Event;
import java.awt.Color;
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
/*import java.util.logging.Level;
import java.util.logging.Logger;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;*/
import org.apache.commons.io.FileUtils;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class SubhojitWelcome extends javax.swing.JFrame implements MFS100Event {

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

    public SubhojitWelcome() {
        initComponents();
        clock();
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
        btnAutoCapture = new javax.swing.JButton();
        lblFinger = new javax.swing.JLabel();
        lblSerial1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        txt_password = new javax.swing.JTextField();
        Login = new java.awt.Button();
        jLabel3 = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lbltime = new javax.swing.JLabel();
        lblQuality = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblSerial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSerial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnAutoCapture.setText("Take Attendance");
        btnAutoCapture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutoCaptureActionPerformed(evt);
            }
        });

        lblFinger.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblSerial1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSerial1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSerial1.setText("MANTRA Softech India Pvt. Ltd. - MFS100");

        jLabel1.setText("UserName");

        jLabel2.setText("Password");

        Login.setActionCommand("Login");
        Login.setLabel("Login");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Admin Login");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblSerial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSerial1, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAutoCapture, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFinger, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_password, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                    .addComponent(txt_username))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbltime, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(lblQuality, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblSerial1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblFinger, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblQuality, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblSerial, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAutoCapture, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(lbltime, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAutoCaptureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutoCaptureActionPerformed
    

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //lblFinger.setVisible(true);
                //lblQuality.setVisible(true);
                FingerData fingerData = new FingerData();
                int ret = mfs100.AutoCapture(fingerData, timeout,  true,false);
                
                if (ret == 0) {
                    m_FingerPrintImage.setImage(mfs100.BytesToBitmap(fingerData.FingerImage()));
                    lblFinger.setIcon(m_FingerPrintImage);
                    lblFinger.repaint();

                    String dbURL = "jdbc:mysql://localhost:3306/std";
                    Connection dbCon = null; 
                    ResultSet rst;
                    Statement stmt1;
                    try {
                        dbCon = DriverManager.getConnection(dbURL, "root", "");
                        String sql = "select * from staffdata";
                        stmt1 = dbCon.createStatement();
                        rst = stmt1.executeQuery(sql);
                        if(rst.next()){
                            do{
                                String  encode=rst.getString(5);
                                byte[] decodedBytes = Base64.getDecoder().decode(encode);
                                int score=0;                            
                                score=mfs100.MatchISO(fingerData.ISOTemplate(), decodedBytes);
                                  if (score >= 14000) {
                                     JOptionPane.showMessageDialog(rootPane, "Attendance complete of  " +"User ID "+rst.getString(2),appTitle,JOptionPane.INFORMATION_MESSAGE);
                                       lblQuality.setText(null);
                                       lblFinger.setIcon(null);
                                   } else if (score >= 0 && score < 14000) {
                                       //JOptionPane.showMessageDialog(rootPane, "Finger Not Matched",appTitle,JOptionPane.INFORMATION_MESSAGE);
                                     } else {
                                       JOptionPane.showMessageDialog(rootPane, "Error: " + mfs100.GetLastError() + " (" + String.valueOf(ret) + ")",appTitle,JOptionPane.ERROR_MESSAGE);
                                     }
                               }while(rst.next());
                             }
                          else{
                            System.out.println("Record Not Found...");
                          }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                      }
   
                    //JOptionPane.showMessageDialog(rootPane, "Capture Success.\nFinger data is saved at application path" ,appTitle,JOptionPane.INFORMATION_MESSAGE );
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Error: " + mfs100.GetLastError() + " (" + String.valueOf(ret) + ")",appTitle,JOptionPane.ERROR_MESSAGE);
                }
            }
        };

        Thread trd = new Thread(runnable);
        trd.start();
    }//GEN-LAST:event_btnAutoCaptureActionPerformed

    private void DBConBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DBConBtnActionPerformed
        // TODO add your handling code here:
        String dbURL = "jdbc:mysql://localhost:3306/new";
        String username ="root";
        String password = "";
       
        Connection dbCon = null;
        Statement stmt = null;
        ResultSet rs = null;


    String query ="select count(*) from staff";
            try {
            //getting database connection to MySQL server
            dbCon = DriverManager.getConnection(dbURL, username, password);
           
            //getting PreparedStatment to execute query
            stmt = dbCon.prepareStatement(query);
           
            //Resultset returned by query
            rs = stmt.executeQuery(query);
           
            while(rs.next()){
             int count = rs.getInt(1);
             System.out.println("count of stock : " + count);
            }
           
        } catch (SQLException ex) {
            //Logger.getLogger(CollectionTest.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
           //close connection ,stmt and resultset here
        }
    }//GEN-LAST:event_DBConBtnActionPerformed

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
             // TODO add your handling code here:
               String dbURL = "jdbc:mysql://localhost:3306/std";
               String username ="root";
               String password = ""; 
                try{
                   Connection dbCon = null;
                   int count=0;
                   dbCon = DriverManager.getConnection(dbURL, username, password);
                   ResultSet rs=null;
                   PreparedStatement stmt1 = dbCon.prepareStatement("select id,username,password,division from users Where (username =? and password =? and division ='Admin')");
                     stmt1.setString(1,txt_username.getText());
                     stmt1.setString(2,txt_password.getText());
                     rs=stmt1.executeQuery();
             
               while(rs.next()){
               int id = rs.getInt(1);
               Emp.empId = id;
               count =count+1;
               if(count==1){
                   JOptionPane.showMessageDialog(null,"Sucess" );
                   MainMenu j = new MainMenu();
                   j.setVisible(true);
                   this.dispose();
               }
              }  
             } catch(Exception e)
               {
             JOptionPane.showMessageDialog(null, e);
             }

    }//GEN-LAST:event_LoginActionPerformed

    @Override
    public void OnPreview(final FingerData fingerData) {
        //System.out.println("OnPreview");

        Runnable runnable = new Runnable() {
            public void run() {
                m_FingerPrintImage.setImage(mfs100.BytesToBitmap(fingerData.FingerImage()));
                lblFinger.setIcon(m_FingerPrintImage);
                lblFinger.repaint();
                lblQuality.setText("Quality: " + String.valueOf(fingerData.Quality()));
                lblQuality.repaint();
            }
        };
        Thread trd = new Thread(runnable);
        trd.start();

    }

    @Override
    public void OnCaptureCompleted(boolean status, int errorCode, String errorMsg, final FingerData fingerData) {
        if (status) {
            Runnable runnable = new Runnable() {
                public void run() {
                    m_FingerPrintImage.setImage(mfs100.BytesToBitmap(fingerData.FingerImage()));
                    lblFinger.setIcon(m_FingerPrintImage);
                    lblFinger.repaint();
                    lblQuality.setText("Quality: " + String.valueOf(fingerData.Quality()) + " Nfiq: " + String.valueOf(fingerData.Nfiq()));
                    lblQuality.repaint();
                    
                    //WriteBytesToFileTemp("FingerImage.bmp", fingerData.FingerImage());
                    WriteBytesToFileTemp("ISOTemplate.iso", fingerData.ISOTemplate());
                    try{ 
                      String FilePath = System.getProperty("user.dir");
                       FilePath += "\\FingerData\\tmp\\ISOTemplate.iso";
                       byte[] fileContent = FileUtils.readFileToByteArray(new File(FilePath));
                       String encodedString = Base64.getEncoder().encodeToString(fileContent);
                       
                              String dbURL = "jdbc:mysql://localhost:3306/finger";
                              String username ="root";
                              String password = "";      
                                 try {
                                    Connection dbCon = null;
                                     ResultSet rs1 = null;
                                      //getting database connection to MySQL server
                                      dbCon = DriverManager.getConnection(dbURL, username, password);
                                      PreparedStatement stmt1 = dbCon.prepareStatement("insert into finger(finger) values (?)");
                                      //stmt1.setInt(1,101);
                                      stmt1.setString(1, encodedString);
                                      int i=stmt1.executeUpdate();  
                                       System.out.println(i+" records inserted");  
                                            dbCon.close();         
                                          } catch (SQLException ex) {
                                    //Logger.getLogger(CollectionTest.class.getName()).log(Level.SEVERE, null, ex);
                              } finally{
                            //close connection ,stmt and resultset here
                          }
                      } catch (Exception ex) {
                      }}
                     };
            JOptionPane.showMessageDialog(rootPane, "Capture Success.\nFinger data is saved at database",appTitle,JOptionPane.INFORMATION_MESSAGE);
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
        }
    }



    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SubhojitWelcome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button Login;
    private javax.swing.JButton btnAutoCapture;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblFinger;
    private javax.swing.JLabel lblQuality;
    private javax.swing.JLabel lblSerial;
    private javax.swing.JLabel lblSerial1;
    private javax.swing.JLabel lbltime;
    private javax.swing.JTextField txt_password;
    private javax.swing.JTextField txt_username;
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


public void clock()
     {
         Thread clock=new Thread()
                 {
                 public void run()
                 {
                     try {
                    while(true)
                        {
                         Calendar cal=new GregorianCalendar();
                         int day=cal.get(Calendar.DAY_OF_MONTH);
                         int month=cal.get(Calendar.MONTH)+1;
                         int year=cal.get(Calendar.YEAR);                   
                    int second=cal.get(Calendar.SECOND);
                    int minute=cal.get(Calendar.MINUTE);
                    int hour=cal.get(Calendar.HOUR);

                    lbltime.setText( hour +":"+ minute +":"+ second);
                    lblDate.setText( year +"-"+ month +"-"+ day );
                  //  getTime=lbltime.getText();
                   // getDate=lbldate.getText();
                                    sleep(1000);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, e);


                }
            }
           };
        clock.start();
      }

}
