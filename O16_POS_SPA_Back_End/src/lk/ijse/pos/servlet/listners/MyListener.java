package lk.ijse.pos.servlet.listners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Context was created");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
