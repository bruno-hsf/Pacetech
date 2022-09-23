/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Task;

/**
 *
 * @author brunoferreira
 */
//primeiro vamos herdar a Classe AbstractTableModel. Ela exige a implementação de 3 métodos abstratos: getRowCount, getColumnCount e getValueAt
//basta clicar com o botão esquerdo e fazer o import automático. 
public class TaskTableModel extends AbstractTableModel {

    //Vetor colunas: ele terá todas as Strings que correspondem as colunas do meu Table
    String[] columns = {"Nome", "Descrição", "Prazo", "Tarefa Concluída", "Editar", "Excluir"};

    List<Task> tasks = new ArrayList();

    @Override
    //vai me dizer quantas linhas/tarefas minha tabela vai ter
    public int getRowCount() {
        //vai retorar o número de linhas da qtde de tarefas. Ex: se o projeto tiver 2 tarefas, então vai me retornar duas linhas
        return tasks.size();
    }

    @Override
    //vai me dizer qtas colunas eu vou ter
    public int getColumnCount() {
        //como eu tenho um vetor de colunas, eu irei retorná-lo
        return columns.length;
    }

    @Override
    //Esse método vai me retornar o nome da coluna baseado no seu index.
    //Exemplo:como a coluna de index 1 é a descrição, ao invés de aparecer 1, irá aparecer Descrição no nome da coluna
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }

    @Override
    //Esse método pergunta se a cécula dessa linha(rowIndex) e dessa coluna(columnIndex) é editável
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        //return true; deixaria alterar todas as caluna, mas eu só quero editar a coluna "tarefa concluída"
        return (columnIndex == 3);
    }

    @Override
    //Esse método retorna qual a Classe do componente que está em determinada coluna: se ele é uma String, se é um Boolean
    //Se não sobrescrevermos este método , por padrão, ele chama o da Classe pai AbstractTableModel; e na classe pai ele 
    //retorna uma String. Por isso que na coluna Tarefa Concluída ele retorna o texto True/False
    //Vamos sobrescrever este método para que na coluna de Tarefa concluída me seja retornado um checklist
    public Class<?> getColumnClass(int columnIndex) {

        if (tasks.isEmpty()) {
            //Se for vazia me retornar o objeto já que não vai constar nada mesmo
            return Object.class;
        }

        //vai pegar o dado da linha 0 e retornar a Classe do dado de cada coluna na qual ela pertence
        //Exemplo: se columnIndex == 3(Tarefa Concluída), vai retornar um dado tipo Boolean, pois os dados dessa Classe são deste tipo.
        //Automaticamente se o dado for do tipo Boolean ele já colocar um cheklist, que teremos que editar no método setValueAt pra ele ficar ou não ticado
        return this.getValueAt(0, columnIndex).getClass();

    }

    @Override
    //diz qual valor específico deverá ser exibido em cada célula
    public Object getValueAt(int rowIndex, int columnIndex) {

        //dependendo da coluna eu vou retornar um dado específico
        switch (columnIndex) {

            case 0:
                //tenho que retornar na coluna 1 o nome da tarefa. 
                //Mas como columns é um vetor, seu index começa do 0
                //rowIndex começa de 1, então tenho Coluna 1(mas que é 0 no vetor) e linha 1 o nome da tarefa
                return tasks.get(rowIndex).getName(); //como estou dando um "return"não precisa do "break"
            case 1:
                return tasks.get(rowIndex).getDescription();
            case 2:
                //formatando a data
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                //retornando a data formatada. O método format recebe uma data e retorna uma String
                return dateFormat.format(tasks.get(rowIndex).getDeadline());
            case 3:
                return tasks.get(rowIndex).IsCompleted();
            case 4,5:
                return "";
            default:
                return "Dados não encontrados";
        }
    }

    @Override
    //Vai fazer um cast(conversão do dado)
    //Meu componente gráfico chama esse método e passa o valor true/false como um Object
    public void setValueAt(Object value, int rowIndex, int columnIndex) {

        if (columnIndex == 3) {
            //To pegando o valor tipo Object e fazendo um Cast, convertendo em boolean 
            //O componente gráfico transforma ele em Object e a gente transforma de novo no tipo Boolean
            //Depois vamos configurar o evento de clique da jTableTask na MainsScreen para salvar essa alteração no BD
            tasks.get(rowIndex).setIsCompleted((boolean) value);
        }
    }

    public String[] getColumns() {
        return columns;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

}
