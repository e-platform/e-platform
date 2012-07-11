package com.sshf.sys;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * CmtLoginroleRel entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.ssh.sys.CmtLoginroleRel
 * @author MyEclipse Persistence Tools
 */

public class CmtLoginroleRelDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(CmtLoginroleRelDAO.class);

	// property constants

	protected void initDao() {
		// do nothing
	}

	public void save(CmtLoginroleRel transientInstance) {
		log.debug("saving CmtLoginroleRel instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CmtLoginroleRel persistentInstance) {
		log.debug("deleting CmtLoginroleRel instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CmtLoginroleRel findById(CmtLoginroleRelId id) {
		log.debug("getting CmtLoginroleRel instance with id: " + id);
		try {
			CmtLoginroleRel instance = (CmtLoginroleRel) getHibernateTemplate()
					.get("com.ssh.sys.CmtLoginroleRel", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CmtLoginroleRel instance) {
		log.debug("finding CmtLoginroleRel instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding CmtLoginroleRel instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CmtLoginroleRel as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all CmtLoginroleRel instances");
		try {
			String queryString = "from CmtLoginroleRel";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CmtLoginroleRel merge(CmtLoginroleRel detachedInstance) {
		log.debug("merging CmtLoginroleRel instance");
		try {
			CmtLoginroleRel result = (CmtLoginroleRel) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CmtLoginroleRel instance) {
		log.debug("attaching dirty CmtLoginroleRel instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CmtLoginroleRel instance) {
		log.debug("attaching clean CmtLoginroleRel instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CmtLoginroleRelDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CmtLoginroleRelDAO) ctx.getBean("CmtLoginroleRelDAO");
	}
}