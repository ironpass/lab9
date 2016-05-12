import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Class for user interface(UI)
 * @author Akarachai Passavoranan
 *
 */
public class ConverterUI extends JFrame {
	private JButton convertButton;
	private UnitConverter unitconverter;
	private JButton clearButton;
	private JTextField inputField1;
	private JTextField inputField2;
	private JComboBox unitBox1;
	private JComboBox unitBox2;
	private JRadioButton leftRight;
	private JRadioButton rightLeft;
	private boolean isLeftToRight = true;
/**
 * Constructor
 * @param uc a unitconverter
 */
	public ConverterUI (UnitConverter uc) {
		this.unitconverter = uc;
		this.setTitle("Length Converter");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
	}
	/**
	 * create JComponents in UI here
	 */
	private void initComponents() {
		inputField1 = new JTextField(10);
		Unit[] lengthArr = unitconverter.getUnits();
		unitBox1 = new JComboBox(lengthArr);
		inputField2 = new JTextField(10);
		inputField2.setEditable(false);
		unitBox2 = new JComboBox(lengthArr);
		convertButton = new JButton("Convert!");
		convertButton.addActionListener(new ConvertButtonListener());
		clearButton = new JButton("Clear");
		clearButton.addActionListener(new ClearButtonListener());
		leftRight = new JRadioButton("Left->Right", true);
		leftRight.addActionListener(new LeftRightListener());
		rightLeft = new JRadioButton("Right->Left", false);
		rightLeft.addActionListener(new RightLeftListener());
		
		//designing JFrame
		JFrame contents = new JFrame();
		contents.setLayout(new FlowLayout());
		contents.setResizable(false);
		contents.setBounds(0,0,630,100);
		contents.add(inputField1);
		contents.add(unitBox1);
		contents.add(new JLabel("="));
		contents.add(inputField2);
		contents.add(unitBox2);
		contents.add(convertButton);
		contents.add(clearButton);
		ButtonGroup radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(leftRight);
		radioButtonGroup.add(rightLeft);
		contents.add(leftRight);
		contents.add(rightLeft);
		contents.setVisible(true);
		
	}
	/**
	 * Action listener for convert button
	 * @author Akarachai Passavoranan
	 *
	 */
	class ConvertButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			convert();
		}
	}
	/**
	 * convert function for convert button
	 */
	private void convert() {
		String s;
		if (isLeftToRight)
		s = inputField1.getText().trim();
		else
			s = inputField2.getText().trim();	
		if (s.length() > 0) {
			try {
				double value = Double.valueOf(s);
				if (isLeftToRight) {
					double result = unitconverter.convert(value, (Length)unitBox1.getSelectedItem(), (Length)unitBox2.getSelectedItem());
					inputField2.setText(result+"");
				} else {
					double result = unitconverter.convert(value, (Length)unitBox2.getSelectedItem(),  (Length)unitBox1.getSelectedItem());
					inputField1.setText(result+"");
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Input must be a number value.", "Invalid input", JOptionPane.PLAIN_MESSAGE);
			}
			
		}
	}
	/**
	 * Action listener for clear button
	 * @author Akarachai Passavoranan
	 *
	 */
	class ClearButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			inputField1.setText("");
			inputField2.setText("");
		}
	}
	/**
	 * Action listener for left to right radio button
	 * @author Akarachai Passavoranan
	 *
	 */
	class LeftRightListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			convert();
			isLeftToRight = true;
			inputField1.setEditable(true);
			inputField2.setEditable(false);
		}
	}
	/**
	 * Action listener for right to left radio button
	 * @author Akarachai Passavoranan
	 *
	 */
	class RightLeftListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			convert();
			isLeftToRight = false;
			inputField1.setEditable(false);
			inputField2.setEditable(true);
		}
	}
}
