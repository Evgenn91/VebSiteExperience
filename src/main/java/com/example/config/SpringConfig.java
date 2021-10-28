package com.example.config;


import com.example.dao.UserDao;
import com.example.dao.UserDaoImpl;
import com.example.service.UserService;
import com.example.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

//когда приложение будет стартовать то все бины описанные в этом классе, будут созданы в нашем контексте приложения
@Configuration
public class SpringConfig {


    //это основная фишка спринга
    //это синглтон и его мы можем ипользовать где захотим в нашем приложении
    //так мы будем обьявлеть наши сервисы и наши дао


    @Bean
    public JdbcTemplate getJdbcTemplate(){
            return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/vebinar?useSLL=false&serverTimezone=Europe/Moscow");
        dataSource.setUsername("root");
        dataSource.setPassword("roottt");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return dataSource;
    }

    @Bean
    public UserDao getUserDao(){
        return new UserDaoImpl(getJdbcTemplate());
    }

    @Bean
    public UserService getUserService(){
        return new UserServiceImpl();
    }

}
