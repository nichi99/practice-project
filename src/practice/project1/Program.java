package practice.project1;

import practice.project1.ui.MainFrame;

public class Program {

    public static final Program instance = new Program();

    private final MainFrame mainFrame;

    public Program() {
	this.mainFrame = new MainFrame();
    }

    public void run() {
	this.mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
	Program.instance.run();
    }

}
