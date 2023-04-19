import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class AccommodoApp {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        System.out.print("Por favor, digite o nome do seu hotel: ");
        String nomeDoHotel = leitor.nextLine();
        System.out.printf("\nQuantas estrelas o  Hotel %s tem? ",nomeDoHotel);
        int estrelasDoHotel = leitor.nextInt();

        Hotel hotel1 = new Hotel(nomeDoHotel,estrelasDoHotel);
        leitor.nextLine();

        System.out.print("\nQual o endereço do Hotel? ");
        String endereco = leitor.nextLine();
        hotel1.setEndereco(endereco);

        System.out.println("\nCadastrando hotel...");

        int acao;

        do {

            System.out.printf("=== Hotel %s - Controle de usuário ===\n",hotel1.getNome());
            System.out.println("---== Seu conforto nossa alegria ==---\n");

            System.out.println("1 - Cadastrar quarto");
            System.out.println("2 - Listar todos os quartos");
            System.out.println("3 - Informações do hotel");
            System.out.println("4 - Fazer reserva de um quarto");
            System.out.println("5 - Cadastrar serviço");
            System.out.println("6 - Cadastrar funcionário");
            System.out.println("7 - Cadastrar Hospede");
            System.out.println("8 - Listar hospedes");
            System.out.println("0 - Sair");

            System.out.print("\nO que deseja fazer? ");

            acao = leitor.nextInt();
            leitor.nextLine();

            switch (acao) {
                case 1:
                    System.out.print("Nome do quarto: ");
                    String nomeDoQuarto = leitor.nextLine();

                    System.out.print("Tipo do quarto: ");
                    String tipoDoQuarto = leitor.nextLine();

                    System.out.print("Preço da diaria: ");
                    int precoDiaria = leitor.nextInt();
                    leitor.nextLine();

                    Quarto quarto = new Quarto(nomeDoQuarto,tipoDoQuarto,precoDiaria);
                    hotel1.adicionarQuarto(quarto);
                case 2:
                    Date dataHoje = new Date();
                    for (Quarto quartoUnico : hotel1.buscarQuartosDisponiveis(dataHoje,dataHoje)) {
                        System.out.printf("\nO quarto %s, n° %d está disponivel. \nSeu valor é de R$%.2f.\n",quartoUnico.getNome(),quartoUnico.getNumero() ,quartoUnico.getPrecoDiaria());
                    }
                    break;
                case 3:
                    System.out.println("\nNosso hotel possui x quartos, estamos com vagas e prontos para recebê-los!\n");
                    break;
                case 4:
                    int reservarQuarto = 0;
                    int index = 1;
                    Date dataHoje2 = new Date();
                    for (Quarto quartoUnico : hotel1.buscarQuartosDisponiveis(dataHoje2,dataHoje2)) {
                        System.out.println(index + ") " +quartoUnico.getNome()+ " " +quartoUnico.getTipo());
                        index++;
                    }
                    System.out.print("\nQual quarto gostaria de reservar:");
                    reservarQuarto = leitor.nextInt();
                    // obter quarto que será reservado aqui, na variavel reservarQuarto
                    // criar logica para saber qual quarto escolheu e mudar disponivel para false
                    break;
                case 5:
                    System.out.print("Por favor insira o nome do serviço a ser adicionado: ");
                    String nomeDoServico = leitor.nextLine();

                    System.out.print("\nAgora informe o valor do serviço: ");
                    int precoProduto = leitor.nextInt();

                    leitor.nextLine();

                    System.out.println("\nE por fim uma breve descrição do mesmo: ");
                    String descricaoDoProduto = leitor.nextLine();

                    Servico novoServico = new Servico(nomeDoServico,precoProduto);
                    novoServico.setDescricao(descricaoDoProduto);

                    if (hotel1.adicionarServico(novoServico)) {
                        System.out.println("Serviço adicionado com sucesso");
                    } else {
                        System.out.println("Não foi possivel adiconar o serviço");
                    }
                    break;
                case 6:
                    System.out.print("\nNome do funcionário: ");
                    String nomeFuncionario = leitor.nextLine();

                    System.out.print("\nCargo do funcionário: ");
                    String cargoFuncionario = leitor.nextLine();

                    System.out.print("\nEmail do funcionário: ");
                    String emailFuncionario = leitor.nextLine();

                    System.out.print("\nSalario do funcionário: ");
                    double salarioFuncionario = leitor.nextDouble();
                    leitor.nextLine();

                    System.out.print("\nTelefone do funcionario: ");
                    String telefoneFuncionario = leitor.nextLine();

                    Funcionario novoFuncionario = new Funcionario(nomeFuncionario,cargoFuncionario,emailFuncionario,salarioFuncionario,telefoneFuncionario);


                    if (hotel1.adicionarFuncionario(novoFuncionario)) {
                        System.out.println("Funcionario adicionado com sucesso");
                    } else {
                        System.out.println("Não foi possivel adicionar o funcionario");
                    }
                    break;
                case 7:
                    System.out.print("\nNome do hospede: ");
                    String nomeHospede = leitor.nextLine();

                    System.out.print("\nEmail do hospede: ");
                    String emailHospede = leitor.nextLine();

                    System.out.print("\nCPF do hospede: ");
                    String documentoHospede = leitor.nextLine();

                    System.out.print("\nTelefone do hospede: ");
                    String telefoneHospede = leitor.nextLine();

                    Hospede novoHospede = new Hospede(nomeHospede,emailHospede,documentoHospede,telefoneHospede);
                    if(hotel1.adicionarHospede(novoHospede)) {
                        System.out.println("Hospede adicionao com sucesso.");
                    }

                case 8:
                    hotel1.listarHospedes();
                default:
                    System.out.println("Função desconhecida. Tente Novamente!");
                    break;
            }
        } while (acao != 0);
    }
}