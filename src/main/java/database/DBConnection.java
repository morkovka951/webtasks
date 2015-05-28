package database;

import entity.Account;
import entity.Discipline;
import entity.Role;
import entity.Student;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DBConnection {
    private static final Logger LOGGER = Logger.getLogger(DBConnection.class);
    private Connection conn = null;
    private ResultSet rs = null;

    private static PreparedStatement loadAllRoles;
    private static PreparedStatement loadAllLogins;
    private static PreparedStatement loadAccountByLogin;
    private static PreparedStatement loadRolesById;
    private static PreparedStatement getIdAccountRoles;

    //PreparedStatement for Discipline
    private static PreparedStatement getListDisciplines;
    private static PreparedStatement deleteDisciplinesById;
    private static PreparedStatement insetrDisciplines;
    private static PreparedStatement selectDisciplinesById;

    //PreparedStatement for Students
    private static PreparedStatement getListStudents;

    public DBConnection(String url, String user, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            loadPreparedStatements();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            LOGGER.error("ClassNotFoundException - > DBConnection(String url); " + e);
        }
    }



    private void loadPreparedStatements() {
        try {
            loadAllRoles = conn.prepareStatement("SELECT * FROM roles");
            loadAllLogins = conn.prepareStatement("SELECT login, id FROM account");
            loadAccountByLogin = conn.prepareStatement("SELECT * FROM account WHERE login = ?");
            loadRolesById = conn.prepareStatement("SELECT * FROM account_roles WHERE id =?");
            getIdAccountRoles = conn.prepareStatement("SELECT id_roles FROM account_roles WHERE id_account = ?");
            getListDisciplines = conn.prepareStatement("SELECT * FROM disciplines");
            deleteDisciplinesById = conn.prepareStatement("DELETE FROM disciplines WHERE id = ?");
            insetrDisciplines = conn.prepareStatement("INSERT INTO disciplines (name) VALUES (?)");
            selectDisciplinesById = conn.prepareStatement("SELECT * FROM disciplines WHERE id = ?");
            getListStudents = conn.prepareStatement("SELECT * FROM students");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void closePreparedStatements() {
        try {
            loadAllRoles.close();
            loadAllLogins.close();
            loadAccountByLogin.close();
            loadRolesById.close();
            getIdAccountRoles.close();
            getListDisciplines.close();
            deleteDisciplinesById.close();
            insetrDisciplines.close();
            selectDisciplinesById.close();
            getListStudents.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public List<Role> getAllRoles() {
        rs = null;
        List<Role> result = new LinkedList<Role>();
        try {
            rs = loadAllRoles.executeQuery();
            while (rs.next()) {
                Role r = new Role();
                r.setId(rs.getInt("id"));
                r.setName(rs.getString("name_roles"));
                result.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;

    }

    public List<Account> getAllLogins() {
        rs = null;
        List<Account> result = new LinkedList<Account>();
        try {
            rs = loadAllLogins.executeQuery();

            while (rs.next()) {
                Account account = new Account();
                account.setUsername(rs.getString("login"));
                account.setId(rs.getInt("id"));
                //account.setPassword(rs.getString("password"));
                result.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    public Account getAccountByLogin(String login) {
        rs = null;
        // SELECT * FROM account WHERE login = ?
        Account result = new Account();
        try {
            loadAccountByLogin.setNString(1, login);
            rs = loadAccountByLogin.executeQuery();

            while (rs.next()) {
                result.setId(rs.getInt("id"));
                result.setUsername(rs.getString("login"));
                result.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    public List<Role> getRolesById(int id) {
        rs = null;
        List<Role> result = new LinkedList<Role>();
        try {
            //SELECT * FROM account_role WHERE id =?
            loadRolesById.setInt(1, id);
            rs = loadRolesById.executeQuery();
            while (rs.next()) {
                Role role = new Role();
                role.setId(rs.getInt("id_account"));
                role.setName(rs.getString("id_roles"));
                result.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    public void close() {
        closePreparedStatements();
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            LOGGER.info("close() exeption " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Integer> getIdAccountRoles(int idAccount) {
        rs = null;
        List<Integer> idAccountRoles = new ArrayList<Integer>();
        try {
            getIdAccountRoles.setInt(1, idAccount);
            rs = getIdAccountRoles.executeQuery();

            while (rs.next()) {
                idAccountRoles.add(rs.getInt("id_roles"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idAccountRoles;
    }

    //For Discipline
    public List<Discipline> getListDisciplines() {

        // SELECT * FROM disciplines
        rs = null;
        List<Discipline> result = new LinkedList<Discipline>();
        try {
            rs = getListDisciplines.executeQuery();
            while (rs.next()) {
                Discipline r = new Discipline();
                r.setId(rs.getInt("id"));
                r.setName(rs.getString("name"));
                result.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    //Detete Disciplines
    public int deleteDisciplinesById(int id) {
        int resultDelete = 1;
        try {
            //DELETE * FROM account_role WHERE id =?
            deleteDisciplinesById.setInt(1, id);
            resultDelete= deleteDisciplinesById.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultDelete;
    }

    //insetrDisciplines = conn.prepareStatement("INSERT INTO disciplines (name) VALUES (?)");
    public int insetrDisciplines(Discipline discipline) {
        try {
            insetrDisciplines.setString(1, discipline.getName());
        return insetrDisciplines.executeUpdate();
        } catch (SQLException e) {
            LOGGER.debug("insetrDisciplines - SQLException");
            return -1;
        }

    }

    //selectDisciplinesById = conn.prepareStatement("SELECT * FROM disciplines WHERE id = ?");
    public Discipline selectDisciplinesById(int id) {
        rs = null;
        // SELECT * FROM disciplines WHERE id = ?
        Discipline result = new Discipline();
        try {
            selectDisciplinesById.setInt(1, id);
            rs = selectDisciplinesById.executeQuery();
            while (rs.next()) {
                result.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }
    //For Students
    public List<Student> getListStudents() {

        // SELECT * FROM students
        rs = null;
        List<Student> result = new LinkedList<Student>();
        try {
            rs = getListStudents.executeQuery();
            while (rs.next()) {
                Student r = new Student();
                r.setId(rs.getInt("id"));
                r.setName(rs.getString("name"));
                r.setLast_name(rs.getString("last_name"));
                r.setDate(rs.getTimestamp("date"));
                r.setGroup(rs.getString("groupe"));
                result.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
