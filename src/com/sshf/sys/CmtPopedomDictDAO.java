package com.sshf.sys;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * CmtPopedomDict entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.ssh.sys.CmtPopedomDict
 * @author MyEclipse Persistence Tools
 */

public class CmtPopedomDictDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(CmtPopedomDictDAO.class);
	// property constants
	public static final String MOD_NAME = "modName";
	public static final String MOD_PATH = "modPath";
	public static final String MOD_DESC = "modDesc";

	protected void initDao() {
		// do nothing
	}

	public void save(CmtPopedomDict transientInstance) {
		log.debug("saving CmtPopedomDict instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CmtPopedomDict persistentInstance) {
		log.debug("deleting CmtPopedomDict instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CmtPopedomDict findById(java.lang.Long id) {
		log.debug("getting CmtPopedomDict instance with id: " + id);
		try {
			CmtPopedomDict instance = (CmtPopedomDict) getHibernateTemplate()
					.get("com.ssh.sys.CmtPopedomDict", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CmtPopedomDict instance) {
		log.debug("finding CmtPopedomDict instance by example");
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
		log.debug("finding CmtPopedomDict instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CmtPopedomDict as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByModName(Object modName) {
		return findByProperty(MOD_NAME, modName);
	}

	public List findByModPath(Object modPath) {
		return findByProperty(MOD_PATH, modPath);
	}

	public List findByModDesc(Object modDesc) {
		return findByProperty(MOD_DESC, modDesc);
	}

	public List findAll() {
		log.debug("finding all CmtPopedomDict instances");
		try {
			String queryString = "from CmtPopedomDict";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CmtPopedomDict merge(CmtPopedomDict detachedInstance) {
		log.debug("merging CmtPopedomDict instance");
		try {
			CmtPopedomDict result = (CmtPopedomDict) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CmtPopedomDict instance) {
		log.debug("attaching dirty CmtPopedomDict instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CmtPopedomDict instance) {
		log.debug("attaching clean CmtPopedomDict instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CmtPopedomDictDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CmtPopedomDictDAO) ctx.getBean("CmtPopedomDictDAO");
	}
}