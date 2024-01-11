/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oop_assignment;


import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author BHAVYA
 */
public class QUIZ extends javax.swing.JFrame {
String s50;
String s51; 
String e;  
int b;
public int n;
public int n1;
ResultSet rs;
ResultSet rs1;

public int marks = 0;
public String answer;
    /**
     * Creates new form SUB
     */
    public QUIZ(String str,String str1,int CA) {
    s50=str;
    s51=str1;
    b=CA;
        
        initComponents();
        GL4.setText(str1);
        GL5.setText(str);
        	SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		jLabel3.setText(dFormat.format(date));
                String sd=dFormat.format(date);
		Connection connection = null;
		Statement statement = null;
		
		try{
			connection=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
			statement=connection.createStatement();	
                        
                        switch(b){
                            case 1:
                                rs = statement.executeQuery("select * from que_bank where cid='2CS301' order by RAND(); ");
                                break;
                                 case 2:
                                     rs = statement.executeQuery("select * from que_bank where cid='2CS302' order by RAND(); ");
                                break;
                                 case 3:
                                     rs = statement.executeQuery("select * from que_bank where cid='2CS303' order by RAND(); ");
                                break;
                                 case 4:
                                     rs = statement.executeQuery("select * from que_bank where cid='2CS304' order by RAND(); ");
                                break;
                                 case 5:
                                     rs = statement.executeQuery("select * from que_bank where cid='2CS305' order by RAND(); ");
                                break;
                                 case 6:
                                     rs = statement.executeQuery("select * from que_bank where cid='2CS306' order by RAND(); ");
                                break;
                            default:
                                break;
                        
                        }
			if(rs.next()){
                            
			String so1,so2,so3,so4;
				jLabel2.setText(String.valueOf(1));
				question.setText(rs.getString(4));
				
				String[] strings = {rs.getString(5),rs.getString(6),rs.getString(7), rs.getString(8)};
				Random rand = new Random();

				// assign strings randomly to variables
				so1 = strings[rand.nextInt(4)];
				so2 = strings[rand.nextInt(4)];
				while (so2.equals(so1)) {
				    so2 = strings[rand.nextInt(4)];
				}
				so3 = strings[rand.nextInt(4)];
				while (so3.equals(so1) || so3.equals(so2)) {
				    so3 = strings[rand.nextInt(4)];
				}
				so4 = strings[rand.nextInt(4)];
				while (so4.equals(so1) || so4.equals(so2) || so4.equals(so3)) {
				    so4 = strings[rand.nextInt(4)];
				}
			
				opt1.setText(so1);
				opt2.setText(so2);
				opt3.setText(so3);
				opt4.setText(so4);
				answer = rs.getString(5);
				n=2;
			}
                        else{
                        question.setText("DATA NOT FOUND!! NO EXAM!!");
                                        next.setVisible(false);
                                        jLabel1.setText("");
					jLabel2.setText("");
					opt1.setVisible(false);
					opt2.setVisible(false);
					opt3.setVisible(false);
				        opt4.setVisible(false);
                                                                       
                        }
                        }
		catch(Exception e){
			System.out.println(e);
		}
    
    
   }
    
public void answerCheck(){
		String studentAnswer="";
		if (opt1.isSelected()){
			studentAnswer = opt1.getText();
		}else if (opt2.isSelected()){
			studentAnswer = opt2.getText();
		}else if (opt3.isSelected()){
			studentAnswer =opt3.getText();
		}else{
			studentAnswer = opt4.getText();
		}
		
		if(studentAnswer.equals(answer)){
			marks++;
		}
		
		//clear jRadioButton
		opt1.setSelected(false);
		opt2.setSelected(false);
		opt3.setSelected(false);
		opt4.setSelected(false);		
	}
public void question(){
//		Connection connection = null;
//		Statement statement = null;
		int k=0;
		try{
//			connection=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
//			statement=connection.createStatement();
//			   switch(b){
//                            case 1:
//                                rs = statement.executeQuery("select * from que_bank where cid='2CS301' order by RAND(); ");
//                                break;
//                                 case 2:
//                                     rs = statement.executeQuery("select * from que_bank where cid='2CS302' order by RAND(); ");
//                                break;
//                                 case 3:
//                                     rs = statement.executeQuery("select * from que_bank where cid='2CS303' order by RAND(); ");
//                                break;
//                                 case 4:
//                                     rs = statement.executeQuery("select * from que_bank where cid='2CS304' order by RAND(); ");
//                                break;
//                                 case 5:
//                                     rs = statement.executeQuery("select * from que_bank where cid='2CS305' order by RAND(); ");
//                                break;
//                                 case 6:
//                                     rs = statement.executeQuery("select * from que_bank where cid='2CS306' order by RAND(); ");
//                                break;
//                            default:
//                                break;
//                        }		
//			while(k<n){
//			rs.next();
//			k++;
//			}
//			rs.next();
			
                        
				//for last que hide next
				if (!rs.next()||n==12) {
                                    
					next.setVisible(false);
                                        jLabel1.setText("");
					jLabel2.setText("");
					question.setText("Exam Completed.\nPlease click on Submit Button.");
					opt1.setVisible(false);
					opt2.setVisible(false);
					opt3.setVisible(false);
					opt4.setVisible(false);
		  
				}
                                else{
                                
                                jLabel2.setText(String.valueOf(n));
			question.setText(rs.getString(4));
				String so1,so2,so3,so4;
				String[] strings = {rs.getString(5),rs.getString(6),rs.getString(7), rs.getString(8)};
				Random rand = new Random();

				// assign strings randomly to variables
				so1 = strings[rand.nextInt(4)];
				so2 = strings[rand.nextInt(4)];
				while (so2.equals(so1)) {
				    so2 = strings[rand.nextInt(4)];
				}
				so3 = strings[rand.nextInt(4)];
				while (so3.equals(so1) || so3.equals(so2)) {
				    so3 = strings[rand.nextInt(4)];
				}
				so4 = strings[rand.nextInt(4)];
				while (so4.equals(so1) || so4.equals(so2) || so4.equals(so3)) {
				    so4 = strings[rand.nextInt(4)];
				}  
				
				opt1.setText(so1);
				opt2.setText(so2);
				opt3.setText(so3);
				opt4.setText(so4);
				answer = rs.getString(5);
			        n++;
                        
                                
                                
                                }
                        
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
public void submit(){
		//String rollno = jLable.getText();
		answerCheck();
		Connection connection = null;
		Statement statement = null;
                SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		//jLabel3.setText(dFormat.format(date));
                String sd=dFormat.format(date);
		
		try{
			connection=DriverManager.getConnection(DB_URL1,DB_USER,DB_PASSWD);
			statement=connection.createStatement();
                        switch(b){
                            case 1:
			statement.executeUpdate("insert into marks values ('"+s50+"','2CS301',DATE('"+sd+"'),"+marks+");");
                        break;
                        
                        case 2:
			statement.executeUpdate("insert into marks values ('"+s50+"','2CS302',DATE('"+sd+"'),"+marks+");");
                        break;
                        
                        case 3:
			statement.executeUpdate("insert into marks values ('"+s50+"','2CS303',DATE('"+sd+"'),"+marks+");");
                        break;
                        
                        case 4:
			statement.executeUpdate("insert into marks values ('"+s50+"','2CS304',DATE('"+sd+"'),"+marks+");");
                        break;
                        
                        case 5:
			statement.executeUpdate("insert into marks values ('"+s50+"','2CS305',DATE('"+sd+"'),"+marks+");");
                        break;
                        
                        case 6:
			statement.executeUpdate("insert into marks values ('"+s50+"','2CS306',DATE('"+sd+"'),"+marks+");");
                        break;
                        default :
                            break;
                        }
                        
                        
                        
                        
                        rs1=statement.executeQuery("select email_id  from studentinfo where rollno='"+s50+"';");
                      while(rs1.next()){
                        e=rs1.getString(1);
                      }
			String marks1=String.valueOf(marks);
			JOptionPane.showMessageDialog(null, marks1);
			setVisible(false);
			//new Submit(marks1).setVisible(true);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jj1 = new javax.swing.JLabel();
        j2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        GL1 = new javax.swing.JLabel();
        GL3 = new javax.swing.JLabel();
        GL2 = new javax.swing.JLabel();
        GL5 = new javax.swing.JLabel();
        GL4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        question = new javax.swing.JLabel();
        opt1 = new javax.swing.JRadioButton();
        opt2 = new javax.swing.JRadioButton();
        opt3 = new javax.swing.JRadioButton();
        opt4 = new javax.swing.JRadioButton();
        next = new javax.swing.JButton();
        Submit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(239, 188, 117));

        jPanel2.setBackground(new java.awt.Color(26, 74, 90));

        jj1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jj1.setForeground(new java.awt.Color(255, 255, 255));
        jj1.setText("EXAMZAAPO.com");

        j2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oop_assignment/Untitled design.jpg"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("A QUIZ MANAGEMENT SYSTEM");

        GL1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        GL1.setForeground(new java.awt.Color(255, 255, 255));
        GL1.setText("STUDENT");

        GL3.setForeground(new java.awt.Color(255, 255, 255));

        GL2.setForeground(new java.awt.Color(255, 255, 255));

        GL5.setForeground(new java.awt.Color(255, 255, 255));
        GL5.setText("jLabel2");

        GL4.setForeground(new java.awt.Color(255, 255, 255));
        GL4.setText(" ");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(j2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(GL5, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                            .addComponent(GL4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jj1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(GL3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(GL2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29))
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(GL1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(j2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(GL3)
                                .addGap(56, 56, 56)
                                .addComponent(GL2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GL4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GL5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jj1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(GL1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Que.");

        question.setText("que......");

        opt1.setBackground(new java.awt.Color(239, 188, 117));
        opt1.setText("jRadioButton1");
        opt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt1ActionPerformed(evt);
            }
        });

        opt2.setBackground(new java.awt.Color(239, 188, 117));
        opt2.setText("jRadioButton2");
        opt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt2ActionPerformed(evt);
            }
        });

        opt3.setBackground(new java.awt.Color(239, 188, 117));
        opt3.setText("jRadioButton3");
        opt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt3ActionPerformed(evt);
            }
        });

        opt4.setBackground(new java.awt.Color(239, 188, 117));
        opt4.setText("jRadioButton4");
        opt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt4ActionPerformed(evt);
            }
        });

        next.setText("NEXT");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        Submit.setText("SUBMIT");
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });

        jLabel2.setText("1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(next)
                            .addComponent(opt2, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                            .addComponent(opt3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(opt4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(opt1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(question, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Submit)
                .addGap(78, 78, 78))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(question)
                .addGap(18, 18, 18)
                .addComponent(opt1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(opt2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(opt3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(opt4)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(next)
                    .addComponent(Submit))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitActionPerformed
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(null, "Do you really want to Submit","Select",JOptionPane.YES_NO_OPTION);
                if(a==0){
                       submit();
                       StudentSub o2= new StudentSub(s50);
                       this.dispose();
                       o2.setVisible(true);
                       
                       Email o5=new Email(s50,s51,e,marks);
                       o5.method();

                }
    }//GEN-LAST:event_SubmitActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        // TODO add your handling code here:
        
        answerCheck();
        question();
        
    }//GEN-LAST:event_nextActionPerformed

    private void opt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt1ActionPerformed
        // TODO add your handling code here:
        if(opt1.isSelected()){
           opt2.setSelected(false);
           opt3.setSelected(false);
           opt4.setSelected(false);

                }
    }//GEN-LAST:event_opt1ActionPerformed

    private void opt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt2ActionPerformed
        // TODO add your handling code here:
        if(opt2.isSelected()){
           opt1.setSelected(false);
           opt3.setSelected(false);
           opt4.setSelected(false);

                }
    }//GEN-LAST:event_opt2ActionPerformed

    private void opt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt3ActionPerformed
        // TODO add your handling code here:
        if(opt3.isSelected()){
           opt2.setSelected(false);
           opt1.setSelected(false);
           opt4.setSelected(false);

                }
    }//GEN-LAST:event_opt3ActionPerformed

    private void opt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt4ActionPerformed
        // TODO add your handling code here:
        if(opt4.isSelected()){
           opt2.setSelected(false);
           opt3.setSelected(false);
           opt1.setSelected(false);
                }
    }//GEN-LAST:event_opt4ActionPerformed

    /**
     * @param args the command line arguments
     */
      static final String DB_URL ="jdbc:mysql://localhost:3306/quiz";
      static final String DB_URL1 ="jdbc:mysql://localhost:3306/quiz";
	static final String DB_DRV ="com.mysql.jdbc.Driver";
	static final String DB_USER = "root";
	static final String DB_PASSWD = "thV@1995"; 
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
            java.util.logging.Logger.getLogger(QUIZ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QUIZ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QUIZ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QUIZ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QUIZ("hello","hi",0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel GL1;
    private javax.swing.JLabel GL2;
    private javax.swing.JLabel GL3;
    private javax.swing.JLabel GL4;
    private javax.swing.JLabel GL5;
    private javax.swing.JButton Submit;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel j2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jj1;
    private javax.swing.JButton next;
    private javax.swing.JRadioButton opt1;
    private javax.swing.JRadioButton opt2;
    private javax.swing.JRadioButton opt3;
    private javax.swing.JRadioButton opt4;
    private javax.swing.JLabel question;
    // End of variables declaration//GEN-END:variables
}
