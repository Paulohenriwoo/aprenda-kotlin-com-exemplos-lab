// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val matricula: Int, val nome: String, val sobrenome: String, var idade: Int) {
    companion object {
        private var proximaMatricula = 1
        fun criarUsuario(nome: String, sobrenome: String, idade: Int): Usuario {
            val usuario = Usuario(proximaMatricula, nome, sobrenome, idade)
            proximaMatricula++
            return usuario
        }
    }
}

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun main() {
    // Criando alguns usuários
    val usuario1 = Usuario.criarUsuario("Anderson", "Silva", 28)
    val usuario2 = Usuario.criarUsuario("Maria", "Oliveira", 40)
    val usuario3 = Usuario.criarUsuario("Pedro", "Vicente", 18)

    // Criando conteúdos educacionais
    val conteudo1 = ConteudoEducacional("Introdução à Programação", nivel = Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", nivel = Nivel.INTERMEDIARIO)
    val conteudo3 = ConteudoEducacional("Algoritmos Avançados", nivel = Nivel.DIFICIL)

    // Criando uma formação e matriculando usuários
    val formacao = Formacao("Ciência da Computação", listOf(conteudo1, conteudo2, conteudo3))
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
    formacao.matricular(usuario3)

    // Imprimindo informações
    println("Formação: ${formacao.nome}")
    println("Conteúdos: ")
    for (conteudo in formacao.conteudos) {
        println("- ${conteudo.nome} (Nível: ${conteudo.nivel})")
    }
    println("Inscritos: ")
    for (inscrito in formacao.inscritos) {
        println("- ${inscrito.nome} ${inscrito.sobrenome}")
    }
}
