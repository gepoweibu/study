package study201901_07;

public class AandB {
	public static void main(String[] args) {
		Box box1=new Box();
		Box box2=new Box();
		Box boxTemp=new Box();
		box1.box="苹果";
		box2.box="香蕉";
		System.out.println("box1:"+box1.box+" box2:"+box2.box);
		boxTemp.box=box1.box;
		box1.box=box2.box;
		box2.box=boxTemp.box;
		System.out.println("box1:"+box1.box+" box2:"+box2.box);
		
	}

}
