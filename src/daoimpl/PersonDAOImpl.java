/**    
 *  name：PersonDAOImpl   
 *  description：   
 *  author：Lcrit_Z   
 *  date：2017年3月23日 上午11:37:17 
 *  @version 
 */
package daoimpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Person;
import dao.PersonDao;
/**
 *   @date：2017年3月23日 上午11:37:17 
 *  @author Lcrit_Z
 *  description：   
 */
public class PersonDAOImpl implements PersonDao{
	private Connection conn = null;
	/**
	 * 
	 */
	public PersonDAOImpl(Connection c) {
		// TODO Auto-generated constructor stub
		this.conn = c;
	}

	/* (non-Javadoc)
	 * @see dao.PersonDao#doCreate(dao.Person)
	 */
	@Override
	public boolean doCreate(Person p) throws Exception {
		boolean flag = false;
		PreparedStatement prestmt = null;
		String sql = "insert into emp(name,age,job,salary) values(?,?,?,?);" ;
		
		 try {
			prestmt = this.conn.prepareStatement(sql);
			 prestmt.setString(1, p.getName());
			 prestmt.setInt(2, p.getAge());
			 prestmt.setString(3, p.getJob());
			 prestmt.setDouble(4, p.getSalary());
			 int len = prestmt.executeUpdate();
			 if (len>0) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				prestmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}		
		return flag;
	}

	/* (non-Javadoc)
	 * @see dao.PersonDao#doUpdate(dao.Person)
	 */
	@Override
	public boolean doUpdate(Person p) throws Exception {
		boolean flag = false;
		PreparedStatement prestmt = null;
		String sql = "update emp set name = ?,age = ?,job = ?,salary = ? where pid = ? ";
		
		try {
			prestmt = this.conn.prepareStatement(sql);
			prestmt.setString(1, p.getName());
			prestmt.setInt(2, p.getAge());
			prestmt.setString(3, p.getJob());
			prestmt.setDouble(4, p.getSalary());
			prestmt.setInt(5, p.getPid());
			int len = prestmt.executeUpdate();
			if (len>0) {
				flag = true;
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (prestmt!=null) {
					prestmt.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		// TODO Auto-generated method stub
		return flag;
	}

	/* (non-Javadoc)
	 * @see dao.PersonDao#doDelete(int)
	 */
	@Override
	public boolean doDelete(int pid) throws Exception {
		boolean flag = false;
		PreparedStatement prestmt = null;
		String sql = "delete from emp where pid = ?";
		
		try {
			prestmt = this.conn.prepareStatement(sql);
			prestmt.setInt(1, pid);
			int len = prestmt.executeUpdate();
			if (len>0) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (prestmt!= null) {
					prestmt.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return flag;
	}

	/* (non-Javadoc)
	 * @see dao.PersonDao#searchPerson(int)
	 */
	@Override
	public Person searchPerson(int pid) throws Exception {
		Person person = new Person();
		String sql = "select * from emp where pid = "+Integer.toString(pid);
		PreparedStatement prestmt = null;
		ResultSet rs = null;
		
		try {
			prestmt = this.conn.prepareStatement(sql);
			rs = prestmt.executeQuery();
			while(rs.next()){
				person.setPid(rs.getInt("pid"));
				person.setName(rs.getString("name"));
				person.setAge(rs.getInt("age"));
				person.setJob(rs.getString("job"));
				person.setSalary(rs.getDouble("salary"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null){
					rs.close();
				}
				if (prestmt!=null) {
					prestmt.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return person;
	}

	/* (non-Javadoc)
	 * @see dao.PersonDao#searchAll(java.lang.String)
	 */
	@Override
	public List<Person> searchAll(String keyWord) throws Exception {
		List<Person> allPerson = new ArrayList<Person>() ;
		String sql= "";
		if (keyWord=="") {
			sql = "select* from emp ";
		}else {
			sql = "select* from emp where "+keyWord;
		}
		
		PreparedStatement prestmt = null;
		ResultSet rs = null;
		
		try {
			prestmt = this.conn.prepareStatement(sql);
			//prestmt.setString(1, keyWord);
			rs = prestmt.executeQuery();
			while(rs.next()){
				Person p = new Person();
				p.setPid(rs.getInt("pid"));
				p.setName(rs.getString("name"));
				p.setAge(rs.getInt("age"));
				p.setJob(rs.getString("job"));
				p.setSalary(rs.getDouble("salary"));
				allPerson.add(p);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (rs!=null) {
					rs.close();
				}
				if (prestmt!=null) {
					prestmt.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return allPerson;
	}
	
}
