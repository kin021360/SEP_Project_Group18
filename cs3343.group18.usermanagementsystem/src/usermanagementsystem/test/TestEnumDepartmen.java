package usermanagementsystem.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import usermanagementsystem.datastructure.EnumDepartment;
import usermanagementsystem.exception.ExInvaildEnumValue;

public class TestEnumDepartmen {
	
	@Test
    public void testEnumDepartment_1() throws ExInvaildEnumValue {
        EnumDepartment expected = null;
        try {
			expected = EnumDepartment.parse(1);

		} catch (ExInvaildEnumValue e) {

		}
		assertEquals(EnumDepartment.HumanResource, expected);

	} 
	@Test
    public void testEnumDepartment_2() throws ExInvaildEnumValue {
        EnumDepartment expected = EnumDepartment.Finance;
		try {
			expected = EnumDepartment.parse(-2);


		} catch (ExInvaildEnumValue e) {

		}
        
 	assertEquals(EnumDepartment.Finance, expected); 
	} 


}
