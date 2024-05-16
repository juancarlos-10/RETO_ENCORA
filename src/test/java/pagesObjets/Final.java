package pagesObjets;

import definitions.Base;
import org.openqa.selenium.By;

public class Final extends Base {
    By resul = By.xpath("//h1[@class='title']/following-sibling::p[1]");


    public Final() {
        super(driver);

    }

    public Boolean encontrarTexto(String palabra){
        if (devolverTexto(resul).contains(palabra)){
            return true;
        }else {
            return false;
        }
    }

}
