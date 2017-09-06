package generics.simple;

public class BoundGeneric1<T extends Number> {

	private T[] nums;

	public BoundGeneric1(T[] nums) {
		super();
		this.nums = nums;
	}
	public double average(){
		double sum = 0.0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i].doubleValue();
		}
		return sum/nums.length;
	}
	public T[] getNums() {
		return nums;
	}
	public void setNums(T[] nums) {
		this.nums = nums;
	}
	public boolean sameAvg(BoundGeneric1 ob){
		if(this.average() == ob.average()){
			return true;
		}else{
			return false;
		}
	}
	
}
