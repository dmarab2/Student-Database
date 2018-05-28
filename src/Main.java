/* Group 13
 * Ritika Upadhyay (UIN: 658759398; NetID: rupadh5)
 * Derrick Marable (UIN: 652692903; NetID: dmarab2)
 * Anurag Banerjee (UIN: 677398706; NetID: abaner22)
 */


//figure out layout for panelUp!!
//figure out action for display ---> define action in case of event

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Main extends JFrame implements ActionListener{
	public static ArrayList<Student> studentList = new ArrayList<Student>();

	/*	o Has a component for showing student info and three buttons: Add, Look Up, and Display.
		o It also has a Text Field which receives a search phrase from the user (it can be any part of student’s name).
		o When the user clicks the Look Up button the Edit Student Info window pops up with the info of the first student whose name contains the
			search phrase. The user can then edit the information (as explained below).
		o The user can view the name, age, start year, and program of all students by clicking on Display button.
		o If they click on Add button the Add Student window pops up. 
		
	
	*/
	//Dividing my window into two panels
	private JPanel mainPanelUp;
	private JPanel mainPanelDown;
	
	//Buttons
	private JButton addButton;     //mainPanelDown
	private JButton displayButton; //mainPanelDown
	private JButton lookUpButton;  //mainPanelDown
	
	//Text Field
	private JTextField searchTextField; //mainPanelUp
	
	//Labels
	private JLabel jlabName; 
	private JLabel jlabAge;
	private JLabel jlabID;
	private JLabel jlabgender;
	private JLabel jlabstartYear;
	private JLabel jlabdepartment;
	private JLabel jlabProgram;
	
	//Text Area
	private JTextArea jtaOutput;
	
	//Scroll Pane
	private JScrollPane jspScroll;
	
	//Fn to initialize panels
	void initPanel() {
		mainPanelUp = new JPanel();
		mainPanelDown = new JPanel();
		
		mainPanelUp.setLayout(new GridLayout(4, 2, 4, 4));
		
		mainPanelDown.setLayout(new GridLayout(1, 3, 10, 10));
		/*
		mainPanelUp.add(jlabName);
		mainPanelUp.add(jlabAge);
		mainPanelUp.add(jlabID);
		mainPanelUp.add(jlabgender);
		mainPanelUp.add(jlabstartYear);
		mainPanelUp.add(jlabdepartment);
		mainPanelUp.add(jlabProgram);
		*/
		mainPanelUp.add(jspScroll);
		mainPanelUp.add(searchTextField);
		
		mainPanelDown.add(addButton);
		mainPanelDown.add(displayButton);
		mainPanelDown.add(lookUpButton);
	}
	
	//Fn to initialize labels
	void initLabels() {//Remember to check they are added to some container
		
		jlabName = new JLabel("Name: "); 
		jlabAge = new JLabel("Age: "); 
		jlabID = new JLabel("Student ID: "); 
		jlabgender = new JLabel("Gender: "); 
		jlabstartYear = new JLabel("Start Year: "); 
		jlabdepartment = new JLabel("Department: ");
		jlabProgram = new JLabel("Program: ");
	}
	
	//Fn to initialize text fields
	void initTextField() {
		searchTextField = new JTextField(10);
		searchTextField.setEditable(true);
		searchTextField.setText("Search Student Name Here");
		
		searchTextField.addActionListener(this);
	}
	
	//Fn to initialize buttons
	void initButton() {
		
		this.addButton = new JButton("Add Student");
		this.displayButton = new JButton("Display All Student Information");
		this.lookUpButton = new JButton("Look Up Information");
		
		addButton.addActionListener(this);
		displayButton.addActionListener(this);
		lookUpButton.addActionListener(this);
	}
	
	public void initTextAreas(){
		jtaOutput = new JTextArea("Student List: \n");
		jspScroll = new JScrollPane(jtaOutput);
		jspScroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
	}
	
	public static void main(String[] args) {
		
		new Main();
	} 
	
	
	//Fn putting everything together
	void init () {
		
		//setting window-level parameters
		this.setLayout(new GridLayout(4, 4));
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//What happens when you click on the cross
		this.setTitle("Main Window :: Student Registry Application");
		this.setSize(4000,3000);
		
		//initialize components
		initTextAreas();
		initButton();
		//initLabels();
		initTextField();
		initPanel();
		this.add(mainPanelUp);
		this.add(mainPanelDown);
		//set everything initialized here to true
		this.setVisible(true);
		
	}
	
	public Main() {
		//test student to make sure that display works
		init();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

if(e.getSource()==lookUpButton) {
	String name = new String(searchTextField.getText());
	for(int i = 0; i < studentList.size(); i++) {
		Student ns = studentList.get(i);
		if(ns.name.toLowerCase().equals(name.toLowerCase())){
			//add edit student window declaration here, replace the next line
			new EditStudent(ns, i);
			break;
		}
		
	}
}

else
	if(e.getSource()==addButton)
		//Add window pops up
	{
		new AddStudent();
	}

	else 
		if(e.getSource()==displayButton){
			this.jtaOutput.setText("");
			for(int i = 0; i < studentList.size(); i++) {
				Student ts = studentList.get(i);
				jtaOutput.append("Student " + (i + 1) + "\nName: " + ts.name + "\nAge: " + ts.age + "\nID: " + ts.ID + "\nGender: " + ts.gender + "\nStart Year: " + ts.startYear + "\nDepartment: " + ts.department + "\nProgram: " + ts.Program + "\n\n");
			}
		}
	}

}

