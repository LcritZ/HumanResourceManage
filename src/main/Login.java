/**    
 *  name：Login   
 *  description：   
 *  author：Lcrit_Z   
 *  date：2017年3月23日 下午4:27:34 
 *  @version 
 */
package main;

import util.DBOperate;
import util.DataInput;
/**
 *   @date：2017年3月23日 下午4:27:34 
 *  @author Lcrit_Z
 *  description：   
 */
public class Login {
	/**
	 * 
	 */
	public Login() {
		while(true){
			this.show();
		}
	}

	/**
	 * 
	 */
	private void show() {
		// TODO Auto-generated method stub
		System.out.println("=====人事管理系统=====");
		System.out.println("1:添加人员信息");
		System.out.println("2:更新人员信息");
		System.out.println("3:删除信息");
		System.out.println("4:查看信息");
		System.out.println("5:检索信息");
		System.out.println("6:查看数据库");
		System.out.println("0:exit\n\n\n");
		int choice = 0;
		choice = new DataInput().getChoice("please select: ", "please input number");
		switch (choice) {
		case 0:
			System.out.println("you have exit the system");
			System.exit(1);
			break;
		case 1:
			DBOperate.insert();
			break;
		case 2:
			DBOperate.update();
			break;
		case 3: 
			DBOperate.delete();
			break;
		case 4:
			DBOperate.searchById();
			break;
		case 5:
			DBOperate.searchByInfo();
			break;
		case 6:
			DBOperate.searchAll();
			break;
		default:
			System.err.print("input wrong !!");
		}
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Login();
	
	}

}
