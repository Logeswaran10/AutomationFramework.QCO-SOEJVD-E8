package Pratice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {

	@Test()

	public void createTest() {
		Assert.fail();
		System.out.println("Created");
	}

	@Test(dependsOnMethods = "createTest")

	public void modifyTest() {
		System.out.println("Modified");
	}

	@Test()

	public void deleteTest() {
		System.out.println("Deleted");
	}
}
