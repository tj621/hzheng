package it.cast;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

//import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyTank4 extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @param args
	 */
	MyPanel mp = null;
	
	
	MyTank4() {
		// TODO Auto-generated constructor stub
	
		mp=new MyPanel();
		Thread t = new Thread(mp);
		t.start();
		this.add(mp);
		this.addKeyListener(mp);
		
		this.setSize(400,300);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTank4 mt = new MyTank4();
	}

}


class MyPanel extends JPanel implements KeyListener,Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Hero hero=null;
	
	Vector<EnemyTank> ets = new Vector<EnemyTank>();
	int tankNum=3;
	
	Vector<Bomb> boms = new Vector<Bomb>();
	
	Image image1 = null;
	Image image2 = null;
//	Vector<Shot> s = new Vector<Shot>();
	
	public MyPanel()
	{
		hero = new Hero(10, 10);
		
		for (int i = 0; i < tankNum; i++) {
			EnemyTank enTank= new EnemyTank((i+1)*50, 50);
			enTank.setType(2);
			enTank.setDirect(2);
			Thread t = new Thread(enTank);
			t.start();
			
			enTank.setEts(ets);
			
			Shot shot = new Shot(enTank.x+10,enTank.y+30,enTank.direct);
			enTank.ss.add(shot);
			Thread t1=new Thread(shot);
			t1.start();
			
			ets.add(enTank);
		}
		image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb1.jpg"));
		image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb2.jpg"));
//		boms.add(image1);
		
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillRect(0, 0, 400, 300);
//		g.setColor(Color.CYAN);
		if(hero.isLive==false)	
		{
			this.drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);
		}
		
		//

		for (int i = 0; i < ets.size(); i++) {
			EnemyTank emt = ets.get(i);
			if (emt.isLive) {
				this.drawTank(emt.getX(), emt.getY(), g, emt.getDirect(), emt.getType());
				for (int j = 0; j < emt.ss.size(); j++) {
					Shot shot = emt.ss.get(j);
					if (shot!=null && shot.isLive) {
						g.draw3DRect(shot.x, shot.y, 1, 1, false);
					}
					if (!(shot.isLive)) {
						emt.ss.remove(shot);
						//为什么用的是myshot  而不是用i直接删除
					}
				}
			}
		}
		
		//我的坦克的子弹消除
		for (int i = 0; i < hero.s.size(); i++) {
			Shot myshot = hero.s.get(i);
			if (myshot!=null && myshot.isLive) {
				g.setColor(Color.yellow);
				g.draw3DRect(myshot.x, myshot.y, 1, 1, false);
			}
			//子弹消除判断，重新能够打出数量为5的子弹
			if (!(myshot.isLive)) {
				hero.s.remove(myshot);
				//为什么用的是myshot  而不是用i直接删除
			}
		}
		
		//炸弹效果显示
		for (int i1 = 0; i1 < boms.size(); i1++) {
				Bomb bomb = boms.get(i1);
//				if (bomb.isLive) {
					if (bomb.life>4) {
						g.drawImage(image1, bomb.x, bomb.y, 30, 30,this);
					}
					else
					{
						g.drawImage(image2, bomb.x, bomb.y, 30, 30,this);
					}
					bomb.lifeDown();
					if (bomb.life==0) {
						boms.remove(bomb);
					}
				}	
//			g.draw3DRect(hero.shot.x, hero.shot.y, 1, 1, false);
}
	
	public void hitTank(Shot s,Tank et)
	{
		switch (et.direct) {
		case 0:
			if (s.x>et.x && s.x<et.x+20 &&s.y>et.y && s.y<et.y+30) {
				//子弹死亡并且坦克死亡
				Bomb bomb=new Bomb(et.x,et.y);
				boms.add(bomb);
				s.isLive=false;
				et.isLive = false;
				
				//打中的时候会出现炸弹
				
			}
			break;
		case 2:
			if (s.x>et.x && s.x<et.x+20 &&s.y>et.y && s.y<et.y+30) {
				//子弹死亡并且坦克死亡
				Bomb bomb=new Bomb(et.x,et.y);
				boms.add(bomb);
				s.isLive=false;
				et.isLive = false;
			}
			break;
		case 1:
			if (s.x>et.x && s.x<et.x+30 &&s.y>et.y && s.y<et.y+20) {
				Bomb bomb=new Bomb(et.x,et.y);
				boms.add(bomb);
				s.isLive=false;
				et.isLive = false;
				
			}
			break;
		case 3:
			if (s.x>et.x && s.x<et.x+30 &&s.y>et.y && s.y<et.y+20) {
				Bomb bomb=new Bomb(et.x,et.y);
				boms.add(bomb);
				s.isLive=false;
				et.isLive = false;
				
			}
			break;
		default:
			break;
		}
	}
	// direct 0:up  1:left  2:down  3:right
	//type 0:Blue 1:yellow  2:
	public void drawTank(int x,int y,Graphics g,int direct,int type)
	{
		switch (type) {
		case 0:
			g.setColor(Color.blue);
			break;
		case 1:
			g.setColor(Color.yellow);
			break;
		case 2:
			g.setColor(Color.blue);
			break;
		default:
			break;
		}
		switch (direct) {
		case 0:
			g.drawRect(x, y, 5, 30);
			for (int i = 1; i < 5; i++) {
				int dx = i*6;
				g.drawLine(x, y+dx,x+5, y+dx);
				g.drawLine(x+15, y+dx,x+20, y+dx);
			}
			
//			g.fillRect(x, y, 5, 30);
			g.drawRect(x+15, y, 5, 30);
			g.drawRect(x+5, y+5, 10, 20);
			g.drawOval(x+6, y+5+6, 8, 8);
			g.drawLine(x+6+4, y+5+6,x+6+4, y);
			break;
		case 1:
			g.drawRect(x+10, y, 30, 5);
			for (int i = 1; i < 5; i++) {
				int dx = i*6;
				g.drawLine(x+10+dx, y,x+10+dx, y+5);
				g.drawLine(x+10+dx, y+15,x+10+dx, y+20);
			}
			g.drawRect(x+10, y+15, 30, 5);
			g.drawRect(x+15, y+5, 20, 10);
			g.drawOval(x+21, y+6, 8, 8);
			g.drawLine(x+20-11, y+10,x+29-8, y+10);
			break;
		case 2:
			g.drawRect(x, y, 5, 30);
			for (int i = 1; i < 5; i++) {
				int dx = i*6;
				g.drawLine(x, y+dx,x+5, y+dx);
				g.drawLine(x+15, y+dx,x+20, y+dx);
			}
			
//			g.fillRect(x, y, 5, 30);
			g.drawRect(x+15, y, 5, 30);
			g.drawRect(x+5, y+5, 10, 20);
			g.drawOval(x+6, y+5+6, 8, 8);
			g.drawLine(x+6+4, y+5+6+8,x+6+4, y+22+8);
			break;
		case 3:
			g.drawRect(x+10, y, 30, 5);
			for (int i = 1; i < 5; i++) {
				int dx = i*6;
				g.drawLine(x+10+dx, y,x+10+dx, y+5);
				g.drawLine(x+10+dx, y+15,x+10+dx, y+20);
			}
			g.drawRect(x+10, y+15, 30, 5);
			g.drawRect(x+15, y+5, 20, 10);
			g.drawOval(x+21, y+6, 8, 8);
			g.drawLine(x+29, y+10,x+40, y+10);
			break;
		default:
			break;
		}
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
//		int code=e.getKeyCode();
		if (e.getKeyCode()==KeyEvent.VK_W) {
			this.hero.setDirect(0);
			this.hero.moveUp();
		}else if (e.getKeyCode()==KeyEvent.VK_D) {
			this.hero.setDirect(3);
			this.hero.moveRight();
		}else if (e.getKeyCode()==KeyEvent.VK_S) {
			this.hero.setDirect(2);
			this.hero.moveDown();
		}else if (e.getKeyCode()==KeyEvent.VK_A) {
			this.hero.setDirect(1);
			this.hero.moveLeft();
		}
		if (e.getKeyCode()==KeyEvent.VK_J) {
			if (this.hero.s.size()<5) {
				this.hero.shotEn();
			}
//			this.hero.shotEn();
		}
//		this.rep
		this.repaint(); 
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			//判断是否击中
			for (int i = 0; i < hero.s.size(); i++) {
				Shot myShot = hero.s.get(i); 
				if (myShot.isLive) {
					for (int j = 0; j < ets.size(); j++) {
						EnemyTank emt = ets.get(j);
						if (emt.isLive) {
							hitTank(myShot, emt);
						}
					}
				}
			}
			
			for(int j=0;j<ets.size();j++)
			{
				EnemyTank entank=ets.get(j);
				for(int k=0;k<entank.ss.size();k++)
				{
					Shot shot=entank.ss.get(k);
					if(shot.isLive)
						hitTank(shot,entank);
				}
			}
			
			for(int j=0;j<ets.size();j++){
				EnemyTank entank=ets.get(j);
				if(entank.isLive)
				{
					if(entank.ss.size()<=5)
					{
						Shot shot  = null;
						System.out.println(entank.ss.size());
						switch (entank.direct) {
						case 0:
							shot = new Shot(entank.x+10, entank.y,0);
							entank.ss.add(shot);
							break;
						case 1:
							shot = new Shot(entank.x, entank.y+10,1);
							entank.ss.add(shot);
							break;
						case 2:
							shot = new Shot(entank.x+10, entank.y+30,2);
							entank.ss.add(shot);
							break;
						case 3:
							shot = new Shot(entank.x+30, entank.y+10,3);
							entank.ss.add(shot);
							break;
						default:
							break;
						}
						Thread t=new Thread(shot);
						t.start();
					}
				}
			}
			//重绘
			this.repaint();
		}
	}
}
