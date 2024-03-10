package udesc.dsd.Utils;

import udesc.dsd.Commons.Constants;

public class ProtocolTranslator {
    public static String[] translate(String message){
        return message.split(Constants.DELIMITER);
    }

}
