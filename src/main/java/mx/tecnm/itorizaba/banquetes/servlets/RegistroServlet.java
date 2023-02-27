package mx.tecnm.itorizaba.banquetes.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "RegistroServlet", urlPatterns = {"/registro"})
public class RegistroServlet extends HttpServlet {
    
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
                    urlRedireccion = "/panel_administrador";
                    break;
                case "empleado":
                    urlRedireccion = "/panel_empleado";
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
        request.getRequestDispatcher("/registro.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los campos del cuerpo de la peticion
        Map<String, String[]> cuerpoPeticion = request.getParameterMap();

        // Mostrar cuerpo en consola
        for (Map.Entry<String, String[]> campo : cuerpoPeticion.entrySet()) {
            String nombreCampo = campo.getKey();
            String[] valoresCampo = campo.getValue();
            for (String valorCampo : valoresCampo) {
                System.out.println("Parametro: " + nombreCampo + " = " + valorCampo);
            }
        }
        
        // Redirigir al controlador de autenticacion
        request.setAttribute("tieneExito", true);
        request.getRequestDispatcher("/registro.jsp").forward(request, response);
    }
}
