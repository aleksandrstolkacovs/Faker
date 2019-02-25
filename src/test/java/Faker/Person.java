package Faker;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Person extends Base {

    static final String GENDER_MALE = "male";
    static final String GENDER_FEMALE = "female";

    public static String[] titleFormat = {
            GENDER_MALE,
            GENDER_FEMALE
    };

    public static String firstName(String Path) {
            jsonFileOpen(Path);
            return jsonFileOpen(Path);
    }

    public static String lastName(String Path) {
        jsonFileOpen(Path);
        return jsonFileOpen(Path);
    }

    public static String middleName(String Path) {
        jsonFileOpen(Path);
        return jsonFileOpen(Path);
    }

    public static String jsonFileOpen(String PathToJson){
        List list = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            list = objectMapper.readValue(new File(PathToJson), List.class);

        }catch (IOException e) {
            e.printStackTrace();
        }
        assert list != null;
        return (String) list.get(numberBetween(0,list.size()));
    }
}

