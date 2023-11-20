package Utils;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Models.Reportes.CantidadProductoStock;
import Models.Reportes.EmpleadoSalario;
import Models.Reportes.VentasMes;
import com.itextpdf.text.Element;
import daoController.VentasController;
import factory.ConnectionFactory;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import com.itextpdf.text.Image;

public class PdfGenerator {
    public static void generarPdf(List<Object> listaObjetos, String nombreArchivo, String x, String y) {

        // Crear el conjunto de datos para el gráfico
        CategoryDataset dataset = createDataset(listaObjetos);

        // Crear el gráfico de barras
        JFreeChart chart = ChartFactory.createBarChart(
                "Gráfico de " + x + " vs. " + y,
                x,
                y,
                dataset
        );

        // Renderizar el gráfico en un objeto BufferedImage
        int width = 500;
        int height = 300;
        BufferedImage bufferedImage = chart.createBufferedImage(width, height);

        // Crear el documento PDF
        Document document = new Document(PageSize.A3);
        try {
            PdfWriter.getInstance(document, new FileOutputStream(nombreArchivo + ".pdf"));
            document.open();

            // Convertir BufferedImage a Image de iText
            Image image = Image.getInstance(bufferedImage, null);

            // Ajustar tamaño de la imagen si es necesario
            image.scaleToFit(PageSize.A4.getWidth(), PageSize.A4.getHeight());

            // Agregar la imagen al documento PDF
            document.add(image);

            // Cerrar el documento PDF
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (com.itextpdf.text.DocumentException e) {
            e.printStackTrace();
        }
    }

    private static CategoryDataset createDataset(List<Object> listaObjetos) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        if (listaObjetos.get(0) instanceof VentasMes) {
            for (Object objeto : listaObjetos) {
                String nombre = ((VentasMes) objeto).getMes();
                int cantidad = Integer.parseInt(((VentasMes) objeto).getTotalVentas());
                dataset.addValue(cantidad, "Cantidad", nombre);
            }
        } else if (listaObjetos.get(0) instanceof CantidadProductoStock) {
            for (Object objeto : listaObjetos) {
                String nombre = ((CantidadProductoStock) objeto).getProducto();
                int cantidad = ((CantidadProductoStock) objeto).getCantidad_en_stock();
                dataset.addValue(cantidad, "Cantidad", nombre);
            }
        } else if (listaObjetos.get(0) instanceof EmpleadoSalario) {
            for (Object objeto : listaObjetos) {
                String nombre = "" + ((EmpleadoSalario) objeto).getPersona_idpersona();
                int cantidad = ((EmpleadoSalario) objeto).getSalario();
                dataset.addValue(cantidad, "Cantidad", nombre);
            }
        }
        return dataset;
    }

//    public static void main(String[] args) {
//        // Ejemplo de uso
//        // Supongamos que tienes una lista de objetos llamada listaObjetos
//        // y cada objeto tiene un nombre y una cantidad asociados
//
//        ConnectionFactory factory = new ConnectionFactory();
//        Connection con = factory.recuperaConexion();
//
//        VentasController ventasController = new VentasController();
//
//        List<VentasMes> listaObjetos = ventasController.listarVentasPorMes();
//
//        for (VentasMes objeto : listaObjetos) {
//            System.out.println(objeto.getMes() + " " + objeto.getTotalVentas());
//        }
//
//        // Llamar al método para generar el PDF con el gráfico
//        generarPdf(listaObjetos, "grafico");
//    }
}
