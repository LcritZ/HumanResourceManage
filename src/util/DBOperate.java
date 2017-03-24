/**    
 *  name：ConstructPerson   
 *  description：   
 *  author：Lcrit_Z   
 *  date：2017年3月23日 下午4:45:04 
 *  @version 
 */
package util;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.lang.model.element.Element;

import dao.Person;
import daoimpl.DAOFactory;

/**
 *   @date：2017年3月23日 下午4:45:04 
 *  @author Lcrit_Z
 *  description：   
 */
public class DBOperate {
	/**
	 * 
	 */
	public static void insert() {
		Person person = new Person();
		DataInput input = new DataInput();
		String name = input.getKeyWords("please input name:");
		int age = input.getChoice("please input age", "age must be integer");
		double salary = input.getSalary("please input salary",
				"salary must be double ");
		String job = input.getKeyWords("please input job");
		person.setName(name);
		person.setAge(age);
		person.setJob(job);
		person.setSalary(salary);
		try {
			DAOFactory.getPersonDAOInstance().doCreate(person);
			System.out.println(name+" has been added");
		} catch (Exception e) {
			System.out.println("database insert failed"+name+"hasn't been added");
		}
	}
	
	public static void update() {
		Person person = null;
		DataInput input = new DataInput();
		int pid = input.getChoice("please input id", "id must be integer");
		
		try {
			person = DAOFactory.getPersonDAOInstance().searchPerson(pid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (person!=null) {
			System.out.println("id:"+pid+"now the name is"+person.getName()+" age : "+
					person.getAge()+" job: "+"salary :"+person.getSalary());
			System.out.println("what you want to update: 1:name,2: age,3:job, 4: salary.");
			int ch =-1;
			while(ch==-1){
				ch = input.getChoice("please input number", "input wrong");
			}
			switch (ch) {
			case 1:
				System.out.println();
				String new_name = input.getKeyWords("please input new name:");
				person.setName(new_name);
				break;
			case 2:
				System.out.println();
				int new_age = input.getChoice("please input new age:","input wrong");
				while(new_age==-1) {
					new_age = input.getChoice("please input new age:","input wrong");
				}
				person.setAge(new_age);
				break;
			case 3:
				System.out.println();
				String new_job = input.getKeyWords("please input new job: ");
				person.setJob(new_job);
				break;
			case 4:
				System.out.println();
				int new_salary = input.getChoice("please input new salary: ","input wrong");
				while(new_salary==-1) {
					new_age = input.getChoice("please input new salary:","input wrong");
				}
				person.setSalary(new_salary);
				break;
			default:
				break;
			}
			
			try {
				DAOFactory.getPersonDAOInstance().doUpdate(person);
				System.out.println("update success !");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("update failed !");
				e.printStackTrace();
			}
			
		}else {
			System.out.println("there is no infomation");
		}
	}
	
	public static void delete() {
		DataInput input = new DataInput();
		int pid = input.getChoice("please the person's id you want to delete", "input wrong");
		
		try {
			DAOFactory.getPersonDAOInstance().doDelete(pid);
			System.out.println("delete successfully !");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("delete failed !");
			e.printStackTrace();
		}
	}
	
	public static void searchById() {
		Person p = new Person();
		int id = new DataInput().getChoice("please input id", "id must be a number");
		
		try {
			p = DAOFactory.getPersonDAOInstance().searchPerson(id);
			System.out.println("search success!");
		} catch (Exception e) {
			System.out.println("search failed !");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("id"+p.getPid()+" name: "+p.getName()+" "+
				" age: "+p.getAge()+" job: "+p.getJob()+"  salary: "+p.getSalary());
	}
	
	public static void searchByInfo() {
		List<Person> personlist = null;
		String info = new DataInput().getKeyWords("please input keywords(such as name = 'Bob' or pid = 16): ");
		
		try {
			personlist = DAOFactory.getPersonDAOInstance().searchAll(info);
			System.out.println("search successfully !");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("search failed !");
			e.printStackTrace();
		}
		Iterator<Person> iter = personlist.iterator();
		while(iter.hasNext()){
			Person p = iter.next();
			System.out.println("id: "+p.getPid()+"  name: "+p.getName()+" "+
			"  age: "+p.getAge()+"  job: "+p.getJob()+"  salary: "+p.getSalary());
			
		}
		
	}
	
	
	public static void searchAll() {
		List<Person> personlist = null;		
		try {
			personlist = DAOFactory.getPersonDAOInstance().searchAll("");
			System.out.println("search successfully !");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("search failed !");
			e.printStackTrace();
		}
		Iterator<Person> iter = personlist.iterator();
		while(iter.hasNext()){
			Person p = iter.next();
			System.out.println("id"+p.getPid()+" name: "+p.getName()+" "+
			" age: "+p.getAge()+" job: "+p.getJob()+"  salary: ");
			
		}
		
	}
	
	
}
