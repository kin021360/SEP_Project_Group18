package usermanagementsystem.test;

import org.junit.Test;
import usermanagementsystem.datastructure.EnumGender;
import usermanagementsystem.exception.ExInvaildEnumValue;

import static org.junit.Assert.assertEquals;

public class TestEnumGender {
    @Test
    public void test_EnumGender_parse_int1() throws ExInvaildEnumValue {
        EnumGender expected = EnumGender.parse(1);
        assertEquals(EnumGender.Female, expected);
    }

    @Test(expected = ExInvaildEnumValue.class)
    public void test_EnumGender_parse_int2() throws ExInvaildEnumValue {
        EnumGender.parse(-2);
    }


    @Test(expected = ExInvaildEnumValue.class)
    public void test_EnumGender_parse_int3() throws ExInvaildEnumValue {
        EnumGender.parse(1000);
    }


    @Test
    public void test_EnumGender_parse_string1() throws ExInvaildEnumValue {
        EnumGender expected = EnumGender.parse("Male");
        assertEquals(EnumGender.Male, expected);
    }

    @Test(expected = ExInvaildEnumValue.class)
    public void test_EnumGender_parse_string2() throws ExInvaildEnumValue {
        EnumGender.parse("XXXXX");
    }

    @Test
    public void test_EnumGender_parse_string3() throws ExInvaildEnumValue {
        EnumGender expected = EnumGender.parse("1");
        assertEquals(EnumGender.Female, expected);
    }

    @Test(expected = ExInvaildEnumValue.class)
    public void test_EnumGender_Parse_string4() throws ExInvaildEnumValue {
        EnumGender.parse("-2");
    }

    @Test(expected = ExInvaildEnumValue.class)
    public void test_EnumGender_parse_string5() throws ExInvaildEnumValue {
        EnumGender.parse("1000");
    }


    @Test
    public void testListAll() {

        String result = "Name of Gender       Id\n";
        for (EnumGender expected : EnumGender.values()) {
            result += String.format("%14s  ---  %2d\n", expected.toString(), expected.getId());
        }

        assertEquals(EnumGender.listAll(), result);
    }
}


