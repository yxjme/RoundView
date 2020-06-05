package com.yxjme.flycoroundview.sqllite;


import com.yxjme.flycoroundview.activity.MyApp;
import java.util.List;

public class UserManager {


    private static UserManager manager;

    private UserBeanDao dao;

    private UserManager(){
        dao = MyApp.getDaoSession().getUserBeanDao();
    }

    public static UserManager newInstance(){
        if (null == manager){
            synchronized (UserManager.class){
                if (null == manager){
                    manager=new UserManager();
                }
            }
        }
        return manager ;
    }




    /**
     * 插入一条记录，表里面要没有与之相同的记录
     *
     */
    public long insert(UserBean userBean){
        return  dao.insert(userBean);
    }




    /**
     * 更新数据
     * @param userBean
     */
    public void update(UserBean userBean){
        UserBean mOldPersonInfor = dao.queryBuilder()
                        .where(UserBeanDao.Properties.Id.eq(userBean.getId()))
                        .build()
                        .unique();//拿到之前的记录
        if(mOldPersonInfor != null){
            mOldPersonInfor.setName("张三");
            dao.update(mOldPersonInfor);
        }
    }



    /**
     * 按条件查询数据
     */
    public List<UserBean> searchByWhere(String wherecluse){
        List<UserBean>personInfors = (List<UserBean>) dao.queryBuilder().where(UserBeanDao.Properties.Name.eq(wherecluse)).build().unique();
        return personInfors;
    }



    /**
     * 查询所有数据
     */
    public List<UserBean> searchAll(){
        List<UserBean>personInfors=dao.queryBuilder().list();
        return personInfors;
    }



    /**
     * 删除数据
     */
    public void delete(String wherecluse){
        dao.queryBuilder().where(UserBeanDao.Properties.Name.eq(wherecluse)).buildDelete().executeDeleteWithoutDetachingEntities();
    }



    /**
     * 刪除所以
     */
    public void delete(){
        dao.deleteAll();
    }

}
