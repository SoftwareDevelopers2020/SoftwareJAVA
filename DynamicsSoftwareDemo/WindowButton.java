import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class WindowButton extends JFrame{
	JFrame f,f1,f2;
	JLabel l1, l2,l3,l4;
	JTextField t1;
	JButton b1, b2;
	JPasswordField p1;
	
	JLabel s1,s2,s3,s4,s5,s6;
	JTextField st1,st2,st3,st4,st5,st6;
	JButton b3;
	
	JLabel lt1,lt2,lt3;
	JTextField t2;
	JPasswordField pt1,pt2;
	JButton b4;
	
	
	Connection con = null;
	Statement st = null;
	ResultSet res = null; 
	
	String name,branch,usn,contact,git,linkedin;
	String sql;
	String user,pass;
	
	public WindowButton() {
		f = new JFrame("Dynamics");
        f.setLayout(null);
        f.setSize(500,400);
        f.getContentPane().setBackground(Color.PINK);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        l1 = new JLabel("Username: ");
        l1.setFont(new Font("New Times Roman", Font.BOLD, 14));
        l1.setForeground(Color.black);
        l1.setBounds(20,30,100,30);
        t1 = new JTextField();
        t1.setBounds(150,30,200,30);
        
        l2 = new JLabel("Password: ");
        l2.setFont(new Font("New Times Roman", Font.BOLD, 14));
        l2.setForeground(Color.black);
        l2.setBounds(20,60,100,30);
        p1 = new JPasswordField();
        p1.setBounds(150,60,200,30);
        
        l3 = new JLabel("Already an User-->");
        l3.setFont(new Font("New Times Roman", Font.BOLD, 12));
        l3.setForeground(Color.black);
        l3.setBounds(50,120,150,30);
        
        b1 = new JButton("Login");
        b1.setBounds(200,120,80,30);
        
        l4 = new JLabel("Or");
        l4.setFont(new Font("New Times Roman", Font.BOLD, 14));
        l4.setForeground(Color.black);
        l4.setBounds(230,180,30,30);
        
        b2 = new JButton("Sign Up");
        b2.setBounds(190,240,100,30);
        
        
        f.add(l1);
        f.add(t1);
        f.add(l2);
        f.add(p1);
        f.add(b1);
        f.add(l3);
        f.add(l4);
        f.add(b2);
        f.setVisible(true);
        
        try {
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
        	con = DriverManager.getConnection("jdbc:mysql://192.168.43.1:3306/Demo?useSSL=false", "root", "Ubuntu.1");
            st = con.createStatement();
            b1.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		try {
            			boolean flag = false;
            			user = t1.getText();
            			pass = new String(p1.getPassword());
            			res = st.executeQuery("select * from login");
            			while(res.next()) {
            				if(user.compareTo(res.getString(1)) == 0 && pass.compareTo(res.getString(2)) == 0) {
            					flag = true;
            					break;
            				}
            			}
            			if(flag == true)
            				JOptionPane.showMessageDialog(null,"Login Successfull");
            			else
            				JOptionPane.showMessageDialog(null,"User name doesn't exists or username or password is invalid!");
            			
            		}
            		catch(Exception exp) {
            			
            		}
            	}
            });
        }
        catch(Exception e2){
        	
        }
        
        b2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        			f1 = new JFrame("Registration");
        			f1.setLayout(null);
        	        f1.setSize(600,400);
        	        f1.getContentPane().setBackground(Color.yellow);
        	        
        	        s1 = new JLabel("Name");
        	        s1.setFont(new Font("New Times Roman", Font.BOLD, 14));
        	        s1.setForeground(Color.black);
        	        s1.setBounds(20,30,120,30);
        	        st1 = new JTextField();
        	        st1.setBounds(200,30,200,30);
        	        
        	        s2 = new JLabel("Branch");
        	        s2.setFont(new Font("New Times Roman", Font.BOLD, 14));
        	        s2.setForeground(Color.black);
        	        s2.setBounds(20,60,120,30);
        	        st2 = new JTextField();
        	        st2.setBounds(200,60,200,30);
        	        
        	        s3 = new JLabel("USN");
        	        s3.setFont(new Font("New Times Roman", Font.BOLD, 14));
        	        s3.setForeground(Color.black);
        	        s3.setBounds(20,90,120,30);
        	        st3 = new JTextField();
        	        st3.setBounds(200,90,200,30);
        	        
        	        s4 = new JLabel("Contact");
        	        s4.setFont(new Font("New Times Roman", Font.BOLD, 14));
        	        s4.setForeground(Color.black);
        	        s4.setBounds(20,120,120,30);
        	        st4 = new JTextField();
        	        st4.setBounds(200,120,200,30);
        	        
        	        s5 = new JLabel("Github Link");
        	        s5.setFont(new Font("New Times Roman", Font.BOLD, 14));
        	        s5.setForeground(Color.black);
        	        s5.setBounds(20,150,120,30);
        	        st5 = new JTextField();
        	        st5.setBounds(200,150,200,30);
        	        
        	        s6 = new JLabel("LinkedIn Link");
        	        s6.setFont(new Font("New Times Roman", Font.BOLD, 14));
        	        s6.setForeground(Color.black);
        	        s6.setBounds(20,180,120,30);
        	        st6 = new JTextField();
        	        st6.setBounds(200,180,200,30);
        	        
        	        b3 = new JButton("Register");
        	        b3.setBounds(210,240,120,30);
        	        
        	        try {
        	        	Class.forName("com.mysql.jdbc.Driver").newInstance();
        	        	con = DriverManager.getConnection("jdbc:mysql://192.168.43.1:3306/Demo?useSSL=false", "root", "Ubuntu.1");
        	            st = con.createStatement();
        	            b3.addActionListener(new ActionListener() {
            	        	public void actionPerformed(ActionEvent e) {
            	        		try {
            	        			name = st1.getText();
            	        			branch = st2.getText();
            	        			usn = st3.getText();
            	        			contact = st4.getText();
            	        			git = st5.getText();
            	        			linkedin = st6.getText();
            	        			sql = "INSERT INTO Register (Name, Branch, USN, Contact, GithubLink, LinkedInLink) VALUES ("+"\""+name+"\""+","+"\""+branch+"\""+","+"\""+usn+"\""+","+"\""+contact+"\""+","+"\""+git+"\""+","+"\""+linkedin+"\""+");"; 
                                	st.executeUpdate(sql);
                                	JOptionPane.showMessageDialog(null,"Registered");
                                	
                                	
                                	f2 = new JFrame("Sign Up");
                                	f2.setLayout(null);
                                    f2.setSize(500,400);
                                    f2.getContentPane().setBackground(Color.orange);
                                    f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                    
                                    lt1 = new JLabel("Username: ");
                                    lt1.setFont(new Font("New Times Roman", Font.BOLD, 14));
                                    lt1.setForeground(Color.black);
                                    lt1.setBounds(20,30,100,30);
                                    t2 = new JTextField();
                                    t2.setBounds(150,30,200,30);
                                    
                                    lt2 = new JLabel("Password: ");
                                    lt2.setFont(new Font("New Times Roman", Font.BOLD, 14));
                                    lt2.setForeground(Color.black);
                                    lt2.setBounds(20,60,100,30);
                                    pt1 = new JPasswordField();
                                    pt1.setBounds(150,60,200,30);
                                    
                                    lt3 = new JLabel("Confirm Password: ");
                                    lt3.setFont(new Font("New Times Roman", Font.BOLD, 14));
                                    lt3.setForeground(Color.black);
                                    lt3.setBounds(20,90,100,30);
                                    pt2 = new JPasswordField();
                                    pt2.setBounds(150,90,200,30);
                                    
                                    b4 = new JButton("Sign Up");
                                    b4.setBounds(200,150,90,30);
                                    
                                    f2.add(lt1);
                                    f2.add(lt2);
                                    f2.add(lt3);
                                    f2.add(t2);
                                    f2.add(pt1);
                                    f2.add(pt2);
                                    f2.add(b4);
                                    f2.setVisible(true);
                                    
                                    try {
                                    	Class.forName("com.mysql.jdbc.Driver").newInstance();
                                    	con = DriverManager.getConnection("jdbc:mysql://192.168.43.1:3306/Demo?useSSL=false", "root", "Ubuntu.1");
                        	            st = con.createStatement();
                        	            b4.addActionListener(new ActionListener() {
                        	            	public void actionPerformed(ActionEvent e) {
                        	            		try {
                        	            			user = t2.getText();
                        	            			pass = new String(pt1.getPassword());
                        	            			sql = "INSERT INTO login (Username, Password) VALUES ("+"\""+user+"\""+","+"\""+pass+"\""+");";
                        	            			st.executeUpdate(sql);
                        	            			JOptionPane.showMessageDialog(null,"Signed Up");
                        	            			f2.dispose();
                        	            		}
                        	            		catch(Exception exp1) {
                        	            			JOptionPane.showMessageDialog(null,exp1.getMessage());
                        	            		}
                    	            		}
                        	            });
                                    }
                                    catch(Exception e4) {
                                    	
                                    }
                                    f1.dispose();
            	        		}
            	        		catch(Exception e2) {
            	        			JOptionPane.showMessageDialog(null,e2.getMessage());
            	        		}
            	        	}
            	        });
        	            
        	            
        	        }
        	        catch(Exception exp) {
        	        	
        	        }
        	        
        	        f1.setVisible(true);
        	        f1.add(s1);
        	        f1.add(s2);
        	        f1.add(s3);
        	        f1.add(s4);
        	        f1.add(s5);
        	        f1.add(s6);
        	        f1.add(b3);
        	        f1.add(st1);
        	        f1.add(st2);
        	        f1.add(st3);
        	        f1.add(st4);
        	        f1.add(st5);
        	        f1.add(st6);
        			
        		}
        		catch(Exception e1) {
        			
        		}
        	}
        });
        
        
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new WindowButton();
            }
        });

	}

}
