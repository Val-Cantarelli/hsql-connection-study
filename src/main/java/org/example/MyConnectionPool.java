package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class MyConnectionPool {

    // 2 in 1: List of conns and queue
    private BlockingDeque<Connection> pool;
    private final String url;
    private final String user;
    private final String password;

    // Constructor to any db
    public MyConnectionPool (int size, String url,String user, String password){

        this.url = url;
        this.user = user;
        this.password = password;
        this.pool = new LinkedBlockingDeque<>(size);


        for (int i = 0; i != size ; i++) {
            Connection conn = null;
            try {
                conn = DriverManager.getConnection(this.url, this.user, this.password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            this.pool.add(conn);
        }
    }

    // How to take a connectio
    public Connection acquireConnection(){
        try{
            return pool.take();

        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Fila de conexões interrompida", e);
        }



    }
    //public void releaseConnection(Connection conn) {}

    // how to retrieve a connection




    public static void main(String[] args) {
        MyConnectionPool meuPool = new MyConnectionPool(3, "jdbc:hsqldb:mem:testdb", "sa", "");
        System.out.println("Pool created successfully! Connections: " + meuPool.pool.size());
    }
}
