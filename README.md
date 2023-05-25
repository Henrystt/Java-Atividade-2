# Java-Atividade-2
Desenvolvi um sistema em Java para ser utilizado por farmácias, com o objetivo de permitir o cadastro de três tipos diferentes de parceiros essenciais: funcionários, clientes e fornecedores.
Fiz as seguintes considerações: todos os funcionários e clientes devem ser pessoas físicas, enquanto todos os fornecedores devem ser pessoas jurídicas.

Para atender a esse requisito, implementei um sistema que mantém dados cadastrais comuns a todos os parceiros, além de dados específicos para cada tipo de parceiro. Os dados a serem registrados nos cadastros incluem: Código (número inteiro para identificação), Nome (nome completo para funcionários e clientes, nome fantasia para fornecedores), Telefone (telefone residencial para funcionários e clientes, telefone comercial para fornecedores) e E-mail (qualquer e-mail de contato).

Além disso, incluí validações na entrada de dados para garantir que informações inválidas não sejam gravadas nos cadastros. Por exemplo, nos cadastros de funcionários, registrei o número da CTPS (Carteira de Trabalho e Previdência Social) e a série da CTPS. Nos cadastros de clientes, incluí o número de telefone celular, número de RG e número de CPF. Nos cadastros de fornecedores, incluí a razão social, o número de Inscrição Estadual (IE) e o número no Cadastro Nacional de Pessoas Jurídicas (CNPJ).

Com a implementação dessas funcionalidades, o sistema permite o cadastro correto e válido dos parceiros e seus respectivos dados, garantindo a integridade das informações. A utilização de métodos para validação dos dados de entrada é fundamental para assegurar a consistência do sistema.

Esse projeto foi uma excelente oportunidade para praticar a linguagem Java e a aplicação de conceitos como herança, polimorfismo e encapsulamento. Estou satisfeito com os resultados alcançados e com o conhecimento adquirido durante o desenvolvimento desse sistema para farmácias
