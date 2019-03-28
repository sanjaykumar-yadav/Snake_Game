import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
class gamepy extends JPanel implements KeyListener, ActionListener
{	 
	
	
	private int[] snakexlength = new int[750];
	private int[] snakeylength = new int[750];
	
	private  int snakelength = 3;
	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;
	
	private Timer timer ;
	private int delay = 100;
	
	private ImageIcon rightimage;
	private ImageIcon upimage;
	private ImageIcon downimage;
	private ImageIcon leftimage;
	
	private ImageIcon topimage;

	 public gamepy()
	 {
		 addKeyListener(this);
		 setFocusable(true);
		 setFocusTraversalKeyEnabled(false);
		 timer = new Timer(delay, this)
		 timmer.start();
	 }
	 
	 public void paint(Graphics g)
	 {
	 	g.setColor(Color.white);
	 	g.drawRect(24, 10, 851, 55);
	 	
	 	//topimage = new ImageIcon("index.jpeg");
	 	//topimage.paintIcon(this , g, 25, 11);
	 	
	 	g.setColor(Color.black);
	 	g.fillRect(25, 75,850,575);
	 	
	 	
	 	g.dispose();
	 }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}