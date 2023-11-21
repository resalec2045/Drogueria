package Utils;

public enum TiposInformes {
    listarInformesPorEstado("listarInformesPorEstado"),
    listarInformesTrabajoPorHorasEmpleados("listarInformesTrabajoPorHorasEmpleados"),
    listarEmpleadoSalario("listarEmpleadoSalario"),
    listarInformesVentas("listarInformesVentas"),
    listarInventarioPorProducto("listarInventarioPorProducto"),
    listarCantidadProductoStock("listarCantidadProductoStock"),
    listarVentasPorMes("listarVentasPorMes"),
    ListarClienteConMasComprasPrimerSemestre("ListarClienteConMasComprasPrimerSemestre"),
    //    TODO: FALTAN
    ListarProveedoresCategoriaMasVendida("ListarProveedoresCategoriaMasVendida"),
    ListarEmleadoConMasHoras("ListarEmleadoConMasHoras");

    private final String nombre;

    TiposInformes(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

}
