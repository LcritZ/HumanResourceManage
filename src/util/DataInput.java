/**    
 *  name：DataInput   
 *  description：   
 *  author：Lcrit_Z   
 *  date：2017年3月23日 下午4:32:29 
 *  @version 
 */
package util;

import java.util.Scanner;
/**
 *   @date：2017年3月23日 下午4:32:29 
 *  @author Lcrit_Z
 *  description：   
 */
public class DataInput {
	public Scanner sc;
	
	public DataInput() {
		this.sc = new Scanner(System.in);		
	}
	
	public String getKeyWords(String info) {
		String str = null;
		System.out.println(info);
		if (this.sc.hasNext()) {
			str = this.sc.nextLine();
		}
		return str;
		
	}
	
	public int getChoice(String info,String errmsg) {
		int choice = -1;
		System.out.println(info);
		if (this.sc.hasNextInt()) {
			//System.out.println(this.sc.nextInt());
			choice = this.sc.nextInt();
		}else {
			System.out.println(errmsg);
		}
		return choice;
		
	}
	
	public double getSalary(String info,String errmsg) {
		double salary = 0;
		System.out.println(info);
		if (this.sc.hasNextDouble()) {
			salary = this.sc.nextDouble();
		}else {
			System.out.println(errmsg);
		}
		
		return salary;
		
	}
}
