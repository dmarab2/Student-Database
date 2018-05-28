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
import javax.swing.JTextField;


public class AddStudent extends JFrame implements ActionListener{
	
	private JLabel jlID = new JLabel("ID: ");
	private JLabel jlName = new JLabel("Name: ");
	private JLabel jlAge = new JLabel("Age: ");
	private JLabel jlGender = new JLabel("Gender: ");
	private JLabel jlYear = new JLabel("Start Year: ");
	private JLabel jlDepartment = new JLabel("Department: ");
	private JLabel jlProgram = new JLabel("Program: ");
	
	private JTextField jtfID = new JTextField(4);
	private JTextField jtfName = new JTextField(15);
	private JTextField jtfAge = new JTextField(3);
	private JTextField jtfGender = new JTextField(7);
	private JTextField jtfYear = new JTextField(4);
	private JTextField jtfDepartment = new JTextField(15);
	private JTextField jtfProgram = new JTextField(15);
	
	private JPanel jpTextFields;
	private JPanel jpButtons;
	
	private JButton jbAdd;
	private JButton jbCancel;
	
	private void initButtons(){
		jbAdd = new JButton("Add");
		jbCancel = new JButton("Cancel");
		this.jbAdd.addActionListener(this); 
		this.jbCancel.addActionListener(this);
		
	}
	
	private void initPanels() {
		jpTextFields = new JPanel();
		jpButtons = new JPanel();
		
		jpTextFields.add(jlID); jpTextFields.add(jtfID);
		jpTextFields.add(jlName); jpTextFields.add(jtfName);
		jpTextFields.add(jlAge); jpTextFields.add(jtfAge);
		jpTextFields.add(jlGender); jpTextFields.add(jtfGender);
		jpTextFields.add(jlYear); jpTextFields.add(jtfYear);
		jpTextFields.add(jlDepartment); jpTextFields.add(jtfDepartment);
		jpTextFields.add(jlProgram); jpTextFields.add(jtfProgram);
		
		jpButtons.add(jbAdd); 
		jpButtons.add(jbCancel);
	}
	
	public void init(){
		this.setLayout(new GridLayout(3, 1));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Add Student");
		this.setSize(1200, 1000);
		
		this.initButtons();
		this.initPanels();
		this.add(this.jpTextFields);
		this.add(this.jpButtons);


		this.setVisible(true);
	}
	
	AddStudent(){
		this.init();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Cancel"){
			this.dispose();
		}
		
		else if(e.getSource() == jbAdd){
			Student s = new Student();
			s.name = this.jtfName.getText();
			s.age = Integer.parseInt(this.jtfAge.getText());
			s.ID = Long.parseLong(this.jtfID.getText());
			s.gender = this.jtfGender.getText();
			s.startYear = Long.parseLong(this.jtfYear.getText());
			s.department = this.jtfDepartment.getText();
			s.Program = this.jtfProgram.getText();
			Main.studentList.add(s);
		}
	}
}
