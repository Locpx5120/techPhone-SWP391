/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.User;

/**
 *
 * @author ThinkPro
 */
public class UserDAO extends context.DBContext {

    Connection connection = null;
    DBContext dBContext = new DBContext();

    public User login(String email, String passWord) {
       
        try {
            connection = dBContext.openConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT * FROM Users WHERE email = ?  AND password = ? AND active = 1";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, passWord);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setPassword(rs.getString("password"));
                user.setFullName(rs.getString("fullName"));
                user.setAvatar(rs.getString("avatar"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setRole(rs.getInt("roleid"));
                user.setActive(rs.getInt("active"));

                return user;
            }
        } catch (SQLException e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                dBContext.closeConnection(connection);
            } catch (SQLException e) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;
    }
   public boolean registerUser(User user) {
        boolean isSuccess = false;
          try {
            connection = dBContext.openConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String query = "INSERT INTO users (fullName, email, phone, address, password, roleid) VALUES (?, ?, ?, ?, ?, 4)";

        try (
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPhone());
            preparedStatement.setString(4, user.getAddress());
            preparedStatement.setString(5, user.getPassword());

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                isSuccess = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
//
//    public int changePassword(int id, String newPassword) {
//        int numberOfChange = 0;
//        try {
//            connection = dBContext.openConnection();
//        } catch (SQLException | ClassNotFoundException ex) {
//            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        String sql = "UPDATE Users SET password = ? WHERE userId = ?";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setString(1, newPassword);
//            st.setInt(2, id);
//            numberOfChange = st.executeUpdate();
//        } catch (SQLException e) {
//            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
//        } finally {
//            try {
//                dBContext.closeConnection(connection);
//            } catch (SQLException e) {
//            }
//        }
//        return numberOfChange;
//    }
//
//    public void updateProfile(User user) {
//        try {
//            connection = dBContext.openConnection();
//        } catch (SQLException | ClassNotFoundException ex) {
//            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        String sql = "UPDATE Users SET fullName = ?, avatar = ?, phone = ?, "
//                + "email = ?, address = ? WHERE userId = ?";
//
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setString(1, user.getFullName());
//            int count = 1;
//            st.setString(++count, user.getAvatar());
//            st.setString(++count, user.getPhone());
//            st.setString(++count, user.getEmail());
//            st.setString(++count, user.getAddress());
//            st.setInt(++count, user.getUserId());
//            st.executeUpdate();
//        } catch (SQLException e) {
//            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
//        } finally {
//            try {
//                dBContext.closeConnection(connection);
//            } catch (SQLException e) {
//                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
//            }
//        }
//
//    }
//
    public int SaveUser(String action, User user) {
        int numberOfChange = 0;
        PreparedStatement st = null;
        try {
            connection = dBContext.openConnection();
            String sql;

            if (action.equals("add")) {
                sql = "INSERT INTO Users(fullName, phone, address, password, email, roleid, active) VALUES(?, ?, ?, ?, ?, ?, ?);";
                st = connection.prepareStatement(sql);
                int count = 0;
                st.setString(++count, user.getFullName());
                st.setString(++count, user.getPhone());
                st.setString(++count, user.getAddress());
                st.setString(++count, user.getPassword());  // Thêm password
                st.setString(++count, user.getEmail());
                st.setInt(++count, user.getRole());  // Thêm role
                st.setInt(++count, user.isActive());  // Thêm trạng thái active
            } else {
                sql = "UPDATE Users SET fullName = ?, phone = ?, address = ?, email = ? WHERE userId = ?";
                st = connection.prepareStatement(sql);
                int count = 0;
                st.setString(++count, user.getFullName());
                st.setString(++count, user.getPhone());
                st.setString(++count, user.getAddress());
                st.setString(++count, user.getEmail());
                st.setInt(++count, user.getUserId());  // Thêm userId khi update
            }

            numberOfChange = st.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (st != null) st.close();
                dBContext.closeConnection(connection);
            } catch (SQLException e) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return numberOfChange;
    }

    public User checkExist(String column, String value, int userId) {
        User user = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = dBContext.openConnection();
            String sql = userId == -1
                    ? String.format("SELECT * FROM Users WHERE %s = ?", column)
                    : String.format("SELECT * FROM Users WHERE %s = ? AND userId <> ?", column);

            ps = connection.prepareStatement(sql);
            ps.setString(1, value);
            if (userId != -1) {
                ps.setInt(2, userId);
            }

            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setPassword(rs.getString("password"));
                user.setFullName(rs.getString("fullName"));
                user.setAvatar(rs.getString("avatar"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setRole(rs.getInt("roleid"));
                user.setActive(rs.getInt("active"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                dBContext.closeConnection(connection);
            } catch (SQLException e) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return user;
    }
    
    
//    public int DeleteUser(int userId) {
//        int numberOfChange = 0;
//        try {
//            connection = dBContext.openConnection();
//        } catch (SQLException | ClassNotFoundException ex) {
//            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        String sql = "UPDATE Users SET active = 0 WHERE userId = ?";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setInt(1, userId);
//            numberOfChange = st.executeUpdate();
//        } catch (SQLException e) {
//            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
//        } finally {
//            try {
//                dBContext.closeConnection(connection);
//            } catch (SQLException e) {
//            }
//        }
//        return numberOfChange;
//    }
//
//    public User getUserById(int userId) {
//        User user = null;
//        try {
//            connection = dBContext.openConnection();
//            String sql = "SELECT * FROM Users WHERE userId = ?";
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setInt(1, userId);
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                user = new User();
//                user.setUserId(rs.getInt("userId"));
//                user.setPassword(rs.getString("password"));
//                user.setFullName(rs.getString("fullName"));
//                user.setAvatar(rs.getString("avatar"));
//                user.setPhone(rs.getString("phone"));
//                user.setEmail(rs.getString("email"));
//                user.setAddress(rs.getString("address"));
////                user.setRole(rs.getString("role"));
////                user.setActive(rs.getBoolean("active"));
//            }
//        } catch (SQLException | ClassNotFoundException ex) {
//            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                dBContext.closeConnection(connection);
//            } catch (SQLException e) {
//                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
//            }
//        }
//        return user;
//    }
//
   

//    public int CountCustomer() {
//        try {
//            connection = dBContext.openConnection();
//
//        } catch (SQLException | ClassNotFoundException ex) {
//            Logger.getLogger(UserDAO.class
//                    .getName()).log(Level.SEVERE, null, ex);
//        }
//        int value = 0;
//        String sql = "select count(*) from Users where role = 'user' ";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                value = rs.getInt(1);
//
//            }
//        } catch (SQLException e) {
//            Logger.getLogger(UserDAO.class
//                    .getName()).log(Level.SEVERE, null, e);
//        } finally {
//            try {
//                dBContext.closeConnection(connection);
//            } catch (SQLException e) {
//            }
//        }
//        return value;
//    }
//
//    public List<User> getUsers() {
//        List<User> list = new ArrayList();
//        try {
//            connection = dBContext.openConnection();
//        } catch (SQLException | ClassNotFoundException ex) {
//            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        String sql = "SELECT * FROM Users where role <> 'admin'";
//        try {
//            PreparedStatement ps = connection.prepareStatement(sql);
//
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                User user = new User();
//                user.setUserId(rs.getInt("userId"));
//                user.setPassword(rs.getString("password"));
//                user.setFullName(rs.getString("fullName"));
//                user.setAvatar(rs.getString("avatar"));
//                user.setPhone(rs.getString("phone"));
//                user.setEmail(rs.getString("email"));
//                user.setAddress(rs.getString("address"));
//                user.setRole(rs.getString("role"));
//                user.setActive(rs.getBoolean("active"));
//
//                list.add(user);
//            }
//        } catch (SQLException e) {
//            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
//        } finally {
//            try {
//                dBContext.closeConnection(connection);
//            } catch (SQLException e) {
//                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
//            }
//        }
//        return list;
//    }
//
//    public User getUserByEmail(String uid, String email) {
//        try {
//            connection = dBContext.openConnection();
//        } catch (SQLException | ClassNotFoundException ex) {
//            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        String sql = "SELECT * FROM Users where email = ? ";
//        if (!uid.isEmpty()) {
//            sql += " and userId <> ?";
//        }
//        try {
//            PreparedStatement ps = connection.prepareStatement(sql);
//            int count = 0;
//            ps.setString(++count, email);
//            if (!uid.isEmpty()) {
//                ps.setInt(++count, Integer.parseInt(uid));
//            }
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                User user = new User();
//                user.setUserId(rs.getInt("userId"));
//                user.setPassword(rs.getString("password"));
//                user.setFullName(rs.getString("fullName"));
//                user.setAvatar(rs.getString("avatar"));
//                user.setPhone(rs.getString("phone"));
//                user.setEmail(rs.getString("email"));
//                user.setAddress(rs.getString("address"));
//                user.setRole(rs.getString("role"));
//                user.setActive(rs.getBoolean("active"));
//                return user;
//            }
//        } catch (SQLException e) {
//            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
//        } finally {
//            try {
//                dBContext.closeConnection(connection);
//            } catch (SQLException e) {
//                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
//            }
//        }
//        return null;
//    }
//
//    public User getUserByPhone(String uid, String phone) {
//        try {
//            connection = dBContext.openConnection();
//        } catch (SQLException | ClassNotFoundException ex) {
//            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        String sql = "SELECT * FROM Users where phone = ? ";
//        if (!uid.isEmpty()) {
//            sql += " and userId <> ?";
//        }
//        try {
//            PreparedStatement ps = connection.prepareStatement(sql);
//            int count = 0;
//            ps.setString(++count, phone);
//            if (!uid.isEmpty()) {
//                ps.setInt(++count, Integer.parseInt(uid));
//            }
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                User user = new User();
//                user.setUserId(rs.getInt("userId"));
//                user.setPassword(rs.getString("password"));
//                user.setFullName(rs.getString("fullName"));
//                user.setAvatar(rs.getString("avatar"));
//                user.setPhone(rs.getString("phone"));
//                user.setEmail(rs.getString("email"));
//                user.setAddress(rs.getString("address"));
//                user.setRole(rs.getString("role"));
//                user.setActive(rs.getBoolean("active"));
//                return user;
//            }
//        } catch (SQLException e) {
//            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
//        } finally {
//            try {
//                dBContext.closeConnection(connection);
//            } catch (SQLException e) {
//                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
//            }
//        }
//        return null;
//    }
//
//    public void updateUser(User user) {
//        try {
//            connection = dBContext.openConnection();
//        } catch (SQLException | ClassNotFoundException ex) {
//            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        String sql = "Update Users set email=?, phone=?,fullName = ?, address = ?, role = ?, active =?"
//                + " where userId = ?";
//        try {
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setString(1, user.getEmail());
//            ps.setString(2, user.getPhone());
//            ps.setString(3, user.getFullName());
//            ps.setString(4, user.getAddress());
//            ps.setString(5, user.getRole());
//            ps.setBoolean(6, user.isActive());
//            ps.setInt(7, user.getUserId());
//            ps.executeUpdate();
//
//        } catch (SQLException e) {
//            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
//        } finally {
//            try {
//                dBContext.closeConnection(connection);
//            } catch (SQLException e) {
//                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
//            }
//        }
//    }
//
//    public void insertUser(User user) {
//        try {
//            connection = dBContext.openConnection();
//        } catch (SQLException | ClassNotFoundException ex) {
//            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        String sql = "Insert into Users (email, phone,fullName,address, role, active) values (?,?,?,?,?,?)";
//        try {
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setString(1, user.getEmail());
//            ps.setString(2, user.getPhone());
//            ps.setString(3, user.getFullName());
//            ps.setString(4, user.getAddress());
//            ps.setString(5, user.getRole());
//            ps.setBoolean(6, true);
//            ps.executeUpdate();
//
//        } catch (SQLException e) {
//            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
//        } finally {
//            try {
//                dBContext.closeConnection(connection);
//            } catch (SQLException e) {
//                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
//            }
//        }
//    }

}
