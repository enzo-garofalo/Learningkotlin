/*
* Uma classe do tipo aData class armazena somente dados e não tem operações(funções)
* só serve como "estrutura de dados" ou seja um tipo que apenas agrega aos outros
* CLASSE: é uma especificação de um tipo de objeto
* de modo informal classe é um molde para
* se criar instancias daquele tipo/objeto
* Classe = Molde = tipo especifico = especificação de algo
* Instancia = um objeto real daquela especificaão
* */

data class Endereco(
    var logradouro: String,
    var numero: Int,
    var complemento: String,
    var bairro: String,
    var cidade: String,
    var uf: String,
    var cep: String
)

//Classe tradicional (como é em java)
class Jogador{
    var nome: String = ""
    var idade: Int = 0
    var posicaoDePreferencia: String = ""
    var posicaoAtualY: Int = 0
    var posicaoAtualX: Int = 0

    fun chutar(bola: Bola){
        if(this.posicaoAtualX == bola.posicaoAtualX &&
            this.posicaoAtualY == bola.posicaoAtualY){
            println("Jogador ${this.nome} chutou a bola")
        }else{
            println("Chute falhou, posições diferentes")
        }
    }

    fun defender(){
        println("Jogador ${this.nome} defender a bola")
    }


    fun saltar(){
        println("Jogador ${this.nome} saltou")
    }

    fun defenderComAsMaos(){
        println("Jogador ${this.nome} defender com as mãos")
    }
}

class Bola{
    var peso: Double = 0.0
    var posicaoAtualY : Int = 0
    var posicaoAtualX : Int = 0

    fun deslocarSe(xo: Int, yo: Int, xd: Int, yd: Int, velocidade: Double){
        println("Bola se deslocando do ponto ($xo,$yo) ao ponto ($xd,$yd)" +
                "na velocidade $velocidade")
    }
}


// uma classe pode ter atributos e funçoes.
// o  nome de uma funçao que esta dentro de uma classe se chama metodo
fun main(){
    val bola = Bola()
    bola.peso = 500.0
    bola.posicaoAtualX = 100
    bola.posicaoAtualY = 300

    val j1 = Jogador()
    j1.nome = "Neymar"
    j1.posicaoDePreferencia = "Atacante"
    j1.idade = 33

    j1.posicaoAtualX = 100
    j1.posicaoAtualY = 300

    j1.chutar(bola)
    j1.saltar()
}
// Esse é um exmplo de herança bem simples,
// Animal é uma classe Abstrata
abstract class Animal(){
    var peso : Double = 0.0
    var idade : Int = 0

    abstract fun emitirSom();
}

class Cachorro: Animal(){
    override fun emitirSom(){
        println("Wolf wolf")
    }
}

// Uma data class não pode ser herdada
// A seguir um empilhamento de herança
open class Pessoa{
    var nome  : String = ""
    var idade : String = ""
    var cpf   : String = ""
    var rg    : String = ""
}

open class Funcionario : Pessoa(){
    var matricula : String = ""
}

class Professor: Funcionario(){
    var titularidade: String = ""
}
/*
fun main() {
    //criando instancias da classe Endereco
    val e1 = Endereco("rua dos pinhos",
        111,
        "",
        "jardim jardim",
        "jacarei",
        "KS",
        "99129005")

    val e2 = Endereco("louros dourados",
        12,
        "depois do logo ali",
        "ggogogo",
        "goianianse",
        "MS",
        "234125002")
}
 */