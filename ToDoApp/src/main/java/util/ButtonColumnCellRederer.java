/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import model.Task;

/**
 *
 * @author bruno
 */

public class ButtonColumnCellRederer extends DefaultTableCellRenderer {

    //construtor que recebe qual botão (editar ou excluir) eu quero renderizar
    public ButtonColumnCellRederer(String buttonType){
        this.buttonType = buttonType;
    
} 
    //como teremos dois botões que queremos mostrar na tela do usuário, a gente vai
    //criar um atributo pra dizer qual botão queremos renderizar
    //Cahamarei este atributo de buttonType, pois na hora de renderizar
    //eu vou escolher qual o tipo de botão irei renderizar(editar ou excluir)
    private String buttonType;

    public String getButtonType() {
        return buttonType;
    }

    public void setButtonType(String buttonType) {
        this.buttonType = buttonType;
    }

    @Override //este método me devolve um componente que será mostrado em determinada célula
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int col) {

        //vai me retornar o componente que vai ser renderizado na tela, isto é, vai renderiar a Label que será exibida no nosso grid.
        JLabel label;
        label = (JLabel) super.getTableCellRendererComponent(table, value,
                isSelected, hasFocus, row, col);

        //centralizando a label. Apresenter a DATA no centro
        label.setHorizontalAlignment(CENTER);
        //getResource me retornar o caminho da pasta Resource que coloquei dentro da pasta Main do projeto
        //buttonType, na verdade, é o nome do arquivo png que será retornado/nderizado.
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/" + buttonType + ".png")));

        return label;

    }
}
