package pages;

import base.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProductPage extends TestBase {
    @AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView") private MobileElement productText;


    public String getTitle() {
        return getAttribute(productText, "text");
    }
}
