package ProvaT;

public class Restaurant{
    private String Name;
    private String Address;
    public Tables[] tables;

    public Restaurant(String name, String addr){
        this.Address = addr;
        this.Name = name;
    }

    public void addTable(int nm){
        Tables mesa = new Tables(nm);
        if (tables == null) {
            this.tables = new Tables[1];
            this.tables[0] = mesa;
        }
        else {
            int l = 0;
            Tables[] table = new Tables[tables.length + 1];
            for (Tables table2 : tables) {
                table[l] = table2;
                l++;
            }
            table[l] = mesa;
            this.tables = table;
        }
        
    }

    public void showTables(){
        for (int l = 0; l < tables.length; l++) {
            System.out.println("Mesa: " + (tables[l].nTable));
            System.out.println("Reserva: ");
            for (int ll = 0; ll < tables[l].date.length; ll++) {
                tables[l].verifyReserve(tables[l].date[ll], ll);
            }
            System.out.println();
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
