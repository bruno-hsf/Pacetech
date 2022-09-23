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

    //construtor que recebe qual bot�o (editar ou excluir) eu quero renderizar
    public ButtonColumnCellRederer(String buttonType){
        this.buttonType = buttonType;
    
} 
    //como teremos dois bot�es que queremos mostrar na tela do usu�rio, a gente vai
    //criar um atributo pra dizer qual bot�o queremos renderizar
    //Cahamarei este atributo de buttonType, pois na hora de renderizar
    //eu vou escolher qual o tipo de bot�o irei renderizar(editar ou excluir)
    private String buttonType;

    public String getButtonType() {
        return buttonType;
    }

    public void setButtonType(String buttonType) {
        this.buttonType = buttonType;
    }

    @Override //este m�todo me devolve um componente que ser� mostrado em determinada c�lula
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int col) {

        //vai me retornar o componente que vai ser renderizado na tela, isto �, vai renderiar a Label que ser� exibida no nosso grid.
        JLabel label;
        label = (JLabel) super.getTableCellRendererComponent(table, value,
                isSelected, hasFocus, row, col);

        //centralizando a label. Apresenter a DATA no centro
        label.setHorizontalAlignment(CENTER);
        //getResource me retornar o caminho da pasta Resource que coloquei dentro da pasta Main do projeto
        //buttonType, na verdade, � o nome do arquivo png que ser� retornado/nderizado.
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/" + buttonType + ".png")));

        return label;

    }
}
