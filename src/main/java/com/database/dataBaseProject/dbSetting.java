package com.database.dataBaseProject;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@ConfigurationProperties("db")
@Configuration
public class dbSetting {
    private String connection;
    private String host;
    private int port;

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        dbSetting dbSetting = (dbSetting) o;
        return port == dbSetting.port && Objects.equals(connection, dbSetting.connection) && Objects.equals(host, dbSetting.host);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connection, host, port);
    }

    @Override
    public String toString() {
        return "dbSetting{" +
                "connection='" + connection + '\'' +
                ", host='" + host + '\'' +
                ", port=" + port +
                '}';
    }
}
