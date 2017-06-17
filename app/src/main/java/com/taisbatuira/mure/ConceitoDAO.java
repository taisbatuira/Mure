package com.taisbatuira.mure;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.taisbatuira.mure.conceitos.Conceito;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by taisbatuira on 13/04/17.
 */

public class ConceitoDAO extends SQLiteOpenHelper{

    public static final String ORDEM_ALFABETICA = "titulo asc";
    public static final String ORDEM_DIDATICA = "ordem asc";

    private static final String P1 = "\t\t\t\t"; // PARAGRAFO
    private static final String L1 = "\n"; // NOVA_LINHA
    private static final String P2 = "&emsp;"; // PARAGRAFO NO HTML
    private static final String L2 = "<br/>"; // NOVA LINHA NO HTML


    public ConceitoDAO(Context context) {
        super(context,"mure", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String tabela = "create table conceitos (ordem double, titulo varchar, conteudo text, exemplo text, tipo varchar);";
        db.execSQL(tabela);

        insere(db, 1.0, "HELLO WORLD!",
                P1 + "A linguagem que usaremos para exemplificação é o Java, considerada uma das principais linguagens Orientadas a Objetos.\n" +
                        L1 + P1 + "A história dessa linguagem pode ser consultada em  http://www.java.com/en/javahistory/\n" +
                        L1 +
                        P1 + "Java não possui muitas regras, o que o torna simples.\n" +
                        L1 + P1 + "Algumas regras iniciais:\n" +
                        P1 + "- O Java é case sensitive. Como boas práticas, usamos letra Maiúscula para nomes de classes e minúsculas para atritubos e métodos.\n" +
                        P1 + "- Toda linha deve ser finalizada com ponto-e-vírgula (;)\n" +
                        P1 + "- A aplicação java tem como ponto de entrada o main.\n" +
                        P1 + "- Manter dados e comportamentos próximos, respeitando a semântica.\n",
                " public class MeuPrograma {" +
                        L2 + P2 + " public static void main(String[] args) {" +
                        L2 + P2 + P2 + " System.out.println(\"Hello World!\");" +
                        L2 + P2 +"}" +
                        L2 + "}",
                "titulo");

        insere(db, 2.0, "VARIÁVEIS LOCAIS",
                P1 + "São variáveis auxiliares declaradas dentro do método e usadas localmente, ou seja, elas não existem fora deste escopo.",
                "public int getPatas() {" +
                        L2 + P2 + " int cachorroPatas = 4;" +
                        L2 + P2 + " return cachorroPatas;" +
                        L2 + "}",
                "titulo");

        insere(db, 2.1, "TIPOS PRIMITIVOS",
                P1 + "São tipos de variáveis que devolvem um valor.\n" +
                        L1 +
                        "TIPOS NUMÉRICOS\n" +
                        P1 + "- int, float, long, double.\n" +
                        P1 + "- O valor padrão é 0.\n" +
                        L1 +
                        "TIPO CONDIÇÃO\n" +
                        P1 + "- boolean.\n" +
                        P1 + "- O valor padrão é false.\n" +
                        L1 +
                        "TIPO CARACTERE\n" +
                        P1 + "- char\n" +
                        P1 + "- O valor padrão é um espaço vazio.\n",
                "int idade = 31;" +
                L2 + " double salario = 100.00;" +
                L2 + " boolean pagamentoEfetuado = true;",
                "subtitulo");

        insere(db, 2.2, "TIPOS DE REFERÊNCIA",
                P1 + "São tipos de variável que devolvem a posição de um endereço de memória.\n" +
                        L1 +
                        "TIPO STRING\n" +
                        P1 + "- O tipo String é uma classe que cria um vetor de char.\n " +
                        P1 + "- Seu valor padrão é null.\n",
                "String nome = \"Tais\"",
                "subtitulo");

        insere(db, 3.0, "CAST",
                P1 + "De forma simples, o Cast é uma modelagem que só pode ser realizada entre atributos do mesmo tipo, por exemplo atributos numéricos, pois permite que um atributo maior (que possua mais bytes) possa ocupar um espaço de memória equivalente a um atributo menor.\n" +
                        L1 +
                        P1 + "Em outras palavras, fazer um double ou um long (8 bytes cada) ocuparem um espaço de memória de um int ou um float (4 bytes cada).\n",
                " double d = 5.25;\n" +
                        L2 + " int i = (int) d;",
                "titulo");

        insere(db, 4.0, "SÍMBOLOS E OPERAÇÕES",
                P1 + "Em toda linguagem, alguns símbolos são usados para representar atribuições ou operações específicas, principalmente as básicas.\n" +
                        L1 +
                        "PADRÃO\n" +
                        P1 + "= Atribuição\n" +
                        L1 +
                        "MATEMÁTICA \n" +
                        P1 + "+ Soma\n" +
                        P1 + "- Subtração\n" +
                        P1 + "* Multiplicação\n" +
                        P1 + "/ Divisão\n" +
                        P1 + "% Resto da divisão inteira\n" +
                        L1 +
                        "COMPARAÇÃO\n" +
                        P1 + ">= Maior ou igual a\n" +
                        P1 + "<= Menor ou igual a\n" +
                        P1 + ">  Maior que\n" +
                        P1 + "<  Menor que\n" +
                        P1 + "== Igual a \n" +
                        P1 + "!= Diferente de\n" +
                        L1 +
                        "OPERADOR UNÁRIO\n" +
                        P1 + "!  Não\n" +
                        L1 +
                        "OPERADORES BINÁRIOS\n" +
                        P1 + "&& E/and\n" +
                        P1 + "|| OU/OR\n" +
                        P1 + "^ XOR\n" +
                        L1 +
                        "STRING\n" +
                        P1 + "+ concatenação",
                P2 + " int a = 3;" +
                        L2 + P2 + " int b = 5;" +
                        L2 + P2 + " int soma = a + b;" +
                        L2 + P2 + " int multiplicacao = a * b;" +
                        L2 + P2 + " if (a == b) {" +
                        L2 + P2 + P2 + " return \"iguais\";" +
                        L2 + P2 + " } else {" +
                        L2 + P2 + P2 + " return \"diferentes\";",
                "titulo");

        insere(db, 5.0, "ESTRUTURAS DE CONTROLE - CONDIÇÃO",
                P1 + "São estruturas que permitem determinar uma ou mais condições para que uma ação ocorra. Elas se baseiam em valores booleanos (true / false) para estipular qual ação deve ser executada. \n" +
                        L1+
                        P1 + "Em Java usa-se o IF / ELSE\n",
                " if (x == y) {" +
                        L2 + P2 + "//faça isso" +
                        L2 + " } else {" +
                        L2 + P2 + "//faça aquilo" +
                        L2 + "}",
                "titulo");

        insere(db, 6.0, "IF / ELSE",
                P1 + "Estrutura que permite estipular uma ou mais condições para disparar um evento específico.\n" +
                        L1 +
                        P1 + "Em situações com mais de uma condição, usamos símbolos auxiliares: \n" +
                        P1 + "- && (E / AND) - Ambas condições devem ser verdadeiras para que a sentença retorne true;\n" +
                        P1 + "- || (OU / OR) - Basta que uma das condições seja verdadeira para que a sentença retorne true.\n",
                " String animal;" +
                        L2 + " if (animal == \"cachorro\") {" +
                        L2 + P2 + " System.out.println(\"tem 4 patas!\");" +
                        L2 + " } else (animal == \"pássaro\") {" +
                        L2 + P2 + " System.out.println(\"tem 2 patas!\");" +
                        L2 + "}",
                "subtitulo");

        insere(db, 7.0, "ESTRUTURAS DE CONTROLE - REPETIÇÃO",
                P1 + "São estruturas que permitem criar um laço (loop) para que uma ação ocorra repetidamente, até que determinada condição pré estabelecida não seja atendida. \n" +
                        L1 + P1 + "Qualquer estrutura de repetição deve conter 4 elementos:\n" +
                        P1 + "- Um valor inicial, que é a condição inicial da repetição; (i=0)\n" +
                        P1 + "- A condição booleana que deve ser verificada após a execução do corpo e que determina se deverá haver uma  repetição ou não; (i < 4)\n" +
                        P1 + "- O corpo, onde estão as instruções que devem ser executadas repetidamente;\n" +
                        P1 + "- Uma iteração, a instrução que deve ser executada após o corpo e antes de uma nova repetição. (i++)\n" +
                        L1 +
                        P1 + "As estruturas usadas em Java são o FOR, WHILE e DO WHILE.\n",
                " for (int i=0; i < 4;i++) {" +
                        L2 + P2 +"//corpo" +
                        L2 +"}",
                "titulo");

        insere(db, 8.0, "WHILE",
                P1 + "É o laço mais comum das estruturas de repetição em Java.\n" +
                        L1 + P1 + "Declara-se o valor inicial. Em seguida, após a palavra while, informa-se a condição booleana entre parênteses. \n" +
                        L1 + P1 + "Dentro das chaves, desenvolve-se o corpo com as instruções e a iteração.\n",
                " int i = 0;" +
                        L2 + P2 + " while(i < 4) {" +
                        L2 + P2 + P2 + "//corpo " +
                        L2 + P2 + " i++;" +
                        L2+"}",
                "subtitulo");

        insere(db, 9.0, "FOR",
                P1 + "É um laço compacto das estruturas de repetição usadas no java. Apesar de ter uma representação diferente, é a mesma estrutura básica da repetição while.\n" +
                        L1 +
                        P1 + "Dos 4 elementos padrões, 3 sao declarados no cabeçalho, dentro de parênteses logo após a palavra for, sendo eles o valor inicial, a condição e a iteração, respectivamente. Em seguida, declara-se o corpo com as instruções dentro das chaves. \n",
                " for (int i=0; i < 4; i++) {" +
                        L2 + P2 +"//corpo" +
                        L2 +"}",
                "subtitulo");

        insere(db, 9.1, "DO WHILE",
                P1 + "A única diferença do DO WHILE para o WHILE é que no WHILE ele verifica a condição booleana antes de executar o corpo do código, enquanto que no DO WHILE ele vai executar o corpo ao menos uma vez, independente da condição, ou seja, ele só verifica a veracidade da condição no segundo laço. \n" +
                        L1 + P1 + "Declara-se o valor inicial. Coloca-se a palavra Do e dentro das chaves, desenvolve-se o corpo com as instruções e a iteração. \n" +
                        L1 + P1 + "Em seguida, após a palavra while, informa-se a condição booleana entre parênteses.\n",
                " int i = 0;" +
                        L2 + " do {" +
                        L2 + P2 +"//corpo" +
                        L2 + P2 + " i++;" +
                        L2 + "} while (i < 4);",
                "subtitulo");

        insere(db, 10.0, "CLASSE",
                P1 + "Uma classe é um conjunto de informações que especificam como deve ser o objeto a ser criado.\n" +
                        L1 +
                        P1 + "As propriedades deste objeto são definidas através dos atributos, cujos comportamentos são determinados ou manipulados através dos métodos (em C, é o equivalente às funções).\n"+
                        L1 +
                        P1 + "Por exemplo, a Classe seria o manual básico para definir um Animal.",
                " public class Animal",
                "titulo");

        insere(db,11.0, "ATRIBUTO OU VARIÁVEL DE OBJETO",
                P1 + "Os Atributos são os componentes (variáveis), manipuláveis ou não, de um objeto. \n" +
                        L1 + P1 + "Especifica-se um nome, um tipo, um valor padrão e sua visibilidade.\n" +
                        L1 + P1 + "São atributos do tipo primitivo e a visibilidade pode ser dos tipos private, public ou protected.",
                " public class Animal {\n" +
                        L2 + P2 + " private int patas;\n" +
                        L2 + P2 + " private string tipo;\n" +
                        L2 + P2 +"...\n" +
                        L2 + "}\n",
                "subtitulo");

        insere(db, 11.1, "VARIÁVEL ESTÁTICA",
                P1 + "Variável estática é um atributo de classe, e não uma variável de objeto. \n" +
                        L1 + P1 + "É um espaço de memória compartilhado por todos os objetos daquela classe; se o valor for alterado, será diretamente na classe e não no objeto. \n" +
                        L1 + P1 + "São atributos do tipo referência e a visibilidade pode ser dos tipos private, public ou protected.\n" +
                        L1 + P1 + "É útil em contadores de classe, por exemplo.\n",
                " static String nome = \"Tais\"",
                "subtitulo");

        insere(db, 12.0, "MÉTODO",
                P1 + "Os métodos são os comportamentos que serão aplicados aos atributos do meu objeto ou classe.\n" +
                        "Especifica-se um nome, um tipo de retorno do método, se ele recebe uma lista de argumentos e a visibilidade.\n" +
                        L1 +
                        "TIPO DE RETORNO\n" +
                        P1 + "Um método sem retorno deve ser definido como void. Ademais, o método pode retornar um valor numérico (int, double), um valor booleano ou uma String, etc.\n" +
                        L1 +
                        "LISTA DE ARGUMENTOS\n" +
                        P1 + "Alguns métodos recebem parâmetros necessários para sua execução. Esses parâmetros devem ser especificados com tipo e com um identificador para cada um. Esse identificador será seu nome para ser referenciado internamente ao método.\n " +
                        L1 +
                        "VISIBILIDADE\n" +
                        P1 + "Pode ser dos tipos private, public ou protected\n" +
                        L1 +
                        "ASSINATURA DO MÉTODO\n" +
                        P1 + "É o nome ou a primeira linha do método, ou seja, a forma como é chamado quando usado, passando os parâmetros solicitados.",
                " public class Animal {\n" +
                        L2 + P2 + " private int patas;\n" +
                        L2 + P2 + " private string tipo;\n" +
                        L2 +
                        L2 + P2 + "...\n" +
                        L2 +
                        L2 + P2 + " public int getPatas() {\n" +
                        L2 + P2 + P2 + " return this.patas;\n" +
                        L2 + P2 + "}\n" +
                        L2 + "}\n",
                "subtitulo");

        insere(db, 12.1, "MÉTODO ESTÁTICO",
                P1 + "É um método de classe, e não um método de objeto. Ou seja, um objeto não pode chamar este método pois ele não compila em tempo de execução, ele só pode ser chamado pela classe daquele objeto. \n" +
                        L1 + P1 + "Portanto, métodos estáticos não podem ser sobrescritos.",
                " public class Animal {\n" +
                        L2 + P2 + " private string voa;\n" +
                        L2 + P2 + " private string anda;\n" +
                        L2 +
                        L2 + P2 + "...\n" +
                        L2 +
                        L2 + P2 + " public static String cachorroSeLocomove() {\n" +
                        L2 + P2 + P2 + " return this.anda;\n" +
                        L2 + P2 + "}\n" +
                        L2 +
                        L2 + P2 + " public static String passaroSeLocomove() {\n" +
                        L2 + P2 + P2 + " return this.voa;\n" +
                        L2 + P2 + "}\n" +
                        L2 + "}\n",
                "subtitulo");

        insere(db, 13.0, "OBJETO",
                P1 + "É o item criado ao instanciar uma classe. \n" +
                        L1 + P1 + "No exemplo, ele seria o \"animal\" criado através do manual. Entretanto, o objeto pode ser manipulável, ou seja, posso criar vários animais com diferentes atributos (cachorro, gato, pássaro) e com comportamentos comuns (andar).\n",
                " Animal animal = new Animal();",
                "subtitulo");

        insere(db, 14.0, "PACOTE",
                P1 + "São diretórios que agrupam classes cujas funcionalidades são parecidas ou que sejam relacionadas. É um bom modo de organizar classes que tratam os mesmos tipos de informações, todas no mesmo lugar.",
                " package com.taisbatuira.mure;",
                "subtitulo");

        insere(db, 15.0, "MODIFICADORES DE ACESSO",
                P1 + "Definem as permissões de acesso dos atributos, métodos, estruturas de classes. Eles que dizem se um determinado dado pode ser acessado por qualquer um ou só dentro da própria classe, por exemplo. \n",
                " public int i=0;" +
                        L2 +" private string c = \"cachorro\"",
                "titulo");

        insere(db, 16.0, "PUBLIC",
                P1 + "Significa que a estrutura em questão pode ser vista ou acessada por qualquer classe. ",
                " public int i=0;",
                "subtitulo");

        insere(db, 17.0, "PRIVATE",
                P1 + "A estrutura em questão só é visível dentro da classe onde foi declarada, ou seja, não é visível ou acessível de outra classe.",
                " private int i=0;",
                "subtitulo");

        insere(db, 18.0, "DEFAULT",
                P1 + "A estrutura criada é visível a todas as classes do mesmo pacote que a classe mãe.",
                " int i=0;",
                "subtitulo");

        insere(db, 19.0, "GET / SET",
                P1 + "Getter e Setter são métodos padrões usados para acessar as variáveis privadas de uma classe, indiretamente.\n" +
                        L1 + P1 + "O Getter permite que você recupere o valor da variável, enquanto que o Setter vai inserir um novo valor à variável. \n",
                " public class Animal {" +
                        L2 + P2 + " private int patas;" +
                        L2 +
                        L2 + P2 + " public int getPatas() {" +
                        L2 + P2 + P2 + " return this.patas;" +
                        L2 + P2 + "}" +
                        L2 +
                        L2 + P2 + " public void setPatas(int totalPatas) {" +
                        L2 + P2 + P2 + " this.patas = totalPatas;" +
                        L2 + P2 + "}" +
                        L2+ "}",
                "subtitulo");

        insere(db, 20.0, "ENCAPSULAMENTO",
                P1 + "É quando os atributos e o corpo (regras) dos métodos são privados, ou seja, visíveis apenas para a classe mãe. \n" +
                        L1 + P1 + "O que permanece visível é apenas a ASSINATURA dos métodos públicos. \n" +
                        L1 + P1 + "Com isso, ao instanciar a classe e criar um objeto, usam-se os métodos públicos para alterar os atributos daquele objeto criado, sem acessar os atributos ou comportamentos privados.\n",
                " public class Animal {\n" +
                        L2 + P2 + " private int patas;\n" +
                        L2 + P2 + " private string tipo;\n" +
                        L2 +
                        L2 + P2 + "...\n" +
                        L2 +
                        L2 + P2 + " private string late() {\n" +
                        L2 + P2 + P2 + " return \"au au\";\n" +
                        L2 + P2 + "}\n" +
                        L2 + "}\n",
                "titulo");

        insere(db, 21.0, "CONSTRUTOR",
                P1 + "Toda classe possui um construtor padrão, que pode ser modificado. \n" +
                        L1 + P1 + "O Construtor é uma estrutura chamada com as especificações para construção de um objeto daquela classe, ou seja, se existem valores específicos necessários, eles devem ser passados no construtor e, ao instanciar a classe, são passados como parâmetros para criação do objeto.\n",
                " public class Animal{\n" +
                        L2 + P2 + " private int patas;\n" +
                        L2 + P2 + " private string tipo;\n" +
                        L2 +
                        L2 + P2 + " public Animal (int patas, string tipo) {\n" +
                        L2 + P2 + P2 + " this.patas = patas;\n" +
                        L2 + P2 + P2 + " this.tipo = tipo;\n" +
                        L2 + P2 + "}\n" +
                        L2 + "}\n",
                "titulo");



        insere(db, 23.0, "HERANÇA",
                P1 + "É a relação entre classes que permite que uma classe seja filha de outra. Uma boa definição é usar o termo É UM, por exemplo, cachorro É UM animal, portanto a classe Cachorro é filha da classe Animal e seus objetos podem herdar os dados da classe mãe. Podemos criar uma segunda classe Gato que seja filha de Animal: tanto Cachorro quanto Gato herdam as características de Animal, mas são diferentes entre si.\n" +
                        L1 + P1 + "Para herança, em java usamos o termo extends.\n",
                " public class Animal {" +
                        L2 + P2 + "…" +
                        L2 + "}" +
                        L2 +
                        L2 + " public class Cachorro extends Animal {\n" +
                        L2 + P2 +"…" +
                        L2 + "}" +
                        L2 +
                        L2 + " public class Gato extends Animal {\n" +
                        L2 + P2 +"…" +
                        L2 + "}",
                "titulo");

        insere(db, 24.0, "MODIFICADOR DE ACESSO - PROTECTED",
                P1 + "Este modificador é parecido com o Default: a estrutura criada é visível a todas as classes do mesmo pacote que a classe mãe, mas também é acessível às classes Filhas, por herança.",
                " protected int i=0;",
                "subtitulo");

        insere(db, 25.0, "POLIMORFISMO",
                P1 + "É a capacidade de poder se referir a um objeto criado pela classe filha através da classe mãe. \n" +
                        L1 +
                        P1 + "Ou seja, ao instanciarmos a classe Cachorro, criamos o objeto cachorro que, por herança, É UM Animal. Sendo assim, o objeto cachorro pode ser atribuído a uma variável do tipo Animal, que só poderá chamar os métodos públicos da classe Animal.\n",
                " public class Animal {" +
                        L2 + P2 + "…" +
                        L2 + P2 +" public int contaPatas() {" +
                        L2 + P2 +"…" +
                        L2 + P2 +"}" +
                        L2 + "}" +
                        L2 +
                        L2 + " public class Cachorro extends Animal {" +
                        L2 + P2 +"…" +
                        L2 + "}" +
                        L2 +
                        L2 + " public class Xpto {" +
                        L2 + P2 +"…" +
                        L2 + P2 +" Animal cachorro = new Cachorro();" +
                        L2 + P2 +" int patas = cachorro.contaPatas();" +
                        L2 + "}",
                "titulo");

        insere(db, 25.0, "INTERFACE",
                P1 + "A interface é um contrato que passamos a uma Classe para obrigá-la a cumprir certas exigências através da implementação de métodos. A interface não possui o corpo dos métodos, apenas suas assinaturas, que devem ser escritos na classe que implementar a interface.\n",
                " public interface intercafeAnimal {" +
                        L2 + P2 + " void tipoAnimal() ;" +
                        L2 + "}" +
                        L2 +
                        L2 +" public class Animal implements interfaceAnimal {" +
                        L2 + P2 + " public void tipoAnimal() {" +
                        L2 + P2 + " String tipo = \"mamífero\";" +
                        L2 + P2 + "}" +
                        L2 + "..." +
                        L2 + "} ",
                "titulo");

        insere(db, 25.0, "ARRAY OU VETOR",
                P1 + "Array ou vetor é um espaço contínuo na memória onde é possível alocar um número fixo de elementos de um tipo específico. Cada elemento possui uma posição fixa numerada a partir do 0 e pode ser acessado através do índice.\n" +
                        L1 +
                        L1 + P1 + "No array String[] animais = {\"cachorro\",\"gato\",\"peixe\",\"pássaro\"}\n" +
                        L1 +
                        L1 + "\"cachorro\" corresponde a animais[0]" +
                        L1 + "\"pássaro\" corresponde a animais[3]\n",
                " String[] animais = {\"cachorro\",\"gato\",\"peixe\",\"pássaro\"};",
                "titulo");

//        insere(db, 25.0, "POLIMORFISMO",
//                P1 + "bla",
//                "String nome = \"Tais\"" +
//                        L2 + P2 + P2 + "LA BLA BLA",
//                "titulo");

    }

    private void insere (SQLiteDatabase banco, Double ordem, String titulo, String conteudo, String exemplo, String categoria) {
        ContentValues cv = new ContentValues();

        cv.put("ordem", ordem);
        cv.put("titulo", titulo);
        cv.put("conteudo", conteudo);
        cv.put("exemplo", exemplo);
        cv.put("tipo", categoria);
        banco.insertOrThrow("conceitos",null,cv);
    }

    public List<Conceito> listaDeConceitos(String ordem){
        ArrayList<Conceito> lista = new ArrayList<>();
        String query = "select * from conceitos order by " + ordem + ";";
        Cursor cursor = getReadableDatabase().rawQuery(query,null);
        while (cursor.moveToNext()){
            Conceito conceito = criaConceitoNoBanco(cursor);
            lista.add(conceito);
        }
        cursor.close();
        return lista;
    }



    private Conceito criaConceitoNoBanco (Cursor cursor){
        Conceito conceito = new Conceito();

        String ordemCursor = cursor.getString(cursor.getColumnIndex("ordem"));
        conceito.setOrdem(ordemCursor);
        String tituloCursor = cursor.getString(cursor.getColumnIndex("titulo"));
        conceito.setTitulo(tituloCursor);
        String conteudoCursor = cursor.getString(cursor.getColumnIndex("conteudo"));
        conceito.setConteudo(conteudoCursor);
        String exemploCursor = cursor.getString(cursor.getColumnIndex("exemplo"));
        conceito.setExemplo(exemploCursor);
        String tipoCursor = cursor.getString(cursor.getColumnIndex("tipo"));
        conceito.setTipo(tipoCursor);
        return conceito;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists conceitos");
        onCreate(db);
    }
}
