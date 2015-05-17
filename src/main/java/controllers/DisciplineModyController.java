package controllers;

import entity.Discipline;
import services.DisciplineServise;
import services.impl.DisciplineServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Skenalard on 28.04.2015.
 */
public class DisciplineModyController extends AbstractWebtasksServletHandler {
    @Override
    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(request.getMethod().equals("GET")){
            showPageDisciplineModifying(request, response);
        }else{
            showPageDisciplineList(request, response);
        }

    }
    protected void showPageDisciplineModifying(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //GET
        request.setAttribute("CURRENT_BUTTON", 2);
        String strId = request.getParameter("id");
        if (strId == null){
            forwardRequest("/admin/disciplinesList.php", request, response);
        }
        //Number format Exception
        int id = Integer.valueOf(strId);
        DisciplineServise disciplineServise = new DisciplineServiceImpl();
        Discipline discipline = disciplineServise.getById(id);
        request.setAttribute("discipline", discipline);
        gotoToJSP("/main/discipline/disciplinesCreatingModifying.jsp", request, response);
    }
    protected void showPageDisciplineList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //POST
        //Изменение на модификацтю а не на добавление!!!
        String strName = request.getParameter("name");
        validateRequestDiscipline(strName);
        DisciplineServise disciplineServise = new DisciplineServiceImpl();
        Discipline discipline = new Discipline(strName);
        if (disciplineServise.add(discipline)){
            //gotoToJSP("/main/discipline/disciplinesList.jsp", request, response);
            forwardRequest("/admin/disciplinesList.php", request, response);
        }else{

        }
    }
}
