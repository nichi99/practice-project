package practice.project1;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class MainFrame extends JFrame {

    // The design code of this frame was automatically generated

    private static final long serialVersionUID = -7698112289443409454L;

    private final int SIZE_WIDTH = 400;
    private final int SIZE_HEIGHT = 400;
    private final String TITLE = "Power Calc Tool";

    private JTable table;

    private int numPrimaries;
    private double utilization;
    private EnumPrimaryType type;

    public MainFrame() {
	this.numPrimaries = 0;

	setResizable(false);
	setSize(400, 275);
	setTitle(TITLE);
	getContentPane().setLayout(null);

	JLabel lblSelectType = new JLabel("Choose type:");
	lblSelectType.setBounds(10, 67, 374, 14);
	getContentPane().add(lblSelectType);

	final JComboBox comboBox = new JComboBox();
	comboBox.addItemListener(new ItemListener() {
	    @Override
	    public void itemStateChanged(ItemEvent arg0) {
		if (arg0.getStateChange() == ItemEvent.SELECTED) {
		    MainFrame.this.type = (EnumPrimaryType) comboBox
			    .getSelectedItem();
		    MainFrame.this.update();
		}
	    }
	});
	comboBox.setModel(new DefaultComboBoxModel(EnumPrimaryType.values()));
	comboBox.setBounds(10, 92, 374, 20);
	getContentPane().add(comboBox);

	JLabel lblNewLabel = new JLabel("Number of primaries:");
	lblNewLabel.setBounds(10, 11, 175, 14);
	getContentPane().add(lblNewLabel);

	final JSpinner spinner = new JSpinner();
	spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0),
		null, new Integer(1)));
	spinner.addChangeListener(new ChangeListener() {
	    @Override
	    public void stateChanged(ChangeEvent arg0) {
		MainFrame.this.numPrimaries = (int) spinner.getValue();
		MainFrame.this.update();
	    }
	});
	spinner.setBounds(10, 36, 175, 20);
	getContentPane().add(spinner);

	table = new JTable();
	table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
		null));
	table.setModel(new DefaultTableModel(new Object[][] {
		{ "Current (A)", null }, { "Voltage (V)", null },
		{ "Power (W)", null }, { "Power (KW)", null },
		{ "Min Power (KW)", null },
		{ "Colocation Power Allocation (KW)", null },
		{ "80% NEC Power (KW)", null }, }, new String[] { "Property",
		"Value" }) {
	    Class[] columnTypes = new Class[] { String.class, String.class };

	    @Override
	    public Class getColumnClass(int columnIndex) {
		return columnTypes[columnIndex];
	    }

	    boolean[] columnEditables = new boolean[] { false, true };

	    @Override
	    public boolean isCellEditable(int row, int column) {
		return columnEditables[column];
	    }
	});
	table.getColumnModel().getColumn(0).setPreferredWidth(187);
	table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	table.setColumnSelectionAllowed(true);
	table.setCellSelectionEnabled(true);
	table.setBounds(10, 123, 374, 112);
	getContentPane().add(table);

	JLabel lblUtilizationEstimate = new JLabel("Utilization estimate (%):");
	lblUtilizationEstimate.setBounds(209, 11, 175, 14);
	getContentPane().add(lblUtilizationEstimate);

	final JSpinner spinner_1 = new JSpinner();
	spinner_1.setModel(new SpinnerNumberModel(new Double(80), null, null,
		new Double(1)));
	spinner_1.addChangeListener(new ChangeListener() {
	    @Override
	    public void stateChanged(ChangeEvent arg0) {
		MainFrame.this.utilization = (double) spinner_1.getValue();
		MainFrame.this.update();
	    }
	});
	spinner_1.setBounds(209, 36, 175, 20);
	getContentPane().add(spinner_1);

	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	this.numPrimaries = (int) spinner.getValue();
	this.utilization = (double) spinner_1.getValue();
	this.type = (EnumPrimaryType) comboBox.getSelectedItem();
	this.update();
    }

    private void update() {
	// Formulas taken from Excel spreadsheet
	int current = this.type.getCurrent();
	int voltage = this.type.getVoltage();
	int powerWatts = this.numPrimaries * current * voltage;
	double powerKilowatts = powerWatts / 1000.0d;
	double powerKilowattsMin = powerKilowatts * 0.5;
	double cpa = powerKilowatts * this.utilization;
	double nec = powerKilowatts * 0.8d;

	TableModel model = this.table.getModel();
	model.setValueAt(current, 0, 1);
	model.setValueAt(voltage, 1, 1);
	model.setValueAt(powerWatts, 2, 1);
	model.setValueAt(powerKilowatts, 3, 1);
	model.setValueAt(powerKilowattsMin, 4, 1);
	model.setValueAt(cpa, 5, 1);
	model.setValueAt(nec, 6, 1);
	this.table.setModel(model);
    }

}
