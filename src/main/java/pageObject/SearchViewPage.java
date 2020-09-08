package pageObject;

import org.testng.Assert;

public interface SearchViewPage {
	
	public void navigateToFilter();
	public void search(String name) throws InterruptedException;
}
