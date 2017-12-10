package usermanagementsystem.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import usermanagementsystem.datastructure.EnumDepartment;
import usermanagementsystem.exception.ExInvaildEnumValue;

public class TestEnumDepartment {

    @Test
    public void testEnumDepartment_Parse_int1() throws ExInvaildEnumValue {
        EnumDepartment expected = EnumDepartment.parse(1);
        assertEquals(EnumDepartment.HumanResource, expected);
    }

    @Test(expected = ExInvaildEnumValue.class)
    public void testEnumDepartment_Parse_int2() throws ExInvaildEnumValue {
        EnumDepartment.parse(-2);
    }

    @Test(expected = ExInvaildEnumValue.class)
    public void testEnumDepartment_Parse_int3() throws ExInvaildEnumValue {
        EnumDepartment.parse(1000);
    }

    @Test
    public void testEnumDepartment_Parse_string1() throws ExInvaildEnumValue {
        EnumDepartment expected = EnumDepartment.parse("HumanResource");
        assertEquals(EnumDepartment.HumanResource, expected);
    }

    @Test(expected = ExInvaildEnumValue.class)
    public void testEnumDepartment_Parse_string2() throws ExInvaildEnumValue {
        EnumDepartment.parse("XXXXXXXXXXX");
    }

    @Test
    public void testEnumDepartment_Parse_string3() throws ExInvaildEnumValue {
        EnumDepartment expected = EnumDepartment.parse("1");
        assertEquals(EnumDepartment.HumanResource, expected);
    }

    @Test(expected = ExInvaildEnumValue.class)
    public void testEnumDepartment_Parse_string4() throws ExInvaildEnumValue {
        EnumDepartment.parse("-2");
    }

    @Test(expected = ExInvaildEnumValue.class)
    public void testEnumDepartment_Parse_string5() throws ExInvaildEnumValue {
        EnumDepartment.parse("1000");
    }

    @Test
    public void testListAll() {

        String result = "Name of Department       Id\n";
        for (EnumDepartment expected : EnumDepartment.values()) {
            result += String.format("%18s  ---  %2d\n", expected.toString(), expected.getId());
        }

        assertEquals(EnumDepartment.listAll(), result);
    }
}
