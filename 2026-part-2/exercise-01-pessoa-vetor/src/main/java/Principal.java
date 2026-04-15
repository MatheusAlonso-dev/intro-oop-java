import java.util.Scanner;

public class Principal {
    public static int idGlobal = 0;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Pessoa[] pessoas = new Pessoa[10];
        int opcao = 0;







        do {
            System.out.print("\n[1] inserir (10 pessoas automaticamente)\n[2] mostrar maior\n[3] mostrar menor\n[4] pesquisar por id\n[0] sair\n\tDigite uma opção: ");
            opcao = sc.nextInt();

            switch (opcao){
                case 0:
                    System.out.println("Saindo...");
                    break;
                case 1:
                    for (int i = 0; i < pessoas.length; i++) {
                        idGlobal++;
                        String nome = "nome" + idGlobal;
                        double salario = idGlobal *100.25;
                        pessoas[i] = new Pessoa(idGlobal, nome, salario );

                        System.out.println(pessoas[i]);
                    }
                    break;
                case 2:
                    maiorSalario(pessoas);
                    break;
                case 3:
                    menorSalario(pessoas);
                    break;
                case 4:
                    if(pessoas[0] == null){
                        System.out.println("Cadastre as pessoas antes de pesquisar por id!");
                        break;
                    }
                    System.out.print("Digite o id para busca: ");
                    int idBusca=0;
                    idBusca = sc.nextInt();
                    System.out.println("\n" + buscarPorId(pessoas, idBusca));
                    break;
                case 5: // teste
                    System.out.println(pessoas);
                    break;
            }

        }while (opcao != 0);

    }

//----------------maior salario
    public static void maiorSalario(Pessoa[] vetPessoas){
        double maiorSalario = 0;
        int indice=0;
        if(vetPessoas[0] == null){
            System.out.println("Cadastre as pessoas antes de conferir o salario!");
            return;
        }
        for (int i = 0; i < vetPessoas.length; i++){
            if (i == 0){
                maiorSalario = vetPessoas[i].getSalario();
                indice = i;
            }else{
                if (vetPessoas[i].getSalario() > maiorSalario){
                    maiorSalario = vetPessoas[i].getSalario();
                    indice = i;
                }
            }
        }

        System.out.println();
        System.out.println(vetPessoas[indice]);
    }
//-----------------------------
//----------------menor salario
    public static void menorSalario(Pessoa[] vetPessoas){
        double menorSalario = 0;
        int indice = 0;
        if(vetPessoas[0] == null){
            System.out.println("Cadastre as pessoas antes de conferir o salario!");
            return;
        }
        for (int i = 0; i < vetPessoas.length; i++){
            if(i == 0){
                menorSalario = vetPessoas[i].getSalario();
                indice = i;
            }else {
                if(vetPessoas[i].getSalario() < menorSalario){
                    menorSalario = vetPessoas[i].getSalario();
                    indice = i;
                }
            }
        }
        System.out.println();
        System.out.println(vetPessoas[indice]);
    }
//-----------------------------
//----------------retornar pessoa pelo id
    public static Pessoa buscarPorId(Pessoa[] vetPessoas, int id){

        for(int i = 0; i < vetPessoas.length; i++){
            if (id == vetPessoas[i].getId()){
                return vetPessoas[i];
            }
        }
        return null;
    }

//-----------------------------

}