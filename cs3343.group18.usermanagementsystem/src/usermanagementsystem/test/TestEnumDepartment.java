package usermanagementsystem.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import usermanagementsystem.datastructure.EnumDepartment;
import usermanagementsystem.exception.ExInvaildEnumValue;

public class TestEnumDepartment {

	@Test
	public void testEnumDepartment_Parse_int1() throws ExInvaildEnumValue {
		EnumDepartment expected = null;
		try {
			expected = EnumDepartment.parse(1);

		} catch (ExInvaildEnumValue e) {

		}
		assertEquals(EnumDepartment.HumanResource, expected);

	}

	@Test
	public void testEnumDepartment_Parse_int2() throws ExInvaildEnumValue {
		EnumDepartment expected = EnumDepartment.Finance;
		try {
			expected = EnumDepartment.parse(-2);

		} catch (ExInvaildEnumValue e) {

		}

		assertEquals(EnumDepartment.Finance, expected);
	}

	@Test
	public void testEnumDepartment_Parse_int3() throws ExInvaildEnumValue {
		EnumDepartment expected = EnumDepartment.Finance;
		try {
			expected = EnumDepartment.parse(10);

		} catch (ExInvaildEnumValue e) {

		}

		assertEquals(EnumDepartment.Finance, expected);
	}

	@Test
	public void testEnumDepartment_Parse_string1() throws ExInvaildEnumValue {
		EnumDepartment expected = null;
		try {
			expected = EnumDepartment.parse("HumanResource");
		} catch (ExInvaildEnumValue e) {

		}

		assertEquals(EnumDepartment.HumanResource, expected);
	}
	
	@Test
	public void testEnumDepartment_Parse_string2() throws ExInvaildEnumValue {
		EnumDepartment expected = null;
		try {
			expected = EnumDepartment.parse("2");
		} catch (ExInvaildEnumValue e) {

		}

		assertEquals(EnumDepartment.Finance, expected);
	}

	@Test
	public void testEnumDepartment_Parse_string3() throws ExInvaildEnumValue {
		EnumDepartment expected = null;
		try {
			expected = EnumDepartment.parse("10");

		} catch (ExInvaildEnumValue e) {

		}

		assertEquals(null, expected);
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
