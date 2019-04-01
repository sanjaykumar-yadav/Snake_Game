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
	private int move =0;
	private ImageIcon topimage;

	 public gamepy()
	 {
		 addKeyListener(this);
		 setFocusable(true);
		 setFocusTraversalKeysEnabled(false);
		 timer = new Timer(delay, this);
		timer.start();
	 }
	 
	 public void paint(Graphics g)
	 {
		 if (move == 0)
		 {
			 snakexlength[2] = 50;
			 snakexlength[1] = 75;
			 snakexlength[0] = 100;
			 
			 snakeylength[2] = 100;
			 snakeylength[1] = 100;
			 snakeylength[0] = 100;
 		}
	 	g.setColor(Color.white);
	 	g.drawRect(24, 10, 851, 55);
	 	
	 	//topimage = new ImageIcon("index.jpeg");
	 	//topimage.paintIcon(this , g, 25, 11);
	 	
	 	g.setColor(Color.black);
	 	g.fillRect(25, 75,850,575);
	 	
	 	rightimage = new ImageIcon("snakeimage.jpg");
	 	rightimage.paintIcon(this, g, snakexlength[0], snakeylength[0]);
	 	
	 	for(int a = 0;a < snakelength ; a++)
	 	{
	 		if(a==0 && right)
	 		{
	 			rightimage = new ImageIcon("snakeimage.jpg");
	 		 	rightimage.paintIcon(this, g, snakexlength[a], snakeylength[a]);
	 		}
	 		if(a==0 && left)
	 		{
	 			leftimage = new ImageIcon("snakeimage.jpg");
	 		 	rightimage.paintIcon(this, g, snakexlength[a], snakeylength[a]);
	 		}
	 		if(a==0 && right)
	 		{
	 			upimage = new ImageIcon("snakeimage.jpg");
	 		 	rightimage.paintIcon(this, g, snakexlength[a], snakeylength[a]);
	 		}
	 		if(a==0 && right)
	 		{
	 			downimage = new ImageIcon("snakeimage.jpg");
	 		 	rightimage.paintIcon(this, g, snakexlength[a], snakeylength[a]);
	 		}
	 		if (a!= 0)
	 		{
		 			rightimage = new ImageIcon("snakeimage.jpg");
		 		 	rightimage.paintIcon(this, g, snakexlength[a], snakeylength[a]);
	 		}
	 		
	 	}
	 	
	 	g.dispose();
	 }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		timer.start();
		if(right)
		{
			for(int b = snakelength-1;b>=0;b--)
			{
				snakeylength[b+1] = snakeylength[b] ;
			}
			for(int b =snakelength;b>=0;b--)
			{
				if(b==0)
				{
					snakexlength[b] = snakexlength[b] + 25;
				}
				else
				{
					snakexlength[b] = snakexlength[b-1];
				}
				if(snakexlength[b] > 850)
				{
					snakexlength[b] = 25;
				}
			}
			repaint();
			
		}
		if(left)
		{
			for(int b = snakelength-1;b>=0;b--)
			{
				snakeylength[b+1] = snakeylength[b] ;
			}
			for(int b =snakelength;b>=0;b--)
			{
				if(b==0)
				{
					snakexlength[b] = snakexlength[b] - 25;
				}
				else
				{
					snakexlength[b] = snakexlength[b-1];
				}
				if(snakexlength[b] < 25)
				{
					snakexlength[b] = 850;
				}
			}
			repaint();
		}
		if(up)
		{
			for(int b = snakelength-1;b>=0;b--)
			{
				snakexlength[b+1] = snakexlength[b] ;
			}
			for(int b =snakelength;b>=0;b--)
			{
				if(b==0)
				{
					snakeylength[b] = snakeylength[b] - 25;
				}
				else
				{
					snakeylength[b] = snakeylength[b-1];
				}
				if(snakeylength[b] < 75)
				{
					snakeylength[b] = 625;
				}
			}
			repaint();	
		}
		if(down)
		{
			for(int b = snakelength-1;b>=0;b--)
			{
				snakexlength[b+1] = snakexlength[b] ;
			}
			for(int b =snakelength;b>=0;b--)
			{
				if(b==0)
				{
					snakeylength[b] = snakeylength[b] + 25;
				}
				else
				{
					snakeylength[b] = snakeylength[b-1];
				}
				if(snakeylength[b] > 625)
				{
					snakeylength[b] = 75 ;
				}
			}
			repaint();	
		}
		}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			move++;
			right = true;
			if(!left)
			{
				right = true;
			}
			else
			{
				right = false;
				left = true;
			}
			up = false;
			down = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			move++;
			left = true;
			if(!right)
			{
				left = true;
			}
			else
			{
				left = false;
				right = true;
			}
			up = false;
			down = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			move++;
			up = true;
			if(!down)
			{
				up = true;
			}
			else
			{
				up = false;
				down = true;
			}
			right = false;
			left = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			move++;
			down = true;
			if(!up)
			{
				down = true;
			}
			else
			{
				down = false;
				up = true;
			}
			right = false;
			left = false;
		}
		
		
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