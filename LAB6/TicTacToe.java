import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.util.Timer;
import java.awt.event.*;
import java.util.Random;
public class TicTacToe {
	private JButton bttn_str,bttn_exit;
	private JFrame frame=new JFrame();
	private JPanel panel,panel1,panel2,panel3,panel4;
	int set;
	int count_1,count_2;
	String user1,user2;
	char[][] arr=new char[3][3];
	private ActionListener taskPerformer;
	int value;
	TextField fld;
	public TicTacToe()
	{	
		panel=new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		JLabel lbl=new JLabel("Tic-Tac-Toe");
		bttn_str=new JButton("Start Game");
		bttn_exit=new JButton("Exit");
		bttn_exit.setBackground(Color.BLUE);
		bttn_exit.setOpaque(true);
		bttn_exit.setBorderPainted(false);
		bttn_str.setBackground(Color.BLUE);
		bttn_str.setOpaque(true);
		bttn_str.setBorderPainted(false);
		panel.setLayout(null);
		lbl.setBounds(220,150,300,40);
		lbl.setFont(new Font("Arial",Font.BOLD,30));
		bttn_str.setBounds(230,250,150,40);
		bttn_exit.setBounds(250,350,100,40);
		panel.add(lbl);
		panel.add(bttn_str);
		panel.add(bttn_exit);
		panel.setBackground(new Color(255,255,244));
		bttn_str.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt)
			{
				new Grid();
			}
		});
		bttn_exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt)
			{
				System.exit(0);
			}
		});
		frame.getContentPane().add(panel,BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.setVisible(true);
	}
	public static void main(String[] arg)
	{
		new TicTacToe();
	}
	public class Grid{
		JButton button[][]=new JButton[3][3];
		public Grid()
		{	setnull();
			panel.removeAll();
			panel.updateUI();
			panel.setLayout(new GridLayout(3,3));
			JPanel panel1=new JPanel();
			panel1.setLayout(new BoxLayout(panel1,BoxLayout.PAGE_AXIS));
			panel1.setBackground(new Color(255,255,244));
			JButton user_user=new JButton("User1 vs User2");
			user_user.setBackground(Color.BLUE);
			user_user.setOpaque(true);
			user_user.setBorderPainted(false);
			JButton user_cpu=new JButton("User vs CPU");
			user_cpu.setBackground(Color.BLUE);
			user_cpu.setOpaque(true);
			user_cpu.setBorderPainted(false);
			JButton cpu_AI=new JButton("CPU vs AI Bot");
			cpu_AI.setBackground(Color.BLUE);
			cpu_AI.setOpaque(true);
			cpu_AI.setBorderPainted(false);
			JButton user_AI=new JButton("User vs AI Bot");
			user_AI.setBackground(Color.BLUE);
			user_AI.setOpaque(true);
			user_AI.setBorderPainted(false);
			bttn_exit=new JButton("Exit");
			bttn_exit.setBackground(Color.BLUE);
			bttn_exit.setOpaque(true);
			bttn_exit.setBorderPainted(false);
			panel1.add(Box.createRigidArea(new Dimension(10,0)));
			panel1.add(Box.createRigidArea(new Dimension(0,150)));
			panel1.add(user_user);
			panel1.add(Box.createRigidArea(new Dimension(0,20)));
			panel1.add(user_cpu);
			panel1.add(Box.createRigidArea(new Dimension(0,20)));
			panel1.add(cpu_AI);
			panel1.add(Box.createRigidArea(new Dimension(0,20)));
			panel1.add(user_AI);
			panel1.add(Box.createRigidArea(new Dimension(0,100)));
			panel1.add(bttn_exit);
			panel2=new JPanel();
			panel2.setBackground(new Color(255,255,244));
			fld=new TextField(50);
			fld.setEditable(false);
			panel2.add(Box.createRigidArea(new Dimension(90,0)));
			panel2.add(Box.createRigidArea(new Dimension(0,70)));
			panel2.add(fld);
			panel3=new JPanel();
			panel4=new JPanel();
			panel3.setBackground(new Color(255,255,244));
			panel4.setBackground(new Color(255,255,244));
			panel3.add(Box.createRigidArea(new Dimension(0,30)));
			panel4.add(Box.createRigidArea(new Dimension(50,0)));
			for(int i=0;i<3;i++)
				{
					for(int j=0;j<3;j++)
					{
					button[i][j]=new JButton();
					panel.add(button[i][j]);
					}
			}
			frame.getContentPane().add(panel3,BorderLayout.NORTH);
			frame.getContentPane().add(panel4,BorderLayout.EAST);
			frame.getContentPane().add(panel2,BorderLayout.SOUTH);
			frame.getContentPane().add(panel1,BorderLayout.WEST);
			frame.getContentPane().add(panel,BorderLayout.CENTER);
			user_user.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt)
				{	user_user.setBackground(Color.YELLOW);
					set=1;
					user1=null;
					user2=null;
					setnull();
					count_1=0;
					count_2=0;
					JPanel panel_dialog = new JPanel();
					panel_dialog.setLayout(new FlowLayout());
					JTextField field1 = new JTextField(10);
					panel_dialog.add(new JLabel("User1"));
					panel_dialog.add(field1);
					JTextField field2 = new JTextField(10);
					panel_dialog.add(new JLabel("User2"));
					panel_dialog.add(field2);
					panel_dialog.setPreferredSize(new Dimension(200, 80));
					int check=0;
					while(check!=1)
					{
						int value = JOptionPane.showConfirmDialog(frame, panel_dialog, "Enter usernames of user1 and user2", JOptionPane.OK_CANCEL_OPTION);
						if (value == JOptionPane.OK_OPTION){
					    user1 = field1.getText();
					    user2 = field2.getText();
					    System.out.println(user1);
					    System.out.println(user2);		
					    if(user1.isEmpty())
					    {
					    JOptionPane.showMessageDialog(null, "User1 Empty");
					    }
					    else if(user2.isEmpty())
					  	{
					  		JOptionPane.showMessageDialog(null, "User2 Empty");
					    }
					    else if(user1.isEmpty() && user2.isEmpty())
					    {
					    	JOptionPane.showMessageDialog(null, "User1 and User2 Empty");
					   	}
					    else
					    	check=1;
					    // handle them
						}
					}
					fld.setText(user1+"'s Turn");
					for(int i=0;i<3;i++)
					{for(int j=0;j<3;j++)
						{
							button[i][j].addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent evt)
								{ int x=-1,y=-1;
								JButton check=(JButton)evt.getSource();
								if(check.getText()=="")
								{
									if(evt.getSource()==button[0][0])
									{	

										if(set==1)
										{	fld.setText(user2+"'s Turn");
										button[0][0].setText("X");
										arr[0][0]='X';
										button[0][0].setFont(new Font("Arial", Font.PLAIN, 100));
				//						System.out.println("jjjgjgj");
										set=0;
										count_1++;
									}
									else if(set==0)
									{	fld.setText(user1+"'s Turn");
										button[0][0].setText("O");
										arr[0][0]='O';
										button[0][0].setFont(new Font("Arial", Font.PLAIN, 100));
										set=1;
										count_2++;
									}
								}
								else if(evt.getSource()==button[0][1])
								{	
									if(set==1)
									{	fld.setText(user2+"'s Turn");
										button[0][1].setText("X");
										arr[0][1]='X';
										button[0][1].setFont(new Font("Arial", Font.PLAIN, 100));
										set=0;
										count_1++;
									}
									else if(set==0)
									{	fld.setText(user1+"'s Turn");
										button[0][1].setText("0");
										arr[0][1]='O';
										button[0][1].setFont(new Font("Arial", Font.PLAIN, 100));
										set=1;
										count_2++;
									}
								}
								else if(evt.getSource()==button[0][2])
								{	
									if(set==1)
									{	fld.setText(user2+"'s Turn");
										button[0][2].setText("X");
										arr[0][2]='X';
										button[0][2].setFont(new Font("Arial", Font.PLAIN, 100));
										set=0;
										count_1++;
									}
									else if(set==0)
									{	fld.setText(user1+"'s Turn");
										button[0][2].setText("0");
										arr[0][2]='O';
										button[0][2].setFont(new Font("Arial", Font.PLAIN, 100));
										set=1;
										count_2++;
									}
								}
								else if(evt.getSource()==button[1][0])
								{
									if(set==1)
									{	fld.setText(user2+"'s Turn");
										button[1][0].setText("X");
										arr[1][0]='X';
										button[1][0].setFont(new Font("Arial", Font.PLAIN, 100));
										set=0;
										count_1++;
									}
									else if(set==0)
									{	fld.setText(user1+"'s Turn");
										button[1][0].setText("0");
										arr[1][0]='O';
										button[1][0].setFont(new Font("Arial", Font.PLAIN, 100));
										set=1;
										count_2++;
									}
								}
								else if(evt.getSource()==button[1][1])
								{	
									if(set==1)
									{ fld.setText(user2+"'s Turn");
										button[1][1].setText("X");
										arr[1][1]='X';
										button[1][1].setFont(new Font("Arial", Font.PLAIN, 100));
										set=0;
										count_1++;
									}
									else if(set==0)
									{	fld.setText(user1+"'s Turn");
										button[1][1].setText("0");
										arr[1][1]='O';
										button[1][1].setFont(new Font("Arial", Font.PLAIN, 100));
										set=1;
										count_2++;
									}
								}
								else if(evt.getSource()==button[1][2])
								{	
									if(set==1)
									{	fld.setText(user2+"'s Turn");
										button[1][2].setText("X");
										arr[1][2]='X';
										button[1][2].setFont(new Font("Arial", Font.PLAIN, 100));
										set=0;
										count_1++;
									}
									else if(set==0)
									{	fld.setText(user1+"'s Turn");
										button[1][2].setText("0");
										arr[1][2]='O';
										button[1][2].setFont(new Font("Arial", Font.PLAIN, 100));
										set=1;
										count_2++;
									}
								}
								else if(evt.getSource()==button[2][0])
								{	
									if(set==1)
									{	fld.setText(user2+"'s Turn");
										button[2][0].setText("X");
										arr[2][0]='X';
										button[2][0].setFont(new Font("Arial", Font.PLAIN, 100));
										set=0;
										count_1++;
									}
									else if(set==0)
									{	fld.setText(user1+"'s Turn");
										button[2][0].setText("0");
										arr[2][0]='O';
										button[2][0].setFont(new Font("Arial", Font.PLAIN, 100));
										set=1;
										count_2++;
									}
								}
								else if(evt.getSource()==button[2][1])
								{	
									if(set==1)
									{	fld.setText(user2+"'s Turn");
										button[2][1].setText("X");
										arr[2][1]='X';
										button[2][1].setFont(new Font("Arial", Font.PLAIN, 100));
										set=0;
										count_1++;
									}
									else if(set==0)
									{ fld.setText(user1+"'s Turn");
										button[2][1].setText("0");
										arr[2][1]='O';
										button[2][1].setFont(new Font("Arial", Font.PLAIN, 100));
										set=1;
										count_2++;
									}
								}
								else if(evt.getSource()==button[2][2])
								{	
									if(set==1)
									{	fld.setText(user2+"'s Turn");
										button[2][2].setText("X");
										arr[2][2]='X';
										button[2][2].setFont(new Font("Arial", Font.PLAIN, 100));
										set=0;
										count_1++;
									}
									else if(set==0)
									{	fld.setText(user1+"'s Turn");
										button[2][2].setText("0");
										arr[2][2]='O';
										button[2][2].setFont(new Font("Arial", Font.PLAIN, 100));
										set=1;
										count_2++;
									}
								}
							}
							else
							{
							JOptionPane.showMessageDialog(null, "Invalid position ,click somewher else");
							}	Board brd=new Board();
								int value=brd.checkState(arr);
								System.out.println(value);
								int diff=count_1-count_2;
								System.out.println(count_1);
								System.out.println(count_2);
								System.out.println(diff);
								if(value==1)
									{if(diff==1)
										fld.setText(user1+" (X) Wins");
									else if(diff==0)
										fld.setText(user2+" (O) Wins");
									color_fill_win(diff);
									}
								else if(value==2)
									fld.setText("Tie");
								if(value==1 || value==2)
								{
									{int choice_2 = JOptionPane.showOptionDialog(null, 
					      				"Do you want to  start a new game or quit?", 
					      			"Start new Game",
					     				 JOptionPane.YES_NO_OPTION, 
					      			JOptionPane.QUESTION_MESSAGE, 
					     		 null, null, null);
					  					if(choice_2 == JOptionPane.YES_OPTION)
					 				 {
						 				frame.remove(panel);
										frame.remove(panel1);
										frame.remove(panel2);
										frame.remove(panel3);
										frame.remove(panel4);
									  new Grid();
									  frame.revalidate();
									  fld.setText("");
					  				}
					 				 else if(choice_2 == JOptionPane.NO_OPTION)
					 				 {
					  					  System.exit(0);
					 				 }
								}
							}
						}
					});
					}
				}
			}
			});
			user_cpu.addActionListener( new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					user_cpu.setBackground(Color.YELLOW);
					setnull();
					count_1=0;
					count_2=0;
					JPanel panel_dialog = new JPanel();
					panel_dialog.setLayout(new FlowLayout());
					JTextField field1 = new JTextField(10);
					panel_dialog.add(new JLabel("User"));
					panel_dialog.add(field1);
					panel_dialog.setPreferredSize(new Dimension(200, 40));
					int check=0;
					while(check!=1)
					{
						int value = JOptionPane.showConfirmDialog(frame, panel_dialog, "Enter username", JOptionPane.OK_CANCEL_OPTION);
						if (value == JOptionPane.OK_OPTION)
						{
					    // OK was p
					    user1 = field1.getText();
							System.out.println(user1);
					    	
					    if(user1.isEmpty())
					    	{
					    	JOptionPane.showMessageDialog(null, "User Empty");
					    	
					    	}
					   else
					    	check=1;
					    // handle them
					}
					}
					fld.setText(user1+" Turn");
					for(int i=0;i<3;i++)
					{
						for(int j=0;j<3;j++)
						{
							button[i][j].addActionListener(new ActionListener(){
								
								public void actionPerformed(ActionEvent evt)
									{ 
									int x=-1,y=-1;
									JButton check=(JButton)evt.getSource();
									Board brd=new Board();
									user(evt,check);
									count_1++;
									int value=brd.checkState(arr);
									int index=brd.computer_move(arr);
									if(index!=-1 && value==0)
									{
										
										fld.setText("CPU's Turn");
										cpu(index,'O');
										count_2++;
									}
									fld.setText(user1+"'s Turn");
									value=brd.checkState(arr);
									System.out.println(value);
									int diff=count_1-count_2;
									System.out.println(count_1);
									System.out.println(count_2);
									System.out.println(diff);
									if(value==1)
									{	if(diff==1)
										fld.setText(user1+" (X) Wins");
									else if(diff==0)
										fld.setText("CPU"+" (O) Wins");
									color_fill_win(diff);
									}
									else if(value==2)
										fld.setText("Tie");
									if(value==1 || value==2)
									{
										{int choice_2 = JOptionPane.showOptionDialog(null, 
						      				"Do you want to  start a new game or quit?", 
						      			"Start new Game",
						     				 JOptionPane.YES_NO_OPTION, 
						      			JOptionPane.QUESTION_MESSAGE, 
						     		 null, null, null);
						  
						 				if(choice_2 == JOptionPane.YES_OPTION)
						 				 {
							 			frame.remove(panel);
										frame.remove(panel1);
										frame.remove(panel2);
										frame.remove(panel3);
										frame.remove(panel4);
										  new Grid();
										  frame.revalidate();
										  fld.setText("");
						  				}
						 				 else if(choice_2 == JOptionPane.NO_OPTION)
						 				 {
						  					  System.exit(0);
						 			 }
										}
									}
									}
								});
						}
					}
				}
			});
			cpu_AI.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					cpu_AI.setBackground(Color.YELLOW);
					Board brd=new Board();
					count_1=0;
					count_2=0;
					setnull();
					value=0;
					Timer timer = new Timer();
					TimerTask task = new TimerTask() {
						public void run() {
						int index=brd.computer_move(arr);
						if(index!=-1 && value==0)
						{
							
							fld.setText("CPU's Turn");
						cpu(index,'X');
						count_1++;
							
						}
						
						try{
							 Thread.sleep(1000);
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						
						value=brd.checkState(arr);
						if(value==0)
						{
							fld.setText("AI's Turn");
							brd.ai_move(arr);
							Ai(arr);
							count_2++;
						}
						
						try{
							 Thread.sleep(1000);
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						value=brd.checkState(arr);
						System.out.println(value);
						int diff=count_1-count_2;
						System.out.println(count_1);
						System.out.println(count_2);
						System.out.println(diff);
						if(value==1)
							{timer.cancel();
			                timer.purge();
			                if(diff==1)
								fld.setText("CPU"+" (X) Wins");
							else if(diff==0)
								fld.setText("AI"+" (O) Wins");
									
							color_fill_win(diff);
							}
						else if(value==2)
							{timer.cancel();
			                timer.purge();
			                fld.setText("Tie");
							}
						if(value==1 || value==2)
						{timer.cancel();
		               	 timer.purge();
							{int choice_2 = JOptionPane.showOptionDialog(null, 
			      				"Do you want to  start a new game or quit?", 
			      			"Start new Game",
			     				 JOptionPane.YES_NO_OPTION, 
			      			JOptionPane.QUESTION_MESSAGE, 
			     		 null, null, null);
			  
			 				if(choice_2 == JOptionPane.YES_OPTION)
			 				 {
				 			frame.remove(panel);
							frame.remove(panel1);
							frame.remove(panel2);
						frame.remove(panel3);
						frame.remove(panel4);
							  new Grid();
							  frame.revalidate();
							  fld.setText("");
			  				}
			 				 else if(choice_2 == JOptionPane.NO_OPTION)
			 				 {
			  					  System.exit(0);
			 			 }
							}
						}
						}
					};
					 timer.scheduleAtFixedRate(task, 1000, 1000);
				}
			});
//			
			user_AI.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					count_1=0;
					count_2=0;
					user_AI.setBackground(Color.YELLOW);
					setnull();
				Board brd=new Board();
					JPanel panel_dialog = new JPanel();
					panel_dialog.setLayout(new FlowLayout());
					JTextField field1 = new JTextField(10);
					panel_dialog.add(new JLabel("User"));
					panel_dialog.add(field1);
					panel_dialog.setPreferredSize(new Dimension(200, 40));
					int check=0;
					while(check!=1)
					{
						int value = JOptionPane.showConfirmDialog(frame, panel_dialog, "Enter username", JOptionPane.OK_CANCEL_OPTION);
					
					
					if (value == JOptionPane.OK_OPTION)
					{
					    // OK was p
					    user1 = field1.getText();
			
					    System.out.println(user1);
					    	
					    if(user1.isEmpty())
					    	{
					    	JOptionPane.showMessageDialog(null, "User Empty");
					    	
					    	}
					   
					    else
					    	check=1;
					    // handle them
					}
					}
					fld.setText(user1+"'s Turn");
					System.out.println(user1);
					for(int i=0;i<3;i++)
					{
						for(int j=0;j<3;j++)
						{
							button[i][j].addActionListener(new ActionListener(){
								
								public void actionPerformed(ActionEvent evt)
									{ 
									int x=-1,y=-1;
									JButton check=(JButton)evt.getSource();
									user(evt,check);
									count_1++;
								int value=brd.checkState(arr);
								int index=brd.computer_move(arr);
								if(index!=-1 && value==0)
								{
//									fld.setText("AI"+" Turn");
									fld.setText("AI's Turn");
									System.out.println("AI");
									brd.ai_move(arr);
									Ai(arr);
									count_2++;
								}
								fld.setText(user1+"'s Turn");
								System.out.println(user1);
								value=brd.checkState(arr);
								System.out.println(value);
								int diff=count_1-count_2;
								if(value==1)
									{
										if(diff==1)
											fld.setText(user1+" (X) Wins");
									else if(diff==0)
										fld.setText("AI"+" (O) Wins");
									color_fill_win(diff);
								}
								else if(value==2)
									fld.setText("Tie");
								if(value==1 || value==2)
								{
									{int choice_2 = JOptionPane.showOptionDialog(null, 
					      				"Do you want to  start a new game or quit?", 
					      			"Start new Game",
					     				 JOptionPane.YES_NO_OPTION, 
					      			JOptionPane.QUESTION_MESSAGE, 
					     		 null, null, null);
					  
					 				if(choice_2 == JOptionPane.YES_OPTION)
					 				 {
						 			frame.remove(panel);
									frame.remove(panel1);
									frame.remove(panel2);
								frame.remove(panel3);
								frame.remove(panel4);
									  new Grid();
									  frame.revalidate();
									  fld.setText("");
					  				}
					 				 else if(choice_2 == JOptionPane.NO_OPTION)
					 				 {
					  					  System.exit(0);
					 			 }
									}
								}
					}
						});
							}
						}
					}
				});
			bttn_exit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt)
				{
					System.exit(0);
				}
			});
		}
			void color_fill_win(int diff)
		{
				int color=0;
				for(int i=0;i<3&&color!=1;i++)
				{	if(button[i][0].getText()==button[i][1].getText() && button[i][1].getText()==button[i][2].getText())
					{
						button[i][0].setForeground(Color.RED);
						button[i][1].setForeground(Color.RED);
						button[i][2].setForeground(Color.RED);
						color=1;
					}
				}
				for(int i=0;i<3&&color!=1;i++)
				{	if(button[0][i].getText()==button[1][i].getText() && button[1][i].getText()==button[2][i].getText())
					{
						button[0][i].setForeground(Color.RED);
						button[1][i].setForeground(Color.RED);
						button[2][i].setForeground(Color.RED);
						color=1;
					}
				}
				if(color!=1)
				{
					if(button[0][0].getText()==button[1][1].getText() && button[1][1].getText()==button[2][2].getText())
					{
						button[0][0].setForeground(Color.RED);
						button[1][1].setForeground(Color.RED);
						button[2][2].setForeground(Color.RED);
						color=1;
					}
					
				}
				if(color!=1)
				{
					if(button[0][2].getText()==button[1][1].getText() && button[1][1].getText()==button[2][0].getText())
					{
						button[0][2].setForeground(Color.RED);
						button[1][1].setForeground(Color.RED);
						button[2][0].setForeground(Color.RED);
						color=1;
					}
					
				}
		}
		void user(ActionEvent evt,JButton check)
		{
		if(check.getText()=="")
			{
				if(evt.getSource()==button[0][0])
				{
				button[0][0].setText("X");
				arr[0][0]='X';
				button[0][0].setFont(new Font("Arial", Font.PLAIN, 100));
				}
				else if(evt.getSource()==button[0][1])
				{
				button[0][1].setText("X");
				arr[0][1]='X';
				button[0][1].setFont(new Font("Arial", Font.PLAIN, 100));
				}
				else if(evt.getSource()==button[0][2])
				{
				button[0][2].setText("X");
				arr[0][2]='X';
				button[0][2].setFont(new Font("Arial", Font.PLAIN, 100));
				}
				else if(evt.getSource()==button[1][0])
				{
				button[1][0].setText("X");
				arr[1][0]='X';
				button[1][0].setFont(new Font("Arial", Font.PLAIN, 100));
				}
				else if(evt.getSource()==button[1][1])
				{
				button[1][1].setText("X");
				arr[1][1]='X';
				button[1][1].setFont(new Font("Arial", Font.PLAIN, 100));
				}
				else if(evt.getSource()==button[1][2])
				{
				button[1][2].setText("X");
				arr[1][2]='X';
				button[1][2].setFont(new Font("Arial", Font.PLAIN, 100));
				}
				else if(evt.getSource()==button[2][0])
				{
				button[2][0].setText("X");
				arr[2][0]='X';
				button[2][0].setFont(new Font("Arial", Font.PLAIN, 100));
				}
				else if(evt.getSource()==button[2][1])
				{
				button[2][1].setText("X");
				arr[2][1]='X';
				button[2][1].setFont(new Font("Arial", Font.PLAIN, 100));
				}
				else if(evt.getSource()==button[2][2])
				{
				button[2][2].setText("X");
				arr[2][2]='X';
				button[2][2].setFont(new Font("Arial", Font.PLAIN, 100));
					}
			}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid position ,click somewher else");
				}
		}
		void cpu(int index,char x)
		{	
			int count=0;
			for(int i=0;i<3;i++)
			{
				for(int j=0;j<3;j++)
				{	
					if(arr[i][j]=='-')
					{
						if(count==index)
						{	
						// System.out.println("i:"+i+"j:"+j);
							arr[i][j]=x;
							button[i][j].setText(Character.toString(x));
							button[i][j].setFont(new Font("Arial", Font.PLAIN, 100));
							
							count++;
							break;
						}
						count++;
					}
				}
			}
		}
		void setnull()
		{
			for(int i=0;i<3;i++)
			{
			for(int j=0;j<3;j++)
			{
				arr[i][j]='-';
			}
			}
		}
		void Ai(char arr[][])
		{
			for(int i=0;i<3;i++)
			{
				for(int j=0;j<3;j++)
				{
					if(arr[i][j]=='O')
					{
						button[i][j].setText("O");
						button[i][j].setFont(new Font("Arial", Font.PLAIN, 100));
						
					}
				}
			}
		}
		
	}
}

