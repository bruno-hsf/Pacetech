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

    @Override //este método me devolve um componente que será mostrado em determinada célula
    public Component getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int col){
        
        //vai me retornar o componente seria renderizado na tela caso a gente não fizesse nenhuma customização
        //Será o responsável por renderiar a Label que será exibida no nosso grid.
        JLabel label;
        label = (JLabel)super.getTableCellRendererComponent(table, value,
                isSelected, hasFocus, row, col);
        
        //centralizando a label. Apresenter a DATA no centro
        label.setHorizontalAlignment(CENTER);
        
        //Agora vou pintar o background da célula conforme o DeadLine da tarefa
        TaskTableModel taskModel = (TaskTableModel) table.getModel(); //pegando o taskModel que está dentro da nossa JTable
        
        //Pegando a tarefa dentro do taskModel da linha que esta sendo renderizada
        Task task = taskModel.getTasks().get(row);
        
        //quero ver se esta deadline(prazo) está depois da data atual (new Date())
        //Se isso for verdade, significa que estou dentro do prazo
        if (task.getDeadline().after(new Date())){
            label.setBackground(Color.GREEN);
        } else {
            label.setBackground(Color.red);
        }
        
        
    return label;
    
    //Agora tenho que falar para o JTable que qdo ele for renderizar aquela célula
    //ele não vai mais usar o renderizador padrão e vai usar um objeto desta Classe
    //que por sua vez irá customizar nossa célula.
    //Vou fazer isso no método decorateTableTask() que está no construtor da Classe MainScreen
    }
    
    
}