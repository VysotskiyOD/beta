package kyivstar;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class Utils {
    private WebDriver driver;

    public Utils(WebDriver driver) {
        this.driver = driver;
    }

    public Utils assertPageStartsWithCurrentUrl(String CurrentUrl) {
        Assert.assertTrue(driver.getCurrentUrl()
                .startsWith(CurrentUrl));
        return this;
    }

    public Utils assertPageEqualsCurrentUrl(String CurrentUrl) {
        Assert.assertTrue(driver.getCurrentUrl()
                .equals(CurrentUrl));
        return this;
    }


}
