package example;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.stat.Statistics;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Jan 26, 2011
 *@author wangys
 */
@SuppressWarnings("unchecked")
public class UserDaoImpl extends HibernateDaoSupport {
	@SuppressWarnings("unchecked")
	public List getList(final String hql) {
		getHibernateTemplate().setCacheQueries(true);
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				
				 

				Statistics message=session.getSessionFactory().getStatistics();  
				//session.getSessionFactory().evict(example.User.class);
				System.out.println("二级缓存命中数："+message.getSecondLevelCacheHitCount());  
				Query q = null;
				q = session.createQuery(hql);
				q.setCacheable(true);
				return q.list();
			}
		});
	}
	
	public void save(User user){
		getHibernateTemplate().save(user);
	}
	
	public void delete(long id){
		User user = findById(id);
		if(user != null)
			getHibernateTemplate().delete(user);
	}
	
	public User findById(long id){
		return (User)getHibernateTemplate().get("example.User",id);
	}
	
	public List<User> findByNmae(String name){
		return (List<User>) getHibernateTemplate().find("from User where userName=?",name);
	}
	
	public void update(User user){
		getHibernateTemplate().update(user);
	}

}
