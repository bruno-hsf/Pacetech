package Semana8_ExercicioSala2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Bem Vindo ao sistema de Médias Pacetech! \n"
                         + "Favor informar o Nome do Aluno: ");
        
        String nome = leitor.nextLine();
        System.out.println("Favor informar a matrícula do aluno: ");
        String matricula = leitor.nextLine();
        System.out.println("Favor informar a nota da prova aluno: ");
        float notaProva = leitor.nextFloat();
        System.out.println("Favor informar a nota do trabalho aluno: ");
        float notaTrabalho = leitor.nextFloat();
        
        Aluno aluno = new Aluno(nome, matricula, notaProva, notaTrabalho);
        
        System.out.println("A média final do aluno: " + aluno.getNome() + ", de matrícula: " + aluno.getMatricula() + " é de: " + aluno.mediaFinal());     
    }
}