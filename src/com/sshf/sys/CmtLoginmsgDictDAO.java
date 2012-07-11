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
 * CmtLoginmsgDict entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.ssh.sys.CmtLoginmsgDict
 * @author MyEclipse Persistence Tools
 */

public class CmtLoginmsgDictDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(CmtLoginmsgDictDAO.class);
	// property constants
	public static final String TEAM_ID = "teamId";
	public static final String LOGIN_NAME = "loginName";
	public static final String LOGIN_PWD = "loginPwd";
	public static final String LOGIN_PHONE = "loginPhone";
	public static final String LOGIN_DESC = "loginDesc";

	protected void initDao() {
		// do nothing
	}

	public void save(CmtLoginmsgDict transientInstance) {
		log.debug("saving CmtLoginmsgDict instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CmtLoginmsgDict persistentInstance) {
		log.debug("deleting CmtLoginmsgDict instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CmtLoginmsgDict findById(java.lang.String id) {
		log.debug("getting CmtLoginmsgDict instance with id: " + id);
		try {
			CmtLoginmsgDict instance = (CmtLoginmsgDict) getHibernateTemplate()
					.get("com.ssh.sys.CmtLoginmsgDict", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CmtLoginmsgDict instance) {
		log.debug("finding CmtLoginmsgDict instance by example");
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
		log.debug("finding CmtLoginmsgDict instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CmtLoginmsgDict as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTeamId(Object teamId) {
		return findByProperty(TEAM_ID, teamId);
	}

	public List findByLoginName(Object loginName) {
		return findByProperty(LOGIN_NAME, loginName);
	}

	public List findByLoginPwd(Object loginPwd) {
		return findByProperty(LOGIN_PWD, loginPwd);
	}

	public List findByLoginPhone(Object loginPhone) {
		return findByProperty(LOGIN_PHONE, loginPhone);
	}

	public List findByLoginDesc(Object loginDesc) {
		return findByProperty(LOGIN_DESC, loginDesc);
	}

	public List findAll() {
		log.debug("finding all CmtLoginmsgDict instances");
		try {
			String queryString = "from CmtLoginmsgDict";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CmtLoginmsgDict merge(CmtLoginmsgDict detachedInstance) {
		log.debug("merging CmtLoginmsgDict instance");
		try {
			CmtLoginmsgDict result = (CmtLoginmsgDict) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CmtLoginmsgDict instance) {
		log.debug("attaching dirty CmtLoginmsgDict instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CmtLoginmsgDict instance) {
		log.debug("attaching clean CmtLoginmsgDict instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CmtLoginmsgDictDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CmtLoginmsgDictDAO) ctx.getBean("CmtLoginmsgDictDAO");
	}
}