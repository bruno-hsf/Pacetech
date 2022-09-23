/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JTable;
import model.Task;

/**
 *
 * @author bruno
 */
public class DeadlineColumnCellRederer extends DefaultTableCellRenderer {

    @Override //este m�todo me devolve um componente que ser� mostrado em determinada c�lula
    public Component getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int col){
        
        //vai me retornar o componente seria renderizado na tela caso a gente n�o fizesse nenhuma customiza��o
        //Ser� o respons�vel por renderiar a Label que ser� exibida no nosso grid.
        JLabel label;
        label = (JLabel)super.getTableCellRendererComponent(table, value,
                isSelected, hasFocus, row, col);
        
        //centralizando a label. Apresenter a DATA no centro
        label.setHorizontalAlignment(CENTER);
        
        //Agora vou pintar o background da c�lula conforme o DeadLine da tarefa
        TaskTableModel taskModel = (TaskTableModel) table.getModel(); //pegando o taskModel que est� dentro da nossa JTable
        
        //Pegando a tarefa dentro do taskModel da linha que esta sendo renderizada
        Task task = taskModel.getTasks().get(row);
        
        //quero ver se esta deadline(prazo) est� depois da data atual (new Date())
        //Se isso for verdade, significa que estou dentro do prazo
        if (task.getDeadline().after(new Date())){
            label.setBackground(Color.GREEN);
        } else {
            label.setBackground(Color.red);
        }
        
        
    return label;
    
    //Agora tenho que falar para o JTable que qdo ele for renderizar aquela c�lula
    //ele n�o vai mais usar o renderizador padr�o e vai usar um objeto desta Classe
    //que por sua vez ir� customizar nossa c�lula.
    //Vou fazer isso no m�todo decorateTableTask() que est� no construtor da Classe MainScreen
    }
    
    
}