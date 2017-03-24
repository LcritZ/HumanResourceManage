/**    
 *  name：Person   
 *  description：   
 *  author：Lcrit_Z   
 *  date：2017年3月23日 上午10:50:34 
 *  @version 
 */
package dao;

/**
 *   @date：2017年3月23日 上午10:50:34 
 *  @author Lcrit_Z
 *  description：   
 */
public class Person {
	private int pid;
	private String name;
	private int age;
	private String job;
	private double salary;
	
	/**
	 * 
	 */
	public Person() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public Person(int pid,String name, int age, String job,double salary){
		super();
		this.pid = pid;
		this.name = name;
		this.age = age;
		this.job = job;
		this.salary = salary;
	}

	/**
	 * @return the pid
	 */
	public int getPid() {
		return pid;
	}

	/**
	 * @param pid the pid to set
	 */
	public void setPid(int pid) {
		this.pid = pid;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the job
	 */
	public String getJob() {
		return job;
	}

	/**
	 * @param job the job to set
	 */
	public void setJob(String job) {
		this.job = job;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	

}
