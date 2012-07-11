package com.tightdb;

import static org.testng.AssertJUnit.*;

import java.nio.ByteBuffer;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tightdb.lib.TightDB;

public class JNICloseTest {
	
	@Test (enabled=true)
	public void shouldCloseTable() {
		// util.setDebugLevel(1);
		
		TableBase table = new TableBase();
		table.close();
		
		boolean gotException = false;
		try {
			@SuppressWarnings("unused")
			long s = table.size();
		} catch (IllegalArgumentException e) {
			// TODO: a more specific Exception must be thrown from JNI..
			gotException = true;
		}
		assertEquals(true, gotException);
		
	}
	
	// TODO: Much more testing needed.
	// Verify that methods make exceptions when Tables are invalidated.
	// Verify subtables are invalidated when table is changed/updated in any way.
	// Check that Group.close works
	
	@Test (enabled=false)
	public void shouldCloseGroup() {
		//Group group = new Group();

//		EmployeeTable employees = new EmployeeTable(group);
	}
	
}