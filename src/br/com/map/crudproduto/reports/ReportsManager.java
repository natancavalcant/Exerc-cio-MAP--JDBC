/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.crudproduto.reports;

import br.com.map.crudproduto.model.Produto;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
/**
 *
 * @author natan
 */
public class ReportsManager {
    private static String path = ReportsManager.class.getClassLoader().getResource("").getPath() + "/br/com/map/crudproduto/reports";
    
    public static JasperPrint escreverRelatorio(List<Produto> produtos) throws JRException {

        JasperReport report = JasperCompileManager.compileReport(path + "/produtos.jrxml");
        return JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(produtos));

    }
}
