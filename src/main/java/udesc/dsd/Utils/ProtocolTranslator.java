package udesc.dsd.Utils;

import udesc.dsd.Commons.Constants;

import static udesc.dsd.Commons.Constants.DELIMITER;

public class ProtocolTranslator {
    public static String[] translateRequest(String message){
        return message.split(DELIMITER);
    }

    public static String translateResponse(String[] response){
        return String.join(DELIMITER, response);
    }

}
