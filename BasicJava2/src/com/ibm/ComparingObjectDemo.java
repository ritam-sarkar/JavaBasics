/**
 * 
 */
package com.ibm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ritam
 *
 */
public class ComparingObjectDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BankAccount acc1 = new BankAccount(2, 200);
		BankAccount acc2 = new BankAccount(2, 200);
		System.out.println(acc1 == acc2);
		System.out.println(acc1.equals(acc2));
		List<BankAccount> myArrList = new ArrayList<BankAccount>();
		myArrList.add(acc1);
		System.out.println(myArrList.contains(acc2));
	}

}
class BankAccount{
	private int accno;
	private long ammount;
	public int getAccno() {
		return accno;
	}
	
	public BankAccount(int accno, long ammount) {
		super();
		this.accno = accno;
		this.ammount = ammount;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}
	public long getAmmount() {
		return ammount;
	}
	public void setAmmount(long ammount) {
		this.ammount = ammount;
	}
	@Override
	public boolean equals(Object ob){
		if(ob == null){
			return false;
		}
		if(ob instanceof BankAccount){
			BankAccount b = (BankAccount)ob;
			if(b == this){
				return true;
			}else if(this.accno == b.getAccno() && this.ammount == b.ammount){
				return true;
			}
			else{
				return false;
			}
		}
		return false;
		
	}
	
}
