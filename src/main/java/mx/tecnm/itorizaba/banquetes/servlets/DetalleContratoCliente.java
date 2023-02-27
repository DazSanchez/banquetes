package mx.tecnm.itorizaba.banquetes.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import mx.tecnm.itorizaba.banquetes.entidades.ContratoCliente;
import mx.tecnm.itorizaba.banquetes.entidades.OpcionSimple;

@WebServlet(name = "DetalleContratoCliente", urlPatterns = {"/panel-cliente/detalle"})
public class DetalleContratoCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        OpcionSimple[] banquetes = new OpcionSimple[]{
            new OpcionSimple(1, "Banquete 1"),
            new OpcionSimple(2, "Banquete 2"),
            new OpcionSimple(3, "Banquete 3")
        };

        OpcionSimple[] tematicas = new OpcionSimple[]{
            new OpcionSimple(1, "Tematica 1"),
            new OpcionSimple(2, "Tematica 2"),
            new OpcionSimple(3, "Tematica 3"),
        };

        OpcionSimple[] colores = new OpcionSimple[]{
            new OpcionSimple(1, "Color 1"),
            new OpcionSimple(2, "Color 2"),
            new OpcionSimple(3, "Color 3"),
        };
        
        ContratoCliente contratoCliente = new ContratoCliente(1, 2, 2, 2, "2023-01-30", 100, "Calle 1", "Colonia 1", "Ciudad 1");

        req.setAttribute("contrato", contratoCliente);
        req.setAttribute("banquetes", banquetes);
        req.setAttribute("tematicas", tematicas);
        req.setAttribute("colores", colores);
        
        req.getRequestDispatcher("/detalle_contrato_cliente.jsp").forward(req, resp);
    }

}
