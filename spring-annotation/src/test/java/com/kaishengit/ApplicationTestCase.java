package com.kaishengit;

import com.kaishengit.Application;
import com.kaishengit.BaseTestCase;
import com.kaishengit.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * @author jinjianghao
 * @date 2018/7/17
 */

public class ApplicationTestCase extends BaseTestCase {

    @Autowired
    private UserService userService;

    @Test
    public void testApplication(){

        userService.save();
    }


}
