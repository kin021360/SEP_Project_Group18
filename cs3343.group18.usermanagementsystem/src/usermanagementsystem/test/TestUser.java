package usermanagementsystem.test;

import org.junit.Test;
import usermanagementsystem.datastructure.*;
import usermanagementsystem.exception.ExInvaildEnumValue;
import usermanagementsystem.exception.ExIsNullOrEmpty;


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
    public void testUserAddPermission() throws ExIsNullOrEmpty {
        User userTest;
        User.UserBuilder builder = new User.UserBuilder();
        userTest = builder.build();
        userTest.addPermission(EnumPermission.ListUsers);
        boolean expected = userTest.hasPermission(EnumPermission.ListUsers);
        assertEquals(true, expected);

    }

    @Test
    public void testUserRemovePermission() throws ExIsNullOrEmpty {
        User userTest;
        User.UserBuilder builder = new User.UserBuilder();
        userTest = builder.build();
        userTest.addPermission(EnumPermission.ListUsers);
        userTest.removePermission(EnumPermission.ListUsers);
        boolean expected = userTest.hasPermission(EnumPermission.ListUsers);
        assertEquals(false, expected);

    }

    @Test
    public void testUserShowAllPermission() throws ExIsNullOrEmpty {
        User userTest;
        String expected;
        User.UserBuilder builder = new User.UserBuilder();
        userTest = builder.build();
        userTest.addPermission(EnumPermission.ListUsers);
        expected = userTest.showAllPermissions();
        String result = "         ListUsers  ---   1" + "\n";
        assertEquals(result, expected);
    }

    @Test
    public void testUserEmail() throws ExIsNullOrEmpty {
        User userTest;
        String expected;
        User.UserBuilder builder = new User.UserBuilder();
        builder.email("abc@test.com");
        userTest = builder.build();
        expected = userTest.getEmail();
        String result = "abc@test.com";
        assertEquals(result, expected);
    }

    @Test
    public void testUserPosition() throws ExIsNullOrEmpty {
        User userTest;
        EnumPosition expected;
        User.UserBuilder builder = new User.UserBuilder();
        builder.position(EnumPosition.ProductOwner);
        userTest = builder.build();
        expected = userTest.getPosition();
        assertEquals(EnumPosition.ProductOwner, expected);
    }

    @Test
    public void testUserDepartment() throws ExIsNullOrEmpty {
        User userTest;
        EnumDepartment expected;
        User.UserBuilder builder = new User.UserBuilder();
        builder.departmentOf(EnumDepartment.Sales);
        userTest = builder.build();
        expected = userTest.getDepartmentOf();
        assertEquals(EnumDepartment.Sales, expected);
    }

    @Test
    public void testUserIsAdmin() throws ExIsNullOrEmpty {
        User userTest;
        boolean expected;
        User.UserBuilder builder = new User.UserBuilder();
        builder.isAdmin(true);
        userTest = builder.build();
        expected = userTest.isAdmin();
        assertEquals(true, expected);
    }

    @Test
    public void testUserStrIsNullOrEmpty_1() throws ExIsNullOrEmpty {
        User.UserBuilder builder = new User.UserBuilder();
        String expected = null;
        try {
            builder.userName("");

        } catch (ExIsNullOrEmpty e) {
            expected = e.getMessage();
        }

        assertEquals("userName is null or empty", expected);
    }

    @Test
    public void testUserStrIsNullOrEmpty_2() throws ExIsNullOrEmpty {

        User.UserBuilder builder = new User.UserBuilder();
        String expected = null;
        try {
            builder.userName(null);

        } catch (ExIsNullOrEmpty e) {
            expected = e.getMessage();
        }

        assertEquals("userName is null or empty", expected);
    }

    @Test
    public void testUserToSupervisor() throws ExIsNullOrEmpty {
        User userTest;
        Supervisor expected;
        User.UserBuilder builder = new User.UserBuilder();
        builder.userName("supervisor")
                .gender(EnumGender.Male)
                .departmentOf(EnumDepartment.Technology)
                .password("abc")
                .position(EnumPosition.ProductOwner)
                .email("supervisor@test.com")
                .isAdmin(true);
        userTest = builder.build();
        expected = userTest.toSupervisor();
        assertEquals(userTest.toString(), expected.toString());
        assertEquals(true, expected.isSupervisor());
    }

    @Test
    public void testUserAssignSupervisor_1() throws ExIsNullOrEmpty {
        User userTest;
        boolean expected;
        User.UserBuilder builder = new User.UserBuilder();
        builder.userName("supervisor")
                .departmentOf(EnumDepartment.Technology)
                .password("abc")
                .position(EnumPosition.ProductOwner)
                .email("supervisor@test.com")
                .isAdmin(true);
        userTest = builder.build();
        expected = userTest.assignSupervisor(userTest.toSupervisor());
        assertEquals(true, expected);
    }

    @Test
    public void testUserAssignSupervisor_2() throws ExIsNullOrEmpty {
        User userTest;
        boolean expected;
        User.UserBuilder builder = new User.UserBuilder();
        builder.userName("supervisor")
                .departmentOf(EnumDepartment.Technology)
                .password("abc")
                .position(EnumPosition.ProductOwner)
                .email("supervisor@test.com")
                .isAdmin(true);
        userTest = builder.build();
        expected = userTest.assignSupervisor(null);
        assertEquals(false, expected);
    }

    @Test
    public void testUserBuild() throws ExIsNullOrEmpty {
        User userTest;
        User.UserBuilder builder = new User.UserBuilder();
        builder.userName("username");
        userTest = builder.build();
        assertEquals(null,userTest.getDepartmentOf());

    }


}

