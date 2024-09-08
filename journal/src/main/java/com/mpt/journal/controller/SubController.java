package com.mpt.journal.controller;

import com.mpt.journal.model.SubModel;
import com.mpt.journal.service.SubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SubController {
    @Autowired
    private SubService subService;

    @GetMapping("/subs")
    public String getAllJobs(Model model) {
        model.addAttribute("subs", subService.findAllSub()); // просто выгрузка студентов на экран
        return "subList";
    }

    @PostMapping("/subs/add")
    public String addSub(@RequestParam String name) {
        SubModel newSub = new SubModel(0, name); // тут мы получаем данные с главных полей, id задается автоматически из нашего репозитория
        subService.addSub(newSub); // добавление студента в оперативную память(после перезапуска проекта, все данные стираются)
        return "redirect:/subs"; // Здесь мы с вами используем redirect на наш GetMapping, чтобы не создавать много однотипных страниц, считай просто презагружаем страницу с новыми данными
    }

    @PostMapping("/subs/update")
    public String updateSub(@RequestParam int id,
                            @RequestParam String name) {
        SubModel updatedSub = new SubModel(id, name); // Получаем новые данные из полей для обновления
        subService.updateSub(updatedSub); // Ссылаемся на наш сервис для обновления по id
        return "redirect:/subs"; // Здесь мы с вами используем redirect на наш GetMapping, чтобы не создавать много однотипных страниц, считай просто презагружаем страницу с новыми данными
    }

    @PostMapping("/subs/delete")
    public String deleteSubs(@RequestParam int id) {
        subService.deleteSub(id); // Ссылаемся на наш сервис для удаления по id
        return "redirect:/subs"; // Здесь мы с вами используем redirect на наш GetMapping, чтобы не создавать много однотипных страниц, считай просто презагружаем страницу с новыми данными
    }
}
