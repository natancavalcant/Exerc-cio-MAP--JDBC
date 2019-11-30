import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import br.com.map.crudproduto.util.ConnectionFactory;
import net.sf.jasperreports.engine.JasperExportManager;
import br.com.map.crudproduto.model.Produto;
import br.com.map.crudproduto.reports.ReportsManager;
import br.com.map.crudproduto.model.Especificacao;
import static groovy.inspect.Inspector.print;
import java.util.ArrayList;
import java.util.List;

public class Test{
    public static void main(String[] args) throws SQLException, Exception {
        Produto p1 = new Produto(1, "p1", 1, new Especificacao(1, "fab1", "cor1", "sistema1", "detalhes1"));
        Produto p3 = new Produto(1, "p3", 1, new Especificacao(1, "fab3", "cor3", "sistema3", "detalhes3"));
        Produto p2 = new Produto(1, "p2", 1, new Especificacao(1, "fab2", "cor2", "sistema2", "detalhes2"));
        List<Produto> PL;
        PL = new ArrayList<>();
        PL.add(p1);
        PL.add(p2);
        PL.add(p3);
        
        JasperExportManager.exportReportToPdfFile(ReportsManager.escreverRelatorio(PL), "D:/Relatorio_de_Clientes.pdf");
        
    }
}