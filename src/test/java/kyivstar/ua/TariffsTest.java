package kyivstar.ua;

import org.junit.Test;
import ua.kyivstar.*;

public class TariffsTest extends BaseTest {

    @Test
    public void WhenPageOpenThenAssertUrl() {

        new Utils(driver).assertPageEqualsCurrentUrl("http://beta.kyivstar.ua/tariffs");
    }


    @Test
    public void WhenTariffsPageOpenClickFilterPrepaidThenAssertDisableFilterPostpaid() {
        new TariffsPage(driver).clickOnFilterPrepaid()
                .checkedEnabledFilterPrepaidAndDisablePostpaid()
                .assertSelectFiltersWithTariffs();
    }

    @Test
    public void WhenTariffsPageOpenClickFilterPrepaidThenAssertCountTarrifs() {
        new TariffsPage(driver).clickOnFilterPrepaid()
                .assertSelectTariffsFiltersWithDisplaysTariffs();
    }

    @Test
    public void WhenTariffsPageOpenClickFilterPostpaid() {

        new TariffsPage(driver).clickOnFilterPostpaid();
    }

    @Test
    public void WhenTariffsArchivePageOpenAssertURL() {
        new TariffsPage(driver).clickOnTariffsArchiveLink();
        new Utils(driver).assertPageEqualsCurrentUrl("https://kyivstar.ua/uk/mm/tariffs/arhive");
    }

    @Test
    public void WhenClickButton() {

        new TariffsPage(driver).checkedEnabledFilterPostpaidAndPrepaid();
    }

    @Test
    public void assertInfoTariffsWithTariffPage() {
        new  TariffsPage(driver)
                .clickInfoActiveTariffsWithTariffPage();
        new  Utils(driver).assertPageStartsWithCurrentUrl("http://beta.kyivstar.ua/tariffs");

    }


    @Test
    public void assertThanPayPage() {
        new TariffsPage(driver).clickButtonTopUpAccount();
        new Utils(driver).assertPageEqualsCurrentUrl("https://pay.kyivstar.ua/");
    }

    @Test
    public void assertClickPlugTariffClickCloseThanTarrifsPage() {
        new TariffsPage(driver).clickPlugTariffOnTariffPage()
                .clickButtonPlugTariffClose()
                .assertSelectFiltersWithTariffs();

    }

    @Test
    public void assertClickPlugTariffClickYesThanLoginPage() {
        new TariffsPage(driver).clickPlugTariffOnTariffPage()
                .clickButtonPlugTariffYes();
        new Utils(driver).assertPageStartsWithCurrentUrl("https://account.kyivstar.ua/cas/login");
    }

    @Test
    public void assertClickPlugTariffClickNoClickNoNewNumberThanMnpPage() {
        new TariffsPage(driver).clickPlugTariffOnTariffPage()
                .clickButtonPlugTariffNo()
                .clickButtonPlugTariffNoNewNumber();
        new Utils(driver).assertPageEqualsCurrentUrl("https://mnp.kyivstar.ua/");
    }

    @Test
    public void assertClickPlugTariffClickNoClickNewNumberClickDeliveryThanShopPage() {
        new TariffsPage(driver).clickPlugTariffOnTariffPage()
                .clickButtonPlugTariffNo()
                .clickButtonPlugTariffNewNumber()
                .clickButtonPlugTariffNoNewNumberDelivery();
        new Utils(driver).assertPageEqualsCurrentUrl("https://shop.kyivstar.ua/");
    }

    @Test
    public void assertClickPlugTariffClickNoClickNewNumberClickFindMarketThanServiceCentersListPage() {
        new TariffsPage(driver).clickPlugTariffOnTariffPage()
                .clickButtonPlugTariffNo()
                .clickButtonPlugTariffNewNumber()
                .clickButtonPlugTariffNoNewNumberFindMarket();
        new Utils(driver).assertPageEqualsCurrentUrl("https://kyivstar.ua/uk/mm/service/centers/list");
    }

}
