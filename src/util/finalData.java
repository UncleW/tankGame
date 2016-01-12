package util;

public interface finalData {
	
	//坦克初始位置
	static int heroT_x=190;
	static int heroT_y=200;
	
	
	//̹坦克活动界面宽高
	static int tankPanWidth=400;
	static int tankPanHeight=300;
	
	//̹坦克占位宽高
	static int tankHeight=30;
	static int tankwidth=20;
	
	//速度设定
	static int speedLevel_1=5;//玩家坦克速度
	static int speedLevel_2=2;//敌人一号坦克速度
	static int speedLevel_3=3;
	static int speedLevel_4=4;
	static int bulletSpeed=2;
	//̹坦克种类
	static int heroTankType=0;
	static int enemyTankType=1;
	
	//敌人坦克数量
	static int enemyTanknum=3;
	
	
	//̹方向设定
	static int direction_up=0;
	static int direction_right=1;
	static int direction_down=2;
	static int direction_left=3;
	
	//敌人的各种概率
	static int moveChance=80;
	static int shootChance=20;
	
}
