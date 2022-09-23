package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Task;
import util.ConnectionFactory;

/**
 *
 * @author bruno
 */
public class TaskController {
    //nesta classe vou criar 4 m�todos. Um pra cada opera��o b�sica: inserir, salvar, remover e atualizar

    public void save(Task task) {
        //Par�metro Task, pois � essa tarefa que quero salvar no BD
        //Primeiro, vamos criar uma string com o script sql que queremos que seja executado
        //dentro de task()v�o os campos que eu quero guardar um valor e em VALUES() quais sao esses valores. S� que os valores vou receber como par�metro
        //os campos que forem auto incremento n�o precisam ser colocados abaixo
        String sql = "INSERT INTO tasks (idProject,"
                + "name,"
                + "description,"
                + "completed,"
                + "notes,"
                + "deadline,"
                + "createdAt,"
                + "updatedAt) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        //conexao com o BD
        //crio ela fora do try, pois qdo eu precisar fecha-la, se ela estiver dentro do try eu nao consigo
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //Estabelecendo a conex�o com o BD
            connection = ConnectionFactory.getConnection();
            
            //preparando a Query
            statement = connection.prepareStatement(sql);

            //vamos setar nesse statement os campos que definimos com ?
            //N�o precisamos setar o Id da tarefa, pois � auto incremento.
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.IsCompleted());
            statement.setString(5, task.getNotes());
            //o DATE do pacote java.util.Date � diferente do Date do SQL, logo vamos ter quwe fazer uma conversao
            //temos que importar java.sql.date
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            
            //executando a query
            statement.execute();

            //nao � uma boa pr�tica fechar a conexao aqui, pois se der algum problema
            //ela pula direto pro catch, deixando a conexao aberta
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar tarefa " + ex.getMessage(), ex); //ex.getMessage pega a mensagem do erro e mostra pro usu�rio
        } finally {

            //fechar a conexao e o statement
            ConnectionFactory.closeConnection(connection, statement);

        }

    }

    public void update(Task task) {
        String sql = "UPDATE TASKS SET idProject = ?, name = ?, description = ?, completed = ?, notes = ?, "
                + "deadline = ?, createdAt = ?, updatedAt = ? WHERE ID = ?";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            //Aqui eu tenho que setar qual o id do projeto que quero atualizar, pois � o filtro da query "WHERE id = ?"
            
            //o index tem que acompanhar a ordem da query .set(1, *) index 1 para idProject que aparece em primeiro.
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.IsCompleted());
            statement.setString(5, task.getNotes());
            //o DATE do pacote java.util.Date � diferente do Date do SQL, logo vamos ter que fazer uma conversao
            //temos que importar java.sql.date
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            
            //� o �ltimo index pois � a condi��o WHERE
            statement.setInt(9, task.getId());

            statement.execute();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar tarefa" + ex.getMessage(), ex);
        }
    }

    public void removeById(int taskId) {
        //passar como par�metro o Id da tarefa qeu quero que seja deletada. Id � tipo inteiro.
        //vou criar uma vari�vel tipo String chamada sql, pois vou passar uma query para ela
        String sql = "DELETE FROM tasks WHERE id = ?"; //comando sql pra deletar um dado

        //Criei uma vari�vel tipo Connection chamada connection, n�o instanciada pois est� com valor null
        Connection connection = null;
        //Criei uma vari�vel tipo PreparedStatement chamada statement
        PreparedStatement statement = null;

        try { //tecla de atalho ctrl + espaco + enter
            //agora vou estabelecer uma conex�o com o BD
            //Lembrando que a Classe ConnectionFactory foi criada dentro do pacote "util"
            connection = ConnectionFactory.getConnection();

            //agora criar um objeto de Statement
            //Ele ajuda a preparar o comando sql que vai ser executado no BD
            statement = connection.prepareStatement(sql);

            //eu quero setar um valor no sql (que criamos acima), isto �, colocar um valor num�rico no texto
            //ou seja, quero mudar o ? pelo Id da task
            //Ele prepara o comando sql pra ser executado no BD
            //(1, taskId) 1 � o index do par�metro.
            statement.setInt(1, taskId);

            //agora estamos mandando executar isso no BD
            statement.execute();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar a tarefa" + ex.getMessage(), ex); //ex.getMessage pega a mensagem do erro e mostra pro usu�rio
        } finally { //bloco finally sempre ser� executado no final da execucao do bloco try, independente se ocorrer ou nao erro
            //Aqui ele ser� executado pois temos que fechar a conexao que est� aberta.
            ConnectionFactory.closeConnection(connection, statement);

        }

    }

    public List<Task> gettAll(int idProject)  {
        //Esse m�todo me devolve uma lista de tarefas.
        //Esse m�todo vai buscar todas as tarefas com base em um projeto. Lembrando que a Tarefa tem uma FK
        //para o projeto, que me informa para qual projeto determinada tarefa pertence.
        //Ent�o vou pegar todas (gettAll) as tarefas do projeto 1. Todas as Tarefas do projeto 2 e assim por diante.
        //lembrando que h� um relacionamento entre uma tarefa e um projeto. Um projeto pode ter v�rias tarefas
        //Montar um filtro pelo Id do projeto
        String sql = "SELECT * FROM tasks WHERE idProject = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        //ResultSet: Qdo a gente faz um Select no banco, ele nos d� uma resposta, ent�o a gente tem que ter uma Classe que 
        //represente esse retorno do BD, e a Classe ResultSet � a que guarda dentro dela o que a gente teve de resposta ao executar o Select no BD.
        ResultSet resultSet = null;

        //Agora vou criar um objeto chamado tasks do tipo List que vai receber como par�metro um objeto do tipo Task.
        //Esse objeto ser� um ArrayList.
        //Logo isso ser� uma lista de tarefas que ser� devolvida quando a chamada do m�todo acontecer
        List<Task> tasks = new ArrayList<Task>();

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            //setando o Id do projeto na qual a tarefa pertence. � o par�metro que corresponde ao filtro.
            statement.setInt(1, idProject);

            //ao inv�s de utilizarmo o statement.execute, vamos utilizar o statement.executeQuery, pois este m�todo retorna um ResultSet
            resultSet = statement.executeQuery(); //logo o objeto resultSet vai ter dentro dele os valores que correspondem as tarefas.

            //Enquanto houver uma pr�xima(next()) tarefa, vou pegando esses valores e fazendo a convers�o entre a resposta do BD e os nossos objetosde tarefa
            while (resultSet.next()) {

                Task task = new Task();
                //vou come�ar a setar nessa tarefa os valores ques est�o no resultSet
                task.setId(resultSet.getInt("id"));//estou pegando(get) o valor da coluna id do meu objeto resultSet e passando(set) para o objeto task
                task.setIdProject(resultSet.getInt("idProject"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setIsCompleted(resultSet.getBoolean("completed"));
                task.setNotes(resultSet.getString("notes"));
                task.setDeadline(resultSet.getDate("deadline"));
                task.setCreatedAt(resultSet.getDate("createdAt"));
                task.setUpdatedAt(resultSet.getDate("updatedAt"));

                //agora vou colocar essa tarefa(task), dentro da minha lista de tarefas(tasks)
                //lembrando: "task" � objeto da classe Task e "tasks" � objeto da classe List
                tasks.add(task);

            }

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar dados" + ex.getMessage(), ex);
        } finally {
            //Aqui tamb�m preciso fechar o ResultSet, ent�o, ao inv�s de criar um "if"dentro de finnaly para fech�-lo,
            //vou na Classe ConnectionFactory e crio um m�todo pra fechar tudo: connection, statement e resultset
         ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        
        
        //Ao criar o m�todo deixei como return um valor nulo s� pra n�o ficar apontando erro.
        //return null;
        
        return tasks; //retornar minha lista que foi criada e carregada do BD
    }

}
