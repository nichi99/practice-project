package practice.project1.ui;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

    private static final long serialVersionUID = -7698112289443409454L;

    private final int SIZE_WIDTH = 400;
    private final int SIZE_HEIGHT = 400;

    private final String TITLE = "Power Calc Tool";

    public MainFrame() {
	this.setResizable(false);
	this.setSize(SIZE_WIDTH, SIZE_HEIGHT);
	this.setTitle(TITLE);
    }

}
