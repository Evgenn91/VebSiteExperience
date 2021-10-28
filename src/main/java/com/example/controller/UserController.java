package com.example.controller;


import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRegistration;

//здесь используем только сервис можем здесь и сразу обращаться к дао но не
// будем перепрыгивать а изолированность соблюдаем и реализуем в userservice

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    public UserService userService;


    //данные в методе get передаются через url
    //пишем штуку, которая вернет нам всех юзеров из б.д.(видео 55:41)
    @GetMapping("/users")
    public String getAllUsers(Model model){
        model.addAttribute("users",userService.findAll()); //метод вернет нам лист юзеров
        return "usersList";  //название файла визуального(html страницы)
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/user/{id}")
    public String getById(@PathVariable("id") int id, Model model) //тут говорим что id который прийдет в url {id}  использовать в нашем методе под таким именем
    {
        model.addAttribute("user",userService.getById(id));
        return "showUser";
    }

    //это все для добавления юзера
    //для попадания в темплейте(где создается юзер)
    @GetMapping("/addUser")
    public String createUserPage(){
        return "createUser";
    }

    //данные ппередаются в невидимом виде(тоесть не по URL)
    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:/users"; //редиректим назад на всех юзеров
    }


    //теперь удаление
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        userService.delete(id);
        return "redirect:/users";
    }

    //обновление
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model){
        model.addAttribute("user",userService.getById(id));
        return "editUser";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user){
        userService.update(user);
        return "redirect:/user/"+user.getId(); //редиректим назад на всех юзеров
    }

}
