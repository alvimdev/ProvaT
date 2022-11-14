package ProvaT;
import java.util.Random;
import java.util.Scanner;

public class Date{
    public int dia, mes, ano;
    public Boolean reserved;
    private Client[] clients = new Client[0];
    private int nClient;
    private Random RND = new Random();

    public Date(){
        this.nClient = 0;
        this.reserved = false;
        this.dia = RND.nextInt(31 - 1) + 1;
        this.mes = RND.nextInt(12 - 1) + 1;
        this.ano = RND.nextInt(2022 - 1) + 1;
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
        this.nClient += l;
    }

    public void reservation(int nP){
        Scanner in = new Scanner(System.in);
        String nome, mail;

        for (int c = 0; c < nP; c++) {
            System.out.println("Nome: ");
            nome = in.nextLine();
            System.out.println("Mail: ");
            mail = in.nextLine();
            addPeople(nome, mail);
        }

        in.close();
        this.reserved = !this.reserved;
    }
}