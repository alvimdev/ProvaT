package ProvaT;
import java.util.Random;
import java.util.Scanner;

public class Date{
    public int dia, mes, ano;
    private Boolean reserved;
    private Client[] clients = new Client[0];
    private Random RND = new Random();

    public Date(){
        this.reserved = false;
        this.dia = RND.nextInt(31 - 1) + 1;
        this.mes = RND.nextInt(12 - 1) + 1;
        this.ano = 2022;
    }

    public void printData(){
        System.out.print(this.dia + "/" + this.mes + "/" + this.ano);
    }

    public void addPeople(String name, String mail){
        Client cliente = new Client(name, mail);
        Client[] client = new Client[clients.length + 1];
        int l = 0;
        for (Client client2 : clients) {
            client[l] = client2;
            l++;
        }
        client[l] = cliente;
        this.clients = client;
    }

    public Boolean getReserve() {
        return reserved;
    }

    public void setReserve(Boolean reserved) {
        this.reserved = reserved;
    }

    public void reservation(int nP, Scanner rd){
        String nome, mail;

        for (int c = 0; c < nP; c++) {
            System.out.print("Nome: ");
            nome = rd.nextLine();
            System.out.print("Mail: ");
            mail = rd.nextLine();
            this.addPeople(nome, mail);
        }
        this.reserved = true;
    }
}