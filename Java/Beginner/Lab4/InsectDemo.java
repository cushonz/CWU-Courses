
public class InsectDemo {
	public static void main(String args[]) {
		
		Grasshopper hopper = new Grasshopper();
		Beetle bee = new Beetle(true);
		
		//this will invoke the method from the class insect since
		//grasshopper extends insect
		hopper.setLifeSpanDays(10);
		hopper.setJumpDist(12.37);
		bee.setLifeSpanDays(12);
		bee.setStink(3);
		
		
		//display hopper
		System.out.println("Jump dist: "+hopper.getJumpDist()+"cm");
		System.out.println("Life span: "+hopper.getLifeSpan()+" days");
		System.out.println("Number of legs: "+hopper.getNumLegs()+"\n");
		
		//display bee
		System.out.println("Is a big stink:"+bee.getIsABigStink());
		System.out.println("Life span: "+bee.getLifeSpan()+" days");
		System.out.println("Number of legs: "+bee.getNumLegs());
	
	}
}
