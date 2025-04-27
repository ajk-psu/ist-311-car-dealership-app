package models;

import java.sql.*;

public class VehicleModel {

    Connection connection;

    public VehicleModel(Connection connection)
    {
        if (connection != null)
            this.connection = connection;
    }
}
