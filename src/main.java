import javax.swing.*;
import java.awt.*;

public class main
{
	public static void main(String[] args)
	{
		JFrame object = new JFrame();
		gamepy gp = new gamepy();
		object.setBounds(10,10,905,700);
		object.setBackground(Color.GRAY);
		object.setResizable(false);
		object.setVisible(true);
		object.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		object.add(gp);
		
		
	}
	
	
}