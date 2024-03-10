package udesc.dsd;

import udesc.dsd.enums.DataIndexes;

import static udesc.dsd.Commons.Constants.INSERT;

public class ProtocolTest {

    private static final String DELIMITER = ": ";
    public static void main(String[] args) {

        //pattern = {"method", "cpf", "name", "address", "type", "speciality"}
        //type: 0 = employee, 1 = manager;

        String cpf = "1234567895";
        String name = "testName";
        String address = "testAddress";
        String type = String.valueOf(1);
        String speciality = "morning";

        String[] messageData = new String[]{INSERT, cpf, name, address, type, speciality};
        String message = String.join(DELIMITER, messageData);

        System.out.println(message);

        String[] translatedMessage = message.split(DELIMITER);

        System.out.println(messageData[DataIndexes.METHOD.index]);
        System.out.println(messageData[DataIndexes.CPF.index]);
        System.out.println(messageData[DataIndexes.NAME.index]);
        System.out.println(messageData[DataIndexes.ADDRESS.index]);
        System.out.println(messageData[DataIndexes.TYPE.index]);
        System.out.println(messageData[DataIndexes.SPECIALITY.index]);



    }
}
