# O GRANDE CINEMA
Sistema distribuído simples com nós de gerenciamento simulando um cinema.

## Instalação
É necessário ter instalado os seguintes:
1. IntelliJ
2. Leiningen
3. Java
4. Cursive: o cursive pode ser instalado pelos plugins do IntelliJ e já possui o Leiningen

## Execução
Para executar é muito simples:

1. Altere o arquivo cinema.clj como desejar com os exemplos expostos e salve o arquivo
2. Execute "lein run" no terminal
3. Observe os resultados

## Explicação
Este sistema em Clojure é uma abstração simples que simula um sistema distribuído para gerenciamento de filmes e salas. Com o atom podemos gerencias os estados compartilhados, semelhante a sistemas distribuídos, e cada namespace funciona como um nó especializado em uma função específica. 
Embora não explicitamente, o core.async é criado para lidar com concorrência, como em sistemas distribuídos. 
A interação dos namespaces imita a comunicação entre diferentes nós no sistema distribuído. 
Nesse sistema, possuímos quatro nós: o de cadastro de filmes, que cadastra e lista novos filmes, o de gerenciamento de filmes, que remove ou busca um filme, o de gerenciamento de salas, que lista, atualiza e remove salas, e o de união entre filme e sala, que permite que um filme seja exibido numa sala disponível.


