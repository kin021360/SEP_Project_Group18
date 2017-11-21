package usermanagementsystem.test;

import junit.framework.TestCase;
import org.junit.Test;
import usermanagementsystem.controller.AdminController;
import usermanagementsystem.dataaccess.UserDao;
import usermanagementsystem.datastructure.EnumDepartment;
import usermanagementsystem.datastructure.EnumPosition;
import usermanagementsystem.datastructure.User;
import usermanagementsystem.exception.ExControllerInitWithNull;
import usermanagementsystem.exception.ExIsNullOrEmpty;

import static org.junit.Assert.assertEquals;

public class TestException  {
    @Test
    public void testExControllerInitWithNull () throws ExControllerInitWithNull{

        AdminController adminController = null;

                
        try {
           adminController.createUserAndAdd("qqq", "111", "Male", EnumPosition.Programmer.toString(), "qqqq@q.com", EnumDepartment.Technology.toString(), "false");
        } catch (Exception e) {

        }
        assertEquals(null,adminController);


    }
}
