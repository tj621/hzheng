package it.cast;
//对tank属性添加存活属性，升级

import java.util.Vector;

class Bomb
{
	int x;
	int y;
	int life = 9;
	boolean isLive=true;
	public Bomb(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	
	public void lifeDown()
	{
		if (life>0) {
			life--;
		}else {
			this.isLive=false;
		}
	}
}

class Shot implements Runnable
{
	int x;
	int y;
	int direct;
	int speed=3;
	int num=0;
	boolean isLive = true;
	public Shot(int x,int y,int direct) {
		// TODO Auto-generated constructor stub
		this.x=x;
		this.y=y;
		this.direct=direct;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				// TODO: handle exception
			}
			switch (direct) {
			case 0:
				y=y-speed;
				break;
			case 1:
				x=x-speed;
				break;
			case 2:
				y=y+speed;
				break;
			case 3:
				x=x+speed;
				break;
			default:
				break;
			}
			if (x<0 || x>400 || y<0 || y>300) {
				this.isLive=false;
				num=0;
				break;
			}
		}
	}
}

class Tank
{
	
	int x=0;
	//0:up  1:right  2:down  3:left
	int direct=0;
	//0:Blue 1:yellow  2:
	int type=0;
	//speed
	int speed=2;
	boolean isLive=true;
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	int y=0;
	
	
	public int getDirect() {
		return direct;
	}

	public void setDirect(int direct) {
		this.direct = direct;
	}
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Tank(int x,int y) {
		this.x=x;
		this.y=y;
	}
}


class EnemyTank extends Tank implements Runnable
{
//	boolean isLive = true;
	
	//子弹添加时间：刚创建的时候坦克的时候，敌人的子弹死亡之后
	Vector<Shot> ss = new Vector<Shot>();
	Shot shot = null;
	
	Vector<EnemyTank> ets = new Vector<EnemyTank>();
	
	public EnemyTank(int x,int y) {
		super(x,y);
		// TODO Auto-generated constructor stub
	}
	
//	public boolean isTouch()
//	{
//		//0:up  1:right  2:down  3:left
//		boolean bool=false;
//		switch (this.direct) {
//		case 0:
//			for (int i = 0; i < ets.size(); i++) {
//				EnemyTank entank = ets.get(i);
//				if (entank != this) {
//					if (entank.direct==0 ||entank.direct==2) {
//						if(this.x>=entank.x && this.x<=entank.x+20 
//								&&this.y>=entank.y&&this.y<=entank.y+30 ){
//							bool= true;
//						}
//						if(this.x+20>=entank.x && this.x+20<=entank.x+20 
//								&&this.y>=entank.y&&this.y<=entank.y+30 ){
//							bool= true;
//						}
//					}
//					if (entank.direct==1 ||entank.direct==3) {
//						if(this.x>entank.x && this.x<=entank.x+30 
//								&&this.y>=entank.y&&this.y<=entank.y+20 ){
//							bool= true;
//						}
//						if(this.x+20>=entank.x && this.x+20<=entank.x+30 
//								&&this.y>=entank.y&&this.y<=entank.y+20 ){
//							bool= true;
//						}
//					}
//				}
//			}
//			break;
//		case 1:
//			for (int i = 0; i < ets.size(); i++) {
//				EnemyTank entank = ets.get(i);
//				if (entank != this) {
//					if (entank.direct==0 ||entank.direct==2) {
//						if(this.x+30>=entank.x && this.x+30<=entank.x+20 
//								&&this.y>=entank.y&&this.y<=entank.y+30 ){
//							bool= true;
//						}
//						if(this.x+30>=entank.x && this.x+30<=entank.x+20 
//								&&this.y>=entank.y&&this.y<=entank.y+30 ){
//							bool= true;
//						}
//					}
//					if (entank.direct==1 ||entank.direct==3) {
//						if(this.x+30>entank.x && this.x+30<=entank.x+30 
//								&&this.y+20>=entank.y&&this.y+20<=entank.y+20 ){
//							bool= true;
//						}
//						if(this.x+30>=entank.x && this.x+30<=entank.x+30 
//								&&this.y+20>=entank.y&&this.y+20<=entank.y+20 ){
//							bool= true;
//						}
//					}
//				}
//			}
//			break;
//		case 2:
//			for (int i = 0; i < ets.size(); i++) {
//				EnemyTank entank = ets.get(i);
//				if (entank != this) {
//					if (entank.direct==0 ||entank.direct==2) {
//						if(this.x>=entank.x && this.x<=entank.x+20 
//								&&this.y+30>=entank.y&&this.y+30<=entank.y+30 ){
//							bool= true;
//						}
//						if(this.x+20>=entank.x && this.x+20<=entank.x+20 
//								&&this.y+30>=entank.y&&this.y+30<=entank.y+30 ){
//							bool= true;
//						}
//					}
//					if (entank.direct==1 ||entank.direct==3) {
//						if(this.x+20>entank.x && this.x+20<=entank.x+30 
//								&&this.y+30>=entank.y&&this.y+30<=entank.y+20 ){
//							bool=true;
//						}
//						if(this.x+20>=entank.x && this.x+20<=entank.x+30 
//								&&this.y+30>=entank.y&&this.y+30<=entank.y+20 ){
//							bool= true;
//						}
//					}
//				}
//			}
//			break;
//		case 3:
//			for (int i = 0; i < ets.size(); i++) {
//				EnemyTank entank = ets.get(i);
//				if (entank != this) {
//					if (entank.direct==0 ||entank.direct==2) {
//						if(this.x>=entank.x && this.x<=entank.x+20 
//								&&this.y>=entank.y&&this.y<=entank.y+30 ){
//							bool= true;
//						}
//						if(this.x>=entank.x && this.x<=entank.x+20 
//								&&this.y>=entank.y&&this.y<=entank.y+30 ){
//							bool=true;
//						}
//					}
//					if (entank.direct==1 ||entank.direct==3) {
//						if(this.x>entank.x && this.x<=entank.x+30 
//								&&this.y+20>=entank.y&&this.y+20<=entank.y+20 ){
//							bool=true;
//						}
//						if(this.x>=entank.x && this.x<=entank.x+30 
//								&&this.y+20>=entank.y&&this.y+20<=entank.y+20 ){
//							bool= true;
//						}
//					}
//				}
//			}
//			break;
//		default:
//			break;
//		}
//		
//		return bool;
//	}
//	
	//外部数据传入，可以想到用set语句。
	public void setEts(Vector<EnemyTank> ets)
	{
		this.ets=ets;
	}
	
	/*
	public void shotHero()
	{	
		
//		shot = new Shot(x, type)
		switch (this.direct) {
		case 0:
			shot = new Shot(x+10, y,0);
			ss.add(shot);
			break;
		case 1:
			shot = new Shot(x, y+10,1);
			ss.add(shot);
			break;
		case 2:
			shot = new Shot(x+10, y+30,2);
			ss.add(shot);
			break;
		case 3:
			shot = new Shot(x+30, y+10,3);
			ss.add(shot);
			break;
		default:
			break;
		}
		Thread t = new Thread(shot); 
		t.start();
	}
	*/
	
	@Override
	//随机方向并且运动
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			
			/*
			 结构替换：
			 try {
				Thread.sleep(50);	
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			switch (this.direct) {
			case 0:
				
				y-=speed;
				break;
			 换成下面的形式
			 */
			
			switch (this.direct) {
			case 0:
				for (int i = 0; i <30; i++) {
					if (y>0 ) {
						y-=speed;
					}	
					try {
						Thread.sleep(50);	
					} catch (Exception e) {
						e.printStackTrace();
						// TODO: handle exception
					}
				}
				break;
			case 1:	
				for (int i = 0; i <30; i++) {
					if(x>0)
					{	
						x-=speed;
					}
					try {
						Thread.sleep(50);	
					} catch (Exception e) {
						e.printStackTrace();
						// TODO: handle exception
					}
				}
				break;
			case 2:
				for (int i = 0; i <30; i++) {
					if(y<300)
					{
						y+=speed;
					}
					try {
						Thread.sleep(50);	
					} catch (Exception e) {
						e.printStackTrace();
						// TODO: handle exception
					}
				}
				break;
			case 3:
				for (int i = 0; i <30; i++) {
					if(x<400)
					{
						x+=speed;
					}
					try {
						Thread.sleep(50);	
					} catch (Exception e) {
						e.printStackTrace();
						// TODO: handle exception
					}
				}
				break;
			default:
				break;
			}
			
			//随机生成方向
			this.direct=(int)(Math.random()*4);
			if (this.isLive==false) {
				break;
			}	
			if (this.isLive==false) {
				break;
			}
			if(this.isLive)
			{
				if(this.ss.size()<=5)
				{
					Shot shot  = null;
					System.out.println(this.ss.size());
					switch (this.direct) {
					case 0:
						shot = new Shot(this.x+10, this.y,0);
						this.ss.add(shot);
						break;
					case 1:
						shot = new Shot(this.x, this.y+10,1);
						this.ss.add(shot);
						break;
					case 2:
						shot = new Shot(this.x+10, this.y+30,2);
						this.ss.add(shot);
						break;
					case 3:
						shot = new Shot(this.x+30, this.y+10,3);
						this.ss.add(shot);
						break;
					default:
						break;
					}
					Thread t=new Thread(shot);
					t.start();
				}
			}
			
		}
	}
	
}

class Hero extends Tank
{
	//
//	int speed=0;
	Shot shot=null;
//	boolean isLive=true;
	Vector<Shot> s = new Vector<Shot>();
	public void shotEn()
	{	
		
//		shot = new Shot(x, type)
		switch (this.direct) {
		case 0:
			shot = new Shot(x+10, y,0);
			s.add(shot);
			break;
		case 1:
			shot = new Shot(x, y+10,1);
			s.add(shot);
			break;
		case 2:
			shot = new Shot(x+10, y+30,2);
			s.add(shot);
			break;
		case 3:
			shot = new Shot(x+30, y+10,3);
			s.add(shot);
			break;
		default:
			break;
		}
		Thread t = new Thread(shot); 
		t.start();
	}
	public Hero(int x,int y)
	{
		super(x,y);
	}
	
	//move up 
	public void moveUp()
	{
		if(y>0)
		{
			y=y-speed;
		}
	}
	public void moveDown()
	{
		if(y<300)
		{
			y=y+speed;
		}
	}
	public void moveLeft()
	{
		if(x>0)
		{
			x=x-speed;
		}
	}
	public void moveRight()
	{
		if(x<400)
		{
			x=x+speed;
		}
	}
}
