package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import impl.copy.studentDaoImpl;
import model.student;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class studentUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField NAME;
	private JTextField CHI;
	private JTextField ENG;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentUI frame = new studentUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public studentUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 255, 255));
		panel.setBounds(0, 10, 610, 55);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("學員管理系統");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel.setBounds(253, 10, 125, 39);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 75, 600, 74);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("姓名:");
		lblNewLabel_1.setBounds(21, 35, 73, 29);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("國文:");
		lblNewLabel_1_1.setBounds(171, 35, 73, 29);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("英文:");
		lblNewLabel_1_2.setBounds(311, 35, 73, 29);
		panel_1.add(lblNewLabel_1_2);
		
		JButton btnNewButton = new JButton("新增");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			String name=NAME.getText();
			int chi=Integer.parseInt(CHI.getText());
			int eng=Integer.parseInt(ENG.getText());
			
			student s=new student(name,chi,eng);
			
			new studentDaoImpl().add(s);
			
			}
		});
		btnNewButton.setBounds(469, 38, 87, 23);
		panel_1.add(btnNewButton);
		
		NAME = new JTextField();
		NAME.setBounds(53, 39, 96, 21);
		panel_1.add(NAME);
		NAME.setColumns(10);
		
		CHI = new JTextField();
		CHI.setBounds(205, 39, 96, 21);
		panel_1.add(CHI);
		CHI.setColumns(10);
		
		ENG = new JTextField();
		ENG.setBounds(346, 39, 96, 21);
		panel_1.add(ENG);
		ENG.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 205, 590, 278);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		
		
		
		JTextArea OUTPUT = new JTextArea();
		OUTPUT.setBounds(10, 63, 558, 205);
		panel_2.add(OUTPUT);
		JButton btnNewButton_1 = new JButton("查詢(string)");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			OUTPUT.setText(new studentDaoImpl().queryAll1());	
				
			}
		});
		btnNewButton_1.setBounds(10, 22, 87, 23);
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("清除");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OUTPUT.setText("");
			}
		});
		btnNewButton_2.setBounds(238, 30, 87, 23);
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("離開");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			
				
			}
		});
		btnNewButton_3.setBounds(480, 22, 87, 23);
		panel_2.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("查詢(list)");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<student> l=new studentDaoImpl().queryAll2();
				String show="";
				int i=0;
				int sum=0;
				
				for(student o:l) 
				{
				    sum=sum+(o.getChi()+o.getEng());
					i++;
					show=show+"id"+o.getId()+"姓名"+o.getName()+
						 "國文:"+o.getChi()+"英文"+o.getEng()+"\n";
				}
				
				show=show+"總分"+sum+"平均:"+(sum/i);
				
				OUTPUT.setText(show);
			}
			
		});
		btnNewButton_4.setBounds(123, 22, 87, 23);
		panel_2.add(btnNewButton_4);
	}
}
