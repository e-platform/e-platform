package com.sshf.sys;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * CmtLoginoprRd entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.ssh.sys.CmtLoginoprRd
 * @author MyEclipse Persistence Tools
 */

public class CmtLoginoprRdDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(CmtLoginoprRdDAO.class);
	// property constants
	public static final String LOGIN_NO = "loginNo";
	public static final String OP_CONTENT = "opContent";

	protected void initDao() {
		// do nothing
	}

	public void save(CmtLoginoprRd transientInstance) {
		log.debug("saving CmtLoginoprRd instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CmtLoginoprRd persistentInstance) {
		log.debug("deleting CmtLoginoprRd instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CmtLoginoprRd findById(java.lang.Long id) {
		log.debug("getting CmtLoginoprRd instance with id: " + id);
		try {
			CmtLoginoprRd instance = (CmtLoginoprRd) getHibernateTemplate()
					.get("com.ssh.sys.CmtLoginoprRd", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CmtLoginoprRd instance) {
		log.debug("finding CmtLoginoprRd instance by example");
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
		log.debug("finding CmtLoginoprRd instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CmtLoginoprRd as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByLoginNo(Object loginNo) {
		return findByProperty(LOGIN_NO, loginNo);
	}

	public List findByOpContent(Object opContent) {
		return findByProperty(OP_CONTENT, opContent);
	}

	public List findAll() {
		log.debug("finding all CmtLoginoprRd instances");
		try {
			String queryString = "from CmtLoginoprRd";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CmtLoginoprRd merge(CmtLoginoprRd detachedInstance) {
		log.debug("merging CmtLoginoprRd instance");
		try {
			CmtLoginoprRd result = (CmtLoginoprRd) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CmtLoginoprRd instance) {
		log.debug("attaching dirty CmtLoginoprRd instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CmtLoginoprRd instance) {
		log.debug("attaching clean CmtLoginoprRd instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CmtLoginoprRdDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CmtLoginoprRdDAO) ctx.getBean("CmtLoginoprRdDAO");
	}
}