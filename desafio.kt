// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String, val idade: Int)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, var nivel: Nivel)

data class Formacao(private val nome: String, private val conteudos: List<ConteudoEducacional>) {

    private val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun usuariosMatriculados() {
        for (inscrito in inscritos) {
            print("Nome: ${inscrito.nome} - Idade: ${inscrito.idade}\n")
        }
    }

    fun formacao() {
        print("Formação ${nome}\n")
    }

    fun conteudos() {
        for (conteudo in conteudos) {
            print("${conteudo.nome} - ${conteudo.duracao}h: ${conteudo.nivel}\n")
        }
    }

}

fun main() {

    val listaConteudos = listOf(
        ConteudoEducacional("Algoritmos", 80, Nivel.BASICO),
        ConteudoEducacional("Cálculo", 80, Nivel.DIFICIL),
        ConteudoEducacional("Lógica", 80, Nivel.INTERMEDIARIO),
        ConteudoEducacional("Arquitetura de Computadores", nivel = Nivel.DIFICIL)
    )

    val formacao = Formacao("Engenharia de Software", listaConteudos)

    formacao.matricular(Usuario("João", 30))

    formacao.matricular(Usuario("Maria", 35))

    formacao.formacao()
    print("\nGrade:\n")
    formacao.conteudos()
    print("\nEstudantes Cadastrados:\n")
    formacao.usuariosMatriculados()
}
