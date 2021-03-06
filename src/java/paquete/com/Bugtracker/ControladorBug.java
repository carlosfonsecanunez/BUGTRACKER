/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package paquete.com.Bugtracker;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author kai
 */
public class ControladorBug extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
     private ModeloBug modeloBug;
    
    @Resource(name="jdbc/BUG")
    private DataSource miPool;
    
    
    @Override
    public void init()throws ServletException{
        super.init();
        
        try{
        modeloBug = new ModeloBug(miPool);
        }catch(Exception e){
            throw new ServletException (e);
        }
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
         String elcomando = request.getParameter("instruccion");
         
        
        if(elcomando==null) elcomando="loguear";
        
        switch(elcomando){/*
            insertar un case con valor "loguear" con  un metodo que compruebe el usuario y la contraseña 
            
            */
             case "loguear" : logUsuario(request,response);
                break;
             case "verificar_user" : verificarUser(request,response);
                break;
             case "registrar_user" : registrarUser(request,response);
                break;
             case "listar" : obtenerBugs(request,response);
                break;
             case "insertar_BBDD" : insertarBugs(request,response);
                break;
             case "cargar" : cargarBug(request,response);
                break;
             case "actualizarBBDD" : actualizar(request,response);
                break;
             case "eliminar" : eliminar(request,response);  
                break;
             //default : obtenerBugs(request,response);
             default : logUsuario(request,response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
             processRequest(request, response);
         } catch (ParseException ex) {
             Logger.getLogger(ControladorBug.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
             processRequest(request, response);
         } catch (ParseException ex) {
             Logger.getLogger(ControladorBug.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void obtenerBugs(HttpServletRequest request, HttpServletResponse response)  {
         List<Bug> bugs;
            
        try  {       
            
            bugs = modeloBug.getBugs();
            
            request.setAttribute("MISBUGS", bugs);
            
            RequestDispatcher miDispatcher = request.getRequestDispatcher("/ListaBugs.jsp");
            
            miDispatcher.forward(request, response);
    }catch(Exception e){
            
            e.printStackTrace();
            
        }
        

    }   

    private void insertarBugs(HttpServletRequest request, HttpServletResponse response) {
        Bug newBug = null;
        String name = request.getParameter("bug_name");
        String type = request.getParameter("type");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        String user = request.getParameter("user");
        //cambiandole el formato a la fecha 
        SimpleDateFormat formatoDate = new SimpleDateFormat ("yyyy-MM-dd");
        
        Date bugFecha = null;
         try {
             
             bugFecha = formatoDate.parse(request.getParameter("init_date"));
             
             
         } catch (ParseException ex) {
             Logger.getLogger(ControladorBug.class.getName()).log(Level.SEVERE, null, ex);
         }
        //Date bugfechaFinal = null;
        if(bugFecha == null){
                 newBug= new Bug(name,type,description,status,user);
                 modeloBug.addNewBug2(newBug);
             }else{
        
        newBug = new Bug(name,type,description,status,user,bugFecha);
        
        modeloBug.addNewBug(newBug);
        }
        
        obtenerBugs(request,response);
    }

    private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        int codibug = Integer.parseInt(request.getParameter("codigo_bug"));
        String name = request.getParameter("bug_name");
        String type = request.getParameter("type");
        String desc = request.getParameter("description");
        String status = request.getParameter("status");
        String user = request.getParameter("user");
        SimpleDateFormat formatdate = new SimpleDateFormat("yyyy-MM-dd");
        
        Date fechaini = formatdate.parse(request.getParameter("inidate"));
        Date fechafi = formatdate.parse(request.getParameter("findate"));
        
        Bug bug = new Bug(codibug,name,type,desc,status,user,fechaini,fechafi);
        
        modeloBug.actualizar(bug);
        
        obtenerBugs(request,response);
        
    }

    private void cargarBug(HttpServletRequest request, HttpServletResponse response) throws ParseException {
       
        int codigo = Integer.parseInt(request.getParameter("codigo_bug"));
        try{
        Bug bug = modeloBug.getBug(codigo);
        request.setAttribute("bugaActualizar", bug);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/actualizarBug.jsp");
              
        dispatcher.forward(request, response);
        }catch(ServletException | IOException e){}
        }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) {
        int codigo =Integer.parseInt(request.getParameter("codigo_bug"));
        modeloBug.eliminar(codigo);
        obtenerBugs(request,response);
    }

    private void logUsuario(HttpServletRequest request, HttpServletResponse response) {
         try {
             RequestDispatcher miDispatcher = request.getRequestDispatcher("/LoginUsuario.jsp");
              
             miDispatcher.forward(request, response);
         } catch (ServletException ex) {
             Logger.getLogger(ControladorBug.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(ControladorBug.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    private void verificarUser(HttpServletRequest request, HttpServletResponse response) {
        String user = request.getParameter("user");
        String passw = request.getParameter("password");
        Usuario userVerify = modeloBug.verificarUser(user,passw);
            if (userVerify != null){
                obtenerBugs(request,response);
            }
            else{
                logUsuario(request,response);
            }
    }

    private void registrarUser(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("name");
        String passWord = request.getParameter("password");
        String passWord2 = request.getParameter("password2");
        int accessType = Integer.parseInt(request.getParameter("access_type"));
        Usuario usr = new Usuario (userName,passWord,accessType);
        Usuario usr2 = null;
        RequestDispatcher miDispatcher = null;
        if (passWord.equals(passWord2)){
            usr2 = modeloBug.registrarUser(usr);
            if (usr2 == null){
                obtenerBugs(request,response);
            }
        }else{
               try {
                    request.setAttribute("usarioNoRegistrado", usr);
                    miDispatcher = request.getRequestDispatcher("/Registrar_usuario.jsp");
                    miDispatcher.forward(request, response);
                } catch (ServletException ex) {
                    Logger.getLogger(ControladorBug.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ControladorBug.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    } 
    
        

    
}
