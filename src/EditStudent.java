/* Group 13
 * Ritika Upadhyay (UIN: 658759398; NetID: rupadh5)
 * Derrick Marable (UIN: 652692903; NetID: dmarab2)
 * Anurag Banerjee (UIN: 677398706; NetID: abaner22)
 */


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class EditStudent extends JFrame implements ActionListener{ 
	
	private int index = 0;
	private JLabel jlID = new JLabel("ID: ");
	private JLabel jlName = new JLabel("Name: ");
	private JLabel jlAge = new JLabel("Age: ");
	private JLabel jlGender = new JLabel("Gender: ");
	private JLabel jlYear = new JLabel("Start Year: ");
	private JLabel jlDepartment = new JLabel("Department: ");
	private JLabel jlProgram = new JLabel("Program: ");
	
	private JTextArea jtaID;
	private JTextArea jtaName;
	private JTextArea jtaAge;
	private JTextArea jtaGender;
	private JTextArea jtaYear;
	private JTextArea jtaDepartment;
	private JTextArea jtaProgram;
	
	private JButton jbEdit;
	private JButton jbCancel;
	
	private JPanel jpText;
	private JPanel jpButton;
	
	private void initButtons(){
		jbEdit = new JButton("Edit");
		jbCancel = new JButton("Cancel");
		this.jbEdit.addActionListener(this); 
		this.jbCancel.addActionListener(this);
		
	}
	
	public void initTextAreas(Student s){
		jtaID = new JTextArea(Long.toString(s.ID), 5, 5);
		jtaName = new JTextArea(s.name, 5 , 5);
		jtaAge = new JTextArea(Integer.toString(s.age), 5, 5);
		jtaGender = new JTextArea(s.gender, 5 ,5);
		jtaYear = new JTextArea(Long.toString(s.startYear), 5, 5);
		jtaDepartment = new JTextArea(s.department, 5, 5);
		jtaProgram = new JTextArea(s.Program, 5, 5);
		
	}
	
	private void initPanels() {
		jpText = new JPanel();
		jpButton = new JPanel();
		
		jpText.add(jlID); jpText.add(jtaID);
		jpText.add(jlName); jpText.add(jtaName);
		jpText.add(jlAge); jpText.add(jtaAge);
		jpText.add(jlGender); jpText.add(jtaGender);
		jpText.add(jlYear); jpText.add(jtaYear);
		jpText.add(jlDepartment); jpText.add(jtaDepartment);
		jpText.add(jlProgram); jpText.add(jtaProgram);
		
		jpButton.add(jbEdit); 
		jpButton.add(jbCancel);
	}
	
	public void init(Student s){
		this.setLayout(new GridLayout(3, 1));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Edit Student");
		this.setSize(1200, 1000);
		
		this.initButtons();
		this.initTextAreas(s);
		this.initPanels();
		this.add(this.jpText);
		this.add(this.jpButton);


		this.setVisible(true);
	}
	
	EditStudent(Student s, int i){
		this.index = i;
		this.init(s);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Cancel"){
			this.dispose();
		}
		
		else if(e.getSource() == jbEdit){
			Main.studentList.get(index).ID = Long.parseLong(jtaID.getText());
			Main.studentList.get(index).name = jtaName.getText();
			Main.studentList.get(index).age = Integer.parseInt(jtaAge.getText());
			Main.studentList.get(index).gender = jtaGender.getText();
			Main.studentList.get(index).startYear = Long.parseLong(jtaYear.getText());
			Main.studentList.get(index).department = jtaDepartment.getText();
			Main.studentList.get(index).Program = jtaProgram.getText();
		}
		
		
	}
}
