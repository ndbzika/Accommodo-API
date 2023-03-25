public class AccommodoApp {
    public static void main(String[] args) {
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
        int numeroDeQuartos = quartos.length;
        String recomendacao = quarto3.nome;
        int promocaoDaRecomendacao = quarto3.preco - (quarto3.preco * 3/10);

        System.out.printf("Nosso hotel possui %d quartos, estamos com vagas e prontos para recebê-los!\n", numeroDeQuartos);
        System.out.println("\nRecomendação do dia: " + recomendacao);
        System.out.printf("Por apenas R$%d,00 (á vista).\n", promocaoDaRecomendacao);
        
        for (Quarto quarto : quartos) {
            if (quarto.disponivel == true) {
                System.out.printf("\nO quarto %s, com numero %d está disponivel. \nSeu valor é de R$%d,00.\n",quarto.nome ,quarto.numero ,quarto.preco);
            } else {
                System.out.printf("\nO quarto %s está ocupado.\n", quarto.nome);
            }
        }
        
    }
}