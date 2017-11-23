package usermanagementsystem.test;



import org.junit.Test;
import usermanagementsystem.datastructure.EnumGender;
import usermanagementsystem.exception.ExInvaildEnumValue;

import static org.junit.Assert.assertEquals;


public class TestEnumGender {
    @Test
    public void test_EnumGender_parse_string1() throws ExInvaildEnumValue {
        EnumGender expected;
        expected = EnumGender.parse("1");
        assertEquals(EnumGender.Female, expected);

    }

    @Test
    public void test_EnumGender_parse_string2() throws ExInvaildEnumValue {
        EnumGender expected = null;

        try {
            expected = EnumGender.parse("Female");
        } catch (ExInvaildEnumValue e) {

        }
        assertEquals(EnumGender.Female, expected);

    }

    @Test
    public void test_EnumGender_parse_string3() throws ExInvaildEnumValue {
        EnumGender expected = EnumGender.Male;

        try {
            expected = EnumGender.parse("3");
        } catch (ExInvaildEnumValue e) {

        }
        assertEquals(EnumGender.Male, expected);

    }

    @Test
    public void test_EnumGender_parse_int1() throws ExInvaildEnumValue {
        EnumGender expected;
        expected = EnumGender.parse(1);
        assertEquals(EnumGender.Female, expected);

    }

    @Test
    public void test_EnumGender_parse_int2() throws ExInvaildEnumValue {
        EnumGender expected = EnumGender.Female;

        try {
            expected = EnumGender.parse(-2);
        } catch (ExInvaildEnumValue e) {

        }
        assertEquals(EnumGender.Female, expected);

    }


    @Test
    public void test_EnumGender_parse_int3() throws ExInvaildEnumValue {
        EnumGender expected = EnumGender.Female;

        try {
            expected = EnumGender.parse(5);
        } catch (ExInvaildEnumValue e) {

        }
        assertEquals(EnumGender.Female, expected);
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


