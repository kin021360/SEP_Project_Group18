package usermanagementsystem.test;

import org.junit.Test;
import usermanagementsystem.datastructure.*;
import usermanagementsystem.exception.ExInvaildEnumValue;
import usermanagementsystem.exception.ExIsNullOrEmpty;

import java.util.Hashtable;

import static org.junit.Assert.assertEquals;

public class TestUser {


    @Test
    public void testUserGetUserName() throws ExInvaildEnumValue, ExIsNullOrEmpty {
        User userTest;
        User.UserBuilder builder = new User.UserBuilder();
        builder.userName("tester");
        userTest = builder.build();
        String expected = userTest.getUserName();
        assertEquals("tester", expected);

    }

    @Test
    public void testUserCheckPassword() throws ExInvaildEnumValue, ExIsNullOrEmpty {
        User userTest;
        User.UserBuilder builder = new User.UserBuilder();
        builder.password("abcabc");
        userTest = builder.build();
        boolean expected = userTest.checkPassword("abcabc");
        assertEquals(true, expected);

    }

    @Test
    public void testUserGetGender() throws ExInvaildEnumValue, ExIsNullOrEmpty {
        User userTest;
        User.UserBuilder builder = new User.UserBuilder();
        builder.gender(EnumGender.Male);
        userTest = builder.build();
        EnumGender expected = userTest.getGender();
        assertEquals(EnumGender.Male, expected);

    }

    @Test
    public void testUserChangePassword() throws ExInvaildEnumValue, ExIsNullOrEmpty {
        User userTest;
        User.UserBuilder builder = new User.UserBuilder();
        builder.password("abcabc");
        userTest = builder.build();
        userTest.changePassword("edgedg");
        boolean expected = userTest.checkPassword("edgedg");
        assertEquals(true, expected);

    }

    @Test
    public void testUserAddPermission() {
        User userTest;
        User.UserBuilder builder = new User.UserBuilder();
        userTest = builder.build();
        userTest.addPermission(EnumPermission.ListUsers);
        boolean expected = userTest.hasPermission(EnumPermission.ListUsers);
        assertEquals(true, expected);

    }
    @Test
    public void testUserRemovePermission() {
        User userTest;
        User.UserBuilder builder = new User.UserBuilder();
        userTest = builder.build();
        userTest.addPermission(EnumPermission.ListUsers);
        userTest.removePermission(EnumPermission.ListUsers);
        boolean expected = userTest.hasPermission(EnumPermission.ListUsers);
        assertEquals(false, expected);

    }
}
