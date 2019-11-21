package net.canway.servlet;

import jdk.nashorn.internal.scripts.JD;
import net.canway.BaseServlet;
import net.canway.entity.Room;
import net.canway.utils.JDBCConnection;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

public class RoomController {

    public void getRooms(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        Enumeration<String> parameterNames = request.getParameterNames();
        Connection connection = null;
        List<Room> list = new ArrayList<>();
        try {
            connection = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from T_ROOM");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                String roomNum = resultSet.getString(2);
                String type = resultSet.getString(3);
                String status = resultSet.getString(4);
                long customId = resultSet.getLong(5);
                Room room = new Room(id, roomNum, type, status, null, customId);
                list.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCConnection.close(connection);
        }

        response.getWriter().write(list.toString());
    }

    public void addRoom(HttpServletRequest request, HttpServletResponse response) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Enumeration<String> parameterNames = request.getParameterNames();
        Room room = new Room();
        Class<? extends Room> clazz = room.getClass();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            String value = request.getParameter(name);
            Method method = Arrays.stream(clazz.getDeclaredMethods())
                    .filter(it -> it.getName().equals(this.buildGetterMethod(name)))
                    .findFirst()
                    .orElseThrow(RuntimeException::new);
            method.invoke(room, value);
        }

        Connection connection = null;
        try {
            connection = JDBCConnection.getConnection();
            connection.setAutoCommit(true);
            String sql = "insert into T_ROOM(ROOM_NUM, TYPE, STATUS) values('"+room.getRoomNum()+"', '"+room.getType()+"', '"+room.getStatus()+"')";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCConnection.close(connection);
        }


    }

    private String buildGetterMethod(String fieldName) {
        String firstLetter = fieldName.substring(0, 1).toUpperCase();
        String suffix = fieldName.substring(1);
        return "set" + firstLetter + suffix;
    }
}
