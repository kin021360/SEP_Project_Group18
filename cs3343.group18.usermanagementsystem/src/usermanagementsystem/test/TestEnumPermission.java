package usermanagementsystem.test;

import org.junit.Test;
import usermanagementsystem.datastructure.EnumPermission;
import usermanagementsystem.exception.ExInvaildEnumValue;

import static org.junit.Assert.assertEquals;

public class TestEnumPermission {

    @Test
    public void testEnumPermission_Parse_int1() throws ExInvaildEnumValue {
        EnumPermission expected = EnumPermission.parse(1);
        assertEquals(EnumPermission.ListUsers, expected);
    }

    @Test(expected = ExInvaildEnumValue.class)
    public void testEnumPermission_Parse_int2() throws ExInvaildEnumValue {
        EnumPermission.parse(-1);
    }

    @Test(expected = ExInvaildEnumValue.class)
    public void testEnumPermission_Parse_int3() throws ExInvaildEnumValue {
        EnumPermission.parse(1000);
    }

    @Test
    public void testEnumPermission_Parse_string1() throws ExInvaildEnumValue {
        EnumPermission expected = EnumPermission.parse("ListUsers");
        assertEquals(EnumPermission.ListUsers, expected);
    }

    @Test(expected = ExInvaildEnumValue.class)
    public void testEnumPermission_Parse_string2() throws ExInvaildEnumValue {
        EnumPermission.parse("XXXX");
    }

    @Test
    public void testEnumPermission_Parse_string3() throws ExInvaildEnumValue {
        EnumPermission expected = EnumPermission.parse("1");
        assertEquals(EnumPermission.ListUsers, expected);
    }

    @Test(expected = ExInvaildEnumValue.class)
    public void testEnumPermission_Parse_string4() throws ExInvaildEnumValue {
        EnumPermission.parse("-1");
    }

    @Test(expected = ExInvaildEnumValue.class)
    public void testEnumPermission_Parse_string5() throws ExInvaildEnumValue {
        EnumPermission.parse("1000");
    }

    @Test
    public void testListAll() {

        String result = "Name of Permission       Id\n";
        for (EnumPermission expected : EnumPermission.values()) {
            result += String.format("%18s  ---  %2d\n", expected.toString(), expected.getId());
        }

        assertEquals(EnumPermission.listAll(), result);
    }
}
