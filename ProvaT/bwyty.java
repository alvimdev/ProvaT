package ProvaT;

/* TRABALHO DE AEDS */
// Restaurante: bwyty (Galês)
// Made by Alvim (2021951426) and ...

public class bwyty {
    public static void main(String[] args) {
        Restaurant local = new Restaurant("iPhome", "Rua Alberto Cintra, n 6429, BH");
        
        local.addTable(3);
        local.tables[0].scDate();
        local.tables[0].verifyReserve(1, 3, 2022);

        local.tables[0].comandaB.Ordering("Coca-Cola", 5.45);
        local.tables[0].comandaC.Ordering("Pão de Batata", 6.50);
        local.tables[0].showConsume();
        System.out.println(local.tables[0].repartBill(2));
        System.out.println(local.tables[0].getServiceRate());

    }
}