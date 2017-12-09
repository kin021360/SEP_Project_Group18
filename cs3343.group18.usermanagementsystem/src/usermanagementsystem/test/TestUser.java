package usermanagementsystem.test;

import org.junit.Test;
import usermanagementsystem.datastructure.*;
import usermanagementsystem.exception.ExIsNullOrEmpty;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.*;

public class TestUser {
    private String userName = "t1";
    private String password = "123abc";
    private String email = "zzzz@zzz.com";
    private EnumGender gender = EnumGender.Male;
    private EnumPosition position = EnumPosition.Engineer;
    private EnumDepartment department = EnumDepartment.Technology;

    @Test(expected = ExIsNullOrEmpty.class)
    public void testBuildUserOnlyUserName() throws ExIsNullOrEmpty {
        User.UserBuilder builder = new User.UserBuilder();
        builder.userName(userName)
                .build();
    }

    @Test(expected = ExIsNullOrEmpty.class)
    public void testBuildUserOnlyPassword() throws ExIsNullOrEmpty {
        User.UserBuilder builder = new User.UserBuilder();
        builder.password(password)
                .build();
    }

    @Test(expected = ExIsNullOrEmpty.class)
    public void testBuildUserOnlyEmail() throws ExIsNullOrEmpty {
        User.UserBuilder builder = new User.UserBuilder();
        builder.email(email)
                .build();
    }

    @Test(expected = ExIsNullOrEmpty.class)
    public void testBuildUserOnlyGender() throws ExIsNullOrEmpty {
        User.UserBuilder builder = new User.UserBuilder();
        builder.gender(gender)
                .build();
    }

    @Test(expected = ExIsNullOrEmpty.class)
    public void testBuildUserOnlyPosition() throws ExIsNullOrEmpty {
        User.UserBuilder builder = new User.UserBuilder();
        builder.position(position)
                .build();
    }

    @Test(expected = ExIsNullOrEmpty.class)
    public void testBuildUserOnlyDepartment() throws ExIsNullOrEmpty {
        User.UserBuilder builder = new User.UserBuilder();
        builder.departmentOf(department)
                .build();
    }

    @Test(expected = ExIsNullOrEmpty.class)
    public void testBuildUserWithEmptyString1() throws ExIsNullOrEmpty {
        User.UserBuilder builder = new User.UserBuilder();
        builder.userName("");
    }

    @Test(expected = ExIsNullOrEmpty.class)
    public void testBuildUserWithEmptyString2() throws ExIsNullOrEmpty {
        User.UserBuilder builder = new User.UserBuilder();
        builder.password("");
    }

    @Test(expected = ExIsNullOrEmpty.class)
    public void testBuildUserWithEmptyString3() throws ExIsNullOrEmpty {
        User.UserBuilder builder = new User.UserBuilder();
        builder.email("");
    }

    @Test(expected = ExIsNullOrEmpty.class)
    public void testBuildUserWithNullValue1() throws ExIsNullOrEmpty {
        User.UserBuilder builder = new User.UserBuilder();
        builder.userName(null);
    }

    @Test(expected = ExIsNullOrEmpty.class)
    public void testBuildUserWithNullValue2() throws ExIsNullOrEmpty {
        User.UserBuilder builder = new User.UserBuilder();
        builder.password(null);
    }

    @Test(expected = ExIsNullOrEmpty.class)
    public void testBuildUserWithNullValue3() throws ExIsNullOrEmpty {
        User.UserBuilder builder = new User.UserBuilder();
        builder.email(null);
    }

    @Test(expected = ExIsNullOrEmpty.class)
    public void testBuildUserWithNullValue4() throws ExIsNullOrEmpty {
        User.UserBuilder builder = new User.UserBuilder();
        builder.userName(userName)
                .password(password)
                .email(email)
                .gender(null)
                .position(position)
                .departmentOf(department)
                .build();
    }

    @Test(expected = ExIsNullOrEmpty.class)
    public void testBuildUserWithNullValue5() throws ExIsNullOrEmpty {
        User.UserBuilder builder = new User.UserBuilder();
        builder.userName(userName)
                .password(password)
                .email(email)
                .gender(gender)
                .position(null)
                .departmentOf(department)
                .build();
    }

    @Test(expected = ExIsNullOrEmpty.class)
    public void testBuildUserWithNullValue6() throws ExIsNullOrEmpty {
        User.UserBuilder builder = new User.UserBuilder();
        builder.userName(userName)
                .password(password)
                .email(email)
                .gender(gender)
                .position(position)
                .departmentOf(null)
                .build();
    }

    @Test
    public void testBuildUser() throws ExIsNullOrEmpty {
        User.UserBuilder builder = new User.UserBuilder();
        builder.userName(userName)
                .password(password)
                .email(email)
                .gender(gender)
                .position(position)
                .departmentOf(department);
        User expected = builder.build();

        assertEquals(userName, expected.getUserName());
        assertTrue(expected.checkPassword(password));
        assertFalse(expected.checkPassword("qqqqqqqqqq"));
        assertEquals(email, expected.getEmail());
        assertEquals(gender, expected.getGender());
        assertEquals(position, expected.getPosition());
        assertEquals(department, expected.getDepartmentOf());
        assertTrue(expected.getStaffId() > 0);
        assertNull(expected.getSupervisorInfo());
        assertFalse(expected.isAdmin());
        assertFalse(expected.isSupervisor());
        assertEquals(0, expected.getLoginFailTime());
        assertEquals(0, expected.getSuspensionTimeStamp());
        assertEquals(12, expected.getAnnualLeave());
        assertEquals(0, expected.getAnnualLeaveInfos().size());

        //admin
        expected = builder.isAdmin(true).build();
        assertTrue(expected.isAdmin());
    }

    @Test
    public void testUserPassword() throws ExIsNullOrEmpty {
        User.UserBuilder builder = new User.UserBuilder();
        builder.userName(userName)
                .password(password)
                .email(email)
                .gender(gender)
                .position(position)
                .departmentOf(department);
        User u = builder.build();

        String expectedPW = "ppp123";
        assertFalse(u.checkPassword(expectedPW));
        u.changePassword(expectedPW);
        assertTrue(u.checkPassword(expectedPW));
    }

    @Test
    public void testUserSetLoginSuspension() throws ExIsNullOrEmpty {
        User.UserBuilder builder = new User.UserBuilder();
        builder.userName(userName)
                .password(password)
                .email(email)
                .gender(gender)
                .position(position)
                .departmentOf(department);
        User u = builder.build();

        u.setLoginFailTime(3);
        assertEquals(3, u.getLoginFailTime());
        u.setSuspensionTimeStamp(1000);
        assertEquals(1000, u.getSuspensionTimeStamp());
    }

    @Test
    public void testUserAnnualLeave() throws ExIsNullOrEmpty, ParseException {
        User.UserBuilder builder = new User.UserBuilder();
        builder.userName(userName)
                .password(password)
                .email(email)
                .gender(gender)
                .position(position)
                .departmentOf(department);
        User u = builder.build();
        u.setAnnualLeave(14);

        assertEquals("You have no annual leave!", u.showAllAnnualLeaveInfos());
        AnnualLeaveInfo al = new AnnualLeaveInfo(14, new SimpleDateFormat("dd-MM-yyyy").parse("02-11-2017"), new SimpleDateFormat("dd-MM-yyyy").parse("15-11-2017"));
        assertTrue(u.addAnnualLeaveInfo(al, al.toString()));
        assertFalse(u.addAnnualLeaveInfo(al, al.toString()));

        assertTrue(u.showAllAnnualLeaveInfos().contains("14"));
        assertTrue(u.showAllAnnualLeaveInfos().contains("02-11-2017"));
        assertTrue(u.showAllAnnualLeaveInfos().contains("15-11-2017"));
    }

    @Test
    public void testUserPermission() throws ExIsNullOrEmpty {
        User.UserBuilder builder = new User.UserBuilder();
        builder.userName(userName)
                .password(password)
                .email(email)
                .gender(gender)
                .position(position)
                .departmentOf(department);
        User u = builder.build();
        EnumPermission expectedPermission = EnumPermission.ViewDocument;

        assertEquals("", u.showAllPermissions());
        assertFalse(u.hasPermission(expectedPermission));

        assertTrue(u.addPermission(expectedPermission));
        assertFalse(u.addPermission(expectedPermission));

        assertTrue(u.hasPermission(expectedPermission));
        assertTrue(u.showAllPermissions().contains(expectedPermission.name()));

        assertFalse(u.removePermission(EnumPermission.ListUsers));
        assertTrue(u.removePermission(expectedPermission));
        assertFalse(u.hasPermission(expectedPermission));
        assertEquals("", u.showAllPermissions());
    }

    @Test
    public void testUserToSupervisor() throws ExIsNullOrEmpty {
        User.UserBuilder builder = new User.UserBuilder();
        builder.userName(userName)
                .password(password)
                .email(email)
                .gender(gender)
                .position(position)
                .departmentOf(department);
        User u = builder.build();
        u.addPermission(EnumPermission.ListUsers);

        Supervisor expected = u.toSupervisor();
        assertEquals(userName, expected.getUserName());
        assertTrue(expected.checkPassword(password));
        assertEquals(email, expected.getEmail());
        assertEquals(gender, expected.getGender());
        assertEquals(position, expected.getPosition());
        assertEquals(department, expected.getDepartmentOf());
        assertEquals(u.getStaffId(), expected.getStaffId());
        assertNull(expected.getSupervisorInfo());
        assertFalse(expected.isAdmin());
        assertEquals(0, expected.getLoginFailTime());
        assertEquals(0, expected.getSuspensionTimeStamp());
        assertEquals(12, expected.getAnnualLeave());
        assertEquals(0, expected.getAnnualLeaveInfos().size());
        assertTrue(expected.hasPermission(EnumPermission.ListUsers));
    }

    @Test
    public void testUserAssignUnAssignSupervisor() throws ExIsNullOrEmpty {
        User.UserBuilder builder = new User.UserBuilder();
        builder.userName(userName)
                .password(password)
                .email(email)
                .gender(gender)
                .position(position)
                .departmentOf(department);
        User u = builder.build();
        Supervisor s = builder.userName("pppp").build().toSupervisor();

        assertFalse(u.assignSupervisor(null));
        assertTrue(u.assignSupervisor(s));

        assertFalse(u.assignSupervisor(s));
        u.unassignSupervisor();
        assertTrue(u.assignSupervisor(s));
    }

    @Test
    public void testUserToString() throws ExIsNullOrEmpty {
        User.UserBuilder builder = new User.UserBuilder();
        builder.userName(userName)
                .password(password)
                .email(email)
                .gender(gender)
                .position(position)
                .departmentOf(department);
        User u = builder.build();

        assertTrue(u.toString().contains(userName));
        assertTrue(u.toString().contains("" + u.getStaffId()));
        assertTrue(u.toString().contains(gender.name()));
        assertTrue(u.toString().contains(email));
        assertTrue(u.toString().contains(position.name()));
        assertTrue(u.toString().contains(department.name()));
        assertTrue(u.toString().contains("-"));
        Supervisor s = builder.userName("pppp").build().toSupervisor();
        u.assignSupervisor(s);
        assertTrue(u.toString().contains(s.getUserName()));
    }

    @Test
    public void testUserCompare() throws ExIsNullOrEmpty {
        User.UserBuilder builder = new User.UserBuilder();
        builder.userName(userName)
                .password(password)
                .email(email)
                .gender(gender)
                .position(position)
                .departmentOf(department);

        User origin = builder.build();
        assertEquals(0, origin.compareTo(origin));

        User smaller = builder.userName("t0").build();
        assertEquals(1, origin.compareTo(smaller));

        User bigger = builder.userName("t2").build();
        assertEquals(-1, origin.compareTo(bigger));
    }

}
