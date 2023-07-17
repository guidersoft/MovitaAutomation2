package Test.Baris.Locators;

public interface AlarmIslemleriLocators extends HomePageLocator {

    String detayliAramaElemanlari="//label[contains(.,\"{0}\")]/following-sibling::input";
    String alarmBilgisiElemanlari="//*[contains(text(),\"{0}\")]/following-sibling::*[self::input or self::select]";
    String alarmTipleri="//div/label[contains(.,\"{0}\")]/following-sibling::select//option[contains(.,\"{1}\")]";
    String aktifGunler="//div[contains(.,\"{0}\")]/following-sibling::select//option[contains(.,\"{1}\")]";
    String alarmDuzenlemeIcon="//td[text()=\"{0}\"]/following-sibling::td[7]";
    String alarmSilmeIcon="//td[text()=\"{0}\"]/following-sibling::td[8]";
    String getalarmkodu="//td[text()=\"{0}\"]/preceding-sibling::td";
}
