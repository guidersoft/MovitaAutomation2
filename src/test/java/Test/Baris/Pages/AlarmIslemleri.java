package Test.Baris.Pages;

import ReuseableClass.BaseClass;
import ReuseableClass._Conditions;
import Test.Baris.Locators.AlarmIslemleriLocators;
import org.openqa.selenium.support.ui.Select;

public class AlarmIslemleri extends BaseClass implements AlarmIslemleriLocators {

    AlarmEkle alarmEkle;
    public void alarmEkle(String aciklama,
                          String alarmTipi,
                          String SMSBildirimTipi,
                          String bolgedeKalmaSuresi_dakika,
                          String birSonrakiBolgeyeMaxVarmaSuresi_dakika,
                          String ihlalCezasi_number,
                          String[] aktifgunler
    ) {
        alarmEkle= new AlarmEkle();
        alarmEkle.aciklamaEkle(aciklama);
        alarmEkle.alarmTipiEkle(alarmTipi);
        alarmEkle.SMSBildirimEkle(SMSBildirimTipi);
        alarmEkle.bolgedeKalmaSuresiEkle(bolgedeKalmaSuresi_dakika);
        alarmEkle.birSonrakiBolgeyeMaxVarmaSuresiEkle(birSonrakiBolgeyeMaxVarmaSuresi_dakika);
        alarmEkle.ihlalCezasiEkle(ihlalCezasi_number);
        alarmEkle.aktifGunEkle(aktifgunler);
        alarmEkle.alarmKaydet();
    };

    public void aciklamaEkle(String aciklama){
        $(xpath(alarmBilgisiElemanlari,"Açıklama")).clear().sendKeys(aciklama);

    }

    public String aciklamayiOku(){
        String alinanaciklama = $(xpath(alarmBilgisiElemanlari, "Açıklama")).getText();
        return alinanaciklama;
    }

    public void clickKaydetButton(){
        $(xpath(ALL_BUTTON,"Kaydet")).scrollByElement().click();
    }


   public class AlarmEkle {

        public String aciklamayiOku(){
            String alinanaciklama = $(xpath(alarmBilgisiElemanlari, "Açıklama")).getText();
            return alinanaciklama;
        }
        public void aciklamaEkle(String aciklama){
            $(xpath(alarmBilgisiElemanlari,"Açıklama")).clear().sendKeys(aciklama);
        }
        public void bolgedeKalmaSuresiEkle(String bolgedeKalmaSuresi_dakika){
            $(xpath(alarmBilgisiElemanlari,"Bölgede Kalma Süresi (Dk)")).sendKeys(bolgedeKalmaSuresi_dakika);
        }
        public void birSonrakiBolgeyeMaxVarmaSuresiEkle(String birSonrakiBolgeyeMaxVarmaSuresi_dakika ){
            $(xpath(alarmBilgisiElemanlari,"Bir Sonraki Bölgeye Max Varma Süresi(Dk)")).sendKeys(birSonrakiBolgeyeMaxVarmaSuresi_dakika);
        }
        public  void alarmTipiEkle(String alarmTipi){
            new Select(
                    $(xpath(alarmBilgisiElemanlari,"Alarm Tipi")).getCurrentElement()
            ).selectByVisibleText(alarmTipi);
        }

        public  void SMSBildirimEkle(String SMSBildirimTipi){
            new Select(
                    $(xpath(alarmBilgisiElemanlari,"Sms Bildirim")).getCurrentElement()
            ).selectByVisibleText(SMSBildirimTipi);
        }
        public  void aktifGunEkle(String[] aktifgunler)  {


            for (String gun : aktifgunler) {
                $(xpath(aktifGunler,"Aktif Günler",gun)).waitFor(_Conditions.visibilty,null).click();
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        public void ihlalCezasiEkle(String ihlalCezasi_number){
            $(xpath(alarmBilgisiElemanlari,"Bölgeye Varış/Kalma Süre İhlali Cezası(Tutar/Puan)")).sendKeys(ihlalCezasi_number);
        }
        public void alarmKaydet(){
            $(xpath(ALL_BUTTON,"Kaydet")).scrollByElement().click();
        }

        }

   public class AlarmListesi {

    }
}
