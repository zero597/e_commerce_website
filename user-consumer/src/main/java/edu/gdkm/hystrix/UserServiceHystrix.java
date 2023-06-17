package edu.gdkm.hystrix;

import edu.gdkm.model.User;
import edu.gdkm.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserServiceHystrix implements UserService {
    @Override
    public int register(String upassword, String uname, String usex) {
        return 0;
    }

    @Override
    public User login(String uname) {
        return null;
    }
}
