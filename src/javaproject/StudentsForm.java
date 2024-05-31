
package javaproject;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vaibhavi
 */
public class StudentsForm extends javax.swing.JFrame {

    /**
     * Creates new form StudentsForm
     */
    public StudentsForm() {
        initComponents();
       
        MySqlConnection();// for testing whether Database connection is successful or not
        fillTable();
    }

    public Connection MySqlConnection(){
        Connection conn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project",
                    "root", "root");
         // JOptionPane.showMessageDialog(null, "Mysql DB Connection Successful...");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Mysql Connection Failed....");
            return null;
        }    
    }
    
    File image = new File("C:\\Users\\VAIBHAVI\\Documents\\NetBeansProjects\\StudentManagement\\src\\images\\PHOTO.PNG");
    String photopath = image.getAbsolutePath();
       
    public ImageIcon resetImageSize(String photopath,byte[] photo){
        ImageIcon myPhoto=null;
        if (photopath!=null) {
            myPhoto=new ImageIcon(photopath);
        }else{
              myPhoto=new ImageIcon(photo);
        }
        Image img=myPhoto.getImage();
        Image img1=img.getScaledInstance(label_photo.getWidth(),label_photo.getHeight(),
                Image.SCALE_SMOOTH);
        ImageIcon ph=new ImageIcon(img1);
        return ph;        
    }
    
    //retrive all students in arraylist
    public ArrayList<StudentBean> retrieveData(){
        ArrayList<StudentBean> al=null;
                al=new ArrayList<StudentBean>();
       
        try {
            Connection conn=MySqlConnection();
            String qry="select * from students";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(qry);
            StudentBean student;
            
            while (rs.next()) {
                student =new StudentBean(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getString(4),
                        rs.getBytes("photo"));                
                al.add(student);
              }
           
        } catch (Exception e) {
            System.out.println(e);
        }
       return al; 
    }
    
    public void fillTable(){
        ArrayList<StudentBean> al=retrieveData();
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        model.setRowCount(0); // Empty/clear the table
        Object[] row=new Object[4];
        for (int i = 0; i < al.size(); i++) {
            row[0]=al.get(i).getId();
            row[1]=al.get(i).getName();
            row[2]=al.get(i).getEmail();
            row[3]=al.get(i).getDob();
            model.addRow(row);
        }
        //model.setRowCount(0);
    }
    //Show item/data to fields:
    public void showItemToFields(int index){
        jTextField_id.setText(Integer.toString(retrieveData().get(index).getId()));
        jTextField_name.setText(retrieveData().get(index).getName());
        jTextField_email.setText(retrieveData().get(index).getEmail());
        
        try {
            java.util.Date dob=null;
 dob=new SimpleDateFormat("dd-MM-yyyy").parse((String)retrieveData().get(index).getDob());
            jDateChooser1_dob.setDate(dob);          
         } catch (Exception e) {
             System.out.println("Error at showItemToFields method "+e);
        }
        label_photo.setIcon(resetImageSize(null, retrieveData().get(index).getPhoto()));         
    }
    
    
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField_id = new javax.swing.JTextField();
        jTextField_name = new javax.swing.JTextField();
        jTextField_email = new javax.swing.JTextField();
        jDateChooser1_dob = new com.toedter.calendar.JDateChooser();
        label_photo = new javax.swing.JLabel();
        jButton_new = new javax.swing.JButton();
        jButton_save = new javax.swing.JButton();
        jButton_delete = new javax.swing.JButton();
        jButton_update = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextField_search = new javax.swing.JTextField();
        jButton_photo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Project Created By : VAIBHAVI, YASH, PRATIK, SUJIT");
        setLocation(new java.awt.Point(100, 0));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(237, 228, 200));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jPanel1.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("         G. V . ACHARYA INSTITUTE OF ENGINEERING AND TECHNOLOGY");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Shelu,Tal - Karjat, Dist - Raigad, Maharashtra.");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.PNG"))); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Student Information");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Roll No:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Student Name:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Email:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Date of Birth:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Photo:");

        jTextField_id.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_id.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jTextField_name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jTextField_email.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jDateChooser1_dob.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jDateChooser1_dob.setDateFormatString("dd-MM-yyyy");
        jDateChooser1_dob.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        label_photo.setBackground(new java.awt.Color(255, 255, 255));
        label_photo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/PHOTO.PNG"))); // NOI18N
        label_photo.setOpaque(true);

        jButton_new.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton_new.setForeground(new java.awt.Color(0, 0, 153));
        jButton_new.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/check.png"))); // NOI18N
        jButton_new.setText("New ");
        jButton_new.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_newActionPerformed(evt);
            }
        });

        jButton_save.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton_save.setForeground(new java.awt.Color(0, 0, 153));
        jButton_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user_add.png"))); // NOI18N
        jButton_save.setText("Insert/Save");
        jButton_save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_saveActionPerformed(evt);
            }
        });

        jButton_delete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton_delete.setForeground(new java.awt.Color(0, 0, 153));
        jButton_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/erase.png"))); // NOI18N
        jButton_delete.setText("Delete");
        jButton_delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_deleteActionPerformed(evt);
            }
        });

        jButton_update.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton_update.setForeground(new java.awt.Color(0, 0, 153));
        jButton_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sync.png"))); // NOI18N
        jButton_update.setText("Update");
        jButton_update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_updateActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Search Student By Name:");

        jTextField_search.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jTextField_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_searchActionPerformed(evt);
            }
        });
        jTextField_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_searchKeyReleased(evt);
            }
        });

        jButton_photo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton_photo.setForeground(new java.awt.Color(0, 0, 153));
        jButton_photo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/folder_red.png"))); // NOI18N
        jButton_photo.setText("Select Photo");
        jButton_photo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_photo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_photoActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Roll No", "Student Name", "Email", "Date of Birth"
            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(394, 394, 394)
                        .addComponent(jLabel10)
                        .addGap(120, 120, 120)
                        .addComponent(jTextField_search, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(81, 81, 81))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(76, 76, 76)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton_photo, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel7)))
                                    .addGap(36, 36, 36)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(label_photo, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                                    .addComponent(jTextField_name)
                                                    .addComponent(jTextField_email)
                                                    .addComponent(jDateChooser1_dob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addComponent(jTextField_id, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jButton_new, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton_save, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton_update, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton_delete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(105, 105, 105))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(0, 0, Short.MAX_VALUE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(172, 172, 172)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField_id, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(jTextField_email, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jDateChooser1_dob, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(label_photo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton_photo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jButton_new, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jButton_save, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jButton_update, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jButton_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel3))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_search, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //for Selecting the photo 
    private void jButton_photoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_photoActionPerformed
        JFileChooser chooser=new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter fnef=new FileNameExtensionFilter("*.images", "jpg","png");
        chooser.addChoosableFileFilter(fnef);
        int ans=chooser.showSaveDialog(null);
        if (ans==JFileChooser.APPROVE_OPTION) {
            File selectedPhoto=chooser.getSelectedFile();
            String path=selectedPhoto.getAbsolutePath();
            label_photo.setIcon(resetImageSize(path, null));
            this.photopath=path;
        }
    }//GEN-LAST:event_jButton_photoActionPerformed

    //For save / insert the  students record to the database
    private void jButton_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_saveActionPerformed
        
        if ((jTextField_id!=null || jTextField_name!=null
        || jTextField_email!=null || jDateChooser1_dob!=null )&& photopath!=null) {
            try {
                Connection conn=MySqlConnection();
                //String qry="insert into students values(id,name,fees,dob,photo) values (?,?,?,?,?)";
                PreparedStatement ps=conn.prepareStatement("insert into students"
                        + "(id,name,fees,dob,photo) values (?,?,?,?,?)");
             
                ps.setInt(1, Integer.parseInt(jTextField_id.getText()));
                
                ps.setString(2,jTextField_name.getText());
                
                ps.setString(3, jTextField_email.getText());
                 
                
                SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
                String dob1=sdf.format(jDateChooser1_dob.getDate());
                ps.setString(4,dob1);
                
              
                InputStream is=new FileInputStream(new File(photopath));
                ps.setBlob(5, is);
                int res=ps.executeUpdate();
                 fillTable();
                if (res>=1) {
                    JOptionPane.showMessageDialog(null, "Insertion Sucessfully ..");
                }else
                    JOptionPane.showMessageDialog(null, "Insertion Failed ..");
            } catch (Exception e) {
               JOptionPane.showMessageDialog(null, e);
            }    
            
            jTextField_id.setText(null);
            jTextField_name.setText(null);
            jTextField_email.setText(null);
            photopath = image.getAbsolutePath();
            label_photo.setIcon(new ImageIcon(photopath));
           
               
        }else{
          
             JOptionPane.showMessageDialog(null, "All fields are compulsory ....");
       }
        
       
      
    }//GEN-LAST:event_jButton_saveActionPerformed

    //for Updating student information
    private void jButton_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_updateActionPerformed
        
          if (jTextField_id!=null || jTextField_name!=null
                    || jTextField_email!=null || jDateChooser1_dob!=null) {
              String qry=null;
              PreparedStatement ps=null;
              Connection conn=MySqlConnection();
              
              if (photopath==null) {
                    try {        
                        qry="update students set name=?, fees=?,dob=? where id=?";
                        ps=conn.prepareStatement(qry);
                        
                        ps.setString(1,jTextField_name.getText());
                        ps.setString(2, jTextField_email.getText());

                        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
                        String dob1=sdf.format(jDateChooser1_dob.getDate());
                        ps.setString(3,dob1);
                         
                        ps.setInt(4, Integer.parseInt(jTextField_id.getText()));
                        //InputStream is=new FileInputStream(new File(photopath));
                        //ps.setBlob(5, is);
                        
                        
                        int res=ps.executeUpdate();
                         fillTable();
                        if (res>=1) {
                            JOptionPane.showMessageDialog(null, " Updated Sucessfully ..");
                        }else
                            JOptionPane.showMessageDialog(null, "Updation Failed ..");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }           
                    jTextField_id.setText("");
                    jTextField_name.setText("");
                    jTextField_email.setText("");

                    }else{
                        try {    
                            InputStream is=new FileInputStream(new File(photopath));
                            
                        qry="update students set name=?, fees=?,dob=?, photo=? where id=?";
                        ps=conn.prepareStatement(qry);
                        
                        ps.setString(1,jTextField_name.getText());
                        ps.setString(2, jTextField_email.getText());

                        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
                        String dob1=sdf.format(jDateChooser1_dob.getDate());
                        ps.setString(3,dob1);
                        
                        ps.setBlob(4, is);
                        
                        ps.setInt(5, Integer.parseInt(jTextField_id.getText()));
                                                
                        int res=ps.executeUpdate();
                         fillTable();
                        if (res>=1) {
                            JOptionPane.showMessageDialog(null, " Updated Sucessfully ..");
                        }else
                            JOptionPane.showMessageDialog(null, "  Updation Failed ....");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }           
                    jTextField_id.setText("");
                    jTextField_name.setText("");
                    jTextField_email.setText("");
     
                    }
          }else
              JOptionPane.showMessageDialog(null, "All fields are mandatory.......");
    }//GEN-LAST:event_jButton_updateActionPerformed

    //for Deleting the student    
    private void jButton_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_deleteActionPerformed
        if (jTextField_id.getText().equals("")) {
               JOptionPane.showMessageDialog(null, "Please Enter the student id");
        }else{             
                try{
                String qry="delete from students where id=?";
                Connection conn=MySqlConnection();
                PreparedStatement ps=conn.prepareStatement(qry);
                ps.setInt(1, Integer.parseInt(jTextField_id.getText().toString()));
                int res=ps.executeUpdate();
                 fillTable();
                if (res>=1) {
                    JOptionPane.showMessageDialog(null, " Deleted Successfully ..");    
                }else
                    JOptionPane.showMessageDialog(null, " Deletion failed ..");    
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
                    
            jTextField_id.setText(null);
            jTextField_name.setText(null);
            jTextField_email.setText(null);
            photopath = image.getAbsolutePath();
            label_photo.setIcon(new ImageIcon(photopath));
    }//GEN-LAST:event_jButton_deleteActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int ind=jTable1.getSelectedRow();
        showItemToFields(ind);
    }//GEN-LAST:event_jTable1MouseClicked

    //to serach student by name
    private void jTextField_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_searchKeyReleased
               
        ArrayList<StudentBean> al=null;
                al=new ArrayList<StudentBean>();
       String val=jTextField_search.getText().toString();
        try {
            Connection conn=MySqlConnection();
            //String qry="select * from students where (name like '%"+val+"%' or id like '%"+Integer.parseInt(val)+"%')";
            String qry="select * from students where name like '%"+val+"%'";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(qry);
            StudentBean student;
            while (rs.next()) {
          student =new StudentBean(rs.getInt(1),rs.getString("name")
                  ,rs.getString(3),rs.getString(4),rs.getBytes("photo"));                
                al.add(student);
              }
            
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        model.setRowCount(0); // Empty/clear the table
        Object[] row=new Object[4];
        for (int i = 0; i < al.size(); i++) {
            row[0]=al.get(i).getId();
            row[1]=al.get(i).getName();
            row[2]=al.get(i).getEmail();
            row[3]=al.get(i).getDob();
            model.addRow(row);
        }           
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }//GEN-LAST:event_jTextField_searchKeyReleased

    private void jButton_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_newActionPerformed
        
        jTextField_id.setText("");
        jTextField_name.setText("");
        jTextField_email.setText("");
    }//GEN-LAST:event_jButton_newActionPerformed

    private void jTextField_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_searchActionPerformed

    /**
     * @param args the command line argument=
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new StudentsForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_delete;
    private javax.swing.JButton jButton_new;
    private javax.swing.JButton jButton_photo;
    private javax.swing.JButton jButton_save;
    private javax.swing.JButton jButton_update;
    private com.toedter.calendar.JDateChooser jDateChooser1_dob;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField_email;
    private javax.swing.JTextField jTextField_id;
    private javax.swing.JTextField jTextField_name;
    private javax.swing.JTextField jTextField_search;
    private javax.swing.JLabel label_photo;
    // End of variables declaration//GEN-END:variables
}
