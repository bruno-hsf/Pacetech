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
//primeiro vamos herdar a Classe AbstractTableModel. Ela exige a implementa��o de 3 m�todos abstratos: getRowCount, getColumnCount e getValueAt
//basta clicar com o bot�o esquerdo e fazer o import autom�tico. 
public class TaskTableModel extends AbstractTableModel {

    //Vetor colunas: ele ter� todas as Strings que correspondem as colunas do meu Table
    String[] columns = {"Nome", "Descri��o", "Prazo", "Tarefa Conclu�da", "Editar", "Excluir"};

    List<Task> tasks = new ArrayList();

    @Override
    //vai me dizer quantas linhas/tarefas minha tabela vai ter
    public int getRowCount() {
        //vai retorar o n�mero de linhas da qtde de tarefas. Ex: se o projeto tiver 2 tarefas, ent�o vai me retornar duas linhas
        return tasks.size();
    }

    @Override
    //vai me dizer qtas colunas eu vou ter
    public int getColumnCount() {
        //como eu tenho um vetor de colunas, eu irei retorn�-lo
        return columns.length;
    }

    @Override
    //Esse m�todo vai me retornar o nome da coluna baseado no seu index.
    //Exemplo:como a coluna de index 1 � a descri��o, ao inv�s de aparecer 1, ir� aparecer Descri��o no nome da coluna
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }

    @Override
    //Esse m�todo pergunta se a c�cula dessa linha(rowIndex) e dessa coluna(columnIndex) � edit�vel
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        //return true; deixaria alterar todas as caluna, mas eu s� quero editar a coluna "tarefa conclu�da"
        return (columnIndex == 3);
    }

    @Override
    //Esse m�todo retorna qual a Classe do componente que est� em determinada coluna: se ele � uma String, se � um Boolean
    //Se n�o sobrescrevermos este m�todo , por padr�o, ele chama o da Classe pai AbstractTableModel; e na classe pai ele 
    //retorna uma String. Por isso que na coluna Tarefa Conclu�da ele retorna o texto True/False
    //Vamos sobrescrever este m�todo para que na coluna de Tarefa conclu�da me seja retornado um checklist
    public Class<?> getColumnClass(int columnIndex) {

        if (tasks.isEmpty()) {
            //Se for vazia me retornar o objeto j� que n�o vai constar nada mesmo
            return Object.class;
        }

        //vai pegar o dado da linha 0 e retornar a Classe do dado de cada coluna na qual ela pertence
        //Exemplo: se columnIndex == 3(Tarefa Conclu�da), vai retornar um dado tipo Boolean, pois os dados dessa Classe s�o deste tipo.
        //Automaticamente se o dado for do tipo Boolean ele j� colocar um cheklist, que teremos que editar no m�todo setValueAt pra ele ficar ou n�o ticado
        return this.getValueAt(0, columnIndex).getClass();

    }

    @Override
    //diz qual valor espec�fico dever� ser exibido em cada c�lula
    public Object getValueAt(int rowIndex, int columnIndex) {

        //dependendo da coluna eu vou retornar um dado espec�fico
        switch (columnIndex) {

            case 0:
                //tenho que retornar na coluna 1 o nome da tarefa. 
                //Mas como columns � um vetor, seu index come�a do 0
                //rowIndex come�a de 1, ent�o tenho Coluna 1(mas que � 0 no vetor) e linha 1 o nome da tarefa
                return tasks.get(rowIndex).getName(); //como estou dando um "return"n�o precisa do "break"
            case 1:
                return tasks.get(rowIndex).getDescription();
            case 2:
                //formatando a data
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                //retornando a data formatada. O m�todo format recebe uma data e retorna uma String
                return dateFormat.format(tasks.get(rowIndex).getDeadline());
            case 3:
                return tasks.get(rowIndex).IsCompleted();
            case 4,5:
                return "";
            default:
                return "Dados n�o encontrados";
        }
    }

    @Override
    //Vai fazer um cast(convers�o do dado)
    //Meu componente gr�fico chama esse m�todo e passa o valor true/false como um Object
    public void setValueAt(Object value, int rowIndex, int columnIndex) {

        if (columnIndex == 3) {
            //To pegando o valor tipo Object e fazendo um Cast, convertendo em boolean 
            //O componente gr�fico transforma ele em Object e a gente transforma de novo no tipo Boolean
            //Depois vamos configurar o evento de clique da jTableTask na MainsScreen para salvar essa altera��o no BD
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
