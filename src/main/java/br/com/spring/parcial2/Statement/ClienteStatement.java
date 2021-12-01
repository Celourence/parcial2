package br.com.spring.parcial2.Statement;
import br.com.spring.parcial2.Configs.Datadase;
import br.com.spring.parcial2.Models.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class ClienteStatement{

    public static void add(Cliente cliente) throws SQLException {

        Connection connection = Datadase.getConnection();
        String sql = "INSERT INTO cliente (Nome, CPF, Titulo_Eleitor) VALUES (?,?,?,?)";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, cliente.getID());
        statement.setString(2, cliente.getNome());
        statement.setString(3, cliente.getTitular_Eleitor());
        statement.setString(4, cliente.getCPF());

        statement.execute();

        statement.close();
        connection.close();
    }

    public static List<Cliente> List() throws SQLException{

        List<Cliente> clientes = new ArrayList<Cliente>();
        Connection connection = Datadase.getConnection();
        String sql = "SELECT * FROM cliente";

        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            Cliente cliente = new Cliente();
            Cliente.setID(resultSet.getInt("ID"));
            Cliente.setNome(resultSet.getString("Nome"));
            Cliente.setTitular_Eleitor(resultSet.getString("Titulo_Eleitor"));
            Cliente.setCPF(resultSet.getString("CPF"));

            clientes.add(cliente);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return clientes;
    }

}
