package mx.tecnm.itorizaba.banquetes.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "AutenticacionServlet", urlPatterns = {"/autenticacion"})
public class AutenticacionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Revisar si el usuario ya tiene una sesion iniciada
        HttpSession sesion = request.getSession(false);
        Object tipoUsuario = sesion != null ? sesion.getAttribute("tipo_usuario") : null;

        String urlRedireccion = null;

        if (tipoUsuario != null) {
            // Redirigir dependiendo tipo de usuario
            switch ((String) tipoUsuario) {
                case "admin":
                    urlRedireccion = "/panel-administrador";
                    break;
                case "empleado":
                    urlRedireccion = "/panel-empleado";
                    break;
                case "cliente":
                    urlRedireccion = "/";
                    break;
            }

            if (urlRedireccion != null) {
                response.sendRedirect(request.getContextPath() + urlRedireccion);
                return;
            }
        }

        // Enviar contexto a plantilla JSP
        request.getRequestDispatcher("/autenticacion.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los campos del cuerpo de la peticion
        Map<String, String[]> cuerpoPeticion = request.getParameterMap();

        String correo = cuerpoPeticion.get("correo")[0];
        // String clave = cuerpoPeticion.get("clave")[0];

        String urlRedireccion = "/";
        String tipoUsuario;
        String nombre;

        // Redirigir basado en tipo de usuario
        if (correo.startsWith("admin")) {
            nombre = "Administrador";
            tipoUsuario = "admin";
            urlRedireccion = "/panel-administrador";
        } else if (correo.startsWith("empleado")) {
            nombre = "Empleado";
            tipoUsuario = "empleado";
            urlRedireccion = "/panel-empleado";
        } else if (correo.startsWith("cliente")) {
            nombre = "Cliente";
            tipoUsuario = "cliente";
        } else { // En caso de que el usuario no coincida, mostrar mensaje de error
            request.setAttribute("tieneError", true);
            request.setAttribute("mensajeError", "Usuario no encontrado");

            request.getRequestDispatcher("/autenticacion.jsp").forward(request, response);
            return;
        }

        // Crear una sesion para el usuario autorizado
        HttpSession sesion = request.getSession();
        sesion.setAttribute("nombre", nombre);
        sesion.setAttribute("tipo_usuario", tipoUsuario);

        String redireccion = request.getParameter("redireccion");

        if (redireccion != null || !redireccion.isEmpty()) {
            response.sendRedirect(redireccion);
        } else {
            // Redirigir al controlador de la ruta
            response.sendRedirect(request.getContextPath() + urlRedireccion);
        }
    }
}
