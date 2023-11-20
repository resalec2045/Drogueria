package Utils;

public enum TiposInformes {
    listarInformesPorEstado("listarInformesPorEstado"),
    listarInformesTrabajoPorHorasEmpleados("listarInformesTrabajoPorHorasEmpleados"),
    listarEmpleadoSalario("listarEmpleadoSalario"),
    listarInformesVentas("listarInformesVentas"),
    listarInventarioPorProducto("listarInventarioPorProducto"),
    listarCantidadProductoStock("listarCantidadProductoStock"),
    listarVentasPorMes("listarVentasPorMes"),
    ELEMENTO_8("Elemento 8"),
    ELEMENTO_9("Elemento 9"),
    ELEMENTO_10("Elemento 10");

    private final String nombre;

    TiposInformes(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

}
