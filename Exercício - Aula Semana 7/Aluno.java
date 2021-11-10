package Semana8_ExercicioSala2;

public class Aluno {

    private String nome;
    private String matricula;
    private float notaProva;
    private float notaTrabalho;

    public Aluno(String nome, String matricula, float notaProva, float notaTrabalho) {

        if (nome.equalsIgnoreCase("")) {
            this.nome = "Aluno";
        } else {
            this.nome = nome;
        }

        if (matricula.equalsIgnoreCase("")) {
            this.matricula = "Sem matricula informada";
        } else {
            this.matricula = matricula;
        }

        if (notaProva < 0) {
            this.notaProva = 0;
        } else {
            this.notaProva = notaProva;
        }

        if (notaTrabalho < 0) {
            this.notaTrabalho = 0;
        } else {
            this.notaTrabalho = notaTrabalho;
        }
    }

    public Aluno() {

    }

    public float mediaFinal() {
        return ((notaProva * 0.5f) + (notaTrabalho * 0.5f));
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.equalsIgnoreCase("")) {
            this.nome = "Aluno";
        } else {
            this.nome = nome;
        }
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        if (matricula.equalsIgnoreCase("")) {
            this.matricula = "Sem matricula informada";
        } else {
            this.matricula = matricula;
        }
    }

    public float getNotaProva() {
        return notaProva;
    }

    public void setNotaProva(float notaProva) {
        if (notaProva < 0) {
            this.notaProva = 0;
        } else {
            this.notaProva = notaProva;
        }
    }

    public float getNotaTrabalho() {
        return notaTrabalho;
    }

    public void setNotaTrabalho(float notaTrabalho) {
        if (notaTrabalho < 0) {
            this.notaTrabalho = 0;
        } else {
            this.notaTrabalho = notaTrabalho;
        }
    }

}
