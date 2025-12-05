# Curso Completo de Assembly x86

## <img src="https://img.shields.io/badge/Assembly-x86-blueviolet?style=for-the-badge&logo=assemblyai&logoColor=white" alt="Logo Assembly x86"> Introdução ao Assembly x86

Olá, futuro(a) programador(a) de baixo nível!

Bem-vindo(a) ao seu curso completo de Assembly x86, o idioma que o processador do seu computador realmente entende. Se você sempre quis saber como os programas funcionam "por baixo do capô", manipular a memória diretamente, otimizar código para a máxima performance, ou simplesmente ter uma compreensão mais profunda da arquitetura de computadores, você está no lugar certo.

Neste curso, vamos desmistificar a programação em Assembly, uma linguagem poderosa, mas frequentemente intimidante. Abordaremos os conceitos fundamentais da arquitetura x86, a sintaxe das instruções, o gerenciamento de registradores e memória, e como interagir com o sistema operacional.

Prepare-se para uma jornada fascinante no coração do seu hardware!

---

## 🚀 Módulo 1: Fundamentos da Arquitetura x86

### 1.1 O Que é Assembly?

Assembly é uma linguagem de programação de baixo nível que possui uma correspondência quase um para um com o código de máquina (a sequência de bits que o processador executa). Cada instrução em Assembly geralmente corresponde a uma única operação que o CPU pode realizar.

Enquanto linguagens de alto nível como Python, Java ou C# abstraem a complexidade do hardware, Assembly nos coloca em contato direto com ele. Isso nos dá controle incomparável, mas também exige uma compreensão mais detalhada de como o hardware funciona.

### 1.2 Por Que Aprender Assembly?

* **Compreensão Profunda:** Entender como os programas são executados no nível mais fundamental.
* **Otimização:** Escrever código extremamente rápido para tarefas críticas.
* **Drivers de Dispositivo:** Desenvolver programas que interagem diretamente com o hardware.
* **Sistemas Operacionais:** Construir componentes essenciais de sistemas operacionais.
* **Engenharia Reversa:** Analisar e entender o funcionamento de programas existentes (malware, por exemplo).
* **Segurança:** Entender vulnerabilidades e como elas são exploradas.

### 1.3 Arquitetura x86 e Seus Registradores

A arquitetura x86 (e suas extensões como x64) é a base da maioria dos computadores pessoais modernos. Um componente central de qualquer CPU são os **registradores**: pequenas áreas de armazenamento dentro do próprio processador que ele usa para realizar operações de forma muito rápida.

Vamos começar com os registradores mais comuns na arquitetura x86 de 32 bits:

#### Registradores de Propósito Geral (General Purpose Registers - GPRs):

Estes são os cavalos de batalha do Assembly, usados para a maioria das operações de dados e cálculos. Cada um tem 32 bits de tamanho (quando estamos falando de arquitetura de 32 bits, como `EAX`). Eles podem ser acessados em partes menores:
* `EAX` (Extended Accumulator Register): Usado para operações aritméticas, retorno de funções.
    * `AX` (16 bits): Metade inferior de `EAX`.
        * `AH` (8 bits): Metade superior de `AX`.
        * `AL` (8 bits): Metade inferior de `AX`.
* `EBX` (Extended Base Register): Usado como ponteiro base para endereços de memória.
    * `BX` (16 bits)
        * `BH` (8 bits)
        * `BL` (8 bits)
* `ECX` (Extended Counter Register): Usado como contador em loops e operações de string.
    * `CX` (16 bits)
        * `CH` (8 bits)
        * `CL` (8 bits)
* `EDX` (Extended Data Register): Usado para operações de E/S (entrada/saída) e como parte de operações aritméticas de 32/64 bits.
    * `DX` (16 bits)
        * `DH` (8 bits)
        * `DL` (8 bits)

#### Registradores de Ponteiro e Índice:

* `ESP` (Extended Stack Pointer): Aponta para o topo da pilha de execução. Crucial para chamadas de função.
* `EBP` (Extended Base Pointer): Usado como um ponteiro base para o frame da pilha, facilitando o acesso a variáveis locais e parâmetros de função.
* `ESI` (Extended Source Index): Usado como ponteiro de origem para operações de string e cópia de dados.
* `EDI` (Extended Destination Index): Usado como ponteiro de destino para operações de string e cópia de dados.

#### Registrador de Status (EFLAGS):

* `EFLAGS`: Contém um conjunto de bits (flags) que refletem o resultado da última operação aritmética ou lógica, ou controlam o comportamento da CPU. Exemplos de flags importantes:
    * `ZF` (Zero Flag): Setado se o resultado da operação for zero.
    * `CF` (Carry Flag): Setado se houver um "vai um" ou "empresta um" em operações aritméticas.
    * `SF` (Sign Flag): Setado se o resultado for negativo (bit mais significativo é 1).
    * `OF` (Overflow Flag): Setado se houver um estouro de capacidade em operações aritméticas assinadas.

#### Registradores de Segmento (Segment Registers - Mais relevantes em modos mais antigos):

* `CS` (Code Segment): Contém o endereço base do segmento de código (onde as instruções do programa estão).
* `DS` (Data Segment): Contém o endereço base do segmento de dados.
* `SS` (Stack Segment): Contém o endereço base do segmento de pilha.
* `ES`, `FS`, `GS`: Registradores de segmento extras para dados.

### 1.4 Nossa Primeira Instrução: `MOV` (Move)

A instrução `MOV` é uma das mais fundamentais e frequentemente usadas em Assembly. Ela move dados de uma origem para um destino.

**Sintaxe geral:** `MOV destino, origem`

**Regras:**
* A origem e o destino devem ter o mesmo tamanho (ex: 8 bits, 16 bits, 32 bits).
* Não é possível mover diretamente de memória para memória. Um registrador deve ser usado como intermediário.
* Um valor imediato (um número direto) pode ser movido para um registrador ou para a memória.

#### Exemplos de Código:

Vamos usar a sintaxe do **NASM (Netwide Assembler)**, que é bastante comum e clara.

```assembly
; Este é um comentário em Assembly NASM

; Mover um valor imediato para um registrador de 32 bits
MOV EAX, 12345      ; EAX = 12345

; Mover um valor imediato para um registrador de 16 bits
MOV BX, 500         ; BX = 500

; Mover um valor imediato para um registrador de 8 bits
MOV AL, 'A'         ; AL = ASCII de 'A' (65)

; Mover o conteúdo de um registrador para outro
MOV EBX, EAX        ; EBX = EAX (agora EBX também é 12345)

; Mover a parte inferior de um registrador para outro
MOV CL, AL          ; CL = AL (agora CL também é 'A' ou 65)

; Exemplo de como usar a memória (abordaremos memória mais a fundo depois)
; Supondo que 'minha_variavel' seja um local na memória
; MOV DWORD [minha_variavel], EAX  ; Mover o conteúdo de EAX para 'minha_variavel' (4 bytes)
; MOV EAX, DWORD [minha_variavel]  ; Mover o conteúdo de 'minha_variavel' para EAX

; Atenção: Isso é INVÁLIDO!
; MOV [minha_variavel], [outra_variavel] ; Não é possível mover diretamente de memória para memória
; Você precisaria de um registrador intermediário:
; MOV EAX, DWORD [outra_variavel]
; MOV DWORD [minha_variavel], EAX
```
---
No próximo módulo, vamos configurar nosso ambiente de desenvolvimento para Assembly e compilar e executar nosso primeiro
 programa!
---
💾 Módulo 2: Variáveis e Dados na Memória
2.1 O Segmento de Dados (.data)
Em Assembly, as variáveis são criadas e armazenadas em uma área da memória chamada segmento de dados. Usando o assembler NASM, definimos este segmento com a diretiva .data.

A sintaxe para definir uma variável é: nome_variavel diretiva_tamanho valor_inicial

Diretivas de Tamanho (Data Definition Directives):
Diretiva	Nome Completo	Tamanho (Bytes)	Usos Comuns
DB	Define Byte	1 byte	Caracteres, strings curtas, números pequenos.
DW	Define Word	2 bytes	Números inteiros de até 65535.
DD	Define Doubleword	4 bytes	Inteiros de 32 bits, endereços de memória.
DQ	Define Quadword	8 bytes	Inteiros de 64 bits.

Exemplos de Definição de Variáveis:
Snippet de código

section .data
    ; Variável de número (32 bits - DD)
    numero_da_vida DD 42

    ; Variável de texto (string - DB)
    ; O '10' é o caractere de quebra de linha (Line Feed)
    ; O '0' é o terminador de string (null terminator)
    mensagem DB "Ola, Assembly!", 10, 0 

    ; Variável de byte único
    status_flag DB 1

    ; Variável de 4 bytes sem valor inicial (reservando espaço)
    resultado RESD 1
2.2 Acessando Variáveis: Ponteiros e MOV
Quando usamos o nome da variável (numero_da_vida) em uma instrução, o Assembly a interpreta como o endereço de memória onde o dado está armazenado.

Para obter o valor armazenado na variável, usamos a sintaxe de colchetes [], que indica que queremos ler (ou escrever) no endereço de memória.

Snippet de código

; Supondo que 'numero_da_vida' (DD = 4 bytes) armazene 42

; Mover o VALOR (42) para o registrador EAX
MOV EAX, [numero_da_vida] 

; Mover o ENDEREÇO (o ponteiro) de 'numero_da_vida' para EBX
MOV EBX, numero_da_vida 

; Mover o valor de EAX (que é 42) de volta para a variável
MOV [numero_da_vida], EAX 
2.3 👋 Nosso Primeiro Programa: Mostrar uma String
Para interagir com o sistema operacional (como Linux ou Windows) e mostrar algo na tela, precisamos usar as Chamadas de Sistema (System Calls). Aqui, usaremos o padrão Linux de 32 bits, que é simples e direto.

As chamadas de sistema são acionadas pela instrução INT 0x80 e usam registradores específicos para passar parâmetros (argumentos).

Tabela de Chamadas de Sistema (Linux 32-bit):
Função	Código (EAX)	Parâmetros (EBX, ECX, EDX)
sys_write (Escrever na tela)	4	EBX (File Descriptor), ECX (Endereço da String), EDX (Tamanho da String)
sys_exit (Sair do programa)	1	EBX (Código de Retorno)

Código Completo: Exibir Mensagem e Número
Este programa exibe a string definida e o valor da variável numero_da_vida (embora a conversão de número para texto para exibição direta seja complexa em Assembly, vamos focar primeiro na string).

Snippet de código

; Primeira Linha - Define o formato do arquivo de saída (executável)
section .text
    global _start       ; Ponto de entrada do programa (onde a execução começa)

_start:
    ; ----------------------------------------------------
    ; 1. EXIBIR A MENSAGEM (sys_write = 4)
    ; ----------------------------------------------------
    MOV EAX, 4          ; Coloca o código da função 'sys_write' em EAX
    MOV EBX, 1          ; Coloca 1 (File Descriptor para STDOUT - tela) em EBX
    MOV ECX, mensagem   ; Coloca o endereço da nossa string em ECX
    MOV EDX, len_mensagem ; Coloca o tamanho da nossa string em EDX
    INT 0x80            ; Executa a chamada de sistema (o texto aparece na tela)

    ; ----------------------------------------------------
    ; 2. SAIR DO PROGRAMA (sys_exit = 1)
    ; ----------------------------------------------------
    MOV EAX, 1          ; Coloca o código da função 'sys_exit' em EAX
    MOV EBX, 0          ; Coloca 0 (código de retorno de sucesso) em EBX
    INT 0x80            ; Executa a chamada de sistema (o programa termina)

; ----------------------------------------------------
; DEFINIÇÃO DOS DADOS (Variáveis)
; ----------------------------------------------------
section .data
    ; Definição da nossa string
    mensagem DB "Este eh o meu primeiro programa em Assembly!", 10 ; 10 = nova linha
    
    ; Calcular o tamanho da string (metadado para o programa)
    len_mensagem EQU $ - mensagem 
    
    ; Definição do número (32 bits)
    numero_da_vida DD 42
2.4 Como Compilar e Executar (Linux/WSL)
Para transformar o código acima em um programa executável, você precisará do NASM (Assembler) e do LD (Linker).

Salvar o Código: Salve o código acima em um arquivo chamado primeiro.asm.

Assemblar (NASM): Transforma o código Assembly em um arquivo Objeto (.o).

Bash

nasm -f elf primeiro.asm -o primeiro.o
Linkar (LD): Transforma o arquivo Objeto em um executável.

Bash

ld -m elf_i386 primeiro.o -o primeiro
Executar:

Bash

./primeiro
Saída Esperada:

Este eh o meu primeiro programa em Assembly!
Próximos Passos:
No próximo módulo, vamos aprender sobre as instruções aritméticas e lógicas (ADD, SUB, AND, OR) e como realmente manipular os dados em Assembly.