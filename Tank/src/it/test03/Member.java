package it.test03;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Vector;

//添加数据流用来保存游戏的数据
//
class Recoder
{
	//记录每一关坦克的数量
	private static int enNum=20;

	private static int myLive=3;
	private static FileWriter fw=null;
	private static BufferedWriter bw=null;
	public static int getEnNum() {
		return enNum;
	}

	public static void setEnNum(int enNum) {
		Recoder.enNum = enNum;
	}

	public static int getMyLive() {
		return myLive;
	}
	public static void keepRecording(){
		try {
			fw=new FileWriter("");
			bw=new BufferedWriter(fw);
			bw.write(enNum+"\r\n");	
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		finally{
			try {
				fw.close();
				bw.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	public static void setMyLive(int myLive) {
		Recoder.myLive = myLive;
	}
	public static void reduceEnBun(){
			if(enNum>0)enNum--;
	}
	public static void reduceMylive(){
			if(myLive>0)myLive--;
	}
	
}

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
	//0:up  1:left 2:down  3:right
	int direct=0;
	//0:Blue 1:yellow  2:
	int type=0;
	//speed
	int speed=2;
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
	boolean isLive = true;
	
	//子弹添加时间：刚创建的时候坦克的时候，敌人的子弹死亡之后
	Vector<Shot> ss = new Vector<Shot>();
	Shot shot = null;
	
	Vector<EnemyTank> ets=new Vector<EnemyTank>();
	
	public Vector<EnemyTank> getEts() {
		return ets;
	}

	public void setEts(Vector<EnemyTank> ets) {
		this.ets = ets;
	}

	public EnemyTank(int x,int y) {
		super(x,y);
		// TODO Auto-generated constructor stub
	}
	
	
	//随机方向并且运动
	public boolean isTouch(Vector<EnemyTank> ets){
		boolean b=false;
		for(int i=0;i<ets.size();i++){
			EnemyTank et=ets.get(i);
			if(et!=this){
				switch (this.direct) {
				case 0://up
					if(et.direct==0 ||et.direct==2){
						if(this.x>=et.x&&this.x<=et.x+20&&this.y>=et.y&&this.y<=et.y+30){
							b=true;
						}
						if(this.x+20>=et.x&&this.x+20<=et.x+20&&this.y>=et.y&&this.y<=et.y+30){
							b=true;
						}
					}		
					if(et.direct==1||et.direct==3)
					{
						if(this.x>=et.x&&this.x<=et.x+30&&this.y>=et.y&&this.y<=et.y+20){
							b=true;
						}
						if(this.x+20>=et.x&&this.x+30<=et.x+20&&this.y>=et.y&&this.y<=et.y+20){
							b=true;
						}
					}
					break;
				case 1://left
					if(et.direct==0 ||et.direct==2){
						if(this.x>=et.x&&this.x<=et.x+20&&this.y>=et.y&&this.y<=et.y+30){
							b=true;
						}
						if(this.x+20>=et.x&&this.x+20<=et.x+20&&this.y>=et.y&&this.y<=et.y+30){
							b=true;
						}
					}		
					if(et.direct==1||et.direct==3)
					{
						if(this.x>=et.x&&this.x<=et.x+30&&this.y+20>=et.y&&this.y+20<=et.y+20){
							b=true;
						}
						if(this.x+20>=et.x&&this.x+20<=et.x+20&&this.y+20>=et.y&&this.y+20<=et.y+20){
							b=true;
						}
					}
					break;
				case 2://down
					if(et.direct==0 ||et.direct==2){
						if(this.x>=et.x&&this.x<=et.x+20&&this.y+30>=et.y&&this.y+30<=et.y+30){
							b=true;
						}
						if(this.x+20>=et.x&&this.x+20<=et.x+20&&this.y+30>=et.y&&this.y+30<=et.y+30){
							b=true;
						}
					}		
					if(et.direct==1||et.direct==3)
					{
						if(this.x>=et.x&&this.x<=et.x+30&&this.y+20>=et.y&&this.y+20<=et.y+20){
							b=true;
						}
						if(this.x+20>=et.x&&this.x+20<=et.x+20&&this.y+30>=et.y&&this.y+30<=et.y+20){
							b=true;
						}
					}
					break;
				case 3://right
					if(et.direct==0 ||et.direct==2){
						if(this.x+30>=et.x&&this.x+30<=et.x+20&&this.y>=et.y&&this.y<=et.y+30){
							b=true;
						}
						if(this.x+30>=et.x&&this.x+30<=et.x+20&&this.y>=et.y&&this.y<=et.y+30){
							b=true;
						}
					}		
					if(et.direct==1||et.direct==3)
					{
						if(this.x+30>=et.x&&this.x<=et.x+30&&this.y+20>=et.y&&this.y+20<=et.y+20){
							b=true;
						}
						if(this.x+30>=et.x&&this.x+30<=et.x+20&&this.y+20>=et.y&&this.y+20<=et.y+20){
							b=true;
						}
					}
					break;
					
				default:
							break;
				}
			}
		}
		return b;
	}
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
					if (y>0&&!this.isTouch(ets)) {
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
					if(x>=0 && !this.isTouch(ets))
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
					if(y+50<300&&!this.isTouch(ets))
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
					if(x+30<400&&!this.isTouch(ets))
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
//					System.out.println(this.ss.size());
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
	boolean isLive=true;
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
