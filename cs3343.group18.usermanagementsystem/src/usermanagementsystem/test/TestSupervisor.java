package usermanagementsystem.test;

import org.junit.Test;
import usermanagementsystem.datastructure.*;
import usermanagementsystem.exception.ExIsNullOrEmpty;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestSupervisor {
    private String userName = "t1";
    private String password = "123abc";
    private String email = "zzzz@zzz.com";
    private EnumGender gender = EnumGender.Male;
    private EnumPosition position = EnumPosition.Engineer;
    private EnumDepartment department = EnumDepartment.Technology;

    @Test
    public void testBuildSupervisor() throws ExIsNullOrEmpty {
        Supervisor.SupervisorBuilder builder = new Supervisor.SupervisorBuilder();
        builder.userName(userName)
                .password(password)
                .email(email)
                .gender(gender)
                .position(position)
                .departmentOf(department);
        Supervisor expected = builder.build();

        assertTrue(expected.getStaffId() > 0);
        assertNull(expected.toSupervisor());
        assertFalse(expected.isAdmin());
        assertTrue(expected.isSupervisor());
    }

    @Test
    public void testSupervisorSubordinate() throws ExIsNullOrEmpty {
        Supervisor.SupervisorBuilder sBuilder = new Supervisor.SupervisorBuilder();
        sBuilder.userName(userName)
                .password(password)
                .email(email)
                .gender(gender)
                .position(position)
                .departmentOf(department);
        Supervisor s = sBuilder.build();

        User.UserBuilder uBuilder = new User.UserBuilder();
        uBuilder.userName("u1")
                .password(password)
                .email(email)
                .gender(gender)
                .position(position)
                .departmentOf(department);
        User u = uBuilder.build();

        assertFalse(s.isMySubordinate(u.getUserName()));
        assertEquals("",s.getMySubordinatesDetails());
        assertTrue(s.addSubordinate(u));
        assertTrue(s.getMySubordinatesDetails().contains(u.getUserName()));

        assertFalse(s.addSubordinate(u));
        assertFalse(s.removeSubordinate("9999999"));
        assertTrue(s.removeSubordinate(u.getUserName()));
    }

}
