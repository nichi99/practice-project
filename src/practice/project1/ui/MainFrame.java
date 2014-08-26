package practice.project1.ui;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import practice.project1.core.EnumType;

public class MainFrame extends JFrame {

    private static final long serialVersionUID = -7698112289443409454L;

    private final int SIZE_WIDTH = 400;
    private final int SIZE_HEIGHT = 400;

    private final String TITLE = "Power Calc Tool";

    public MainFrame() {
	this.setResizable(false);
	this.setSize(SIZE_WIDTH, SIZE_HEIGHT);
	this.setTitle(TITLE);
	getContentPane().setLayout(null);

	JLabel lblSelectType = new JLabel("Select type:");
	lblSelectType.setBounds(10, 11, 374, 14);
	getContentPane().add(lblSelectType);

	JComboBox comboBox = new JComboBox();
	comboBox.setModel(new DefaultComboBoxModel(EnumType.values()));
	comboBox.setBounds(10, 36, 374, 20);
	getContentPane().add(comboBox);
    }
}
