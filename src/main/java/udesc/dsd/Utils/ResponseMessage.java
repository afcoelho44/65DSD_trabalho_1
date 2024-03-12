package udesc.dsd.Utils;

import udesc.dsd.Commons.Constants;

import static udesc.dsd.Commons.Constants.MESSAGE_RESPONSE;
import static udesc.dsd.Commons.Constants.OBJECT_RESPONSE;

public class ResponseMessage {

    private ResponseMessage(){}

    public static String objectResponse(String input){
        String[] response = new String[]{OBJECT_RESPONSE, input};
        return ProtocolTranslator.translateResponse(response);
    }

    public static String messageResponse(String input){
        String[] response = new String[]{MESSAGE_RESPONSE, input};
        return ProtocolTranslator.translateResponse(response);
    }
}
