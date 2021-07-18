package milan.liebsch.mycomponents;

import javax.swing.JFrame;

public class App  extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TitleLabel a = new TitleLabel("hahaha");
		a.paint(null);
		
		App hello = new App();
		hello.add(a);
		
		hello.setVisible(true);
		

	}

}
