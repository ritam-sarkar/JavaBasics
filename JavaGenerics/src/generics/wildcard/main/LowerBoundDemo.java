/**
 * 
 */
package generics.wildcard.main;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ritam
 *
 */
public class LowerBoundDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<? super Phone> phoneList = new ArrayList<Gift>();
		List<? super Gift> giftList = new ArrayList<Gift>();
		List<? super Mobile> mobileList = new ArrayList<Phone>();
		Phone phone = new Phone();
		Gift gift = new Gift();
		Mobile mobile = new Mobile();
		phone.setName("Phone");
		gift.setName("gift");
		mobile.setName("mobile");
		phoneList.add(phone);
		giftList.add(gift);
		mobileList.add(mobile);
		//mobileList.add(phone);
		phoneList.add(mobile);
		
		
	}

}
class Gift{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

class Phone extends Gift{
	
}
class Mobile extends Phone{
	
}
