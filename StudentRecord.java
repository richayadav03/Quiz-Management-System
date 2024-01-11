/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oop_assignment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import net.proteanit.sql.DbUtils;

public class StudentRecord extends javax.swing.JFrame {
String s50;
String s51;
int b;
    /**
     * Creates new form StudentRecord
     */
    public StudentRecord(String str,String str1,int n){
     
     initComponents();
        s50=str;
        s51=str1;
        b=n;
        GL2.setText(str);
        GL1.setText(str1);
        Connection connection = null;
	Statement statement = null;
	ResultSet rs=null;
        ResultSet resultSet = null;

		try{
	connection =DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
         statement=connection.createStatement();
           switch(b){
                            case 1:
                               resultSet = statement.executeQuery("select * from marks where marks IS NOT NULL and cid='2CS301'; ");
//			       rs=statement.executeQuery("select avg(marks) from marks;");
                                
                                
                                break;
                                 case 2:
                                     resultSet = statement.executeQuery("select * from marks where marks IS NOT NULL and cid='2CS302'; ");
//				     rs=statement.executeQuery("select avg(marks) from marks;");
                                break;
                                 case 3:
                                     resultSet = statement.executeQuery("select *  from marks where marks IS NOT NULL and cid='2CS303'; ");
//				     rs=statement.executeQuery("select avg(marks) from marks;");
                                break;
                                 case 4:
                                     resultSet = statement.executeQuery("select *  from marks where marks IS NOT NULL and cid='2CS304'; ");
//				     rs=statement.executeQuery("select avg(marks) from marks;");
                                break;
                                 case 5:
                                      resultSet = statement.executeQuery("select *  from marks where marks IS NOT NULL and cid='2CS305'; ");
//				      rs=statement.executeQuery("select avg(marks) from marks;");
                                break;
                                 case 6:
                                     resultSet = statement.executeQuery("select *  from marks where marks IS NOT NULL and cid='2CS306'; ");
//				     rs=statement.executeQuery("select avg(marks) from marks;");
                                break;
                            default:
                                break;
                        }
	   
	   
	   
	  tab.setModel(DbUtils.resultSetToTableModel(resultSet));
	  
	  
	  
	   switch(b){
                            case 1:
//                                resultSet = statement.executeQuery("select rollno,marks,avg(marks) from marks where marks IS NOT NULL and cid='2CS301'; ");
				rs=statement.executeQuery("select avg(marks) from marks group by cid having cid='2CS301';");
                                                                
                                break;
                                 case 2:
//                                     resultSet = statement.executeQuery("select rollno,marks  from marks where marks IS NOT NULL and cid='2CS302'; ");
				    rs=statement.executeQuery("select avg(marks) from marks group by cid having cid='2CS302';");
                                break;
                                 case 3:
//                                     resultSet = statement.executeQuery("select rollno,marks  from marks where marks IS NOT NULL and cid='2CS303'; ");
				    rs=statement.executeQuery("select avg(marks) from marks group by cid having cid='2CS303';");
                                break;
                                 case 4:
//                                     resultSet = statement.executeQuery("select rollno,marks  from marks where marks IS NOT NULL and cid='2CS304'; ");
				    rs=statement.executeQuery("select avg(marks) from marks group by cid having cid='2CS304';");
                                break;
                                 case 5:
//                                     resultSet = statement.executeQuery("select rollno,marks  from marks where marks IS NOT NULL and cid='2CS305'; ");
				     rs=statement.executeQuery("select avg(marks) from marks group by cid having cid='2CS305';");
                                break;
                                 case 6:
//                                     resultSet = statement.executeQuery("select rollno,marks  from marks where marks IS NOT NULL and cid='2CS306'; ");
				     rs=statement.executeQuery("select avg(marks) from marks group by cid having cid='2CS306';");
                                break;
                            default:
                                break;
                        }
                       
 
				if(rs.next()){
					avg.setText(String.valueOf(rs.getDouble(1)));
				}

		}catch(Exception e){
			System.out.println(e);
		}
        
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tab = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jj1 = new javax.swing.JLabel();
        j2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        GL2 = new javax.swing.JLabel();
        GL1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        avg = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(239, 188, 117));

        tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tab);

        jPanel2.setBackground(new java.awt.Color(26, 74, 90));

        jj1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jj1.setForeground(new java.awt.Color(255, 255, 255));
        jj1.setText("EXAMZAAPO.com");

        j2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oop_assignment/Untitled design.jpg"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("A QUIZ MANAGEMENT SYSTEM");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oop_assignment/adm2.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");

        GL2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        GL2.setForeground(new java.awt.Color(255, 255, 255));
        GL2.setText("ADMIN");

        GL1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        GL1.setForeground(new java.awt.Color(255, 255, 255));
        GL1.setText("ADMIN - HOMEPAGE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(j2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jj1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(GL1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(GL2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(j2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jj1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)))
                        .addGap(18, 18, 18)
                        .addComponent(GL1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GL2))))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oop_assignment/icons8-back-arrow-50 (1).jpg"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        avg.setText("    ");

        jLabel1.setText("Class Average :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(avg, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(avg)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Admin3 o1= new Admin3(s50,s51,b);
        this.dispose();
        o1.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    
        static final String DB_URL ="jdbc:mysql://localhost:3306/quiz";
	static final String DB_DRV ="com.mysql.jdbc.Driver";
	static final String DB_USER = "root";
	static final String DB_PASSWD = "abc";
    /**
     * @param args the command line arguments
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
            java.util.logging.Logger.getLogger(StudentRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentRecord("hi","hello",0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel GL1;
    private javax.swing.JLabel GL2;
    private javax.swing.JLabel avg;
    private javax.swing.JLabel j2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jj1;
    private javax.swing.JTable tab;
    // End of variables declaration//GEN-END:variables
}
