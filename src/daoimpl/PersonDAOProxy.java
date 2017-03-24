/**    
 *  name：PersonDAOProxy   
 *  description：   
 *  author：Lcrit_Z   
 *  date：2017年3月23日 下午3:39:02 
 *  @version 
 */
package daoimpl;

import java.util.ArrayList;
import java.util.List;

import dao.Person;
import dao.PersonDao;
import util.DatabaseConnection;

/**
 *   @date：2017年3月23日 下午3:39:02 
 *  @author Lcrit_Z
 *  description：   
 */
public class PersonDAOProxy implements PersonDao{
	private DatabaseConnection dbc = null;
	private PersonDao persondao = null;
	/**
	 * 
	 */
	public PersonDAOProxy() {
		this.dbc = new DatabaseConnection();
		this.persondao = new PersonDAOImpl(this.dbc.getConn());
	}
	/* (non-Javadoc)
	 * @see dao.PersonDao#doCreate(dao.Person)
	 */
	@Override
	public boolean doCreate(Person p) throws Exception {
		boolean flag = false;
		try {
			flag = this.persondao.doCreate(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.dbc.close();
		}
		
		return flag;
	}

	/* (non-Javadoc)
	 * @see dao.PersonDao#doUpdate(dao.Person)
	 */
	@Override
	public boolean doUpdate(Person p) throws Exception {

		boolean flag = false;
		try {
			flag = this.persondao.doUpdate(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.dbc.close();
		}
		
		return flag;
	
	}

	/* (non-Javadoc)
	 * @see dao.PersonDao#doDelete(int)
	 */
	@Override
	public boolean doDelete(int pid) throws Exception {

		boolean flag = false;
		try {
			flag = this.persondao.doDelete(pid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.dbc.close();
		}
		
		return flag;
	
	}

	/* (non-Javadoc)
	 * @see dao.PersonDao#searchPerson(int)
	 */
	@Override
	public Person searchPerson(int pid) throws Exception {
		Person p = null;

		try {
			p = this.persondao.searchPerson(pid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.dbc.close();
		}
		
		return p;
	
		
	}

	/* (non-Javadoc)
	 * @see dao.PersonDao#searchAll(java.lang.String)
	 */
	@Override
	public List<Person> searchAll(String keyWord) throws Exception {
		List<Person> allPerson = new ArrayList<Person>();

		try {
			allPerson = this.persondao.searchAll(keyWord);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.dbc.close();
		}
	
		return allPerson;
	}

}
