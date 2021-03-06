package kdf;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.GenericMethods;

public class Application {

	
	@Test
	public void invalidLoginTest() throws IOException {
		String[][] data = GenericMethods.getData("D:\\Sel19Dec\\TestData.xlsx", "Sheet2");
		Methods mtd = new Methods();
		
		//Making changes after R1.1
		
		for(int i = 1;i<data.length;i++) {
			switch(data[i][3]) {
			case "openBrowser":
				mtd.openBrowser();
				break;
			case "maxWindow":
				mtd.maximizeBrowserWindow();
				break;
			case "impWait":
				mtd.implementImplicitWait();
				break;
			case "navigateToApp":
				mtd.navigateToApplication(data[i][6]);
				break;
			case "enterInTextBox":
				mtd.enterInTextBox(data[i][5], data[i][6]);
				break;
			case "clickButton":
				mtd.clickButton(data[i][4],data[i][5]);
				break;
			case "verifyMsg":
				String actualMsg = mtd.getText(data[i][4],data[i][5]);
				String expectedMsg = data[i][6];
				Assert.assertEquals(actualMsg, expectedMsg);
				break;
			case "closeApp":
				mtd.closeApplication();
				break;
			}
		}
	}
}
