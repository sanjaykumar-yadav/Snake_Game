import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

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
	
	private int score = 0;
	
	private int [] enemyxpos = {25,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625,650,675,700,725,750};
	private int [] enemyypos = {75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525};
	
	private Random random = new Random();
	private int xpos = random.nextInt(29);
	private int ypos = random.nextInt(19);
	
	private Timer timer ;
	private int delay = 100;
	private ImageIcon enemy;
	private ImageIcon rightimage;
	private ImageIcon upimage;
	private ImageIcon downimage;
	private ImageIcon leftimage;
	private ImageIcon snakeimage;
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
	 	
	 	topimage = new ImageIcon("snaketitle.jpg");
	 	topimage.paintIcon(this , g, 24, 11);
	 	
	 	g.setColor(Color.black);
	 	g.fillRect(25, 75,850,575);
	 	
	 	g.setColor(Color.white);
	 	g.setFont(new Font("arial", Font.PLAIN ,14));
	 	g.drawString("Score : "+score, 780, 30);
	 	
	 	g.setColor(Color.white);
	 	g.setFont(new Font("arial", Font.PLAIN ,14));
	 	g.drawString("Length : "+snakelength, 780, 50);
	 	
	 	rightimage = new ImageIcon("rightimage.jpg");
	 	rightimage.paintIcon(this, g, snakexlength[0], snakeylength[0]);
	 	
	 	for(int a = 0;a < snakelength ; a++)
	 	{
	 		if(a==0 && right)
	 		{
	 			rightimage = new ImageIcon("rightimage.jpg");
	 		 	rightimage.paintIcon(this, g, snakexlength[a], snakeylength[a]);
	 		}
	 		if(a==0 && left)
	 		{
	 			leftimage = new ImageIcon("leftimage.jpg");
	 		 	leftimage.paintIcon(this, g, snakexlength[a], snakeylength[a]);
	 		}
	 		if(a==0 && up)
	 		{
	 			upimage = new ImageIcon("upimage.jpg");
	 		 	upimage.paintIcon(this, g, snakexlength[a], snakeylength[a]);
	 		}
	 		if(a==0 && down)
	 		{
	 			downimage = new ImageIcon("downimage.jpg");
	 		 	downimage.paintIcon(this, g, snakexlength[a], snakeylength[a]);
	 		}
	 		if (a!= 0)
	 		{
		 			snakeimage = new ImageIcon("snakeimage.jpg");
		 		 	snakeimage.paintIcon(this, g, snakexlength[a], snakeylength[a]);
	 		}
	 		
	 	}
	 	enemy = new ImageIcon("enemy.jpg");
	 	
	 	if(enemyxpos[xpos] == snakexlength[0]  &&  enemyypos[ypos] == snakeylength[0])
	 	{	
	 		score++;
	 		snakelength++;
	 		xpos = random.nextInt(29);
	 		ypos = random.nextInt(19);
	 	}
	 	enemy.paintIcon(this, g, enemyxpos[xpos], enemyypos[ypos]);
		
	 	for(int b =1 ; b<snakelength;b++)
	 	{
	 		if(snakexlength[b] == snakexlength[0] && snakeylength[b] == snakeylength[0])
	 		{
	 			right = false;
	 			left = false;
	 			up = false;
	 			down = false;
	 			
	 			g.setColor(Color.white);
	 			g.setFont(new Font("arial",Font.BOLD,50));
	 			g.drawString("GAME OVER !!", 300, 300);
	 			g.setFont(new Font("arial",Font.BOLD,20));
	 			g.drawString("Press Space Restart", 350, 340);
	 			repaint();
	 			
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
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			move = 0;
			score = 0;
			snakelength = 3;
		}
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