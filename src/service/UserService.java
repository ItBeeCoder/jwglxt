package service;

import dao.UserDao;
import entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaozhi on 2017/6/20.
 */
public class UserService {

    //添加用户
    public static void addUser(String username,String psw) throws Exception{
        User user = new User();
        if(username!=null&&!"".equals(username)&&psw!=null&&!"".equals(psw)){
            user.setUsername(username);
            user.setPsw(psw);
        }
        UserDao userDao = new UserDao();
        userDao.add(user);

    }

    //查询所有用户
    public static List<User> listAll() throws Exception{
        List<User> userList = new ArrayList<User>();
        UserDao userDao = new UserDao();
        userList = userDao.list();
        return userList;
    }

    //根据id查询用户
    public static User queryById(int id) throws  Exception{
        User user = new User();
        UserDao userDao = new UserDao();
        if(id >0){
            user = userDao.queryById(id);
        }
        return user;
    }

    //修改用户密码
    public static void alterPsw() throws Exception{

    }

    //删除用户
    public static void del(int id) throws Exception{
        UserDao userDao = new UserDao();
        if(id>0){
            userDao.del(id);
        }

    }

    //更新用户
    public static void update(int id,String username,String psw ) throws  Exception{
        UserDao userDao = new UserDao();
        User user = new User();
        if(id>0&&username!=null&&!"".equals(username)&&psw!=null&&!"".equals(psw)){
            user.setId(id);
            user.setUsername(username);
            user.setPsw(psw);
            userDao.update(user);
        }
    }
}
