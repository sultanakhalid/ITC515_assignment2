package datamanagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class Addut {
	private cgCTL ctl;
	private JFrame frmAddUnit;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addut window = new Addut();
					window.frmAddUnit.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Addut() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddUnit = new JFrame();
		frmAddUnit.setResizable(false);
		frmAddUnit.setTitle("Add Unit");
		frmAddUnit.setBounds(100, 100, 510, 304);
		frmAddUnit.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(83, 103, 388, 33);
		frmAddUnit.getContentPane().add(panel);
		
		JLabel lblAssignmentWght = new JLabel("assign1 wght");
		panel.add(lblAssignmentWght);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(3);
		
		JLabel lblAssignmentWght_1 = new JLabel("assign2 wght");
		panel.add(lblAssignmentWght_1);
		
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(3);
		
		JLabel lblAssignmentWght_2 = new JLabel("Exam wght  ");
		panel.add(lblAssignmentWght_2);
		
		textField_2 = new JTextField();
		panel.add(textField_2);
		textField_2.setColumns(3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_3.setBounds(83, 191, 388, 33);
		frmAddUnit.getContentPane().add(panel_3);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uid=textField_4.getText();
				String u_Name=textField_3.getText();
				//String sid=textField_2.getText();
				String asg_1=textField.getText();
				String asg_2=textField_1.getText();
				String exam=textField_2.getText();
			    String hD=textField_9.getText();
				String aE=textField_5.getText();
				String pS=textField_6.getText();
				String cR=textField_7.getText();
				String dI=textField_8.getText();
				
					try{
				        File fXmlFile = new File("../assign/DataManagementDemo_DB.xml");
				        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				        DocumentBuilder dbf = dbFactory.newDocumentBuilder();
				        Document doc = dbf.parse(fXmlFile);
				        Element d_Tag = doc.getDocumentElement();
				        Element p_Tag =  (Element) d_Tag.getElementsByTagName("unitTable").item(0);

				        Element new_Unit = doc.createElement("unit");

				        new_Unit.setAttribute("uid",uid);    
				        new_Unit.setAttribute("name",u_Name);    
				        new_Unit.setAttribute("asg1wgt",asg_1);    
				        new_Unit.setAttribute("asg2wgt",asg_2);    
				        new_Unit.setAttribute("examwgt",exam);    
				        new_Unit.setAttribute("ae",aE);    
				        new_Unit.setAttribute("ps",pS);    
				        new_Unit.setAttribute("cr",cR);    
				        new_Unit.setAttribute("di",dI);    
				        new_Unit.setAttribute("hd",hD);    
				        //new_Stu.setAttribute("examwgt",exam);    

				        p_Tag.appendChild(new_Unit);
				        TransformerFactory trans_Former = TransformerFactory.newInstance();
				            Transformer trans = trans_Former.newTransformer();
				            DOMSource source = new DOMSource(doc);

				            StreamResult result = new StreamResult("../assign/DataManagementDemo_DB.xml");
				            trans.transform(source, result);
				        } catch (Exception em) {
				            em.printStackTrace();
				        }
			uio();
			}
		});
		panel_3.add(btnNewButton);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel_3.add(tabbedPane);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(83, 59, 388, 33);
		frmAddUnit.getContentPane().add(panel_4);
		
		JLabel lblEnterSubjectName = new JLabel("Enter Subject Name");
		panel_4.add(lblEnterSubjectName);
		
		textField_3 = new JTextField();
		textField_3.setColumns(8);
		panel_4.add(textField_3);
		
		JLabel lblSubjectCode = new JLabel("Subject Code");
		panel_4.add(lblSubjectCode);
		
		textField_4 = new JTextField();
		panel_4.add(textField_4);
		textField_4.setColumns(6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(83, 147, 388, 33);
		frmAddUnit.getContentPane().add(panel_1);
		
		JLabel lblAddiExam = new JLabel("A.E");
		panel_1.add(lblAddiExam);
		
		textField_5 = new JTextField();
		textField_5.setColumns(3);
		panel_1.add(textField_5);
		
		JLabel lblPassMarks = new JLabel("P.S");
		panel_1.add(lblPassMarks);
		
		textField_6 = new JTextField();
		textField_6.setColumns(3);
		panel_1.add(textField_6);
		
		JLabel lblCr = new JLabel("CR");
		panel_1.add(lblCr);
		
		textField_7 = new JTextField();
		textField_7.setColumns(3);
		panel_1.add(textField_7);
		
		JLabel lblDi = new JLabel("DI");
		panel_1.add(lblDi);
		
		textField_8 = new JTextField();
		textField_8.setColumns(3);
		panel_1.add(textField_8);
		
		JLabel lblHd = new JLabel("HD");
		panel_1.add(lblHd);
		
		textField_9 = new JTextField();
		textField_9.setColumns(3);
		panel_1.add(textField_9);
		
		JLabel lblNewLabel = new JLabel("ADD UNIT ");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(223, 21, 117, 27);
		frmAddUnit.getContentPane().add(lblNewLabel);
	}
	public void uio(){
		String uid=textField_4.getText();
		String u_Name=textField_3.getText();
		//String sid=textField_2.getText();
		String asg_1=textField.getText();
		String asg_2=textField_1.getText();
		String exam=textField_2.getText();
	    String hD=textField_9.getText();
		String aE=textField_5.getText();
		String pS=textField_6.getText();
		String cR=textField_7.getText();
		String dI=textField_8.getText();
		try{
	        File fXmlFile = new File("../assign/DataManagementDemo_DB.xml");
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dbf = dbFactory.newDocumentBuilder();
	        Document doc = dbf.parse(fXmlFile);
	        Element d_Tag = doc.getDocumentElement();
	        Element p_Tag =  (Element) d_Tag.getElementsByTagName("studentUnitRecordTable").item(0);

	        Element new_Unit = doc.createElement("record");

	      //  String uid = null,asg_1 = null,asg_2 = null,exam = null;
			new_Unit.setAttribute("uid",uid);    
	       // new_Unit.setAttribute("name",u_Name);    
	        new_Unit.setAttribute("asg1",asg_1);    
	        new_Unit.setAttribute("asg2",asg_2);    
	        new_Unit.setAttribute("exam",exam);    
	       // new_Unit.setAttribute("ae",aE);    
	        //new_Unit.setAttribute("ps",pS);    
	        //new_Unit.setAttribute("cr",cR);    
	        //new_Unit.setAttribute("di",dI);    
	        //new_Unit.setAttribute("hd",hD);    
	        //new_Stu.setAttribute("examwgt",exam);    

	        p_Tag.appendChild(new_Unit);
	        TransformerFactory trans_Former = TransformerFactory.newInstance();
	            Transformer trans = trans_Former.newTransformer();
	            DOMSource source = new DOMSource(doc);

	            StreamResult result = new StreamResult("../assign/DataManagementDemo_DB.xml");
	            trans.transform(source, result);
	        } catch (Exception em) {
	            em.printStackTrace();
	        }
		
	}
}
