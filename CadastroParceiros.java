import java.util.Scanner;

public class CadastroParceiros {
    private static final int MAX_PARCEIROS = 50;
    private int quantidadeParceiros = 0;
    private Parceiros[] parceiros = new Parceiros[MAX_PARCEIROS];
    private Scanner scanner = new Scanner(System.in);

    public void cadastrarParceiro() {
        if (quantidadeParceiros >= MAX_PARCEIROS) {
            System.out.println("Erro: limite máximo de parceiros atingido.");
            return;
        }

        System.out.print("Digite o código: ");
        int codigo; 

        //validar codigo
    do{
        codigo = scanner.nextInt();
            if (validarCod(codigo, 1, 1000)){
                System.out.print("Digite o nome e sobrenome: ");
            }else{
                System.out.println("Codigo errado, favor insira o codigo dentro do paramento");
            }
    }while(!validarCod(codigo, 1, 1000));

        // Limpar o buffer do scanner
        scanner.nextLine(); 

        String nome;

        //validar Nome
    do{
        nome = scanner.nextLine();
        if(validarString(nome)){
            System.out.print("Digite o telefone: ");
        }else{
            System.out.println("Nome inválido. Favor inserir nome e sobrenome completos, sem abreviações, um de cada.");
        }
    }while(!validarString(nome));

        String telefone;
        
        //validar telefone
    do{
        telefone = scanner.nextLine();
        if (validarTelefone(telefone)) {
            System.out.print("Digite o e-mail: ");
        } else {
            System.out.println("Telefone inválido. Deve estar no formato (xx)xxxx-xxxx e ter no máximo 13 caracteres.");
        }
    }while(!validarTelefone(telefone));

        String email;

        //validar email
    do{
        email = scanner.nextLine();
        if(validarEmail(email)){
            System.out.print("Tipo de parceiro (1-Funcionário, 2-Cliente, 3-Fornecedor): ");
        }else{
            System.out.println("Email invalido, confirme se tem somente um aroba no email fornecido.");
        }
    }while(!validarEmail(email));

        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        switch (tipo) {
            case 1:
                System.out.print("Digite o número da CTPS: ");
                int ctps;

                //validar ctps
            do{
                ctps = scanner.nextInt();
                if (validarCtps(ctps, 1, 5000)){
                    Funcionarios funcionario = new Funcionarios(codigo, nome, telefone, email, ctps);
                    parceiros[quantidadeParceiros] = funcionario;
                    quantidadeParceiros++;                
                }else{
                    System.out.println("Codigo errado, favor insira o codigo dentro do paramento");
                }
            }while(!validarCtps(ctps, 1, 5000));
                
            System.out.println("Funcionário cadastrado com sucesso.");
                break;

            case 2:
                System.out.print("Digite o número de celular: ");
                String celular;

                //validar celular
            do{
                celular = scanner.nextLine();
                if(validarCelular(celular)){
                    System.out.print("Digite o número do RG: ");
                }else{
                    System.out.println("celular inválido. Deve estar no formato (xx)9xxxx-xxxx e ter no máximo 14 caracteres.");

                }
            }while(!validarCelular(celular));

                String rg;
                //validar rg
            do{
                rg = scanner.nextLine();
                if(validarRg(rg)){
                    System.out.print("Digite o número do CPF: ");
                }else{
                    System.out.println("O documento RG deve conter entre 8 e 11 numeros");
                }
            }while(!validarRg(rg));

                String cpf = scanner.nextLine();

                Cliente cliente = new Cliente(codigo, nome, telefone, email, celular, rg, cpf);
                parceiros[quantidadeParceiros] = cliente;
                quantidadeParceiros++;
                System.out.println("Cliente cadastrado com sucesso.");
                break;

            case 3:
                System.out.print("Digite a razão social: ");
                String razaoSocial;

                //validar razão social
            do{
                razaoSocial = scanner.nextLine();
                if(validarString(razaoSocial)){
                    System.out.print("Digite o número da Inscrição Estadual: ");
                }else{
                    System.out.println("Razão social inválida. Favor inserir a Razão social completa, sem abreviações.");
                }
            }while(!validarString(razaoSocial));

                String inscricaoEstadual;

                //validar ie
            do{
                inscricaoEstadual = scanner.nextLine();
                if(validarIe(inscricaoEstadual)){
                    System.out.print("Digite o número do CNPJ: ");
                }else{
                    System.out.println("Inscrição Estadual deve ter no maximo 15 letras");
                }
            }while(!validarIe(inscricaoEstadual));

                String cnpj;
                
                //validar cnpj
            do{
                cnpj = scanner.nextLine();
                if(validarCNPJ(cnpj)){
                    Fornecedor fornecedor = new Fornecedor(codigo, nome, telefone, email, razaoSocial, inscricaoEstadual, cnpj);
                    parceiros[quantidadeParceiros] = fornecedor;
                    quantidadeParceiros++;
                }else{
                    System.out.println("CNPJ invalido, verifique novamente");
                }
            }while(!validarCNPJ(cnpj));
            

                System.out.println("Fornecedor cadastrado com sucesso.");
                break;

            default:
                System.out.println("Tipo de parceiro inválido.");
                break;
        }
    }

    public static void main(String[] args) {
        CadastroParceiros cadastro = new CadastroParceiros();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("======= MENU =======");
            System.out.println("1 - Cadastrar Parceiro");
            System.out.println("2 - Exibir Parceiro");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    cadastro.cadastrarParceiro();
                    break;
                case 2:
                System.out.println("=====================");
                    cadastro.exibirUltimoParceiro();
                System.out.println("=====================");
                break;

                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }


    //validar parte 1
    public static boolean validarCod(int cod, int min, int max){  
    return cod >=  min && cod <= max;
    }

    public static boolean validarString(String texto) {
        String[] palavras = texto.split(" ");
        
        // Verificar se existem exatamente duas palavras
        if (palavras.length != 2) {
            return false;
        }
        
        // Verificar se cada palavra tem no mínimo dois caracteres
        for (String palavra : palavras) {
            if (palavra.length() < 2) {
                return false;
            }
        }

        return true;
    }

    public static boolean validarTelefone(String telefone) {
        // Remover espaços em branco e caracteres especiais
        String numeroLimpo = telefone.replaceAll("\\s", "");
        
        // Verificar se o número tem no máximo 13 caracteres
        if (numeroLimpo.length() > 13) {
            return false;
        }
        
        // Verificar o formato do número usando expressão regular
        if (!numeroLimpo.matches("\\(\\d{2}\\)\\d{4}-\\d{4}")) {
            return false;
        }
        
        return true;
    }
    
    public static boolean validarEmail(String email) {
        String[] Email = email.split("@");
        
        // Verificar se existem exatamente duas palavras
        if (Email.length != 2) {
            return false;
        }
        
        // Verificar se cada palavra tem no mínimo dois caracteres
        for (String tamanho : Email) {
            if (tamanho.length() < 2) {
                return false;
            }
        }

        return true;
    }

    //validar parte 2(switch)
    public static boolean validarCtps(int ctps, int min, int max){  
        return ctps >=  min && ctps <= max;
        }

    public static boolean validarCelular(String celular) {
            // Remover espaços em branco e caracteres especiais
            String numeroLimpo = celular.replaceAll("\\s", "");
            
            // Verificar se o número tem no máximo 13 caracteres
            if (numeroLimpo.length() > 14) {
                return false;
            }
            
            // Verificar o formato do número usando expressão regular
            if (!numeroLimpo.matches("\\(\\d{2}\\)9\\d{4}-\\d{4}")) {
                return false;
            }
            
            return true;
        }

    public static boolean validarRg(String rg){
        int comprimento = rg.length();

        return comprimento >= 8 && comprimento <= 11;
    }

    public static boolean validarIe(String ie){
        int comprimento = ie.length();

        return comprimento >= 1 && comprimento <= 15;
    }

    public static boolean validarCNPJ(String cnpj){
        int comprimento = cnpj.length();

        return comprimento == 18;
    }

    public void exibirUltimoParceiro() {
        if (quantidadeParceiros > 0) {
            int indiceUltimoParceiro = quantidadeParceiros - 1;
            Parceiros ultimoParceiro = parceiros[indiceUltimoParceiro];
            System.out.println("Informações do último parceiro cadastrado:");
            System.out.println("Código: " + ultimoParceiro.getCodigo());
            System.out.println("Nome: " + ultimoParceiro.getNome());
            System.out.println("Telefone: " + ultimoParceiro.getTelefone());
            System.out.println("Email: " + ultimoParceiro.getEmail());
    
            // Verificar o tipo de parceiro
            if (ultimoParceiro instanceof Funcionarios) {
                Funcionarios funcionario = (Funcionarios) ultimoParceiro;
                System.out.println("CTPS: " + funcionario.getCtps());
            } else if (ultimoParceiro instanceof Cliente) {
                Cliente cliente = (Cliente) ultimoParceiro;
                System.out.println("Celular: " + cliente.getCelular());
                System.out.println("RG: " + cliente.getRg());
                System.out.println("CPF: " + cliente.getCpf());
            } else if (ultimoParceiro instanceof Fornecedor) {
                Fornecedor fornecedor = (Fornecedor) ultimoParceiro;
                System.out.println("Razão Social: " + fornecedor.getRazaoSocial());
                System.out.println("Inscrição Estadual: " + fornecedor.getInscricaoEstadual());
                System.out.println("CNPJ: " + fornecedor.getCnpj());
            }
        } else {
            System.out.println("Não há parceiros cadastrados.");
        }
    }
    
}
