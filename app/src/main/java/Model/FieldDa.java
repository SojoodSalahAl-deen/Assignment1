package Model;

import android.graphics.HardwareRenderer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

 class FieldDa implements FieldDataInterface {
    //this model class  is take with data base and web server , cause we does not take how we get data from data base or web server we will get the data from array list

    private ArrayList<Field> fields = new ArrayList<>();
    public FieldDa() {
        //fill array list
        this.fields.add(new Field("Food" ,"Type Of Food"));
        this.fields.add(new Field("Food" ,"Amount Of Food"));
        this.fields.add(new Field("Food" ,"Time Of Food"));
        this.fields.add(new Field("Sleep" ,"Duration Of Sleep"));
    }

    // iterate in the array list extract the spesfic fields According to choosen field in Spinner Return It.as an Object


    @Override
    public List<Field> getType(String field) {
            ArrayList<Field> result = new ArrayList<>();
            for(Field item : this.fields) {
                if (item.getName().equals(field)) {
                    result.add(item);
                }

            }
            return result;



        }



    @Override
        public List<String> getFields(){
            ArrayList<String> fields = new ArrayList<>();
            fields.add("Sleep");
            fields.add("Food");
            return fields;
        }




}
