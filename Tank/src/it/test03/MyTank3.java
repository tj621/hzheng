package it.test03;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

//import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MyTank3 extends JFrame implements ActionListener{

	/**
	 * ��Ϸ����
	 * 1�����Կ���̹�˵�������������ͬ��ɫ��̹��
	 * 2���ҵ�̹�˿����ƶ�
	 * 3���ҵ�̹�˿��Է����ӵ������5��
	 * 4�����һ��б���̹�˵�ʱ�򣬵��˾ͻ���ʧ
	 * 5�����˵�̹��Ҳ�����ƶ�������Ҳ���Է����ӵ����Ҵ��к���б�ըЧ��
	 * 6��̹��֮�䲻�ܳ����ص�����
	 * 7�����Էֹء�
	 * 		7��1��ʼ��ʾ�յĹؿ���
	 * 		7��2ѡ���ʱ�������˸Ч��
	 * 8��������ͣ/������Ϸ
	 * 	8.1��ͣ��ʱ���ӵ����ٶȺ�̹�˵��ٶ�Ϊ0���ҷ��򲻱仯��
	 * 		��¼�ϴε��ٶȷ���֮��ָ���
	 * 9����¼��ҵ���Ϸ�ɼ�
	 *      9.1���ļ���
	 *      9.2����дһ��Recoder�࣬
	 *      9.3ʹ���ַ������������д������
	 *      9.4�ָ��ϴε����ݵ�ʱ�򣬻ָ���ȡ�ļ����ɡ�
	 *      9.5�����˳���
	 * 10��java��β��������ļ�
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @param args
	 */
	MyPanel mp = null;
	StartPanel sp=null;
	
	JMenuBar jmb=null; //�˵���
	JMenu jmenu=null;//�˵���
	JMenuItem jmt=null;//�˵���Ŀ
	JMenuItem jmt2=null;
	
	MyTank3() {
		// TODO Auto-generated constructor stub
		sp=new StartPanel();
		
		jmb=new JMenuBar();
		jmenu=new JMenu("��ϷG");
		//���ÿ�ݷ�ʽ
		jmenu.setMnemonic('G');

		jmt= new JMenuItem("��ʼ��Ϸ(N)");
		//�����Ӧ
		jmt.addActionListener(this);
		jmt.setActionCommand("new Game");
		//���ÿ�ݼ�
		jmt.setMnemonic('N');
		
		jmt2=new JMenuItem("�˳�");
		jmt2.addActionListener(this);
		jmt2.setActionCommand("quite");
		
		jmb.add(jmenu);
		jmenu.add(jmt);
		jmenu.add(jmt2);
		
		Thread t_sp=new Thread(sp);
		t_sp.start();
		this.setJMenuBar(jmb);
		this.add(sp);
		
//		mp=new MyPanel();
//		Thread t = new Thread(mp);
//		t.start();
//		this.add(mp);
		this.addKeyListener(mp);
		
		this.setSize(600,500);
		
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTank3 mt = new MyTank3();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("new Game")){
			
			mp=new MyPanel();
			
			Thread t = new Thread(mp);
			t.start();
			this.remove(sp);
			this.add(mp);
			this.setVisible(true);
		}
		if(e.getActionCommand().equals("quite")){
			//�˳�֮ǰ��Ҫ������Ϸ���ݣ���Recoder���е�����
			System.exit(0);
		}
	}

}

//��ʼ�������棬��Ҫ����ѡ��ؿ��ȹ���
class StartPanel extends JPanel implements Runnable{
	
	public void paint(Graphics g){
		super.paint(g);
		g.fillRect(0, 0, 400, 300);
		if(times%2==0)
		{
			g.setColor(Color.yellow);
			Font myFont=new Font("������κ",Font.BOLD,30);
			g.setFont(myFont);
			g.drawString("stage:1", 150, 150);
		}
		
	}
	int times=0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true){
			try {
				Thread.sleep(300);
			} catch (Exception e) {
				// TODO: handle exception
			}
			times++;
			this.repaint();
		}
	}
}


class MyPanel extends JPanel implements KeyListener,Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Hero hero=null;
	
	Vector<EnemyTank> ets = new Vector<EnemyTank>();
	int tankNum=5;
	
	Vector<Bomb> boms = new Vector<Bomb>();
	
	Image image1 = null;
	Image image2 = null;
//	Vector<Shot> s = new Vector<Shot>();
	
	//������ʾ��Ϣ
	public void showInfo(Graphics g){
		
		//�ڿհ�������ʾ��Ϸ��Ϣ
		this.drawTank(80, 330, g, 0, 0);
		this.drawTank(80, 370, g, 0, 0);
		g.setColor(Color.RED);
		g.drawString(Recoder.getEnNum()+"", 110, 350);
//		g.setColor(Color.CYAN);
//		g.setColor(Color.YELLOW);
		g.drawString(Recoder.getMyLive()+"", 110, 390);
		if(hero.isLive)
		{
			this.drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);
		}
	}
	
	public MyPanel()
	{

		hero = new Hero(50, 50);
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
	
	//��ʼ��/���»�
	public void paint(Graphics g)
	{super.paint(g);
	g.fillRect(0, 0, 400, 300);
	
		this.showInfo(g);
		//

		for (int i = 0; i < ets.size(); i++) {
			EnemyTank emt = ets.get(i);
			if (emt.isLive) {
				this.drawTank(emt.getX(), emt.getY(), g, emt.getDirect(), emt.getType());
				for (int j = 0; j < emt.ss.size(); j++) {
					Shot shot = emt.ss.get(j);
					if (shot!=null && shot.isLive) {
						hitHero(shot, hero);
						g.draw3DRect(shot.x, shot.y, 1, 1, false);
					}
					if (!(shot.isLive)) {
						emt.ss.remove(shot);
						//Ϊʲô�õ���myshot  ��������iֱ��ɾ��
					}
				}
			}
		}
		
		//�ҵ�̹�˵��ӵ�����
		for (int i = 0; i < hero.s.size(); i++) {
			Shot myshot = hero.s.get(i);
			if (myshot!=null && myshot.isLive) {
				g.setColor(Color.yellow);
				g.draw3DRect(myshot.x, myshot.y, 1, 1, false);
			}
			//�ӵ������жϣ������ܹ��������Ϊ5���ӵ�
			if (!(myshot.isLive)) {
				hero.s.remove(myshot);
				//Ϊʲô�õ���myshot  ��������iֱ��ɾ��
			}
		}
		
		//ը��Ч����ʾ
		if(hero.isLive){
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
}
	public void hitHero(Shot s,Hero hero)
	{
		switch (hero.direct) {
		case 2:
		case 0:
			if(s.x>hero.x && s.x<hero.x+20 &&s.y>hero.y && s.y<hero.y+30)
				hero.isLive=false;
				Recoder.reduceMylive();
			break;
		
		case 1:
		case 3:
			if(s.x>hero.x && s.x<hero.x+30 &&s.y>hero.y && s.y<hero.y+20)
				hero.isLive=false;
				Recoder.reduceMylive();
			break;
		default:
			break;
		}
	}
	
	public void hitTank(Shot s,EnemyTank et)
	{
		switch (et.direct) {
		case 0:
			if (s.x>et.x && s.x<et.x+20 &&s.y>et.y && s.y<et.y+30) {
				//�ӵ���������̹������
				Bomb bomb=new Bomb(et.x,et.y);
				boms.add(bomb);
				s.isLive=false;
				et.isLive = false;
				Recoder.reduceEnBun();
				//���е�ʱ������ը��
				
			}
			break;
		case 2:
			if (s.x>et.x && s.x<et.x+20 &&s.y>et.y && s.y<et.y+30) {
				//�ӵ���������̹������
				Bomb bomb=new Bomb(et.x,et.y);
				boms.add(bomb);
				s.isLive=false;
				et.isLive = false;
				Recoder.reduceEnBun();
			}
			break;
		case 1:
			if (s.x>et.x && s.x<et.x+30 &&s.y>et.y && s.y<et.y+20) {
				Bomb bomb=new Bomb(et.x,et.y);
				boms.add(bomb);
				s.isLive=false;
				et.isLive = false;
				Recoder.reduceEnBun();
			}
			break;
		case 3:
			if (s.x>et.x && s.x<et.x+30 &&s.y>et.y && s.y<et.y+20) {
				Bomb bomb=new Bomb(et.x,et.y);
				boms.add(bomb);
				s.isLive=false;
				et.isLive = false;
				Recoder.reduceEnBun();
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
			this.hero.setDirect(1);//����
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
			
			//�ж��Ƿ����
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
			
//			for(int j=0;j<ets.size();j++){
//				EnemyTank entank=ets.get(j);
//				if(entank.isLive)
//				{
//					if(entank.ss.size()<=5)
//					{
//						Shot shot  = null;
//						System.out.println(entank.ss.size());
//						switch (entank.direct) {
//						case 0:
//							shot = new Shot(entank.x+10, entank.y,0);
//							entank.ss.add(shot);
//							break;
//						case 1:
//							shot = new Shot(entank.x, entank.y+10,1);
//							entank.ss.add(shot);
//							break;
//						case 2:
//							shot = new Shot(entank.x+10, entank.y+30,2);
//							entank.ss.add(shot);
//							break;
//						case 3:
//							shot = new Shot(entank.x+30, entank.y+10,3);
//							entank.ss.add(shot);
//							break;
//						default:
//							break;
//						}
//						Thread t=new Thread(shot);
//						t.start();
//					}
//				}
//			}
			//�ػ�
			this.repaint();
		}
	}
}
