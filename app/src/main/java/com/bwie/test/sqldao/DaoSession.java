package com.bwie.test.sqldao;

import com.bwie.test.bean.DataBean;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

public class DaoSession extends AbstractDaoSession {
    private final DaoConfig dataBeanDaoConfig;
    private final DataBeanDao dataBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> daoConfigMap) {
        super(db);
        dataBeanDaoConfig = daoConfigMap.get(DataBeanDao.class).clone();
        dataBeanDaoConfig.initIdentityScope(type);
        dataBeanDao = new DataBeanDao(dataBeanDaoConfig, this);
        registerDao(DataBean.class, dataBeanDao);
    }
    
    public void clear() {
        dataBeanDaoConfig.clearIdentityScope();
    }

    public DataBeanDao getDataBeanDao() {
        return dataBeanDao;
    }
}
