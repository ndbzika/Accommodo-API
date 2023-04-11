import java.util.Scanner;

public class AccommodoApp {
    public static void main(String[] args) {
        String[] possiveisServicos = {"Academia","Aceita animais","Almoço","Bar","Buffet","Café da manhã","Internet","Estacionamento"};

        Hotel hotel1 = new Hotel();
        hotel1.nome = "Adam Lake";
        hotel1.estrelas = 4;
        hotel1.serviços = possiveisServicos;

        Quarto quarto1 = new Quarto();
        quarto1.nome = "Básico";
        quarto1.numero = 11;
        quarto1.andar = 0;
        quarto1.preco = 100;
        quarto1.disponivel = true;

        Quarto quarto2 = new Quarto();
        quarto2.nome = "Executivo";
        quarto2.numero = 12;
        quarto2.andar = 0;
        quarto2.preco = 160;
        quarto2.disponivel = false;

        Quarto quarto3 = new Quarto();
        quarto3.nome = "Suíte Básica";
        quarto3.numero = 13;
        quarto3.andar = 1;
        quarto3.preco = 230;
        quarto3.disponivel = true;
        
        Quarto quarto4 = new Quarto();
        quarto4.nome = "Suíte Master";
        quarto4.numero = 14;
        quarto4.andar = 2;
        quarto4.preco = 300;
        quarto4.disponivel = true;

        Quarto[] quartos = {quarto1,quarto2,quarto3,quarto4};
        hotel1.quartos = quartos;
        int numeroDeQuartos = hotel1.quartos.length;
        String recomendacao = quarto3.nome;
        int promocaoDaRecomendacao = quarto3.preco - (quarto3.preco * 3/10);

        // Pegar todas as ações do usuario.
        // *Jogar informações num banco de dados, se possivel (opcional)

        Scanner leitor = new Scanner(System.in);


        int acao;

        do {

            System.out.println("=== Hotel X - Controle de usuário ===");
            System.out.println("---== Seu conforto nossa alegria ==---\n");
            System.out.println("- Qual ação gostaria de realizar? -");
            System.out.println("1 - Listar todos os quartos");
            System.out.println("2 - Informações do hotel");
            System.out.println("3 - Fazer reserva de um quarto");
            System.out.println("4 - Feedback do quarto e hotel");
            System.out.println("5 - Recomendação do dia");
            System.out.println("0 - Sair");
            
            acao = leitor.nextInt();

            switch (acao) {
                case 1:
                for (Quarto quarto : hotel1.quartos) {
                    if (quarto.disponivel == true) {
                        System.out.printf("\nO quarto %s, n° %d está disponivel. \nSeu valor é de R$%d,00.\n",quarto.nome ,quarto.numero ,quarto.preco);
                    } else {
                        System.out.printf("\nO quarto %s está ocupado.\n", quarto.nome);
                    }
                }
                break;
                case 2:
                    System.out.printf("\nNosso hotel possui %d quartos, estamos com vagas e prontos para recebê-los!\n", numeroDeQuartos);
                    break;
                case 3:
                    int reservarQuarto = 0;
                    System.out.println("\nQual quarto gostaria de reservar:");
                    System.out.println("99 - Voltar");
    
                    for(int i = 0; i < numeroDeQuartos; i++) {
                        if (quartos[i].disponivel == true) {
                            System.out.println((i + 1) + " - " + quartos[i].nome + " n° " + quartos[i].numero);
                        }
                    }
    
                    // obter quarto que será reservado aqui, na variavel reservarQuarto
                    // criar logica para saber qual quarto escolheu e mudar disponivel para false
                    break;
                case 4:
                    int acaoFeedback = 2;
                    System.out.println("\nOnde deseja deixar o feedback:");
                    System.out.println("1 - Hotel");
                    System.out.println("2 - Quarto");
                    System.out.println("99 - Voltar");
    
                    switch (acaoFeedback) {
                        case 1:
                            int ratingHotel = 0;
                            int acaoRatingHotel = 4;
                            System.out.println("\nQuantas estrelas você deixará para nosso Hotel:");
                            System.out.println("0 - Realmente não gostei");
                            System.out.println("1 - Não é meu tipo");
                            System.out.println("2 - Poderia melhorar em algumas coisas");
                            System.out.println("3 - Razoável");
                            System.out.println("4 - Gostei bastante");
                            System.out.println("5 - Amei! Experiencia incrivel!");
                            System.out.println("99 - Voltar");
    
                            switch (acaoRatingHotel) {
                                case 0:
                                    ratingHotel = 0;
                                    break;
                                case 1:
                                    ratingHotel = 1;
                                    break;
                                case 2:
                                    ratingHotel = 2;
                                    break;
                                case 3:
                                    ratingHotel = 3;
                                    break;
                                case 4:
                                    ratingHotel = 4;
                                    break;
                                case 5:
                                    ratingHotel = 5;
                                    break;
                                case 99:
                                    break;
                                default:
                                    System.out.println("\nPor favor informe um numero de 0 a 5.");
                                    break;
                            }
                            hotel1.estrelas = ratingHotel;
    
                            System.out.println("\nDeixe seu comentário para o hotel aqui:");
                            // obter comentário aqui e colocar na variavel cometarioQuarto
    
                            break;
    
                            case 2:
                            int ratingQuarto = 0;
                            int acaoRatingQuarto = 4;
                            System.out.println("\nQuantas estrelas você deixará para nosso quarto:");
                            System.out.println("0 - Realmente não gostei");
                            System.out.println("1 - Não é meu tipo");
                            System.out.println("2 - Poderia melhorar em algumas coisas");
                            System.out.println("3 - Razoável");
                            System.out.println("4 - Gostei bastante");
                            System.out.println("5 - Amei! Experiencia incrivel!");
                            System.out.println("99 - Voltar");
    
    
                            switch (acaoRatingQuarto) {
                                case 0:
                                    ratingQuarto = 0;
                                    break;
                                case 1:
                                    ratingQuarto = 1;
                                    break;
                                case 2:
                                    ratingQuarto = 2;
                                    break;
                                case 3:
                                    ratingQuarto = 3;
                                    break;
                                case 4:
                                    ratingQuarto = 4;
                                    break;
                                case 5:
                                    ratingQuarto = 5;
                                    break;
                                case 99:
                                    break;
                                default:
                                    System.out.println("\nPor favor informe um numero de 0 a 5.");
                                    break;
                            }
                        
                            System.out.println("\nDeixe seu comentário para o quarto aqui:");
                            String cometarioQuarto = "";
                            // obter comentário aqui
    
                            break;
    
                    
                        default:
                            System.out.println("\nPor favor insira uma das opções acima.");
                            break;
                    }
    
                    break;
                case 5:
                    System.out.println("\nRecomendação do dia: " + recomendacao);
                    System.out.printf("Por apenas R$%d,00 (á vista).\n", promocaoDaRecomendacao);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Função desconhecida. Tente Novamente!");
                    break;
            }
        } while (acao != 0);
    }
}