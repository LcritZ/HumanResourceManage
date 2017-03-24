/**    
 *  name：DAOFactory   
 *  description：   
 *  author：Lcrit_Z   
 *  date：2017年3月23日 下午4:25:35 
 *  @version 
 */
package daoimpl;

import dao.PersonDao;

/**
 *   @date：2017年3月23日 下午4:25:35 
 *  @author Lcrit_Z
 *  description：   
 */
public class DAOFactory {
	public static PersonDao getPersonDAOInstance(){
		return new PersonDAOProxy();
	}
}
