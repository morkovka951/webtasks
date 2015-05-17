package controllers;

import entity.Discipline;
import services.DisciplineServise;
import services.impl.DisciplineServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Skenalard on 21.04.2015.
 */
public class DisciplineListController extends AbstractWebtasksServletHandler {

    @Override
    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DisciplineServise disciplineServise = new DisciplineServiceImpl();
        List<Discipline> disciplineList = disciplineServise.getDisciplines();
        request.setAttribute("disciplines", disciplineList);
        gotoToJSP("/main/discipline/disciplinesList.jsp", request, response);
    }


}
