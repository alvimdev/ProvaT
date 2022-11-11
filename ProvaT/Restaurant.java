package ProvaT;

/* TRABALHO DE AEDS */
// Restaurante: bwyty (Galês)
// Made by Alvim (2021951426) and ...

public class Restaurant{
    public String Name;
    public String Address;
    public Tables[] tables;

    public Restaurant(String name, String addr){
        this.tables[0] = new Tables("12/09/2022",1);
    }

    public void addTable(String d, int nm){
        Tables table = new Tables(d, nm);
        if (tables == null) {
            this.tables = new Tables[1];
            this.tables[0] = table;
        }
        else {
            int l = 0;
            [tables.length + 1];
            for (Tables tables : tables) {
                
            }
        }
        
    }

    //Getters -- Setters
    public String getName() {
        return Name;
    }

    public String getAddress() {
        return Address;
    }
}
