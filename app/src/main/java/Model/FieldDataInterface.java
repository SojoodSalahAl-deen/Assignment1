package Model;

import java.util.List;
// we make this interface but inside it the method in FieldsDa (The class fetch data from any where then make this class implemented this interface)

public interface FieldDataInterface {
    // we but inside it the method get the data
    //  whats the method get the Data for me??
    // GetType Method ok..
    List<Field> getType(String field);
    List<String> getFields();
}




