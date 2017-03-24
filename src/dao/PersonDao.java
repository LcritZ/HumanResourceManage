/**    
 *  name：PersonDao   
 *  description：   
 *  author：Lcrit_Z   
 *  date：2017年3月23日 上午11:00:13 
 *  @version 
 */
package dao;

import java.util.List;
/**
 *   @date：2017年3月23日 上午11:00:13 
 *  @author Lcrit_Z
 *  description：   
 */
public interface PersonDao {
	
	
	/**
	 * 修改人事信息
	 * @param p
	 * @return
	 * @throws Exception
	 */
	public boolean doCreate(Person p) throws Exception;
	
	/**
	 * 更新人事信息
	 * @param p
	 * @return
	 * @throws Exception
	 */
	public boolean doUpdate(Person p) throws Exception;
	
	
	/**
	 * 根据pid删除
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	public boolean doDelete(int pid) throws Exception;
	
	/**
	 * 搜索信息
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	public Person searchPerson(int pid) throws Exception;
	
	/**
	 * 搜索全部信息
	 * @param keyWord
	 * @return
	 * @throws Exception
	 */
	public List<Person> searchAll(String keyWord) throws Exception;
	
	
}
