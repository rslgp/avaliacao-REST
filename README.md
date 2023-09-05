# avaliacao-REST PACTOMAIS

parte 1
Você irá implementar um controle de transação de credito em conta com cartão obedecendo as
seguintes regras:
1. Cada portador de cartão (cliente) possui uma conta com seus dados;
2. A cada operação realizada pelo cliente uma transação é criada e associada à sua respectiva
conta;
3. Cada transação possui um tipo (compra a vista, compra parcelada, saque ou pagamento), um
valor e uma data de criação;
4. Transações de tipo compra e saque são registradas com valor negativo, enquanto transações
de pagamento são registradas com valor positivo.

parte 2
A partir do caso desenvolvido na primeira etapa, limitar o crédito disponível para uma conta
com as seguintes regras:
A. O limite disponível de crédito deve ser abatido a cada transação feita e nunca pode ser
menor que 0 (zero). Ou seja, uma transação maior do que o limite disponível de crédito
deve ser recusada.
B. Transações de pagamento devem aumentar o limite disponível.
Exemplo 1:
1) Para uma conta com limite 100, ao fazer um saque no valor de 30 o limite deve passar
a ser de 70.
2) Ao tentar fazer uma nova transação de saque no valor de 80 devemos recusá-la, pois o
limite disponível agora é de apenas 70.
3) Assim que é emitida uma transação de pagamento no valor de 20, o limite disponível
aumenta para 90.
