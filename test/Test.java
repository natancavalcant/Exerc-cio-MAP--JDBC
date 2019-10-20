import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import br.com.map.crudproduto.util.ConnectionFactory;

public class Test{
    public static void main(String[] args) throws SQLException {
        PreparedStatement st;
        Connection con = ConnectionFactory.getConnection();

        String sql = "insert into especificacoes (codigo, fabricante, cor, sistema, detalhes) values (0, 'none', 'none', 'none', 'none')";
        st = con.prepareStatement(sql);
        st.executeUpdate();
        con.close();
    }
}