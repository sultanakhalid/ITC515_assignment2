package datamanagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

import javax.swing.border.LineBorder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class AddStu {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStu window = new AddStu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void addStud(){
		
		String sid=textField_2.getText();
		String finame=textField.getText();
		String lsname=textField_1.getText();
		System.out.print(sid + "../assign/DataManagementDemo_DB.xml");
		
		  try{
		        File fXmlFile = new File("../assign/DataManagementDemo_DB.xml");
		        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		        DocumentBuilder dbf = dbFactory.newDocumentBuilder();
		        Document doc = dbf.parse(fXmlFile);
		        Element d_Tag = doc.getDocumentElement();
		        Element p_Tag =  (Element) d_Tag.getElementsByTagName("studentTable").item(0);

		        Element new_Stu = doc.createElement("student");

		        new_Stu.setAttribute("sid",sid);    
		        new_Stu.setAttribute("fname",finame);    
		        new_Stu.setAttribute("lname",lsname);    

		        p_Tag.appendChild(new_Stu);
		        TransformerFactory trans_Former = TransformerFactory.newInstance();
		            Transformer trans = trans_Former.newTransformer();
		            DOMSource source = new DOMSource(doc);

		            StreamResult result = new StreamResult("../assign/DataManagementDemo_DB.xml");
		            trans.transform(source, result);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
	}

	/**
	 * Create the application.
	 */
	public AddStu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 433, 347);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(34, 108, 314, 32);
		frame.getContentPane().add(panel);
		
		JLabel lblEnterFirstName = new JLabel("Enter First Name");
		panel.add(lblEnterFirstName);
		
		JLabel label = new JLabel("     ");
		panel.add(label);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(34, 151, 314, 32);
		frame.getContentPane().add(panel_1);
		
		JLabel lblEnterLastName = new JLabel("Enter Last Name");
		panel_1.add(lblEnterLastName);
		
		JLabel label_2 = new JLabel("     ");
		panel_1.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_1.add(textField_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(34, 65, 314, 32);
		frame.getContentPane().add(panel_2);
		
		JLabel lblEnterStudent = new JLabel("Enter Student Id ");
		panel_2.add(lblEnterStudent);
		
		JLabel label_4 = new JLabel("     ");
		panel_2.add(label_4);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		panel_2.add(textField_2);
		
		JLabel lblNewLabel = new JLabel("ADD STUDENT");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(118, 11, 168, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(34, 244, 314, 35);
		frame.getContentPane().add(panel_3);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addStud();
			
			
			}
		});
		panel_3.add(btnSave);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(34, 190, 314, 32);
		frame.getContentPane().add(panel_4);
		
		JLabel lblSelectUnit = new JLabel("Select Unit");
		panel_4.add(lblSelectUnit);
		
		JLabel label_3 = new JLabel("     ");
		panel_4.add(label_3);
	}
}
