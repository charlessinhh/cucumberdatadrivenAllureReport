package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {
    public void selectDropdown(final WebElement locator, final String value) {
        final Select select = new Select(locator);
        select.selectByVisibleText(value);
    }

    public void selectDropdownByIndex(final WebElement locator, final int index) {
        final Select select = new Select(locator);
        select.selectByIndex(index);
    }
}
