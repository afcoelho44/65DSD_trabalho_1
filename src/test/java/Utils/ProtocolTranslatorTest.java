package Utils;

import org.junit.Test;
import udesc.dsd.Commons.Constants;
import udesc.dsd.Model.Department;
import udesc.dsd.Model.Employee;
import udesc.dsd.Model.Person;
import udesc.dsd.Utils.ProtocolTranslator;
import udesc.dsd.enums.DataIndexes;

import static org.junit.Assert.assertEquals;

public class ProtocolTranslatorTest {

    @Test
    public void mustTranslateRequest(){
        String requestInPattern = "PERSON: GET: 1";

        String[] result = ProtocolTranslator.translateRequest(requestInPattern);

        assertEquals(result[DataIndexes.CLASS.index], Constants.PERSON_REQUEST);
        assertEquals(result[DataIndexes.METHOD.index], Constants.GET);
        assertEquals(result[DataIndexes.DEPARTMENT_ID.index], "1");
    }

    @Test
    public void mustTranslateResponse(){
        Department department = new Department("Security");
        Person employee = new Employee("1234567890", "João", "Rua x", department, "morning");

        String[] response = {Constants.OBJECT_RESPONSE, employee.toString()};

        String responseString = ProtocolTranslator.translateResponse(response);

        assertEquals(responseString, Constants.OBJECT_RESPONSE + Constants.DELIMITER + employee);
    }

}
