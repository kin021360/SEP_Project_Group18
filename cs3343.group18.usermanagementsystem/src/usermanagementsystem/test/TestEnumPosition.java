package usermanagementsystem.test;

import org.junit.Test;
import usermanagementsystem.datastructure.EnumPosition;
import usermanagementsystem.exception.ExInvaildEnumValue;

import static org.junit.Assert.assertEquals;

public class TestEnumPosition {
    @Test
    public void testEnumPosition_Parse_int1() throws ExInvaildEnumValue {
        EnumPosition expected = EnumPosition.parse(0);
        assertEquals(EnumPosition.Programmer, expected);
    }

    @Test(expected = ExInvaildEnumValue.class)
    public void testEnumPosition_Parse_int2() throws ExInvaildEnumValue {
        EnumPosition.parse(-2);
    }

    @Test(expected = ExInvaildEnumValue.class)
    public void testEnumPosition_Parse_int3() throws ExInvaildEnumValue {
        EnumPosition.parse(1000);
    }

    @Test
    public void testEnumPosition_Parse_string1() throws ExInvaildEnumValue {
        EnumPosition expected = EnumPosition.parse("Engineer");
        assertEquals(EnumPosition.Engineer, expected);
    }

    @Test(expected = ExInvaildEnumValue.class)
    public void testEnumPosition_Parse_string2() throws ExInvaildEnumValue {
        EnumPosition.parse("XXXX");
    }

    @Test
    public void testEnumPosition_Parse_string3() throws ExInvaildEnumValue {
        EnumPosition expected = EnumPosition.parse("0");
        assertEquals(EnumPosition.Programmer, expected);
    }

    @Test(expected = ExInvaildEnumValue.class)
    public void testEnumPosition_Parse_string4() throws ExInvaildEnumValue {
        EnumPosition.parse("-2");
    }

    @Test(expected = ExInvaildEnumValue.class)
    public void testEnumPosition_Parse_string5() throws ExInvaildEnumValue {
        EnumPosition.parse("1000");
    }

    @Test
    public void testListAll() {

        String result = "Name of Position       Id\n";
        for (EnumPosition expected : EnumPosition.values()) {
            result += String.format("%16s  ---  %2d\n", expected.toString(), expected.getId());
        }

        assertEquals(EnumPosition.listAll(), result);
    }
}
