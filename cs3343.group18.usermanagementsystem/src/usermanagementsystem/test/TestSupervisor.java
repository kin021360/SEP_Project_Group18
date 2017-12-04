package usermanagementsystem.test;

import org.junit.Test;
import usermanagementsystem.datastructure.Supervisor;
import usermanagementsystem.datastructure.User;
import usermanagementsystem.exception.ExIsNullOrEmpty;

import static org.junit.Assert.assertEquals;

public class TestSupervisor {
    @Test
    public void testSupervisorGetStaffID() throws ExIsNullOrEmpty {
        Supervisor supervisorTest;
        long expected;
        Supervisor.SupervisorBuilder builder = new Supervisor.SupervisorBuilder();
        builder.isAdmin(true);
        supervisorTest = builder.build();
        expected = supervisorTest.getStaffId();
        assertEquals(0, expected);
    }


}
