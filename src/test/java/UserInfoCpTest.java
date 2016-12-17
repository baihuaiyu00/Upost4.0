import cn.xupt.entity.User;
import cn.xupt.mapper.UserMapper;
import cn.xupt.service.UserService;
import cn.xupt.serviceImpl.UserServiceImpl;

/**
 * Created by Admin on 2016/11/13.
 */
public class UserInfoCpTest {


    public static void main(String[] args){
        UserService userService = new UserServiceImpl();
        UserMapper userMapper = null;
        User u = new User();
        u.setSchool_id("1001");
        u.setHead("d:/123.jpg");
        u.setSignature("i'm a bird");
        u.setMajor("computer science");
        u.setStu_nickname("Bob");
        u.setStu_num("12333");
//        userService.userInfoComplete(u);
//        userMapper.userInfoComplete(u);
    }

}
