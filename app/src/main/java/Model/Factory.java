package Model;
public class Factory {
    //have one method that must be called in UI Class its return instance from tha class how return the data
    public FieldDataInterface getModel(){
        return new FieldDa();
    }
}