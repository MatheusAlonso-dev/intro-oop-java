import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcao;
        int idGeal = 0;
        String descricaoGeral;
        ArrayList<Item> lista = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            idGeal++;
            descricaoGeral = "descrição" + idGeal;
            lista.add(new Item(idGeal,descricaoGeral));
        }

        do {
            System.out.println("\n[1] Alterar algum Item\n[2] Excluir algum item\n[3] Imprimir lista\n[0] sair\n\tSelecione uma opção: ");
            opcao = sc.nextInt();
            switch (opcao){
                case 1:
                    alterItem(lista);
                    break;
                case 2:
                    excluirItem(lista);
                    break;
                case 3:
                    imprimirLista(lista);
                    break;
                case 0:
                    System.out.println("\n\tSaindo...\n");
                    break;
            }

        }while(opcao != 0);

    }

    public static void imprimirLista(ArrayList<Item> lista){
        for(Item item: lista){
            System.out.println(item);
        }
    }

    public static boolean alterItem(ArrayList<Item> lista){
        Scanner sc = new Scanner(System.in);
        int id;
        System.out.println("Digite o id do item a ser alterado: ");
        id = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < lista.size(); i++){
            if(id == lista.get(i).getId()){
                String novaDescricao;
                System.out.println("Digite a nova descrição: ");
                novaDescricao = sc.nextLine();
                lista.get(i).setDescricao(novaDescricao);
                return true;
            }
        }
        return false;
    }

    public static boolean excluirItem(ArrayList<Item> lista){
        Scanner sc = new Scanner(System.in);
        int id;
        System.out.println("Digite o id a ser excluido: ");
        id = sc.nextInt();

        for(int i = 0; i < lista.size(); i++){
            if(id == lista.get(i).getId()){
                lista.remove(i);
                return true;
            }
        }
        return false;
    }

}
