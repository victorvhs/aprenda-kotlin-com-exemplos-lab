import domain.ConteudoEducacional
import domain.Formacao
import domain.Usuario
import domain.enums.Cursos
import domain.enums.Nivel
import services.imp.MatricularAlunoImpl

fun main() {

    val curso1 = Cursos.JAVA
    val curso2 = Cursos.KOTLIN
    val conteudoEducacional01 = ConteudoEducacional("${curso1} Android", 32)
    val conteudoEducacional02 = ConteudoEducacional("${curso2} android", 25)

    val formacao = Formacao(curso1, mutableListOf(), Nivel.AVANCADO)
    val formacao2 = Formacao(curso2, mutableListOf(), Nivel.AVANCADO)
    val matricula = MatricularAlunoImpl(formacao)
    val matricula2 = MatricularAlunoImpl(formacao2)

    val user1 = Usuario(1, "jacira", "999999999999")
    val user2 = Usuario(2, "Milton", "999999999999")
    val user3 = Usuario(3, "Fernando", "999999999999")


    formacao.adicionarConteudo(conteudoEducacional01)
    formacao2.adicionarConteudo(conteudoEducacional02)
    matricula.matricular(user1)
    matricula.matricular(user2)
    matricula2.matricular(user3)
    println("formação ${formacao.linguagem} : $formacao")
    println("formação ${formacao2.linguagem} : $formacao2")
    println("formação ${formacao.linguagem} Total de alunos: ${formacao.inscritos}")
    println("formação ${formacao.linguagem}  conteudo: ${formacao.conteudos}")
    val userRemovido = matricula.desistir(user2)
    println("formação ${formacao2.linguagem} Total de alunos:: ${formacao2.inscritos}")

    if (userRemovido != null) {
        println("Na formação ${formacao.linguagem} o Aluno ${userRemovido.nome} desistiu dos inscritos.")
    }
    println("formação ${formacao.linguagem} inscritos: ${formacao.inscritos}")
}