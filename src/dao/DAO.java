/**
 * 
 */
package dao;

/**
 * @author thomas
 *
 */
public abstract class DAO<T> {
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public abstract T find(int id);
	
	
	/**
	 * 
	 * @param obj
	 * @return
	 */
	public abstract T create(T obj);
	
	
	/**
	 * 
	 * @param obj
	 * @return
	 */
	public abstract T update(T obj);
	
	
	/**
	 * 
	 * @param obj
	 */
	public abstract void delete(T obj);
	
	
}
